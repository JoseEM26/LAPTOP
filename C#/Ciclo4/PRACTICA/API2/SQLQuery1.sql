use bd_hr
go

create table alumno(
 idAlumno int primary key ,
 nombre varchar(50),
 apellido varchar(50),
 nroDocumento varchar(8),
 fechaNacimiento date,
 flgEliminado bit

)
go
INSERT INTO alumno (idAlumno, nombre, apellido, nroDocumento, fechaNacimiento, flgEliminado)
VALUES (1, 'Ivana Elif', 'Espinoza Morales', '76179903', '2004-07-14', 0);
go

INSERT INTO alumno (idAlumno, nombre, apellido, nroDocumento, fechaNacimiento, flgEliminado)
VALUES (2, 'José Ángel', 'Pérez Gutiérrez', '76220001', '2003-05-22', 0);
go

INSERT INTO alumno (idAlumno, nombre, apellido, nroDocumento, fechaNacimiento, flgEliminado)
VALUES (3, 'María Fernanda', 'Lopez Ramirez', '76180002', '2002-11-11', 0);
go

INSERT INTO alumno (idAlumno, nombre, apellido, nroDocumento, fechaNacimiento, flgEliminado)
VALUES (4, 'Carlos Alberto', 'Mendoza Ruiz', '76179904', '2001-03-18', 0);
go

INSERT INTO alumno (idAlumno, nombre, apellido, nroDocumento, fechaNacimiento, flgEliminado)
VALUES (5, 'Lucía Andrea', 'Salazar Torres', '76179905', '2005-09-05', 0);
go

create or alter proc USP_ALUMNO_LISTAR
@idAlumno int ,
@flgListar bit

as
begin
   if @flgListar = 1
   begin
      select * from alumno where flgEliminado=0

   end

   if @flgListar =2
   begin
      if exists(select 1 from alumno as a where a.idAlumno=@idAlumno and flgEliminado=0)
	  begin
	     select * from alumno where idAlumno=@idAlumno and flgEliminado=0
	  end

   end
end
go



create or alter proc USP_ALUMNO_CREATE
@nombre varchar (50),
@apellido varchar(50),
@nroDocumento varchar(8),
@fechaNacimiento date,
@mensaje varchar(200) output,
@value int output
as
begin
  if not exists(select 1 from alumno as a where a.flgEliminado =0 and nroDocumento=@nroDocumento)
  begin
  declare @idAlumno int = isnull((select Max(a.idAlumno) from alumno a ) ,0)+1

  insert into alumno(idAlumno , nombre ,apellido ,nroDocumento , fechaNacimiento ,flgEliminado)values
                     (@idAlumno,@nombre,@apellido,@nroDocumento,@fechaNacimiento,0)
         set @mensaje = 'Se creo el nuevo alumno con ID'
	     set @value=1
  end
  else
  begin
  	     set @mensaje = 'Ya existe un nroDocumento con el numero :'+@nroDocumento
	     set @value=0
  end
end
--http://localhost:5002/