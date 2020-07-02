-- auto Generated on 2020-07-01 21:30:50 
-- DROP TABLE IF EXISTS `bill`; 
CREATE TABLE `bill`(
    `id` INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `goods_name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'goodsName',
    `unit` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'unit',
    `amount` INT (11) NOT NULL DEFAULT -1 COMMENT 'amount',
    `price` INT (11) NOT NULL DEFAULT -1 COMMENT 'price',
    `provider_id` INT (11) NOT NULL DEFAULT -1 COMMENT 'providerId',
    `status` INT (11) NOT NULL DEFAULT -1 COMMENT 'status',
    `create_date` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'createDate',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`bill`';
