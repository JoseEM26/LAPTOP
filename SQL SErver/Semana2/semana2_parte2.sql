create table PERSONA.estudianteS(
 id char(3),
 nombre varchar(20),
 apellido varchar(20)
)

bulk insert PERSONA.estudianteS
from 'D:\DBA\Semana2\estudiante.csv'
with(
fieldterminator =';',
rowterminator ='\n'
)


select*from PERSONA.estudianteS




------------------------------
------------------------------
------------------------------

---insercion de datos desde xml
SELECT*FROM Cargos FOR XML AUTO

CREATE TABLE clientess (
    id INT,
    nombre NVARCHAR(100)
);

DECLARE @xml XML = '<clientes>
    <cliente>
        <id>1</id>
        <nombre>Juan</nombre>
    </cliente>
    <cliente>
        <id>2</id>
        <nombre>Ana</nombre>
    </cliente>
</clientes>';

INSERT INTO clientess (id, nombre)
SELECT
    cliente.value('(id)[1]', 'INT') AS id,
    cliente.value('(nombre)[1]', 'NVARCHAR(100)') AS nombre
FROM
    @xml.nodes('/clientes/cliente') AS cliente(cliente);

	select*from clientess


	------------------------------------------------------
	--HACEMOS UN MERGE PARA HACER COMO UN IF ELSE EN LO QUE ES INSERTAR O ACTUALIZA5.
USE NEGOCIOS
GO
select*from paises

DECLARE @PAIS VARCHAR (50),@ID CHAR (3)

SET @PAIS='kenia'
SET @ID='001'

MERGE PAISES AS TARGET
USING (SELECT @ID, @PAIS) AS SOURCE (IDPAIS, NOMBREPAIS)
ON (TARGET.IDPAIS = SOURCE.IDPAIS)
WHEN MATCHED THEN
UPDATE SET NOMBREPAIS = SOURCE.NOMBREPAIS
WHEN NOT MATCHED THEN
INSERT VALUES (SOURCE.IDPAIS, SOURCE.NOMBREPAIS);

--actualizar o eliminar -----mergeUSE NEGOCIOS;
GO

-- Crear tabla CLIENTES
CREATE TABLE CLIENTES (
    IDCLIENTE VARCHAR(25),
    NOMCLIENTE VARCHAR(52),
    DIRCLIENTE VARCHAR(25)
);

-- Insertar datos en CLIENTES
INSERT INTO CLIENTES (IDCLIENTE, NOMCLIENTE, DIRCLIENTE) VALUES ('C001', 'Juan', 'Calle1');
INSERT INTO CLIENTES (IDCLIENTE, NOMCLIENTE, DIRCLIENTE) VALUES ('C002', 'Ana', 'Calle2');

-- Crear tabla CLIENTESBAK
CREATE TABLE CLIENTESBAK (
    IDCLIENTE VARCHAR(25),
    NOMCLIENTE VARCHAR(25),
    DIRCLIENTE VARCHAR(25)
);

-- Insertar datos en CLIENTESBAK
INSERT INTO CLIENTESBAK (IDCLIENTE, NOMCLIENTE, DIRCLIENTE) VALUES ('C001', 'Juan', 'Calle1');
INSERT INTO CLIENTESBAK (IDCLIENTE, NOMCLIENTE, DIRCLIENTE) VALUES ('C002', 'Ana', 'Calle2');

-- Realizar el MERGE
MERGE INTO CLIENTESBAK AS TARGET
USING CLIENTES AS SOURCE
ON TARGET.IDCLIENTE = SOURCE.IDCLIENTE
WHEN MATCHED AND TARGET.NOMCLIENTE <> SOURCE.NOMCLIENTE THEN
    UPDATE SET TARGET.NOMCLIENTE = SOURCE.NOMCLIENTE,
               TARGET.DIRCLIENTE = SOURCE.DIRCLIENTE
WHEN NOT MATCHED BY TARGET THEN
    INSERT (IDCLIENTE, NOMCLIENTE, DIRCLIENTE)
    VALUES (SOURCE.IDCLIENTE, SOURCE.NOMCLIENTE, SOURCE.DIRCLIENTE)
WHEN NOT MATCHED BY SOURCE THEN
    DELETE;
