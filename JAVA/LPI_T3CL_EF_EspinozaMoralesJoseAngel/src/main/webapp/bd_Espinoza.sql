create database if not exists BD_EspinozMorales;
use BD_EspinozMorales;
create table  tb_tipo(
 id_tipo int auto_increment primary key,
 des_tipo_proy varchar(35)
);
create table tb_proyecto(
  cod_proyecto int auto_increment primary key,
  nom_proyecto varchar(35),
  id_tipo int ,
  presupuesto decimal,
  fecha_inicio date,
  duracion int,
  foreign key(id_tipo)references tb_tipo (id_tipo)
);

-- Inserciones en la tabla tb_tipo
INSERT INTO tb_tipo (des_tipo_proy) VALUES 
('Infraestructura'),
('Software'),
('Investigación'),
('Educativo'),
('Industrial'),
('Energético'),
('Turístico'),
('Comercial'),
('Salud'),
('Agrícola');

-- Inserciones en la tabla tb_proyecto
INSERT INTO tb_proyecto (nom_proyecto, id_tipo, presupuesto, fecha_inicio, duracion) VALUES
('Construcción de Puente', 1, 125000.50, '2024-01-15', 180),
('Sistema de Gestión Escolar', 2, 30000.75, '2024-02-10', 90),
('Estudio de Ecosistemas', 3, 45000.00, '2024-03-01', 120),
('Capacitación Docente', 4, 15000.00, '2024-04-05', 60),
('Automatización de Planta', 5, 200000.00, '2024-05-20', 240),
('Parque Eólico', 6, 500000.00, '2024-06-15', 365),
('Promoción Turística', 7, 80000.00, '2024-07-10', 150),
('Desarrollo de Tienda Virtual', 8, 25000.00, '2024-08-01', 45),
('Clínica Especializada', 9, 750000.00, '2024-09-12', 300),
('Riego Automatizado', 10, 120000.00, '2024-10-01', 180),
('Edificio Corporativo', 1, 1000000.00, '2024-11-01', 540),
('Aplicación Móvil', 2, 40000.00, '2024-12-01', 120),
('Análisis Climático', 3, 35000.00, '2024-01-10', 90),
('Proyecto Educativo Rural', 4, 18000.00, '2024-02-15', 100),
('Línea de Producción', 5, 220000.00, '2024-03-20', 360),
('Planta Solar', 6, 600000.00, '2024-04-25', 400),
('Ruta Gastronómica', 7, 45000.00, '2024-05-30', 120),
('E-commerce Internacional', 8, 50000.00, '2024-06-05', 60),
('Centro de Salud Comunitario', 9, 850000.00, '2024-07-12', 400),
('Optimización de Cultivos', 10, 140000.00, '2024-08-20', 200);


select*from tb_proyecto;
select*from tb_tipo;

CREATE PROCEDURE sp_actualizar_proyecto(
    IN p_cod_proyecto INT,
    IN p_nom_proyecto VARCHAR(35),
    IN p_id_tipo INT,
    IN p_presupuesto DECIMAL(10, 2),
    IN p_fecha_inicio DATE,
    IN p_duracion INT
)
    UPDATE tb_proyecto
    SET 
        nom_proyecto = p_nom_proyecto,
        id_tipo = p_id_tipo,
        presupuesto = p_presupuesto,
        fecha_inicio = p_fecha_inicio,
        duracion = p_duracion
    WHERE cod_proyecto = p_cod_proyecto;

