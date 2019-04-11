package com.yyjz.icop.securitycheck.application.service;

import com.yyjz.icop.securitycheck.application.vo.SecuritycheckEgslllVO;
import com.yyjz.icop.exception.BusinessException;

/**
 * <p>操作服务接口</p>
 * <p>@author ICOP  2019-04-09</p>
 * <p>注意：请不要修改该文件中的代码，或者在该文件中添加自定义实现，每次执行“生成代码”都会导致任何对该文件的修改丢失！
 *     如需要扩展功能或者添加自定义实现，请在SecuritycheckEgslllServiceExtend类中完成。</p>
 */
public interface ISecuritycheckEgslllService {
	SecuritycheckEgslllVO insert(SecuritycheckEgslllVO securitycheckEgslllVO) throws BusinessException;
	SecuritycheckEgslllVO update(SecuritycheckEgslllVO securitycheckEgslllVO) throws BusinessException;
	void delete(SecuritycheckEgslllVO[] securitycheckEgslllVOs) throws BusinessException;
}
