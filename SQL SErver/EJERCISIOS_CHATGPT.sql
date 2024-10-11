-------------------------------------------INNER JOIN------------------------------------------
--Ejercicio 1: Obtener una lista de todos los productos con su proveedor y categoría.
SELECT *
FROM Productos AS P
INNER JOIN Proveedores AS S ON S.IdProveedor=P.IdProveedor
INNER JOIN Categorias AS C ON C.IdCategoria=P.IdCategoria

--Ejercicio 2: Listar todos los empleados junto con su distrito y cargo.
 SELECT*
 FROM Empleados AS E
 INNER JOIN Distritos AS D ON E.idDistrito=D.idDistrito
 INNER JOIN Cargos AS C ON C.idcargo=E.idCargo

 --Ejercicio 3: Mostrar los pedidos junto con el nombre del cliente y el nombre del empleado que los gestionó.
 SELECT C.IdPedido,
        CL.NomCliente,
		E.NomEmpleado
 FROM pedidoscabe AS C 
 INNER JOIN Clientes AS CL ON CL.IdCliente =C.IdCliente
 INNER JOIN Empleados AS E ON E.IdEmpleado=C.IdEmpleado

 --Ejercicio 4: Obtener el total de productos por proveedor, mostrando el nombre del proveedor 
 --y la cantidad total de productos.
 SELECT 
        PR.NomProveedor,
		COUNT(*)
 FROM Productos AS P
 INNER JOIN Proveedores AS PR ON PR.IdProveedor=P.IdProveedor
 GROUP BY(PR.NomProveedor)

 --Ejercicio 5: Listar los clientes que han realizado pedidos, junto con la cantidad de pedidos realizados.
SELECT CL.NomCliente,
       COUNT(C.IdCliente)
FROM pedidoscabe AS C
INNER JOIN Clientes AS CL ON CL.IdCliente=C.IdCliente
GROUP BY(CL.NomCliente)

--------------------------------------Ejercicios con Subconsultas
--Ejercicio 1: Obtener la lista de productos cuyo precio es mayor que el precio 
--promedio de todos los productos.

SELECT P.NomProducto
FROM Productos AS P
WHERE P.PrecioUnidad>(SELECT AVG(PR.PrecioUnidad)
                      FROM Productos AS PR

)

--Ejercicio 2: Mostrar los empleados que están en un distrito donde hay más de 10 empleados.
SELECT 
    NomEmpleado, 
    ApeEmpleado 
FROM 
    Empleados 
WHERE 
    IdDistrito IN (SELECT IdDistrito
	               FROM Empleados 
				   GROUP BY IdDistrito 
				   HAVING COUNT(*) > 2);

--Ejercicio 3: Listar los clientes que viven en el mismo país que un proveedor específico.

SELECT C.NomCliente
FROM Clientes AS C
WHERE C.idpais = (SELECT P.idpais
                   FROM Proveedores AS P
				   WHERE NomProveedor='Exotic Liquids'
					)

--Ejercicio 5: Mostrar los pedidos cuya cantidad es 
--mayor que la media de las cantidades de todos los pedidos.
SELECT IdPedido,P.CantidaPedido
FROM pedidoscabe AS P
WHERE P.CantidaPedido > (SELECT AVG(PE.CantidaPedido) FROM pedidoscabe AS PE)


------------------------------------Ejercicios con CASE
--Ejercicio 1: Clasificar los productos como "Caro", "Moderado" o "Barato" según su precio.
SELECT P.NomProducto,
       CASE
	     WHEN P.PrecioUnidad<= 10 THEN 'BARATO'
	     WHEN P.PrecioUnidad>10 AND P.PrecioUnidad<50 THEN 'MEDIO'
	     WHEN P.PrecioUnidad>=50 THEN 'CARO'
	   END AS 'RANGO'
FROM Productos AS P

--Ejercicio 2: Mostrar el nombre del cliente junto con un estado 
--que indica si ha realizado pedidos ("Sí" o "No").

SELECT C.NomCliente,
      CASE
	    WHEN P.IdCliente IS NOT NULL THEN 'SI'
		ELSE 'NO'
	  END
FROM Clientes AS C
LEFT JOIN pedidoscabe AS P ON P.IdCliente=C.IdCliente

--Ejercicio 3: Indicar el nivel de salario de los empleados como 
--"Alto", "Medio" o "Bajo". (Asumiendo que se añade el salario a la tabla empleados)

	SELECT 
    NomEmpleado, 
    Salario, 
    CASE 
        WHEN Salario > 5000 THEN 'Alto'
        WHEN Salario BETWEEN 3000 AND 5000 THEN 'Medio'
        ELSE 'Bajo' 
    END AS NivelSalario 
FROM 
    Empleados;

	--Ejercicio 4: Mostrar los pedidos indicando si la cantidad 
	--es "Alta" (mayor a 10) o "Baja" (10 o menor).
	SELECT 
    IdPedido, 
    CantidaPedido, 
    CASE 
        WHEN CantidaPedido > 10 THEN 'Alta' 
        ELSE 'Baja' 
    END AS TipoCantidad 
FROM 
    PedidosCabe;


--Ejercicio 5: Clasificar los proveedores según la cantidad de 
--productos que tienen: "Pocos", "Moderados" o "Muchos".

SELECT P.NomProveedor,
       CASE
	     WHEN COUNT(PR.IdProducto) < 5 THEN 'Pocos'
        WHEN COUNT(PR.IdProducto) BETWEEN 5 AND 10 THEN 'Moderados'
        ELSE 'Muchos'  
	   END
FROM Proveedores  AS P
LEFT JOIN Productos AS PR ON PR.IdProveedor =P.IdProveedor
GROUP BY P.NomProveedor


-----------------------------Ejercicios con GROUP BY
--Ejercicio 1: Contar el número de productos por categoría.

SELECT COUNT(P.IdProducto),
        P.NomProducto
FROM Productos AS P
LEFT JOIN Categorias AS C ON P.IdCategoria=C.IdCategoria
GROUP BY P.NomProducto

--Ejercicio 3: Listar la cantidad total de pedidos por cliente.
SELECT C.NomCliente,
       COUNT(*)
FROM pedidoscabe AS P
RIGHT JOIN Clientes AS C ON C.IdCliente=P.IdCliente
GROUP BY C.NomCliente

--Ejercicio 4: Mostrar el total de productos vendidos por cada proveedor.











