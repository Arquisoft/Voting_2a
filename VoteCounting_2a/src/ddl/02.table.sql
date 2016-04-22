CREATE TABLE `colegio_electoral` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_n9idjulnxkbrr50irwrt92iy2` (`nombre`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `voto` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_colegio` bigint(20) NOT NULL,
  `id_eleccion` bigint(20) NOT NULL,
  `online` bit(1) NOT NULL,
  `opcion` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `recuento` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_eleccion` bigint(20) NOT NULL,
  `opcion` varchar(255) NOT NULL,
  `total` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `eleccion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_m71umymtuppksp6fcoc8gmf7g` (`nombre`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
