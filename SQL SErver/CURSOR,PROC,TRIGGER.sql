--Primer ejercisio mostrar datos dentro de un cursor
declare @id varchar(5) ,@nombre varchar(50),@pais varchar(50)

declare cursorcito cursor for
   select c.IdCliente,c.NomCliente,p.NombrePais
   from Clientes as c
   inner join paises as p on p.Idpais=c.idpais

open cursorcito

fetch cursorcito into @id,@nombre,@pais

while @@FETCH_STATUS=0
  begin
     print @id+space(10)+@nombre+space(50-len(@nombre))+@pais
     fetch cursorcito into @id,@nombre,@pais

  end

close cursorcito
deallocate cursorcito

-------------------------------------------
DECLARE @NOMBRE2 VARCHAR(50),@CANTIDAD INT,@ACUMULADOR INT
SET @ACUMULADOR=0

declare cursito cursor for
   select c.NomCliente,count(*)as cantidad
   from Clientes as c
   INNER JOIN pedidoscabe AS P ON 
   P.IdCliente=C.IdCliente
   GROUP BY NomCliente

OPEN CURSITO

FETCH CURSITO INTO @NOMBRE2,@CANTIDAD

WHILE @@FETCH_STATUS=0
BEGIN
  PRINT @NOMBRE2 + SPACE(40-LEN(@NOMBRE2))+ CAST(@CANTIDAD AS VARCHAR)
  SET @ACUMULADOR+=@CANTIDAD
  FETCH CURSITO INTO @NOMBRE2,@CANTIDAD

END

CLOSE CURSITO
DEALLOCATE CURSITO
PRINT REPLICATE('*',50)
PRINT 'SE A ACUMULADO LO QUE ES '+CAST(@ACUMULADOR AS VARCHAR)

------------------------------------------------------
--------------------------Pagina 122--------------------------
--DECLARO VARIABLES DE TRABAJO
DECLARE @Y INT, @Y1 INT, @CODIGO INT, @MONTO DECIMAL, @TOTAL DECIMAL = 0;

-- DECLARO EL CURSOR
DECLARE MI_CURSOR CURSOR FOR
SELECT YEAR(C.FECHAPEDIDO), C.IDPEDIDO, SUM(D.PRECIOUNIDAD * D.CANTIDAD)
FROM PEDIDOSCABE C
JOIN PEDIDOSDETA D ON C.IDPEDIDO = D.IDPEDIDO
GROUP BY YEAR(C.FECHAPEDIDO), C.IDPEDIDO
ORDER BY 1;

-- ABRIR EL CURSOR
OPEN MI_CURSOR;

-- LEER EL PRIMER REGISTRO
FETCH NEXT FROM MI_CURSOR INTO @Y, @CODIGO, @MONTO;

SET @Y1=@Y
PRINT 'AÑO : '+ CAST (@Y AS VARCHAR)
PRINT REPLICATE('*',20)

WHILE @@FETCH_STATUS = 0
BEGIN
  IF @Y1=@Y SET @TOTAL += @MONTO
  ELSE
  BEGIN
    PRINT REPLICATE ('-',30)
	PRINT 'IMPORTE EN  '+CAST (@Y1 AS VARCHAR) +'  ES '+CAST (@TOTAL AS VARCHAR)
    PRINT SPACE(10)
	SET @TOTAL=@MONTO
    SET @Y1=@Y
	PRINT 'AÑO : '+ CAST (@Y1 AS VARCHAR)
    PRINT REPLICATE('*',20)
  END

  PRINT CAST(@CODIGO AS VARCHAR) + SPACE(10) + CAST(@MONTO AS VARCHAR)
  FETCH NEXT FROM MI_CURSOR INTO @Y, @CODIGO, @MONTO;

END

CLOSE MI_CURSOR
DEALLOCATE MI_CURSOR

    PRINT REPLICATE ('-',30)
	PRINT 'IMPORTE EN  '+CAST (@Y1 AS VARCHAR) +'  ES '+CAST (@TOTAL AS VARCHAR)
    PRINT SPACE(10)

-------------------------------------------------------
--------------PAGINA 124-----------------------------------
DECLARE @IDP INT , @NOM VARCHAR, @UNIDAD DECIMAL , @EXIS INT

DECLARE MI_CURSOR CURSOR FOR 
     SELECT P.IdProducto,
	        P.NomProducto,
	        P.PrecioUnidad ,
	        P.UnidadesEnExistencia
	 FROM Productos AS P
	 FOR UPDATE

OPEN MI_CURSOR
FETCH MI_CURSOR INTO @IDP ,@NOM, @UNIDAD,@EXIS

WHILE @@FETCH_STATUS =0
BEGIN
  IF(@EXIS >=1000) SET @UNIDAD=@UNIDAD*0.50
  ELSE SET @UNIDAD=@UNIDAD*0.80

  UPDATE Productos SET PrecioUnidad=@UNIDAD
  WHERE CURRENT OF MI_CURSOR
  PRINT 'SE HIZO EN CAMBIO EN '+ @NOM + 'VALOR ES'+
        CAST(@UNIDAD AS VARCHAR)

FETCH MI_CURSOR INTO @IDP ,@NOM, @UNIDAD,@EXIS

END

CLOSE MI_CURSOR
DEALLOCATE MI_CURSOR




-----------------------------------------------
------USO DE PROCEDURE CON DATOS DE SALIDA-----


CREATE OR ALTER PROCEDURE USP_REPORTEPEDIDOSEMPLEADO
@ID INT,
@Y INT,
@Q INT OUTPUT,
@MONTO DECIMAL OUT
AS
BEGIN
SELECT @Q= COUNT (*), @MONTO = SUM (PRECIOUNIDAD*CANTIDAD)
FROM PEDIDOSCABE PC JOIN PEDIDOSDETA PD
ON PC.IDPEDIDO = PD.IDPEDIDO
WHERE IDEMPLEADO =@ID AND YEAR (FECHAPEDIDO) = @Y
END
GO

DECLARE @v_Q INT, @v_M DECIMAL
EXEC USP_REPORTEPEDIDOSEMPLEADO
2,
1997,
@v_Q OUT,
@v_M OUT
PRINT 'CANTIDAD DE PEDIDOS COLOCADOS: ' + CAST(@v_Q AS VARCHAR)
PRINT 'MONTO PERCIBIDO: ' + CAST(@v_M AS VARCHAR)
GO




---------------------------------------------------------
--------------------PAGINA 140--------------------------------



CREATE OR ALTER PROC USP_INVENTARIO
 AS
 BEGIN

 DECLARE @ID INT,@NOMBRE VARCHAR(50),@PRECIO DECIMAL,@CANTIDAD INT
 DECLARE @ACUMULADO INT=0

   DECLARE MI_CURSOR CURSOR FOR
     SELECT P.IdProducto,
	        P.NomProducto,
			P.PrecioUnidad,
			P.UnidadesEnExistencia
	 FROM Productos AS P

 OPEN MI_CURSOR
 FETCH MI_CURSOR INTO @ID,@NOMBRE,@PRECIO,@CANTIDAD

 PRINT 'ID' +SPACE(10)+'PRODUCTO'+SPACE(50)+'PRECIO'+SPACE(10)+'STOCK'
 PRINT REPLICATE('=',80)

 WHILE @@FETCH_STATUS =0 
 BEGIN
     PRINT CAST(@ID AS VARCHAR)+SPACE(10)+
	       @NOMBRE+SPACE(50-LEN(@NOMBRE))+
		   CAST(@PRECIO AS VARCHAR) +SPACE(10)+
		   CAST(@CANTIDAD AS VARCHAR)

     SET @ACUMULADO+=@CANTIDAD
     FETCH MI_CURSOR INTO @ID,@NOMBRE,@PRECIO,@CANTIDAD

 END

 CLOSE MI_CURSOR
 DEALLOCATE MI_CURSOR

 PRINT 'INVENTARIO DE PRODUCTOS :     '+CAST(@ACUMULADO AS VARCHAR) 

 END

 EXEC USP_INVENTARIO


 SELECT*FROM paises
 ----------------------------------------------------------------------------------------------------------------------------------------------
 ----------------------------------------------------------------------------------------------------------------------------------------------
--CREACION DE PROCEDURE CON EL USO DE MERGE

CREATE OR ALTER PROC USP_ACTUALIZAREMPLEADO
  @IDPAIS CHAR(3),
  @NOMBRE VARCHAR(40)
AS
BEGIN
  MERGE PAISES AS TARGET
  USING (SELECT @IDPAIS,@NOMBRE) AS SOURCE (Idpais,NombrePais)
  ON(TARGET.IDPAIS=SOURCE.IDPAIS)

  WHEN MATCHED THEN 
  UPDATE SET IDPAIS=@IDPAIS,
             NOMBREPAIS=@NOMBRE
  
  WHEN NOT MATCHED THEN
  INSERT VALUES(@IDPAIS ,@NOMBRE);
END

EXEC USP_ACTUALIZAREMPLEADO 1 ,'BRAZILIA'
go

-------------------------------------------------------------
--------------------------------trigger------------------------
CREATE or alter TRIGGER t_crud_paises 
ON paises
FOR DELETE, UPDATE, INSERT
AS
BEGIN
    DECLARE @fecha VARCHAR(50) = RIGHT(GETDATE(), 8);

    -- Verificar si hay registros eliminados
    IF EXISTS (SELECT 0 FROM deleted) 
    BEGIN
        -- Si hay registros en inserted, significa que se actualizó un registro
        IF EXISTS (SELECT 0 FROM inserted) 
        BEGIN
            INSERT INTO control VALUES (SUSER_NAME(), @fecha, 'se actualizó');
        END
        -- Si no hay registros en inserted, significa que se eliminó un registro
        ELSE 
        BEGIN
            INSERT INTO control VALUES (SUSER_NAME(), @fecha, 'se eliminó');
        END
    END
    -- Si no hay registros en deleted, significa que se insertó un nuevo registro
    ELSE 
    BEGIN
        INSERT INTO control VALUES (SUSER_NAME(), @fecha, 'se insertó');
    END
END


update paises
set NombrePais ='NuevaZelanda'
where Idpais=1


----------------------------------------------------
-----------TRIGGER PARA NIVEL DE DDL----------------
USE MASTER
GO
IF EXISTS (SELECT * FROM SYS.SERVER_TRIGGERS
WHERE NAME = 'DDL_TRIGGER_BD')
DROP TRIGGER DDL_TRIGGER_BD
ON ALL SERVER
GO

CREATE TRIGGER DDL_TRIGGER_BD
ON ALL SERVER
FOR CREATE_DATABASE
AS
BEGIN
    DECLARE @MSG NVARCHAR (MAX);
    PRINT 'UD. HA CREADO UNA BASE DE DATOS';
    SELECT @MSG = EVENTDATA().value('(/EVENT_INSTANCE/ObjectName)[1]', 'NVARCHAR(256)');
    PRINT @MSG;
END
GO
