package com.yyjz.icop.tender.application.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import java.math.BigDecimal;
import com.yyjz.icop.refer.annotation.Refer;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import com.yyjz.icop.tender.application.entity.TenderEntity;
import com.yyjz.icop.metadata.core.annotations.Display;
import com.yyjz.icop.pubapp.platform.entity.SuperSubEntity;

/**
 * <p>TenderDetailsEntity</p>
 * <p>@author ICOP  2019-04-09</p>
 * <p>注意：模型类，继承SuperMainEntity或者SuperSubEntity </p>
 */
@Entity
@Table(name="tenderlll_details")
@Refer(referCode = "Tenderlll_Details", id = "id", name = "itemName", code = "itemCode")
@Display("招议标申请子表实体")
public class TenderDetailsEntity extends SuperSubEntity{	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	@Display("主键")
	private String id ;
	@Display("清单编码")
	@Column(name="item_code")
	private String itemCode ;
	@Display("清单名称")
	@Column(name="item_name")
	private String itemName ;
	@Display("数量")
	@Column(name="num")
	private BigDecimal num ;
	@Display("主表")
	@ManyToOne
	@JoinColumn(name = "pid" , insertable = false, updatable = false)
	private TenderEntity parent ;
	@Display("主表ID")
	@Column(name="pid")
	private String pid ;
	@Display("单价")
	@Column(name="price")
	private BigDecimal price ;
	@Display("计量单位")
	@Column(name="unit")
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
	public TenderEntity getParent() {
		return this.parent;
	}
	public void setParent(TenderEntity parent) {
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