package com.yyjz.icop.securitycheck.application.vo;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yyjz.icop.metadata.core.annotations.Display;
import com.yyjz.icop.pubapp.platform.vo.SuperSubVO;

/**
 * <p>SecuritycheckEgslllSubVO</p>
 * <p>@author ICOP  2019-04-09</p>
 * <p>注意：该类为SecuritycheckEgslllSubEntity对应的VO类，继承SuperMainVO或者SuperSubVO </p>
 */
public class SecuritycheckEgslllSubVO extends SuperSubVO{	
	private static final long serialVersionUID = 1L;
	
	@Display("主键")
	private String id ;
	@Display("到达地点")
	private String arrive ;
	@Display("出发地点")
	private String depart ;
	@Display("预计返回时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date endTime ;
	@Display("预计金额")
	private BigDecimal money ;
	@Display("出差申请主实体")
	private SecuritycheckEgslllVO parent ;
	@Display("同行出发人")
	private String person ;
	@Display("出差申请主表id")
	private String pid ;
	@Display("预计出发时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date startTime ;
	@Display("交通工具")
	private String vehicle ;
	
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getArrive() {
		return this.arrive;
	}
	public void setArrive(String arrive) {
		this.arrive = arrive;
	}
	public String getDepart() {
		return this.depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public Date getEndTime() {
		return this.endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public BigDecimal getMoney() {
		return this.money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public SecuritycheckEgslllVO getParent() {
		return this.parent;
	}
	public void setParent(SecuritycheckEgslllVO parent) {
		this.parent = parent;
	}
	public String getPerson() {
		return this.person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getPid() {
		return this.pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public Date getStartTime() {
		return this.startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public String getVehicle() {
		return this.vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	
}