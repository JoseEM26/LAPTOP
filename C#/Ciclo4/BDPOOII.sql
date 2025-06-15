create database POOII
go

use POOII
go

Create table Alumno (
	idAlumno int primary key,
	nombre varchar(50),
	apellido varchar(50),
	nroDocumento varchar(8),
	fechanacimiento Date,
	flgEliminado bit
	)
go


INSERT INTO Alumno (idAlumno, nombre, apellido, nroDocumento, fechanacimiento, flgEliminado)
VALUES (1, 'Carlos', 'Ramírez', '12345678', '2002-05-14', 0);
GO

INSERT INTO Alumno (idAlumno, nombre, apellido, nroDocumento, fechanacimiento, flgEliminado)
VALUES (2, 'Lucía', 'Fernández', '23456789', '2003-11-22', 0);
GO

INSERT INTO Alumno (idAlumno, nombre, apellido, nroDocumento, fechanacimiento, flgEliminado)
VALUES (3, 'Miguel', 'Torres', '34567890', '2001-03-10', 0);
GO

INSERT INTO Alumno (idAlumno, nombre, apellido, nroDocumento, fechanacimiento, flgEliminado)
VALUES (4, 'Andrea', 'Pérez', '45678901', '2000-08-30', 0);
GO

INSERT INTO Alumno (idAlumno, nombre, apellido, nroDocumento, fechanacimiento, flgEliminado)
VALUES (5, 'José', 'Gonzales', '56789012', '2004-01-05', 0);
GO
create procedure usp_Alumno_Insert
(
	@Nombre varchar(50),
	@Apellidos varchar(50),
	@NroDocumento varchar(8),
	@FechNacimiento date,
	@Exito int output,
	@Mensaje varchar(200) output
)
as

if exists (select IdAlumno from Alumno where NroDocumento = @NroDocumento and flgEliminado = 0)
	begin
		set @Exito = 0
		set @Mensaje = 'El número de documento ' + @NroDocumento + ' ya existe'
	end
else
	begin
		declare @IdAlumno int = isnull((select MAX(IdAlumno) from Alumno), 0) + 1;

		insert into Alumno (IdAlumno, Nombre, Apellido, NroDocumento, Fechanacimiento, flgEliminado)
		values (@IdAlumno, @Nombre, @Apellidos, @NroDocumento, @FechNacimiento, 0)

		set @Exito = 1
		set @Mensaje = 'Registro Correcto'
	end

go


create procedure usp_Alumno_Lista(
	@flgorden int,
	@IdAlumno int
)
as

if @flgorden = 1 -- Devuelve toda la lista
	begin
		select * from Alumno where flgEliminado = 0
	end
else if @flgorden = 2 -- devuelve por ID
	begin
		select * from Alumno where IdAlumno  = @IdAlumno
	end
go
select *from alumno
go