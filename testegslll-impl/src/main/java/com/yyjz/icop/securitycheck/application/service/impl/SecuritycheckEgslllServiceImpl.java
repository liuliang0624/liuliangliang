package com.yyjz.icop.securitycheck.application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yyjz.icop.database.util.ExceptionUtils;
import com.yyjz.icop.securitycheck.application.activity.SecuritycheckEgslllDeleteActivity;
import com.yyjz.icop.securitycheck.application.activity.SecuritycheckEgslllInsertActivity;
import com.yyjz.icop.securitycheck.application.activity.SecuritycheckEgslllUpdateActivity;
import com.yyjz.icop.securitycheck.application.entity.SecuritycheckEgslllEntity;
import com.yyjz.icop.securitycheck.application.service.ISecuritycheckEgslllService;
import com.yyjz.icop.securitycheck.application.vo.SecuritycheckEgslllVO;
import com.yyjz.icop.pubapp.platform.util.DataObjectUtils;

/**
 * <p>操作接口实现</p>
 * <p>@author  2019-04-09</p>
 * <p>注意：请不要修改该文件中的代码，或者在该文件中添加自定义实现，每次执行“生成代码”都会导致任何对该文件的修改丢失！
 *     如需要扩展功能或者添加自定义实现，请在SecuritycheckEgslllServiceExtend类中完成。 </p>
 */
@Service
@Transactional
public abstract class SecuritycheckEgslllServiceImpl implements ISecuritycheckEgslllService {

	@Autowired
	protected SecuritycheckEgslllInsertActivity securitycheckEgslllInsertActivity;
	@Autowired
	protected SecuritycheckEgslllUpdateActivity securitycheckEgslllUpdateActivity;
	@Autowired
	protected SecuritycheckEgslllDeleteActivity securitycheckEgslllDeleteActivity;

	@Override
	public SecuritycheckEgslllVO insert(SecuritycheckEgslllVO securitycheckEgslllVO) {
		try {
			SecuritycheckEgslllEntity newEntity = new SecuritycheckEgslllEntity();
			DataObjectUtils.copyVOToEntity(securitycheckEgslllVO, newEntity);
			SecuritycheckEgslllEntity backEntity = securitycheckEgslllInsertActivity.insert(newEntity);
			SecuritycheckEgslllVO backVO = new SecuritycheckEgslllVO();
			DataObjectUtils.copyEntityToVO(backEntity, backVO);
			return backVO;
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return securitycheckEgslllVO;

	}

	@Override
	public SecuritycheckEgslllVO update(SecuritycheckEgslllVO securitycheckEgslllVO) {
		try {
			SecuritycheckEgslllEntity newEntity = new SecuritycheckEgslllEntity();
			DataObjectUtils.copyVOToEntity(securitycheckEgslllVO, newEntity);
			SecuritycheckEgslllEntity backEntity = securitycheckEgslllUpdateActivity.update(newEntity);
			SecuritycheckEgslllVO backVO = new SecuritycheckEgslllVO();
			DataObjectUtils.copyEntityToVO(backEntity, backVO);
			return backVO;
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return securitycheckEgslllVO;
	}

	@Override
	public void delete(SecuritycheckEgslllVO[] securitycheckEgslllVOs) {
		try {
			List<SecuritycheckEgslllEntity> entityList = new ArrayList<>();
			for (SecuritycheckEgslllVO vo : securitycheckEgslllVOs) {
				SecuritycheckEgslllEntity newEntity = new SecuritycheckEgslllEntity();
				DataObjectUtils.copyVOToEntity(vo, newEntity);
				entityList.add(newEntity);
			}
			securitycheckEgslllDeleteActivity.delete(entityList.toArray(new SecuritycheckEgslllEntity[0]));
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
	}

}
