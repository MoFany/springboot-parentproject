-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS employee;
CREATE TABLE employee
(
    keyId      int(4)                                                 NOT NULL AUTO_INCREMENT COMMENT '主键（自增）',
    year       int(4)                                                 NULL DEFAULT NULL COMMENT '薪资年份',
    month      int(4)                                                 NULL DEFAULT NULL COMMENT '薪资月份',
    createDate datetime                                               NULL DEFAULT NULL COMMENT '创建时间',
    fullName   varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
    enCode     varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职员编号',
    sex        varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '性别（男、女、未知）',
    age        int(4)                                                 NULL DEFAULT NULL COMMENT '年龄',
    sfz        varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
    phone      varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
    grossPay   decimal(10, 2)                                         NULL DEFAULT NULL COMMENT '应发工资',
    taxRatio   float(4, 2)                                            NULL DEFAULT NULL COMMENT '扣税比例',
    netpay     decimal(10, 2)                                         NULL DEFAULT NULL COMMENT '实发工资（=应发工资-应发工资*扣税比例）',
    PRIMARY KEY (keyId) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '职员薪资表'
  ROW_FORMAT = Dynamic;


