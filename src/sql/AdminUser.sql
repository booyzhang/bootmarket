-- auto Generated on 2020-06-30 16:24:18 
-- DROP TABLE IF EXISTS `admin_user`; 
CREATE TABLE `admin_user`(
    `id` INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'name',
    `password` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'password',
    `gender` INT (11) NOT NULL DEFAULT -1 COMMENT 'gender',
    `age` INT (11) NOT NULL DEFAULT -1 COMMENT 'age',
    `code` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'code',
    `mobile` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'mobile',
    `type` INT (11) NOT NULL DEFAULT -1 COMMENT 'type',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`admin_user`';
