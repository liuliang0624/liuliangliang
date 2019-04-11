package com.yyjz.icop.securitycheck.application.vo;

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
 * <p>SecuritycheckEgslllVO</p>
 * <p>@author ICOP  2019-04-09</p>
 * <p>注意：该类为SecuritycheckEgslllEntity对应的VO类，继承SuperMainVO或者SuperSubVO </p>
 */
public class SecuritycheckEgslllVO extends SuperMainVO{	
	private static final long serialVersionUID = 1L;
	
	@Display("主键")
	private String id ;
	@Display("申请人")
	private String applicant ;
	@Display("申请日期")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date applicationDate ;
	@Display("申请部门")
	private String applicationDept ;
	@Display("出差申请子表")
	private List<SecuritycheckEgslllSubVO> editTable  = new ArrayList<>();
	@Display("预计费用")
	private BigDecimal estimatedCost ;
	@Display("预计天数")
	private int expectedDays ;
	@Display("是否报销")
	private String expense ;
	@Display("项目名称")
	private String projectId ;
	@Display("出差事由")
	private String travelReason ;
//我的代码  参照
@ReferSerialTransfer(referCode="Tenderlll_Details")
	public String getBidding() {
		return this.bidding;
	}
	@ReferDeserialTransfer
	public void setBidding(String bidding) {
		this.bidding = bidding;
	}
	@Display("招标文件")
	private String bidding ;
	//我的代码
	
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
	public List<SecuritycheckEgslllSubVO> getEditTable() {
		return this.editTable;
	}
	public void setEditTable(List<SecuritycheckEgslllSubVO> editTable) {
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