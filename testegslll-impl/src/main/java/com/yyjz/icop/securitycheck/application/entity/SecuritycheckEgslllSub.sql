CREATE TABLE `securitycheck_egslll_sub` (
	`id` VARCHAR(32) NOT NULL COMMENT '主键',
	`arrive` VARCHAR(20) DEFAULT NULL COMMENT '到达地点',
	`company_id` VARCHAR(36) DEFAULT NULL COMMENT '公司id',
	`depart` VARCHAR(20) DEFAULT NULL COMMENT '出发地点',
	`dr` INT(1) DEFAULT NULL COMMENT 'dr',
	`end_time` DATETIME DEFAULT NULL COMMENT '预计返回时间',
	`money` DECIMAL(50,0) DEFAULT NULL COMMENT '预计金额',
	`person` VARCHAR(50) DEFAULT NULL COMMENT '同行出发人',
	`pid` VARCHAR(255) DEFAULT NULL COMMENT '出差申请主表id',
	`start_time` DATETIME DEFAULT NULL COMMENT '预计出发时间',
	`tenantid` VARCHAR(36) DEFAULT NULL COMMENT '租户id',
	`ts` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
	`vehicle` VARCHAR(50) DEFAULT NULL COMMENT '交通工具',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
