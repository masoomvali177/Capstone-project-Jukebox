CREATE DATABASE  IF NOT EXISTS `jukebox` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `jukebox`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: jukebox
-- ----------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `playlist`
--

DROP TABLE IF EXISTS `playlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `playlist` (
  `playlistid` int NOT NULL AUTO_INCREMENT,
  `playlistname` varchar(50) DEFAULT NULL,
  `songids` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`playlistid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlist`
--

LOCK TABLES `playlist` WRITE;
/*!40000 ALTER TABLE `playlist` DISABLE KEYS */;
INSERT INTO `playlist` VALUES (1,'happy',NULL),(2,'vali playlist','3,4'),(3,'anisha playlist','1'),(4,'pinky playlist','6,7,8'),(5,'masoom playlist','1'),(6,'masoom vali','1'),(7,'pelai','1'),(8,'a','1'),(9,'b','1'),(10,'vali ayaan','1'),(11,'abc','1,2'),(12,'','4,6'),(13,'friday',NULL),(14,'fridays','3,4'),(15,'anisha girl',NULL),(16,'pinky mam',NULL),(17,'pinky mams','3,4'),(18,'anisha play',NULL),(19,'playlist','3,4'),(20,'vali ayaan','1'),(21,'sita ramam songs','6,7,8'),(22,'VALIS','8');
/*!40000 ALTER TABLE `playlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `songs`
--

DROP TABLE IF EXISTS `songs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `songs` (
  `songId` int NOT NULL AUTO_INCREMENT,
  `songName` varchar(45) DEFAULT NULL,
  `artist` varchar(45) DEFAULT NULL,
  `songGenre` varchar(45) DEFAULT NULL,
  `album` varchar(45) DEFAULT NULL,
  `songDuration` double DEFAULT NULL,
  `songPath` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`songId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `songs`
--

LOCK TABLES `songs` WRITE;
/*!40000 ALTER TABLE `songs` DISABLE KEYS */;
INSERT INTO `songs` VALUES (1,'dosti','keravani','dance','rrr',4,'src/main/resources/songs/Dosti.wav'),(2,'natu natu','kera','friendship','rrr',4,'src/main/resources/songs/Natu-Natu.wav'),(3,'lonely','akon','sad','akon',4,'src/main/resources/songs/lonely.wav'),(4,'100 days','jb','love','jbs',2,'src/main/resources/songs/100 days.wav'),(5,'boss','hari','party','Boss',4,'src/main/resources/songs/Boss.wav'),(6,'inthandam','ram','love','sita ramam',4,'src/main/resources/songs/Inthandham.wav'),(7,'kalyanam','ram','love','sita ramam',4.3,'src/main/resources/songs/Kalyanam.wav'),(8,'sita','sita','love','sita ramam',3,'src/main/resources/songs/Sita.wav');
/*!40000 ALTER TABLE `songs` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-05 20:23:37
