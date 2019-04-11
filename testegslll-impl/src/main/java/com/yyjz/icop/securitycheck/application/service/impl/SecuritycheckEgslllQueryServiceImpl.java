package com.yyjz.icop.securitycheck.application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.yyjz.icop.database.util.ExceptionUtils;
import com.yyjz.icop.securitycheck.application.entity.SecuritycheckEgslllEntity;
import com.yyjz.icop.securitycheck.application.service.ISecuritycheckEgslllQueryService;
import com.yyjz.icop.securitycheck.application.vo.SecuritycheckEgslllVO;
import com.yyjz.icop.exception.BusinessException;
import com.yyjz.icop.pubapp.platform.query.BillQuery;
import com.yyjz.icop.pubapp.platform.query.QuerySchema;
import com.yyjz.icop.pubapp.platform.util.DataObjectUtils;

/**
 * <p>查询接口实现现</p>
 * <p>@author  2019-04-09</p>
 * <p>注意：请不要修改该文件中的代码，或者在该文件中添加自定义实现，每次执行“生成代码”都会导致任何对该文件的修改丢失！
 *     如需要扩展功能或者添加自定义实现，请在SecuritycheckEgslllQueryServiceExtend类中完成。 </p>
 */
@Service
public abstract class SecuritycheckEgslllQueryServiceImpl implements ISecuritycheckEgslllQueryService {

	@Autowired
	protected BillQuery<SecuritycheckEgslllEntity> query;

	@Override
	public Page<SecuritycheckEgslllVO> showList(QuerySchema querySchema) {
		Page<SecuritycheckEgslllEntity> page = query.findPage(SecuritycheckEgslllEntity.class, querySchema);
		Pageable pageable = new PageRequest(querySchema.getPageNumber(), querySchema.getPageSize());
		List<SecuritycheckEgslllEntity> list = page.getContent();
		List<SecuritycheckEgslllVO> vos = new ArrayList<>();
		for (SecuritycheckEgslllEntity entity : list) {
			SecuritycheckEgslllVO vo = new SecuritycheckEgslllVO();
			DataObjectUtils.copyEntityToVO(entity, vo);
			vos.add(vo);
		}
		Page<SecuritycheckEgslllVO> retVal = new PageImpl<SecuritycheckEgslllVO>(vos, pageable, page.getTotalElements());
		return retVal;
	}

	@Override
	public SecuritycheckEgslllVO findById(String primaryKey) throws BusinessException {
		try {
			SecuritycheckEgslllEntity entity = query.findOne(SecuritycheckEgslllEntity.class, primaryKey);
			SecuritycheckEgslllVO vo = new SecuritycheckEgslllVO();
			DataObjectUtils.copyEntityToVO(entity, vo);
			return vo;
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return null;
	}

}
