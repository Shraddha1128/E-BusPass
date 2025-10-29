-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 29, 2025 at 07:49 AM
-- Server version: 8.0.27
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pbl24`
--

-- --------------------------------------------------------

--
-- Table structure for table `studentinfo`
--

DROP TABLE IF EXISTS `studentinfo`;
CREATE TABLE IF NOT EXISTS `studentinfo` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(100) NOT NULL,
  `MiddleName` varchar(100) NOT NULL,
  `LastName` varchar(100) NOT NULL,
  `CollegeName` varchar(100) NOT NULL,
  `CollegeId` varchar(100) NOT NULL,
  `BirthDate` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `StartDate` varchar(100) NOT NULL,
  `EndDate` varchar(100) NOT NULL,
  `Year` varchar(100) NOT NULL,
  `BusNo` varchar(100) NOT NULL,
  `BusRoute` varchar(100) NOT NULL,
  `TAddress` varchar(100) NOT NULL,
  `PAddress` varchar(100) NOT NULL,
  `UploadCollegeId` varchar(100) NOT NULL,
  `Bonafide` varchar(100) NOT NULL,
  `CollegeReciept` varchar(100) NOT NULL,
  `CollegeBusReciept` varchar(100) NOT NULL,
  `AadharCard` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Photo` varchar(100) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `studentinfo`
--

INSERT INTO `studentinfo` (`Id`, `FirstName`, `MiddleName`, `LastName`, `CollegeName`, `CollegeId`, `BirthDate`, `Email`, `StartDate`, `EndDate`, `Year`, `BusNo`, `BusRoute`, `TAddress`, `PAddress`, `UploadCollegeId`, `Bonafide`, `CollegeReciept`, `CollegeBusReciept`, `AadharCard`, `Photo`) VALUES
(1, 'Vispute', 'Chinmay', 'Manoj', 'K.K.WaghCollege', 'S372213102', '2004-04-28', 'chinmayvispute58@gmail.com', '2025-06-29', '2025-09-29', '4', '102', 'Jail Road', 'Aurangabad', 'Aurangabad', 'AadharCard.pdf', 'Bonafide.pdf', 'college', 'college', 'AadharCard.pdf', 'photo.jpeg');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
