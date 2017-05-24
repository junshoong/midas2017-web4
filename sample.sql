-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.1.23-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- sample 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `sample` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sample`;

-- 테이블 sample.board 구조 내보내기
CREATE TABLE IF NOT EXISTS `BOARD` (
  `AR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `SBJ` varchar(50) NOT NULL,
  `CONT` text NOT NULL,
  `WRITER` varchar(50) NOT NULL,
  `CRT_DT` date NOT NULL,
  `MDFY_DT` date NOT NULL,
  `RD_CNT` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`AR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8;

-- 테이블 데이터 sample.board:~0 rows (대략적) 내보내기
DELETE FROM `BOARD`;
/*!40000 ALTER TABLE `BOARD` DISABLE KEYS */;
INSERT INTO `BOARD` (`AR_ID`, `SBJ`, `CONT`, `WRITER`, `CRT_DT`, `MDFY_DT`, `RD_CNT`) VALUES
	(100, '아몰라', 'ㅋㅋㅋㅋ', '누굴까', '2017-05-23', '2017-05-23', 0),
	(101, 'ㅋㅋㅋㅋㅋㅋ', '<p>This is my textarea to be replaced with CKEditor. ㅋㅋㅋㅋㅋ</p>\r\n', '최성진', '2017-05-23', '2017-05-23', 0),
	(102, 'ㅗㅎ론', '<p>This is my textarㅗㄹ온ea to be replaced with CKㅗㄴ로ㅗEditor.</p>\r\n', '', '2017-05-23', '2017-05-23', 0),
	(103, 'ㅗㄴㅇ롤ㅇ', '<p>This is my textarea to be replaced wㅗㄹ온오오ith CKEditor.</p>\r\n', '', '2017-05-23', '2017-05-23', 0),
	(104, 'ㅗㄹ온ㅇ', '<p>This is my textarea to be replacㅗㅇㄹ노오ed with CKEditor.</p>\r\n', '', '2017-05-23', '2017-05-23', 0),
	(105, 'ㅗㄹ옹', '<p>This is my textarea to be replaced ㅗㅗㅇ로옹with CKEditor.</p>\r\n', '', '2017-05-23', '2017-05-23', 0),
	(106, 'ㅗㄹ온', '<p>This is my textarea to be replacㅗㄹㅇ노옹ed with CKEditor.</p>\r\n', '', '2017-05-23', '2017-05-23', 0),
	(107, 'ㅗㄹㅇ노ㅗ', '<p>This is my textarea to be replaced 농롱노with CKEditor.</p>\r\n', '', '2017-05-23', '2017-05-23', 0),
	(108, 'ㅗㅇㄴ론오', '<p>This is my textarea to be replaced witㅗ오옹h CKEditor.</p>\r\n', '', '2017-05-23', '2017-05-23', 0),
	(109, 'ㅗㄹ노', '<p>This is my textarea to be rㅗㄹㅇ노오heplaced with CKEditor.</p>\r\n', '', '2017-05-23', '2017-05-23', 0),
	(110, 'ㅗ론ㅇ', '<p>This is my textarea to be reㅇ농ㄹ논ㅇhplaced with CKEditor.</p>\r\n', '', '2017-05-23', '2017-05-23', 0),
	(111, 'ㅗㄹ논오', '<p>This is my textarea tㅇ농농ㄴo be replaced with CKEditor.</p>\r\n', '', '2017-05-23', '2017-05-23', 0),
	(112, 'dasddsa', '<p>This is my textarea todasdad be replaced with CKEditor.</p>\r\n', '최성진', '2017-05-23', '2017-05-23', 0);
/*!40000 ALTER TABLE `BOARD` ENABLE KEYS */;

-- 테이블 sample.usrs 구조 내보내기
CREATE TABLE IF NOT EXISTS `USRS` (
  `USR_ID` varchar(50) DEFAULT NULL,
  `USR_NM` varchar(50) DEFAULT NULL,
  `USR_PWD` varchar(50) DEFAULT NULL,
  `JOIN_DT` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 sample.usrs:~2 rows (대략적) 내보내기
DELETE FROM `USRS`;
/*!40000 ALTER TABLE `USRS` DISABLE KEYS */;
INSERT INTO `USRS` (`USR_ID`, `USR_NM`, `USR_PWD`, `JOIN_DT`) VALUES
	('hi', 'choi', 'hi', '2017-05-21'),
	('choi', '최성진', 'choi', '2017-05-23');
/*!40000 ALTER TABLE `USRS` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;