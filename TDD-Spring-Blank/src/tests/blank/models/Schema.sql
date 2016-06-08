/*
* Database: paybat
* Username: paybat
* Password: 57551fdfad2c1
*
*/

/*
* Database: paybat-test
* Username: paybat-test
* Password: 57551fdfad2c1
*
*/

DROP TABLE IF EXISTS `User`;

CREATE TABLE `User` (
  `code` varchar(36) NOT NULL,
  `name` varchar(500) NOT NULL,
  `email` varchar(500) NOT NULL,
  `password` varchar(500) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;