package com.yyjz.icop.tender.application.activity;

import org.springframework.beans.factory.annotation.Autowired;

import com.yyjz.icop.application.rule.AddAuditinfoRule;
import com.yyjz.icop.application.rule.AddFsAttachRule;
import com.yyjz.icop.tender.application.entity.TenderEntity;
import com.yyjz.icop.pubapp.platform.annotation.Activity;
import com.yyjz.icop.pubapp.platform.template.InsertTemplate;

/**
 * <p>新增activity</p>
 * <p>@author ICOP  2019-04-09</p>
 *     如需要扩展功能或者添加自定义实现，请在TenderInsertActivityExtend类中完成。 </p>
 */
@Activity
public abstract class TenderInsertActivity {
	@Autowired
	protected InsertTemplate<TenderEntity> insert;
	/**
	 * 引入审计信息公共rule
	 */
	@Autowired
	protected AddAuditinfoRule<TenderEntity> addAuditinfoRule;

	/**
	 * 引入附件公共rule
	 */
	@Autowired
	protected AddFsAttachRule<TenderEntity> addFsAttachRule;

	public TenderEntity insert(TenderEntity entity) {
		insert.addBeforeRule(addAuditinfoRule);
		insert.addAfterRule(addFsAttachRule);
		TenderEntity[] backEntity = insert.doAction(new TenderEntity[] { entity });
		return backEntity[0];
	}
}