/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE TABLE `cities` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(225) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE `passenger_ride` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ride_id` int(11) NOT NULL,
  `passengers_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `passenger_ride_ibfk_1` (`passengers_id`),
  KEY `rides_id` (`ride_id`),
  CONSTRAINT `passenger_ride_ibfk_1` FOREIGN KEY (`passengers_id`) REFERENCES `passengers` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `passenger_ride_ibfk_2` FOREIGN KEY (`ride_id`) REFERENCES `rides` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

CREATE TABLE `passengers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE `rides` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `train_id` int(11) NOT NULL,
  `departure_time` datetime NOT NULL,
  `departure_city` int(11) unsigned NOT NULL,
  `destination_city` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `train` (`train_id`),
  KEY `rides_ibfk_2` (`departure_city`),
  KEY `rides_ibfk_3` (`destination_city`),
  CONSTRAINT `rides_ibfk_1` FOREIGN KEY (`train_id`) REFERENCES `trains` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `rides_ibfk_2` FOREIGN KEY (`departure_city`) REFERENCES `cities` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `rides_ibfk_3` FOREIGN KEY (`destination_city`) REFERENCES `cities` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

CREATE TABLE `trains` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) CHARACTER SET utf8 NOT NULL,
  `max_speed` int(11) NOT NULL,
  `max_passengers` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

INSERT INTO `cities` (`id`, `name`) VALUES
(1, 'Brussel');
INSERT INTO `cities` (`id`, `name`) VALUES
(2, 'Gent');


INSERT INTO `passenger_ride` (`id`, `ride_id`, `passengers_id`) VALUES
(5, 4, 2);
INSERT INTO `passenger_ride` (`id`, `ride_id`, `passengers_id`) VALUES
(6, 4, 1);


INSERT INTO `passengers` (`id`, `name`) VALUES
(1, 'David');
INSERT INTO `passengers` (`id`, `name`) VALUES
(2, 'Hira');


INSERT INTO `rides` (`id`, `train_id`, `departure_time`, `departure_city`, `destination_city`) VALUES
(4, 2, '2021-11-09 16:15:01', 2, 1);


INSERT INTO `trains` (`id`, `type`, `max_speed`, `max_passengers`) VALUES
(2, 'IC', 300, 400);



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;