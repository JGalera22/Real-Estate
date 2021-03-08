# Proyecto API REST Real Estate Sevilla Triana

Esta aplicación simula una inmobiliaria online para buscar viviendas en venta o en alquiler.

Ha sido realizada con Spring Boot mediante el lenguaje de Kotlin. 

Un usuario logueado puede ver la lista de viviendas disponibles y marcarlas como favoritas. También podrá crear una publicación de su vivienda y gestionarla.

El usuario no logueado solo podrá ver la lista de viviendas disponibles y sus detalles.

El buscador posee un filtro de categorías, ciudad y precio.

Hay datos de ejemplo que se cargan al iniciar la aplicación con un data.sql (11 usuarios, 17 viviendas y unas 25 imágenes). La base de datos se guarda en memoria aunque sabemos que no es lo más correcto pero de otra forma no cargaba los datos.

Los usuarios tienen de avatar un robot genérico que se carga de la API Robohash

Las imágenes de las viviendas se guardan en Imgur, un sitio web para alojar imágenes en linea.

## Información para ejecutar la aplicación

Hay que abrir el proyecto con Intellij IDEA, hacer doble clic en la tecla CTRL y escribir el comando: gradle bootRun, así sera ejecutado.

### Usuario registrado para acceder a la aplicación sin registrarse
 
 - Username: mcampos
 - Password: 12345678

Se proporciona un archivo JSON con la colección de POSTMAN con todas las rutas de la API REST con datos de ejemplo en el Body.


La aplicación por defecto se ejecuta en el puerto 9000

