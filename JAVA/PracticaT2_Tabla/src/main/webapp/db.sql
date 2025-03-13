create database bd_Espinoza;
use bd_Espinoza;

create table tb_choferes(
 id_chofer int auto_increment primary key,
 nom_choferes varchar(30),
 ape_choferes varchar(30),
 num_choferes int
);

insert into tb_choferes(nom_choferes,ape_choferes,num_choferes) values("nombre","apellido",111111111);
insert into tb_choferes(nom_choferes,ape_choferes,num_choferes) values("nombre1","apellido1",111111112);
insert into tb_choferes(nom_choferes,ape_choferes,num_choferes) values("nombre2","apellido2",111111113);

create table tb_rutas(
 id_ruta int auto_increment primary key,
 nom_ruta varchar(30)
);
insert into tb_rutas (nom_ruta) values ("ruta1");
insert into tb_rutas (nom_ruta) values ("ruta2");
insert into tb_rutas (nom_ruta) values ("ruta3");

create table tb_buses(
 id_bus int auto_increment primary key,
 num_placa varchar(30),
 id_chofer int ,
 id_ruta int,
 foreign key(id_chofer) references tb_choferes(id_chofer),
 foreign key(id_ruta) references tb_rutas(id_ruta)
);
insert into tb_buses(num_placa,id_chofer,id_ruta) values ("AAAA",1,1);
insert into tb_buses(num_placa,id_chofer,id_ruta) values ("BBBB",2,1);
insert into tb_buses(num_placa,id_chofer,id_ruta) values ("CCCC",1,3);
select*from tb_buses;

drop procedure listarTodo;
create procedure listarTodo(in Pid_ruta int)
select b.id_bus,
       c.nom_choferes,
       c.Ape_choferes,
       c.num_choferes
from tb_buses as b
inner join tb_choferes as c on c.id_chofer=b.id_chofer
where id_ruta=Pid_ruta or Pid_ruta=0;

call listarTodo (0);
	
    
    select*from tb_choferes;
    select*from tb_buses;
    
    
    
    
    
    
    
    

