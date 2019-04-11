package com.yyjz.icop.tender.application.activity;

import org.springframework.beans.factory.annotation.Autowired;

import com.yyjz.icop.application.rule.AddAuditinfoRule;
import com.yyjz.icop.application.rule.AddFsAttachRule;
import com.yyjz.icop.tender.application.entity.TenderEntity;
import com.yyjz.icop.pubapp.platform.annotation.Activity;
import com.yyjz.icop.pubapp.platform.template.InsertTemplate;

/**
 * <p>新增activity</p>
 * <p>@author ICOP  2019-04-09</p> * <p>注意：请不要修改该文件中的代码，或者在该文件中添加自定义实现，每次执行“生成代码”都会导致任何对该文件的修改丢失！
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
