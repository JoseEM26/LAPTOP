USE master
GO

USE bd_hr
GO

-- Crear tabla Venta
CREATE TABLE Venta(
  idVenta INT PRIMARY KEY,
  cliente VARCHAR(50),
  nroDocumento VARCHAR(8),
  fechaVenta DATE,
  subTotal DECIMAL(18, 4),
  igv DECIMAL(18, 4),
  total DECIMAL(18, 4),
  flgEliminado INT
)
GO

-- Crear tabla ventaDet
CREATE TABLE ventaDet(
  idVentaDet INT PRIMARY KEY,
  idVenta INT,
  producto VARCHAR(50),
  cantidad INT,
  precio DECIMAL(18, 4),
  subTotal DECIMAL(18, 4),
  igv DECIMAL(18, 4),
  total DECIMAL(18, 4),
  flgEliminado INT
)
GO
-- Insertar datos en la tabla Venta
INSERT INTO Venta (idVenta, cliente, nroDocumento, fechaVenta, subTotal, igv, total, flgEliminado)
VALUES 
(1, 'Juan Perez', '12345678', '2025-04-01', 150.00, 27.00, 177.00, 0),
(2, 'Maria Lopez', '23456789', '2025-04-02', 200.00, 36.00, 236.00, 0),
(3, 'Carlos Gomez', '34567890', '2025-04-03', 300.00, 54.00, 354.00, 0),
(4, 'Ana Torres', '45678901', '2025-04-04', 120.00, 21.60, 141.60, 0),
(5, 'Pedro Ruiz', '56789012', '2025-04-05', 250.00, 45.00, 295.00, 0),
(6, 'Laura Martinez', '67890123', '2025-04-06', 180.00, 32.40, 212.40, 0),
(7, 'Luis Fernandez', '78901234', '2025-04-07', 220.00, 39.60, 259.60, 0),
(8, 'Marta Garcia', '89012345', '2025-04-08', 170.00, 30.60, 200.60, 0),
(9, 'Jorge Sanchez', '90123456', '2025-04-09', 280.00, 50.40, 330.40, 0),
(10, 'Isabel Diaz', '01234567', '2025-04-10', 130.00, 23.40, 153.40, 0);
go
-- Insertar datos en la tabla ventaDet
INSERT INTO ventaDet (idVentaDet, idVenta, producto, cantidad, precio, subTotal, igv, total, flgEliminado)
VALUES
(1, 1, 'Producto A', 2, 50.00, 100.00, 18.00, 118.00, 0),
(2, 1, 'Producto B', 1, 50.00, 50.00, 9.00, 59.00, 0),
(3, 2, 'Producto C', 3, 60.00, 180.00, 32.40, 212.40, 0),
(4, 2, 'Producto D', 1, 20.00, 20.00, 3.60, 23.60, 0),
(5, 3, 'Producto E', 5, 50.00, 250.00, 45.00, 295.00, 0),
(6, 3, 'Producto F', 1, 50.00, 50.00, 9.00, 59.00, 0),
(7, 4, 'Producto G', 1, 120.00, 120.00, 21.60, 141.60, 0),
(8, 5, 'Producto H', 3, 70.00, 210.00, 37.80, 247.80, 0),
(9, 6, 'Producto I', 2, 90.00, 180.00, 32.40, 212.40, 0),
(10, 7, 'Producto J', 2, 110.00, 220.00, 39.60, 259.60, 0),
(11, 8, 'Producto K', 1, 170.00, 170.00, 30.60, 200.60, 0),
(12, 9, 'Producto L', 3, 90.00, 270.00, 48.60, 318.60, 0),
(13, 10, 'Producto M', 1, 130.00, 130.00, 23.40, 153.40, 0);
go
--truncate table venta 
--truncate table ventaDet 

-- Procedimiento para insertar cabecera de venta
CREATE or alter PROC USP_VENTA_INSERTAR
  @cliente VARCHAR(50),
  @nroDocumento VARCHAR(8),
  @fechaVenta DATE,
  @subTotal DECIMAL(18, 4),
  @igv DECIMAL(18, 4),
  @total DECIMAL(18, 4),
  @idVenta INT OUTPUT
AS
BEGIN
   SET @idVenta = ISNULL((SELECT MAX(a.idVenta) FROM Venta AS a), 0) + 1

   INSERT INTO Venta(idVenta, cliente, nroDocumento, fechaVenta, subTotal, igv, total, flgEliminado)
   VALUES (@idVenta, @cliente, @nroDocumento, @fechaVenta, @subTotal, @igv, @total, 0)
END
GO

-- Procedimiento para insertar detalle de venta
CREATE or alter PROC USP_VENTA_INSERTARDET
  @idVenta INT,
  @producto VARCHAR(50),
  @cantidad INT,
  @precio DECIMAL(18, 4),
  @subTotal DECIMAL(18, 4),
  @igv DECIMAL(18, 4),
  @total DECIMAL(18, 4)
AS 
BEGIN
   DECLARE @idVentaDet INT = ISNULL((SELECT MAX(a.idVentaDet) FROM ventaDet AS a), 0) + 1

   INSERT INTO ventaDet(idVentaDet, idVenta, producto, cantidad, precio, subTotal, igv, total, flgEliminado)
   VALUES (@idVentaDet, @idVenta, @producto, @cantidad, @precio, @subTotal, @igv, @total, 0)
END
GO

create or alter proc USP_VENTA_LISTAR
@flgListar int,
@idVenta int,
@idVentaDet int
as
begin
  if @flgListar =1
  begin
  select*from Venta where flgEliminado=0
  end
  if @flgListar=2
  begin
  select * from ventaDet where flgEliminado=0
  end
  if @flgListar=3
  begin
   select * from venta where idVenta=@idVenta and flgEliminado=0
  end
  if @flgListar=4
  begin
    select*from ventaDet where idVentaDet=@idVenta and idVenta=@idVenta and flgEliminado=0
  end
  if @flgListar=5
  begin
    select * from ventaDet where idVenta=@idVenta
  end
 
end
go

create or alter proc USP_VENTA_ACTUALIZAR
  @idVenta INT ,
  @cliente VARCHAR(50),
  @nroDocumento VARCHAR(8)
as 
begin
  update venta set 
  cliente=@cliente,
  nroDocumento=@nroDocumento
  where idVenta=@idVenta
end
go

create or alter proc USP_VENTA_DELETE
 @idVenta int
as
begin
 update Venta
 set flgEliminado=1
 where idVenta=@idVenta

  update ventaDet
 set flgEliminado=1
 where idVenta=@idVenta

end
go

create or alter proc USP_VENTADetalle_DELETE
 @idVenta int,
 @idVentaDet int
as
begin
 update ventaDet
 set flgEliminado=1
 where idVenta=@idVenta and idVentaDet=@idVentaDet

 declare @igvRestante decimal(18,4)= (select v.igv from Venta as v where idVenta=@idVenta)-(select v.igv from ventaDet as v where idVentaDet=@idVentaDet)
 declare @totalRestante decimal(18,4)=(select v.total from Venta as v where idVenta=@idVenta)-(select v.total from ventaDet as v where idVentaDet=@idVentaDet)
 declare @subTotalRestante decimal(18,4)=(select v.subTotal from Venta as v where idVenta=@idVenta)-(select v.subTotal from ventaDet as v where idVentaDet=@idVentaDet)

 update Venta set
 igv=@igvRestante,
 subTotal=@subTotalRestante,
 total=@totalRestante
 where idVenta=@idVenta
end
go

create or alter proc USP_VENTADETALLE_ACTUALIZAR
  @idVentaDet INT,
  @idVenta INT,
  @producto VARCHAR(50),
  @cantidad INT,
  @precio DECIMAL(18, 4)
  --@subTotal DECIMAL(18, 4),
  --@igv DECIMAL(18, 4),
  --@total DECIMAL(18, 4)
as
begin
   update ventaDet set
   cantidad=@cantidad,
   producto=@producto,
   precio=@precio,
   subTotal=@precio*@cantidad,
   igv=(@precio*@cantidad)*0.18,
   total=(@precio*@cantidad)+((@precio*@cantidad)*0.18)
   where idVentaDet=@idVentaDet and idVenta=@idVenta

   declare @sumaSubTotal decimal(18,4) = isnull((select SUM(v.subTotal) from ventaDet as v where v.idVenta=@idVenta),0)
   declare @sumaIGV decimal(18,4) = isnull((select SUM(v.igv) from ventaDet as v where v.idVenta=@idVenta),0)
   declare @sumaTotal decimal(18,4) = isnull((select SUM(v.total) from ventaDet as v where v.idVenta=@idVenta),0)

   update Venta set
   subTotal=@sumaSubTotal,
   igv=@sumaIGV,
   total=@sumaTotal
   where idVenta=@idVenta

end
go
 
select*from venta
go
select*from ventaDet
go