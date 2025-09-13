-- MariaDB dump 10.19  Distrib 10.4.32-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: medical
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `id` int NOT NULL AUTO_INCREMENT,
  `company_name` varchar(100) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `contact_no` varchar(100) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (6,'XYZ Pharmaceuticals','india','XYZ@gmail.com','35484646846','zkgnvljdlbjssn'),(7,'ABC Pharma','USA','abc@example.com','1234567890','123 Main Street, New York'),(8,'XYZ Pharmaceuticals','UK','xyz@example.com','9876543210','456 Park Avenue, London'),(9,'DEF Pharma','India','def@example.com','4464648644','123 Main Street, Delhi');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `printed_bills`
--

DROP TABLE IF EXISTS `printed_bills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `printed_bills` (
  `bill_id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `subtotal` decimal(10,2) DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT 'Walk-in Customer',
  `bill_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`bill_id`)
) ENGINE=InnoDB AUTO_INCREMENT=82239 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `printed_bills`
--

LOCK TABLES `printed_bills` WRITE;
/*!40000 ALTER TABLE `printed_bills` DISABLE KEYS */;
INSERT INTO `printed_bills` VALUES (1,'AllerFree',9.99,2,19.98,19.98,'Walk-in Customer','2025-04-03 23:37:06'),(2,'Pain-Away',12.99,20,259.80,409.60,'Walk-in Customer','2025-04-03 23:34:35'),(3,'Ibuprofen',7.49,20,149.80,409.60,'Walk-in Customer','2025-04-03 23:34:35'),(4,'Ibuprofen',7.49,2,14.98,14.98,'Walk-in Customer','2025-04-03 23:34:35'),(5,'CleanHands',3.99,5,19.95,19.95,'Walk-in Customer','2025-04-03 23:34:35'),(6,'Pain-Away',12.99,5,64.95,64.95,'Walk-in Customer','2025-04-03 23:34:35'),(8,'SneezeStop',7.99,5,39.95,49.93,'Walk-in Customer','2025-04-03 23:34:35'),(9,'Aspirin',4.99,2,9.98,49.93,'Walk-in Customer','2025-04-03 23:34:35'),(10,'Pain-Away',12.99,5,64.95,64.95,'Walk-in Customer','2025-04-03 23:34:35'),(11,'mask',5.00,5,25.00,25.00,'Walk-in Customer','2025-04-03 23:34:35'),(12,'mask',5.00,5,25.00,25.00,'Walk-in Customer','2025-04-03 23:34:35'),(13,'mask',5.00,5,25.00,25.00,'Walk-in Customer','2025-04-03 23:34:35'),(14,'mask',5.00,5,25.00,25.00,'Walk-in Customer','2025-04-03 23:34:35'),(15,'mask',5.00,3,15.00,15.00,'Walk-in Customer','2025-04-03 23:34:35'),(16,'mask',5.00,3,15.00,15.00,'Walk-in Customer','2025-04-03 23:34:35'),(17,'Pain-Away',12.99,3,38.97,38.97,'Walk-in Customer','2025-04-03 23:34:35'),(18,'mask',5.00,3,15.00,15.00,'Walk-in Customer','2025-04-03 23:34:35'),(19,'SkinGlow',6.99,1,6.99,6.99,'Walk-in Customer','2025-04-03 23:34:35'),(18860,'Ibuprofen',7.49,4,29.96,29.96,'Walk-in Customer','2025-04-04 00:02:35'),(30878,'cipltggrth',10.00,6,60.00,60.00,'Walk-in Customer','2025-04-04 11:10:03'),(33858,'Aspirin',4.99,2,9.98,9.98,'Walk-in Customer','2025-04-04 00:09:02'),(42935,'AllerFree',9.99,2,19.98,72.93,'Yash','2025-04-03 23:58:04'),(53453,'Aspirin',4.99,2,9.98,9.98,'Walk-in Customer','2025-04-03 23:54:32'),(55003,'AllerFree',9.99,2,19.98,72.93,'Yash','2025-04-03 23:56:57'),(60501,'Loratadine',8.99,2,17.98,17.98,'Walk-in Customer','2025-04-04 10:42:20'),(67186,'CleanHands',3.99,3,11.97,11.97,'Walk-in Customer','2025-04-04 00:04:23'),(77773,'mask',5.00,6,30.00,30.00,'Walk-in Customer','2025-04-04 11:23:42'),(82238,'AllerFree',9.99,2,19.98,72.93,'Yash','2025-04-04 00:04:06');
/*!40000 ALTER TABLE `printed_bills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `printed_bills_backup`
--

DROP TABLE IF EXISTS `printed_bills_backup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `printed_bills_backup` (
  `bill_id` int NOT NULL DEFAULT '0',
  `product_name` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `subtotal` decimal(10,2) DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `printed_bills_backup`
--

LOCK TABLES `printed_bills_backup` WRITE;
/*!40000 ALTER TABLE `printed_bills_backup` DISABLE KEYS */;
INSERT INTO `printed_bills_backup` VALUES (2,'Pain-Away',12.99,20,259.80,409.60),(3,'Ibuprofen',7.49,20,149.80,409.60),(4,'Ibuprofen',7.49,2,14.98,14.98),(5,'CleanHands',3.99,5,19.95,19.95),(6,'Pain-Away',12.99,5,64.95,64.95),(7,'Loratadine',8.99,5,44.95,44.95),(8,'SneezeStop',7.99,5,39.95,49.93),(9,'Aspirin',4.99,2,9.98,49.93),(10,'Pain-Away',12.99,5,64.95,64.95),(11,'mask',5.00,5,25.00,25.00),(12,'mask',5.00,5,25.00,25.00),(13,'mask',5.00,5,25.00,25.00),(14,'mask',5.00,5,25.00,25.00),(15,'mask',5.00,3,15.00,15.00),(16,'mask',5.00,3,15.00,15.00),(17,'Pain-Away',12.99,3,38.97,38.97),(18,'mask',5.00,3,15.00,15.00),(19,'SkinGlow',6.99,1,6.99,6.99);
/*!40000 ALTER TABLE `printed_bills_backup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_category`
--

DROP TABLE IF EXISTS `product_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_category` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `category` varchar(255) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_category`
--

LOCK TABLES `product_category` WRITE;
/*!40000 ALTER TABLE `product_category` DISABLE KEYS */;
INSERT INTO `product_category` VALUES (1,'Medicines'),(2,'Medical Equipment'),(3,'Health Supplements'),(4,'Personal Care'),(5,'sirgical'),(6,'mhy');
/*!40000 ALTER TABLE `product_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `product_name` varchar(255) NOT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `product_category` varchar(255) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `price_per_unit` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`product_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES ('AllerFree','Company B','Allergy',148,9.99),('Aspirin','GHI Pharmaceuticals','Pain Relief',116,4.99),('cipltggrth','XYZ Pharmaceuticals','Health Supplements',29,10.00),('CleanHands','DEF Pharma','Personal Care',287,3.99),('HeadEase','Company A','Pain Relief',145,10.49),('Ibuprofen','DEF Pharma','Pain Relief',53,7.49),('Loratadine','JKL Labs','Allergy',44,8.99),('PainRR','XYZ Pharmaceuticals','Medicines',100,2.00);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales_record`
--

DROP TABLE IF EXISTS `sales_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sales_record` (
  `record_id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(100) NOT NULL,
  `company_name` varchar(100) NOT NULL,
  `date_of_sale` date NOT NULL,
  `quantity` int NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales_record`
--

LOCK TABLES `sales_record` WRITE;
/*!40000 ALTER TABLE `sales_record` DISABLE KEYS */;
INSERT INTO `sales_record` VALUES (1,'Aspirin','Pharma Inc.','2024-04-11',10,59.90),(3,'Cough Syrup','MediCorp','2024-04-09',8,71.92),(4,'Amoxicillin','XYZ Pharmaceuticals','2024-04-11',55,604.45),(5,'Tablet1','ABC Pharma','2024-04-11',5,54.95),(6,'Tablet1','ABC Pharma','2024-04-11',5,29.95),(7,'Amoxicillin','XYZ Pharmaceuticals','2024-04-12',2,21.98),(8,'AllerFree','Company B','2024-04-15',50,499.50),(9,'SurgiGard','ABC Pharma','2024-04-16',100,2499.00),(10,'mask','ABC Pharma','2025-04-04',1000,5000.00);
/*!40000 ALTER TABLE `sales_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `fullname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `contact_no` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `user_type` enum('User','Admin') NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (5,'John Doe','john@example.com','1234567890','123 Main St, City','yash','yash','User'),(6,'Jane Smith','jane@example.com','0987654321','456 Elm St, Town','admin','admin','Admin'),(7,'','','','','','','User'),(8,'yuiuioo','fhyghg@gmail.com','764466788','jhjhfh','hfghfhg','jhgfuyfuh','User');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-09-13 20:58:25
