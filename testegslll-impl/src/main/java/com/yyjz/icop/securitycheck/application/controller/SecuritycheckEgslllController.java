package com.yyjz.icop.securitycheck.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yyjz.icop.securitycheck.application.service.ISecuritycheckEgslllQueryService;
import com.yyjz.icop.securitycheck.application.service.ISecuritycheckEgslllService;
import com.yyjz.icop.securitycheck.application.vo.SecuritycheckEgslllVO;
import com.yyjz.icop.exception.BusinessException;
import com.yyjz.icop.metadata.core.data.JsonBackData;
import com.yyjz.icop.pubapp.platform.query.QuerySchema;

/**
 * <p>前台交互rest服务</p>
 * <p>@author ICOP  2019-04-09</p>
 * <p>注意：请不要修改该文件中的代码，或者在该文件中添加自定义实现，每次执行“生成代码”都会导致任何对该文件的修改丢失！
 *     如需要扩展功能或者添加自定义实现，请在SecuritycheckEgslllControllerExtend类中完成。 </p>
 */
@Controller
@RequestMapping(value = "securitycheckEgslll")
public abstract class SecuritycheckEgslllController {
	@Autowired
	protected ISecuritycheckEgslllService securitycheckEgslllService;
	@Autowired
	protected ISecuritycheckEgslllQueryService securitycheckEgslllQueryService;

	/**
	 * 新增保存
	 * 
	 * @param securitycheckEgslllVO
	 * @return
	 */
	@RequestMapping(value = "insert")
	@ResponseBody
	public JsonBackData insert(@RequestBody SecuritycheckEgslllVO securitycheckEgslllVO) {
		JsonBackData back = new JsonBackData();
		try {
			SecuritycheckEgslllVO backVO = securitycheckEgslllService.insert(securitycheckEgslllVO);

			back.setBackData(backVO);
			back.setBackMsg("新增成功");
		} catch (BusinessException e) {
			back.setSuccess(false);
			back.setBackMsg("新增失败:"+e.getMessage());
		}
		return back;

	}

	/**
	 * 修改保存
	 * 
	 * @param securitycheckEgslllVO
	 * @return
	 */
	@RequestMapping(value = "update")
	@ResponseBody
	public JsonBackData update(@RequestBody SecuritycheckEgslllVO securitycheckEgslllVO) {
		JsonBackData back = new JsonBackData();
		try {
			SecuritycheckEgslllVO vo = securitycheckEgslllService.update(securitycheckEgslllVO);
			back.setBackData(vo);
			back.setBackMsg("更新成功");
		} catch (BusinessException e) {
			back.setSuccess(false);
			back.setBackMsg("更新失败:"+e.getMessage());
		}
		return back;
	}

	/**
	 * 删除
	 * 
	 * @param securitycheckEgslllVOs
	 * @return
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonBackData delete(@RequestBody SecuritycheckEgslllVO[] securitycheckEgslllVOs) {
		JsonBackData back = new JsonBackData();
		try {
			securitycheckEgslllService.delete(securitycheckEgslllVOs);
			back.setSuccess(true);
			back.setBackMsg("删除成功");
		} catch (BusinessException e) {
			back.setSuccess(false);
			back.setBackMsg("删除失败:"+e.getMessage());
		}
		return back;
	}

	/**
	 * 查询详细信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "queryDetail")
	@ResponseBody
	public JsonBackData queryDetail(@RequestParam String id) {
		JsonBackData back = new JsonBackData();
		try {
			SecuritycheckEgslllVO vo = securitycheckEgslllQueryService.findById(id);
			back.setBackData(vo);
			back.setSuccess(true);
			back.setBackMsg("查询详细信息成功");
		} catch (BusinessException e) {
			back.setSuccess(false);
			back.setBackMsg("查询详细信息失败:"+e.getMessage());
		}
		return back;
	}

	/**
	 * 查询
	 * 
	 * @param QuerySchema
	 * @return
	 */
	@RequestMapping(value = "queryList")
	@ResponseBody
	public JsonBackData queryList(@RequestBody(required = false) QuerySchema querySchema) {
		JsonBackData back = new JsonBackData();
		try {
			Page<SecuritycheckEgslllVO> page = securitycheckEgslllQueryService.showList(querySchema);
			back.setBackData(page);
			back.setSuccess(true);
			back.setBackMsg("查询列表信息成功");
		} catch (BusinessException e) {
			back.setSuccess(false);
			back.setBackMsg("查询列表信息失败:"+e.getMessage());
		}
		return back;
	}

}
