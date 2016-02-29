SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `system_department`;
CREATE TABLE `system_department` (
  `id` int(11) NOT NULL auto_increment,
  `timestamp` timestamp default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `name` varchar(48) default NULL,
  `principle_user` varchar(48) default '',
  `region` varchar(8) default '',  
  `parent_id` int(11) default '0',
  PRIMARY KEY  (`id`)
  FOREIGN KEY (`parent_id`) REFERENCES system_department (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


DROP TABLE IF EXISTS `system_permission`;
CREATE TABLE `system_permission` (
  `id` int(11) NOT NULL auto_increment,
  `timestamp` timestamp default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `permissionname` varchar(48) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


DROP TABLE IF EXISTS `system_role`;
CREATE TABLE `system_role` (
  `id` int(11) NOT NULL auto_increment,
  `timestamp` timestamp default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `rolename` varchar(120) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user` (
  `id` int(11) NOT NULL auto_increment,
  `timestamp` timestamp default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
   `account` varchar(48) NOT NULL,
   `password` varchar(48) default '',
   `username` varchar(48) default '',
   `sex` char(1) default '',
  `department_id` int(11) default NULL,
  `employee_id` int(11) default '',
  `email` varchar(100) default '',
  `position` varchar(48) default '',
  `lastlogin` datetime default null,
  `enabled` tinyint(1) default '0' COMMENT '1 for YES or 0 for NO',
  PRIMARY KEY  (`id`)
  FOREIGN KEY (`department_id`) REFERENCES system_department(`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
ALTER TABLE `system_user` ADD INDEX  system_user_index_name(`account`);

DROP TABLE IF EXISTS `system_userRole`;
CREATE TABLE `system_userRole` (
  `id` int(11) NOT NULL auto_increment,
  `timestamp` timestamp default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `role_id` int(11) default NULL,
  `user_id` int(11) default NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`role_id`) REFERENCES system_role (`id`)
  FOREIGN KEY (`user_id`) REFERENCES system_user (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;


DROP TABLE IF EXISTS `system_rolePermission`;
CREATE TABLE `system_rolePermission` (
  `id` int(11) NOT NULL auto_increment,
  `timestamp` timestamp default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `role_id` int(11) default NULL,
  `permission_id` int(11) default NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`role_id`) REFERENCES system_role (`id`)
  FOREIGN KEY (`permission_id`) REFERENCES system_permission (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;



SET FOREIGN_KEY_CHECKS=1;





















