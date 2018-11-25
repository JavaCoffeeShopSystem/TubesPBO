create database coffee_shop;

create table employe(
	id_employe int auto_increment PRIMARY KEY,
	nama varchar(255),
	no_hp int
);

create table emp_gudang(
	id_employe int PRIMARY KEY,
	user_name varchar(255),
	pass varchar(255),
	FOREIGN KEY (id_employe) REFERENCES employe(id_employe)
);

create table emp_kasir(
	id_employe int PRIMARY KEY ,
	user_name varchar(255),
	pass varchar(255),
	FOREIGN KEY (id_employe) REFERENCES employe(id_employe)
);

create table barang (
	id_barang int auto_increment  PRIMARY KEY,
	nama varchar(50),
	jml int,
	satuan varchar(20),
	harga int
);

create table pembelian(
	id_pembelian int PRIMARY KEY,
	nama varchar(50),
	jumlah int,
	harga int,
	tgl date,
	id_employe int,
	FOREIGN KEY (id_pembelian) REFERENCES barang(id_barang),
	FOREIGN KEY (id_employe) REFERENCES emp_gudang(id_employe)
	
);

create table menu(
	id_menu int auto_increment  PRIMARY KEY,
	nama varchar(50),
	harga int,
	url varchar(100)
);

create table makanan(
	id_menu int PRIMARY KEY,
	category varchar(30),
	FOREIGN KEY (id_menu) REFERENCES menu(id_menu)
);

create table minuman(
	id_menu int PRIMARY KEY,
	category varchar(30),
	FOREIGN KEY (id_menu) REFERENCES menu(id_menu)
);

create table bahan(
	id_menu int,
	id_barang int,
	jumlah int,
	PRIMARY KEY(id_menu,id_barang),
	FOREIGN KEY (id_menu) REFERENCES menu(id_menu),
	FOREIGN KEY (id_barang) REFERENCES barang(id_barang)
);

create table member(
	id_member int auto_increment PRIMARY KEY,
	nama varchar(255),
	jk varchar(1),
	alamat varchar(255),
	no_hp int
);

create table penjualan(
	id_penjualan int auto_increment PRIMARY KEY,
	id_menu int,
	harga int,
	jumlah int,
	id_member int,
	id_kasir int,
	tgl date,
	FOREIGN KEY (id_menu) REFERENCES menu(id_menu),
	FOREIGN KEY (id_member) REFERENCES member(id_member),
	FOREIGN KEY (id_kasir) REFERENCES emp_kasir(id_employe)
);








