CREATE TABLE IF NOT EXISTS `Student` (
  `id`           BIGINT(20)  NOT NULL AUTO_INCREMENT,
  `name`         VARCHAR(20)   NOT NULL DEFAULT '' COMMENT '名字',
  `sex`          TINYINT(2)   NOT NULL DEFAULT 0 COMMENT '性别',
  `age`          INT(5)    NOT NULL DEFAULT 0 COMMENT '年龄',
  `createTime`   TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建时间',
  `updateTime`   TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据更新时间',
  `createBy`     VARCHAR(40) NOT NULL DEFAULT '' COMMENT '数据创建人',
  `updateBy`     VARCHAR(40) NOT NULL DEFAULT '' COMMENT '数据更新人',
  PRIMARY KEY (`id`),
  KEY `idx_name` (`name`),
  KEY `idx_age` (`age`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT ='学生表';