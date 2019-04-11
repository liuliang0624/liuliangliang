package com.yyjz.icop.tender.application.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yyjz.icop.metadata.core.annotations.Display;
import com.yyjz.icop.pubapp.platform.vo.SuperMainVO;
import com.yyjz.icop.refer.annotation.ReferDeserialTransfer;
import com.yyjz.icop.refer.annotation.ReferSerialTransfer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>TenderVO</p>
 * <p>@author ICOP  2019-04-09</p>
 * <p>注意：该类为TenderEntity对应的VO类，继承SuperMainVO或者SuperSubVO </p>
 */
public class TenderVO extends SuperMainVO{	
	private static final long serialVersionUID = 1L;
	
	@Display("主键")
	private String id ;
	@Display("工程量清单")
	private List<TenderDetailsVO> details  = new ArrayList<>();
	@Display("金额")
	private BigDecimal money ;
	@Display("供应商")
	private String supplier ;
	@Display("招标日期")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date tenderData ;
	@Display("集采层级")
	private String tenderGrape ;
	@Display("名称")
	private String tenderName ;
	
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<TenderDetailsVO> getDetails() {
		return this.details;
	}
	public void setDetails(List<TenderDetailsVO> details) {
		this.details = details;
	}
	public BigDecimal getMoney() {
		return this.money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	@ReferSerialTransfer(referCode="bd-012")
	public String getSupplier() {
		return this.supplier;
	}
	@ReferDeserialTransfer
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public Date getTenderData() {
		return this.tenderData;
	}
	public void setTenderData(Date tenderData) {
		this.tenderData = tenderData;
	}
	public String getTenderGrape() {
		return this.tenderGrape;
	}
	public void setTenderGrape(String tenderGrape) {
		this.tenderGrape = tenderGrape;
	}
	public String getTenderName() {
		return this.tenderName;
	}
	public void setTenderName(String tenderName) {
		this.tenderName = tenderName;
	}
	
}