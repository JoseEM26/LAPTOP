use Ventas2017
go
create table Alumno(
 idAlumno int primary key,
 nombre varchar(50),
 apellido varchar(50),
 nroDocumento varchar(8),
 fechaNacimiento datetime,
 flgEliminar int
 )
 go

 create proc USP_ALUMNO_LISTAR
 @flgListar int,
 @idAlumno int
 AS
 BEGIN
   if @flgListar=1
   begin
   select*from Alumno
   end
   if @flgListar=2
   begin
     select*from Alumno where idAlumno=@idAlumno
   end
 END
 GO

 CREATE PROC USP_ALUMNO_CREATE
 @nombre varchar(50),
 @apellido varchar(50),
 @nroDocumento varchar(8),
 @fechaNacimiento datetime,
 @mensaje varchar(200) output,
 @value int output
 AS
 BEGIN
 if not exists(select 1 from Alumno as a where a.nroDocumento=@nroDocumento and flgEliminar=0)
 begin
     declare @idAlumno int = isnull((select MAX(a.idAlumno) from Alumno as a),0)+1

     insert into Alumno (idAlumno,nombre,apellido,nroDocumento,fechaNacimiento,flgEliminar)values
	                     (@idAlumno,@nombre,@apellido,@nroDocumento,@fechaNacimiento,0)

						 set @mensaje='El alumno fue registrado correctamente'
						 set @value=1
 end
 else
 begin
    set @mensaje='No puede existir 2 dulicados de DNI'
	set @value=0
 end

 END
 go