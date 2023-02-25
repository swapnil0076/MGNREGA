-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: constructweek
-- ------------------------------------------------------
-- Server version	8.0.31

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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-25 22:20:16
