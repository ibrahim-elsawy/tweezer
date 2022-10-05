DROP DATABASE  IF EXISTS `tweezer`;

CREATE DATABASE  IF NOT EXISTS `tweezer`;
USE `tweezer`;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(68) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Inserting data for table `users`
--

INSERT INTO `users` 
VALUES 
('sawy','ibrahimelsawy834@gmail.com','{noop}sawy4507',1);

--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('sawy','ROLE_ADMIN');



