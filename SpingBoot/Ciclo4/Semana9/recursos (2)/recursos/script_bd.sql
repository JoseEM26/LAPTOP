-- borra la bd si existe
DROP DATABASE IF EXISTS ciberfarmaweb;

-- creamos la bd
CREATE DATABASE ciberfarmaweb;

-- activamos la bd
USE ciberfarmaweb;

create table tb_tipos(
idtipo		int not null primary key,
descripcion varchar(15)
);
insert into tb_tipos values (1, 'administrativo');
insert into tb_tipos values (2, 'cliente');

CREATE TABLE tb_usuarios(
cod_usua  int auto_increment,
nom_usua varchar(15) not null,
ape_usua varchar(25)  not null,
user_usua char(45) not null unique,
pswd_usua char(100) not null,
fnac_usua  date  null,
idtipo    int not null default 2 CHECK (idtipo IN (1,2)), 
est_usua  bit not null default 1 check (est_usua IN (0,1)),
primary key (cod_usua),
constraint fk_tipo foreign key (idtipo) references tb_tipos(idtipo)
);
insert into tb_usuarios values (null,'Admin', 'Admin','admin@ciberfarma.com', 'super', curdate(),1,default);
insert into tb_usuarios values (null,'Tito', 'Ciber','U001@gmail.com', '10001', curdate(),1,0);
insert into tb_usuarios values (null,'Zoila', 'Baca','U002@gmail.com', '10002', curdate(),2,default);
insert into tb_usuarios values (null,'Willy', 'Wonka','U003@gmail.com', '10003', curdate(),2,default);
insert into tb_usuarios values (null,'Charlie', 'Bucket','U004@gmail.com', '10004', curdate(),1,default);

create table tb_proveedor(
idproveedor int auto_increment,
nombre_rs varchar(45) not null,
telefono varchar(10) not null,
email varchar(45) not null, 
primary key (idproveedor)
);
insert into tb_proveedor values (1,'Pharmalab', '997448556','ventas@pharmalab.com');
insert into tb_proveedor values (2,'Minsa', '254785','minsa@peru.org');
insert into tb_proveedor values (3,'La Naturista', '7895412','naturista@gmail.com');

create table tb_categorias(
idcategoria	int not null primary key,
descripcion varchar(45) not null
);
insert into tb_categorias values (1, 'Pastillas');
insert into tb_categorias values (2, 'Jarabe');
insert into tb_categorias values (3, 'Cremas');
insert into tb_categorias values (4, 'Tocador');
insert into tb_categorias values (5, 'Cuidado');
insert into tb_categorias values (6, 'Otros');

create table tb_productos(
id_prod char(5) not null,
des_prod varchar(45) not null,
stk_prod int not null,
pre_prod decimal(8,2) not null,
idcategoria int,
est_prod bit not null default 1,
idproveedor int,
primary key (id_prod), 
constraint fk_categoria foreign key (idcategoria) references tb_categorias(idcategoria),
constraint fk_proveedor foreign key (idproveedor) references tb_proveedor(idproveedor)
);
insert into tb_productos values ('P0001','Panadol cj 10',20,1.85,1,1,1);
insert into tb_productos values ('P0002','Curitas unidad',100,1.0,3,1,1);
insert into tb_productos values ('P0003','Kita tos',80,15.0,2,1,3);
insert into tb_productos values ('P0004','Achiz',120,1.0,1,1,3);
insert into tb_productos values ('P0005','Jaboncillo cj',120,1.0,3,1,3);
insert into tb_productos values ('P0006','Termometro',80,2.8,5,1,2);
insert into tb_productos values ('P0007','Panadol jarabe pq',40,10.5,2,1,1);
insert into tb_productos values ('P0008','Antalgina',55,1.8,1,1,1);
insert into tb_productos values ('P0009','Ibuprofeno',60,15.0,4,1,2);
insert into tb_productos values ('P0010','Mejoralito Niños',10,1.5,1,1,2);
insert into tb_productos values ('P0011','Panadol jarabe',10,1.5,2,1,2);
insert into tb_productos values ('P0012','Jabon Neko',40,8.5,4,1,1);
insert into tb_productos values ('P0013','Pañales x 24u',10,1.5,5,1,1);
insert into tb_productos values ('P0014','Mejoralito XForte',10,1.5,1,1,1);
insert into tb_productos values ('P0015','Champu Amigo',50,0.99,5,1,3);
insert into tb_productos values ('P0016','Mejoralito',10,1.5,4,1,2);
insert into tb_productos values ('P0017','SinDolor',23,1.5,6,1,1);
insert into tb_productos values ('P0018','Mejoralito Forte',10,1.5,2,1,2);
insert into tb_productos values ('P0020','Mejoralito UForte',10,0.99,5,1,1);

create table tb_cab_boleta(
num_bol     int auto_increment,
fch_bol    date not null,
cod_usua  int not null,
primary key (num_bol),
foreign key (cod_usua) references tb_usuarios(cod_usua)
);

create table tb_det_boleta(
num_bol     int not null,
id_prod      char(5) not null,
cantidad    int not null,
preciovta   decimal(8,2) not null,
primary key (num_bol,id_prod),
constraint fk_boleta foreign key (num_bol) references tb_cab_boleta(num_bol),
constraint fk_producto foreign key (id_prod) references tb_productos(id_prod));

-- consultas
SELECT * FROM tb_usuarios;
SELECT * FROM tb_productos;
select * from tb_categorias;