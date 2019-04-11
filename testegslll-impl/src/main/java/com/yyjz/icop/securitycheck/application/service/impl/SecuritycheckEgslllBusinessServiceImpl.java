package com.yyjz.icop.securitycheck.application.service.impl;

import org.springframework.stereotype.Service;

import com.yyjz.icop.application.approval.IBusinessService;

import com.yyjz.icop.database.entity.SuperEntity;
import com.yyjz.icop.securitycheck.application.entity.SecuritycheckEgslllEntity;
import com.yyjz.icop.pubapp.platform.util.JsonBackData;

/**
 * <p>审批回调服务</p>
 * <p>@author ICOP</p>
 * <p>注意：请不要修改该文件中的代码，或者在该文件中添加自定义实现，每次执行“生成代码”都会导致任何对该文件的修改丢失！</p>
 */
@Service(value="securitycheckEgslllEvent")
public class SecuritycheckEgslllBusinessServiceImpl implements IBusinessService {

	@Override
	public String getBillType() {
		return "demoegslll";
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends SuperEntity> Class<T> getMainEntityClass() {
		return (Class<T>) SecuritycheckEgslllEntity.class;
	}

	@Override
	public JsonBackData afterApprovalProcessor(String billId, Integer state) {
		return null;
	}

}
