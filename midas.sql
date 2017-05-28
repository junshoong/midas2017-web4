/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE TABLE IF NOT EXISTS `food` (
  `FOOD_NO` int(11) NOT NULL AUTO_INCREMENT COMMENT '음식번호',
  `FOOD_NAME` varchar(50) NOT NULL DEFAULT '0' COMMENT '메뉴 이름',
  `FOOD_CAL` int(11) NOT NULL DEFAULT '0' COMMENT '칼로리',
  `FOOD_KIND` int(11) NOT NULL DEFAULT '0' COMMENT '메뉴 구분 (10: 밥 20: 국 30: 반찬)',
  PRIMARY KEY (`FOOD_NO`),
  UNIQUE KEY `FOOD_NAME` (`FOOD_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=293 DEFAULT CHARSET=utf8 COMMENT='음식';

DELETE FROM `food`;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
INSERT INTO `food` (`FOOD_NO`, `FOOD_NAME`, `FOOD_CAL`, `FOOD_KIND`) VALUES
	(1, '밥', 200, 10),
	(2, '미역국', 200, 20),
	(3, '장어', 100, 30),
	(4, '두부', 100, 30),
	(5, '제육볶음', 300, 30),
	(6, '콩밥', 240, 10),
	(7, '순두부찌개', 200, 20),
	(8, '오징어볶음', 200, 30),
	(36, '콩자반', 266, 30),
	(38, '파김치', 199, 30),
	(42, '버섯구이', 223, 30),
	(47, '김치찌개', 300, 20),
	(50, '호박전', 321, 30),
	(55, '오징어튀김', 285, 30),
	(68, '김치볶음밥', 300, 10),
	(69, '된장찌개', 100, 20),
	(71, '멸치볶음', 200, 30),
	(73, '현미밥', 200, 10),
	(76, '케이크', 200, 30),
	(77, '김치', 150, 30),
	(83, '볶음밥', 100, 10),
	(86, '단무지', 200, 30),
	(92, '미역줄기', 500, 30),
	(113, '국밥', 450, 10),
	(115, '샐러드', 60, 30),
	(117, '청경채볶음', 130, 30),
	(141, '동치미', 300, 30),
	(142, '도토리묵', 321, 30),
	(281, '김말이', 300, 30);
/*!40000 ALTER TABLE `food` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `food_set` (
  `MENU_NO` int(11) NOT NULL COMMENT '식단번호 (FK)',
  `FOOD_NO` int(11) NOT NULL COMMENT '음식번호 (FK)',
  PRIMARY KEY (`MENU_NO`,`FOOD_NO`),
  KEY `FK_food_set_food` (`FOOD_NO`),
  CONSTRAINT `FK_food_set_food` FOREIGN KEY (`FOOD_NO`) REFERENCES `food` (`FOOD_NO`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_food_set_menu` FOREIGN KEY (`MENU_NO`) REFERENCES `menu` (`MENU_NO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='음식 세트';

DELETE FROM `food_set`;
/*!40000 ALTER TABLE `food_set` DISABLE KEYS */;
INSERT INTO `food_set` (`MENU_NO`, `FOOD_NO`) VALUES
	(1, 1),
	(1, 2),
	(1, 3),
	(1, 4),
	(1, 36),
	(2, 5),
	(2, 6),
	(2, 7),
	(2, 8),
	(2, 38),
	(3, 1),
	(3, 5),
	(3, 47),
	(3, 50),
	(3, 92),
	(4, 2),
	(4, 3),
	(4, 5),
	(4, 6),
	(4, 8),
	(16, 6),
	(16, 7),
	(16, 38),
	(16, 50),
	(16, 55),
	(21, 2),
	(21, 71),
	(21, 73),
	(21, 77),
	(21, 86),
	(22, 36),
	(22, 50),
	(22, 69),
	(22, 71),
	(22, 83),
	(23, 38),
	(23, 42),
	(23, 113),
	(23, 115),
	(23, 117),
	(24, 1),
	(24, 42),
	(24, 50),
	(24, 55),
	(24, 69),
	(25, 47),
	(25, 73),
	(25, 77),
	(25, 141),
	(25, 142),
	(26, 1),
	(26, 8),
	(26, 69),
	(26, 77),
	(26, 281),
	(27, 2),
	(27, 3),
	(27, 4),
	(27, 71),
	(27, 83),
	(30, 2),
	(30, 3),
	(30, 4),
	(30, 8),
	(30, 68);
/*!40000 ALTER TABLE `food_set` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `log` (
  `USR_NO` int(11) NOT NULL COMMENT '회원번호 (FK)',
  `MENU_NO` int(11) NOT NULL COMMENT '식단번호 (FK)',
  `LIKE` tinyint(1) NOT NULL,
  PRIMARY KEY (`USR_NO`,`MENU_NO`),
  KEY `FK_log_menu` (`MENU_NO`),
  CONSTRAINT `FK_log_menu` FOREIGN KEY (`MENU_NO`) REFERENCES `menu` (`MENU_NO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_log_usrs` FOREIGN KEY (`USR_NO`) REFERENCES `usrs` (`USR_NO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='식사 로그';

DELETE FROM `log`;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
INSERT INTO `log` (`USR_NO`, `MENU_NO`, `LIKE`) VALUES
	(3, 2, 1),
	(3, 16, 1),
	(4, 16, 1);
/*!40000 ALTER TABLE `log` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `menu` (
  `MENU_NO` int(11) NOT NULL AUTO_INCREMENT COMMENT '식단번호',
  `MENU_DT` date NOT NULL COMMENT '날짜',
  `MENU_KIND` int(11) NOT NULL COMMENT '구분 10: 아침, 20: 점심, 30: 저녁',
  `MENU_FILE_NAME` varchar(200) DEFAULT NULL COMMENT '이미지 파일명',
  PRIMARY KEY (`MENU_NO`),
  UNIQUE KEY `MENU_DT_MENU_KIND` (`MENU_DT`,`MENU_KIND`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='식단';

DELETE FROM `menu`;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` (`MENU_NO`, `MENU_DT`, `MENU_KIND`, `MENU_FILE_NAME`) VALUES
	(1, '2017-05-27', 20, 'a.jpg'),
	(2, '2017-05-28', 20, 'b.jpg'),
	(3, '2017-05-29', 30, 'c.jpg'),
	(4, '2017-05-22', 10, 'd.jpg'),
	(16, '2017-05-28', 10, 'e.jpg'),
	(21, '2017-05-31', 10, 'f.jpg'),
	(22, '2017-05-31', 20, 'g.jpg'),
	(23, '2017-05-31', 30, 'h.jpg'),
	(24, '2017-05-30', 10, 'i.jpg'),
	(25, '2017-05-30', 20, 'j.jpg'),
	(26, '2017-06-01', 10, 'dd254e4b-f711-43cf-bce8-7c81e7a347082015070601000629100033411_99_20150706143903.jpg'),
	(27, '2017-05-28', 30, '01cc431c-43ca-476c-b58c-3da5e4d08ed7food1.png'),
	(30, '2017-05-27', 30, '5549a438-d175-4693-ba22-50cd8f2b3a50food1.png');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `usrs` (
  `USR_NO` int(11) NOT NULL AUTO_INCREMENT COMMENT '회원번호',
  `USR_ID` varchar(50) NOT NULL COMMENT '아이디 (이메일)',
  `USR_NM` varchar(50) NOT NULL COMMENT '이름',
  `USR_PWD` varchar(50) NOT NULL COMMENT '비밀번호',
  `USR_PM` int(11) NOT NULL COMMENT '권한 10: 관리자, 20: 이용자',
  `JOIN_DT` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일',
  PRIMARY KEY (`USR_NO`),
  UNIQUE KEY `USR_ID` (`USR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='회원';

DELETE FROM `usrs`;
/*!40000 ALTER TABLE `usrs` DISABLE KEYS */;
INSERT INTO `usrs` (`USR_NO`, `USR_ID`, `USR_NM`, `USR_PWD`, `USR_PM`, `JOIN_DT`) VALUES
	(1, 'kwongusgn@gmail.com', '권현후', 'test', 20, '2017-05-27 11:34:44'),
	(2, 'csj21300@naver.com', '최성진', 'test', 20, '2017-05-27 11:35:56'),
	(3, 'vaporize93@gmail.com', '김준수', 'test', 20, '2017-05-27 11:36:15'),
	(4, 'team.kimkongko@gmail.com', '관리자', 'test', 10, '2017-05-27 11:37:07');
/*!40000 ALTER TABLE `usrs` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
