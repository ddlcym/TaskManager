INSERT INTO `system_department` VALUES (1, '2016-02-22 00:00:00', '成都研发部','周部长','成都', 0);
INSERT INTO `system_department` VALUES (2, '2016-02-22 00:00:00', 'STB小组','李林炳','成都', 1);
INSERT INTO `system_department` VALUES (2, '2016-02-22 00:00:00', '互联网小组','王昆','成都', 1);

INSERT INTO `system_permission` VALUES (1, '2016-02-22 00:00:00', '项目管理');
INSERT INTO `system_permission` VALUES (2, '2016-02-22 00:00:00', '人员管理');
INSERT INTO `system_permission` VALUES (3, '2016-02-22 00:00:00', '任务管理');
INSERT INTO `system_permission` VALUES (4, '2016-02-22 00:00:00', '任务');
INSERT INTO `system_permission` VALUES (4, '2016-02-22 00:00:00', '测试工程师');

CREATE TABLE `system_role` (
  `id` int(11) NOT NULL auto_increment,
  `timestamp` timestamp default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `rolename` varchar(120) default NULL,
  PRIMARY KEY  (`id`)
) 

INSERT INTO `system_role` VALUES (1, '2016-02-22 00:00:00', '研发部长');
INSERT INTO `system_role` VALUES (2, '2016-02-22 00:00:00', '组长');
INSERT INTO `system_role` VALUES (3, '2016-02-22 00:00:00', '项目经理');
INSERT INTO `system_role` VALUES (4, '2016-02-22 00:00:00', '研发工程师');
INSERT INTO `system_role` VALUES (4, '2016-02-22 00:00:00', '测试工程师');


INSERT INTO `system_user` VALUES (1, '2014-04-01 00:00:00', 'Admin', 'Admin', 'chappadmin', 'chappadmin', 1);
INSERT INTO `system_role` VALUES (1, '2011-01-01 00:00:00', 'ROLE_ADMIN', 1);

INSERT INTO `system_user` VALUES (1, '2014-04-01 00:00:00', 'Admin', 'Admin', 'chappadmin', 'chappadmin', 1);
INSERT INTO `system_role` VALUES (1, '2011-01-01 00:00:00', 'ROLE_ADMIN', 1);
INSERT INTO `system_user` VALUES (1, '2014-04-01 00:00:00', 'Admin', 'Admin', 'chappadmin', 'chappadmin', 1);
INSERT INTO `system_role` VALUES (1, '2011-01-01 00:00:00', 'ROLE_ADMIN', 1);
INSERT INTO `system_user` VALUES (1, '2014-04-01 00:00:00', 'Admin', 'Admin', 'chappadmin', 'chappadmin', 1);
INSERT INTO `system_role` VALUES (1, '2011-01-01 00:00:00', 'ROLE_ADMIN', 1);
INSERT INTO `system_user` VALUES (1, '2014-04-01 00:00:00', 'Admin', 'Admin', 'chappadmin', 'chappadmin', 1);
INSERT INTO `system_role` VALUES (1, '2011-01-01 00:00:00', 'ROLE_ADMIN', 1);
INSERT INTO `system_user` VALUES (1, '2014-04-01 00:00:00', 'Admin', 'Admin', 'chappadmin', 'chappadmin', 1);
INSERT INTO `system_role` VALUES (1, '2011-01-01 00:00:00', 'ROLE_ADMIN', 1);
INSERT INTO `system_user` VALUES (1, '2014-04-01 00:00:00', 'Admin', 'Admin', 'chappadmin', 'chappadmin', 1);
INSERT INTO `system_role` VALUES (1, '2011-01-01 00:00:00', 'ROLE_ADMIN', 1);
INSERT INTO `system_user` VALUES (1, '2014-04-01 00:00:00', 'Admin', 'Admin', 'chappadmin', 'chappadmin', 1);
INSERT INTO `system_role` VALUES (1, '2011-01-01 00:00:00', 'ROLE_ADMIN', 1);
INSERT INTO `system_user` VALUES (1, '2014-04-01 00:00:00', 'Admin', 'Admin', 'chappadmin', 'chappadmin', 1);
INSERT INTO `system_role` VALUES (1, '2011-01-01 00:00:00', 'ROLE_ADMIN', 1);
INSERT INTO `system_user` VALUES (1, '2014-04-01 00:00:00', 'Admin', 'Admin', 'chappadmin', 'chappadmin', 1);
INSERT INTO `system_role` VALUES (1, '2011-01-01 00:00:00', 'ROLE_ADMIN', 1);


