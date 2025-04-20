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
@flgListar int

as
begin
   if @flgListar = 1
   begin
      select * from alumno where flgEliminado=0

   end

   if @flgListar = 2
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
go

create proc USP_ALUMNO_UPDATE
@idALumno int,
@nombre varchar (50),
@apellido varchar(50),
@nroDocumento varchar(8),
@fechaNacimiento date,
@mensaje varchar(200) output,
@value int output
AS 
BEGIN
  if exists (select 1 from alumno as a where flgEliminado=  0 and a.idAlumno=@idALumno)
  begin
     update alumno
	    set nombre=@nombre,
		    apellido = @apellido,
			nroDocumento=@nroDocumento,
			fechaNacimiento=@fechaNacimiento
			where idAlumno=@idALumno

	 set @mensaje= 'Se actualizo el Alumno'
	set @value=1
  end
  else
  begin
    set @mensaje= 'No existe El id'
	set @value=0
  end
END

go

create proc  USP_ALUMNO_ELIMINAR
@idAlumno int ,
@mensaje varchar(200) output,
@value int output
as 
begin
  if exists(select 1 from alumno where idAlumno= @idAlumno and flgEliminado=0)
  begin
    update alumno
	    set flgEliminado=1
		where idAlumno=@idAlumno
		 set @mensaje= 'Se Elimino el Alumno'
	     set @value=1
  end
  else
  begin
  set @mensaje= 'No existe El id'
	set @value=0
  end
end