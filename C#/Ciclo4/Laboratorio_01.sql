create database ProgramacionOrientadObjetos
go

use ProgramacionOrientadObjetos
go

CREATE TABLE alumno(
  idAlumno int primary key ,
  nombre varchar(50),
  apellido varchar(50),
  nroDocumento varchar(8),
  fechaNacimiento Date,
  flgEliminar bit
)
GO

INSERT INTO alumno (idAlumno, nombre, apellido, nroDocumento, fechaNacimiento, flgEliminar)
VALUES
(1, 'Juan', 'Pérez', '12345678', '2000-01-01', 0),
(2, 'Ana', 'González', '23456789', '1999-02-02', 0),
(3, 'Carlos', 'Rodríguez', '34567890', '1998-03-03', 0),
(4, 'María', 'Sánchez', '45678901', '1997-04-04', 0),
(5, 'Pedro', 'López', '56789012', '2001-05-05', 0),
(6, 'Lucía', 'Martínez', '67890123', '1996-06-06', 0),
(7, 'José', 'Gómez', '78901234', '1995-07-07', 0),
(8, 'Elena', 'Fernández', '89012345', '2002-08-08', 0),
(9, 'Miguel', 'Díaz', '90123456', '2000-09-09', 0),
(10, 'Sara', 'Vázquez', '12340123', '1998-10-10', 0),
(11, 'David', 'Hernández', '23451234', '2001-11-11', 0),
(12, 'Laura', 'Ramírez', '34562345', '1999-12-12', 0),
(13, 'Antonio', 'Jiménez', '45673456', '1997-01-13', 0),
(14, 'Patricia', 'Mendoza', '56784567', '1996-02-14', 0),
(15, 'Raúl', 'Torres', '67895678', '1995-03-15', 0),
(16, 'Beatriz', 'Suárez', '78906789', '2000-04-16', 0),
(17, 'Francisco', 'Pérez', '89017890', '1998-05-17', 0),
(18, 'Clara', 'González', '90128901', '2001-06-18', 0),
(19, 'Luis', 'López', '12340124', '1999-07-19', 0),
(20, 'Carmen', 'Martínez', '23451235', '1997-08-20', 0);
GO



create proc usp_alumno_insert
(
 @nombre varchar(50),
 @apellido varchar(50),
 @nroDocumento varchar(8),
 @fechaNacimiento Date,
 @exito int output,
 @mensaje varchar(200) output
)
as
begin
if exists(select a.idAlumno  from alumno as a where a.nroDocumento=@nroDocumento and a.flgEliminar = 0)
       begin
	        set @exito=0
			set @mensaje ='El numero de Documento ' + @nroDocumento + ' Ya existe'
	   end
else
       begin
	      declare @idAlumno int = isnull((select max(idAlumno) from alumno) , 0)+1;

		  insert into alumno (idAlumno,nombre,apellido,nroDocumento,fechaNacimiento,flgEliminar) values
		  (@idAlumno , @nombre , @apellido,@nroDocumento, @fechaNacimiento ,0);

		  set @exito = 1
		  set @mensaje='registro Correcto'
	   end
   
end
go

create proc  usp_alumno_actualizar
 @idAlumno int,
 @nombre varchar(50),
 @apellido varchar(50),
 @nroDocumento varchar(8),
 @fechaNacimiento Date,
 @exito int output,
 @mensaje varchar(200) output
as
begin
  if not exists(select 1 from alumno as a where a.idAlumno=@idAlumno)
      begin
	     set @exito=0
		 set @mensaje='El Usuario con este Id no existe'
	  end
   else
      begin
	     update alumno 
		 set nombre=@nombre,
		     apellido=@apellido,
			 nroDocumento=@nroDocumento,
			 fechaNacimiento=@fechaNacimiento
		where idAlumno=@idAlumno

	     SET @exito = 1
         SET @mensaje = 'El Usuario existe'
	  end
   
end

create proc usp_alumno_Eliminar
 @idAlumno int,
 @exito int output,
 @mensaje varchar(200) output
as
begin
  if not exists(select 1 from alumno as a where a.idAlumno=@idAlumno)
      begin
	     set @exito=0
		 set @mensaje='El Usuario con este Id no existe'
	  end
   else
      begin
	     update alumno 
		 set flgEliminar= -1
		where idAlumno=@idAlumno

	     SET @exito = 1
         SET @mensaje = 'El Usuario fue Eliminado'
	  end
   
end

create proc usp_alumno_lista
(
 @flgorden int ,
 @idAlumno int ,
   int output,
 @mensaje varchar(200) output
)
as
begin
  if not exists(select 1 from alumno as a)
  begin
         SET @exito = 0
         SET @mensaje = 'No hay nada en la tabla Alumno'
  end
  else
  begin
     if @flgorden = 1 --devuelve toda la lista
     begin 
	     select * from alumno where flgEliminar = 0
	     SET @exito = 1
         SET @mensaje = 'OK'
	 end
   else if @flgorden = 2 --devuelve por id
      begin 
	      select*from alumno as a where a.idAlumno=@idAlumno
		  SET @exito = 1
          SET @mensaje = 'OK '
	  end
  end
end
go

