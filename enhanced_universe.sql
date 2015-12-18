-- phpMyAdmin SQL Dump
-- version 4.2.12deb2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 18-12-2015 a las 14:37:29
-- Versión del servidor: 5.5.41-0+wheezy1
-- Versión de PHP: 5.6.7-1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `enhanced_universe`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ADMINISTRADOR`
--

CREATE TABLE IF NOT EXISTS `ADMINISTRADOR` (
  `usuario` varchar(50) NOT NULL COMMENT 'Esta es la clave primaria',
  `email` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `contrasena` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Esta es la tabla de administrador';

--
-- Volcado de datos para la tabla `ADMINISTRADOR`
--

INSERT INTO `ADMINISTRADOR` (`usuario`, `email`, `nombre`, `apellido`, `contrasena`) VALUES
('Steven Yepes ', 'jhonatan.yepes@udea,edu.co', 'Steven', 'Yepes', '397f30fe2f09e217a28b576fb26cff1f');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ASTEROIDE`
--

CREATE TABLE IF NOT EXISTS `ASTEROIDE` (
`id` int(11) unsigned NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `diametro` double DEFAULT NULL,
  `peligroso` tinyint(1) DEFAULT NULL COMMENT 'Potencialmente peligroso para la Tierra.',
  `galaxia` int(11) unsigned NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ASTEROIDE`
--

INSERT INTO `ASTEROIDE` (`id`, `nombre`, `diametro`, `peligroso`, `galaxia`) VALUES
(1, 'ceres', 952.4, NULL, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `COMETA`
--

CREATE TABLE IF NOT EXISTS `COMETA` (
`id` int(11) unsigned NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `diametro` double DEFAULT NULL,
  `periodoorbital` double DEFAULT NULL,
  `ultimoperihelio` int(11) DEFAULT NULL COMMENT 'Ultima vez que paso cerca a la Tierra.',
  `galaxia` int(11) unsigned NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `COMETA`
--

INSERT INTO `COMETA` (`id`, `nombre`, `diametro`, `periodoorbital`, `ultimoperihelio`, `galaxia`) VALUES
(1, 'halley', NULL, 75.3, 1986, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ESTRELLA`
--

CREATE TABLE IF NOT EXISTS `ESTRELLA` (
`id` int(11) unsigned NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `tipoespectral` varchar(2) DEFAULT NULL,
  `temperatura` double DEFAULT NULL,
  `clase` varchar(100) DEFAULT NULL,
  `masa` double DEFAULT NULL,
  `diametro` double DEFAULT NULL,
  `galaxia` int(11) unsigned NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ESTRELLA`
--

INSERT INTO `ESTRELLA` (`id`, `nombre`, `tipoespectral`, `temperatura`, `clase`, `masa`, `diametro`, `galaxia`) VALUES
(1, 'sol', 'G', 5504.85, 'enana', 1.9891e30, 1392000, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `GALAXIA`
--

CREATE TABLE IF NOT EXISTS `GALAXIA` (
`id` int(11) unsigned NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `tipo` int(11) unsigned NOT NULL,
  `alto` double DEFAULT NULL,
  `ancho` double DEFAULT NULL,
  `prufundidad` double DEFAULT NULL,
  `diametro` double DEFAULT NULL,
  `distanciatierra` double DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `GALAXIA`
--

INSERT INTO `GALAXIA` (`id`, `nombre`, `tipo`, `alto`, `ancho`, `prufundidad`, `diametro`, `distanciatierra`) VALUES
(1, 'via lactea', 1, NULL, NULL, NULL, 100000, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `GLOSARIO`
--

CREATE TABLE IF NOT EXISTS `GLOSARIO` (
`id` int(11) unsigned NOT NULL,
  `termino` varchar(100) NOT NULL,
  `definicion` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `GLOSARIO`
--

INSERT INTO `GLOSARIO` (`id`, `termino`, `definicion`) VALUES
(1, 'tipo espectral', 'El tipo espectral estelar, conocido también como Clasificación espectral de Harvard, ya que lo comenzó a esbozar Edward Charles Pickering de la Universidad de Harvard en el año 1890, y que perfeccionó Annie Jump Cannon de la misma universidad en 1901, es la clasificación estelar más utilizada en astronomía. Las diferentes clases se enumeran de las más cálidas a frías.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `PLANETA`
--

CREATE TABLE IF NOT EXISTS `PLANETA` (
`id` int(11) unsigned NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `masa` double DEFAULT NULL,
  `gravedad` double DEFAULT NULL,
  `diametro` double DEFAULT NULL,
  `temperatura` double DEFAULT NULL,
  `periodorotacional` double DEFAULT NULL,
  `periodoorbital` double DEFAULT NULL,
  `distaciatierra` double DEFAULT NULL,
  `galaxia` int(11) unsigned NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `PLANETA`
--

INSERT INTO `PLANETA` (`id`, `nombre`, `masa`, `gravedad`, `diametro`, `temperatura`, `periodorotacional`, `periodoorbital`, `distaciatierra`, `galaxia`) VALUES
(4, 'tierra', 5.9736e24, 9.780327, 6378.1, 14.05, 24, 1, 0, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `SATELITE`
--

CREATE TABLE IF NOT EXISTS `SATELITE` (
`id` int(11) unsigned NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `masa` double DEFAULT NULL,
  `gravedad` double DEFAULT NULL,
  `diametro` double DEFAULT NULL,
  `temperatura` double DEFAULT NULL,
  `periodorotacional` double DEFAULT NULL,
  `periodoorbital` double DEFAULT NULL,
  `planeta` int(11) unsigned NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `SATELITE`
--

INSERT INTO `SATELITE` (`id`, `nombre`, `masa`, `gravedad`, `diametro`, `temperatura`, `periodorotacional`, `periodoorbital`, `planeta`) VALUES
(1, 'luna', 7.349e22, 1.62, 3474, 107, NULL, 29.5, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TIPOESPECTRAL`
--

CREATE TABLE IF NOT EXISTS `TIPOESPECTRAL` (
  `clasificacion` varchar(2) NOT NULL,
  `color` varchar(100) NOT NULL,
  `temperatura` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `TIPOESPECTRAL`
--

INSERT INTO `TIPOESPECTRAL` (`clasificacion`, `color`, `temperatura`) VALUES
('G', 'amarillo', 6000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TIPOGALAXIA`
--

CREATE TABLE IF NOT EXISTS `TIPOGALAXIA` (
`id` int(11) unsigned NOT NULL,
  `nombre` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `TIPOGALAXIA`
--

INSERT INTO `TIPOGALAXIA` (`id`, `nombre`) VALUES
(2, 'eliptica'),
(1, 'espiral');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ADMINISTRADOR`
--
ALTER TABLE `ADMINISTRADOR`
 ADD PRIMARY KEY (`usuario`), ADD UNIQUE KEY `email` (`email`);

--
-- Indices de la tabla `ASTEROIDE`
--
ALTER TABLE `ASTEROIDE`
 ADD PRIMARY KEY (`id`), ADD KEY `galaxia` (`galaxia`);

--
-- Indices de la tabla `COMETA`
--
ALTER TABLE `COMETA`
 ADD PRIMARY KEY (`id`), ADD KEY `galaxia` (`galaxia`);

--
-- Indices de la tabla `ESTRELLA`
--
ALTER TABLE `ESTRELLA`
 ADD PRIMARY KEY (`id`), ADD KEY `galaxia` (`galaxia`), ADD KEY `tipoespectral` (`tipoespectral`);

--
-- Indices de la tabla `GALAXIA`
--
ALTER TABLE `GALAXIA`
 ADD PRIMARY KEY (`id`), ADD KEY `tipo` (`tipo`);

--
-- Indices de la tabla `GLOSARIO`
--
ALTER TABLE `GLOSARIO`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `termino` (`termino`);

--
-- Indices de la tabla `PLANETA`
--
ALTER TABLE `PLANETA`
 ADD PRIMARY KEY (`id`), ADD KEY `galaxia` (`galaxia`);

--
-- Indices de la tabla `SATELITE`
--
ALTER TABLE `SATELITE`
 ADD PRIMARY KEY (`id`), ADD KEY `planeta` (`planeta`);

--
-- Indices de la tabla `TIPOESPECTRAL`
--
ALTER TABLE `TIPOESPECTRAL`
 ADD PRIMARY KEY (`clasificacion`);

--
-- Indices de la tabla `TIPOGALAXIA`
--
ALTER TABLE `TIPOGALAXIA`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `nombre` (`nombre`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ASTEROIDE`
--
ALTER TABLE `ASTEROIDE`
MODIFY `id` int(11) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `COMETA`
--
ALTER TABLE `COMETA`
MODIFY `id` int(11) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `ESTRELLA`
--
ALTER TABLE `ESTRELLA`
MODIFY `id` int(11) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `GALAXIA`
--
ALTER TABLE `GALAXIA`
MODIFY `id` int(11) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `GLOSARIO`
--
ALTER TABLE `GLOSARIO`
MODIFY `id` int(11) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `PLANETA`
--
ALTER TABLE `PLANETA`
MODIFY `id` int(11) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `SATELITE`
--
ALTER TABLE `SATELITE`
MODIFY `id` int(11) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `TIPOGALAXIA`
--
ALTER TABLE `TIPOGALAXIA`
MODIFY `id` int(11) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ASTEROIDE`
--
ALTER TABLE `ASTEROIDE`
ADD CONSTRAINT `asteroide_galaxia` FOREIGN KEY (`galaxia`) REFERENCES `GALAXIA` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `COMETA`
--
ALTER TABLE `COMETA`
ADD CONSTRAINT `cometa_galaxia` FOREIGN KEY (`galaxia`) REFERENCES `GALAXIA` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `ESTRELLA`
--
ALTER TABLE `ESTRELLA`
ADD CONSTRAINT `ESTRELLA_ibfk_1` FOREIGN KEY (`tipoespectral`) REFERENCES `TIPOESPECTRAL` (`clasificacion`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `estrella_galaxia` FOREIGN KEY (`galaxia`) REFERENCES `GALAXIA` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `GALAXIA`
--
ALTER TABLE `GALAXIA`
ADD CONSTRAINT `tipo_galaxia` FOREIGN KEY (`tipo`) REFERENCES `TIPOGALAXIA` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `PLANETA`
--
ALTER TABLE `PLANETA`
ADD CONSTRAINT `planeta_galaxia` FOREIGN KEY (`galaxia`) REFERENCES `GALAXIA` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `SATELITE`
--
ALTER TABLE `SATELITE`
ADD CONSTRAINT `satelite_planeta` FOREIGN KEY (`planeta`) REFERENCES `PLANETA` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
