package com.yyjz.icop.securitycheck.application.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import java.math.BigDecimal;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import java.util.Date;
import com.yyjz.icop.securitycheck.application.entity.SecuritycheckEgslllEntity;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yyjz.icop.metadata.core.annotations.Display;
import com.yyjz.icop.pubapp.platform.entity.SuperSubEntity;

/**
 * <p>SecuritycheckEgslllSubEntity</p>
 * <p>@author ICOP  2019-04-09</p>
 * <p>注意：模型类，继承SuperMainEntity或者SuperSubEntity </p>
 */
@Entity
@Table(name="securitycheck_egslll_sub")
@Display("安全检查子表")
public class SecuritycheckEgslllSubEntity extends SuperSubEntity{	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	@Display("主键")
	private String id ;
	@Display("到达地点")
	@Column(name="arrive")
	private String arrive ;
	@Display("出发地点")
	@Column(name="depart")
	private String depart ;
	@Display("预计返回时间")
	@Column(name="end_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date endTime ;
	@Display("预计金额")
	@Column(name="money")
	private BigDecimal money ;
	@Display("出差申请主实体")
	@ManyToOne
	@JoinColumn(name = "pid" , insertable = false, updatable = false)
	private SecuritycheckEgslllEntity parent ;
	@Display("同行出发人")
	@Column(name="person")
	private String person ;
	@Display("出差申请主表id")
	@Column(name="pid")
	private String pid ;
	@Display("预计出发时间")
	@Column(name="start_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date startTime ;
	@Display("交通工具")
	@Column(name="vehicle")
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
	public SecuritycheckEgslllEntity getParent() {
		return this.parent;
	}
	public void setParent(SecuritycheckEgslllEntity parent) {
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