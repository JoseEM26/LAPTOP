-- Eliminar la base de datos si existe
DROP DATABASE IF EXISTS `database_t1`;
-- Crear la base de datos
CREATE DATABASE `database_t1`;
USE `database_t1`;

-- 1) Tabla tbl_categoria
CREATE TABLE `tbl_categoria` (
  `id_categoria` INT NOT NULL AUTO_INCREMENT,	
  `descripcion`   VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Insertar datos en tbl_categoria
INSERT INTO `tbl_categoria` (`descripcion`) VALUES
  ('Artes Visuales'),
  ('Tecnología Creativa'),
  ('Oficios Manuales'),
  ('Escritura y Literatura'),
  ('Música y Sonido');

-- 2) Tabla tbl_actividad
-- Fijar AUTO_INCREMENT = 10 para que arranque en 10
CREATE TABLE `tbl_actividad` (
  `id_actividad` INT NOT NULL AUTO_INCREMENT,
  `descripcion`  VARCHAR(255) NOT NULL,
  `id_categoria` INT,
  `fecha_inicio` DATE NOT NULL,
  `nro_vacantes` INT NOT NULL DEFAULT 100,
  PRIMARY KEY (`id_actividad`),
  CONSTRAINT `chk_actividad_nro_vacantes` CHECK (`nro_vacantes` >= 2),
  CONSTRAINT `fk_actividad_categoria`
    FOREIGN KEY (`id_categoria`) REFERENCES `tbl_categoria`(`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=10;

-- Insertar datos en tbl_actividad
INSERT INTO `tbl_actividad` (`descripcion`, `id_categoria`, `fecha_inicio`, `nro_vacantes`) VALUES
  ('Taller de Fotografía Urbana',       1, '2025-05-05', 20),
  ('Diseño de Videojuegos con Unity',    2, '2025-06-01', 15),
  ('Curso de Cerámica Básica',           3, '2025-04-30', 12),
  ('Escritura Creativa: Cuento Corto',   4, '2025-05-10', 25),
  ('Producción Musical con Ableton Live',5, '2025-06-15', 18),
  ('Pintura al Óleo para Principiantes', 1, '2025-05-20', 10),
  ('Robótica Creativa con Arduino',      2, '2025-06-05', 14),
  ('Marroquinería Artesanal',            3, '2025-05-02', 16),
  ('Narrativa para Novelas',            4, '2025-06-10', 22),
  ('Grabación y Edición de Podcast',     5, '2025-05-25', 20);

-- 3) Tabla tbl_solicitud
-- AUTO_INCREMENT = 100 para que arranque en 100; fecha_reg por defecto CURRENT_TIMESTAMP
CREATE TABLE `tbl_solicitud` (
  `nro_solicitud`   INT NOT NULL AUTO_INCREMENT,
  `id_actividad`    INT NOT NULL,
  `estado`          CHAR(2) NOT NULL,
  `archivo_adjunto` VARCHAR(200) NOT NULL,
  `fecha_reg`       DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`nro_solicitud`),
  CONSTRAINT `chk_solicitud_estado` CHECK (`estado` IN ('PE','AC','AN')),
  CONSTRAINT `chk_solicitud_archivo` CHECK (
    `archivo_adjunto` LIKE '%.pdf' OR `archivo_adjunto` LIKE '%.docx'
  ),
  CONSTRAINT `fk_solicitud_actividad`
    FOREIGN KEY (`id_actividad`) REFERENCES `tbl_actividad`(`id_actividad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=100;

-- Insertar datos en tbl_solicitud
INSERT INTO `tbl_solicitud` (`id_actividad`, `estado`, `archivo_adjunto`) VALUES
  (10, 'PE', 'inscripcion1.pdf'),
  (11, 'AC', 'documento2.docx'),
  (12, 'AN', 'ficha3.pdf'),
  (13, 'PE', 'resumen4.docx'),
  (14, 'PE', 'solicitud5.pdf'),
  (10, 'AC', 'info6.pdf'),
  (11, 'PE', 'adjunto7.docx'),
  (12, 'AN', 'archivo8.pdf'),
  (13, 'AC', 'reporte9.docx'),
  (14, 'PE', 'certificado10.pdf');

