DROP TABLE IF EXISTS sys_mutex;
CREATE TABLE `sys_mutex`
(
    `system_id`   varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '系统标识号',
    `mutex_name`  varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '分布式锁名称',
    `mutex_group` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '分布式锁分组',
    PRIMARY KEY (`system_id`, `mutex_name`, `mutex_group`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;