
CREATE TABLE ESTUDIANTE(
  NOMBRE VARCHAR(20),
  APELLIDO VARCHAR(20),
  ID CHAR(2)
)

ALTER TABLE ESTUDIANTE
ALTER COLUMN ID SMALLINT

BULK INSERT ESTUDIANTE
FROM 'C:\Users\JOSE ANGEL\Pictures\LAPTOP\SQL SErver\ESTUDIANTE.CSV'
WITH(FIRSTROW=2,FIELDTERMINATOR=';',ROWTERMINATOR='\n')

SELECT*FROM ESTUDIANTE