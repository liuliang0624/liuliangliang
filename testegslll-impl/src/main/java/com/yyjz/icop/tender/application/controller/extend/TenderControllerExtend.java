package com.yyjz.icop.tender.application.controller.extend;

import com.alibaba.fastjson.JSONObject;
import com.yyjz.icop.base.response.RefPagableResponse;
import com.yyjz.icop.base.response.ReturnCode;
import com.yyjz.icop.database.repository.EntityJdbcPageQuery;
import com.yyjz.icop.database.repository.EntityJdbcQuery;
import com.yyjz.icop.excel.ExportExcelUtils;
import com.yyjz.icop.exception.BusinessException;
import com.yyjz.icop.metadata.core.data.JsonBackData;
import com.yyjz.icop.pubapp.platform.export.ExportConvertUtil;
import com.yyjz.icop.pubapp.platform.export.ExportDataConvert;
import com.yyjz.icop.pubapp.platform.export.ExportDataScope;
import com.yyjz.icop.pubapp.platform.export.ExportParams;
import com.yyjz.icop.pubapp.platform.print.PrintAttributeConvert;
import com.yyjz.icop.pubapp.platform.print.PrintUtil;
import com.yyjz.icop.pubapp.platform.query.Compare;
import com.yyjz.icop.pubapp.platform.query.FieldType;
import com.yyjz.icop.pubapp.platform.query.QuerySchema;
import com.yyjz.icop.pubapp.platform.query.SearchItem;
import com.yyjz.icop.pubapp.platform.query.util.QueryFieldResult;
import com.yyjz.icop.pubapp.platform.query.util.QuerySchemaTools;
import com.yyjz.icop.pubapp.platform.util.DataObjectUtils;
import com.yyjz.icop.tender.application.controller.TenderController;
import com.yyjz.icop.tender.application.entity.TenderDetailsEntity;
import com.yyjz.icop.tender.application.entity.TenderEntity;
import com.yyjz.icop.tender.application.service.extend.TenderQueryServiceExtend;
import com.yyjz.icop.tender.application.service.extend.TenderServiceExtend;
import com.yyjz.icop.tender.application.vo.TenderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>前台交互rest服务扩展</p>
 * <p>@author ICOP  2019-04-09</p>
 * <p>请在该类中添加自定义实现，以扩展功能</p>
 */
@Controller
@RequestMapping(value = "tender")
public class TenderControllerExtend extends TenderController{

	@Autowired
	protected TenderServiceExtend tenderServiceExtend;

	@Autowired
	protected TenderQueryServiceExtend tenderQueryServiceExtend;
//我的代码
	@Autowired
	private EntityJdbcPageQuery pageQuery;//一次查询只能查主表
	@Autowired
	private EntityJdbcQuery entityJdbcQuery;
	@RequestMapping(value = "print", method = RequestMethod.GET)
	//我的代码
	@ResponseBody
	public JsonBackData queryPrint(@RequestParam String id) {
		JsonBackData back = new JsonBackData();
		try {
			TenderVO vo = tenderQueryService.findById(id);
			JSONObject json = PrintUtil.convertPrintData(vo, new PrintAttributeConvert() {
				@Override
				public void convert(JSONObject entityJson) {
					// TODO 根据业务需求将某些字段进行转换，例如：sex = true 转换为sex = "男"等。
				}
			});
			back.setBackData(json);
			back.setSuccess(true);
			back.setBackMsg("查询打印数据成功");
		} catch (BusinessException e) {
			back.setSuccess(false);
			back.setBackMsg("查询打印数据失败:" + e.getMessage());
		}
		return back;
	}
	/**
	 * 导出Excel
	 * 
	 * @param response
	 * @param params
	 * @return
	 */
	@RequestMapping("/export")
	@ResponseBody
	public void exportExcel(HttpServletResponse response, @RequestBody ExportParams<TenderVO> params) {
		List<TenderVO> dataList = null;
		try {
			if (ExportDataScope.ALL.name().equalsIgnoreCase(params.getScope())) {
				QuerySchema queryScheme = params.getQueryScheme();
				if (queryScheme != null) {
					// 根据查询方案查询所有数据
					queryScheme.setPageNumber(0);
					queryScheme.setPageSize(ExportParams.maxExportSize);
					Page<TenderVO> page = tenderQueryServiceExtend.showList(queryScheme);
					dataList = page.getContent();
				} else {
					dataList = Collections.emptyList();
				}
			} else {
				// 前端传递页面数据
				dataList = params.getData();
			}
			// 数据转换
			dataList = ExportConvertUtil.convertDatas(dataList, new ExportDataConvert<TenderVO>() {
				@Override
				public void convert(TenderVO vo) {
					// 自定义数据转换
				}
			});
		} catch (BusinessException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		if (params.getUseTemplate()) { // 使用模板
			String templatePath = this.getClass().getResource("../../").getPath() + "template/text.xlsx"; // 模板路径
			ExportExcelUtils.exportWithTemplete(response, params.getFileName(), templatePath, 4, 0, dataList,
					TenderVO.class);
		} else { // 不使用模板
			ExportExcelUtils.export(response, params.getFileName(), params.getTitle(), dataList, TenderVO.class);
		}
	}
    //我的代码
	@ResponseBody
	@RequestMapping(value = "ref")
	public RefPagableResponse queryRefList(
			@RequestParam(required = false, value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") Integer pageSize,
			@RequestParam(required = false, value = "searchText") String searchText,
			@RequestParam(required = false) String condition) {
		RefPagableResponse response = new RefPagableResponse(TenderVO.class);

		try {

			// 处理前台传参
			JSONObject obj = JSONObject.parseObject(condition);
			String companyId = null;

			// 设置查询参数
			QuerySchema querySchema = new QuerySchema();
			querySchema.setSearchText(searchText);
			querySchema.setPageNumber(pageNumber - 1);
			querySchema.setPageSize(pageSize);

			// 查找 - 未删除的数据
			List<SearchItem> itemList = new ArrayList<SearchItem>();
			SearchItem busiStateItem = new SearchItem();
			busiStateItem.setField("dr");//过滤查询
			busiStateItem.setCompare(Compare.EQ.name());
			busiStateItem.setFieldtype(FieldType.INTEGER.name());
			busiStateItem.setData(0);
			itemList.add(busiStateItem);

			// 处理检索字段
//            if (StringUtils.isNotEmpty(searchText)) {
//                SearchItem codeItem = new SearchItem();
//                codeItem.setField("tender_plan_no");
//                codeItem.setCompare(Compare.CN.name());
//                codeItem.setFieldtype(FieldType.STRING.name());
//                codeItem.setData(searchText);
//                itemList.add(codeItem);
//            }

			// 去掉检索条件
			querySchema.setCondition(itemList);
			querySchema.setSearchText(null);

			// 设置查询条件
			QueryFieldResult queryFieldResult = QuerySchemaTools.querySchema(querySchema);
			String conditionForQuery = queryFieldResult.getCondition();
			String order = queryFieldResult.getOrder();
			Pageable pageable = new PageRequest(querySchema.getPageNumber(), querySchema.getPageSize());

//            SqlBuilder sql = new SqlBuilder();
//            sql.append(conditionForQuery);
//            // 增加是否流标筛选
//            if (StringUtils.isNotBlank(isTenderFailure)) {
//                sql.append(" AND is_tender_failure ", isTenderFailure);
//            }
//            sql.append(commonService.getAllChildrenCompanyForSql(companyId));
//            sql.append(" AND bill_state=3 ");

			Page<TenderEntity> dataPage = pageQuery.query(TenderEntity.class, pageable,
					"" , null);
			//查询的语句 解析 赋予过去




			List<TenderEntity> list = dataPage.getContent();
			List<TenderVO> vos = new ArrayList<>();
			for (TenderEntity entity : list) {
				String pid = entity.getId();
				StringBuffer sb = new StringBuffer();
				sb.append(" and pid='");
				sb.append(pid);
				sb.append("'");
				List<TenderDetailsEntity> detailEntities = entityJdbcQuery.query(TenderDetailsEntity.class, sb.toString(), null);
				entity.setDetails(detailEntities);
                //注入Entity-VO
				TenderVO vo = new TenderVO();
				DataObjectUtils.copyEntityToVO(entity, vo);
				vos.add(vo);
			}
			Page<TenderVO> page = new PageImpl<>(vos, pageable, dataPage.getTotalElements());
			// 设置返回参数
			response.setCount(page.getTotalElements());
			response.setList(page.getContent());
			response.setPageNumber(pageNumber);
			response.setPageSize(pageSize);
			response.setCode(ReturnCode.SUCCESS);
			response.setMsg("获取信息成功！");
		} catch (Exception e) {
			response.setCode(ReturnCode.FAILURE);
			response.setMsg("获取失败！");
		}
		return response;
	}
	//我的代码

}
