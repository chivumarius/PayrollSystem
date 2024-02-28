-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 28, 2024 at 09:37 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `payroll_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `id` varchar(20) DEFAULT NULL,
  `date_tm` varchar(30) DEFAULT NULL,
  `f_half` varchar(20) DEFAULT NULL,
  `s_half` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`id`, `date_tm`, `f_half`, `s_half`) VALUES
('0001', '2024-02-27 17:34:27', 'Present', 'Absent'),
('0002', '2024-02-27 17:34:27', 'Present', 'Present'),
('0003', '2024-02-27 17:34:27', 'Absent', 'Present'),
('0004', '2024-02-27 17:34:27', 'Absent', 'Present'),
('0005', '2024-02-27 17:34:27', 'Present', 'Absent'),
('0006', '2024-02-27 17:34:27', 'Absent', 'Present'),
('0007', '2024-02-27 17:34:27', 'Absent', 'Absent'),
('0008', '2024-02-27 17:34:27', 'Absent', 'Present'),
('0009', '2024-02-27 17:34:27', 'Present', 'Present'),
('0010', '2024-02-27 17:34:27', 'Absent', 'Present'),
('0011', '2024-02-27 17:34:27', 'Absent', 'Present'),
('0012', '2024-02-27 17:34:27', 'Absent', 'Present'),
('0013', '2024-02-27 17:34:27', 'Absent', 'Absent'),
('0014', '2024-02-27 17:34:27', 'Absent', 'Absent'),
('0015', '2024-02-27 17:34:27', 'Absent', 'Absent'),
('0016', '2024-02-27 17:34:27', 'Present', 'Present'),
('0017', '2024-02-27 17:34:27', 'Present', 'Present'),
('0018', '2024-02-27 17:34:27', 'Present', 'Present'),
('0019', '2024-02-27 17:34:27', 'Present', 'Present'),
('0020', '2024-02-27 17:34:27', 'Absent', 'Present'),
('0021', '2024-02-27 17:34:27', 'Present', 'Present'),
('0022', '2024-02-27 17:34:27', 'Present', 'Absent'),
('0023', '2024-02-27 17:34:27', 'Absent', 'Absent'),
('0024', '2024-02-27 17:34:27', 'Absent', 'Absent'),
('0025', '2024-02-27 17:34:27', 'Absent', 'Absent'),
('0026', '2024-02-27 17:34:27', 'Present', 'Present'),
('0027', '2024-02-27 17:34:27', 'Present', 'Present'),
('0028', '2024-02-27 17:34:27', 'Present', 'Absent'),
('0029', '2024-02-27 17:34:27', 'Absent', 'Present'),
('0030', '2024-02-27 17:34:27', 'Present', 'Present'),
('0031', '2024-02-27 17:34:27', 'Present', 'Absent'),
('0032', '2024-02-27 17:34:27', 'Absent', 'Present'),
('0033', '2024-02-27 17:34:27', 'Present', 'Absent'),
('0034', '2024-02-27 17:34:27', 'Present', 'Absent'),
('0035', '2024-02-27 17:34:27', 'Present', 'Present'),
('0036', '2024-02-27 17:34:27', 'Present', 'Present'),
('0037', '2024-02-27 17:34:27', 'Absent', 'Present'),
('0038', '2024-02-27 17:34:27', 'Absent', 'Absent'),
('0039', '2024-02-27 17:34:27', 'Present', 'Present'),
('0040', '2024-02-27 17:34:27', 'Absent', 'Present'),
('0041', '2024-02-27 17:34:27', 'Absent', 'Absent'),
('0042', '2024-02-27 17:34:27', 'Absent', 'Absent'),
('0043', '2024-02-27 17:34:27', 'Absent', 'Present'),
('0044', '2024-02-27 17:34:27', 'Absent', 'Absent'),
('0045', '2024-02-27 17:34:27', 'Present', 'Absent'),
('0046', '2024-02-27 17:34:27', 'Absent', 'Present'),
('0047', '2024-02-27 17:34:27', 'Absent', 'Absent'),
('0048', '2024-02-27 17:34:27', 'Absent', 'Present'),
('0049', '2024-02-27 17:34:27', 'Absent', 'Absent'),
('0050', '2024-02-27 17:34:27', 'Absent', 'Absent'),
('0051', '2024-02-27 17:34:27', 'Present', 'Present'),
('0052', '2024-02-27 17:34:27', 'Present', 'Absent'),
('0053', '2024-02-27 17:34:27', 'Present', 'Present'),
('0054', '2024-02-27 17:34:27', 'Present', 'Present'),
('0055', '2024-02-27 17:34:27', 'Present', 'Absent'),
('0056', '2024-02-27 17:34:27', 'Present', 'Absent'),
('0057', '2024-02-27 17:34:27', 'Absent', 'Absent'),
('0058', '2024-02-27 17:34:27', 'Absent', 'Present'),
('0059', '2024-02-27 17:34:27', 'Present', 'Absent'),
('0060', '2024-02-27 17:34:27', 'Absent', 'Present'),
('0061', '2024-02-27 17:34:27', 'Absent', 'Absent'),
('0062', '2024-02-27 17:34:27', 'Present', 'Absent'),
('0063', '2024-02-27 17:34:27', 'Present', 'Present'),
('0064', '2024-02-27 17:34:27', 'Absent', 'Absent'),
('0065', '2024-02-27 17:34:27', 'Present', 'Absent'),
('0066', '2024-02-27 17:34:27', 'Present', 'Absent'),
('0067', '2024-02-27 17:34:27', 'Absent', 'Present'),
('0068', '2024-02-27 17:34:27', 'Present', 'Present'),
('0069', '2024-02-27 17:34:27', 'Present', 'Absent'),
('0070', '2024-02-27 17:34:27', 'Present', 'Present'),
('0071', '2024-02-27 17:34:27', 'Absent', 'Present'),
('0072', '2024-02-27 17:34:27', 'Absent', 'Present'),
('0073', '2024-02-27 17:34:27', 'Present', 'Absent'),
('0074', '2024-02-27 17:34:27', 'Absent', 'Absent'),
('0075', '2024-02-27 17:34:27', 'Present', 'Absent'),
('0076', '2024-02-27 17:34:27', 'Present', 'Absent'),
('0077', '2024-02-27 17:34:27', 'Present', 'Absent'),
('0078', '2024-02-27 17:34:27', 'Present', 'Present'),
('0079', '2024-02-27 17:34:27', 'Absent', 'Present'),
('0080', '2024-02-27 17:34:27', 'Present', 'Present'),
('0081', '2024-02-27 17:34:27', 'Absent', 'Absent'),
('0082', '2024-02-27 17:34:27', 'Absent', 'Absent'),
('0083', '2024-02-27 17:34:27', 'Present', 'Absent'),
('0084', '2024-02-27 17:34:27', 'Absent', 'Present'),
('0085', '2024-02-27 17:34:27', 'Absent', 'Absent'),
('0086', '2024-02-27 17:34:27', 'Absent', 'Present'),
('0087', '2024-02-27 17:34:27', 'Absent', 'Absent'),
('0088', '2024-02-27 17:34:27', 'Present', 'Absent'),
('0089', '2024-02-27 17:34:27', 'Absent', 'Present'),
('0090', '2024-02-27 17:34:27', 'Present', 'Absent'),
('0091', '2024-02-27 17:34:27', 'Absent', 'Present'),
('0092', '2024-02-27 17:34:27', 'Absent', 'Present'),
('0093', '2024-02-27 17:34:27', 'Absent', 'Present'),
('0094', '2024-02-27 17:34:27', 'Present', 'Absent'),
('0095', '2024-02-27 17:34:27', 'Absent', 'Present'),
('0096', '2024-02-27 17:34:27', 'Present', 'Absent'),
('0097', '2024-02-27 17:34:27', 'Present', 'Present'),
('0098', '2024-02-27 17:34:27', 'Present', 'Present'),
('0099', '2024-02-27 17:34:27', 'Absent', 'Absent'),
('0100', '2024-02-27 17:34:27', 'Absent', 'Present'),
('0101', 'Tue Feb 27 17:36:53 EET 2024', 'Present', 'Present'),
('0102', 'Wed Feb 28 10:10:12 EET 2024', 'Present', 'Absent');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` varchar(20) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `gender` varchar(30) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `state` varchar(30) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `name`, `gender`, `address`, `state`, `city`, `email`, `phone`) VALUES
('0001', 'Name1', 'Male', 'Address1', 'State1', 'City1', 'name1@gmail.com', '+40738533150'),
('0002', 'Name2', 'Male', 'Address2', 'State2', 'City2', 'name2@gmail.com', '+40759270595'),
('0003', 'Name3', 'Female', 'Address3', 'State3', 'City3', 'name3@gmail.com', '+40779342991'),
('0004', 'Name4', 'Female', 'Address4', 'State4', 'City4', 'name4@gmail.com', '+40774081503'),
('0005', 'Name5', 'Male', 'Address5', 'State5', 'City5', 'name5@gmail.com', '+40793461680'),
('0006', 'Name6', 'Male', 'Address6', 'State6', 'City6', 'name6@gmail.com', '+40709038418'),
('0007', 'Name7', 'Female', 'Address7', 'State7', 'City7', 'name7@gmail.com', '+40730574848'),
('0008', 'Name8', 'Female', 'Address8', 'State8', 'City8', 'name8@gmail.com', '+40799576381'),
('0009', 'Name9', 'Female', 'Address9', 'State9', 'City9', 'name9@gmail.com', '+40716777647'),
('0010', 'Name10', 'Male', 'Address10', 'State10', 'City10', 'name10@gmail.com', '+40722587888'),
('0011', 'Name11', 'Female', 'Address11', 'State11', 'City11', 'name11@gmail.com', '+40778171086'),
('0012', 'Name12', 'Female', 'Address12', 'State12', 'City12', 'name12@gmail.com', '+40781959673'),
('0013', 'Name13', 'Male', 'Address13', 'State13', 'City13', 'name13@gmail.com', '+40753694039'),
('0014', 'Name14', 'Female', 'Address14', 'State14', 'City14', 'name14@gmail.com', '+40782549727'),
('0015', 'Name15', 'Female', 'Address15', 'State15', 'City15', 'name15@gmail.com', '+40785198487'),
('0016', 'Name16', 'Female', 'Address16', 'State16', 'City16', 'name16@gmail.com', '+40775823744'),
('0017', 'Name17', 'Female', 'Address17', 'State17', 'City17', 'name17@gmail.com', '+40773864786'),
('0018', 'Name18', 'Female', 'Address18', 'State18', 'City18', 'name18@gmail.com', '+40721017269'),
('0019', 'Name19', 'Male', 'Address19', 'State19', 'City19', 'name19@gmail.com', '+40734545079'),
('0020', 'Name20', 'Male', 'Address20', 'State20', 'City20', 'name20@gmail.com', '+40767201102'),
('0021', 'Name21', 'Male', 'Address21', 'State21', 'City21', 'name21@gmail.com', '+40765915257'),
('0022', 'Name22', 'Male', 'Address22', 'State22', 'City22', 'name22@gmail.com', '+40747579992'),
('0023', 'Name23', 'Female', 'Address23', 'State23', 'City23', 'name23@gmail.com', '+40710782566'),
('0024', 'Name24', 'Male', 'Address24', 'State24', 'City24', 'name24@gmail.com', '+40776648859'),
('0025', 'Name25', 'Male', 'Address25', 'State25', 'City25', 'name25@gmail.com', '+40759285252'),
('0026', 'Name26', 'Female', 'Address26', 'State26', 'City26', 'name26@gmail.com', '+40736580102'),
('0027', 'Name27', 'Male', 'Address27', 'State27', 'City27', 'name27@gmail.com', '+40761454692'),
('0028', 'Name28', 'Male', 'Address28', 'State28', 'City28', 'name28@gmail.com', '+40738418262'),
('0029', 'Name29', 'Female', 'Address29', 'State29', 'City29', 'name29@gmail.com', '+40776854789'),
('0030', 'Name30', 'Male', 'Address30', 'State30', 'City30', 'name30@gmail.com', '+40714476654'),
('0031', 'Name31', 'Male', 'Address31', 'State31', 'City31', 'name31@gmail.com', '+40783363365'),
('0032', 'Name32', 'Female', 'Address32', 'State32', 'City32', 'name32@gmail.com', '+40753614077'),
('0033', 'Name33', 'Female', 'Address33', 'State33', 'City33', 'name33@gmail.com', '+40768397209'),
('0034', 'Name34', 'Female', 'Address34', 'State34', 'City34', 'name34@gmail.com', '+40717020318'),
('0035', 'Name35', 'Female', 'Address35', 'State35', 'City35', 'name35@gmail.com', '+40707811188'),
('0036', 'Name36', 'Female', 'Address36', 'State36', 'City36', 'name36@gmail.com', '+40795229742'),
('0037', 'Name37', 'Male', 'Address37', 'State37', 'City37', 'name37@gmail.com', '+40739064433'),
('0038', 'Name38', 'Female', 'Address38', 'State38', 'City38', 'name38@gmail.com', '+40785156588'),
('0039', 'Name39', 'Female', 'Address39', 'State39', 'City39', 'name39@gmail.com', '+40766395312'),
('0040', 'Name40', 'Male', 'Address40', 'State40', 'City40', 'name40@gmail.com', '+40795101674'),
('0041', 'Name41', 'Male', 'Address41', 'State41', 'City41', 'name41@gmail.com', '+40709374021'),
('0042', 'Name42', 'Male', 'Address42', 'State42', 'City42', 'name42@gmail.com', '+40722191375'),
('0043', 'Name43', 'Male', 'Address43', 'State43', 'City43', 'name43@gmail.com', '+40737269973'),
('0044', 'Name44', 'Female', 'Address44', 'State44', 'City44', 'name44@gmail.com', '+40708407147'),
('0045', 'Name45', 'Female', 'Address45', 'State45', 'City45', 'name45@gmail.com', '+40724306067'),
('0046', 'Name46', 'Female', 'Address46', 'State46', 'City46', 'name46@gmail.com', '+40786150977'),
('0047', 'Name47', 'Female', 'Address47', 'State47', 'City47', 'name47@gmail.com', '+40718113997'),
('0048', 'Name48', 'Male', 'Address48', 'State48', 'City48', 'name48@gmail.com', '+40768807181'),
('0049', 'Name49', 'Male', 'Address49', 'State49', 'City49', 'name49@gmail.com', '+40744310495'),
('0050', 'Name50', 'Male', 'Address50', 'State50', 'City50', 'name50@gmail.com', '+40722634802'),
('0051', 'Name51', 'Male', 'Address51', 'State51', 'City51', 'name51@gmail.com', '+40731266828'),
('0052', 'Name52', 'Male', 'Address52', 'State52', 'City52', 'name52@gmail.com', '+40790356533'),
('0053', 'Name53', 'Female', 'Address53', 'State53', 'City53', 'name53@gmail.com', '+40735372703'),
('0054', 'Name54', 'Female', 'Address54', 'State54', 'City54', 'name54@gmail.com', '+40758872592'),
('0055', 'Name55', 'Male', 'Address55', 'State55', 'City55', 'name55@gmail.com', '+40700224957'),
('0056', 'Name56', 'Female', 'Address56', 'State56', 'City56', 'name56@gmail.com', '+40774420887'),
('0057', 'Name57', 'Male', 'Address57', 'State57', 'City57', 'name57@gmail.com', '+40711972266'),
('0058', 'Name58', 'Male', 'Address58', 'State58', 'City58', 'name58@gmail.com', '+40757685114'),
('0059', 'Name59', 'Female', 'Address59', 'State59', 'City59', 'name59@gmail.com', '+40788266793'),
('0060', 'Name60', 'Female', 'Address60', 'State60', 'City60', 'name60@gmail.com', '+40757903083'),
('0061', 'Name61', 'Male', 'Address61', 'State61', 'City61', 'name61@gmail.com', '+40705757460'),
('0062', 'Name62', 'Female', 'Address62', 'State62', 'City62', 'name62@gmail.com', '+40788264027'),
('0063', 'Name63', 'Female', 'Address63', 'State63', 'City63', 'name63@gmail.com', '+40725199412'),
('0064', 'Name64', 'Female', 'Address64', 'State64', 'City64', 'name64@gmail.com', '+40784412609'),
('0065', 'Name65', 'Male', 'Address65', 'State65', 'City65', 'name65@gmail.com', '+40777044898'),
('0066', 'Name66', 'Female', 'Address66', 'State66', 'City66', 'name66@gmail.com', '+40704139607'),
('0067', 'Name67', 'Female', 'Address67', 'State67', 'City67', 'name67@gmail.com', '+40785248481'),
('0068', 'Name68', 'Female', 'Address68', 'State68', 'City68', 'name68@gmail.com', '+40782464708'),
('0069', 'Name69', 'Male', 'Address69', 'State69', 'City69', 'name69@gmail.com', '+40799593163'),
('0070', 'Name70', 'Female', 'Address70', 'State70', 'City70', 'name70@gmail.com', '+40750087748'),
('0071', 'Name71', 'Male', 'Address71', 'State71', 'City71', 'name71@gmail.com', '+40755328784'),
('0072', 'Name72', 'Male', 'Address72', 'State72', 'City72', 'name72@gmail.com', '+40700457190'),
('0073', 'Name73', 'Female', 'Address73', 'State73', 'City73', 'name73@gmail.com', '+40710727592'),
('0074', 'Name74', 'Male', 'Address74', 'State74', 'City74', 'name74@gmail.com', '+40799709575'),
('0075', 'Name75', 'Female', 'Address75', 'State75', 'City75', 'name75@gmail.com', '+40797933621'),
('0076', 'Name76', 'Male', 'Address76', 'State76', 'City76', 'name76@gmail.com', '+40763352664'),
('0077', 'Name77', 'Female', 'Address77', 'State77', 'City77', 'name77@gmail.com', '+40722298057'),
('0078', 'Name78', 'Female', 'Address78', 'State78', 'City78', 'name78@gmail.com', '+40753489139'),
('0079', 'Name79', 'Male', 'Address79', 'State79', 'City79', 'name79@gmail.com', '+40715611156'),
('0080', 'Name80', 'Female', 'Address80', 'State80', 'City80', 'name80@gmail.com', '+40715209741'),
('0081', 'Name81', 'Female', 'Address81', 'State81', 'City81', 'name81@gmail.com', '+40748484716'),
('0082', 'Name82', 'Female', 'Address82', 'State82', 'City82', 'name82@gmail.com', '+40784321963'),
('0083', 'Name83', 'Female', 'Address83', 'State83', 'City83', 'name83@gmail.com', '+40765754884'),
('0084', 'Name84', 'Male', 'Address84', 'State84', 'City84', 'name84@gmail.com', '+40790445161'),
('0085', 'Name85', 'Male', 'Address85', 'State85', 'City85', 'name85@gmail.com', '+40726664138'),
('0086', 'Name86', 'Male', 'Address86', 'State86', 'City86', 'name86@gmail.com', '+40792612196'),
('0087', 'Name87', 'Male', 'Address87', 'State87', 'City87', 'name87@gmail.com', '+40719654513'),
('0088', 'Name88', 'Male', 'Address88', 'State88', 'City88', 'name88@gmail.com', '+40739926015'),
('0089', 'Name89', 'Female', 'Address89', 'State89', 'City89', 'name89@gmail.com', '+40781703700'),
('0090', 'Name90', 'Female', 'Address90', 'State90', 'City90', 'name90@gmail.com', '+40793036203'),
('0091', 'Name91', 'Female', 'Address91', 'State91', 'City91', 'name91@gmail.com', '+40732354581'),
('0092', 'Name92', 'Female', 'Address92', 'State92', 'City92', 'name92@gmail.com', '+40777411240'),
('0093', 'Name93', 'Male', 'Address93', 'State93', 'City93', 'name93@gmail.com', '+40779622360'),
('0094', 'Name94', 'Male', 'Address94', 'State94', 'City94', 'name94@gmail.com', '+40716123710'),
('0095', 'Name95', 'Female', 'Address95', 'State95', 'City95', 'name95@gmail.com', '+40789749283'),
('0096', 'Name96', 'Male', 'Address96', 'State96', 'City96', 'name96@gmail.com', '+40760123019'),
('0097', 'Name97', 'Female', 'Address97', 'State97', 'City97', 'name97@gmail.com', '+40734593840'),
('0098', 'Name98', 'Male', 'Address98', 'State98', 'City98', 'name98@gmail.com', '+40716175832'),
('0099', 'Name99', 'Male', 'Address99', 'State99', 'City99', 'name99@gmail.com', '+40795996275'),
('0100', 'Name100', 'Female', 'Address100', 'State100', 'City100', 'name100@gmail.com', '+40778346772'),
('0101', 'Name101', 'Male', 'Address101', 'State101', 'City101', 'name101@gmail.com', '+40744332211'),
('0102', 'Name102', 'Female', 'Address102', 'State102', 'City102', 'name102@yahoo.com', '+40700001111');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('admin', '123456');

-- --------------------------------------------------------

--
-- Table structure for table `salary`
--

CREATE TABLE `salary` (
  `id` varchar(20) DEFAULT NULL,
  `house_rent_allowance` varchar(12) DEFAULT NULL,
  `dearness_allowance` varchar(12) DEFAULT NULL,
  `medical_allowance` varchar(12) DEFAULT NULL,
  `provident_fund` varchar(12) DEFAULT NULL,
  `basic_salary` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `salary`
--

INSERT INTO `salary` (`id`, `house_rent_allowance`, `dearness_allowance`, `medical_allowance`, `provident_fund`, `basic_salary`) VALUES
('0001', '30', '19', '7', '1127', '615'),
('0002', '37', '15', '6', '1107', '722'),
('0003', '21', '40', '9', '1180', '905'),
('0004', '49', '38', '6', '1261', '580'),
('0005', '14', '23', '5', '1389', '787'),
('0006', '40', '49', '6', '644', '1360'),
('0007', '44', '40', '3', '1267', '702'),
('0008', '38', '47', '6', '1427', '1498'),
('0009', '18', '12', '7', '583', '968'),
('0010', '13', '11', '9', '993', '1203'),
('0011', '11', '13', '4', '675', '531'),
('0012', '35', '11', '4', '1079', '1368'),
('0013', '34', '26', '3', '1466', '615'),
('0014', '37', '11', '3', '1144', '1269'),
('0015', '46', '20', '6', '748', '904'),
('0016', '20', '16', '9', '918', '649'),
('0017', '29', '10', '7', '624', '1205'),
('0018', '16', '35', '7', '1246', '1038'),
('0019', '28', '36', '9', '1082', '686'),
('0020', '17', '24', '4', '766', '1015'),
('0021', '41', '23', '4', '1158', '802'),
('0022', '31', '40', '4', '1474', '594'),
('0023', '31', '28', '7', '1414', '1094'),
('0024', '19', '24', '2', '839', '962'),
('0025', '21', '12', '5', '638', '785'),
('0026', '10', '18', '9', '754', '859'),
('0027', '11', '13', '4', '995', '917'),
('0028', '34', '40', '9', '1084', '513'),
('0029', '22', '31', '7', '1387', '855'),
('0030', '14', '30', '3', '1055', '619'),
('0031', '47', '21', '7', '1015', '1037'),
('0032', '15', '13', '2', '524', '1430'),
('0033', '33', '14', '8', '1085', '1088'),
('0034', '17', '17', '4', '546', '785'),
('0035', '21', '34', '3', '1327', '1260'),
('0036', '22', '22', '7', '814', '1102'),
('0037', '12', '30', '5', '1007', '794'),
('0038', '47', '44', '5', '1021', '861'),
('0039', '19', '15', '9', '760', '1006'),
('0040', '40', '19', '9', '603', '1113'),
('0041', '40', '47', '5', '990', '552'),
('0042', '41', '42', '7', '1274', '1462'),
('0043', '29', '32', '4', '541', '669'),
('0044', '38', '13', '4', '864', '1325'),
('0045', '11', '37', '5', '1349', '578'),
('0046', '43', '49', '5', '1493', '1298'),
('0047', '10', '36', '4', '1013', '1156'),
('0048', '39', '39', '6', '763', '1314'),
('0049', '21', '49', '2', '700', '1425'),
('0050', '11', '24', '7', '835', '1147'),
('0051', '19', '17', '4', '1413', '1166'),
('0052', '33', '48', '9', '616', '1097'),
('0053', '35', '25', '2', '715', '1327'),
('0054', '29', '49', '5', '683', '1140'),
('0055', '36', '23', '8', '1313', '1255'),
('0056', '23', '27', '2', '795', '635'),
('0057', '41', '31', '4', '1373', '986'),
('0058', '42', '34', '6', '725', '792'),
('0059', '41', '12', '9', '849', '546'),
('0060', '17', '41', '4', '863', '1298'),
('0061', '46', '14', '8', '1414', '525'),
('0062', '25', '43', '2', '1271', '1177'),
('0063', '12', '23', '5', '636', '909'),
('0064', '35', '48', '8', '1001', '1382'),
('0065', '46', '45', '7', '1459', '1122'),
('0066', '19', '21', '8', '1497', '1158'),
('0067', '22', '31', '7', '595', '772'),
('0068', '12', '32', '6', '521', '1001'),
('0069', '27', '38', '4', '629', '1376'),
('0070', '49', '23', '7', '1121', '1417'),
('0071', '38', '44', '3', '767', '1309'),
('0072', '19', '42', '4', '557', '899'),
('0073', '42', '46', '3', '1467', '892'),
('0074', '12', '15', '5', '1404', '648'),
('0075', '11', '37', '5', '1425', '915'),
('0076', '22', '20', '5', '627', '1002'),
('0077', '15', '15', '4', '1400', '1233'),
('0078', '48', '34', '3', '659', '687'),
('0079', '28', '39', '4', '662', '505'),
('0080', '31', '36', '7', '1196', '756'),
('0081', '17', '17', '5', '833', '1022'),
('0082', '34', '29', '6', '1071', '536'),
('0083', '28', '18', '7', '1405', '882'),
('0084', '17', '43', '6', '881', '677'),
('0085', '39', '17', '8', '667', '1079'),
('0086', '25', '19', '2', '873', '1306'),
('0087', '46', '16', '2', '1119', '553'),
('0088', '26', '45', '3', '677', '901'),
('0089', '28', '16', '5', '1138', '1401'),
('0090', '33', '19', '5', '1138', '1259'),
('0091', '45', '15', '2', '1245', '1136'),
('0092', '47', '42', '4', '1342', '932'),
('0093', '35', '44', '5', '1101', '1186'),
('0094', '35', '12', '5', '677', '954'),
('0095', '39', '23', '5', '655', '993'),
('0096', '10', '30', '6', '963', '1000'),
('0097', '14', '12', '9', '1136', '790'),
('0098', '31', '44', '7', '1195', '1016'),
('0099', '29', '47', '3', '1489', '982'),
('0100', '27', '40', '6', '862', '700'),
('0101', '9', '20', '10', '200', '550'),
('0102', '9', '20', '10', '180', '750'),
('0103', '9', '20', '10', '210', '1200');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
