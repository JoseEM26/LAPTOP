	-- Crear la base de datos y utilizarla
	CREATE DATABASE IF NOT EXISTS ExploraPeru;
	USE ExploraPeru;

	-- Crear tabla Roles
	CREATE TABLE IF NOT EXISTS Roles (
		id_rol INT AUTO_INCREMENT PRIMARY KEY,
		nombre_rol VARCHAR(50) NOT NULL
	);

	-- Insertar datos en la tabla Roles
	INSERT INTO Roles (nombre_rol) VALUES ('Usuario');
	INSERT INTO Roles (nombre_rol) VALUES ('Administrador');

	-- Crear tabla Usuarios (después de Roles)
	CREATE TABLE IF NOT EXISTS Usuarios (
		id_usuario INT AUTO_INCREMENT PRIMARY KEY,
		nombre_usuario VARCHAR(50) NOT NULL,
		email VARCHAR(100) NOT NULL UNIQUE,
		contraseña VARCHAR(255) NOT NULL,
		telefono VARCHAR(15),
		id_rol INT NOT NULL,
		fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
		fecha_cumpleaños DATE,
		img TEXT,
		FOREIGN KEY (id_rol) REFERENCES Roles(id_rol)
	);

	-- Insertar datos en la tabla Usuarios
	INSERT INTO Usuarios (nombre_usuario, email, contraseña, telefono, id_rol, fecha_cumpleaños, img)
	VALUES 
	('Juan Pérez', 'juan.perez@gmail.com', 'contrasena123', '987654321', 1, '1990-06-15', 'https://images.pexels.com/photos/2379004/pexels-photo-2379004.jpeg?auto=compress&cs=tinysrgb&w=600'),
	('Ana López', 'ana.lopez@hotmail.com', 'contrasena456', '989123456', 1, '1988-04-20', 'https://images.pexels.com/photos/774909/pexels-photo-774909.jpeg?auto=compress&cs=tinysrgb&w=600'),
	('Carlos Díaz', 'carlos.diaz@gmail.com', 'contrasena789', '986543210', 1, '1995-12-25', 'https://images.pexels.com/photos/6801642/pexels-photo-6801642.jpeg?auto=compress&cs=tinysrgb&w=600'),
	('María García', 'maria.garcia@gmail.com', 'admin12345', '988765432', 2, '1985-03-10', 'https://images.pexels.com/photos/415829/pexels-photo-415829.jpeg?auto=compress&cs=tinysrgb&w=600'),
	('Pedro Fernández', 'pedro.fernandez@hotmail.com', 'admin54321', '987123456', 2, '1992-07-18', 'https://images.pexels.com/photos/697509/pexels-photo-697509.jpeg?auto=compress&cs=tinysrgb&w=600');

	-- Crear tabla CLIENTES
	CREATE TABLE IF NOT EXISTS CLIENTES (
		id_cliente INT AUTO_INCREMENT PRIMARY KEY,
		nombre_cliente VARCHAR(100) NOT NULL,
		email VARCHAR(100) NOT NULL UNIQUE,
		telefono VARCHAR(15) NOT NULL
	);

	-- Crear tabla ALOJAMIENTO
	CREATE TABLE IF NOT EXISTS ALOJAMIENTO (
		id_alojamiento INT AUTO_INCREMENT PRIMARY KEY,
		nombre VARCHAR(100) NOT NULL,
		ubicacion VARCHAR(150) NOT NULL,
		tipo ENUM('Hotel', 'Casa vacacional', 'Lodge') NOT NULL,
		precio_noche DECIMAL(10, 2) NOT NULL,
		disponible ENUM('Sí', 'No') NOT NULL,
		capacidad INT NOT NULL
	);

	-- Crear tabla RESERVAS_ALOJAMIENTO
	CREATE TABLE IF NOT EXISTS RESERVAS_ALOJAMIENTO (
		id_reserva INT AUTO_INCREMENT PRIMARY KEY,
		id_cliente INT NOT NULL,
		id_alojamiento INT NOT NULL,
		fecha_inicio DATE NOT NULL,
		fecha_fin DATE NOT NULL,
		cantidad_personas INT NOT NULL,
		total DECIMAL(10, 2) NOT NULL,
		FOREIGN KEY (id_cliente) REFERENCES CLIENTES(id_cliente),
		FOREIGN KEY (id_alojamiento) REFERENCES ALOJAMIENTO(id_alojamiento)
	);

	-- Crear tabla DESTINOS
	CREATE TABLE IF NOT EXISTS DESTINOS (
		id_destino INT NOT NULL PRIMARY KEY, 
		destino VARCHAR(100) NOT NULL,       
		descripcion VARCHAR(255) NOT NULL    
	);
	-- Insertar datos en la tabla DESTINOS
	INSERT INTO DESTINOS (id_destino, destino, descripcion) VALUES
(1, 'Cusco', 'Una ciudad histórica conocida por su cercanía al Machu Picchu.'),
(2, 'Arequipa', 'La ciudad blanca famosa por su arquitectura colonial.'),
(3, 'Iquitos', 'La ciudad más grande de la Amazonía peruana.'),
(4, 'Trujillo', 'Conocida por su cultura precolombina y playas.'),
(5, 'Piura', 'Famosa por sus hermosas playas y clima cálido.'),
(6, 'Tacna', 'Una ciudad cercana a la frontera con Chile.'),
(7, 'Pucallpa', 'Ubicada en la región amazónica, conocida por sus paisajes naturales.'),
(8, 'Tarapoto', 'Otra ciudad amazónica famosa por sus cataratas y biodiversidad.'),
(9, 'Lima', 'La capital del Perú, famosa por su gastronomía y cultura.'),
(10, 'Nazca', 'Famoso por las misteriosas Líneas de Nazca.'),
(11, 'Puno', 'Conocida por el Lago Titicaca y su cultura andina.'),
(12, 'Huaraz', 'Destino montañés conocido por su belleza natural y actividades de trekking.'),
(13, 'Ica', 'Famoso por las dunas de arena y el oasis de Huacachina.'),
(14, 'Lambayeque', 'Conocida por sus ruinas arqueológicas, como el Templo de Tucume.'),
(15, 'Chiclayo', 'Una ciudad costera conocida por su gastronomía y su historia arqueológica.'),
(16, 'Junín', 'Conocida por la laguna de Junín y su biodiversidad.'),
(17, 'Huancavelica', 'Famosa por su minería y paisajes andinos.'),
(18, 'Huánuco', 'Conocida por su clima cálido y sus montañas.'),
(19, 'Apurímac', 'Famosa por sus hermosos paisajes naturales.'),
(20, 'Ayacucho', 'Conocida por sus iglesias coloniales y paisajes montañosos.'),
(21, 'Cajamarca', 'Famosa por su historia y la plaza de armas colonial.'),
(22, 'Callao', 'Puerto principal del Perú, conocido por su terminal marítimo y la Fortaleza Real Felipe.'),
(23, 'Cusco', 'Una ciudad histórica conocida por su cercanía al Machu Picchu.'),
(24, 'Loreto', 'Conocida por su biodiversidad amazónica y el río Amazonas.'),
(25, 'Madre de Dios', 'Destino para los amantes de la biodiversidad y ecoturismo en la Amazonía.'),
(26, 'Moquegua', 'Conocida por sus viñedos y paisajes desérticos.'),
(27, 'Pasco', 'Conocida por su biodiversidad y las minas de oro.'),
(28, 'Piura', 'Famosa por sus hermosas playas y clima cálido.'),
(29, 'Puno', 'Conocida por el Lago Titicaca y su cultura andina.'),
(30, 'San Martín', 'Conocida por su selva tropical y biodiversidad.'),
(31, 'Tacna', 'Una ciudad cercana a la frontera con Chile.'),
(32, 'Tumbes', 'Conocida por sus playas y el clima tropical.'),
(33, 'Ucayali', 'Conocida por la ciudad de Pucallpa y su biodiversidad amazónica.');

	-- Crear tabla VUELOS
	CREATE TABLE IF NOT EXISTS VUELOS (
		id_vuelo INT AUTO_INCREMENT PRIMARY KEY, 
		id_destino INT NOT NULL,                 
		fecha_salida DATE NOT NULL,
		fecha_llegada DATE NOT NULL,
		precio DECIMAL(10, 2) NOT NULL,
		plazas_disponibles INT NOT NULL,
		imagen_url VARCHAR(255),  -- URL de la imagen del vuelo
		lugar VARCHAR(100),       -- Descripción del lugar o ciudad de destino
		FOREIGN KEY (id_destino) REFERENCES DESTINOS(id_destino) 
	);

	-- Insertar datos en la tabla VUELOS
	INSERT INTO VUELOS (id_destino, fecha_salida, fecha_llegada, precio, plazas_disponibles, imagen_url, lugar) VALUES
	(1, '2024-12-15', '2024-12-15', 120.00, 25, 'https://images.pexels.com/photos/2929906/pexels-photo-2929906.jpeg', 'Machu Picchu'),
	(2, '2024-12-16', '2024-12-16', 110.00, 30, 'https://images.pexels.com/photos/16932757/pexels-photo-16932757/free-photo-of-ciudad-vacaciones-punto-de-referencia-viaje.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1', 'Catedral de Arequipa'),
	(3, '2024-12-17', '2024-12-17', 130.00, 20, 'https://peruconstruye.net/wp-content/uploads/2024/10/iquitos-puerto-1-compressed.jpg.webp', 'Puerto de Iquitos'),
	(4, '2024-12-18', '2024-12-18', 150.00, 18, 'https://i.ytimg.com/vi/tBkF0hqNV6E/maxresdefault.jpg', 'Plaza de Armas de Trujillo'),
	(5, '2024-12-19', '2024-12-19', 140.00, 22, 'https://perutogethertravel.com/wp-content/uploads/2021/10/playa-mancora-piura.png', 'Playa de Máncora, Piura'),
	(6, '2024-12-20', '2024-12-20', 100.00, 35, 'https://noticias-pe.laiglesiadejesucristo.org/media/960x540/Tacna.jpg', 'Plaza de Armas de Tacna'),
	(7, '2024-12-21', '2024-12-21', 160.00, 15, 'https://viajeroperuano.com/wp-content/uploads/2013/01/Promocion-LAN-Lima-Pucallpa-Lima-59-dolares-e1430939608548.jpg', 'Laguna Yarinacocha en Pucallpa'),
	(8, '2024-12-22', '2024-12-22', 80.00, 40, 'https://tarapoto.tours/wp-content/uploads/2019/01/Ahuashiyacu-8-1.jpg', 'Catarata de Ahuashiyacu');

	-- Crear tabla RESERVAS_VUELOS
	CREATE TABLE IF NOT EXISTS RESERVAS_VUELOS (
		id_reserva INT AUTO_INCREMENT PRIMARY KEY,
		id_cliente INT NOT NULL,
		id_vuelo INT NOT NULL,
		cantidad_pasajeros INT NOT NULL,
		total DECIMAL(10, 2) NOT NULL,
		FOREIGN KEY (id_cliente) REFERENCES CLIENTES(id_cliente),
		FOREIGN KEY (id_vuelo) REFERENCES VUELOS(id_vuelo)
	);
	create table if not exists tipoTarjeta(
	  idTipo int auto_increment primary key,
	  nombreTipo varchar(50)
	);
	INSERT INTO tipoTarjeta (nombreTipo) VALUES 
	('Débito'),
	('Crédito'),
	('Prepago'),
	('Virtual'),
	('Corporativa');

	-- Crear tabla TarjetasVisa
	CREATE TABLE IF NOT EXISTS TarjetasVisa (
		numeroTarjeta CHAR(16) PRIMARY KEY,
		fechaValidacion DATE,
		CVV CHAR(3),
		idTipo int ,
		foreign key (idTipo) references tipoTarjeta(idTipo)
	);
	INSERT INTO TarjetasVisa (numeroTarjeta, fechaValidacion, CVV, idTipo) VALUES 
	('1234567812345678', '2025-12-31', '123', 1), -- Débito
	('9876543210987654', '2026-10-15', '456', 2), -- Crédito
	('5678123498761234', '2024-08-01', '789', 3), -- Prepago
	('4321123456789876', '2027-01-20', '321', 4), -- Virtual
	('1111222233334444', '2025-05-30', '654', 5); -- Corporativa

	-- Crear tabla Auditoria_Accesos
	CREATE TABLE IF NOT EXISTS Auditoria_Accesos (
		id_acceso INT AUTO_INCREMENT PRIMARY KEY,
		id_usuario INT NOT NULL,
		ip_acceso VARCHAR(50) NOT NULL,
		fecha_acceso DATE NOT NULL,
		FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario)
	);

	-- Crear tabla CONTACTANOS
	CREATE TABLE IF NOT EXISTS CONTACTANOS (
		idcontacto INT AUTO_INCREMENT PRIMARY KEY,
		nombreContacto VARCHAR(50),
		emailContacto VARCHAR(50),
		numeroContacto CHAR(9),
		mensajeContacto TEXT
	);

	-- Inserciones en la tabla CONTACTANOS
	INSERT INTO CONTACTANOS (nombreContacto, emailContacto, numeroContacto, mensajeContacto)
	VALUES 
	('Juan Pérez', 'juan.perez@example.com', '987654321', 'Hola, me interesa obtener más información sobre sus servicios.'),
	('María López', 'maria.lopez@example.com', '912345678', 'Tengo una consulta sobre el estado de mi pedido.'),
	('Carlos Gómez', 'carlos.gomez@example.com', '998877665', 'Quisiera saber si tienen descuentos para grupos grandes.'),
	('Ana Martínez', 'ana.martinez@example.com', '911223344', '¿Cómo puedo actualizar mis datos en su sistema?'),
	('Luis Torres', 'luis.torres@example.com', '933112233', 'Estoy interesado en colaborar con su empresa, ¿cómo puedo contactarlos formalmente?');
create table tb_cab_boleta(
num_bol      char(5) not null,
fch_bol    date,
id_usuario  int not null,
primary key (num_bol),
foreign key (id_usuario) references Usuarios(id_usuario)
);

create table tb_det_boleta(
num_bol     char(5) not null,
id_destino    int,
cantidad    int,
preciovta   decimal(8,2),
primary key (num_bol,id_destino),
foreign key (num_bol) references tb_cab_boleta(num_bol),
foreign key (id_destino) references DESTINOS(id_destino)
);

	-- Consultas SELECT
	SELECT * FROM CONTACTANOS;
	SELECT * FROM Roles;
	SELECT * FROM Usuarios;
	SELECT * FROM VUELOS;
	SELECT * FROM DESTINOS;
	SELECT * FROM tipoTarjeta;
	SELECT * FROM TarjetasVisa;
	SELECT * FROM tb_cab_boleta;
	SELECT * FROM tb_det_boleta;
	SELECT * FROM Usuarios WHERE email = 'juan.perez@gmail.com' AND contraseña = 'contrasena123';


	CREATE PROCEDURE ActualizarUsuario(
		IN p_id_usuario INT,
		IN p_nombre_usuario VARCHAR(50),
		IN p_email VARCHAR(100),
		IN p_contraseña VARCHAR(255),
		IN p_telefono VARCHAR(15),
		IN p_fecha_cumpleanos DATE,
		IN p_img TEXT
	)
		UPDATE Usuarios
		SET
			nombre_usuario = p_nombre_usuario,
			email = p_email,
			contraseña = p_contraseña,
			telefono = p_telefono,
			fecha_cumpleaños = p_fecha_cumpleanos,
			img = p_img
		WHERE id_usuario = p_id_usuario;

