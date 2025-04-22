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

-- Procedimiento para insertar cabecera de venta
CREATE PROC USP_VENTA_INSERTAR
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
CREATE PROC USP_VENTA_INSERTARDET
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
select*from venta
select*from ventaDet