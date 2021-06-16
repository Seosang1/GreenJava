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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_admin_info`
--

LOCK TABLES `t_admin_info` WRITE;
/*!40000 ALTER TABLE `t_admin_info` DISABLE KEYS */;
INSERT INTO `t_admin_info` VALUES (2,'admin1','1111','전우치','y','2021-04-19 16:43:33'),(3,'admin2','1111','임꺽정','y','2021-04-19 16:49:55'),(1,'sa','1111','관리자','y','2021-04-15 15:38:24');
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_admin_login_log`
--

LOCK TABLES `t_admin_login_log` WRITE;
/*!40000 ALTER TABLE `t_admin_login_log` DISABLE KEYS */;
INSERT INTO `t_admin_login_log` VALUES (1,1,'127.0.0.1','2021-04-19 17:15:26');
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
-- Table structure for table `t_admin_permission`
--

DROP TABLE IF EXISTS `t_admin_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_admin_permission` (
  `ap_idx` int NOT NULL AUTO_INCREMENT,
  `ap_ai_idx` int NOT NULL,
  `am_idx` int NOT NULL,
  `ap_pms` int DEFAULT '0',
  `ap_regdate` datetime DEFAULT CURRENT_TIMESTAMP,
  `ai_idx` int DEFAULT NULL,
  PRIMARY KEY (`ap_ai_idx`,`am_idx`),
  UNIQUE KEY `ap_idx` (`ap_idx`),
  KEY `fk_admin_permission_am_idx` (`am_idx`),
  KEY `fk_admin_permission_ai_idx` (`ai_idx`),
  CONSTRAINT `fk_admin_permission_ai_idx` FOREIGN KEY (`ai_idx`) REFERENCES `t_admin_info` (`ai_idx`),
  CONSTRAINT `fk_admin_permission_am_idx` FOREIGN KEY (`am_idx`) REFERENCES `t_admin_menu` (`am_idx`),
  CONSTRAINT `fk_admin_permission_ap_ai_idx` FOREIGN KEY (`ap_ai_idx`) REFERENCES `t_admin_info` (`ai_idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_admin_permission`
--

LOCK TABLES `t_admin_permission` WRITE;
/*!40000 ALTER TABLE `t_admin_permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_admin_permission` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_brd_notice`
--

LOCK TABLES `t_brd_notice` WRITE;
/*!40000 ALTER TABLE `t_brd_notice` DISABLE KEYS */;
INSERT INTO `t_brd_notice` VALUES (1,'6번째 공지사항입니다.','내용666',0,'n','2021-04-20 15:51:58',1),(2,'1번째 공지사항입니다.','내용111',0,'n','2021-04-20 15:52:01',1),(3,'2번째 공지사항입니다.','내용222',0,'n','2021-04-20 15:52:02',1),(4,'3번째 공지사항입니다.','내용333',0,'n','2021-04-20 15:52:03',1),(5,'4번째 공지사항입니다.','내용444',0,'n','2021-04-20 15:52:04',1),(6,'5번째 공지사항입니다.','내용555',0,'n','2021-04-20 15:52:04',1),(7,'7번째 공지사항입니다.','내용777',0,'n','2021-04-20 15:52:39',1),(8,'8번째 공지사항입니다.','내용888',0,'y','2021-04-20 15:52:40',1),(9,'9번째 공지사항입니다.','내용999',0,'y','2021-04-20 15:52:40',1),(10,'테스트 공지글','공지 공지 공지',0,'y','2021-04-20 16:03:47',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_brd_qna`
--

LOCK TABLES `t_brd_qna` WRITE;
/*!40000 ALTER TABLE `t_brd_qna` DISABLE KEYS */;
INSERT INTO `t_brd_qna` VALUES (1,'test1','회원 관련','질문있습니다.2','이게 뭔데??',NULL,'2021-04-20 18:01:50','답변입니다.',1,'2021-04-22 11:15:48','b');
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
  `br_opt` varchar(10) COLLATE utf8_bin NOT NULL DEFAULT '',
  `br_title` varchar(100) COLLATE utf8_bin NOT NULL,
  `br_content` text COLLATE utf8_bin NOT NULL,
  `br_cnt` int DEFAULT '0',
  `br_img1` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `br_img2` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `br_star` float DEFAULT '0.5',
  `br_score` float DEFAULT '0',
  `br_isview` char(1) COLLATE utf8_bin DEFAULT 'y',
  `br_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`mi_id`,`oi_id`,`pi_id`,`br_opt`),
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
  `br9_status` char(1) COLLATE utf8_bin DEFAULT 'a',
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
  `brr_content` text COLLATE utf8_bin NOT NULL,
  `brr_recc` int DEFAULT '0',
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
  PRIMARY KEY (`mi_id`,`brr_idx`),
  UNIQUE KEY `brrr_idx` (`brrr_idx`),
  KEY `fk_brd_review_reply_recc_brr_idx` (`brr_idx`),
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
  `brs_score` float DEFAULT '0.5',
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_main_banner`
--

LOCK TABLES `t_main_banner` WRITE;
/*!40000 ALTER TABLE `t_main_banner` DISABLE KEYS */;
INSERT INTO `t_main_banner` VALUES (1,'main01.jpg','/',1,'y','2021-04-26 13:01:06',1),(2,'main02.jpg','/',1,'n','2021-04-26 13:01:07',1),(3,'main03.jpg','/',2,'y','2021-04-26 13:01:08',1),(4,'main04.jpg','/',1,'y','2021-04-26 13:01:09',1),(5,'main05.jpg','/',5,'n','2021-04-26 13:01:49',1),(6,'main06.jpg','/',3,'y','2021-04-26 13:02:12',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_member_addr`
--

LOCK TABLES `t_member_addr` WRITE;
/*!40000 ALTER TABLE `t_member_addr` DISABLE KEYS */;
INSERT INTO `t_member_addr` VALUES (1,'test1','12345','서울','123-45','y','2021-04-15 17:45:27'),(2,'test2','22222','부산','222-45','y','2021-04-15 17:45:28'),(3,'test3','33333','대전','333-45','n','2021-04-15 17:45:29'),(4,'test4','11222','경상북도 문경시','456-456','y','2021-04-19 18:15:11'),(5,'test3','33333','울산시 중구','333-33','y','2021-04-20 11:09:17'),(6,'test2','22211','경상북도 포항시','오천읍 세계리','n','2021-04-20 11:10:40');
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
INSERT INTO `t_member_info` VALUES ('test1','1111','홍길동','1988-05-15','m','010-1234-5678','hong@gmail.com','y','y',1000,NULL,NULL,NULL,'2021-04-15 17:41:18','y',NULL),('test2','1234','전우치','1991-08-05','m','010-2222-5678','woochi@nate.com','y','y',1000,NULL,NULL,NULL,'2021-04-15 17:41:19','y',NULL),('test3','1111','임꺽정','1998-11-23','m','010-1234-3333','lim@naver.com','y','n',1000,'SC은행','32165-12-123',NULL,'2021-04-15 17:41:20','y',NULL),('test4','1111','둘리','1995-08-09','m','010-1234-4444','dooly@naver.com','y','n',2500,'국민은행','123-4567-890','test1','2021-04-19 18:15:11','y',NULL);
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
  `br_idx` int DEFAULT '0',
  `mp_content` varchar(50) COLLATE utf8_bin NOT NULL,
  `mp_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `ai_idx` int DEFAULT '0',
  PRIMARY KEY (`mp_idx`),
  KEY `fk_member_point_mi_id` (`mi_id`),
  CONSTRAINT `fk_member_point_mi_id` FOREIGN KEY (`mi_id`) REFERENCES `t_member_info` (`mi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_member_point`
--

LOCK TABLES `t_member_point` WRITE;
/*!40000 ALTER TABLE `t_member_point` DISABLE KEYS */;
INSERT INTO `t_member_point` VALUES (1,'test1','s',1000,0,'가입축하금','2021-04-15 17:57:23',0),(2,'test2','s',1000,0,'가입축하금','2021-04-15 17:57:24',0),(3,'test3','s',1000,0,'가입축하금','2021-04-15 17:57:24',0),(4,'test4','s',1000,0,'가입축하금','2021-04-19 18:15:11',0),(6,'test4','a',1500,0,'관리자갑질','2021-04-20 10:39:09',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order_cart`
--

LOCK TABLES `t_order_cart` WRITE;
/*!40000 ALTER TABLE `t_order_cart` DISABLE KEYS */;
INSERT INTO `t_order_cart` VALUES (5,'test1','pdt001','14도',2,'2021-04-27 15:44:16'),(6,'test1','pdt001','18도',1,'2021-04-27 15:44:17'),(7,'test1','pdt002','11도',3,'2021-04-27 15:44:18');
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
  `oi_cmt` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `oi_invoice` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `oi_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `oi_modify` datetime DEFAULT CURRENT_TIMESTAMP,
  `ai_idx` int DEFAULT '0',
  PRIMARY KEY (`oi_id`),
  KEY `fk_order_info_mi_id` (`mi_id`),
  CONSTRAINT `fk_order_info_mi_id` FOREIGN KEY (`mi_id`) REFERENCES `t_member_info` (`mi_id`)
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
  `pq_status` char(1) COLLATE utf8_bin DEFAULT 'a',
  `pq_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `ai_idx` int DEFAULT NULL,
  PRIMARY KEY (`pq_idx`),
  KEY `fk_poll_question_ai_idx` (`ai_idx`),
  CONSTRAINT `fk_poll_question_ai_idx` FOREIGN KEY (`ai_idx`) REFERENCES `t_admin_info` (`ai_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_poll_question`
--

LOCK TABLES `t_poll_question` WRITE;
/*!40000 ALTER TABLE `t_poll_question` DISABLE KEYS */;
INSERT INTO `t_poll_question` VALUES (1,'주로 마시는 술은 어떤 술인가요?','소주','맥주','막걸리','와인','데킬라','2021-04-26','2021-06-27','이제 그만','b','2021-04-26 10:56:20',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_poll_result`
--

LOCK TABLES `t_poll_result` WRITE;
/*!40000 ALTER TABLE `t_poll_result` DISABLE KEYS */;
INSERT INTO `t_poll_result` VALUES (1,1,'test1',1,'2021-04-26 11:01:02'),(3,1,'test2',1,'2021-04-26 11:05:05'),(4,1,'test3',2,'2021-04-26 11:05:06'),(5,1,'test4',3,'2021-04-26 11:05:06');
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
INSERT INTO `t_product_info` VALUES ('pdt001','지평막걸리','B1S01','BR05','대한민국',2000,3000,0,'14도;18도','pdt001_1.jpg',NULL,NULL,'pdt001_d.jpg',500,0,0,0,'y','2021-04-16 10:22:45',1),('pdt002','술01','B1S01','BR01','대한민국',1500,2500,10,'11도;15도','pdt002_1.jpg',NULL,NULL,'pdt002_d.jpg',550,0,0,0,'y','2021-04-16 10:49:58',1),('pdt003','술02','B1S01','BR02','대한민국',2000,4000,10,'15도;18도','pdt003_1.jpg',NULL,NULL,'pdt003_d.jpg',-1,0,0,0,'y','2021-04-16 10:52:23',1),('pdt004','술03','B1S01','BR03','대한민국',2500,4500,10,'11도;15도','pdt004_1.jpg',NULL,NULL,'pdt004_d.jpg',-1,0,0,0,'y','2021-04-16 10:52:24',1),('pdt005','술04','B1S02','BR04','대한민국',3000,5000,10,'15도;18도','pdt005_1.jpg',NULL,NULL,'pdt005_d.jpg',600,0,0,0,'y','2021-04-16 10:52:25',1),('pdt006','술05','B1S02','BR05','대한민국',3500,5500,10,'11도;15도','pdt006_1.jpg',NULL,NULL,'pdt006_d.jpg',300,0,0,0,'y','2021-04-16 10:52:26',1),('pdt007','술06','B1S02','BR06','대한민국',1200,3200,10,'15도;18도','pdt007_1.jpg',NULL,NULL,'pdt007_d.jpg',600,0,0,0,'y','2021-04-16 10:52:27',1),('pdt008','술07','B1S02','BR01','대한민국',1800,3800,10,'12도;19도;21도','pdt008_1.jpg',NULL,NULL,'pdt008_d.jpg',300,0,0,0,'y','2021-04-16 10:52:28',1),('pdt009','술08','B1S03','BR02','대한민국',2400,4400,10,'12도;19도;21도','pdt009_1.jpg',NULL,NULL,'pdt009_d.jpg',600,0,0,0,'y','2021-04-16 10:52:29',1),('pdt010','술09','B1S03','BR03','대한민국',3000,5000,10,'12도;19도;21도','pdt010_1.jpg',NULL,NULL,'pdt010_d.jpg',300,0,0,0,'y','2021-04-16 10:52:30',1),('pdt011','술10','B1S03','BR04','대한민국',3600,5600,10,'12도;19도;21도','pdt011_1.jpg',NULL,NULL,'pdt011_d.jpg',600,0,0,0,'y','2021-04-16 10:52:31',1),('pdt012','술11','B2S01','BR05','대한민국',5500,7500,0,'12도;19도;21도','pdt012_1.jpg',NULL,NULL,'pdt012_d.jpg',300,0,0,0,'y','2021-04-16 10:52:32',1),('pdt013','술12','B2S01','BR06','대한민국',8000,10000,0,'33도;39도;41도','pdt013_1.jpg',NULL,NULL,'pdt013_d.jpg',-1,0,0,0,'y','2021-04-16 10:52:33',1),('pdt014','술13','B2S01','BR01','대한민국',10500,12500,0,'33도;39도;41도','pdt014_1.jpg',NULL,NULL,'pdt014_d.jpg',-1,0,0,0,'y','2021-04-16 10:52:34',1),('pdt015','술14','B2S02','BR02','대한민국',13000,15000,0,'33도;39도;41도','pdt015_1.jpg',NULL,NULL,'pdt015_d.jpg',-1,0,0,0,'y','2021-04-16 10:52:35',1),('pdt016','술15','B2S02','BR03','대한민국',15500,17500,0,'33도;39도;41도','pdt016_1.jpg',NULL,NULL,'pdt016_d.jpg',-1,0,0,0,'y','2021-04-16 10:52:36',1),('pdt017','술16','B2S02','BR04','대한민국',18000,20000,0,'33도;39도;41도','pdt017_1.jpg',NULL,NULL,'pdt017_d.jpg',-1,0,0,0,'y','2021-04-16 10:52:37',1),('pdt018','술17','B2S03','BR05','대한민국',20500,22500,0,'45도;50도;60도','pdt018_1.jpg',NULL,NULL,'pdt018_d.jpg',-1,0,0,0,'y','2021-04-16 10:52:38',1),('pdt019','술18','B2S03','BR06','대한민국',23000,25000,0,'45도;50도;60도','pdt019_1.jpg',NULL,NULL,'pdt019_d.jpg',-1,0,0,0,'y','2021-04-16 10:52:39',1),('pdt020','술19','B2S03','BR01','대한민국',25500,27500,0,'45도;50도;60도','pdt020_1.jpg',NULL,NULL,'pdt020_d.jpg',-1,0,0,0,'y','2021-04-16 10:52:40',1),('pdt021','술21','B2S03','BR01','대한민국',33000,40000,0,'45도;50도;60도','pdt021_1.jpg','pdt021_2.jpg','','pdt021_d.jpg',1500,0,0,0,'y','2021-04-20 13:11:16',1);
/*!40000 ALTER TABLE `t_product_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `v_cart_list`
--

DROP TABLE IF EXISTS `v_cart_list`;
/*!50001 DROP VIEW IF EXISTS `v_cart_list`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_cart_list` AS SELECT 
 1 AS `pi_id`,
 1 AS `pi_price`,
 1 AS `pi_discount`,
 1 AS `oc_cnt`,
 1 AS `pi_option`,
 1 AS `oc_option`,
 1 AS `pi_name`,
 1 AS `pi_img1`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_order_list`
--

DROP TABLE IF EXISTS `v_order_list`;
/*!50001 DROP VIEW IF EXISTS `v_order_list`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_order_list` AS SELECT 
 1 AS `oi_id`,
 1 AS `mi_id`,
 1 AS `pi_id`,
 1 AS `od_pdtimg`,
 1 AS `od_pdtname`,
 1 AS `od_option`,
 1 AS `od_cnt`,
 1 AS `oi_pay`,
 1 AS `oi_date`,
 1 AS `oi_status`,
 1 AS `pi_isview`,
 1 AS `pi_stock`,
 1 AS `cb_id`,
 1 AS `cb_name`,
 1 AS `cs_id`,
 1 AS `cs_name`,
 1 AS `b_id`,
 1 AS `b_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_review_list`
--

DROP TABLE IF EXISTS `v_review_list`;
/*!50001 DROP VIEW IF EXISTS `v_review_list`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_review_list` AS SELECT 
 1 AS `br_idx`,
 1 AS `mi_id`,
 1 AS `title`,
 1 AS `br_date`,
 1 AS `br_star`,
 1 AS `br_img1`,
 1 AS `pi_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'testmall'
--

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
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ad_admin_insert`(
	aiid varchar(20), aipwd varchar(20), ainame varchar(20), aiisrun varchar(20))
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
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ad_admin_update`(
	aipwd varchar(20), aiisrun varchar(20), aiid varchar(20))
begin
	update t_admin_info set ai_pwd = aipwd, ai_isrun = aiisrun where ai_id = aiid;
    -- id와 이름은 변경불가로 하고 변경하려는 관리자의 id를 받아와 조건을 사용
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ad_banner_insert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ad_banner_insert`(
	mbimg varchar(50), mburl varchar(100), mbseq int, mbisview char(1), aiidx int)
begin
	insert into t_main_banner (mb_img, mb_url, mb_seq, mb_isview, ai_idx) 
	values (mbimg, mburl, mbseq, mbisview, aiidx);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ad_banner_insert2` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ad_banner_insert2`(oldidx int, -- 기존 이미지중 안보이게 하려는 이미지의 idx
	mbimg varchar(50), mburl varchar(100), mbseq int, mbisview char(1), aiidx int)
begin
	if mbisview = 'y' then -- 새로 추가하는 이미지를 보여주는 경우
		if oldidx > 0 then -- 기존의 이미지들(4개) 중 안보이게 할 이미지가 있을 경우
			update t_main_banner set mb_isview = 'n' where mb_idx = oldidx;
        end if;
    end if;
	insert into t_main_banner (mb_img, mb_url, mb_seq, mb_isview, ai_idx) 
	values (mbimg, mburl, mbseq, mbisview, aiidx);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ad_banner_update` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ad_banner_update`(
	mbidx int, mbimg varchar(50), mburl varchar(100), mbseq int, mbisview char(1))
begin
	update t_main_banner set mb_img = mbimg, mb_url = mburl, mb_seq = mbseq, 
	mb_isview = mbisview where mb_idx = mbidx;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ad_banner_update2` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ad_banner_update2`(oldidx int, oldview char(1), 
-- oldidx : 새롭게 보여질 이미지를 위해 숨길 이미지번호, oldview : 수정하려는 이미지의 원래 보임여부
	mbidx int, mbimg varchar(50), mburl varchar(100), mbseq int, mbisview char(1))
begin
	if mbisview = 'y' and oldview = 'n' and oldidx > 0 then
    -- 수정하는 이미지가 보임으로 변경되고 기존의 보이는 이미지가 4개일 경우
		update t_main_banner set mb_isview = 'n' where mb_idx = oldidx;
    end if;
	update t_main_banner set mb_img = mbimg, mb_url = mburl, mb_seq = mbseq, 
	mb_isview = mbisview where mb_idx = mbidx;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ad_faq_delete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ad_faq_delete`(bfidx int)
begin
	delete from t_brd_faq where bf_idx = bfidx;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ad_faq_insert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ad_faq_insert`(
	bfcata varchar(20), bftitle varchar(100), bfcontent text, aiidx int)
begin
	insert into t_brd_faq (bf_cata, bf_title, bf_content, ai_idx) 
    values (bfcata, bftitle, bfcontent, aiidx);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ad_faq_update` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ad_faq_update`(
	bfidx int, bfcata varchar(20), bftitle varchar(100), bfcontent text)
begin
	update t_brd_faq set bf_cata = bfcata, bf_title = bftitle, bf_content = bfcontent 
	where bf_idx = bfidx;
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
	insert into t_admin_login_log (ai_idx, al_ip) values (aiidx, alip);
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
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ad_menu_insert`(amidx int, amname varchar(20), 
	amlink varchar(100), amparent int, amseq int, aiidx int)
begin
	insert into t_admin_menu (am_idx, am_name, am_link, am_parent, am_seq, ai_idx) 
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
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ad_menu_update`(amidx int, amname varchar(20), 
	amlink varchar(100), amparent int, amseq int)
begin
	update t_admin_menu set am_name = amname, am_link = amlink, 
		am_parent = amparent, am_seq = amseq where am_idx = amidx;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ad_notice_delete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ad_notice_delete`(bnidx int)
begin
	delete from t_brd_notice where bn_idx = bnidx;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ad_notice_insert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ad_notice_insert`(
	bntitle varchar(100), bncontent text, bnisnotice char(1), aiidx int)
begin
	declare cnt int;
    declare idx int;
    set cnt = 0;
    set idx = 0;
	if bnisnotice = 'y' then
		select count(*) into cnt from t_brd_notice where bn_isnotice = 'y';
        if cnt >= 3 then
			select min(bn_idx) into idx from t_brd_notice where bn_isnotice = 'y';
            update t_brd_notice set bn_isnotice = 'n' where bn_idx = idx;
        end if;
    end if;
	insert into t_brd_notice (bn_title, bn_content, bn_isnotice, ai_idx) 
    values (bntitle, bncontent, bnisnotice, aiidx);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ad_notice_update` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ad_notice_update`(bnidx int, 
	bntitle varchar(100), bncontent text, bnisnotice char(1))
begin
	declare cnt int; -- 공지글의 개수를 저장할 변수
    declare idx int; -- 가장 오래된 공지글의 글번호를 저장할 변수
    set cnt = 0;
    set idx = 0;
	if bnisnotice = 'y' then
		select count(*) into cnt from t_brd_notice 
        where bn_isnotice = 'y' and bn_idx <> bnidx;
        if cnt >= 3 then
			select min(bn_idx) into idx from t_brd_notice where bn_isnotice = 'y';
            update t_brd_notice set bn_isnotice = 'n' where bn_idx = idx;
        end if;
    end if;
	update t_brd_notice set bn_title = bntitle, bn_content = bncontent, 
		bn_isnotice = bnisnotice where bn_idx = bnidx;
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
    values (apaiidx, amidx, appms, aiidx);
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
/*!50003 DROP PROCEDURE IF EXISTS `sp_ad_point_insert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ad_point_insert`(miid varchar(20), mppoint int, 
	mplinknum varchar(10), mpcontent varchar(50), aiidx int)
begin
	insert into t_member_point (mi_id, mp_kind, mp_point, mp_linknum, mp_content, ai_idx) 
    values (miid, 'a', mppoint, mplinknum, mpcontent, aiidx);

	update t_member_info set mi_point = mi_point + mppoint where mi_id = miid;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ad_poll_insert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ad_poll_insert`(
	pqquestion varchar(200), pqex1 varchar(100), pqex2 varchar(100), pqex3 varchar(100), 
	pqex4 varchar(100), pqex5 varchar(100), pqsdate varchar(10), pqedate varchar(10),
	pqendmsg varchar(100), pqstatus char(1), aiidx int)
begin
	insert into t_poll_question (pq_question, pq_ex1, pq_ex2, pq_ex3, pq_ex4, pq_ex5, 
		pq_sdate, pq_edate, pq_endmsg, pq_status, ai_idx) 
	values (pqquestion, pqex1, pqex2, pqex3, pqex4, pqex5, pqsdate, pqedate, 
		pqendmsg, pqstatus, aiidx);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ad_poll_update` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ad_poll_update`(
	pqidx int, pqquestion varchar(200), pqex1 varchar(100), pqex2 varchar(100), 
	pqex3 varchar(100), pqex4 varchar(100), pqex5 varchar(100), pqsdate varchar(10), 
	pqedate varchar(10), pqendmsg varchar(100), pqstatus char(1))
begin
	update t_poll_question set pq_question = pqquestion, pq_ex1 = pqex1, pq_ex2 = pqex2, 
		pq_ex3 = pqex3, pq_ex4 = pqex4, pq_ex5 = pqex5, pq_sdate = pqsdate, 
		pq_edate = pqedate, pq_endmsg = pqendmsg, pq_status = pqstatus 
	where pq_idx = pqidx;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ad_qna_answer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ad_qna_answer`(bqidx int, bqanswer text, aiidx int)
begin
	update t_brd_qna set bq_answer = bqanswer, bq_adate = now(), 
		bq_status = 'b', ai_idx = aiidx where bq_idx = bqidx;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_ad_review_911_proc` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ad_review_911_proc`(br9idx int, br9status char(1), aiidx int)
begin
	update t_brd_review_911 set br9_status = br9status, br9_opdate = now(), ai_idx = aiidx 
	where br9_idx = br9idx;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_all_order_update` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_all_order_update`(aiidx int, miid varchar(20), oiid char(10), oistatus char(1), 
	oiname varchar(20), oiphone varchar(13), oizip char(5), oiaddr1 varchar(50), oiaddr2 varchar(50))
begin
	if aiidx = 0 then -- 사용자가 변경하는 경우
		update t_order_info set oi_name = oiname, oi_phone = oiphone, oi_zip = oizip, oi_addr1 = oiaddr1, 
			oi_addr2 = oiaddr2, oi_status = oistatus where mi_id = miid and oi_id = oiid;
    else -- 관리자가 변경하는 경우
		update t_order_info set oi_name = oiname, oi_phone = oiphone, oi_zip = oizip, oi_addr1 = oiaddr1, 
			oi_addr2 = oiaddr2, oi_status = oistatus, oi_modify = now(), ai_idx = aiidx where oi_id = oiid;
    end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_cart_delete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_cart_delete`(ocidx int)
begin
	delete from t_order_cart where oc_idx = ocidx;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_cart_insert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_cart_insert`(
	miid varchar(20), piid char(6), ocoption varchar(10), occnt int)
begin
	declare cnt int; -- 동일상품/옵션의 개수를 저장할 변수
    select count(oc_idx) into cnt from t_order_cart 
	where mi_id = miid and pi_id = piid and oc_option = ocoption;
    -- 동일 회원/상품/옵션을 가진 목록이 카트테이블에 몇 개인지를 추출하는 쿼리

	if cnt = 0 then -- 기존 목록에 동일한 상품이 없을 경우
		insert into t_order_cart (mi_id, pi_id, oc_option, oc_cnt) 
		values (miid, piid, ocoption, occnt);
	else
		update t_order_cart set oc_cnt = oc_cnt + occnt 
		where mi_id = miid and pi_id = piid and oc_option = ocoption;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_cart_update` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_cart_update`(
	ocidx int, miid varchar(20), piid char(6), ocoption varchar(10), occnt int)
begin
	declare idx int; -- 동일상품/옵션의 개수를 저장할 변수
    select ifnull(oc_idx, 0) into idx from t_order_cart 
	where mi_id = miid and pi_id = piid and oc_option = ocoption;
    -- 동일 회원/상품/옵션을 가진 목록이 카트테이블에 있으면 idx를 추출하는 쿼리

	if idx = 0 then
		update t_order_cart set oc_option = ocoption, oc_cnt = occnt where oc_idx = ocidx;
		-- 옵션/수량을 변경해주는 쿼리
    else
    begin
		update t_order_cart set oc_cnt = oc_cnt + occnt where oc_idx = idx;
		-- 동일한 옵션을 가진 상품이 이미 있으므로 수량만 추가해 주는 쿼리
		delete from t_order_cart where oc_idx = ocidx;
        -- 변경한 상품은 수량을 추가했으므로 변경한 상품을 삭제해야 함
	end;
    end if;
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
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_member_insert`(miid varchar(20), mipwd varchar(20), 
	miname varchar(20), mibirth char(10), migender char(1), miphone varchar(13), 
	miemail varchar(50), miissns char(1), miismail char(1), mipoint int, 
    mirebank varchar(50), miaccount varchar(50), mirecommend varchar(20), 
	mazip char(5), maaddr1 varchar(50), maaddr2 varchar(50), 
    mppoint int, mpcontent varchar(50))
begin
	insert into t_member_info (mi_id, mi_pwd, mi_name, mi_birth, mi_gender, mi_phone, 
		mi_email, mi_issns, mi_ismail, mi_point, mi_rebank, mi_account, mi_recommend)
	values (miid, mipwd, miname, mibirth, migender, miphone, miemail, miissns, 
		miismail, mipoint, mirebank, miaccount, mirecommend);

	insert into t_member_addr (mi_id, ma_zip, ma_addr1, ma_addr2) 
    values (miid, mazip, maaddr1, maaddr2);

	insert into t_member_point (mi_id, mp_point, mp_content) 
    values (miid, mppoint, mpcontent);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_member_out` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_member_out`(miid varchar(20), miisactive char(1))
begin
	update t_member_info set mi_isactive = miisactive where mi_id = miid;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_member_password` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_member_password`(miid varchar(20), mipwd varchar(20))
begin
	update t_member_info set mi_pwd = mipwd where mi_id = miid;
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
/*!50003 DROP PROCEDURE IF EXISTS `sp_mem_addr_insert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_mem_addr_insert`(miid varchar(20), mazip char(5), 
	maaddr1 varchar(50), maaddr2 varchar(50), mabasic char(1))
begin
	if mabasic = 'y' then	-- 추가하려는 주소를 기본주소로 할 경우
		update t_member_addr set ma_basic = 'n' where mi_id = miid and ma_basic = 'y';
        -- 기존의 기본주소를 일반주소로 변경한 후 추가해야 함
    end if;

	insert into t_member_addr (mi_id, ma_zip, ma_addr1, ma_addr2, ma_basic) 
    values (miid, mazip, maaddr1, maaddr2, mabasic);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_mem_addr_update` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_mem_addr_update`(maidx int, miid varchar(20), mazip char(5), 
	maaddr1 varchar(50), maaddr2 varchar(50), mabasic char(1))
begin
	if mabasic = 'y' then	-- 변경하려는 주소를 기본주소로 할 경우
		update t_member_addr set ma_basic = 'n' where mi_id = miid and ma_basic = 'y';
        -- 기존의 기본주소를 일반주소로 변경한 후 추가해야 함
    end if;
	update t_member_addr set ma_zip = mazip, ma_addr1 = maaddr1, ma_addr2 = maaddr2, 
		ma_basic = mabasic where ma_idx = maidx and mi_id = miid;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_order_insert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_order_insert`(miid varchar(20), oiname varchar(20), oiphone varchar(13), oizip char(5), 
	oiaddr1 varchar(50), oiaddr2 varchar(50), oipayment char(1), oipay int, oiusepnt int, oidelipay int, 
	oistatus char(1), oicmt varchar(100), piid char(6), odpdtname varchar(20), odpdtimg varchar(50), 
	odpdtprice int, odcnt int, odoption varchar(10), ocidxs varchar(50))
begin
	declare oiid char(10);
	declare end_row boolean default false;
	declare cpiid char(6);			-- 쇼핑 카트내 상품id를 저장할 변수
	declare coption varchar(10);	-- 쇼핑 카트내 상품옵션을 저장할 변수
	declare ccnt int;				-- 쇼핑 카트내 상품개수를 저장할 변수
	declare cname varchar(20);		-- 쇼핑 카트내 상품이름을 저장할 변수
	declare cimg varchar(50);		-- 쇼핑 카트내 상품이미지를 저장할 변수
	declare cprice int;				-- 쇼핑 카트내 상품단가를 저장할 변수
	declare c_set cursor for
		select a.pi_id, a.oc_option, a.oc_cnt, b.pi_name, b.pi_img1, b.pi_price 
		from t_order_cart a, t_product_info b where a.pi_id = b.pi_id and a.oc_idx in (ocidxs);
        -- 구매하려는 목록을 카트에서 추출하여 커서로 생성
	declare continue handler for not found set end_row = true;

	-- 새 주문번호 생성
	select if(count(oi_id) = 0, concat(right(replace(date(now()), '-', ''), 6), '1000'), oi_id) + 1 into oiid 
	from t_order_info where date(oi_date) = curdate() order by oi_id desc limit 1;

	-- 주문 정보 등록 쿼리
	insert into t_order_info (oi_id, mi_id, oi_name, oi_phone, oi_zip, oi_addr1, oi_addr2, oi_payment, 
		oi_pay, oi_usepnt, oi_delipay, oi_status, oi_cmt) values (oiid, miid, oiname, oiphone, oizip, 
		oiaddr1, oiaddr2, oipayment, oipay, oiusepnt, oidelipay, oistatus, oicmt);

	-- 포인트 사용내역 등록 및 보유포인트 변경 쿼리
    if oiusepnt > 0 then -- 주문시 포인트를 사용했을 경우
    begin
		insert into t_member_point (mi_id, mp_kind, mp_point, mp_linknum, mp_content) 
		values (miid, 'u', oiusepnt, oiid, '주문시 사용');

		update t_member_info set mi_point = mi_point - oiusepnt where mi_id = miid;
	end;
	end if;

	if ocidxs = '0' then -- 바로 구매로 구매시
	begin
		-- 주문 상세 등록 쿼리
		insert into t_order_detail (oi_id, pi_id, od_pdtname, od_pdtimg, od_pdtprice, od_cnt, od_option) 
		values (oiid, piid, odpdtname, odpdtimg, odpdtprice, odcnt, odoption);
		-- 상품 판매개수 및 재고량 변경 쿼리
		update t_product_info set pi_salecnt = pi_salecnt + odcnt, 
		pi_stock = pi_stock - if(pi_stock = -1, 0, odcnt) where pi_id = piid;
	end;
	else -- 쇼핑카트를 통해 구매시
    begin
        open c_set; -- c_set이라는 커서를 열어줌
		lblLoop:while true do
			fetch c_set into cpiid, coption, ccnt, cname, cimg, cprice; -- 커서내에 있는 데이터들을 차례대로 변수에 저장
			if end_row then
				leave lblLoop;
			end if;
			-- 주문 상세 등록 쿼리
			insert into t_order_detail (oi_id, pi_id, od_pdtname, od_pdtimg, od_pdtprice, od_cnt, od_option) 
			values (oiid, cpiid, cname, cimg, cprice, ccnt, coption);
			-- 상품 판매개수 및 재고량 변경 쿼리
			update t_product_info set pi_salecnt = pi_salecnt + ccnt, 
			pi_stock = pi_stock - if(pi_stock = -1, 0, ccnt) where pi_id = cpiid;
		end while;

		-- 쇼핑카트에서 구매한 상품 삭제 쿼리
		delete from t_order_cart where oc_idx in (ocidxs);
		close c_set;
	end;
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_pdt_cata_insert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_pdt_cata_insert`(kind char(1), 
	cbid char(2), cbname varchar(20), csid char(4), csname varchar(20))
begin
	if kind = 'b' then	-- 대분류 등록이면
		insert into t_cata_big values (cbid, cbname);
    else	-- 소분류 등록이면
		insert into t_cata_small values (csid, cbid, csname);
    end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_pdt_cata_update` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_pdt_cata_update`(kind char(1), 
	cbid char(2), cbname varchar(20), csid char(4), csname varchar(20))
begin
	if kind = 'b' then	-- 대분류 수정이면
		update t_cata_big set cb_name = cbname where cb_id = cbid;
    else	-- 소분류 수정이면
		update t_cata_small set cb_id = cbid, cs_name = csname where cs_id = csid;
    end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_poll_result_insert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_poll_result_insert`(pqidx int, miid varchar(20), prex int)
begin
	-- 현재 진행중인 설문인지 여부를 검사 후 참여시킴
	declare pqstatus char(1);
	select pq_status into pqstatus from t_poll_question where pq_idx = pqidx;
    if pqstatus = 'b' then
    	insert into t_poll_result (pq_idx, mi_id, pr_ex) values (pqidx, miid, prex);
	end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_product_insert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_product_insert`(piid char(6), piname varchar(20), csid char(5), 
	bid char(4), piorigin varchar(20), picost int, piprice int, pidiscount int, 
	pioption varchar(100), piimg1 varchar(50), piimg2 varchar(50), piimg3 varchar(50), 
	pidesc varchar(50), pistock int, piisview char(1), aiidx int)
begin
	insert into t_product_info (pi_id, pi_name, cs_id, b_id, pi_origin, pi_cost, 
		pi_price, pi_discount, pi_option, pi_img1, pi_img2, pi_img3, pi_desc, 
		pi_stock, pi_isview, ai_idx)
	values (piid, piname, csid, bid, piorigin, picost, piprice, pidiscount, pioption, 
		piimg1, piimg2, piimg3, pidesc, pistock, piisview, aiidx);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_product_update` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_product_update`(piid char(6), piname varchar(20), csid char(5), 
	bid char(4), piorigin varchar(20), picost int, piprice int, pidiscount int, 
	pioption varchar(100), piimg1 varchar(50), piimg2 varchar(50), piimg3 varchar(50), 
	pidesc varchar(50), pistock int, piisview char(1))
begin
	update t_product_info set pi_name = piname, cs_id = csid, b_id = bid, 
		pi_origin = piorigin, pi_cost = picost, pi_price = piprice, 
		pi_discount = pidiscount, pi_option = pioption, pi_img1 = piimg1, 
		pi_img2 = piimg2, pi_img3 = piimg3, pi_desc = pidesc, pi_stock = pistock, 
		pi_isview = piisview where pi_id = piid;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_qna_delete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_qna_delete`(bqidx int)
begin
	delete from t_brd_qna where bq_idx = bqidx and bq_status = 'a';
    -- 질문에 대한 수정으로 관리자가 답변을 달기 전에만 삭제가 가능함
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_qna_insert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_qna_insert`(miid varchar(20), 
	bqcata varchar(20), bqtitle varchar(100), bqcontent text, bqimg varchar(50))
begin
	insert into t_brd_qna (mi_id, bq_cata, bq_title, bq_content, bq_img) 
    values (miid, bqcata, bqtitle, bqcontent, bqimg);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_qna_update` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_qna_update`(bqidx int, 
	bqcata varchar(20), bqtitle varchar(100), bqcontent text, bqimg varchar(50))
begin
	update t_brd_qna set bq_cata = bqcata, bq_title = bqtitle, 
	bq_content = bqcontent, bq_img = bqimg where bq_idx = bqidx and bq_status = 'a';
    -- 질문에 대한 수정으로 관리자가 답변을 달기 전에만 수정이 가능함
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_review_911` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_review_911`(bridx int, miid varchar(20), br9content varchar(50))
begin
	insert into t_brd_review_911 (br_idx, mi_id, br9_content) values (bridx, miid, br9content);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_review_delete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_review_delete`(bridx int, piid char(6))
begin
	declare star float; -- 별점 평균을 저장할 변수들
	set star = 0.0; -- 변수 초기화

	update t_brd_review set br_isview = 'n' where br_idx = bridx;
    -- 관리자가 사용자들이 못보게 후기를 수정함(관리자 페이지에서는 보임)

	select avg(br_star) into star from t_brd_review where pi_id = piid and br_isview = 'y';
	-- 해당 상품에 대한 리뷰별점의 평균을 구하여 star변수에 저장(볼수있는 리뷰에서만 추출)

	update t_product_info set pi_star = ifnull(star, 0.0) where pi_id = piid;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_review_insert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_review_insert`(miid varchar(20), oiid char(10), piid char(6), 
brtitle varchar(100), brcontent text, brimg1 varchar(50), brimg2 varchar(50), brstar float)
begin
	declare star float; -- 별점 평균을 저장할 변수들
	set star = 0.0; -- 변수 초기화

	insert into t_brd_review (mi_id, oi_id, pi_id, br_title, br_content, br_img1, br_img2, 
    br_star) values (miid, oiid, piid, brtitle, brcontent, brimg1, brimg2, brstar);

	select avg(br_star) into star from t_brd_review where pi_id = piid and br_isview = 'y';
	-- 해당 상품에 대한 리뷰별점의 평균을 구하여 star변수에 저장(볼수있는 리뷰에서만 추출)

	update t_product_info set pi_star = ifnull(star, 0.0) where pi_id = piid;
    -- 해당 상품의 평점 평균을 변경함(평균값이 null이면 - 리뷰가 없으면 - 0점 처리)
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_review_reply_delete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_review_reply_delete`(brridx int, bridx int, miid varchar(20))
begin
	update t_brd_review_reply set brr_isview = 'n' where brr_idx = brridx and mi_id = miid;

	update t_brd_review set br_cnt = br_cnt - 1 where br_idx = bridx;
	-- 리뷰 테이블의 댓글 개수를 1감소 시킴
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_review_reply_insert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_review_reply_insert`(bridx int, miid varchar(20), brrcontent text)
begin
	insert into t_brd_review_reply (br_idx, mi_id, brr_content )
	values (bridx, miid, brrcontent );

	update t_brd_review set br_cnt = br_cnt + 1 where br_idx = bridx;
	-- 리뷰 테이블의 댓글 개수를 1증가 시킴
    
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_review_reply_update` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_review_reply_update`(brridx int, miid varchar(20), brrcontent text)
begin
	update t_brd_review_reply set brr_content = brrcontent 
	where brr_idx = brridx and mi_id = miid;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_review_star` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_review_star`(miid varchar(20), bridx int, brsscore float)
begin
	declare score float; -- 평점 평균을 저장할 변수들
	set score = 0.0; -- 변수 초기화

	insert into t_brd_review_star (mi_id, br_idx, brs_score) values (miid, bridx, brsscore);

	select avg(brs_score) into score from t_brd_review_star where br_idx = bridx;
	-- 해당 리뷰에 대한 평점의 평균을 구하여 score변수에 저장

	update t_brd_review set br_score = ifnull(score, 0.0) where br_idx = bridx;
    -- 해당 리뷰의 평점 평균을 변경함(평균값이 null이면 0점 처리)
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_review_update` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_review_update`(bridx int, brtitle varchar(100), brcontent text, 
	brimg1 varchar(50), brimg2 varchar(50))
begin
	update t_brd_review set br_title = brtitle, br_content = brcontent, br_img1 = brimg1, 
		br_img2 = brimg2 where br_idx = bridx and br_cnt = 0;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `v_cart_list`
--

/*!50001 DROP VIEW IF EXISTS `v_cart_list`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_cart_list` AS select `a`.`pi_id` AS `pi_id`,`a`.`pi_price` AS `pi_price`,`a`.`pi_discount` AS `pi_discount`,`b`.`oc_cnt` AS `oc_cnt`,`a`.`pi_option` AS `pi_option`,`b`.`oc_option` AS `oc_option`,`a`.`pi_name` AS `pi_name`,`a`.`pi_img1` AS `pi_img1` from (`t_product_info` `a` join `t_order_cart` `b`) where (`a`.`pi_id` = `b`.`pi_id`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_order_list`
--

/*!50001 DROP VIEW IF EXISTS `v_order_list`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_order_list` AS select `a`.`oi_id` AS `oi_id`,`a`.`mi_id` AS `mi_id`,`b`.`pi_id` AS `pi_id`,`b`.`od_pdtimg` AS `od_pdtimg`,`b`.`od_pdtname` AS `od_pdtname`,`b`.`od_option` AS `od_option`,`b`.`od_cnt` AS `od_cnt`,`a`.`oi_pay` AS `oi_pay`,`a`.`oi_date` AS `oi_date`,`a`.`oi_status` AS `oi_status`,`c`.`pi_isview` AS `pi_isview`,`c`.`pi_stock` AS `pi_stock`,`d`.`cb_id` AS `cb_id`,`d`.`cb_name` AS `cb_name`,`c`.`cs_id` AS `cs_id`,`e`.`cs_name` AS `cs_name`,`c`.`b_id` AS `b_id`,`f`.`b_name` AS `b_name` from (((((`t_order_info` `a` join `t_order_detail` `b`) join `t_product_info` `c`) join `t_cata_big` `d`) join `t_cata_small` `e`) join `t_brand` `f`) where ((`a`.`oi_id` = `b`.`oi_id`) and (`b`.`pi_id` = `c`.`pi_id`) and (`d`.`cb_id` = `e`.`cb_id`) and (`e`.`cs_id` = `c`.`cs_id`) and (`f`.`b_id` = `c`.`b_id`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_review_list`
--

/*!50001 DROP VIEW IF EXISTS `v_review_list`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_review_list` AS select `a`.`br_idx` AS `br_idx`,`a`.`mi_id` AS `mi_id`,concat(`a`.`br_title`,' - ',`c`.`od_option`) AS `title`,`a`.`br_date` AS `br_date`,`a`.`br_star` AS `br_star`,`a`.`br_img1` AS `br_img1`,`b`.`pi_name` AS `pi_name` from ((`t_brd_review` `a` join `t_product_info` `b`) join `t_order_detail` `c`) where ((`a`.`pi_id` = `b`.`pi_id`) and (`a`.`oi_id` = `c`.`oi_id`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-28 18:10:04
