create database POOII
go

use POOII
go


Create table Alumno (
	IdAlumno int primary key,
	Nombre varchar(50),
	Apellido varchar(50),
	NroDocumento varchar(8),
	Fechanacimiento Date,
	flgEliminado bit
	)
go

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