package com.yyjz.icop.securitycheck.application.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yyjz.icop.metadata.core.annotations.Display;
import com.yyjz.icop.pubapp.platform.entity.SuperMainEntity;
import com.yyjz.icop.refer.annotation.ReferDeserialTransfer;
import com.yyjz.icop.refer.annotation.ReferSerialTransfer;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>SecuritycheckEgslllEntity</p>
 * <p>@author ICOP  2019-04-09</p>
 * <p>注意：模型类，继承SuperMainEntity或者SuperSubEntity </p>
 */
@Entity
@Table(name="securitycheck_egslll")
@Display("安全检查主表")
public class SecuritycheckEgslllEntity extends SuperMainEntity{	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	@Display("主键")
	private String id ;
	@Display("申请人")
	@Column(name="applicant")
	private String applicant ;
	@Display("申请日期")
	@Column(name="application_date")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date applicationDate ;
	@Display("申请部门")
	@Column(name="application_dept")
	private String applicationDept ;
	@Display("出差申请子表")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="parent")
	private List<SecuritycheckEgslllSubEntity> editTable  = new ArrayList<>();
	@Display("预计费用")
	@Column(name="estimated_cost")
	private BigDecimal estimatedCost ;
	@Display("预计天数")
	@Column(name="expected_days")
	private int expectedDays ;
	@Display("是否报销")
	@Column(name="expense")
	private String expense ;
	@Display("项目名称")
	@Column(name="project_id")
	private String projectId ;
	@Display("出差事由")
	@Column(name="travel_reason")
	private String travelReason ;
	//我的代码
	@ReferSerialTransfer(referCode="Tenderlll_Details")
	public String getBidding() {
		return  this.bidding;
	}
	@ReferDeserialTransfer
	public void setBidding(String bidding) {
		this.bidding = bidding;
	}

	@Display("招标文件")
	@Column(name="bidding")
	private String bidding ;
	//



	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getApplicant() {
		return this.applicant;
	}
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	public Date getApplicationDate() {
		return this.applicationDate;
	}
	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}
	public String getApplicationDept() {
		return this.applicationDept;
	}
	public void setApplicationDept(String applicationDept) {
		this.applicationDept = applicationDept;
	}
	public List<SecuritycheckEgslllSubEntity> getEditTable() {
		return this.editTable;
	}
	public void setEditTable(List<SecuritycheckEgslllSubEntity> editTable) {
		this.editTable = editTable;
	}
	public BigDecimal getEstimatedCost() {
		return this.estimatedCost;
	}
	public void setEstimatedCost(BigDecimal estimatedCost) {
		this.estimatedCost = estimatedCost;
	}
	public int getExpectedDays() {
		return this.expectedDays;
	}
	public void setExpectedDays(int expectedDays) {
		this.expectedDays = expectedDays;
	}
	public String getExpense() {
		return this.expense;
	}
	public void setExpense(String expense) {
		this.expense = expense;
	}
	public String getProjectId() {
		return this.projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getTravelReason() {
		return this.travelReason;
	}
	public void setTravelReason(String travelReason) {
		this.travelReason = travelReason;
	}
	
}