-- auto Generated on 2020-07-01 16:39:00 
-- DROP TABLE IF EXISTS `Provider`;
CREATE TABLE `provider`(
    `id` INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `code` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'code',
    `name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'name',
    `linkman` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'linkman',
    `phone` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'phone',
    `fax` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'fax',
    `create_date` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'createDate',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`Provider`';
