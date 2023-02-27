-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: constructweek
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `empID` int NOT NULL AUTO_INCREMENT,
  `EName` varchar(25) NOT NULL,
  `EAddress` varchar(25) NOT NULL,
  `gram_panchayat_Id` int NOT NULL,
  `projectId` int DEFAULT NULL,
  PRIMARY KEY (`empID`),
  KEY `gram_panchayat_Id` (`gram_panchayat_Id`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`gram_panchayat_Id`) REFERENCES `gram_panchayat` (`gram_panchyat_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Kamal','abdef',3,0);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gram_panchayat`
--

DROP TABLE IF EXISTS `gram_panchayat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gram_panchayat` (
  `gram_panchyat_Id` int NOT NULL AUTO_INCREMENT,
  `gram_panchyat_Address` int NOT NULL,
  `gram_panchayat_name` varchar(50) NOT NULL,
  PRIMARY KEY (`gram_panchyat_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gram_panchayat`
--

LOCK TABLES `gram_panchayat` WRITE;
/*!40000 ALTER TABLE `gram_panchayat` DISABLE KEYS */;
INSERT INTO `gram_panchayat` VALUES (1,123,'Example Gram Panchayat'),(2,456,'Greenfield Gram Panchayat'),(3,789,'Ruralville Gram Panchayat'),(4,321,'Meadowdale Gram Panchayat'),(5,654,'Sunset Valley Gram Panchayat'),(6,987,'Hometown Gram Panchayat');
/*!40000 ALTER TABLE `gram_panchayat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gram_panchayat_member`
--

DROP TABLE IF EXISTS `gram_panchayat_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gram_panchayat_member` (
  `GP_member_Id` int NOT NULL AUTO_INCREMENT,
  `GP_member_Name` varchar(25) NOT NULL,
  `GP_member_Address` varchar(25) DEFAULT NULL,
  `GP_member_Password` varchar(25) NOT NULL,
  `gram_panchayat_Id` int NOT NULL,
  PRIMARY KEY (`GP_member_Id`),
  KEY `gram_panchayat_Id` (`gram_panchayat_Id`),
  CONSTRAINT `gram_panchayat_member_ibfk_1` FOREIGN KEY (`gram_panchayat_Id`) REFERENCES `gram_panchayat` (`gram_panchyat_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gram_panchayat_member`
--

LOCK TABLES `gram_panchayat_member` WRITE;
/*!40000 ALTER TABLE `gram_panchayat_member` DISABLE KEYS */;
INSERT INTO `gram_panchayat_member` VALUES (1,'John Doe','123 Main','123',1),(2,'Jane Smith','456','456',2),(3,'Bob Johnson','789','789',3),(4,'Alice Brown','910','910',4),(5,'Mike Davis','112','112',5),(6,'Chandu','1213','1213',6),(7,'Raghav','NewDelhi','1234',3);
/*!40000 ALTER TABLE `gram_panchayat_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project` (
  `projectId` int NOT NULL AUTO_INCREMENT,
  `projectName` varchar(25) NOT NULL,
  `projectAddress` varchar(25) DEFAULT NULL,
  `gram_panchayat_Id` int DEFAULT NULL,
  `GP_member_Id` int DEFAULT NULL,
  `budget` int DEFAULT NULL,
  `start` date NOT NULL DEFAULT (curdate()),
  `end` date DEFAULT NULL,
  `location` varchar(25) DEFAULT NULL,
  `status` enum('Not Started','In Progress','Completed') NOT NULL DEFAULT 'Not Started',
  PRIMARY KEY (`projectId`),
  KEY `gram_panchayat_Id` (`gram_panchayat_Id`),
  KEY `GP_member_Id` (`GP_member_Id`),
  CONSTRAINT `project_ibfk_1` FOREIGN KEY (`gram_panchayat_Id`) REFERENCES `gram_panchayat` (`gram_panchyat_Id`),
  CONSTRAINT `project_ibfk_2` FOREIGN KEY (`GP_member_Id`) REFERENCES `gram_panchayat_member` (`GP_member_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,'WaterSupply','123',3,7,500000,'2023-02-23',NULL,'456','In Progress'),(2,'RoadConstruction','123',1,NULL,250000,'2023-02-23',NULL,'321','Completed');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wage`
--

DROP TABLE IF EXISTS `wage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wage` (
  `Wage_Id` int NOT NULL AUTO_INCREMENT,
  `employee_id` int NOT NULL,
  `projectId` int NOT NULL,
  `gram_panchayat_Id` int NOT NULL,
  `wage_date` date DEFAULT (curdate()),
  `wage` decimal(10,2) NOT NULL,
  PRIMARY KEY (`Wage_Id`),
  KEY `employee_id` (`employee_id`),
  KEY `projectId` (`projectId`),
  CONSTRAINT `wage_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`empID`),
  CONSTRAINT `wage_ibfk_2` FOREIGN KEY (`projectId`) REFERENCES `project` (`projectId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wage`
--

LOCK TABLES `wage` WRITE;
/*!40000 ALTER TABLE `wage` DISABLE KEYS */;
INSERT INTO `wage` VALUES (1,1,1,3,'2023-02-24',1000.00),(2,1,1,3,'2023-02-24',1000.00),(3,1,1,3,'2023-02-24',1000.00);
/*!40000 ALTER TABLE `wage` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-27 11:22:28
