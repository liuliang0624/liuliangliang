package com.yyjz.icop.securitycheck.application.activity;

import org.springframework.beans.factory.annotation.Autowired;

import com.yyjz.icop.application.rule.AddAuditinfoRule;
import com.yyjz.icop.application.rule.AddFsAttachRule;
import com.yyjz.icop.securitycheck.application.entity.SecuritycheckEgslllEntity;
import com.yyjz.icop.pubapp.platform.annotation.Activity;
import com.yyjz.icop.pubapp.platform.template.InsertTemplate;

/**
 * <p>新增activity</p>
 * <p>@author ICOP  2019-04-09</p>
 *     如需要扩展功能或者添加自定义实现，请在SecuritycheckEgslllInsertActivityExtend类中完成。 </p>
 */
@Activity
public abstract class SecuritycheckEgslllInsertActivity {
	@Autowired
	protected InsertTemplate<SecuritycheckEgslllEntity> insert;
	/**
	 * 引入审计信息公共rule
	 */
	@Autowired
	protected AddAuditinfoRule<SecuritycheckEgslllEntity> addAuditinfoRule;

	/**
	 * 引入附件公共rule
	 */
	@Autowired
	protected AddFsAttachRule<SecuritycheckEgslllEntity> addFsAttachRule;

	public SecuritycheckEgslllEntity insert(SecuritycheckEgslllEntity entity) {
		insert.addBeforeRule(addAuditinfoRule);
		insert.addAfterRule(addFsAttachRule);
		SecuritycheckEgslllEntity[] backEntity = insert.doAction(new SecuritycheckEgslllEntity[] { entity });
		return backEntity[0];
	}
}