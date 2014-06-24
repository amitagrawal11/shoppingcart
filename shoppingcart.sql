-- MySQL dump 10.13  Distrib 5.5.32, for Win32 (x86)
--
-- Host: localhost    Database: shoppingcart
-- ------------------------------------------------------
-- Server version	5.5.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `ADMINID` int(11) NOT NULL AUTO_INCREMENT,
  `ADMINUSERNAME` varchar(255) NOT NULL,
  `ADMINPASSWORD` varchar(255) NOT NULL,
  PRIMARY KEY (`ADMINID`),
  UNIQUE KEY `ADMINUSERNAME` (`ADMINUSERNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `CATGID` int(11) NOT NULL AUTO_INCREMENT,
  `CATGNAME` varchar(255) NOT NULL,
  PRIMARY KEY (`CATGID`),
  UNIQUE KEY `CATGNAME` (`CATGNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (9,'Air Conditioner'),(2,'Bike'),(5,'Book'),(3,'Computer'),(43,'HeadPhones'),(52,'laptops'),(4,'LCD TVs'),(50,'SunGlasses');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `PRODUCTID` int(11) NOT NULL AUTO_INCREMENT,
  `PRODUCTNAME` varchar(255) NOT NULL,
  `PRODUCTPRICE` double NOT NULL,
  `PRODUCTDESC` varchar(255) DEFAULT NULL,
  `CATGID` int(11) DEFAULT NULL,
  PRIMARY KEY (`PRODUCTID`),
  UNIQUE KEY `PRODUCTNAME` (`PRODUCTNAME`),
  KEY `FK185958CF82C65A8F` (`CATGID`),
  CONSTRAINT `FK185958CF82C65A8F` FOREIGN KEY (`CATGID`) REFERENCES `category` (`CATGID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Sun',560,'book for java',5),(2,'Vestar',34000,'split ac',9),(3,'Voltas',25000,'very bad ac',9),(4,'BlueStar',30354,'window ac',9),(12,'Apache',80000,'180 cc ',2),(13,'hp G1234',32000,'i5- 3rd gen',3),(14,'lenovo g12',50000,'i7-2nd gen 8gb ram, 1tb hd',3),(15,'Ray Ban',5000,'Aviators',50),(16,'Head First ',500,'Java book for Beginners',5),(17,'Skul Candy',2000,'Known for bass effect',43),(18,'Sony Bravia',45000,'HD LCD 42\" Screen',4),(19,'Panasonic Viera',40000,'36\" LCD Sd ',4),(20,'Armani',5000,'Branded World Class Goggles',50),(21,'Pulsar',81000,'!50 cc Twin Spark Engine. 40 average',2),(22,'Spinkel',2000,'Colored HeadPhones',43),(23,'acer',20000,'cheaper laptops',52);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `USERID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `EMAILID` varchar(255) NOT NULL,
  `MOBILENO` varchar(255) NOT NULL,
  PRIMARY KEY (`USERID`),
  UNIQUE KEY `USERNAME` (`USERNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'amit','user','amit@admin.com','9128347234'),(2,'atul','user','atul@admin.com','23746837');
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

-- Dump completed on 2013-09-25 16:19:55
