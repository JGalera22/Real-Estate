/*Usuarios*/

INSERT INTO USUARIO(email, fecha_nacimiento, nombre_completo, passwd, username, activo, credential_is_non_expired, non_expired, non_locked, fecha_alta, id) VALUES('miguel@email.com', '1984-02-10', 'Miguel Campos Rivera','12345678','mcampos',true, true, true, true, CURRENT_DATE, NEXTVAL('hibernate_sequence'));
INSERT INTO USUARIO(email, fecha_nacimiento, nombre_completo, passwd, username, activo, credential_is_non_expired, non_expired, non_locked, fecha_alta,id) VALUES('fernandezhernandez@email.com', '1971-5-15', 'Antonio Fernández Hernández','12345678','antoniofernandez',true, true,true, true,CURRENT_DATE, NEXTVAL('hibernate_sequence'));
INSERT INTO USUARIO(email, fecha_nacimiento, nombre_completo, passwd, username, activo, credential_is_non_expired, non_expired, non_locked, fecha_alta,id) VALUES('ruizgarcia@email.com', '1982-10-16', 'Francisca Ruiz García','12345678','franciscaruiz',true, true,true, true,CURRENT_DATE, NEXTVAL('hibernate_sequence'));
INSERT INTO USUARIO(email, fecha_nacimiento, nombre_completo, passwd, username, activo, credential_is_non_expired, non_expired, non_locked, fecha_alta,id) VALUES('rodriguezmartinez@email.com', '1996-5-11', 'Javier Rodríguez Martínez','12345678','javierrodriguez', true, true,true, true,CURRENT_DATE,NEXTVAL('hibernate_sequence'));
INSERT INTO USUARIO(email, fecha_nacimiento, nombre_completo, passwd, username, activo, credential_is_non_expired, non_expired, non_locked, fecha_alta,id) VALUES('ramosramos@email.com', '1975-9-26', 'Javier Ramos Ramos','12345678','javierramos',true, true,true, true, CURRENT_DATE,NEXTVAL('hibernate_sequence'));
INSERT INTO USUARIO(email, fecha_nacimiento, nombre_completo, passwd, username, activo, credential_is_non_expired, non_expired, non_locked, fecha_alta,id) VALUES('castrorubio@email.com', '1989-3-18', 'Jose Castro Rubio','12345678','josecastro', true,true, true, true,CURRENT_DATE,NEXTVAL('hibernate_sequence'));
INSERT INTO USUARIO(email, fecha_nacimiento, nombre_completo, passwd, username, activo, credential_is_non_expired, non_expired, non_locked, fecha_alta,id) VALUES('sanzgarcia@email.com', '1982-7-23', 'Marta Sanz García','12345678','martasanz', true, true,true, true,CURRENT_DATE,NEXTVAL('hibernate_sequence'));
INSERT INTO USUARIO(email, fecha_nacimiento, nombre_completo, passwd, username, activo, credential_is_non_expired, non_expired, non_locked, fecha_alta,id) VALUES('delgadomolina@email.com', '1945-11-20', 'Manuel Delgado Molina','12345678','manueldelgado', true,true, true, true,CURRENT_DATE,NEXTVAL('hibernate_sequence'));
INSERT INTO USUARIO(email, fecha_nacimiento, nombre_completo, passwd, username, activo, credential_is_non_expired, non_expired, non_locked, fecha_alta,id) VALUES('vazquezmarin@email.com', '1971-3-2', 'María Ángeles Vázquez Marín','12345678','maríaángelesvazquez', true,true,true, true, CURRENT_DATE,NEXTVAL('hibernate_sequence'));
INSERT INTO USUARIO(email, fecha_nacimiento, nombre_completo, passwd, username, activo, credential_is_non_expired, non_expired, non_locked, fecha_alta,id) VALUES('garciadiaz@email.com', '1945-5-8', 'Ana García Díaz','12345678','anagarcia', true,true, true, true,CURRENT_DATE,NEXTVAL('hibernate_sequence'));
INSERT INTO USUARIO(email, fecha_nacimiento, nombre_completo, passwd, username, activo, credential_is_non_expired, non_expired, non_locked, fecha_alta,id) VALUES('lopezgarcia@email.com', '1955-9-4', 'María Teresa López García','12345678','maríateresalopez', true,true,true, true,CURRENT_DATE, NEXTVAL('hibernate_sequence'));

INSERT INTO usuario_roles (usuario_id, roles) VALUES(1, 'USER');
INSERT INTO usuario_roles (usuario_id, roles) VALUES(2, 'USER');
INSERT INTO usuario_roles (usuario_id, roles) VALUES(3, 'USER');
INSERT INTO usuario_roles (usuario_id, roles) VALUES(4, 'USER');
INSERT INTO usuario_roles (usuario_id, roles) VALUES(5, 'USER');
INSERT INTO usuario_roles (usuario_id, roles) VALUES(6, 'USER');
INSERT INTO usuario_roles (usuario_id, roles) VALUES(7, 'USER');
INSERT INTO usuario_roles (usuario_id, roles) VALUES(8, 'USER');
INSERT INTO usuario_roles (usuario_id, roles) VALUES(9, 'USER');
INSERT INTO usuario_roles (usuario_id, roles) VALUES(10, 'USER');
INSERT INTO usuario_roles (usuario_id, roles) VALUES(11, 'USER');



/*Viviendas*/
insert into vivienda (categoria, coordenadas, descripcion, direccion, localidad, metros_cuadrados, numero_habitaciones, precio, propietario_id, provincia, titulo, id) 
values('Venta', '37.177234, -3.604230', 'Venta de pisazo en edificio La Purísima, en calle Horno de Haza. Con plaza de garaje y trastero incluidos en el precio. Consta de cuatro amplios dormitorios, tres cuartos de baño, cocina, salón de 27 m2, una estupenda terraza cerrada. Todo exterior, salvo cuartos de baño. Soleado y con vistas despejadas. El edificio tiene calefacción y agua caliente central. No pierda la oportunidad de vivir en un gran piso en pleno centro de Granada y con todas las comodidades. Gastos según ley. Honorarios agencia aparte.',
    'Calle Horno de Haza, 28 -32', 'Granada', 157, 4, 399000.00, 1, 'Granada', 'Piso en venta en Granada', NEXTVAL('hibernate_sequence'));

insert into vivienda (categoria, coordenadas, descripcion, direccion, localidad, metros_cuadrados, numero_habitaciones, precio, propietario_id, provincia, titulo, id) 
values('Venta', '41.650683,-4.7286885', 'Piso en la calle DUQUE DE LA VICTORIA, situado entre la Plaza mayor y Plaza España. Totalmente reformada con excelentes calidades. Cuenta con salón de 35 m2, dos habitaciones, dos baños, uno de ellos en dormitorio principal, y cocina de 18 m2. La vivienda es muy luminosa y muy amplia. Existe la posibilidad de hacer un tercer dormitorio.', 'Calle Duque de la Victoria, 9', 'Valladolid', 130, 2, 340000.00, 5, 'Valladolid', 'Piso en venta en el centro de Valladolid', NEXTVAL('hibernate_sequence'));

insert into vivienda (categoria, coordenadas, descripcion, direccion, localidad, metros_cuadrados, numero_habitaciones, precio, propietario_id, provincia, titulo, id) 
values('Venta', '38.9899731,-1.8633713', 'Una vivienda con carácter, que mantiene su esencia original y de las que apenas conservamos en la ciudad. Con una superficie construida de 130 m2, dispone de salón comedor, amplia cocina con acceso a despensa, habitación interior, aseo y galería, 4 habitaciones amplias y un gran baño. Se trata de una segunda planta sin ascensor.', 'Calle Dr Callado Piña, 29',
   'Albacete', 130, 5, 130000.00, 8, 'Albacete', 'Piso en venta en el centro de Albacete', NEXTVAL('hibernate_sequence'));


insert into vivienda (categoria, coordenadas, descripcion, direccion, localidad, metros_cuadrados, numero_habitaciones, precio, propietario_id, provincia, titulo, id) 
values('Alquiler', '40.4281065,-3.6904916', 'El inmueble está ubicado en una zona comercial con todos los servicios y excelente comunicación tanto en transporte público y líneas de metro: Metro Ibiza y Sainz de Baranda. También con cercanías importantes de interés comercial y de ocio, justo al lado del parque Retiro.', 'Avenida de Menéndez Pelayo, 26', 'Madrid', 150, 3, 2300.00, 9, 'Madrid', 'Alquiler de piso en el Parque del Retiro', NEXTVAL('hibernate_sequence'));


insert into vivienda (categoria, coordenadas, descripcion, direccion, localidad, metros_cuadrados, numero_habitaciones, precio, propietario_id, provincia, titulo, id) 
values('Alquiler', '40.4137701,-3.6793367', 'Se alquila precioso apartamento completamente amueblado de diseño, reforma a estrenar. Estupenda ubicación en pleno centro financiero de Madrid junto a Torre Picasso, Torre Europa etc.', 'Calle Paseo de la Castellana, 15', 'Madrid', 60, 1, 950.00, 6, 'Madrid', 'Alquiler de piso en Bernabéu-Hispanoamérica', NEXTVAL('hibernate_sequence'));

insert into vivienda (categoria, coordenadas, descripcion, direccion, localidad, metros_cuadrados, numero_habitaciones, precio, propietario_id, provincia, titulo, id) 
values('Alquiler', '37.3801005,-6.0146169', 'El apartamento tiene 1 dormitorio, TV de pantalla plana, cocina equipada con microondas y nevera, lavadora y baño con ducha. Todo los servicio necesarios para encontrarse comodo y agusto. Solo para Alquilar hasta Junio 2021 o Meses Sueltos.', 'Calle José León Sanz, 15', 'Sevilla', 70, 1, 650.00, 10, 'Sevilla', 'Alquiler de piso en Triana', NEXTVAL('hibernate_sequence'));

insert into vivienda (categoria, coordenadas, descripcion, direccion, localidad, metros_cuadrados, numero_habitaciones, precio, propietario_id, provincia, titulo, id) values('Venta', '36.5277844,-6.2914522','¡ En el casco histórico de Cádiz! Piso de 42 m² distribuidos en salón-comedor, cocina, dos habitaciones y un cuarto de baño en el centro de Cádiz. Precisa reforma, pero ofrece muchas posibilidades. Es una planta baja en un bloque con ascensor. Está muy cercano al transporte urbano, a 2 minutos de la parada de autobuses (L1-L3-L7), a 9 minutos de la Catedral de Cádiz y de la Playa Santa Mª del Mar. Hay todo tipo de servicios en la zona: colegios, tiendas, comercios, centros de salud…', 'calle Goleta s/n', 'Cádiz', 42, 3, 90000.00, 2, 'Cádiz', 'Piso en venta en calle Goleta s/n', NEXTVAL('hibernate_sequence'));


insert into vivienda (categoria, coordenadas, descripcion, direccion, localidad, metros_cuadrados, numero_habitaciones, precio, propietario_id, provincia, titulo, id) values('Venta', '36.5296654,-6.293993','Imagina residir en la zona mejor comunicada del casco histórico de Cádiz, junto al Palacio de Congresos y Ayuntamiento, cercana a las estaciones de RENFE y de autobuses, la Terminal de Catamaranes, y a 5 minutos de la salida de la ciudad, a través de la nueva Avenida de Astilleros y el Puente de la Constitución de 1812 Residencial Calle Plocia consta de 15 viviendas, áticos, dúplex, lofts o pisos de 1, 2 y 3 dormitorios, equipados con 1, 2 y hasta 3 baños. Acabados 100% Porcelanosa Grupo, Cocinas Porcelanosa, aunando un exclusivo diseño, con los más altos niveles de calidad, confort y ahorro energético. Visite nuestra oficina de ventas situada en c/Virgen de los Milagros, 54 El Puerto de Santa María, o llámenos al 956 54 20 44, nuestro equipo comercial le atenderá gustosamente. Desde 1972, Inmobiliaria Retamar S. A. , agencia inmobiliaria y promotor inmobiliario, idea, proyecta y promueve en la Costa de la Luz, y más intensamente en la provincia de Cádiz. Encuentra la vivienda de tus sueños.', 'calle Amaya, 2', 'Cádiz', 107, 2, 325000.00, 2, 'Cádiz','Dúplex en venta en calle Amaya, 2', NEXTVAL('hibernate_sequence'));


insert into vivienda (categoria, coordenadas, descripcion, direccion, localidad, metros_cuadrados, numero_habitaciones, precio, propietario_id, provincia, titulo, id) values('Venta', '42.2431364,-1.7638401','Casa de 300 m² de superficie, en Milagro, provincia de Nafarroa. Esta casa se ajusta perfectamente a las necesidades de una pareja o de una familia.Esta vivienda tiene 4 plantas de altura y se distribuye en 1 amplio salón, 1 cocina amueblada y equipada con electrodomésticos,con chimenea, 4 habitaciones y 1 cuarto de baño. Además, la casa en la planta de arriba, cuenta con un solárium de madera y ladrillo rústico y un patio, con barbacoa, con muchas posibilidades, para que puedas disfrutar del buen tiempo. También cuenta con trastero para que puedas aprovechar todo el espacio de la vivienda. Esta vivienda, se encuentra situada en una vía de fácil acceso y dispone de 1 plaza de garaje para mayor seguridad. El inmueble es todo exterior, muy luminoso.', 'calle Horno', 'Navarra', 300, 4, 94000.00, 3, 'Peralta', 'Casa o chalet en venta en calle Horno', NEXTVAL('hibernate_sequence'));




insert into vivienda (categoria, coordenadas, descripcion, direccion, localidad, metros_cuadrados, numero_habitaciones, precio, propietario_id, provincia, titulo, id) values('Alquiler','42.8768747,-8.5425368','Apartamento 2 habitaciones con terraza amplia. En pleno centro de santiago. Cercano a plaza de abastos y plaza de galicia.', 'calle do Pexigo de Arriba, 30', 'Galicia', 63, 2, 350, 7, 'Santiago de Compostela', 'Alquiler de Piso en calle do Pexigo de Arriba, 30', NEXTVAL('hibernate_sequence'));


insert into vivienda (categoria, coordenadas, descripcion, direccion, localidad, metros_cuadrados, numero_habitaciones, precio, propietario_id, provincia, titulo, id) values('Alquiler','40.955101,-4.1153108','Piso tres dormitorios. Totalmente exterior. Muy luminoso. Excelentes vistas. Calefacción individual Gas. Aire Acondicionado. Proximo a parada BUS. Cercano a la IE.', 'calle San Vicente el Real, 5', 'Segovia',85, 3, 400, 11, 'Segovia', 'Alquiler de Piso en calle San Vicente el Real, 5',NEXTVAL('hibernate_sequence'));


insert into vivienda (categoria, coordenadas, descripcion, direccion, localidad, metros_cuadrados, numero_habitaciones, precio, propietario_id, provincia, titulo, id) values('Alquiler','37.9994901,-1.1752094','Piso tres dormitorios. Totalmente exterior. Muy luminoso. Excelentes vistas. Calefacción individual Gas. Aire Acondicionado. Proximo a parada BUS. Cercano a la IE.', 'Calle Cabezo Blanco, 30', 'Murcia',50, 2, 400, 7, 'Guadalupe', 'Alquiler de Piso en Guadalupe', NEXTVAL('hibernate_sequence'));



insert into vivienda (categoria, coordenadas, descripcion, direccion, localidad, metros_cuadrados, numero_habitaciones, precio, propietario_id, provincia, titulo, id)
 values ('Venta','37.3829102,-5.9748801','Gilmar Sevilla les presenta este espléndido inmueble ubicado en la zona más privilegiada del barrio de Nervión, junto a la Buhaira, en uno de los edificios más apreciados de la zona por sus calidades y zonas comunes. La ubicación del inmueble le permitirá disfrutar de todo tipo de servicios como centros educativos (Centro Porta Coeli y El Buen Pastor), comercios (El corte inglés), restauración y ocio de calidad (Nervión plaza), y con una conectividad excelente disponiendo de una estación de metro a 1 minuto (Nervión) y la Estación central de Santa Justa a 15 minutos a pie. Todo ello a menos de 5 minutos a pie del casco histórico por Avenida de Eduardo Dato. El piso se ubica en las últimas plantas del edificio, y totalmente exterior, por lo que es muy luminoso y podrá disfrutar de unas magníficas vistas en las que se enmarcan Catedral y la Giralda. La superficie total de la vivienda es de 250 m2 distribuidos en recibidor, estar, salón, comedor, cocina con con lavadero, baño, y cuatro dormitorios, uno de ellos con baño en suite, más un dormitorio de servicio con baño. La vivienda es totalmente exterior, con orientación sureste y dispone de una terraza compartida por varios dormitorios. Dispone de entrada principal y de servicio. El inmueble dispone de altas calidades con mármol en suelos, aire acondicionado centralizado y una distribución ordenada.',
'C/ Luis de Morales','Sevilla',250,5,625000.0, 5, 'Sevilla','Piso en venta en Nervión',NEXTVAL('hibernate_sequence'));

insert into vivienda (categoria, coordenadas, descripcion, direccion, localidad, metros_cuadrados, numero_habitaciones, precio, propietario_id, provincia, titulo, id)
 values ('Venta','37.3862204,-5.979766','Fantástica vivienda en pleno Nervión junto a El Corte Inglés, Nervión Plaza y Campo del Sevilla. Se trata de una vivienda de 154 m2, totalmente exterior en recinto cerrado con plaza de garaje y zonas comunes: piscina, pistas de tenis, jardines y parque infantil. La vivienda cuenta con un elegante salón comedor independiente, la terraza de la vivienda se ha incorporado a la zona de comedor, pero si se desea se puede rescatar. El acceso del salón a la cocina es cómodo por la cercanía de estas estancias, ésta dispone de lavadero y habitación de servicio con cuarto de baño privado. Además cuenta con otros 3 dormitorios con armarios empotrados, el principal con vestidor y baño y contamos con otro baño en pasillo. La vivienda dispone de puerta de servicio, alarma, azotea transitable, aire acondicionado centralizado y calefacción por radiadores, que es muy de agradecer por el calor tan confortable que producen. El acceso al garaje es directo desde la vivienda. Es una urbanización muy apreciada por ubicación, vecindario y zonas comunes., con orientación sureste y dispone de una terraza compartida por varios dormitorios. Dispone de entrada principal y de servicio. El inmueble dispone de altas calidades con mármol en suelos, aire acondicionado centralizado y una distribución ordenada.',
'C/ Benito Mas y Prat s/n','Sevilla',154,4,600000.00, 1,'Sevilla','Piso en venta',NEXTVAL('hibernate_sequence'));


insert into vivienda (categoria, coordenadas, descripcion, direccion, localidad, metros_cuadrados, numero_habitaciones, precio, propietario_id, provincia, titulo, id)
 values ('Venta','38.0109029,-3.3731081','Chalet de 348m² de superficie y 650m² de parcela, en la que podrás disfrutar de tus ratos de ocio sin salir de casa, en Úbeda, provincia de Jaén. Por el espacio que te ofrece, este chalet es ideal para una familia con hijos. Este chalet tiene dos plantas de altura y se distribuye en un amplio y acogedor salón, una fabulosa bodega, un despacho, cuatro dormitorios, dos cuartos de baño completos, un aseo, y cocina amueblada. Además, el chalet cuenta con balcón que aporta gran luminosidad a toda la estancia, terraza, para que descanses al aire libre, un patio para que puedas desayunar al aire libre y armarios empotrados para aumentar la capacidad de almacenaje de tu hogar. El inmueble es todo exterior. También tiene jardín privado en el que aprovecharás el buen tiempo, una piscina privada para refrescarte en verano, y trastero para que puedas aprovechar todo el espacio de la vivienda. Este chalet está situado en una vía de fácil acceso, y tiene dos plazas de garaje para que puedas aparcar con mayor comodidad., con orientación sureste y dispone de una terraza compartida por varios dormitorios. Dispone de entrada principal y de servicio. El inmueble dispone de altas calidades con mármol en suelos, aire acondicionado centralizado y una distribución ordenada.',
'C/ Benito Mas y Prat s/n','Úbeda',348,5,1250000.00, 1,'Jaén', 'Casa o chalet en venta en cuesta Merced',NEXTVAL('hibernate_sequence'));


insert into vivienda (categoria, coordenadas, descripcion, direccion, localidad, metros_cuadrados, numero_habitaciones, precio, propietario_id, provincia, titulo, id)
 values ('Alquiler','39.4728793,-0.3802639','Bonita vivienda ubicada en el centro de valencia, zona barrio del carmen y junto a la universidad católica con reforma de calidad. Dispone de dos habitaciones dobles y una sencilla con armarios empotrados, una de ellas con baño integrado. Tiene ventanas de pvc oscilo batientes, suelo porcelánico imitación parquet, puertas macizas lacadas en blanco, puertas en los baños correderas para facilitar el acceso, cocina abierta al comedor con barra de madera, electrodomésticos de alta eficiencia y luces led. Aire acondicionado inverter en comedor-cocina y en habitación principal. Las otras dos habitaciones tienen ventiladores de techo con luz, también dispone de balcón a la calle y una terraza a patio de vecinos, cuenta con un pequeño trastero en el interior. Se encuentra amueblado, incluye mueble en salón con tv, sofá cheslong, mesa de comedor de cristal con sillas, habitación principal completa, otra habitación con cama de 135 y habitación pequeña con cama de 90.', 'Ciutat Vella','Valencia',101,3,950.00, 9,'Valencia','Alquiler de Piso en El Carme',NEXTVAL('hibernate_sequence'));



insert into vivienda (categoria, coordenadas, descripcion, direccion, localidad, metros_cuadrados, numero_habitaciones, precio, propietario_id, provincia, titulo, id)
 values ('Alquiler','39.4712981,-0.3892182','Vivienda en alquiler lista para entrar a vivir junto al Mercado Central y el Ayuntamiento de Valencia. En Plaza peatonal muy tranquila en el centro de la ciudad. La vivienda consta de dos dormitorios, un cuarto de baño completo, cocina tipo office equipada con electrodomésticos a estrenar, amplio salón-comedor con mucha luz y balcón. Aire acondicionado y calefacción. ¡Ponte en contacto con nosotros para realizar una visita! Somos una inmobiliaria diferente, especializada en el trato con las personas para dar siempre un servicio cercano, humano y personalizado. Ser diferentes es nuestra obligación.', 'C/ del Actor Rivelles','Valencia', 81,2,710.00, 11, 'Valencia','Alquiler de Piso en El Pilar',NEXTVAL('hibernate_sequence'));



/*Imágenes vivienda*/


insert into imagen_vivienda(id, data_id, delete_hash, vivienda_id) values (NEXTVAL('hibernate_sequence'), 'zi3AIuX', 'Oo55EkuFayvfLf0',12);

insert into imagen_vivienda(id, data_id, delete_hash, vivienda_id) values (NEXTVAL('hibernate_sequence'), 'siFBvVd', 'Vga32C9yMrchIzt',14);

insert into imagen_vivienda(id, data_id, delete_hash, vivienda_id) values (NEXTVAL('hibernate_sequence'), 'ypp9kSE', 'UqZ2l3c4hs6HW1v',13);

insert into imagen_vivienda(id, data_id, delete_hash, vivienda_id) values (NEXTVAL('hibernate_sequence'), 'HucINH1', 'FuzGKB27RDdSWmH',15);

insert into imagen_vivienda(id, data_id, delete_hash, vivienda_id) values (NEXTVAL('hibernate_sequence'), '0XdgaQk', '7Lrbk6uQPbqK9Ag',16);

insert into imagen_vivienda(id, data_id, delete_hash, vivienda_id) values (NEXTVAL('hibernate_sequence'), 'Lxadzal', 'DmIRJvqCI7tch1D',17);

insert into imagen_vivienda(id, data_id, delete_hash, vivienda_id) values (NEXTVAL('hibernate_sequence'), 'CtysRMC', 'VZbqb5y3GIOgFJT',18);

insert into imagen_vivienda(id, data_id, delete_hash, vivienda_id) values (NEXTVAL('hibernate_sequence'), 'NWyOOca', 'nPLtJyVFwPlrxUF',18);

insert into imagen_vivienda(id, data_id, delete_hash, vivienda_id) values (NEXTVAL('hibernate_sequence'), 'bT7vA7Y', 'dJ1jrDUvhn0i19Y',19);

insert into imagen_vivienda(id, data_id, delete_hash, vivienda_id) values (NEXTVAL('hibernate_sequence'), 'CtysRMC', 'nPLtJyVFwPlrxUF',19);

insert into imagen_vivienda(id, data_id, delete_hash, vivienda_id) values (NEXTVAL('hibernate_sequence'), 'kDRWZTw','ml8lJOzh1MHndXq',20);

insert into imagen_vivienda(id, data_id, delete_hash, vivienda_id) values (NEXTVAL('hibernate_sequence'), 'TnGu6xs', 'WVMEYCC1xo7KtDx',20);

insert into imagen_vivienda(id, data_id, delete_hash, vivienda_id) values (NEXTVAL('hibernate_sequence'), 'I4botK0', 'ixtFvzZ6kLLTzgS',20);

insert into imagen_vivienda(id, data_id, delete_hash, vivienda_id) values (NEXTVAL('hibernate_sequence'), 'zojROr8','ml8lJOzh1MHndXq',21);

insert into imagen_vivienda(id, data_id, delete_hash, vivienda_id) values (NEXTVAL('hibernate_sequence'), 'TnGu6xs', 'D9LlC1azRq1stSP',21);

insert into imagen_vivienda(id, data_id, delete_hash, vivienda_id) values (NEXTVAL('hibernate_sequence'), '2DAldFI','G2DOkshqePwPAo7',22);

insert into imagen_vivienda(id, data_id, delete_hash, vivienda_id) values (NEXTVAL('hibernate_sequence'), 'pPx8tD9', '6uoPaYKbUw09bN3',22);

insert into imagen_vivienda(id, data_id, delete_hash, vivienda_id) values (NEXTVAL('hibernate_sequence'), '4yoDZZd','heVBgVZgZNIKdwd',23);

insert into imagen_vivienda(id, data_id, delete_hash, vivienda_id) values (NEXTVAL('hibernate_sequence'),'ZPf9Iox','mBRghEnRn5Lfs9q',23);

insert into imagen_vivienda(id, data_id, delete_hash, vivienda_id) values (NEXTVAL('hibernate_sequence'), 'hQLDwuB', 'RRv6qaKdAmuRRcA',24);

insert into imagen_vivienda(id, data_id, delete_hash, vivienda_id) values (NEXTVAL('hibernate_sequence'), 'GDLW1pl', 'PR1zTsjpHC79ifo',25);

insert into imagen_vivienda(id, data_id, delete_hash, vivienda_id) values (NEXTVAL('hibernate_sequence'), '3ZrYGqY', 'RZRQ6ZQqrWF9MZ0',26);

insert into imagen_vivienda(id, data_id, delete_hash, vivienda_id) values (NEXTVAL('hibernate_sequence'),'Kh3HMFq','CxkdTvwHQDGhSjg',27);

insert into imagen_vivienda(id, data_id, delete_hash, vivienda_id) values (NEXTVAL('hibernate_sequence'),'VVWGL8U','446YqHbKaSNixbc',28);

insert into imagen_vivienda(id, data_id, delete_hash, vivienda_id) values (NEXTVAL('hibernate_sequence'),'oOAxIJr','bgcXy7kYwycoO3E',28);







