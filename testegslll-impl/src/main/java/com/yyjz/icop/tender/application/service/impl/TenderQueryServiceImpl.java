package com.yyjz.icop.tender.application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.yyjz.icop.database.util.ExceptionUtils;
import com.yyjz.icop.tender.application.entity.TenderEntity;
import com.yyjz.icop.tender.application.service.ITenderQueryService;
import com.yyjz.icop.tender.application.vo.TenderVO;
import com.yyjz.icop.exception.BusinessException;
import com.yyjz.icop.pubapp.platform.query.BillQuery;
import com.yyjz.icop.pubapp.platform.query.QuerySchema;
import com.yyjz.icop.pubapp.platform.util.DataObjectUtils;

/**
 * <p>查询接口实现现</p>
 * <p>@author  2019-04-09</p>
 * <p>注意：请不要修改该文件中的代码，或者在该文件中添加自定义实现，每次执行“生成代码”都会导致任何对该文件的修改丢失！
 *     如需要扩展功能或者添加自定义实现，请在TenderQueryServiceExtend类中完成。 </p>
 */
@Service
public abstract class TenderQueryServiceImpl implements ITenderQueryService {

	@Autowired
	protected BillQuery<TenderEntity> query;

	@Override
	public Page<TenderVO> showList(QuerySchema querySchema) {
		Page<TenderEntity> page = query.findPage(TenderEntity.class, querySchema);
		Pageable pageable = new PageRequest(querySchema.getPageNumber(), querySchema.getPageSize());
		List<TenderEntity> list = page.getContent();
		List<TenderVO> vos = new ArrayList<>();
		for (TenderEntity entity : list) {
			TenderVO vo = new TenderVO();
			DataObjectUtils.copyEntityToVO(entity, vo);
			vos.add(vo);
		}
		Page<TenderVO> retVal = new PageImpl<TenderVO>(vos, pageable, page.getTotalElements());
		return retVal;
	}

	@Override
	public TenderVO findById(String primaryKey) throws BusinessException {
		try {
			TenderEntity entity = query.findOne(TenderEntity.class, primaryKey);
			TenderVO vo = new TenderVO();
			DataObjectUtils.copyEntityToVO(entity, vo);
			return vo;
		} catch (Exception e) {
			ExceptionUtils.marsh(e);
		}
		return null;
	}

}
