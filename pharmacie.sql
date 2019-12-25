-- phpMyAdmin SQL Dump
-- version 4.4.15.9
-- https://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 15, 2019 at 04:19 PM
-- Server version: 5.6.37
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pharmacie`
--

-- --------------------------------------------------------

--
-- Table structure for table `medicaments`
--

CREATE TABLE IF NOT EXISTS `medicaments` (
  `idMedicament` int(11) NOT NULL,
  `codeBarre` int(11) NOT NULL,
  `prix` int(11) NOT NULL,
  `nom` varchar(45) NOT NULL,
  `quantite` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `medicaments`
--

INSERT INTO `medicaments` (`idMedicament`, `codeBarre`, `prix`, `nom`, `quantite`) VALUES
(1, 22224578, 50, 'Rhumix', 300),
(4, 22224578, 50, 'Rhumix', 12),
(5, 25478695, 60, 'Doliprane', 20),
(6, 222278548, 80, 'Ibuprofene', 54),
(7, 22224578, 50, 'Rhumix', 12),
(8, 25478695, 60, 'Doliprane', 20),
(9, 222278548, 80, 'Ibuprofene', 54),
(10, 22224578, 50, 'Rhumix', 12),
(11, 25478695, 60, 'Doliprane', 20),
(12, 222278548, 80, 'Ibuprofene', 54),
(13, 12347859, 87, 'DoliGrippe', 52),
(15, 1234567, 140, 'Doliprane', 56),
(16, 12347859, 87, 'DoliGrippe', 87),
(17, 12347859, 20, 'DoliGrippe', 20),
(18, 22224578, 50, 'Rhumix', 12),
(19, 12347859, 180, 'DoliGrippe', 87),
(20, 22224578, 50, 'Rhumix', 12),
(50, 5478962, 69, 'ZT3', 69),
(73, 528974, 90, 'EFFERALGAN', 56),
(74, 12453987, 100, 'EFFERALGAN', 20),
(75, 4, 90, 'Paracétamol', 20),
(76, 9, 10, 'Khalil', 2),
(77, 5478962, 100, 'EFFERALGAN', 56),
(78, 5478962, 90, 'Paracétamol', 20),
(79, 5478962, 90, 'Paracétamol', 20),
(80, 528974, 100, 'Paracétamol', 20),
(81, 5478962, 90, 'Paracétamol', 20),
(82, 5478962, 90, 'Paracétamol', 20),
(83, 5478962, 100, 'ZT3', 20),
(84, 5478962, 100, 'ZT3', 20),
(85, 5478962, 90, 'EFFERALGAN', 20);

-- --------------------------------------------------------

--
-- Table structure for table `utilisateurs`
--

CREATE TABLE IF NOT EXISTS `utilisateurs` (
  `idUtilisateur` int(11) NOT NULL,
  `nom` varchar(45) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `utilisateurs`
--

INSERT INTO `utilisateurs` (`idUtilisateur`, `nom`, `prenom`, `email`, `password`) VALUES
(1, 'John', 'Doe', 'john@doe.net', 'john'),
(2, 'test', 'test', 'test@test.net', 'test');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `medicaments`
--
ALTER TABLE `medicaments`
  ADD PRIMARY KEY (`idMedicament`);

--
-- Indexes for table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  ADD PRIMARY KEY (`idUtilisateur`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `medicaments`
--
ALTER TABLE `medicaments`
  MODIFY `idMedicament` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=87;
--
-- AUTO_INCREMENT for table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  MODIFY `idUtilisateur` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
