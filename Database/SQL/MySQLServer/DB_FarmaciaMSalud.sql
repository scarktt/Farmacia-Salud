-- MySQL dump 10.13  Distrib 8.0.16, for macos10.14 (x86_64)
--
-- Host: localhost    Database: FarmaciaMSalud
-- ------------------------------------------------------
-- Server version	5.7.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Abono`
--

DROP TABLE IF EXISTS `Abono`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Abono` (
  `IDabono` int(11) NOT NULL,
  `FacturaCompraPedido` int(11) NOT NULL,
  `IDproveedor` int(11) NOT NULL,
  `SaldoAbono` decimal(13,3) DEFAULT NULL,
  PRIMARY KEY (`IDabono`,`FacturaCompraPedido`,`IDproveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Abono`
--

LOCK TABLES `Abono` WRITE;
/*!40000 ALTER TABLE `Abono` DISABLE KEYS */;
/*!40000 ALTER TABLE `Abono` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Compra`
--

DROP TABLE IF EXISTS `Compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Compra` (
  `FacturaCompra` int(11) NOT NULL,
  `IDproveedor` int(11) NOT NULL,
  `FacturaPedido` int(11) NOT NULL,
  `FechaCompra` datetime NOT NULL,
  `MontoCompra` decimal(13,3) NOT NULL,
  `ReciboColector` char(8) DEFAULT NULL,
  `Status` char(10) NOT NULL,
  `Observacion` char(30) DEFAULT NULL,
  `FechaVencPago` datetime NOT NULL,
  `Descuento` decimal(13,3) DEFAULT NULL,
  PRIMARY KEY (`FacturaCompra`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Compra`
--

LOCK TABLES `Compra` WRITE;
/*!40000 ALTER TABLE `Compra` DISABLE KEYS */;
INSERT INTO `Compra` VALUES (3001,7001,2001,'2016-01-21 00:00:00',0.000,'5001','Credito','-','2016-01-01 00:00:00',0.000),(3002,7002,2002,'2016-01-19 00:00:00',0.000,'5002','Credito','-','2016-01-30 00:00:00',0.000),(3003,7003,2003,'2016-03-10 00:00:00',0.000,'5003','Credito','-','2016-03-10 00:00:00',0.000),(3004,7004,2004,'2017-04-06 00:00:00',0.000,'5004','Credito','-','2017-04-10 00:00:00',0.000),(3005,7005,2005,'2017-05-20 00:00:00',0.000,'5005','Credito','-','2017-05-30 00:00:00',0.000),(3006,7006,2006,'2017-06-13 00:00:00',0.000,'5006','Credito','-','2017-06-20 00:00:00',0.000),(3007,7007,2007,'2017-07-13 00:00:00',0.000,'5007','Contado','-','2017-07-13 00:00:00',0.000),(3008,7008,2008,'2017-08-20 00:00:00',0.000,'5008','Credito','-','2017-08-20 00:00:00',0.000),(3009,7009,2009,'2017-09-20 00:00:00',0.000,'5009','Contado','-','2017-09-20 00:00:00',0.000),(3010,7010,2010,'2017-10-25 00:00:00',0.000,'5010','Contado','-','2017-10-25 00:00:00',0.000),(3011,7011,2011,'2017-11-07 00:00:00',0.000,'5011','Contado','-','2017-11-07 00:00:00',0.000),(3012,7012,2012,'2018-01-13 00:00:00',0.000,'5012','Contado','-','2018-01-13 00:00:00',0.000),(3013,7013,2013,'2018-01-26 00:00:00',0.000,'5013','Contado','-','2018-01-26 00:00:00',0.000),(3014,7014,2014,'2018-02-19 00:00:00',0.000,'50104','Credito','-','2018-02-19 00:00:00',0.000),(3015,7015,2015,'2018-04-10 00:00:00',0.000,'50105','Credito','-','2019-04-10 00:00:00',0.000),(3016,7016,2016,'2018-05-06 00:00:00',0.000,'50106','Credito','-','2018-05-06 00:00:00',0.000),(3017,7017,2017,'2018-07-20 00:00:00',0.000,'50107','Credito','-','2018-07-20 00:00:00',0.000),(3018,7018,2018,'2018-09-13 00:00:00',0.000,'50108','Contado','-','2018-09-13 00:00:00',0.000),(3019,7019,2019,'2018-12-13 00:00:00',0.000,'5019','Contado','-','2018-12-13 00:00:00',0.000),(3020,7020,2020,'2019-01-20 00:00:00',0.000,'5020','Contado','-','2019-01-20 00:00:00',0.000),(3021,7021,2021,'2019-01-20 00:00:00',0.000,'5021','Contado','-','2019-01-20 00:00:00',0.000),(3022,7022,2022,'2019-02-25 00:00:00',0.000,'5022','Contado','-','2019-02-25 00:00:00',0.000),(3023,7023,2023,'2019-03-07 00:00:00',0.000,'5023','Credito','-','2019-03-07 00:00:00',0.000),(3024,7024,2024,'2019-04-07 00:00:00',0.000,'5024','Credito','-','2019-04-07 00:00:00',0.000),(3025,7025,2025,'2019-04-26 00:00:00',0.000,'5025','Credito','-','2019-04-26 00:00:00',0.000),(3026,7026,2026,'2019-04-28 00:00:00',0.000,'501','Credito','-','2019-05-01 00:00:00',0.000),(3027,7027,2027,'2019-04-30 00:00:00',0.000,'502','Credito','-','2019-05-06 00:00:00',0.000),(3028,7028,2028,'2019-05-04 00:00:00',0.000,'503','Credito','-','2019-05-11 00:00:00',0.000),(3029,7029,2029,'2019-05-06 00:00:00',0.000,'504','Credito','-','2019-05-16 00:00:00',0.000),(3030,7030,2030,'2019-05-08 00:00:00',0.000,'505','Credito','-','2019-05-21 00:00:00',0.000),(3031,7031,2031,'2019-05-10 00:00:00',0.000,'506','Credito','-','2019-05-26 00:00:00',0.000),(3032,7032,2032,'2019-05-12 00:00:00',0.000,'507','Credito','-','2019-05-31 00:00:00',0.000),(3034,7034,2034,'2019-05-16 00:00:00',0.000,'509','Credito','-','2019-06-06 00:00:00',0.000),(3035,7035,2035,'2019-05-18 00:00:00',0.000,'5010','Credito','-','2019-06-11 00:00:00',0.000),(3036,7036,2036,'2019-05-20 00:00:00',20.000,'5011','Contado','-','2019-06-10 00:00:00',0.000),(3037,7037,2037,'2019-05-22 00:00:00',0.000,'5012','Contado','-','2019-06-21 00:00:00',0.000),(3038,7038,2038,'2019-05-24 00:00:00',0.000,'5013','Contado','-','2019-06-26 00:00:00',0.000),(3039,7039,2039,'2019-05-26 00:00:00',0.000,'5014','Contado','-','2019-06-30 00:00:00',0.000),(3040,7040,2040,'2019-05-28 00:00:00',0.000,'5015','Contado','-','2019-07-01 00:00:00',0.000),(3041,7041,2041,'2019-05-30 00:00:00',0.000,'5016','Contado','-','2019-07-04 00:00:00',0.000),(3042,7042,2042,'2019-06-02 00:00:00',0.000,'5017','Contado','-','2019-07-07 00:00:00',0.000),(3043,7043,2043,'2019-06-04 00:00:00',0.000,'5018','Contado','-','2019-07-10 00:00:00',0.000),(3044,7044,2044,'2019-06-06 00:00:00',0.000,'5019','Contado','-','2019-07-21 00:00:00',0.000),(3045,7045,2045,'2019-06-08 00:00:00',0.000,'5020','Contado','-','2019-07-26 00:00:00',0.000),(3046,7046,2046,'2019-06-10 00:00:00',0.000,'5021','Credito','-','2019-07-31 00:00:00',0.000),(3047,7047,2047,'2019-06-12 00:00:00',0.000,'5022','Credito','-','2019-08-01 00:00:00',0.000),(3048,7048,2048,'2019-06-14 00:00:00',0.000,'5023','Credito','-','2019-08-06 00:00:00',0.000),(3049,7049,2049,'2019-06-16 00:00:00',0.000,'5024','Credito','-','2019-08-11 00:00:00',0.000),(3050,7050,2050,'2019-06-18 00:00:00',0.000,'5025','Credito','-','2019-08-10 00:00:00',0.000),(3051,7051,2051,'2019-06-20 00:00:00',0.000,'5026','Credito','-','2019-08-21 00:00:00',0.000),(3052,7052,2052,'2019-06-22 00:00:00',0.000,'5027','Credito','-','2019-08-26 00:00:00',0.000),(3053,7053,2053,'2019-06-24 00:00:00',0.000,'5028','Credito','-','2019-08-31 00:00:00',0.000),(3054,7054,2054,'2019-06-26 00:00:00',0.000,'5029','Credito','-','2019-09-01 00:00:00',0.000),(3055,7055,2055,'2019-06-28 00:00:00',0.000,'5030','Credito','-','2019-09-06 00:00:00',0.000),(3056,7056,2056,'2019-06-30 00:00:00',0.000,'5031','Contado','-','2019-09-11 00:00:00',0.000),(3057,7057,2057,'2019-07-01 00:00:00',0.000,'5032','Contado','-','2019-09-10 00:00:00',0.000),(3058,7058,2058,'2019-07-03 00:00:00',0.000,'5033','Contado','-','2019-09-21 00:00:00',0.000),(3059,7059,2059,'2019-07-05 00:00:00',0.000,'5034','Contado','-','2019-09-26 00:00:00',0.000),(3060,7060,2060,'2019-07-07 00:00:00',0.000,'5035','Contado','-','2019-09-30 00:00:00',0.000),(3061,7061,2061,'2019-07-09 00:00:00',0.000,'5036','Contado','-','2019-10-01 00:00:00',0.000),(3062,7062,2062,'2019-07-11 00:00:00',0.000,'5037','Contado','-','2019-10-06 00:00:00',0.000),(3063,7063,2063,'2019-07-13 00:00:00',0.000,'5038','Contado','-','2019-10-11 00:00:00',0.000),(3064,7064,2064,'2019-07-10 00:00:00',0.000,'5039','Contado','-','2019-10-10 00:00:00',0.000),(3065,7065,2065,'2019-07-17 00:00:00',0.000,'5040','Contado','-','2019-10-21 00:00:00',0.000),(3066,7066,2066,'2019-07-19 00:00:00',0.000,'5041','Credito','-','2019-10-26 00:00:00',0.000),(3067,7067,2067,'2019-07-21 00:00:00',0.000,'5042','Credito','-','2019-10-31 00:00:00',0.000),(3068,7068,2068,'2019-07-23 00:00:00',0.000,'5043','Credito','-','2019-11-01 00:00:00',0.000),(3069,7069,2069,'2019-07-25 00:00:00',0.000,'5044','Credito','-','2019-11-06 00:00:00',0.000),(3070,7070,2070,'2019-07-27 00:00:00',0.000,'5045','Credito','-','2019-11-11 00:00:00',0.000),(3071,7071,2071,'2019-07-29 00:00:00',0.000,'5046','Credito','-','2019-11-16 00:00:00',0.000),(3072,7072,2072,'2019-08-02 00:00:00',0.000,'5047','Credito','-','2019-11-16 00:00:00',0.000),(3073,7073,2073,'2019-08-02 00:00:00',0.000,'5048','Credito','-','2019-11-16 00:00:00',0.000),(3074,7074,2074,'2019-08-02 00:00:00',0.000,'5049','Credito','-','2019-11-10 00:00:00',0.000),(3075,7075,2075,'2019-08-02 00:00:00',0.000,'5050','Credito','-','2019-11-10 00:00:00',0.000),(3076,7076,2076,'2019-08-04 00:00:00',0.000,'5051','Contado','-','2019-11-10 00:00:00',0.000),(3077,7077,2077,'2019-08-04 00:00:00',0.000,'5052','Contado','-','2019-11-10 00:00:00',0.000),(3078,7078,2078,'2019-08-06 00:00:00',0.000,'5053','Contado','-','2019-11-11 00:00:00',0.000),(3079,7079,2079,'2019-08-06 00:00:00',0.000,'5054','Contado','-','2019-11-13 00:00:00',0.000),(3080,7080,2080,'2019-08-06 00:00:00',0.000,'5055','Contado','-','2019-11-14 00:00:00',0.000),(3081,7007,2081,'2019-05-05 05:38:10',153.530,'','Contado','','2019-05-05 05:38:10',0.000);
/*!40000 ALTER TABLE `Compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DetalleFactura`
--

DROP TABLE IF EXISTS `DetalleFactura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `DetalleFactura` (
  `NoFactura` int(11) NOT NULL,
  `FacturaCompraPedido` int(11) NOT NULL,
  `IDproducto` int(11) NOT NULL,
  `Descripcion` char(30) NOT NULL,
  `PrecioUnitario` decimal(13,3) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Total` decimal(13,3) NOT NULL,
  PRIMARY KEY (`NoFactura`,`FacturaCompraPedido`,`IDproducto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DetalleFactura`
--

LOCK TABLES `DetalleFactura` WRITE;
/*!40000 ALTER TABLE `DetalleFactura` DISABLE KEYS */;
/*!40000 ALTER TABLE `DetalleFactura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DetallePedido`
--

DROP TABLE IF EXISTS `DetallePedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `DetallePedido` (
  `FacturaPedido` int(11) NOT NULL,
  `IDproducto` int(11) NOT NULL,
  `IDproveedor` int(11) NOT NULL,
  `CantidadUnidad` int(11) NOT NULL,
  `MontoxUnidad` decimal(13,3) NOT NULL,
  PRIMARY KEY (`FacturaPedido`,`IDproducto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DetallePedido`
--

LOCK TABLES `DetallePedido` WRITE;
/*!40000 ALTER TABLE `DetallePedido` DISABLE KEYS */;
INSERT INTO `DetallePedido` VALUES (2001,1001,7001,20,46.000),(2002,1002,7002,19,15.000),(2003,1003,7003,13,28.000),(2004,1004,7004,13,20.000),(2005,1005,7005,19,35.000),(2006,1006,7006,29,21.000),(2007,1007,7007,12,18.000),(2008,1008,7008,15,19.000),(2009,1009,7009,25,29.000),(2010,1010,7010,8,45.000),(2011,1011,7011,27,45.000),(2012,1012,7012,12,16.000),(2013,1013,7013,5,50.000),(2014,1014,7014,25,15.000),(2015,1015,7015,27,22.000),(2016,1016,7016,11,16.000),(2017,1017,7017,5,35.000),(2018,1018,7018,11,41.000),(2019,1019,7019,28,39.000),(2020,1020,7020,21,50.000),(2021,1021,7021,7,13.000),(2022,1022,7022,3,52.000),(2023,1023,7023,15,26.000),(2024,1024,7024,23,42.000),(2025,1025,7025,29,44.000),(2026,1026,7026,4,11.000),(2027,1027,7027,7,59.000),(2028,1028,7028,10,43.000),(2029,1029,7029,28,60.000),(2030,1030,7030,13,42.000),(2031,1031,7031,12,41.000),(2032,1032,7032,18,20.000),(2033,1033,7033,20,15.000),(2034,1034,7034,7,12.000),(2035,1035,7035,21,43.000),(2036,1036,7036,16,11.000),(2037,1037,7037,23,26.000),(2038,1038,7038,24,36.000),(2039,1039,7039,18,57.000),(2040,1040,7040,30,51.000),(2041,1041,7041,10,33.000),(2042,1042,7042,14,38.000),(2043,1043,7043,30,40.000),(2044,1044,7044,11,15.000),(2045,1045,7045,30,58.000),(2046,1046,7046,14,20.000),(2047,1047,7047,16,16.000),(2048,1048,7048,23,43.000),(2049,1049,7049,29,32.000),(2050,1050,7050,23,44.000),(2051,1051,7051,16,45.000),(2052,1052,7052,12,36.000),(2053,1053,7053,13,47.000),(2054,1054,7054,14,17.000),(2055,1055,7055,19,25.000),(2056,1056,7056,6,39.000),(2057,1057,7057,15,52.000),(2058,1058,7058,28,47.000),(2059,1059,7059,15,12.000),(2060,1060,7060,22,44.000),(2061,1061,7061,6,45.000),(2062,1062,7062,16,26.000),(2063,1063,7063,20,20.000),(2064,1064,7064,19,16.000),(2065,1065,7065,6,26.000),(2066,1066,7066,21,43.000),(2067,1067,7067,22,37.000),(2068,1068,7068,27,54.000),(2069,1069,7069,17,37.000),(2070,1070,7070,14,55.000),(2071,1071,7071,18,23.000),(2072,1072,7072,10,27.000),(2073,1073,7073,18,32.000),(2074,1074,7074,13,31.000),(2075,1075,7075,26,42.000),(2076,1076,7076,19,57.000),(2077,1077,7077,26,55.000),(2078,1078,7078,7,19.000),(2079,1079,7079,16,30.000),(2080,1080,7080,29,33.000),(2081,1027,7007,8,63.000),(2081,1028,7007,9,45.940),(2081,1029,7007,8,44.690);
/*!40000 ALTER TABLE `DetallePedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Empleado`
--

DROP TABLE IF EXISTS `Empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Empleado` (
  `IDempleado` int(11) NOT NULL,
  `CedulaEmpleado` char(16) DEFAULT NULL,
  `Nombre` char(30) NOT NULL,
  `Usuario` char(10) NOT NULL,
  `Pass` char(8) NOT NULL,
  PRIMARY KEY (`IDempleado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Empleado`
--

LOCK TABLES `Empleado` WRITE;
/*!40000 ALTER TABLE `Empleado` DISABLE KEYS */;
INSERT INTO `Empleado` VALUES (1,'001-130599-1007K','Francisco Silva','FSilva','1234'),(2,'001-230198-0198W','Gabriela Castillo','GCastillo','1234'),(3,'','Vendedor 3','Vendedor','1234');
/*!40000 ALTER TABLE `Empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Enfermedad`
--

DROP TABLE IF EXISTS `Enfermedad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Enfermedad` (
  `IDenfermedad` int(11) NOT NULL,
  `Descripcion` char(35) NOT NULL,
  PRIMARY KEY (`IDenfermedad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Enfermedad`
--

LOCK TABLES `Enfermedad` WRITE;
/*!40000 ALTER TABLE `Enfermedad` DISABLE KEYS */;
INSERT INTO `Enfermedad` VALUES (5001,'Fiebre'),(5002,'Herpes'),(5003,'Varicela'),(5004,'Gripe'),(5005,'Congestion'),(5006,'Dolor muscular'),(5007,'Diarrea'),(5008,'Dolor estomacal'),(5009,'Ansiedad'),(5010,'Infeccion estomacal'),(5011,'Bronquitis'),(5012,'Neumonia'),(5013,'Rinitis'),(5019,'Dolor de cabeza'),(5020,'Dolor de muela'),(5021,'Tos'),(5022,'Vomito'),(5023,'Alergia'),(5024,'Sinucitis'),(5025,'Infeccion vaginal'),(50104,'Mucolitico'),(50105,'Deshidratacion'),(50106,'Relajar'),(50107,'Imsonmio'),(50108,'Mononucleosis');
/*!40000 ALTER TABLE `Enfermedad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Factura`
--

DROP TABLE IF EXISTS `Factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Factura` (
  `NoFactura` int(11) NOT NULL,
  `IDempleado` int(11) NOT NULL,
  `Fecha` datetime NOT NULL,
  PRIMARY KEY (`NoFactura`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Factura`
--

LOCK TABLES `Factura` WRITE;
/*!40000 ALTER TABLE `Factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `Factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Indicacion`
--

DROP TABLE IF EXISTS `Indicacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Indicacion` (
  `IDindicacion` int(11) NOT NULL,
  `Descripcion` char(35) NOT NULL,
  PRIMARY KEY (`IDindicacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Indicacion`
--

LOCK TABLES `Indicacion` WRITE;
/*!40000 ALTER TABLE `Indicacion` DISABLE KEYS */;
INSERT INTO `Indicacion` VALUES (7001,'Niños < 6 meses'),(7002,'Niños < 1 año'),(7003,'Niños < 2 años'),(7004,'Niños < 5 años'),(7005,'Niños < 7 años'),(7006,'Niños < 10 años'),(7007,'0-105 años'),(7008,'Mayores de 108'),(7009,'Adultos > 40'),(7010,'Adultos > 50'),(7011,'Adultos > 60'),(7012,'Todas las edades'),(7013,'No apto para embarazadas'),(7014,'No apto durante la lactancia'),(7015,'No apto para personas hipertensas'),(7016,'No apto para diabéticos'),(7017,'Niños > 10 años');
/*!40000 ALTER TABLE `Indicacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `IndicacionProducto`
--

DROP TABLE IF EXISTS `IndicacionProducto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `IndicacionProducto` (
  `IDproducto` int(11) NOT NULL,
  `IDindicacion` int(11) NOT NULL,
  PRIMARY KEY (`IDproducto`,`IDindicacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `IndicacionProducto`
--

LOCK TABLES `IndicacionProducto` WRITE;
/*!40000 ALTER TABLE `IndicacionProducto` DISABLE KEYS */;
INSERT INTO `IndicacionProducto` VALUES (1001,7006),(1002,70106),(1003,7006),(1004,70106),(1005,7006),(1006,7009),(1007,7003),(1008,7007),(1009,7010),(1010,7005),(1011,7010),(1012,7011),(1013,7008),(1019,7006),(1020,7003),(1021,7011),(1022,7004),(1023,7013),(1024,70104),(1025,70104),(1026,70104),(1027,7001),(1028,7005),(1029,7006),(1030,7004),(1031,7006),(1032,7005),(1033,7010),(1034,7013),(1035,7006),(1036,7005),(1037,7003),(1038,7001),(1039,7010),(1040,7006),(1041,7007),(1042,7005),(1043,7010),(1044,7013),(1045,7010),(1046,7002),(1047,7005),(1048,7012),(1049,7009),(1050,7003),(1051,70104),(1052,7005),(1053,7007),(1054,7010),(1055,7011),(1056,7010),(1057,7002),(1058,7001),(1059,7005),(1060,7009),(1061,7001),(1062,7005),(1063,7005),(1064,7013),(1065,7003),(1066,7011),(1067,7004),(1068,7012),(1069,7006),(1070,7011),(1071,7010),(1072,7004),(1073,7003),(1074,7008),(1075,7002),(1076,7011),(1077,7001),(1078,7012),(1079,7001),(1080,7012),(10104,7013),(10105,7013),(10106,7003),(10107,7003),(10108,7009);
/*!40000 ALTER TABLE `IndicacionProducto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `InventarioProducto`
--

DROP TABLE IF EXISTS `InventarioProducto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `InventarioProducto` (
  `FacturaCompra` int(11) NOT NULL,
  `IDproducto` int(11) NOT NULL,
  `CantidadUnidades` int(11) NOT NULL,
  `MontoxUnidad` decimal(13,3) NOT NULL,
  `Ganancia` decimal(13,3) NOT NULL,
  `PrecioVentaUnitario` decimal(13,3) NOT NULL,
  `StockBodega` int(11) NOT NULL,
  `StockEstante` int(11) NOT NULL,
  PRIMARY KEY (`FacturaCompra`,`IDproducto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `InventarioProducto`
--

LOCK TABLES `InventarioProducto` WRITE;
/*!40000 ALTER TABLE `InventarioProducto` DISABLE KEYS */;
INSERT INTO `InventarioProducto` VALUES (3081,1027,8,63.000,0.350,85.050,0,8),(3081,1028,9,45.940,0.350,62.019,3,6),(3081,1029,8,44.690,0.350,60.330,0,8);
/*!40000 ALTER TABLE `InventarioProducto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Pagos`
--

DROP TABLE IF EXISTS `Pagos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Pagos` (
  `IDPagos` int(11) NOT NULL,
  `IDempleado` int(11) NOT NULL,
  `TipoPago` char(40) DEFAULT NULL,
  `MontoPago` decimal(13,3) NOT NULL,
  `FechaPago` datetime NOT NULL,
  PRIMARY KEY (`IDPagos`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Pagos`
--

LOCK TABLES `Pagos` WRITE;
/*!40000 ALTER TABLE `Pagos` DISABLE KEYS */;
INSERT INTO `Pagos` VALUES (10601,1,'Luz',1072.000,'2018-09-14 01:26:52'),(10602,1,'Luz',772.000,'2019-01-04 22:36:26'),(10603,1,'Luz',448.000,'2018-11-29 05:09:12'),(10604,1,'Agua',10460.000,'2018-11-23 05:52:29'),(10605,2,'Agua',1011.000,'2019-01-24 14:58:03'),(10606,1,'Agua',1065.000,'2019-02-20 15:27:53'),(10607,2,'CasaClaro',331.000,'2019-03-29 20:03:07'),(10608,1,'CasaClaro',1343.000,'2019-01-04 07:41:08'),(10609,2,'CasaClaro',621.000,'2019-03-06 20:33:23'),(10610,1,'Luz',1095.000,'2019-03-06 14:57:14'),(10611,1,'Luz',294.000,'2018-09-04 13:18:13'),(10612,1,'Luz',70.000,'2018-11-15 18:08:13'),(10613,1,'Agua',372.000,'2019-03-04 16:40:50'),(10619,1,'Luz',953.000,'2018-08-28 05:18:10'),(10620,2,'Luz',673.000,'2019-06-21 03:32:20'),(10621,1,'Luz',473.000,'2019-02-10 02:40:49'),(10622,1,'Agua',11080.000,'2019-06-07 22:52:16'),(10623,2,'Agua',496.000,'2019-04-11 03:19:19'),(10624,2,'Agua',335.000,'2018-11-22 02:39:10'),(10625,2,'CasaClaro',793.000,'2019-04-15 22:40:20'),(10626,2,'CasaClaro',442.000,'2018-11-25 06:14:45'),(10627,1,'CasaClaro',1210.000,'2019-05-14 00:21:50'),(10628,1,'Luz',576.000,'2019-06-13 18:29:32'),(10629,2,'Luz',1068.000,'2019-01-26 20:01:45'),(10630,2,'Luz',1397.000,'2018-09-04 09:28:41'),(10631,1,'Agua',890.000,'2019-07-13 07:48:52'),(10632,1,'Agua',11058.000,'2018-09-25 23:51:41'),(10633,1,'Agua',338.000,'2019-01-30 14:55:04'),(10634,1,'CasaClaro',520.000,'2019-05-13 22:33:36'),(10635,2,'CasaClaro',772.000,'2018-12-12 18:12:32'),(10636,2,'CasaClaro',1045.000,'2018-10-20 09:48:05'),(10637,1,'Luz',10450.000,'2019-03-28 06:30:45'),(10638,2,'Luz',522.000,'2018-08-31 17:29:04'),(10639,2,'Luz',469.000,'2019-08-04 09:05:37'),(10640,2,'Agua',593.000,'2019-02-23 05:35:15'),(10641,1,'Agua',346.000,'2019-05-12 22:26:14'),(10642,1,'Agua',1293.000,'2019-03-23 09:43:43'),(10643,2,'CasaClaro',263.000,'2018-10-21 14:14:23'),(10644,1,'CasaClaro',10424.000,'2019-03-28 19:04:43'),(10645,2,'CasaClaro',1002.000,'2018-11-06 10:55:45'),(10646,1,'Luz',671.000,'2019-01-29 02:22:08'),(10647,2,'Luz',1298.000,'2019-04-24 01:52:57'),(10648,2,'Luz',734.000,'2019-03-22 22:13:19'),(10649,2,'Agua',670.000,'2018-08-12 16:09:23'),(10650,1,'Agua',1063.000,'2018-11-28 13:10:54'),(10651,1,'Agua',1344.000,'2018-08-18 11:29:13'),(10652,2,'CasaClaro',7105.000,'2018-12-08 07:12:10'),(10653,2,'CasaClaro',786.000,'2018-09-24 09:40:32'),(10654,2,'CasaClaro',1375.000,'2018-12-01 08:20:28'),(10655,1,'Luz',1081.000,'2019-07-10 22:49:43'),(10656,1,'Luz',1377.000,'2019-05-20 00:16:22'),(10657,1,'Luz',1339.000,'2018-11-07 11:19:56'),(10658,2,'Agua',884.000,'2019-05-09 12:48:00'),(10659,1,'Agua',269.000,'2019-04-20 19:54:00'),(10660,2,'Agua',1222.000,'2018-10-09 20:34:39'),(10661,2,'CasaClaro',190.000,'2018-10-21 23:13:41'),(10662,1,'CasaClaro',50.000,'2018-10-01 16:02:58'),(10663,1,'CasaClaro',1227.000,'2018-11-26 01:02:24'),(10664,1,'Luz',867.000,'2019-03-02 01:22:26'),(10665,1,'Luz',1063.000,'2019-01-09 19:29:09'),(10666,2,'Luz',10460.000,'2019-01-06 23:43:06'),(10667,1,'Agua',11084.000,'2018-08-29 07:05:32'),(10668,1,'Agua',578.000,'2019-01-15 06:55:50'),(10669,2,'Agua',13106.000,'2019-07-22 00:56:11'),(10670,1,'CasaClaro',959.000,'2018-09-15 22:06:30'),(10671,2,'CasaClaro',1059.000,'2018-09-13 09:24:37'),(10672,2,'CasaClaro',602.000,'2019-01-19 23:22:43'),(10673,1,'Luz',1356.000,'2019-06-13 18:52:59'),(10674,1,'Luz',440.000,'2018-10-29 13:43:47'),(10675,1,'Luz',570.000,'2019-07-23 01:35:13'),(10676,2,'Agua',370.000,'2019-05-24 12:10:06'),(10677,1,'Agua',1290.000,'2019-01-09 21:08:02'),(10678,1,'Agua',55.000,'2019-02-07 21:14:52'),(10679,1,'CasaClaro',12108.000,'2018-09-05 18:16:33'),(10680,2,'CasaClaro',705.000,'2019-05-19 18:59:20'),(10681,2,'CasaClaro',1344.000,'2019-05-21 11:19:30'),(10682,2,'Luz',803.000,'2018-11-29 07:47:43'),(10683,1,'Luz',657.000,'2018-08-16 10:24:24'),(10684,1,'Luz',1327.000,'2019-04-19 21:26:54'),(10685,1,'Agua',507.000,'2019-04-26 12:44:51'),(10686,2,'Agua',643.000,'2019-08-06 00:16:20'),(10687,2,'Agua',198.000,'2018-08-22 20:40:25'),(10688,1,'CasaClaro',263.000,'2019-02-21 22:21:07'),(10689,2,'CasaClaro',1348.000,'2019-06-16 14:49:55'),(10690,2,'CasaClaro',1063.000,'2018-12-16 08:45:54'),(10691,2,'Luz',996.000,'2019-05-18 00:00:03'),(10692,1,'Luz',406.000,'2019-04-10 07:41:22'),(10693,2,'Luz',11061.000,'2018-09-20 01:19:41'),(10694,1,'Agua',541.000,'2019-07-08 08:22:39'),(10695,2,'Agua',264.000,'2018-09-25 11:25:46'),(10696,1,'Agua',5105.000,'2018-11-19 22:08:36'),(10697,2,'CasaClaro',84.000,'2018-08-27 06:30:16'),(10698,1,'CasaClaro',942.000,'2019-05-04 05:28:09'),(10699,1,'CasaClaro',1298.000,'2018-08-22 19:54:13'),(106104,1,'Agua',722.000,'2019-07-09 16:04:36'),(106105,2,'Agua',234.000,'2018-11-04 18:33:25'),(106106,1,'CasaClaro',11106.000,'2019-04-01 07:09:51'),(106107,2,'CasaClaro',984.000,'2019-01-26 10:13:26'),(106108,1,'CasaClaro',6107.000,'2018-10-28 20:08:57');
/*!40000 ALTER TABLE `Pagos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Pedido`
--

DROP TABLE IF EXISTS `Pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Pedido` (
  `FacturaPedido` int(11) NOT NULL,
  `IDproveedor` int(11) NOT NULL,
  `IDempleado` int(11) NOT NULL,
  `FechaPedido` datetime NOT NULL,
  `MontoPedido` decimal(13,3) NOT NULL,
  PRIMARY KEY (`FacturaPedido`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Pedido`
--

LOCK TABLES `Pedido` WRITE;
/*!40000 ALTER TABLE `Pedido` DISABLE KEYS */;
INSERT INTO `Pedido` VALUES (2001,7001,2,'2018-06-25 12:35:35',46.000),(2002,7002,2,'2019-07-29 18:23:32',15.000),(2003,7003,2,'2018-11-18 22:29:40',28.000),(2004,7004,2,'2018-11-16 18:37:24',20.000),(2005,7005,2,'2019-07-18 13:05:19',35.000),(2006,7006,2,'2019-03-29 11:25:15',21.000),(2007,7007,2,'2018-09-19 15:40:01',18.000),(2008,7008,2,'2018-11-06 04:52:56',19.000),(2009,7009,2,'2018-07-04 09:05:07',29.000),(2010,7010,2,'2018-12-30 02:59:47',45.000),(2011,7011,2,'2019-05-20 19:44:21',45.000),(2012,7012,2,'2019-06-27 02:10:17',16.000),(2013,7013,2,'2018-09-01 19:49:49',50.000),(2014,7014,2,'2018-08-28 22:26:08',15.000),(2015,7015,2,'2019-06-27 17:39:57',22.000),(2016,7016,2,'2018-07-09 21:58:33',16.000),(2017,7017,2,'2019-01-14 21:36:06',35.000),(2018,7018,2,'2019-01-06 08:19:34',41.000),(2019,7019,2,'2018-08-03 21:28:49',39.000),(2020,7020,2,'2019-08-01 20:00:45',50.000),(2021,7021,2,'2019-03-11 13:41:56',13.000),(2022,7022,2,'2018-08-21 07:30:26',52.000),(2023,7023,2,'2019-02-10 18:27:31',26.000),(2024,7024,2,'2019-01-21 13:17:57',42.000),(2025,7025,2,'2019-07-30 23:44:37',44.000),(2026,7026,2,'2018-11-29 13:25:40',11.000),(2027,7027,2,'2019-01-19 12:29:10',59.000),(2028,7028,2,'2019-07-10 14:23:04',43.000),(2029,7029,2,'2019-06-25 01:16:20',60.000),(2030,7030,2,'2018-10-25 18:45:02',42.000),(2031,7031,1,'2018-06-05 15:50:00',41.000),(2032,7032,1,'2019-06-11 00:02:13',20.000),(2033,7033,1,'2019-03-31 15:06:41',15.000),(2034,7034,1,'2019-02-02 10:20:12',12.000),(2035,7035,1,'2019-01-30 18:32:24',43.000),(2036,7036,1,'2019-04-26 07:10:03',11.000),(2037,7037,1,'2018-12-24 16:55:27',26.000),(2038,7038,1,'2018-06-09 04:31:28',36.000),(2039,7039,1,'2018-12-03 16:43:52',57.000),(2040,7040,1,'2018-10-07 08:23:00',51.000),(2041,7041,1,'2018-06-17 19:50:43',33.000),(2042,7042,1,'2018-08-07 06:36:45',38.000),(2043,7043,1,'2018-08-11 19:57:03',40.000),(2044,7044,1,'2019-03-07 19:42:24',15.000),(2045,7045,1,'2019-05-16 08:17:16',58.000),(2046,7046,1,'2018-10-18 14:41:43',20.000),(2047,7047,1,'2018-07-03 08:26:53',16.000),(2048,7048,1,'2018-12-17 03:44:57',43.000),(2049,7049,1,'2018-07-25 08:03:41',32.000),(2050,7050,1,'2019-02-23 14:39:52',44.000),(2051,7051,1,'2019-01-02 20:23:17',45.000),(2052,7052,1,'2019-04-04 07:27:46',36.000),(2053,7053,1,'2018-09-10 00:58:24',47.000),(2054,7054,1,'2018-11-21 10:37:32',17.000),(2055,7055,1,'2018-10-23 22:39:51',25.000),(2056,7056,1,'2018-12-08 07:16:31',39.000),(2057,7057,1,'2019-04-09 08:11:49',52.000),(2058,7058,1,'2019-04-06 18:38:24',47.000),(2059,7059,1,'2018-10-18 07:11:12',12.000),(2060,7060,1,'2018-08-16 15:12:02',44.000),(2061,7061,2,'2019-07-04 18:26:52',45.000),(2062,7062,2,'2018-06-07 12:51:45',26.000),(2063,7063,2,'2019-05-28 07:36:50',20.000),(2064,7064,2,'2019-07-05 02:48:00',16.000),(2065,7065,2,'2019-07-13 04:38:21',26.000),(2066,7066,2,'2019-04-30 02:56:49',43.000),(2067,7067,2,'2018-11-05 07:49:02',37.000),(2068,7068,2,'2018-06-22 02:24:06',54.000),(2069,7069,2,'2019-07-21 01:01:57',37.000),(2070,7070,2,'2019-04-07 16:21:59',55.000),(2071,7071,2,'2018-06-22 06:13:45',23.000),(2072,7072,2,'2018-11-05 06:27:41',27.000),(2073,7073,2,'2019-03-16 07:17:17',32.000),(2074,7074,2,'2019-01-10 21:33:42',31.000),(2075,7075,2,'2018-10-17 22:23:00',42.000),(2076,7076,2,'2018-08-29 06:50:30',57.000),(2077,7077,2,'2018-11-25 10:07:15',55.000),(2078,7078,2,'2018-06-13 23:04:00',19.000),(2079,7079,2,'2019-05-07 10:13:23',30.000),(2080,7080,2,'2018-07-12 17:56:12',33.000),(2081,7007,2,'2019-05-05 05:38:09',153.530);
/*!40000 ALTER TABLE `Pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PerdidaProducto`
--

DROP TABLE IF EXISTS `PerdidaProducto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `PerdidaProducto` (
  `IDperdida` int(11) NOT NULL,
  `FacturaCompraPedido` int(11) NOT NULL,
  `IDproducto` int(11) NOT NULL,
  `CantidadUnidades` int(11) NOT NULL,
  `MontoPerdido` decimal(13,3) NOT NULL,
  PRIMARY KEY (`IDperdida`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PerdidaProducto`
--

LOCK TABLES `PerdidaProducto` WRITE;
/*!40000 ALTER TABLE `PerdidaProducto` DISABLE KEYS */;
/*!40000 ALTER TABLE `PerdidaProducto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Producto`
--

DROP TABLE IF EXISTS `Producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Producto` (
  `IDproducto` int(11) NOT NULL,
  `Nombre` char(30) NOT NULL,
  `Forma_farmaceutica` char(20) NOT NULL,
  `Dosis_Contenido` int(11) NOT NULL,
  `Unidad_medida` char(10) NOT NULL,
  `Restriccion` bit(1) DEFAULT NULL,
  `Generico` bit(1) NOT NULL,
  `Descontinuado` bit(1) DEFAULT NULL,
  PRIMARY KEY (`IDproducto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Producto`
--

LOCK TABLES `Producto` WRITE;
/*!40000 ALTER TABLE `Producto` DISABLE KEYS */;
INSERT INTO `Producto` VALUES (1001,'Acetaminofen','Gotas',30,'ml',_binary '\0',_binary '',_binary '\0'),(1002,'Aciclovir','Tabletas',400,'mg',_binary '\0',_binary '',_binary '\0'),(1003,'Mucolex','Jarabe',90,'ml',_binary '\0',_binary '\0',_binary '\0'),(1004,'Zepol Deportista','Crema',30,'gr',_binary '\0',_binary '\0',_binary '\0'),(1005,'Alka-D','Tabletas',25,'gr',_binary '\0',_binary '\0',_binary ''),(1006,'Amoxicilina','Tabletas',500,'ml',_binary '\0',_binary '\0',_binary '\0'),(1007,'Ambroxol','Jarabe',100,'ml',_binary '\0',_binary '\0',_binary '\0'),(1008,'Ketotifeno','Tabletas',1,'mg',_binary '\0',_binary '\0',_binary '\0'),(1009,'Bromexina','Jarabe',120,'ml',_binary '\0',_binary '\0',_binary '\0'),(1010,'Broncodil','Gotas',30,'ml',_binary '\0',_binary '\0',_binary '\0'),(1011,'Electrolit','Suero',625,'ml',_binary '\0',_binary '\0',_binary '\0'),(1012,'Kalizzer','Suspension',1080,'ml',_binary '\0',_binary '\0',_binary '\0'),(1013,'Lorazepam','Tabletas',2,'mg',_binary '',_binary '\0',_binary '\0'),(1014,'Panesia','Spray',20,'ml',_binary '\0',_binary '\0',_binary '\0'),(1015,'Clotrimazol','Crema',20,'gr',_binary '\0',_binary '\0',_binary '\0'),(1016,'ViroGrip Gel AM','Tabletas',24,'mg',_binary '\0',_binary '\0',_binary '\0'),(1017,'ViroGrip Gel PM','Tabletas',24,'mg',_binary '\0',_binary '\0',_binary '\0'),(1018,'Prueba de embarazo','Unidad',0,'-',_binary '\0',_binary '\0',_binary '\0'),(1019,'ViroGrip Gel AM','Tabletas',24,'mg',_binary '\0',_binary '\0',_binary '\0'),(1020,'Loratadina','Tabletas',10,'mg',_binary '\0',_binary '\0',_binary '\0'),(1021,'ViroGrip Gel AM','Tabletas',24,'mg',_binary '\0',_binary '\0',_binary '\0'),(1022,'Serafon','Jarabe',1050,'ml',_binary '\0',_binary '\0',_binary '\0'),(1023,'Virogrip','Jarabe',1050,'ml',_binary '\0',_binary '\0',_binary '\0'),(1024,'Sulfaprim','Jarabe',200,'ml',_binary '\0',_binary '\0',_binary '\0'),(1025,'Clotrimazol','Crema',20,'gr',_binary '\0',_binary '\0',_binary '\0'),(1026,'Fungil','Locion',30,'ml',_binary '\0',_binary '\0',_binary '\0'),(1027,'Fungil','Spray',60,'ml',_binary '\0',_binary '\0',_binary '\0'),(1028,'Fungil','Talco',60,'gr',_binary '\0',_binary '\0',_binary '\0'),(1029,'Leche Magnesia','Jarabe',105,'ml',_binary '\0',_binary '\0',_binary '\0'),(1030,'P.P.M.S','Tabletas',1,'mg',_binary '\0',_binary '\0',_binary '\0'),(1031,'Aceite Mineral','Aceite Mineral',60,'ml',_binary '\0',_binary '',_binary '\0'),(1032,'Diclofenac Sodico','Tabletas',100,'mg',_binary '\0',_binary '',_binary '\0'),(1033,'Losardil','Tabletas',100,'mg',_binary '\0',_binary '',_binary '\0'),(1034,'Losardil','Tabletas',50,'mg',_binary '\0',_binary '',_binary '\0'),(1035,'Bromuro de ipratropio','Aerosol',0,'ml',_binary '\0',_binary '',_binary '\0'),(1036,'Acido Acetilsalicílico','Tabletas',100,'gr',_binary '\0',_binary '',_binary '\0'),(1037,'Metformina','Tabletas',850,'mg',_binary '\0',_binary '\0',_binary '\0'),(1038,'Ginkgo Biloba','Capsulas',60,'mg',_binary '\0',_binary '\0',_binary '\0'),(1039,'Macrovitam','Jarabe',240,'ml',_binary '\0',_binary '\0',_binary '\0'),(1040,'Macrovitam','Gotas',30,'ml',_binary '\0',_binary '\0',_binary '\0'),(1041,'Ketomed','Jarabe',120,'ml',_binary '\0',_binary '\0',_binary '\0'),(1042,'Dolovitalgia','Tabletas',80,'mg',_binary '\0',_binary '\0',_binary '\0'),(1043,'Salbutamol','Spray',100,'ml',_binary '\0',_binary '',_binary '\0'),(1044,'Ketorolaco','Tabletas',10,'mg',_binary '\0',_binary '',_binary '\0'),(1045,'Ketorolaco','Tabletas',20,'mg',_binary '',_binary '',_binary '\0'),(1046,'Dolofor','Ampollas',5,'ml',_binary '\0',_binary '\0',_binary '\0'),(1047,'Espasmo dolofor','Ampollas',2,'ml',_binary '\0',_binary '\0',_binary '\0'),(1048,'Desketoprofeno','Tabletas',25,'mg',_binary '\0',_binary '',_binary '\0'),(1049,'Definhidramina','Tabletas',25,'mg',_binary '\0',_binary '',_binary '\0'),(1050,'Furosolidona','Jarabe',100,'ml',_binary '\0',_binary '',_binary '\0'),(1051,'Furosolidona','Tabletas',100,'mg',_binary '\0',_binary '',_binary '\0'),(1052,'Jeringas','-',20,'cc',_binary '\0',_binary '\0',_binary '\0'),(1053,'Jeringas','-',60,'cc',_binary '\0',_binary '\0',_binary '\0'),(1054,'Pyrofantil','Supositorios',100,'mg',_binary '\0',_binary '\0',_binary '\0'),(1055,'Pyrofantil','Supositorios',300,'mg',_binary '\0',_binary '\0',_binary '\0'),(1056,'Sinalgex','Supositorios',300,'mg',_binary '\0',_binary '\0',_binary '\0'),(1057,'Tramadol','Tabletas',100,'mg',_binary '\0',_binary '',_binary '\0'),(1058,'Borax','-',30,'mg',_binary '\0',_binary '',_binary '\0'),(1059,'Enalapril','Tabletas',10,'mg',_binary '\0',_binary '\0',_binary '\0'),(1060,'Enalapril','Tabletas',10,'mg',_binary '\0',_binary '\0',_binary '\0'),(1061,'Ibuprofeno','Jarabe',400,'mg',_binary '\0',_binary '',_binary '\0'),(1062,'Ibuprofeno','Tabletas',400,'mg',_binary '\0',_binary '',_binary '\0'),(1063,'Gorros de enfermera','-',0,'-',_binary '\0',_binary '\0',_binary '\0'),(1064,'Furosolidona','Tabletas',100,'mg',_binary '\0',_binary '',_binary '\0'),(1065,'Furosolidona','Jarabe',100,'ml',_binary '\0',_binary '',_binary '\0'),(1066,'Mucolex','Jarabe',90,'ml',_binary '\0',_binary '\0',_binary '\0'),(1067,'Higado Sanil','Tabletas',80,'mg',_binary '\0',_binary '\0',_binary '\0'),(1068,'Definhidramina','Tabletas',25,'mg',_binary '\0',_binary '\0',_binary ''),(1069,'Amoxicilina','Tabletas',500,'ml',_binary '\0',_binary '\0',_binary '\0'),(1070,'Tramadol','Ampollas',50,'mg',_binary '\0',_binary '\0',_binary '\0'),(1071,'Ketorolaco','Ampollas',30,'mg',_binary '\0',_binary '\0',_binary '\0'),(1072,'Zepol','Ungüento',30,'gr',_binary '\0',_binary '\0',_binary '\0'),(1073,'Alcohol','-',500,'ml',_binary '\0',_binary '\0',_binary '\0'),(1074,'Alcohol','-',100,'ml',_binary '\0',_binary '\0',_binary '\0'),(1075,'Simvastatina','Tabletas',20,'mg',_binary '\0',_binary '\0',_binary '\0'),(1076,'Dextrometorfano','Jarabe',120,'ml',_binary '\0',_binary '\0',_binary '\0'),(1077,'Spasmoctyl','Tabletas',40,'mg',_binary '\0',_binary '\0',_binary '\0'),(1078,'Ballena Azul Naranja','Emulsión',200,'ml',_binary '\0',_binary '\0',_binary '\0'),(1079,'Azitromicina','Tabletas',500,'mg',_binary '\0',_binary '',_binary '\0'),(1080,'Loratadina','J',24,'mg',_binary '\0',_binary '\0',_binary '\0');
/*!40000 ALTER TABLE `Producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Proveedor`
--

DROP TABLE IF EXISTS `Proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Proveedor` (
  `IDproveedor` int(11) NOT NULL,
  `Tipo_proveedor` char(20) DEFAULT NULL,
  `Nombre_proveedor` char(30) NOT NULL,
  `tel1` char(8) DEFAULT NULL,
  `tel2` char(8) DEFAULT NULL,
  PRIMARY KEY (`IDproveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Proveedor`
--

LOCK TABLES `Proveedor` WRITE;
/*!40000 ALTER TABLE `Proveedor` DISABLE KEYS */;
INSERT INTO `Proveedor` VALUES (7001,'Laboratorio','Unifarm','8224508','87451632'),(7002,'Laboratorio','Pharmalat','86328780','87459632'),(7003,'Laboratorio','Ramos','76254868','85674859'),(7004,'Laboratorio','Caplin Point','76254893','86153478'),(7005,'Laboratorio','Procaps','83632708','50531087'),(7006,'Laboratorio','Chia Fong','86751047','50536810'),(7007,'Laboratorio','Ceguel','87656496','50506111'),(7008,'Laboratorio','Rarpe','87249035','50549373'),(7009,'Laboratorio','Pisa','81210636','50526788'),(7010,'Laboratorio','Panzyma','82452831','50594381'),(7011,'Laboratorio','Infasa','82472541','50554505'),(7012,'Laboratorio','PFizer','85333510','50520108'),(7013,'Laboratorio','La Santé','89471012','50539881'),(7014,'Laboratorio','Bengoechea','87107837','50596431'),(7015,'Distribuidor','Rocha','8689544','50546020'),(7016,'Distribuidor','J.Ruiz','8837770','50527204'),(7017,'Distribuidor','Jazmin','8690749','50554013'),(7018,'Distribuidor','Refanic','8489108','50582053'),(7019,'Distribuidor','Los Paisanos','8775477','50530178'),(7020,'Distribuidor','Krisan','8493283','50595898'),(7021,'Laboratorio','Solka','85241061','50529273'),(7022,'Laboratorio','Calox','81107530','50541908'),(7023,'Laboratorio','Unimark','87771903','50538060'),(7024,'Laboratorio','Zepol','83431061','50561358'),(7025,'Laboratorio','Altasa','8323278','50529789'),(7026,'Laboratorio','Winzzer','8979657','50524107'),(7027,'Laboratorio','Bayer','8292382','50510434'),(7028,'Laboratorio','Discarsa','8127620','5054565'),(7029,'Laboratorio','Euros','8272319','5057679'),(7030,'Distribuidor','Refanic','8595942','5057631'),(7031,'Distribuidor','Dicegsa','8202351','50591061'),(7032,'Distribuidor','Farcosa','87872107','5050886'),(7033,'Distribuidor','Disprofar','84546224','5052971'),(7034,'Distribuidor','Pushendorf','82641088','5058795'),(7035,'Distribuidor','Generifar','85126108','5059065'),(7036,'Laboratorio','Natural Herbal','84532308','5059532');
/*!40000 ALTER TABLE `Proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UtilidadProducto`
--

DROP TABLE IF EXISTS `UtilidadProducto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `UtilidadProducto` (
  `IDproducto` int(11) NOT NULL,
  `IDenfermedad` int(11) NOT NULL,
  PRIMARY KEY (`IDproducto`,`IDenfermedad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UtilidadProducto`
--

LOCK TABLES `UtilidadProducto` WRITE;
/*!40000 ALTER TABLE `UtilidadProducto` DISABLE KEYS */;
INSERT INTO `UtilidadProducto` VALUES (1001,5009),(1002,5022),(1003,5011),(1004,5025),(1005,5019),(1006,5014),(1007,5001),(1008,5007),(1009,5023),(1010,5020),(1011,5016),(1012,5009),(1013,5015),(1014,5023),(1015,5024),(1016,5020),(1018,5013),(1019,5010),(1020,5015),(1021,5010),(1022,5019),(1023,5003),(1024,5007),(1025,5010),(1026,5016),(1027,5020),(1028,5025),(1029,5011),(1030,5024),(1031,5025),(1032,5024),(1033,5014),(1034,5002),(1035,5021),(1036,5024),(1037,5022),(1038,5004),(1039,5025),(1040,5016),(1041,5019),(1042,5014),(1043,5006),(1044,5021),(1045,5006),(1046,5012),(1047,5019),(1048,5001),(1049,5014),(1050,5023),(1051,5009),(1052,5011),(1053,5021),(1054,5003),(1055,5014),(1056,5014),(1057,5006),(1058,5006),(1059,5021),(1060,5015),(1061,5004),(1062,5016),(1063,5013),(1064,5017),(1065,5014),(1066,5015),(1067,5016),(1068,5013),(1069,5007),(1070,5006),(1071,5017),(1072,5003),(1073,5003),(1074,5025),(1075,5022),(1076,5022),(1077,5006),(1078,50107),(1079,5016),(1080,5025);
/*!40000 ALTER TABLE `UtilidadProducto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-27 15:14:00
