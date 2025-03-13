SELECT*FROM paises


--INSERT INTO SIMPLE
INSERT INTO Clientes(
IdCliente,
NomCliente,
DirCliente,
idpais,
fonoCliente)VALUES
('AAAA','JOSE','SSS','003','324455')


INSERT INTO paises VALUES
('111','VENEZUELA'),
('121','VENEZUELA'),
('113','VENEZUELA')


CREATE TABLE EMPLEADOS2011
(
IDEMPLEADO INT NOT NULL,
NOMEMPLEADO VARCHAR (50) NOT NULL,
APEEMPLEADO VARCHAR (50) NOT NULL,
FONOEMPLEADO VARCHAR (15) NULL,
DIREMPLEADO VARCHAR (100) NOT NULL,
IDDISTRITO INT NOT NULL
)


--INSERTAR EN UNA TABLA NUEVA ATRAVEZ DE UN SELECT
INSERT INTO EMPLEADOS2011 
SELECT A.IDEMPLEADO, A.NOMEMPLEADO, A.APEEMPLEADO,
A.FONOEMPLEADO,A.DIREMPLEADO,A.IDDISTRITO
FROM EMPLEADOS AS A
WHERE YEAR (A.FECCONTRATA) = '2011'
GO

SELECT * FROM EMPLEADOS 
GO--CREACION DE UNA TABLA TEMPORAL CON INSERCION-- Crear una variable tipo tabla
DECLARE @PRODUCTOS TABLE (
    PRODUCTOID INT,
    PRODUCTONOMBRE NVARCHAR(255),
    PRODUCTOPRE DECIMAL(18, 2),
    PRODUCTOCAN INT
);

-- Insertar datos en la variable tipo tabla desde la tabla PRODUCTOS
INSERT INTO @PRODUCTOS (PRODUCTOID, PRODUCTONOMBRE, PRODUCTOPRE, PRODUCTOCAN)
SELECT IDPRODUCTO, NOMPRODUCTO, PRECIOUNIDAD, UNIDADESENEXISTENCIA
FROM PRODUCTOS
WHERE PRECIOUNIDAD > 100;

-- Ver los valores de la variable tipo tabla
SELECT * FROM @PRODUCTOS;


select*from clientes

BULK INSERT clientes
FROM 'D:\DBA\Semana2\clientes.txt'
 with(fieldterminator=',',firstrow=2)



BULK INSERT Cargos
FROM 'D:\DBA\Semana2\cargos.csv'
WITH
(
format='csv',
    FIELDTERMINATOR = ';',   -- El delimitador de campos es la coma
    ROWTERMINATOR = '0x0a',    -- El delimitador de filas es el salto de línea
    FIRSTROW = 1,             -- Comenzar desde la segunda fila si la primera es el encabezado
	fieldquote='\'
);

