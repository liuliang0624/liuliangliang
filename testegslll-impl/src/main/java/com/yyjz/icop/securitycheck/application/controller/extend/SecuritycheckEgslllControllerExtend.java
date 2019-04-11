package com.yyjz.icop.securitycheck.application.controller.extend;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import com.yyjz.icop.securitycheck.application.controller.SecuritycheckEgslllController;
import com.yyjz.icop.securitycheck.application.service.extend.SecuritycheckEgslllQueryServiceExtend;
import com.yyjz.icop.securitycheck.application.service.extend.SecuritycheckEgslllServiceExtend;
import com.yyjz.icop.securitycheck.application.vo.SecuritycheckEgslllVO;
import com.yyjz.icop.pubapp.platform.print.PrintAttributeConvert;
import com.yyjz.icop.pubapp.platform.print.PrintUtil;
import com.yyjz.icop.excel.ExportExcelUtils;
import com.yyjz.icop.pubapp.platform.export.ExportConvertUtil;
import com.yyjz.icop.pubapp.platform.export.ExportDataConvert;
import com.yyjz.icop.pubapp.platform.export.ExportDataScope;
import com.yyjz.icop.pubapp.platform.export.ExportParams;
import com.yyjz.icop.pubapp.platform.query.QuerySchema;
import com.yyjz.icop.metadata.core.data.JsonBackData;
import com.yyjz.icop.exception.BusinessException;
import com.alibaba.fastjson.JSONObject;

/**
 * <p>前台交互rest服务扩展</p>
 * <p>@author ICOP  2019-04-09</p>
 * <p>请在该类中添加自定义实现，以扩展功能</p>
 */
@Controller
@RequestMapping(value = "securitycheckEgslll")
public class SecuritycheckEgslllControllerExtend extends SecuritycheckEgslllController{

	@Autowired
	protected SecuritycheckEgslllServiceExtend securitycheckEgslllServiceExtend;

	@Autowired
	protected SecuritycheckEgslllQueryServiceExtend securitycheckEgslllQueryServiceExtend;
	
	
	@RequestMapping(value = "print", method = RequestMethod.GET)
	@ResponseBody
	public JsonBackData queryPrint(@RequestParam String id) {
		JsonBackData back = new JsonBackData();
		try {
			SecuritycheckEgslllVO vo = securitycheckEgslllQueryService.findById(id);
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
	public void exportExcel(HttpServletResponse response, @RequestBody ExportParams<SecuritycheckEgslllVO> params) {
		List<SecuritycheckEgslllVO> dataList = null;
		try {
			if (ExportDataScope.ALL.name().equalsIgnoreCase(params.getScope())) {
				QuerySchema queryScheme = params.getQueryScheme();
				if (queryScheme != null) {
					// 根据查询方案查询所有数据
					queryScheme.setPageNumber(0);
					queryScheme.setPageSize(ExportParams.maxExportSize);
					Page<SecuritycheckEgslllVO> page = securitycheckEgslllQueryServiceExtend.showList(queryScheme);
					dataList = page.getContent();
				} else {
					dataList = Collections.emptyList();
				}
			} else {
				// 前端传递页面数据
				dataList = params.getData();
			}
			// 数据转换
			dataList = ExportConvertUtil.convertDatas(dataList, new ExportDataConvert<SecuritycheckEgslllVO>() {
				@Override
				public void convert(SecuritycheckEgslllVO vo) {
					// 自定义数据转换
				}
			});
		} catch (BusinessException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		if (params.getUseTemplate()) { // 使用模板
			String templatePath = this.getClass().getResource("../../").getPath() + "template/text.xlsx"; // 模板路径
			ExportExcelUtils.exportWithTemplete(response, params.getFileName(), templatePath, 4, 0, dataList,
					SecuritycheckEgslllVO.class);
		} else { // 不使用模板
			ExportExcelUtils.export(response, params.getFileName(), params.getTitle(), dataList, SecuritycheckEgslllVO.class);
		}
	}
}
