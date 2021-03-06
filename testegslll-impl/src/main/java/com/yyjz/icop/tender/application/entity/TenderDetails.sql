CREATE TABLE `tenderlll_details` (
	`id` VARCHAR(32) NOT NULL COMMENT '主键',
	`company_id` VARCHAR(36) DEFAULT NULL COMMENT '公司id',
	`dr` INT(1) DEFAULT NULL COMMENT 'dr',
	`item_code` VARCHAR(50) DEFAULT NULL COMMENT '清单编码',
	`item_name` VARCHAR(255) DEFAULT NULL COMMENT '清单名称',
	`num` DECIMAL(10,0) DEFAULT NULL COMMENT '数量',
	`pid` VARCHAR(255) DEFAULT NULL COMMENT '主表ID',
	`price` DECIMAL(10,0) DEFAULT NULL COMMENT '单价',
	`tenantid` VARCHAR(36) DEFAULT NULL COMMENT '租户id',
	`ts` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
	`unit` VARCHAR(50) DEFAULT NULL COMMENT '计量单位',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
