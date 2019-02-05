-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.11-log - MySQL Community Server (GPL)
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando datos para la tabla tareas_proyectos.proyecto: 2 rows
DELETE FROM `proyecto`;
/*!40000 ALTER TABLE `proyecto` DISABLE KEYS */;
INSERT INTO `proyecto` (`pid`, `fecha_fin`, `fecha_inicio`, `título`, `responsable`) VALUES
	(1, '2019-02-08 00:00:00', '2019-04-24 00:00:00', 'Aplicación Cli Medicos', 1),
	(2, '2018-12-04 00:00:00', '2019-05-30 00:00:00', 'Rest API Medicos', 1);
/*!40000 ALTER TABLE `proyecto` ENABLE KEYS */;

-- Volcando datos para la tabla tareas_proyectos.tarea: 1 rows
DELETE FROM `tarea`;
/*!40000 ALTER TABLE `tarea` DISABLE KEYS */;
INSERT INTO `tarea` (`id`, `duración`, `nombre`, `proyecto`, `responsable`) VALUES
	(1, 10, 'Crear proyecto', 1, 1);
/*!40000 ALTER TABLE `tarea` ENABLE KEYS */;

-- Volcando datos para la tabla tareas_proyectos.usuario: 3 rows
DELETE FROM `usuario`;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`uid`, `email`, `foto`, `nombre`) VALUES
	(1, 'r@r.com', 'r.jgpg', 'Ricardo'),
	(2, 'a@a.com', 'a.jpg', 'Ana'),
	(3, 'p@p.com', 'p.jpg', 'Petra');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
