use master 
go
use PRUEBA
go
create table Alumno(
  idAlumno int primary key,
  nombre varchar(50), 
  nroDocumento varchar(10), 
  fecha date, 
  ciclo varchar(10), 
  promedio int, 
  flgEliminado int 
)
go

create table CursoAlumno(
  idCursoAlumno int primary key,
  idAlumno int ,
  curso varchar(50),
  nota int,
  fechaRegistro date,
  fechaActualizado date,
  flgEliminado int

)
go
INSERT INTO Alumno (idAlumno, nombre, nroDocumento, fecha, ciclo, promedio, flgEliminado)
VALUES
(1, 'Carlos Pérez', '12345678', '2024-03-15', '3', 14, 0),
(2, 'María Gómez', '87654321', '2024-03-16', '2', 16, 0),
(3, 'Luis Torres', '45678912', '2024-03-17', '1', 12, 0),
(4, 'Ana Rodríguez', '23456789', '2024-03-18', '4', 17, 0),
(5, 'José Espinoza', '34567890', '2024-03-19', '3', 15, 0);
go
INSERT INTO CursoAlumno (idCursoAlumno, idAlumno, curso, nota, fechaRegistro, fechaActualizado, flgEliminado)
VALUES
(1, 1, 'Matemática', 15, '2024-04-01', NULL, 0),
(2, 1, 'Programación', 14, '2024-04-01', NULL, 0),
(3, 2, 'Matemática', 17, '2024-04-02', NULL, 0),
(4, 2, 'Estadística', 15, '2024-04-02', NULL, 0),
(5, 3, 'Programación', 13, '2024-04-03', NULL, 0),
(6, 4, 'Contabilidad', 18, '2024-04-04', NULL, 0),
(7, 5, 'Sistemas Operativos', 16, '2024-04-05', NULL, 0);
GO
create or alter proc USP_ALUMNO_INSERTAR
  @nombre varchar(50), 
  @nroDocumento varchar(10), 
  @fecha date, 
  @ciclo varchar(10), 
  @promedio int,
  @idAlumno int output
as
begin
  set @idAlumno = isnull((select MAX(a.idAlumno) from Alumno as a),0)+1
  insert into Alumno (idAlumno,nombre,nroDocumento,fecha,ciclo,promedio,flgEliminado)
              values(@idAlumno,@nombre,@nroDocumento,@fecha,@ciclo,@promedio,0)
end
go

create or alter proc USP_CURSO_INSERTAR
  @idAlumno int ,
  @curso varchar(50),
  @nota int,
  @fechaRegistro date
  --@fechaActualizado date
as
begin
  declare @idCURSO int = isnull((select MAX(a.idCursoAlumno) from CursoAlumno as a),0)+1
  insert into CursoAlumno (idCursoAlumno,idAlumno,curso,nota,fechaRegistro,fechaActualizado,flgEliminado)
              values(@idCURSO,@idAlumno,@curso,@nota,@fechaRegistro,null,0)
end
go

create proc USP_ALUMNO_LISTAR
 @idAlumno int ,
  @flgListar int	
as
begin
 if @flgListar =1
 begin
  select*from Alumno where flgEliminado=0
 end
 if @flgListar=2
 begin
  select*from Alumno where idAlumno=@idAlumno and flgEliminado=0
  select *from CursoAlumno where idAlumno=@idAlumno and flgEliminado=0
 end
end
go
create proc USP_ACTUALIZAR_ALUMNO
  @idAlumno int ,
  @nombre varchar(50), 
  @nroDocumento varchar(10), 
  @ciclo varchar(10), 
  @promedio int
as
begin
 update alumno set
  nombre=@nombre,
  nroDocumento=@nroDocumento,
  ciclo=@ciclo,
  promedio=@promedio
  where idAlumno=@idAlumno
end
go
create proc USP_ACTUALIZAR_CURSO
  @idCursoAlumno int,
  @curso varchar(50),
  @nota int,
  @fechaActualizado date
as
begin
 update CursoAlumno set
  curso=@curso,
  nota=@nota,
  fechaActualizado=@fechaActualizado
  where
   idCursoAlumno=@idCursoAlumno
end
go

create proc USP_ALUMNO_DELETE
 @idAlumno int 
as
begin
  update Alumno set
  flgEliminado=1
  where idAlumno=@idAlumno

  update CursoAlumno set
  flgEliminado=1
  where idAlumno=@idAlumno
end
go

create proc USP_CURSO_DELETE
 @idCurso int
as
begin
update CursoAlumno set flgEliminado=1 where idCursoAlumno=@idCurso
end
go

select*from Alumno
go
select*from CursoAlumno
go
