package com.yyjz.icop.tender.application.activity;

import org.springframework.beans.factory.annotation.Autowired;

import com.yyjz.icop.application.rule.UpdateAuditinfoRule;
import com.yyjz.icop.tender.application.entity.TenderEntity;
import com.yyjz.icop.pubapp.platform.annotation.Activity;
import com.yyjz.icop.pubapp.platform.template.UpdateTemplate;

/**
 * <p>修改activity</p>
 * <p>@author ICOP  2019-04-09</p>
 * <p>注意：请不要修改该文件中的代码，或者在该文件中添加自定义实现，每次执行“生成代码”都会导致任何对该文件的修改丢失！
 *     如需要扩展功能或者添加自定义实现，请在TenderUpdateActivityExtend类中完成。 </p>
 */
@Activity
public abstract class TenderUpdateActivity {

	@Autowired
	protected UpdateAuditinfoRule<TenderEntity> updateAuditinfoRule;
	@Autowired
	protected UpdateTemplate<TenderEntity> update;

	public TenderEntity update(TenderEntity entity) {
			update.addBeforeRule(updateAuditinfoRule);
			update.addAfterRule(null);
			TenderEntity[] backEntity = update.doAction(new TenderEntity[] { entity });
			return backEntity[0];
	}
}
