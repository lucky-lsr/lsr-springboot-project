DROP TABLE IF EXISTS sys_service_instance;
CREATE TABLE `sys_service_instance`
(
    `system_id`        varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '' COMMENT '系统标识号',
    `service_name`     varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL COMMENT '服务名称',
    `service_id`       varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '服务ID ip#name#envId',
    `service_address`  varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci           DEFAULT '' COMMENT '服务地址',
    `service_port`     int(10) DEFAULT 0 COMMENT '服务端口',
    `create_time`      datetime                                                               DEFAULT NULL COMMENT '初始更新时间',
    `last_modify_time` datetime                                                               DEFAULT NULL COMMENT '最后更新时间',
    PRIMARY KEY (`service_name`, `service_id`, `system_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;