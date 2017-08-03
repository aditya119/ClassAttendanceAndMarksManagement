-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 03, 2017 at 11:51 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `class_erp`
--

-- --------------------------------------------------------

--
-- Table structure for table `ada_database_attendance`
--

CREATE TABLE `ada_database_attendance` (
  `roll_number` varchar(8) NOT NULL,
  `attendance` int(100) NOT NULL,
  `total` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ada_database_marks`
--

CREATE TABLE `ada_database_marks` (
  `roll_number` varchar(8) NOT NULL,
  `sessional` float NOT NULL,
  `quiz` float NOT NULL,
  `attendance_marks` float NOT NULL,
  `semester` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Table structure for table `cao_database_attendance`
--

CREATE TABLE `cao_database_attendance` (
  `roll_number` varchar(8) NOT NULL,
  `attendance` int(100) NOT NULL,
  `total` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `cao_database_marks`
--

CREATE TABLE `cao_database_marks` (
  `roll_number` varchar(8) NOT NULL,
  `sessional` float NOT NULL,
  `quiz` float NOT NULL,
  `attendance_marks` float NOT NULL,
  `semester` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Table structure for table `os_database_attendance`
--

CREATE TABLE `os_database_attendance` (
  `roll_number` varchar(8) NOT NULL,
  `attendance` int(100) NOT NULL,
  `total` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `os_database_marks`
--

CREATE TABLE `os_database_marks` (
  `roll_number` varchar(8) NOT NULL,
  `sessional` float NOT NULL,
  `quiz` float NOT NULL,
  `attendance_marks` float NOT NULL,
  `semester` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Table structure for table `se_database_attendance`
--

CREATE TABLE `se_database_attendance` (
  `roll_number` varchar(8) NOT NULL,
  `attendance` int(100) NOT NULL,
  `total` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `se_database_marks`
--

CREATE TABLE `se_database_marks` (
  `roll_number` varchar(8) NOT NULL,
  `sessional` float NOT NULL,
  `quiz` float NOT NULL,
  `attendance_marks` float NOT NULL,
  `semester` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `subject` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`, `subject`) VALUES
('se', 'se', 'se'),
('ada', 'ada', 'ada'),
('cao', 'cao', 'cao'),
('wt', 'wt', 'wt'),
('os', 'os', 'os');

-- --------------------------------------------------------

--
-- Table structure for table `wt_database_attendance`
--

CREATE TABLE `wt_database_attendance` (
  `roll_number` varchar(8) NOT NULL,
  `attendance` int(100) NOT NULL,
  `total` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `wt_database_marks`
--

CREATE TABLE `wt_database_marks` (
  `roll_number` varchar(8) NOT NULL,
  `sessional` float NOT NULL,
  `quiz` float NOT NULL,
  `attendance_marks` float NOT NULL,
  `semester` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ada_database_marks`
--
ALTER TABLE `ada_database_marks`
  ADD PRIMARY KEY (`roll_number`);

--
-- Indexes for table `cao_database_marks`
--
ALTER TABLE `cao_database_marks`
  ADD PRIMARY KEY (`roll_number`);

--
-- Indexes for table `os_database_marks`
--
ALTER TABLE `os_database_marks`
  ADD PRIMARY KEY (`roll_number`);

--
-- Indexes for table `se_database_marks`
--
ALTER TABLE `se_database_marks`
  ADD PRIMARY KEY (`roll_number`);

--
-- Indexes for table `wt_database_marks`
--
ALTER TABLE `wt_database_marks`
  ADD PRIMARY KEY (`roll_number`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
