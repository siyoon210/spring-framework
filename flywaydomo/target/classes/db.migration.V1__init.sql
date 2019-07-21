CREATE TABLE `user`{
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL ,
  `name` varchar(255) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  unique (`UK_demo_email`, `email`)
}