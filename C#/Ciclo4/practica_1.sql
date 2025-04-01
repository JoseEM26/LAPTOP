		create database POO_Practicas
		go

		use POO_Practicas
		go
	
		create table alumno(
		  idAlumno int primary key,
		  nombre varchar(50),
		  apellido varchar(50),
		  nroDocumento varchar(8),
		  fechaNacimiento Date,
		  flgEliminar bit
  
		)
		go

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


		create proc SP_Alumno_Create
		  @nombre varchar(50),
		  @apellido varchar(50),
		  @nroDocumento varchar(8),
		  @fechaNacimiento Date,
		  @exito int output,
		  @mensaje varchar(200) output
		as
		begin

		   if not exists (select 1 from alumno as a where a.nroDocumento=@nroDocumento and a.flgEliminar = 0)
			  begin 

				 declare @id int= isnull((select max(a.idAlumno) from alumno as a) , 0)+1

				 insert into alumno(idAlumno ,  nombre ,apellido , nroDocumento , fechaNacimiento ,flgEliminar ) values
								   (@id , @nombre ,@apellido ,@nroDocumento,@fechaNacimiento , 0)
									 set @exito = 1
									 set @mensaje='Nuevo Alumno fue insertado exitosamente'
			  end
		   else 
			  begin
			   set @exito = 0
			   set @mensaje='Ya existe este numero de DNI'
			  end
  
		end
		go

		create proc USP_Alumno_Update
		  @idAlumno int ,
		  @nombre varchar(50),
		  @apellido varchar(50),
		  @nroDocumento varchar(8),
		  @fechaNacimiento Date,
		  @exito int output,
		  @mensaje varchar(200) output
		as
		begin
		  if exists(select 1 from alumno as a where a.idAlumno =@idAlumno and a.flgEliminar=0)
		  begin
			update alumno 
			set nombre= @nombre,  
				apellido=@apellido,
				nroDocumento=@nroDocumento,
				fechaNacimiento =@fechaNacimiento
				where idAlumno= @idAlumno
			   set @exito = 1
			   set @mensaje='Se actualizo correctamente el alumno'

		  end
		  else
		  begin
			   set @exito = 0
			   set @mensaje='El id no fue encontrado o no existe'
		  end
		end
		go

		create proc USP_Alumno_Eliminar
		  @idAlumno int ,
		  @exito int output,
		  @mensaje varchar(200) output
		as
		begin
		  if exists(select 1 from alumno as a where a.idAlumno =@idAlumno and a.flgEliminar=0)
		  begin
			update alumno 
			set flgEliminar=1  
				where idAlumno= @idAlumno  
						   set @exito = 1
			   set @mensaje='Se elimino correctamente'
		  end
			else
		  begin
			   set @exito = 0
			   set @mensaje='El id no fue encontrado o no existe'
		  end
		end
		go



		create proc USP_Alumno_listar
		  @flgListar int,
		  @exito int output,
		  @mensaje varchar(200) output,
		  @idAlumno int
		as
		begin
		if @flgListar = 1
	begin
		set @exito = 1;
		select * from alumno as a where a.flgEliminar = 0;
	end
	else
	begin
		if exists(select 1 from alumno where idAlumno = @idAlumno and flgEliminar = 0)
		begin
			set @exito = 1;
			select * from alumno as a where a.flgEliminar = 0 and a.idAlumno = @idAlumno;
		end
		else
		begin
			set @exito = 0;
			set @mensaje = 'El alumno con el ID especificado no existe';
		end
	end

	end 
	go