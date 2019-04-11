package com.yyjz.icop.tender.application.service.extend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yyjz.icop.tender.application.activity.extend.TenderDeleteActivityExtend;
import com.yyjz.icop.tender.application.activity.extend.TenderInsertActivityExtend;
import com.yyjz.icop.tender.application.activity.extend.TenderUpdateActivityExtend;
import com.yyjz.icop.tender.application.service.ITenderService;
import com.yyjz.icop.tender.application.service.impl.TenderServiceImpl;

/**
 * <p>操作接口扩展</p>
 * <p>@author  2019-04-09</p>
 * <p>请在该类中添加自定义实现，以扩展功能</p>
 */
@Service
@Transactional
public class TenderServiceExtend extends TenderServiceImpl implements ITenderService {
	
	@Autowired
	private TenderInsertActivityExtend tenderInsertActivityExtend;
	
	@Autowired
	private TenderUpdateActivityExtend tenderUpdateActivityExtend;
	
	@Autowired
	private TenderDeleteActivityExtend tenderDeleteActivityExtend;

	
}
