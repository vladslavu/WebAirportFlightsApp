-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: airplane_events_scheduling
-- ------------------------------------------------------
-- Server version	8.0.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `airplane`
--

DROP TABLE IF EXISTS `airplane`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airplane` (
  `id_airplane` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `id_company` int NOT NULL,
  `passenger_capacity` int NOT NULL,
  `luggage_capacity` int NOT NULL,
  PRIMARY KEY (`id_airplane`),
  KEY `id_company_fk_idx` (`id_company`),
  CONSTRAINT `id_company_fk` FOREIGN KEY (`id_company`) REFERENCES `airplane_company` (`id_company`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airplane`
--

LOCK TABLES `airplane` WRITE;
/*!40000 ALTER TABLE `airplane` DISABLE KEYS */;
INSERT INTO `airplane` VALUES (1,'Airforce',1,100,35),(2,'Bumblebee',1,50,10);
/*!40000 ALTER TABLE `airplane` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `airplane_company`
--

DROP TABLE IF EXISTS `airplane_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airplane_company` (
  `id_company` int NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `capital` int NOT NULL,
  `country` varchar(150) NOT NULL,
  `city` varchar(150) NOT NULL,
  `street` varchar(150) NOT NULL,
  `street_number` int NOT NULL,
  `number_of_employees` int NOT NULL,
  PRIMARY KEY (`id_company`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airplane_company`
--

LOCK TABLES `airplane_company` WRITE;
/*!40000 ALTER TABLE `airplane_company` DISABLE KEYS */;
INSERT INTO `airplane_company` VALUES (1,'TAROMANIA',20,'Romania','Bucharest','st',12,130);
/*!40000 ALTER TABLE `airplane_company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `airplane_event`
--

DROP TABLE IF EXISTS `airplane_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airplane_event` (
  `id_airplane_event` int NOT NULL,
  `id_airplane` int NOT NULL,
  `start_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `start_location` varchar(150) NOT NULL,
  `end_location` varchar(150) NOT NULL,
  `number_of_passengers` int NOT NULL DEFAULT '0',
  `luggage_weight` int DEFAULT NULL,
  `status` varchar(205) DEFAULT NULL,
  `type` varchar(200) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_airplane_event`),
  KEY `id_airplane_fk_idx` (`id_airplane`),
  CONSTRAINT `id_airplane_fk` FOREIGN KEY (`id_airplane`) REFERENCES `airplane` (`id_airplane`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airplane_event`
--

LOCK TABLES `airplane_event` WRITE;
/*!40000 ALTER TABLE `airplane_event` DISABLE KEYS */;
INSERT INTO `airplane_event` VALUES (2,1,'2022-04-23 18:25:00','2022-04-23 21:27:00','Cluj-Napoca','London Luton',70,20,'Future','0'),(4,1,'2022-04-23 01:22:00','2022-04-23 03:25:00','Cluj-Napoca','Amsterdam',93,25,'Future','0'),(8,1,'2022-05-01 14:38:00','2022-05-01 16:38:00','Bucharest','Barcelona',65,13,'Future','0'),(9,2,'2022-05-01 13:53:00','2022-05-01 16:53:00','Bucharest','London Luton',43,10,'Future','0'),(10,2,'2022-05-03 01:44:00','2022-05-03 04:50:00','London Luton','Bucharest',40,10,'Future','0'),(12,2,'2022-05-03 14:22:00','2022-05-03 15:22:00','Bucharest','Iasi',25,10,'Future','0'),(13,1,'2022-05-10 17:30:00','2022-05-10 19:50:00','Leeds','Bucharest',87,33,'Future','0'),(14,2,'2022-05-13 13:12:00','2022-05-13 14:42:00','Cluj-Napoca','Bucharest',33,8,'Future','0'),(15,2,'2022-05-13 14:00:00','2022-05-13 16:30:00','Cluj-Napoca','Leeds',49,10,'Future','0'),(21,2,'2022-05-15 20:20:00','2022-05-15 21:20:00','Bucharest','Cluj-Napoca',32,5,'Future','0'),(35,2,'2022-05-15 16:23:00','2022-05-15 17:53:00','Amsterdam','Iasi',44,10,'Future','0'),(37,1,'2022-05-16 16:40:00','2022-05-16 17:40:00','Cluj-Napoca','Iasi',13,2,'Future','0'),(39,1,'2021-12-25 08:12:00','2021-12-25 10:12:00','Iasi','Paris',87,30,'No problems','0'),(40,2,'2021-10-13 14:31:00','2021-10-13 17:01:00','Bucharest','Paris',49,12,'No problems','0'),(58,2,'2021-11-27 16:38:00','2021-11-27 18:45:00','Roma','Cluj-Napoca',39,11,'No problems','0');
/*!40000 ALTER TABLE `airplane_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_staff_assignation`
--

DROP TABLE IF EXISTS `event_staff_assignation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_staff_assignation` (
  `id_airplane_event` int NOT NULL,
  `id_staff_member` int NOT NULL,
  `role` varchar(150) DEFAULT NULL,
  `id_event_staff_assignation` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_event_staff_assignation`),
  KEY `id_airplane_eventFK_idx` (`id_airplane_event`),
  KEY `id_staff_memberFK_idx` (`id_staff_member`),
  CONSTRAINT `id_airplane_eventFK` FOREIGN KEY (`id_airplane_event`) REFERENCES `airplane_event` (`id_airplane_event`) ON DELETE CASCADE,
  CONSTRAINT `id_staff_memberFK` FOREIGN KEY (`id_staff_member`) REFERENCES `staff_member` (`id_staff_member`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_staff_assignation`
--

LOCK TABLES `event_staff_assignation` WRITE;
/*!40000 ALTER TABLE `event_staff_assignation` DISABLE KEYS */;
INSERT INTO `event_staff_assignation` VALUES (39,19,'1',1),(40,41,'1',23),(58,42,'1',24),(4,76,'1',59),(2,19,'1',60),(9,41,'1',65),(8,62,'1',85);
/*!40000 ALTER TABLE `event_staff_assignation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (96);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff_member`
--

DROP TABLE IF EXISTS `staff_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff_member` (
  `id_staff_member` int NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `age` int NOT NULL,
  `nationality` varchar(45) NOT NULL,
  `work_experience` int NOT NULL,
  PRIMARY KEY (`id_staff_member`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff_member`
--

LOCK TABLES `staff_member` WRITE;
/*!40000 ALTER TABLE `staff_member` DISABLE KEYS */;
INSERT INTO `staff_member` VALUES (19,'Tomas','Tom',27,'Romanian',3),(41,'Ghandi','Tom',30,'Indian',3),(42,'Georgi','Bodea',44,'Romanian',5),(62,'George','Petruta',35,'Romanian',5),(76,'Vlad','Slavu',22,'Romanian',1);
/*!40000 ALTER TABLE `staff_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `id_ticket` int NOT NULL AUTO_INCREMENT,
  `id_user` int NOT NULL,
  `id_event` int NOT NULL,
  `price` double DEFAULT '0',
  PRIMARY KEY (`id_ticket`),
  KEY `id_userfk_idx` (`id_user`),
  KEY `id_eventfk_idx` (`id_event`),
  CONSTRAINT `id_eventfk` FOREIGN KEY (`id_event`) REFERENCES `airplane_event` (`id_airplane_event`),
  CONSTRAINT `id_userfk` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (17,1,10,200.5),(18,1,10,200.5),(66,57,2,0.6551080294679997),(67,57,10,52),(69,68,35,233),(70,68,9,277),(74,57,4,183),(75,57,8,151),(77,57,2,63),(78,57,13,48),(79,57,8,24),(81,80,2,54),(82,80,9,26),(83,80,37,50),(87,57,21,67),(88,57,9,49),(90,57,8,90),(93,92,4,124),(94,92,21,44),(95,92,9,79);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `username` varchar(200) NOT NULL,
  `password` varchar(1000) NOT NULL,
  `role` varchar(100) NOT NULL,
  `email` varchar(200) NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'a','fsda','eaw','fdsa'),(22,'Tomas','$2a$10$6mDrqTJ5zhX.gA16PNicEO.JpzT32rHonalGi.Y8BNH098LU0t8SO','0','Tomeleu@Tomas'),(26,'Tomas','$2a$10$ujnSNrw1MgtiKJftOqO0G.qX0.BTvdI6BSK1k7WyFBb4ZYCIVTIPS','1','Tomeleu@Tomas'),(53,'yo','$2a$10$eoblBTFbK46pGSYX2CxZ6uB8.u.NsGPryn6OUHnyzwAmSXVctimVa','1','yo@gmail.com'),(54,'admin','$2a$10$0M4R6ca3lLSQw9JS5sA2Pe.t3oiHUDEASYOYbDXZh9TpYrH3axJTu','0','admin@gmail.com'),(55,'staff','$2a$10$G5YqYsCG5Phee.Yr42m/KupeSVNUrakKZPPLX1Ok8HpWYTNzI0ZG2','2','staff@gmail.com'),(56,'event','$2a$10$g2iFjOaD7pbVnY5NaDnWPOLDn0YYBX6PkRIUhnJz.Sj.RTaYfjkei','3','event@gmail.com'),(57,'customer','$2a$10$JKhnX7NA5ikoBxtmczp1x.1XLm7FeN7RFbH4oDSD7JHZZOvdXZIR.','1','customer@gmail.com'),(68,'vlad','$2a$10$iMNovyd0XWPPmQPEJxVfAuV9LpnNgcDobRHYWZgBmyq9IzVuYM1/O','1','vlad@pewe.com'),(71,'vllk','$2a$10$eWptxirWwZ2Rmyro.LClkunzx6xsoG8wxddCYZsWTHWm0mh3xBSnS','1','klmsac@ds.com'),(72,'vld','$2a$10$1yAJ8qIy2d3aExOza1dfPuUEKfJ98rD2f7UFR17A4arovidd6mltK','0','vld@yahpoo.com'),(73,'vld2','$2a$10$3kDLE34AQqNnMwvhLmvk3e2rKnPcdMYqlNRm8CxKT7NTybG2Ry1gK','2','vld2@yah.com'),(80,'staff2','$2a$10$Dys0tOmF58QHvhnGin/.I.KmaKxmdB6dBXVwxcxGu1EyqMkZycz3e','1','staff2@aes.net'),(89,'admin3','$2a$10$RptslRZIigE5Nh9YOj6NMu3PFN4JfnyjJ2G0KQDH5CHXIQF0kxM8K','0','admin3@gmail.com'),(91,'event3','$2a$10$wh3XhLoxI05D9BqGFxkbCO8oB93qN1QQJqj3Qs/fPwcUZ8TvKeo9K','3','event3@gmail.com'),(92,'customer3','$2a$10$fNSBfJUulk/53PMdvXNmZurjzauH/bWcA5Y66N9AObDhCuyqPUShS','1','customer3@gmail.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-28 19:29:31
