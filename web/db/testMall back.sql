-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: testmall
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `t_admin_info`
--

DROP TABLE IF EXISTS `t_admin_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_admin_info` (
  `ai_idx` int NOT NULL AUTO_INCREMENT,
  `ai_id` varchar(20) COLLATE utf8_bin NOT NULL,
  `ai_pwd` varchar(20) COLLATE utf8_bin NOT NULL,
  `ai_name` varchar(20) COLLATE utf8_bin NOT NULL,
  `ai_isrun` char(1) COLLATE utf8_bin DEFAULT 'y',
  `ai_regdate` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ai_id`),
  UNIQUE KEY `ai_idx` (`ai_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_admin_info`
--

LOCK TABLES `t_admin_info` WRITE;
/*!40000 ALTER TABLE `t_admin_info` DISABLE KEYS */;
INSERT INTO `t_admin_info` VALUES (2,'admin2','1111','임꺽정','y','2021-04-20 09:39:24'),(1,'sa','1111','관리자','y','2021-04-15 15:40:48');
/*!40000 ALTER TABLE `t_admin_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_admin_login_log`
--

DROP TABLE IF EXISTS `t_admin_login_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_admin_login_log` (
  `al_idx` int NOT NULL AUTO_INCREMENT,
  `ai_idx` int DEFAULT NULL,
  `al_ip` varchar(15) COLLATE utf8_bin NOT NULL,
  `al_date` datetime DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY `al_idx` (`al_idx`),
  KEY `fk_admin_login_log_ai_idx` (`ai_idx`),
  CONSTRAINT `fk_admin_login_log_ai_idx` FOREIGN KEY (`ai_idx`) REFERENCES `t_admin_info` (`ai_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_admin_login_log`
--

LOCK TABLES `t_admin_login_log` WRITE;
/*!40000 ALTER TABLE `t_admin_login_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_admin_login_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_admin_menu`
--

DROP TABLE IF EXISTS `t_admin_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_admin_menu` (
  `am_idx` int NOT NULL,
  `am_name` varchar(20) COLLATE utf8_bin NOT NULL,
  `am_link` varchar(100) COLLATE utf8_bin DEFAULT 'unlink',
  `am_parent` int DEFAULT '0',
  `am_seq` int DEFAULT '0',
  `am_regdate` datetime DEFAULT CURRENT_TIMESTAMP,
  `ai_idx` int DEFAULT NULL,
  PRIMARY KEY (`am_idx`),
  KEY `fk_admin_menu_ai_idx` (`ai_idx`),
  CONSTRAINT `fk_admin_menu_ai_idx` FOREIGN KEY (`ai_idx`) REFERENCES `t_admin_info` (`ai_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_admin_menu`
--

LOCK TABLES `t_admin_menu` WRITE;
/*!40000 ALTER TABLE `t_admin_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_admin_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_admin_premission`
--

DROP TABLE IF EXISTS `t_admin_premission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_admin_premission` (
  `ap_idx` int NOT NULL AUTO_INCREMENT,
  `ap_ai_idx` int NOT NULL,
  `am_idx` int NOT NULL,
  `ap_pms` int DEFAULT '0',
  `ap_regdate` datetime DEFAULT CURRENT_TIMESTAMP,
  `ai_idx` int DEFAULT NULL,
  PRIMARY KEY (`ap_ai_idx`,`am_idx`),
  UNIQUE KEY `ap_idx` (`ap_idx`),
  KEY `fk_admin_premission_am_idx` (`am_idx`),
  KEY `fk_admin_premission_ai_idx` (`ai_idx`),
  CONSTRAINT `fk_admin_premission_ai_idx` FOREIGN KEY (`ai_idx`) REFERENCES `t_admin_info` (`ai_idx`),
  CONSTRAINT `fk_admin_premission_am_idx` FOREIGN KEY (`am_idx`) REFERENCES `t_admin_menu` (`am_idx`),
  CONSTRAINT `fk_admin_premission_ap_ai_idx` FOREIGN KEY (`ap_ai_idx`) REFERENCES `t_admin_info` (`ai_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_admin_premission`
--

LOCK TABLES `t_admin_premission` WRITE;
/*!40000 ALTER TABLE `t_admin_premission` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_admin_premission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_brand`
--

DROP TABLE IF EXISTS `t_brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_brand` (
  `b_id` char(4) COLLATE utf8_bin NOT NULL,
  `b_name` varchar(20) COLLATE utf8_bin NOT NULL,
  `b_company` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`b_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_brand`
--

LOCK TABLES `t_brand` WRITE;
/*!40000 ALTER TABLE `t_brand` DISABLE KEYS */;
INSERT INTO `t_brand` VALUES ('BR01','하이트진로','진로'),('BR02','장수','서울탁주'),('BR03','처음처럼','롯데'),('BR04','한라산','한라산'),('BR05','지평','지평주조'),('BR06','OB','두산');
/*!40000 ALTER TABLE `t_brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_brd_faq`
--

DROP TABLE IF EXISTS `t_brd_faq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_brd_faq` (
  `bf_idx` int NOT NULL AUTO_INCREMENT,
  `bf_cata` varchar(20) COLLATE utf8_bin NOT NULL,
  `bf_title` varchar(100) COLLATE utf8_bin NOT NULL,
  `bf_content` text COLLATE utf8_bin NOT NULL,
  `bf_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `ai_idx` int DEFAULT NULL,
  PRIMARY KEY (`bf_idx`),
  KEY `fk_brd_faq_ai_idx` (`ai_idx`),
  CONSTRAINT `fk_brd_faq_ai_idx` FOREIGN KEY (`ai_idx`) REFERENCES `t_admin_info` (`ai_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_brd_faq`
--

LOCK TABLES `t_brd_faq` WRITE;
/*!40000 ALTER TABLE `t_brd_faq` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_brd_faq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_brd_notice`
--

DROP TABLE IF EXISTS `t_brd_notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_brd_notice` (
  `bn_idx` int NOT NULL AUTO_INCREMENT,
  `bn_title` varchar(100) COLLATE utf8_bin NOT NULL,
  `bn_content` text COLLATE utf8_bin NOT NULL,
  `bn_read` int DEFAULT '0',
  `bn_isnotice` char(1) COLLATE utf8_bin DEFAULT 'n',
  `bn_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `ai_idx` int DEFAULT NULL,
  PRIMARY KEY (`bn_idx`),
  KEY `fk_brd_notice_ai_idx` (`ai_idx`),
  CONSTRAINT `fk_brd_notice_ai_idx` FOREIGN KEY (`ai_idx`) REFERENCES `t_admin_info` (`ai_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_brd_notice`
--

LOCK TABLES `t_brd_notice` WRITE;
/*!40000 ALTER TABLE `t_brd_notice` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_brd_notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_brd_qna`
--

DROP TABLE IF EXISTS `t_brd_qna`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_brd_qna` (
  `bq_idx` int NOT NULL AUTO_INCREMENT,
  `mi_id` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `bq_cata` varchar(20) COLLATE utf8_bin NOT NULL,
  `bq_title` varchar(100) COLLATE utf8_bin NOT NULL,
  `bq_content` text COLLATE utf8_bin NOT NULL,
  `bq_img` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `bq_qdate` datetime DEFAULT CURRENT_TIMESTAMP,
  `bq_answer` text COLLATE utf8_bin,
  `ai_idx` int DEFAULT NULL,
  `bq_adate` datetime DEFAULT NULL,
  `bq_status` char(1) COLLATE utf8_bin DEFAULT 'a',
  PRIMARY KEY (`bq_idx`),
  KEY `fk_brd_qna_mi_id` (`mi_id`),
  KEY `fk_brd_qna_ai_idx` (`ai_idx`),
  CONSTRAINT `fk_brd_qna_ai_idx` FOREIGN KEY (`ai_idx`) REFERENCES `t_admin_info` (`ai_idx`),
  CONSTRAINT `fk_brd_qna_mi_id` FOREIGN KEY (`mi_id`) REFERENCES `t_member_info` (`mi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_brd_qna`
--

LOCK TABLES `t_brd_qna` WRITE;
/*!40000 ALTER TABLE `t_brd_qna` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_brd_qna` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_brd_review`
--

DROP TABLE IF EXISTS `t_brd_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_brd_review` (
  `br_idx` int NOT NULL AUTO_INCREMENT,
  `mi_id` varchar(20) COLLATE utf8_bin NOT NULL,
  `oi_id` char(10) COLLATE utf8_bin NOT NULL,
  `pi_id` char(6) COLLATE utf8_bin NOT NULL,
  `br_title` varchar(100) COLLATE utf8_bin NOT NULL,
  `br_content` text COLLATE utf8_bin NOT NULL,
  `br_cnt` int DEFAULT '0',
  `br_img1` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `br_img2` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `br_star` float DEFAULT '0',
  `br_score` float DEFAULT '0',
  `br_isview` char(1) COLLATE utf8_bin DEFAULT 'y',
  `br_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`mi_id`,`oi_id`,`pi_id`),
  UNIQUE KEY `br_idx` (`br_idx`),
  KEY `fk_brd_review_oi_id` (`oi_id`),
  KEY `fk_brd_review_pi_id` (`pi_id`),
  CONSTRAINT `fk_brd_review_mi_id` FOREIGN KEY (`mi_id`) REFERENCES `t_member_info` (`mi_id`),
  CONSTRAINT `fk_brd_review_oi_id` FOREIGN KEY (`oi_id`) REFERENCES `t_order_info` (`oi_id`),
  CONSTRAINT `fk_brd_review_pi_id` FOREIGN KEY (`pi_id`) REFERENCES `t_product_info` (`pi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_brd_review`
--

LOCK TABLES `t_brd_review` WRITE;
/*!40000 ALTER TABLE `t_brd_review` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_brd_review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_brd_review_911`
--

DROP TABLE IF EXISTS `t_brd_review_911`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_brd_review_911` (
  `br9_idx` int NOT NULL AUTO_INCREMENT,
  `br_idx` int DEFAULT NULL,
  `mi_id` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `br9_content` varchar(50) COLLATE utf8_bin NOT NULL,
  `br9_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `br_status` char(1) COLLATE utf8_bin DEFAULT 'a',
  `br9_opdate` datetime DEFAULT NULL,
  `ai_idx` int DEFAULT NULL,
  PRIMARY KEY (`br9_idx`),
  KEY `fk_brd_review_911_br_idx` (`br_idx`),
  KEY `fk_brd_review_911_mi_id` (`mi_id`),
  KEY `fk_brd_review_911_ai_idx` (`ai_idx`),
  CONSTRAINT `fk_brd_review_911_ai_idx` FOREIGN KEY (`ai_idx`) REFERENCES `t_admin_info` (`ai_idx`),
  CONSTRAINT `fk_brd_review_911_br_idx` FOREIGN KEY (`br_idx`) REFERENCES `t_brd_review` (`br_idx`),
  CONSTRAINT `fk_brd_review_911_mi_id` FOREIGN KEY (`mi_id`) REFERENCES `t_member_info` (`mi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_brd_review_911`
--

LOCK TABLES `t_brd_review_911` WRITE;
/*!40000 ALTER TABLE `t_brd_review_911` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_brd_review_911` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_brd_review_reply`
--

DROP TABLE IF EXISTS `t_brd_review_reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_brd_review_reply` (
  `brr_idx` int NOT NULL AUTO_INCREMENT,
  `br_idx` int DEFAULT NULL,
  `mi_id` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `brr_contentnn` text COLLATE utf8_bin NOT NULL,
  `brr_recc` float DEFAULT '0',
  `brr_isview` char(1) COLLATE utf8_bin DEFAULT 'y',
  `brr_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`brr_idx`),
  KEY `fk_brd_review_reply_br_idx` (`br_idx`),
  KEY `fk_brd_review_reply_mi_id` (`mi_id`),
  CONSTRAINT `fk_brd_review_reply_br_idx` FOREIGN KEY (`br_idx`) REFERENCES `t_brd_review` (`br_idx`),
  CONSTRAINT `fk_brd_review_reply_mi_id` FOREIGN KEY (`mi_id`) REFERENCES `t_member_info` (`mi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_brd_review_reply`
--

LOCK TABLES `t_brd_review_reply` WRITE;
/*!40000 ALTER TABLE `t_brd_review_reply` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_brd_review_reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_brd_review_reply_recc`
--

DROP TABLE IF EXISTS `t_brd_review_reply_recc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_brd_review_reply_recc` (
  `brrr_idx` int NOT NULL AUTO_INCREMENT,
  `brr_idx` int NOT NULL,
  `mi_id` varchar(20) COLLATE utf8_bin NOT NULL,
  `brrr_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`brr_idx`,`mi_id`),
  UNIQUE KEY `brrr_idx` (`brrr_idx`),
  KEY `fk_brd_review_reply_recc_mi_id` (`mi_id`),
  CONSTRAINT `fk_brd_review_reply_recc_brr_idx` FOREIGN KEY (`brr_idx`) REFERENCES `t_brd_review_reply` (`brr_idx`),
  CONSTRAINT `fk_brd_review_reply_recc_mi_id` FOREIGN KEY (`mi_id`) REFERENCES `t_member_info` (`mi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_brd_review_reply_recc`
--

LOCK TABLES `t_brd_review_reply_recc` WRITE;
/*!40000 ALTER TABLE `t_brd_review_reply_recc` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_brd_review_reply_recc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_brd_review_star`
--

DROP TABLE IF EXISTS `t_brd_review_star`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_brd_review_star` (
  `brs_idx` int NOT NULL AUTO_INCREMENT,
  `mi_id` varchar(20) COLLATE utf8_bin NOT NULL,
  `br_idx` int NOT NULL,
  `brs_score` float DEFAULT '0',
  `brs_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`mi_id`,`br_idx`),
  UNIQUE KEY `brs_idx` (`brs_idx`),
  KEY `fk_brd_review_star_br_idx` (`br_idx`),
  CONSTRAINT `fk_brd_review_star_br_idx` FOREIGN KEY (`br_idx`) REFERENCES `t_brd_review` (`br_idx`),
  CONSTRAINT `fk_brd_review_star_mi_id` FOREIGN KEY (`mi_id`) REFERENCES `t_member_info` (`mi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_brd_review_star`
--

LOCK TABLES `t_brd_review_star` WRITE;
/*!40000 ALTER TABLE `t_brd_review_star` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_brd_review_star` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_cata_big`
--

DROP TABLE IF EXISTS `t_cata_big`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_cata_big` (
  `cb_id` char(2) COLLATE utf8_bin NOT NULL,
  `cb_name` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`cb_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_cata_big`
--

LOCK TABLES `t_cata_big` WRITE;
/*!40000 ALTER TABLE `t_cata_big` DISABLE KEYS */;
INSERT INTO `t_cata_big` VALUES ('B1','발효주'),('B2','증류주');
/*!40000 ALTER TABLE `t_cata_big` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_cata_small`
--

DROP TABLE IF EXISTS `t_cata_small`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_cata_small` (
  `cs_id` char(5) COLLATE utf8_bin NOT NULL,
  `cb_id` char(2) COLLATE utf8_bin DEFAULT NULL,
  `cs_name` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`cs_id`),
  KEY `fk_cata_small_cb_id` (`cb_id`),
  CONSTRAINT `fk_cata_small_cb_id` FOREIGN KEY (`cb_id`) REFERENCES `t_cata_big` (`cb_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_cata_small`
--

LOCK TABLES `t_cata_small` WRITE;
/*!40000 ALTER TABLE `t_cata_small` DISABLE KEYS */;
INSERT INTO `t_cata_small` VALUES ('B1S01','B1','막걸리'),('B1S02','B1','포도주'),('B1S03','B1','맥주'),('B2S01','B2','소주'),('B2S02','B2','죽엽청'),('B2S03','B2','보드카');
/*!40000 ALTER TABLE `t_cata_small` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_main_banner`
--

DROP TABLE IF EXISTS `t_main_banner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_main_banner` (
  `mb_idx` int NOT NULL AUTO_INCREMENT,
  `mb_img` varchar(50) COLLATE utf8_bin NOT NULL,
  `mb_url` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `mb_seq` int DEFAULT '0',
  `mb_isview` char(1) COLLATE utf8_bin DEFAULT 'n',
  `mb_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `ai_idx` int DEFAULT NULL,
  PRIMARY KEY (`mb_idx`),
  KEY `fk_main_banner_ai_idx` (`ai_idx`),
  CONSTRAINT `fk_main_banner_ai_idx` FOREIGN KEY (`ai_idx`) REFERENCES `t_admin_info` (`ai_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_main_banner`
--

LOCK TABLES `t_main_banner` WRITE;
/*!40000 ALTER TABLE `t_main_banner` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_main_banner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_member_addr`
--

DROP TABLE IF EXISTS `t_member_addr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_member_addr` (
  `ma_idx` int NOT NULL AUTO_INCREMENT,
  `mi_id` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `ma_zip` char(5) COLLATE utf8_bin NOT NULL,
  `ma_addr1` varchar(50) COLLATE utf8_bin NOT NULL,
  `ma_addr2` varchar(50) COLLATE utf8_bin NOT NULL,
  `ma_basic` char(1) COLLATE utf8_bin DEFAULT 'y',
  `ma_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ma_idx`),
  KEY `fk_member_addr_mi_id` (`mi_id`),
  CONSTRAINT `fk_member_addr_mi_id` FOREIGN KEY (`mi_id`) REFERENCES `t_member_info` (`mi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_member_addr`
--

LOCK TABLES `t_member_addr` WRITE;
/*!40000 ALTER TABLE `t_member_addr` DISABLE KEYS */;
INSERT INTO `t_member_addr` VALUES (1,'test1','12345','서울','123-45','y','2021-04-15 22:08:21'),(2,'test2','22222','부산','222-45','y','2021-04-15 22:08:22'),(3,'test3','33333','대전','333-45','y','2021-04-15 22:08:22'),(4,'test4','11222','경상북도 문경시','456-456','y','2021-04-20 09:39:52');
/*!40000 ALTER TABLE `t_member_addr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_member_info`
--

DROP TABLE IF EXISTS `t_member_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_member_info` (
  `mi_id` varchar(20) COLLATE utf8_bin NOT NULL,
  `mi_pwd` varchar(20) COLLATE utf8_bin NOT NULL,
  `mi_name` varchar(20) COLLATE utf8_bin NOT NULL,
  `mi_birth` char(10) COLLATE utf8_bin NOT NULL,
  `mi_gender` char(1) COLLATE utf8_bin NOT NULL,
  `mi_phone` varchar(13) COLLATE utf8_bin NOT NULL,
  `mi_email` varchar(50) COLLATE utf8_bin NOT NULL,
  `mi_issns` char(1) COLLATE utf8_bin DEFAULT 'y',
  `mi_ismail` char(1) COLLATE utf8_bin DEFAULT 'y',
  `mi_point` int DEFAULT '0',
  `mi_rebank` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `mi_account` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `mi_recommend` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `mi_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `mi_isactive` char(1) COLLATE utf8_bin DEFAULT 'y',
  `mi_lastlogin` datetime DEFAULT NULL,
  PRIMARY KEY (`mi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_member_info`
--

LOCK TABLES `t_member_info` WRITE;
/*!40000 ALTER TABLE `t_member_info` DISABLE KEYS */;
INSERT INTO `t_member_info` VALUES ('test1','1111','홍길동','1988-05-15','m','010-1234-5678','hong@gmail.com','y','y',1000,NULL,NULL,NULL,'2021-04-15 22:08:17','y',NULL),('test2','1111','전우치','1991-08-05','m','010-2222-5678','woochi@nate.com','y','y',1000,NULL,NULL,NULL,'2021-04-15 22:08:17','y',NULL),('test3','1111','임꺽정','1998-11-23','m','010-1234-3333','lim@naver.com','y','n',1000,'SC은행','32165-12-123',NULL,'2021-04-15 22:08:18','y',NULL),('test4','1111','둘리','1995-08-09','m','010-1234-4444','dooly@naver.com','y','n',1000,'국민은행','123-4567-890','test1','2021-04-20 09:39:52','y',NULL);
/*!40000 ALTER TABLE `t_member_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_member_point`
--

DROP TABLE IF EXISTS `t_member_point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_member_point` (
  `mp_idx` int NOT NULL AUTO_INCREMENT,
  `mi_id` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `mp_kind` char(1) COLLATE utf8_bin DEFAULT 's',
  `mp_point` int DEFAULT '0',
  `mp_content` varchar(50) COLLATE utf8_bin NOT NULL,
  `mp_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`mp_idx`),
  KEY `fk_member_point_mi_id` (`mi_id`),
  CONSTRAINT `fk_member_point_mi_id` FOREIGN KEY (`mi_id`) REFERENCES `t_member_info` (`mi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_member_point`
--

LOCK TABLES `t_member_point` WRITE;
/*!40000 ALTER TABLE `t_member_point` DISABLE KEYS */;
INSERT INTO `t_member_point` VALUES (1,'test1','s',1000,'가입축하금','2021-04-15 22:08:25'),(2,'test2','s',1000,'가입축하금','2021-04-15 22:08:26'),(3,'test3','s',1000,'가입축하금','2021-04-15 22:08:27'),(4,'test4','s',1000,'가입축하금','2021-04-20 09:39:52'),(5,'test1','s',1000,'가입축하금','2021-04-20 09:40:51'),(6,'test2','s',1000,'가입축하금','2021-04-20 09:40:55'),(7,'test3','s',1000,'가입축하금','2021-04-20 09:40:56');
/*!40000 ALTER TABLE `t_member_point` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order_cart`
--

DROP TABLE IF EXISTS `t_order_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_order_cart` (
  `oc_idx` int NOT NULL AUTO_INCREMENT,
  `mi_id` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `pi_id` char(6) COLLATE utf8_bin DEFAULT NULL,
  `oc_option` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `oc_cnt` int DEFAULT '1',
  `oc_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`oc_idx`),
  KEY `fk_order_cart_mi_id` (`mi_id`),
  KEY `fk_order_cart_pi_id` (`pi_id`),
  CONSTRAINT `fk_order_cart_mi_id` FOREIGN KEY (`mi_id`) REFERENCES `t_member_info` (`mi_id`),
  CONSTRAINT `fk_order_cart_pi_id` FOREIGN KEY (`pi_id`) REFERENCES `t_product_info` (`pi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order_cart`
--

LOCK TABLES `t_order_cart` WRITE;
/*!40000 ALTER TABLE `t_order_cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_order_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order_detail`
--

DROP TABLE IF EXISTS `t_order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_order_detail` (
  `od_idx` int NOT NULL AUTO_INCREMENT,
  `oi_id` char(10) COLLATE utf8_bin DEFAULT NULL,
  `pi_id` char(6) COLLATE utf8_bin DEFAULT NULL,
  `od_pdtname` varchar(20) COLLATE utf8_bin NOT NULL,
  `od_pdtimg` varchar(50) COLLATE utf8_bin NOT NULL,
  `od_pdtprice` int DEFAULT '0',
  `od_cnt` int DEFAULT '1',
  `od_option` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `od_savepnt` int DEFAULT '0',
  PRIMARY KEY (`od_idx`),
  KEY `fk_order_detail_oi_id` (`oi_id`),
  KEY `fk_order_detail_pi_id` (`pi_id`),
  CONSTRAINT `fk_order_detail_oi_id` FOREIGN KEY (`oi_id`) REFERENCES `t_order_info` (`oi_id`),
  CONSTRAINT `fk_order_detail_pi_id` FOREIGN KEY (`pi_id`) REFERENCES `t_product_info` (`pi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order_detail`
--

LOCK TABLES `t_order_detail` WRITE;
/*!40000 ALTER TABLE `t_order_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order_info`
--

DROP TABLE IF EXISTS `t_order_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_order_info` (
  `oi_id` char(10) COLLATE utf8_bin NOT NULL,
  `mi_id` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `oi_name` varchar(20) COLLATE utf8_bin NOT NULL,
  `oi_phone` varchar(13) COLLATE utf8_bin NOT NULL,
  `oi_zip` char(5) COLLATE utf8_bin NOT NULL,
  `oi_addr1` varchar(50) COLLATE utf8_bin NOT NULL,
  `oi_addr2` varchar(50) COLLATE utf8_bin NOT NULL,
  `oi_payment` char(1) COLLATE utf8_bin DEFAULT 'a',
  `oi_pay` int DEFAULT '0',
  `oi_usepnt` int DEFAULT '0',
  `oi_delipay` int DEFAULT '0',
  `oi_status` char(1) COLLATE utf8_bin DEFAULT 'b',
  `oi_cnt` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `oi_invoice` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `oi_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`oi_id`),
  KEY `fk_order_info_pi_id` (`mi_id`),
  CONSTRAINT `fk_order_info_pi_id` FOREIGN KEY (`mi_id`) REFERENCES `t_member_info` (`mi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order_info`
--

LOCK TABLES `t_order_info` WRITE;
/*!40000 ALTER TABLE `t_order_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_order_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_poll_question`
--

DROP TABLE IF EXISTS `t_poll_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_poll_question` (
  `pq_idx` int NOT NULL AUTO_INCREMENT,
  `pq_question` varchar(200) COLLATE utf8_bin NOT NULL,
  `pq_ex1` varchar(100) COLLATE utf8_bin NOT NULL,
  `pq_ex2` varchar(100) COLLATE utf8_bin NOT NULL,
  `pq_ex3` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `pq_ex4` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `pq_ex5` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `pq_sdate` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `pq_edate` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `pq_endmsg` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `pa_status` char(1) COLLATE utf8_bin DEFAULT 'a',
  `pq_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `ai_idx` int DEFAULT NULL,
  PRIMARY KEY (`pq_idx`),
  KEY `fk_poll_question_ai_idx` (`ai_idx`),
  CONSTRAINT `fk_poll_question_ai_idx` FOREIGN KEY (`ai_idx`) REFERENCES `t_admin_info` (`ai_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_poll_question`
--

LOCK TABLES `t_poll_question` WRITE;
/*!40000 ALTER TABLE `t_poll_question` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_poll_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_poll_result`
--

DROP TABLE IF EXISTS `t_poll_result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_poll_result` (
  `pr_idx` int NOT NULL AUTO_INCREMENT,
  `pq_idx` int NOT NULL,
  `mi_id` varchar(20) COLLATE utf8_bin NOT NULL,
  `pr_ex` int DEFAULT NULL,
  `pr_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`pq_idx`,`mi_id`),
  UNIQUE KEY `pr_idx` (`pr_idx`),
  KEY `fk_poll_result_mi_id` (`mi_id`),
  CONSTRAINT `fk_poll_result_mi_id` FOREIGN KEY (`mi_id`) REFERENCES `t_member_info` (`mi_id`),
  CONSTRAINT `fk_poll_result_pq_idx` FOREIGN KEY (`pq_idx`) REFERENCES `t_poll_question` (`pq_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_poll_result`
--

LOCK TABLES `t_poll_result` WRITE;
/*!40000 ALTER TABLE `t_poll_result` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_poll_result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_info`
--

DROP TABLE IF EXISTS `t_product_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_product_info` (
  `pi_id` char(6) COLLATE utf8_bin NOT NULL,
  `pi_name` varchar(20) COLLATE utf8_bin NOT NULL,
  `cs_id` char(5) COLLATE utf8_bin DEFAULT NULL,
  `b_id` char(4) COLLATE utf8_bin DEFAULT NULL,
  `pi_origin` varchar(20) COLLATE utf8_bin NOT NULL,
  `pi_cost` int DEFAULT '0',
  `pi_price` int DEFAULT '0',
  `pi_discount` int DEFAULT '0',
  `pi_option` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `pi_img1` varchar(50) COLLATE utf8_bin NOT NULL,
  `pi_img2` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `pi_img3` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `pi_desc` varchar(50) COLLATE utf8_bin NOT NULL,
  `pi_stock` int DEFAULT '-1',
  `pi_salecnt` int DEFAULT '0',
  `pi_review` int DEFAULT '0',
  `pi_star` float DEFAULT '0',
  `pi_isview` char(1) COLLATE utf8_bin DEFAULT 'n',
  `pi_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `ai_idx` int DEFAULT NULL,
  PRIMARY KEY (`pi_id`),
  KEY `fk_product_info_cs_id` (`cs_id`),
  KEY `fk_product_info_b_id` (`b_id`),
  KEY `fk_product_info_ai_idx` (`ai_idx`),
  CONSTRAINT `fk_product_info_ai_idx` FOREIGN KEY (`ai_idx`) REFERENCES `t_admin_info` (`ai_idx`),
  CONSTRAINT `fk_product_info_b_id` FOREIGN KEY (`b_id`) REFERENCES `t_brand` (`b_id`),
  CONSTRAINT `fk_product_info_cs_id` FOREIGN KEY (`cs_id`) REFERENCES `t_cata_small` (`cs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_info`
--

LOCK TABLES `t_product_info` WRITE;
/*!40000 ALTER TABLE `t_product_info` DISABLE KEYS */;
INSERT INTO `t_product_info` VALUES ('pdt001','지평막걸리','B1S01','BR05','대한민국',2000,3000,0,'14도;18도','pdt001_1.jpg',NULL,NULL,'pdt001_d.jpg',500,0,0,0,'y','2021-04-20 09:41:26',1),('pdt002','술01','B1S01','BR01','대한민국',1500,2500,10,'11도;15도','pdt002_1.jpg',NULL,NULL,'pdt002_d.jpg',550,0,0,0,'y','2021-04-20 09:41:31',1),('pdt003','술02','B1S01','BR02','대한민국',2000,4000,10,'15도;18도','pdt003_1.jpg',NULL,NULL,'pdt003_d.jpg',-1,0,0,0,'y','2021-04-20 09:41:31',1),('pdt004','술03','B1S01','BR03','대한민국',2500,4500,10,'11도;15도','pdt004_1.jpg',NULL,NULL,'pdt004_d.jpg',-1,0,0,0,'y','2021-04-20 09:41:31',1),('pdt005','술04','B1S02','BR04','대한민국',3000,5000,10,'15도;18도','pdt005_1.jpg',NULL,NULL,'pdt005_d.jpg',600,0,0,0,'y','2021-04-20 09:41:31',1),('pdt006','술05','B1S02','BR05','대한민국',3500,5500,10,'11도;15도','pdt006_1.jpg',NULL,NULL,'pdt006_d.jpg',300,0,0,0,'y','2021-04-20 09:41:31',1),('pdt007','술06','B1S02','BR06','대한민국',1200,3200,10,'15도;18도','pdt007_1.jpg',NULL,NULL,'pdt007_d.jpg',600,0,0,0,'y','2021-04-20 09:41:31',1),('pdt008','술07','B1S02','BR01','대한민국',1800,3800,10,'12도;19도;21도','pdt008_1.jpg',NULL,NULL,'pdt008_d.jpg',300,0,0,0,'y','2021-04-20 09:41:31',1),('pdt009','술08','B1S03','BR02','대한민국',2400,4400,10,'12도;19도;21도','pdt009_1.jpg',NULL,NULL,'pdt009_d.jpg',600,0,0,0,'y','2021-04-20 09:41:31',1),('pdt010','술09','B1S03','BR03','대한민국',3000,5000,10,'12도;19도;21도','pdt010_1.jpg',NULL,NULL,'pdt010_d.jpg',300,0,0,0,'y','2021-04-20 09:41:31',1),('pdt011','술10','B1S03','BR04','대한민국',3600,5600,10,'12도;19도;21도','pdt011_1.jpg',NULL,NULL,'pdt011_d.jpg',600,0,0,0,'y','2021-04-20 09:41:31',1),('pdt012','술11','B2S01','BR05','대한민국',5500,7500,0,'12도;19도;21도','pdt012_1.jpg',NULL,NULL,'pdt012_d.jpg',300,0,0,0,'y','2021-04-20 09:41:31',1),('pdt013','술12','B2S01','BR06','대한민국',8000,10000,0,'33도;39도;41도','pdt013_1.jpg',NULL,NULL,'pdt013_d.jpg',-1,0,0,0,'y','2021-04-20 09:41:31',1),('pdt014','술13','B2S01','BR01','대한민국',10500,12500,0,'33도;39도;41도','pdt014_1.jpg',NULL,NULL,'pdt014_d.jpg',-1,0,0,0,'y','2021-04-20 09:41:31',1),('pdt015','술14','B2S02','BR02','대한민국',13000,15000,0,'33도;39도;41도','pdt015_1.jpg',NULL,NULL,'pdt015_d.jpg',-1,0,0,0,'y','2021-04-20 09:41:31',1),('pdt016','술15','B2S02','BR03','대한민국',15500,17500,0,'33도;39도;41도','pdt016_1.jpg',NULL,NULL,'pdt016_d.jpg',-1,0,0,0,'y','2021-04-20 09:41:31',1),('pdt017','술16','B2S02','BR04','대한민국',18000,20000,0,'33도;39도;41도','pdt017_1.jpg',NULL,NULL,'pdt017_d.jpg',-1,0,0,0,'y','2021-04-20 09:41:31',1),('pdt018','술17','B2S03','BR05','대한민국',20500,22500,0,'45도;50도;60도','pdt018_1.jpg',NULL,NULL,'pdt018_d.jpg',-1,0,0,0,'y','2021-04-20 09:41:31',1),('pdt019','술18','B2S03','BR06','대한민국',23000,25000,0,'45도;50도;60도','pdt019_1.jpg',NULL,NULL,'pdt019_d.jpg',-1,0,0,0,'y','2021-04-20 09:41:31',1),('pdt020','술19','B2S03','BR01','대한민국',25500,27500,0,'45도;50도;60도','pdt020_1.jpg',NULL,NULL,'pdt020_d.jpg',-1,0,0,0,'y','2021-04-20 09:41:31',1);
/*!40000 ALTER TABLE `t_product_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'testmall'
--
/*!50003 DROP PROCEDURE IF EXISTS `sp_ad_admin_insert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ad_admin_insert`(aiid varchar(20), aipwd varchar(20), ainame varchar(20), aiisrun varchar(20))
begin
	insert into t_admin_info (ai_id, ai_pwd, ai_name, ai_isrun)
    values (aiid, aipwd, ainame, aiisrun);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ad_admin_update` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ad_admin_update`(aipwd varchar(20), aiisrun varchar(20), aiid varchar(20))
begin
	update t_admin_info set ai_pwd = aipwd, ai_isrun = aiisrun where ai_id = aiid;
    -- id와 이름은 변경 불가로 하고 변경하려는 관리자의 id를 받아와 조건을 사용
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ad_log_insert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ad_log_insert`(aiidx int, alip varchar(15))
begin
	insert into t_admin_login_log(ai_idx, al_ip)
    values (aiidx, alip);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ad_menu_insert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ad_menu_insert`(amidx int, amname varchar(20), amlink varchar(100), amparent int, amseq int, aiidx int)
begin
	insert into t_admin_menu(am_idx, am_name, am_link, am_parent, am_seq, ai_idx)
	values (amidx, amname, amlink, amparent, amseq, aiidx);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ad_menu_update` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ad_menu_update`(amidx int, amname varchar(20), amlink varchar(100), amparent int, amseq int)
begin
	update t_admin_menu set am_name = amname, am_link = amlink, am_parent = amparent, am_seq = amseq where am_idx = amidx;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ad_pms_insert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ad_pms_insert`(apaiidx int, amidx int, appms int, aiidx int)
begin
	insert into t_admin_permission (ap_ai_idx, am_idx, ap_pms, ai_idx)
	values (apaiidx, amidx, appms ,aiidx );
    -- 한 관리자가 특정 메뉴에 대해 권한을 부여하는 쿼리
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ad_pms_update` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ad_pms_update`(apidx int, appms int)
begin
	update t_admin_permission set ap_pms = appms where ap_idx = apidx;
    
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_member_insert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_member_insert`(miid varchar(20), mipwd varchar(20), miname varchar(20), mibirth char(10), 
	migender char(1), miphone varchar(13), miemail varchar(50), miissns char(1), miismail char(1), mipoint int, 
    mirebank varchar(50), miaccount varchar(50), mirecommend varchar(20), mazip char(5), maaddr1 varchar(50), maaddr2 varchar(50), mppoint int, mpcontent varchar(50))
begin
	insert into t_member_info (mi_id, mi_pwd, mi_name, mi_birth, mi_gender, 
		mi_phone, mi_email, mi_issns, mi_ismail, mi_point, mi_rebank, mi_account, mi_recommend) 
	values (miid, mipwd, miname, mibirth, migender, miphone, miemail, miissns, miismail, 
		mipoint, mirebank, miaccount, mirecommend);
	-- 회원 정보 등록 쿼리
        
	insert into t_member_addr (mi_id, ma_zip, ma_addr1, ma_addr2) values (miid, mazip, maaddr1, maaddr2);
    -- 회원 주소 정보 등록 쿼리
    
    insert into t_member_point (mi_id, mp_point, mp_content) values (miid, mppoint, mpcontent);
    -- 회원 가입축하금 수령 쿼리
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_member_update` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_member_update`(miid varchar(20), miphone varchar(13), 
	miemail varchar(50), miissns char(1), miismail char(1), mirebank varchar(50), 
    miaccount varchar(50))
begin
	update t_member_info set mi_phone = miphone, mi_email = miemail, mi_issns = miissns,
		mi_ismail = miismail, mi_rebank = mirebank, mi_account = miaccount
	where mi_id = miid; 
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-29  9:47:37
