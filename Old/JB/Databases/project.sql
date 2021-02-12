CREATE DATABASE  IF NOT EXISTS `project` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `project`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: project
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Spa'),(2,'Food'),(3,'Vacation'),(4,'Electronics'),(5,'Clothes'),(6,'Shoes');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `companies`
--

DROP TABLE IF EXISTS `companies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `companies` (
  `company_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `password` varchar(90) DEFAULT NULL,
  PRIMARY KEY (`company_id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=235 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `companies`
--

LOCK TABLES `companies` WRITE;
/*!40000 ALTER TABLE `companies` DISABLE KEYS */;
INSERT INTO `companies` VALUES (10,'John Bryce','john@bryce.com','1234567'),(11,'Intel','intel@intelMail.com','1234567'),(12,'Microsoft','microsoft@soft.org','123456'),(13,'Finviz','bizviz.mail.com',NULL),(222,'t','test','t'),(224,'test12','test12','test12'),(226,'ye test Comp','email@email.com','1234'),(234,'Roogle','uniqueAndUnused@mail.com','1234567');
/*!40000 ALTER TABLE `companies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coupons`
--

DROP TABLE IF EXISTS `coupons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coupons` (
  `coupon_id` int NOT NULL AUTO_INCREMENT,
  `company_id` int DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `price` double DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`coupon_id`),
  KEY `FK_category_id_idx` (`category_id`),
  KEY `FK_company_id_idx` (`company_id`),
  CONSTRAINT `FK_category_id` FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`),
  CONSTRAINT `FK_company_id` FOREIGN KEY (`company_id`) REFERENCES `companies` (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coupons`
--

LOCK TABLES `coupons` WRITE;
/*!40000 ALTER TABLE `coupons` DISABLE KEYS */;
INSERT INTO `coupons` VALUES (1,12,5,'Chihuahua clothing','Short sleeve doggo shirt','2020-06-22','2050-02-23',9001,255,'C://Doggo.png'),(3,11,4,'Screens','Computer Screen','2020-05-19','2120-02-23',24999,50.5,'C://Images//cat.png'),(5,10,2,'Title_2','Desc_2','2010-05-06','2024-01-21',4,11,'pic2_location'),(6,11,3,'Free Trip To Wuhan ','100% No Viruses','2019-08-12','2020-01-05',50,0,'Corona.png'),(7,12,4,'Title_3','Desc_3','1990-11-16','1990-01-21',3,66,'pic3_location'),(8,13,5,'Title_4','Desc_4','1990-02-03','2000-01-21',2,77,'pic4_location'),(9,11,6,'Title_5','Desc_5','1990-10-27','2090-01-21',1,75,'pic5_location'),(26,12,4,'testCoupon','differentDesc','2019-02-04','2019-02-05',12,12,'imgLocation'),(32,226,3,'Ti11','updated Desc','2019-08-12','2020-01-05',50,123,'Corona.png'),(34,226,3,'Ti','100% No Viruses','2019-08-12','2020-01-05',50,5,'Corona.png');
/*!40000 ALTER TABLE `coupons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `password` varchar(90) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'updatedName1','updatedLast1','updated@mail.com','123update'),(3,'jeffery','jefferson','jeff@jefferson@mail.com','12341234'),(4,'Paityn','Hernandez','hernandez@mail.com','97721'),(5,'Ronald','Turner','turner123@mail.com','68442'),(6,'Amya','Hanz','ketchup@mail.com','69723'),(7,'Ryleigh','Lee','bruceleeOO@mail.com','27403'),(8,'Jason','Bourne','jasonbourne@mail.com','10132'),(9,'Samantha','Serban','communism@mail.com','67641'),(10,'Paul','Carter','cartoAB12grapher@mail.com','10524'),(11,'Sophia','Davis','SoDavis@mail.com','41111'),(12,'Michael','Martinez','micky.mart@mail.com','78160'),(17,'testFirst','testFirst','uniqueAndUnused@mail.com','1234');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers_vs_coupons`
--

DROP TABLE IF EXISTS `customers_vs_coupons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers_vs_coupons` (
  `customer_id` int NOT NULL,
  `coupon_id` int NOT NULL,
  PRIMARY KEY (`customer_id`,`coupon_id`),
  KEY `FK_customer_id_idx` (`customer_id`),
  KEY `FK_coupon_id_idx` (`coupon_id`),
  CONSTRAINT `FK_coupon_id` FOREIGN KEY (`coupon_id`) REFERENCES `coupons` (`coupon_id`),
  CONSTRAINT `FK_customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers_vs_coupons`
--

LOCK TABLES `customers_vs_coupons` WRITE;
/*!40000 ALTER TABLE `customers_vs_coupons` DISABLE KEYS */;
INSERT INTO `customers_vs_coupons` VALUES (1,1),(1,3),(1,26),(3,3),(6,3),(6,5),(6,7),(7,3),(7,9),(9,1),(11,6);
/*!40000 ALTER TABLE `customers_vs_coupons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'project'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-08 22:25:10
