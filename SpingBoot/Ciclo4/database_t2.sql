-- Eliminar la base de datos si existe
DROP DATABASE IF EXISTS `database_t2`;
-- Crear la base de datos
CREATE DATABASE `database_t2`;
USE `database_t2`;

-- CREACIÓN DE TABLAS
CREATE TABLE tbl_categoria (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(100) NOT NULL,
    frecuencia_compra CHAR(1) CHECK (frecuencia_compra IN ('A', 'M', 'B', 'O')) -- A: Alta, M: Media, B: Baja, O: Ocasional
);

INSERT INTO tbl_categoria (descripcion, frecuencia_compra) VALUES
('Lácteos', 'A'),
('Carnes', 'M'),
('Snacks', 'B'),
('Bebidas', 'O');

CREATE TABLE tbl_producto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    id_categoria INT NOT NULL,
    stock_maximo INT DEFAULT 0,
    stock_actual INT,
    FOREIGN KEY (id_categoria) REFERENCES tbl_categoria(id)
);

INSERT INTO tbl_producto (nombre, id_categoria, stock_maximo, stock_actual) VALUES
('Leche Entera', 1, 100, 80),
('Queso Mozzarella', 1, 50, 45),
('Yogur Natural', 1, 70, 60),
('Carne de Res', 2, 60, 40),
('Pollo Entero', 2, 90, 85),
('Papas Fritas', 3, 200, 150),
('Chocolatina', 3, 180, 160),
('Jugo de Naranja', 4, 120, 100),
('Gaseosa Cola', 4, 300, 270),
('Agua Mineral', 4, 250, 240);

CREATE TABLE tbl_inventario (
    numero INT AUTO_INCREMENT PRIMARY KEY,
    fecha_vencimiento DATE NOT NULL,
    id_producto INT NOT NULL,
    costo_ingreso DECIMAL(10, 2) NOT NULL,
    cantidad INT DEFAULT 1,
    lote VARCHAR(30),
    cod_estado CHAR(1) CHECK (cod_estado IN ('A', 'V', 'T', 'B')), -- A: Activo, V: Vencido, T: En tránsito, B: Bloqueado
    FOREIGN KEY (id_producto) REFERENCES tbl_producto(id)
);
INSERT INTO tbl_inventario (fecha_vencimiento, id_producto, costo_ingreso, cantidad, lote, cod_estado) VALUES
('2025-07-15', 1, 0.85, 20, 'L001-A', 'A'),
('2025-08-01', 2, 1.20, 10, 'L002-A', 'A'),
('2025-06-30', 3, 0.70, 15, 'L003-V', 'V'),
('2025-07-01', 4, 5.50, 8, 'C001-A', 'A'),
('2025-07-10', 5, 4.75, 12, 'C002-A', 'A'),
('2025-12-01', 6, 0.90, 50, 'S001-A', 'B'),
('2025-12-15', 7, 1.10, 40, 'S002-A', 'A'),
('2026-01-01', 8, 1.50, 30, 'B001-A', 'A'),
('2026-01-10', 9, 1.60, 45, 'B002-A', 'A'),
('2026-02-01', 10, 0.50, 60, 'B003-A', 'A'),
('2025-06-15', 3, 0.68, 10, 'L004-V', 'V'),
('2025-08-20', 1, 0.90, 25, 'L005-A', 'A'),
('2025-09-10', 6, 0.88, 30, 'S003-A', 'A'),
('2026-03-01', 9, 1.65, 40, 'B004-T', 'T'),
('2025-10-05', 5, 4.60, 15, 'C003-B', 'B');
