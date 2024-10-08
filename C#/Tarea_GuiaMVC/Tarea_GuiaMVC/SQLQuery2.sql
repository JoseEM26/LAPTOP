CREATE PROC USP_CLIENTE_LISTAR
AS
BEGIN
  SELECT C.IdCliente ,
         C. NomCliente,
		 C.DirCliente,
		 P.NombrePais,
		 C.fonoCliente

  FROM Clientes AS C
  INNER JOIN paises AS P ON P.Idpais = C.idpais
END


CREATE PROC USP_PEDIDO_LISTAR
AS
BEGIN
  SELECT P.IdPedido,
         P.FechaPedido,
		 C.NomCliente,
		 P.DirDestinatario,
         E.ApeEmpleado+' '+E.NomEmpleado AS [Empleado]

  FROM pedidoscabe AS P
  INNER JOIN Clientes AS C ON C.IdCliente=P.IdCliente
  INNER JOIN Empleados AS E ON E.IdEmpleado =P.IdEmpleado
END

EXEC USP_CLIENTE_LISTAR
EXEC USP_PEDIDO_LISTAR

-----------------------------------------------------
-----------------------------------------------------

CREATE OR ALTER PROC USP_PRODUCTO_LISTAR_NOMBRE
@NOMBRE VARCHAR(20)
AS
BEGIN
   SELECT P.IdProducto ,
          P.NomProducto,
		  P.PrecioUnidad,
		  C.NombreCategoria,
		  S.NomProveedor,
		  P.UnidadesEnExistencia AS [Stock]
   FROM Productos AS P
   INNER JOIN Proveedores AS S ON S.IdProveedor =P.IdProveedor
   INNER JOIN Categorias AS C ON C.IdCategoria =P.IdCategoria
   WHERE P.NomProducto LIKE '%'+@NOMBRE+'%' OR @NOMBRE=''
END

EXEC USP_PRODUCTO_LISTAR_NOMBRE 'QUESO'


CREATE OR ALTER PROC USP_PRODUCTO_CATEGORIA
@NOMBRECategoria VARCHAR(100)
AS
BEGIN
   SELECT P.IdProducto ,
          P.NomProducto,
		  P.PrecioUnidad,
		  C.NombreCategoria,
		  S.NomProveedor,
		  P.UnidadesEnExistencia AS [Stock]
   FROM Productos AS P
   INNER JOIN Proveedores AS S ON S.IdProveedor =P.IdProveedor
   INNER JOIN Categorias AS C ON C.IdCategoria =P.IdCategoria
   WHERE C.NombreCategoria  like '%'+@NOMBRECategoria+'%' or @NOMBRECategoria=''
END


exec USP_PRODUCTO_CATEGORIA 'bebidas'




CREATE PROC USP_PRODUCTOlISTAR
AS
BEGIN
  SELECT P.IdProducto ,
          P.NomProducto,
		  P.PrecioUnidad,
		  C.NombreCategoria,
		  S.NomProveedor,
		  P.UnidadesEnExistencia AS [Stock]
  FROM Productos AS P
  INNER JOIN Categorias AS C ON C.IdCategoria=P.IdCategoria
  INNER JOIN Proveedores AS S ON P.IdProveedor=S.IdProveedor
  END

  -------------------------------------------------
  -------------------------------------------------
  -------------------------------------------------
  -------------------------------------------------
  -------------------------------------------------
  -------------------------------------------------
  -------------------------------------------------
  -------------------------------------------------
  CREATE OR ALTER PROC USP_CATEGORIA_LISTAR
  AS
  BEGIN
     SELECT C.IdCategoria,
	        C.NombreCategoria
	 FROM Categorias AS C
  END

   CREATE OR ALTER PROC USP_PROVEDOR_LISTAR
  AS
  BEGIN
     SELECT P.IdProveedor, 
	        P.NomProveedor,
			P.NomContacto
	 FROM Proveedores AS P
  END
  -------------------------------------------------
EXEC USP_CRUD_PRODUCTO 
'INSERTAR',
12, 
'', 
0, 
0,
'',
0,
0
--insert into Productos(
-- NomProducto,
--	   IdProveedor,
--	   IdCategoria,
--	   CantxUnidad,
--	   PrecioUnidad,
--	   UnidadesEnExistencia
--) values(
--'', 
--1, 
--2,
--'',
--0,
--0
--)

select*from Productos

  CREATE OR alter PROC USP_CRUD_PRODUCTO
   @INDICADOR VARCHAR(30),
   @IdProducto INT,
   @NomProducto VARCHAR(40),
   @IdProveedor INT,
   @IdCategoria INT,
   @CantxUnidad VARCHAR(20),
   @PrecioUnidad DECIMAL,
   @UnidadesEnExis SMALLINT,
   @activo bit
  AS
  BEGIN


     IF @INDICADOR='MOSTRARTODO'
	 BEGIN
	    SELECT IdProducto,
		       NomProducto,
			   IdCategoria,
			   IdProveedor,
			   CantxUnidad,
			   PrecioUnidad,
			   UnidadesEnExistencia
		FROM Productos AS P
		WHERE ACTIVO=1
	 END


     IF @INDICADOR='INSERTAR'
	 BEGIN
	   INSERT into Productos(
	   NomProducto,
	   IdProveedor,
	   IdCategoria,
	   CantxUnidad,
	   PrecioUnidad,
	   UnidadesEnExistencia,
	   ACTIVO
	   )VALUES
	   (
       @NomProducto     ,
       @IdProveedor ,
       @IdCategoria ,
       @CantxUnidad ,
       @PrecioUnidad ,
       @UnidadesEnExis ,
	   @activo
	   )
	 END

	 IF @INDICADOR='ACTUALIZAR'
	 BEGIN
	   UPDATE Productos SET
	   NomProducto =@NomProducto  ,
	   IdCategoria =@IdProveedor  ,
	   IdProveedor =@IdCategoria  ,
	   CantxUnidad =@CantxUnidad  ,
	   PrecioUnidad =@PrecioUnidad  ,
	   UnidadesEnExistencia =@UnidadesEnExis
	   WHERE Productos.IdProducto=@IdProducto
	 END

	  IF @INDICADOR='ELIMINAR'
	 BEGIN
	   UPDATE Productos SET ACTIVO=0 
	   WHERE IdProducto=@IdProducto
	 END

	 IF @INDICADOR='lISTARDATOS'
	 BEGIN
	   SELECT IdProducto,
	   NomProducto,
	   IdCategoria,
	   IdProveedor,
	   CantxUnidad,
	   PrecioUnidad,
	   UnidadesEnExistencia
	   FROM Productos
	   WHERE IdProducto=@IdProducto AND
	         ACTIVO=1
	 END

  END



