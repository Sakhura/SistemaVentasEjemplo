DROP DATABASE IF EXISTS SistemaVentas;
CREATE DATABASE  SistemaVentas;
USE SistemaVentas;


CREATE TABLE Comuna(
cod_comuna int primary key auto_increment,
descripcion varchar(250)
);

CREATE TABLE region(
cod_region int primary key auto_increment,
descripcion varchar(250)
);

CREATE TABLE cargo(
cod_cargo int primary key auto_increment,
descripcion varchar(250)
);

CREATE TABLE marca(
cod_marca int primary key auto_increment,
nombre_marca   varchar(250)
);

CREATE TABLE categoria(
cod_categoria int primary key auto_increment,
descripcion varchar(250)
);

CREATE TABLE modelo(
cod_modelo int primary key auto_increment,
nombre_modelo  varchar(250),
precio_compra 	int,
precio_venta   int,
cod_marca      int(5),
cod_categoria  int(5),
foreign key (cod_marca) references marca(cod_marca),
foreign key (cod_categoria) references categoria(cod_categoria)
);

CREATE TABLE empleado(
cod_empleado    int primary key auto_increment,
nombre          varchar(25),
apellidos       varchar(25),
rut             varchar(10),
direccion       varchar(45),
telefono        varchar(12),
email           varchar(45),
cod_comuna    int,
cod_cargo       int,
usuario         varchar(25),
contrasena      varchar(25),
cod_region      int, 
foreign key (cod_comuna) references comuna(cod_comuna),
foreign key (cod_cargo) references cargo(cod_cargo),
foreign key (cod_region) references region(cod_region)
);

CREATE TABLE cliente(
cod_cliente    int primary key auto_increment,
nombre         varchar(25),
apellidos      varchar(25),
rut           varchar(10),
direccion      varchar(45),
celular       varchar(12),
email          varchar(45),
cod_comuna   int,
foreign key (cod_comuna) references comuna(cod_comuna)
);

CREATE TABLE producto(
cod_producto  int primary key auto_increment,
cod_modelo     int,
talla          int,
color          varchar(15),
stock          int,
foreign key (cod_modelo) references modelo(cod_modelo)
);

CREATE TABLE boleta(
cod_boleta      int primary key auto_increment,
fecha_hora_emision timestamp,
cod_cliente    int,
cod_empleado   int,
foreign key (cod_cliente) references cliente(cod_cliente),
foreign key (cod_empleado) references empleado(cod_empleado)
);

CREATE TABLE detalle_boleta(
cod_boleta     int primary key auto_increment,
cod_producto    int,
cantidad       int,
importe        int,
foreign key (cod_boleta) references boleta(cod_boleta),
foreign key (cod_producto) references producto(cod_producto)
);