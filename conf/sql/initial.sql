INSERT INTO `system_department` VALUES (1, '2016-02-22 00:00:00', '�ɶ��з���','�ܲ���','�ɶ�', 0);
INSERT INTO `system_department` VALUES (2, '2016-02-22 00:00:00', 'STBС��','���ֱ�','�ɶ�', 1);
INSERT INTO `system_department` VALUES (2, '2016-02-22 00:00:00', '������С��','����','�ɶ�', 1);

INSERT INTO `system_permission` VALUES (1, '2016-02-22 00:00:00', '��Ŀ����');
INSERT INTO `system_permission` VALUES (2, '2016-02-22 00:00:00', '��Ա����');
INSERT INTO `system_permission` VALUES (3, '2016-02-22 00:00:00', '�������');
INSERT INTO `system_permission` VALUES (4, '2016-02-22 00:00:00', '����');
INSERT INTO `system_permission` VALUES (4, '2016-02-22 00:00:00', '���Թ���ʦ');

CREATE TABLE `system_role` (
  `id` int(11) NOT NULL auto_increment,
  `timestamp` timestamp default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `rolename` varchar(120) default NULL,
  PRIMARY KEY  (`id`)
) 

INSERT INTO `system_role` VALUES (1, '2016-02-22 00:00:00', '�з�����');
INSERT INTO `system_role` VALUES (2, '2016-02-22 00:00:00', '�鳤');
INSERT INTO `system_role` VALUES (3, '2016-02-22 00:00:00', '��Ŀ����');
INSERT INTO `system_role` VALUES (4, '2016-02-22 00:00:00', '�з�����ʦ');
INSERT INTO `system_role` VALUES (4, '2016-02-22 00:00:00', '���Թ���ʦ');


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


