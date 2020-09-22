-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 22, 2020 at 05:08 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hacktiv8_bcaffinalproject`
--
CREATE DATABASE IF NOT EXISTS `hacktiv8_bcaffinalproject` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `hacktiv8_bcaffinalproject`;

-- --------------------------------------------------------

--
-- Table structure for table `tb_agency`
--

CREATE TABLE `tb_agency` (
  `id` varchar(255) NOT NULL,
  `created_date` datetime NOT NULL,
  `details` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_agency`
--

INSERT INTO `tb_agency` (`id`, `created_date`, `details`, `name`, `updated_date`, `user_id`, `code`) VALUES
('1f7eb9b9-deb0-4e4c-b96d-4e2a3dd34c17', '2020-08-26 13:41:24', 'christian', 'ivana', '2020-09-21 07:20:01', '8a88ad71-c2a5-4d19-9a7e-70e94890c2c3', NULL),
('216d7701-c0eb-41d5-9e41-b9ed76b5d015', '2020-08-27 11:36:23', 'This Update', 'Agency update', '2020-09-21 16:15:17', '4d32d61a-ac17-49cf-a9e0-81f2d43988d2', NULL),
('383b930c-2732-4067-9966-2c9aa6febe9c', '2020-09-16 14:17:14', 'checker', 'validation', NULL, 'ac65d9ea-d804-4191-9cca-bce12859acaa', NULL),
('44a75f13-93c6-4979-81ea-4158184dff78', '2020-09-18 06:19:31', 'detail', 'name agency', NULL, '6607f69c-2074-4956-a272-387d41ce59c2', NULL),
('7345bdcf-70b3-4adb-a32b-c320ce66b1b9', '2020-09-10 13:18:56', '1234', '1234', NULL, '896eaf0d-2beb-4245-9998-a2f44defa3d4', NULL),
('7e92fa8e-98d7-4387-a0f9-8d06028f13ed', '2020-09-10 06:40:46', '1234', '1234', NULL, '6b3efbfe-766e-4cbf-9942-cf21f398c8a8', NULL),
('8486d3dd-7702-425e-ac66-ebdf3a1fdb52', '2020-09-16 14:59:54', 'start activity', 'test', NULL, 'cb968b33-8101-49d9-9951-fd4662d54fa4', NULL),
('ba1f6c20-5b79-443c-a0fb-2e7860b064ce', '2020-09-16 14:23:14', '12r1', 'dfqwko', NULL, '557f6ce9-c500-4607-b7e7-33f10cf35a05', NULL),
('c04bb622-2560-4661-bea4-fcdf7d3551c7', '2020-09-04 12:09:21', 'agency', 'test', NULL, '859f9d13-3624-4fc7-9f42-a8b3a2ce603f', NULL),
('ec38350d-ac37-47c1-bffa-eb10112f8e78', '2020-09-10 06:29:01', 'this for test', 'test android ', NULL, '059a7a13-b91c-4cf3-b041-b33d043b4f98', NULL),
('ed72c981-f912-4b95-8058-e8add763daff', '2020-09-17 02:09:01', 'agency', 'agency', NULL, 'f7ccfb84-c179-419d-a46e-a90a517bde1f', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tb_bus`
--

CREATE TABLE `tb_bus` (
  `id` varchar(255) NOT NULL,
  `agency_id` varchar(255) DEFAULT NULL,
  `capacity` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `created_date` datetime NOT NULL,
  `make` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_bus`
--

INSERT INTO `tb_bus` (`id`, `agency_id`, `capacity`, `code`, `created_date`, `make`, `updated_date`) VALUES
('4c8a3597-476a-425c-9a64-65ad7acbcc9d', '1f7eb9b9-deb0-4e4c-b96d-4e2a3dd34c17', 12, 'IC001', '2020-08-27 16:10:13', '1234', NULL),
('52360bc0-e79f-11ea-8980-28c2dd108650', '1f7eb9b9-deb0-4e4c-b96d-4e2a3dd34c17', 4, 'C0003', '2020-08-26 20:23:25', '2019', '2020-08-26 15:56:48'),
('545f0e2e-e79f-11ea-8980-28c2dd108650', '1f7eb9b9-deb0-4e4c-b96d-4e2a3dd34c17', 6, 'U0002', '2020-08-26 20:23:28', '2019', '2020-08-26 16:06:32'),
('54eeb506-e79f-11ea-8980-28c2dd108650', '1f7eb9b9-deb0-4e4c-b96d-4e2a3dd34c17', 10, 'A0003', '2020-08-26 20:23:29', '2019', NULL),
('55f34d68-e79f-11ea-8980-28c2dd108650', '1f7eb9b9-deb0-4e4c-b96d-4e2a3dd34c17', 52, 'A0004', '2020-08-26 20:23:31', '2019', NULL),
('57368c94-e79f-11ea-8980-28c2dd108650', '1f7eb9b9-deb0-4e4c-b96d-4e2a3dd34c17', 10, 'A0005', '2020-08-26 20:23:33', '2019', '2020-08-26 15:51:02'),
('6159f9f8-e79f-11ea-8980-28c2dd108650', '1f7eb9b9-deb0-4e4c-b96d-4e2a3dd34c17', 31, 'A0006', '2020-08-26 20:23:50', '2019', NULL),
('62c04ef3-e79f-11ea-8980-28c2dd108650', '1f7eb9b9-deb0-4e4c-b96d-4e2a3dd34c17', 61, 'A0007', '2020-08-26 20:23:53', '2019', NULL),
('679bee09-e79f-11ea-8980-28c2dd108650', '596a9963-84be-452b-aeb0-fee8dcf6adb5', 41, 'A0008', '2020-08-26 20:24:01', '2019', NULL),
('6831977c-e79f-11ea-8980-28c2dd108650', '596a9963-84be-452b-aeb0-fee8dcf6adb5', 31, 'A0009', '2020-08-26 20:24:02', '2019', NULL),
('6917b45c-ea21-47a2-9484-263acfa7c226', '216d7701-c0eb-41d5-9e41-b9ed76b5d015', 12, 'T0001', '2020-08-27 16:09:30', '2020', NULL),
('6a43693f-e79f-11ea-8980-28c2dd108650', '216d7701-c0eb-41d5-9e41-b9ed76b5d015', 11, 'C0011', '2020-08-26 20:24:05', '2019', '2020-09-07 07:17:13'),
('6ecb5867-e79f-11ea-8980-28c2dd108650', '596a9963-84be-452b-aeb0-fee8dcf6adb5', 7, 'A0012', '2020-08-26 20:24:13', '2019', NULL),
('6f819044-e79f-11ea-8980-28c2dd108650', '216d7701-c0eb-41d5-9e41-b9ed76b5d015', 9, 'A0013', '2020-08-26 20:24:14', '2019', NULL),
('707ab7e5-e79f-11ea-8980-28c2dd108650', '596a9963-84be-452b-aeb0-fee8dcf6adb5', 22, 'A0014', '2020-08-26 20:24:16', '2019', NULL),
('b96e6495-10d4-4cb0-aa5e-e18b693e4507', '1f7eb9b9-deb0-4e4c-b96d-4e2a3dd34c17', 10, 'U0003', '2020-08-26 16:06:32', '2021', '2020-08-26 16:09:02'),
('bf81d411-3bbf-4c55-ae0b-b23742b3e8ca', '216d7701-c0eb-41d5-9e41-b9ed76b5d015', 7, 'A0016', '2020-08-26 15:56:49', '2020', '2020-09-07 07:17:30');

-- --------------------------------------------------------

--
-- Table structure for table `tb_role`
--

CREATE TABLE `tb_role` (
  `id` varchar(255) NOT NULL,
  `created_date` datetime NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_role`
--

INSERT INTO `tb_role` (`id`, `created_date`, `role`, `updated_date`) VALUES
('44a7653a-e758-11ea-b101-28c2dd108650', '2020-08-26 11:54:48', 'passenger', NULL),
('46cf91db-e758-11ea-b101-28c2dd108650', '2020-08-26 11:54:51', 'owner', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tb_stop`
--

CREATE TABLE `tb_stop` (
  `id` varchar(255) NOT NULL,
  `created_date` datetime NOT NULL,
  `details` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_stop`
--

INSERT INTO `tb_stop` (`id`, `created_date`, `details`, `name`, `updated_date`, `code`) VALUES
('9c1094cc-e94b-11ea-ad57-28c2dd108650', '2020-08-28 23:29:13', 'Jakarta', 'JKT-01', NULL, NULL),
('a24053cc-e94b-11ea-ad57-28c2dd108650', '2020-08-28 23:29:24', 'Bandung', 'BDO-01', NULL, NULL),
('abdaee06-e94b-11ea-ad57-28c2dd108650', '2020-08-28 23:29:40', 'Surakarta', 'SOC-01', NULL, NULL),
('cc9f77b5-e94b-11ea-ad57-28c2dd108650', '2020-08-28 23:30:35', 'Surabaya', 'SUB-01', NULL, NULL),
('d5dd9e40-e94b-11ea-ad57-28c2dd108650', '2020-08-28 23:30:50', 'Bali', 'DPS-01', NULL, NULL),
('e4b92950-e94b-11ea-ad57-28c2dd108650', '2020-08-28 23:31:15', 'Yogyakarta', 'YKIA-01', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tb_ticket`
--

CREATE TABLE `tb_ticket` (
  `id` varchar(255) NOT NULL,
  `cancellable` bit(1) NOT NULL,
  `created_date` datetime NOT NULL,
  `journey_date` datetime NOT NULL,
  `seat_number` int(11) NOT NULL,
  `trip_schedule_id` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tb_trip`
--

CREATE TABLE `tb_trip` (
  `id` varchar(255) NOT NULL,
  `bus_id` varchar(255) DEFAULT NULL,
  `created_date` datetime NOT NULL,
  `dest_stop_id` varchar(255) DEFAULT NULL,
  `fare` int(11) NOT NULL,
  `journey_time` int(11) NOT NULL,
  `source_stop_id` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `agency_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_trip`
--

INSERT INTO `tb_trip` (`id`, `bus_id`, `created_date`, `dest_stop_id`, `fare`, `journey_time`, `source_stop_id`, `updated_date`, `agency_id`) VALUES
('249f907e-83b1-4ea9-9736-f1d9cca64249', '6917b45c-ea21-47a2-9484-263acfa7c226', '2020-08-28 19:16:24', '9c1094cc-e94b-11ea-ad57-28c2dd108650', 16, 120, 'e4b92950-e94b-11ea-ad57-28c2dd108650', NULL, '216d7701-c0eb-41d5-9e41-b9ed76b5d015'),
('a332c43f-e94c-11ea-ad57-28c2dd108650', '6a43693f-e79f-11ea-8980-28c2dd108650', '2020-08-28 23:36:35', 'abdaee06-e94b-11ea-ad57-28c2dd108650', 16, 100, 'a24053cc-e94b-11ea-ad57-28c2dd108650', '2020-09-07 10:32:43', '216d7701-c0eb-41d5-9e41-b9ed76b5d015'),
('f1fb543f-ce5b-4d91-8a92-5018da447072', '6f819044-e79f-11ea-8980-28c2dd108650', '2020-09-07 10:22:31', 'd5dd9e40-e94b-11ea-ad57-28c2dd108650', 14, 120, 'a24053cc-e94b-11ea-ad57-28c2dd108650', NULL, '216d7701-c0eb-41d5-9e41-b9ed76b5d015'),
('f6acb9ee-a2b5-47b4-aeb8-841e40d4211d', 'bf81d411-3bbf-4c55-ae0b-b23742b3e8ca', '2020-08-28 19:16:24', 'd5dd9e40-e94b-11ea-ad57-28c2dd108650', 13, 7, '9c1094cc-e94b-11ea-ad57-28c2dd108650', '2020-08-28 19:18:31', '216d7701-c0eb-41d5-9e41-b9ed76b5d015');

-- --------------------------------------------------------

--
-- Table structure for table `tb_trip_schedule`
--

CREATE TABLE `tb_trip_schedule` (
  `id` varchar(255) NOT NULL,
  `available_seats` int(11) NOT NULL,
  `created_date` datetime NOT NULL,
  `trip_date` datetime NOT NULL,
  `trip_id` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tb_user`
--

CREATE TABLE `tb_user` (
  `id` varchar(255) NOT NULL,
  `created_date` datetime NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role_id` varchar(255) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_user`
--

INSERT INTO `tb_user` (`id`, `created_date`, `email`, `first_name`, `last_name`, `mobile_number`, `password`, `role_id`, `updated_date`) VALUES
('059a7a13-b91c-4cf3-b041-b33d043b4f98', '2020-09-10 06:29:01', 'test@andorid.com', 'ivan', 'test', '1234', '$2a$10$.oYuY2qNA.3vq46tKGyVVOK3KeMqrvghSyoOhHgGrjeeRbv24q0Km', '46cf91db-e758-11ea-b101-28c2dd108650', NULL),
('4d32d61a-ac17-49cf-a9e0-81f2d43988d2', '2020-08-27 11:36:23', 'test@test.com', 'One', 'Last Try', '123456789', '$2a$10$YhL8Emmq44cdsARiX89cbeNkTrtUnUTuo70GUhsWS9f4UqNbR2Heu', '46cf91db-e758-11ea-b101-28c2dd108650', '2020-09-21 16:15:40'),
('557f6ce9-c500-4607-b7e7-33f10cf35a05', '2020-09-16 14:23:14', 'clear@data.com', 'check', 'clear', 'qkqwo1234', '$2a$10$HrqFGl1IwFWzC8CTd6gZcOiPXNjyXz7XDStpMUwM20THFGRdAZtcK', '46cf91db-e758-11ea-b101-28c2dd108650', NULL),
('6607f69c-2074-4956-a272-387d41ce59c2', '2020-09-18 06:19:31', 'maksa@maksa.com', 'maksa', 'banget', '0851234979', '$2a$10$MSDXMJgq2yd9QO55a.dtEeFKl0mp3/CacKd/keO3kglo0hY.bod/S', '46cf91db-e758-11ea-b101-28c2dd108650', NULL),
('6b3efbfe-766e-4cbf-9942-cf21f398c8a8', '2020-09-10 06:40:46', 'test@android.com', 'test', 'ivan', '1234', '$2a$10$vIEQ1aS7nJw0Heg/MpmTlehr7E.SNYVWdaAi/l1.r1ckJeYRFUi16', '46cf91db-e758-11ea-b101-28c2dd108650', NULL),
('859f9d13-3624-4fc7-9f42-a8b3a2ce603f', '2020-09-04 12:09:21', 'test@agency.com', 'ivan', 'christian', '123152341', '$2a$10$rxt8OG5zMPVgxyC2z7Yx0.6RmJ5hLIWAxc3IutkeBSLqLUOFmVolS', '46cf91db-e758-11ea-b101-28c2dd108650', NULL),
('896eaf0d-2beb-4245-9998-a2f44defa3d4', '2020-09-10 13:18:56', 'android@test.com', '1234', '1234', '1234', '$2a$10$QVpxdo8jOZzMpAU4qE4Dh.EPfIyd88BP.SycA1etbitaIzunsfU3u', '46cf91db-e758-11ea-b101-28c2dd108650', NULL),
('8a88ad71-c2a5-4d19-9a7e-70e94890c2c3', '2020-08-26 13:41:24', 'ivanchriztian@gmail.com', 'ivan', 'christian', '087836615272', '$2a$10$kkl/eXVxR2/ELqzbKHMF5Or.VlzLsnnETUR5mQ3gMOeb1rjAn76PS', '46cf91db-e758-11ea-b101-28c2dd108650', NULL),
('ac65d9ea-d804-4191-9cca-bce12859acaa', '2020-09-16 14:17:14', 'check@validation.com', 'validation', 'check', '123451231', '$2a$10$NOiuRfpDqmEo23Nm4OUom.90n0nDtrsx8kQTrfmLwvbBFVeShtH/i', '46cf91db-e758-11ea-b101-28c2dd108650', NULL),
('cb968b33-8101-49d9-9951-fd4662d54fa4', '2020-09-16 14:59:54', 'start@activity.com', 'test', 'activity', '12345124', '$2a$10$7pe4FwcDsQetC/n4yyWWUem92M5jjvPj2ZtpmobzV0C9kIPwSqtti', '46cf91db-e758-11ea-b101-28c2dd108650', NULL),
('f7ccfb84-c179-419d-a46e-a90a517bde1f', '2020-09-17 02:08:56', 'a@mail.com', 'cobaaa', 'aa', '8457687', '$2a$10$NBakAP2ol2ZY47hAF0dNW.WXSBZJuQTkcYSZ1S9TJ/e5pEUbiFyK.', '46cf91db-e758-11ea-b101-28c2dd108650', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `trip_schedule_ticket_id`
--

CREATE TABLE `trip_schedule_ticket_id` (
  `trip_schedule_id` varchar(255) NOT NULL,
  `ticket_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_agency`
--
ALTER TABLE `tb_agency`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_bus`
--
ALTER TABLE `tb_bus`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_role`
--
ALTER TABLE `tb_role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_stop`
--
ALTER TABLE `tb_stop`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_ticket`
--
ALTER TABLE `tb_ticket`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_trip`
--
ALTER TABLE `tb_trip`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_trip_schedule`
--
ALTER TABLE `tb_trip_schedule`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `trip_schedule_ticket_id`
--
ALTER TABLE `trip_schedule_ticket_id`
  ADD KEY `FKlv5lpbqi9esmqc75teboqxaen` (`trip_schedule_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `trip_schedule_ticket_id`
--
ALTER TABLE `trip_schedule_ticket_id`
  ADD CONSTRAINT `FKlv5lpbqi9esmqc75teboqxaen` FOREIGN KEY (`trip_schedule_id`) REFERENCES `tb_trip_schedule` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
