package com.yyjz.icop.tender.application.vo;

import java.math.BigDecimal;
import com.yyjz.icop.metadata.core.annotations.Display;
import com.yyjz.icop.pubapp.platform.vo.SuperSubVO;

/**
 * <p>TenderDetailsVO</p>
 * <p>@author ICOP  2019-04-09</p>
 * <p>注意：该类为TenderDetailsEntity对应的VO类，继承SuperMainVO或者SuperSubVO </p>
 */
public class TenderDetailsVO extends SuperSubVO{	
	private static final long serialVersionUID = 1L;
	
	@Display("主键")
	private String id ;
	@Display("清单编码")
	private String itemCode ;
	@Display("清单名称")
	private String itemName ;
	@Display("数量")
	private BigDecimal num ;
	@Display("主表")
	private TenderVO parent ;
	@Display("主表ID")
	private String pid ;
	@Display("单价")
	private BigDecimal price ;
	@Display("计量单位")
	private String unit ;
	
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItemCode() {
		return this.itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return this.itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public BigDecimal getNum() {
		return this.num;
	}
	public void setNum(BigDecimal num) {
		this.num = num;
	}
	public TenderVO getParent() {
		return this.parent;
	}
	public void setParent(TenderVO parent) {
		this.parent = parent;
	}
	public String getPid() {
		return this.pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public BigDecimal getPrice() {
		return this.price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getUnit() {
		return this.unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
}