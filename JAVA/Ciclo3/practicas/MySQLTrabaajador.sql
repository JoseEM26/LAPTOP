create database Formulario;
use formulario;
create table trabajador(
 dni char(8) not null primary key,
 nombre varchar(50) not null,
 apellido varchar(50) not null,
 edad int not null,
 direccion varchar(50) not null,
 fecha date not null

);
INSERT INTO trabajador VALUES ('76179903', 'Jose', 'Angel', 19, 'Campoy', '2004-11-26');
-----------------------------------------------------	
delete from trabajador where dni='76179905';

select*from trabajador;
-----------------------------------------------------
CREATE procedure ActualizarTrabajador(
     IN p_dni CHAR(8),
     IN p_nombre VARCHAR(50),
     IN p_apellido VARCHAR(50),
     IN p_edad INT,
     IN p_direccion VARCHAR(50),
     IN p_fecha DATE
)
    UPDATE trabajador
    SET
        nombre = p_nombre,
        apellido = p_apellido,
        edad = p_edad,
        direccion = p_direccion,
        fecha = p_fecha
    WHERE dni = p_dni;

CALL ActualizarTrabajador('76179903', 'Jose', 'Espinoza', 20, 'Campoy 123', '2004-11-26');


    

    
    
    
    