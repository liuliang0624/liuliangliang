package com.yyjz.icop.securitycheck.application.activity;

import org.springframework.beans.factory.annotation.Autowired;

import com.yyjz.icop.application.rule.ReturnBillCodeRule;
import com.yyjz.icop.securitycheck.application.entity.SecuritycheckEgslllEntity;
import com.yyjz.icop.pubapp.platform.annotation.Activity;
import com.yyjz.icop.pubapp.platform.template.DeleteTemplate;

/**
 * <p>删除activity</p>
 * <p>@author ICOP  2019-04-09</p>
 * <p>注意：请不要修改该文件中的代码，或者在该文件中添加自定义实现，每次执行“生成代码”都会导致任何对该文件的修改丢失！
 *     如需要扩展功能或者添加自定义实现，请在SecuritycheckEgslllDeleteActivityExtend类中完成。 </p>
 */
@Activity
public abstract class SecuritycheckEgslllDeleteActivity {

	@Autowired
	protected ReturnBillCodeRule<SecuritycheckEgslllEntity> returnBillCodeRule;
	@Autowired
	protected DeleteTemplate<SecuritycheckEgslllEntity> delete;

	public void delete(SecuritycheckEgslllEntity[] entities) {
		delete.addBeforeRule(null);
		delete.addAfterRule(returnBillCodeRule);
		delete.doAction(entities);
	}
}
