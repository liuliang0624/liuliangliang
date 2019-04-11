package com.yyjz.icop.tender.application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yyjz.icop.database.util.ExceptionUtils;
import com.yyjz.icop.tender.application.activity.TenderDeleteActivity;
import com.yyjz.icop.tender.application.activity.TenderInsertActivity;
import com.yyjz.icop.tender.application.activity.TenderUpdateActivity;
import com.yyjz.icop.tender.application.entity.TenderEntity;
import com.yyjz.icop.tender.application.service.ITenderService;
import com.yyjz.icop.tender.application.vo.TenderVO;
import com.yyjz.icop.pubapp.platform.util.DataObjectUtils;

/**
 * <p>操作接口实现</p>
 * <p>@author  2019-04-09</p>
 * <p>注意：请不要修改该文件中的代码，或者在该文件中添加自定义实现，每次执行“生成代码”都会导致任何对该文件的修改丢失！
 *     如需要扩展功能或者添加自定义实现，请在TenderServiceExtend类中完成。 </p>
 */
@Service
@Transactional
public abstract class TenderServiceImpl implements ITenderService {

	@Autowired
	protected TenderInsertActivity tenderInsertActivity;
	@Autowired
	protected TenderUpdateActivity tenderUpdateActivity;
	@Autowired
	protected TenderDeleteActivity tenderDeleteActivity;

	@Override
	public TenderVO insert(TenderVO tenderVO) {
		try {
			TenderEntity newEntity = new TenderEntity();
			DataObjectUtils.copyVOToEntity(tenderVO, newEntity);
			TenderEntity backEntity = tenderInsertActivity.insert(newEntity);
			TenderVO backVO = new TenderVO();
			DataObjectUtils.copyEntityToVO(backEntity, backVO);
			return backVO;
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return tenderVO;

	}

	@Override
	public TenderVO update(TenderVO tenderVO) {
		try {
			TenderEntity newEntity = new TenderEntity();
			DataObjectUtils.copyVOToEntity(tenderVO, newEntity);
			TenderEntity backEntity = tenderUpdateActivity.update(newEntity);
			TenderVO backVO = new TenderVO();
			DataObjectUtils.copyEntityToVO(backEntity, backVO);
			return backVO;
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return tenderVO;
	}

	@Override
	public void delete(TenderVO[] tenderVOs) {
		try {
			List<TenderEntity> entityList = new ArrayList<>();
			for (TenderVO vo : tenderVOs) {
				TenderEntity newEntity = new TenderEntity();
				DataObjectUtils.copyVOToEntity(vo, newEntity);
				entityList.add(newEntity);
			}
			tenderDeleteActivity.delete(entityList.toArray(new TenderEntity[0]));
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
	}

}
