package com.yyjz.icop.securitycheck.application.service;

import org.springframework.data.domain.Page;

import com.yyjz.icop.securitycheck.application.vo.SecuritycheckEgslllVO;
import com.yyjz.icop.exception.BusinessException;
import com.yyjz.icop.pubapp.platform.query.QuerySchema;

/**
 * <p>查询服务接口</p>
 * <p>@author ICOP  2019-04-09</p>
 * <p>注意：请不要修改该文件中的代码，或者在该文件中添加自定义实现，每次执行“生成代码”都会导致任何对该文件的修改丢失！
 *     如需要扩展功能或者添加自定义实现，请在SecuritycheckEgslllQueryServiceExtend类中完成。 </p>
 */
public interface ISecuritycheckEgslllQueryService {
	Page<SecuritycheckEgslllVO> showList(QuerySchema querySchema) throws BusinessException;
	SecuritycheckEgslllVO findById(String primaryKey) throws BusinessException;
}
