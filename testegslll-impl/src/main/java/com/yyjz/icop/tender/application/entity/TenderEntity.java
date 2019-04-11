package com.yyjz.icop.tender.application.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yyjz.icop.metadata.core.annotations.Display;
import com.yyjz.icop.pubapp.platform.entity.SuperMainEntity;
import com.yyjz.icop.refer.annotation.Refer;
import com.yyjz.icop.refer.annotation.ReferDeserialTransfer;
import com.yyjz.icop.refer.annotation.ReferSerialTransfer;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>TenderEntity</p>
 * <p>@author ICOP  2019-04-09</p>
 * <p>注意：模型类，继承SuperMainEntity或者SuperSubEntity </p>
 */
@Entity
@Table(name="tlll_tender")
@Refer(referCode = "Tlll_Tender", id = "id", name = "itemName", code = "itemCode")
@Display("招议标申请主表实体")
public class TenderEntity extends SuperMainEntity{	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	@Display("主键")
	private String id ;
	@Display("工程量清单")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="parent")
	private List<TenderDetailsEntity> details  = new ArrayList<>();
	@Display("金额")
	@Column(name="money")
	private BigDecimal money ;
	@Display("招标日期")
	@Column(name="tender_data")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date tenderData ;
	@Display("集采层级")
	@Column(name="tender_grape")
	private String tenderGrape ;
	@Display("名称")
	@Column(name="tender_name")
	private String tenderName ;
	//我的代码
	@Display("供应商") //注释
	@Column(name="supplier")
	private String supplier ;

	//

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<TenderDetailsEntity> getDetails() {
		return this.details;
	}
	public void setDetails(List<TenderDetailsEntity> details) {
		this.details = details;
	}
	public BigDecimal getMoney() {
		return this.money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public Date getTenderData() {
		return this.tenderData;
	}
	//我的代码

	@ReferSerialTransfer(referCode="bd-012")
	public String getSupplier() {
		return this.supplier;
	}
	@ReferDeserialTransfer
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	//
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