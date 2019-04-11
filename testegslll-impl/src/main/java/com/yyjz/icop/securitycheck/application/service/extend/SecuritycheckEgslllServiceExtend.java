package com.yyjz.icop.securitycheck.application.service.extend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yyjz.icop.securitycheck.application.activity.extend.SecuritycheckEgslllDeleteActivityExtend;
import com.yyjz.icop.securitycheck.application.activity.extend.SecuritycheckEgslllInsertActivityExtend;
import com.yyjz.icop.securitycheck.application.activity.extend.SecuritycheckEgslllUpdateActivityExtend;
import com.yyjz.icop.securitycheck.application.service.ISecuritycheckEgslllService;
import com.yyjz.icop.securitycheck.application.service.impl.SecuritycheckEgslllServiceImpl;

/**
 * <p>操作接口扩展</p>
 * <p>@author  2019-04-09</p>
 * <p>请在该类中添加自定义实现，以扩展功能</p>
 */
@Service
@Transactional
public class SecuritycheckEgslllServiceExtend extends SecuritycheckEgslllServiceImpl implements ISecuritycheckEgslllService {
	
	@Autowired
	private SecuritycheckEgslllInsertActivityExtend securitycheckEgslllInsertActivityExtend;
	
	@Autowired
	private SecuritycheckEgslllUpdateActivityExtend securitycheckEgslllUpdateActivityExtend;
	
	@Autowired
	private SecuritycheckEgslllDeleteActivityExtend securitycheckEgslllDeleteActivityExtend;

	
}
