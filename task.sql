DROP DATABASE IF EXISTS `kadai_task_list`;
CREATE DATABASE `kadai_task_list` DEFAULT CHARSET utf8 COLLATE utf8_bin;
GRANT ALL PRIVILEGES ON `kadai_task_list`.* TO kadai_task_list@localhost IDENTIFIED BY 'mysql';