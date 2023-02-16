# API Electronic Commerce

Para la Ejecución de la API:

* Se ejecuta en [http://localhost:8080/](http://localhost:8080/)
* La api cuenta con una documentación en [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

##Se crearon dos endpoint
*Un primer endpoint [http://localhost:8080/electroniccommerce/allprice](http://localhost:8080/electroniccommerce/allprice) para obtener y verificar la carga de data inicial.
*Un segundo endpoint [http://localhost:8080/electroniccommerce/price](http://localhost:8080/electroniccommerce/price) donde recibe los parametros descritos por queryParam y devuelve el resultado en base a los datos del ejemplo.

### Documentación Referente

En la Raiz del proyecto se encuentra un carpeta donde contiene el fichero .json que puede ser importado en el postman:

### Test Unitarios

Ademas de comprobar y validar que el servicio funcionara correctamente desde el swagger, 
se realizaron 6 test unitarios, donde 5 se validan las peticiones al servicio con los datos del ejemplo 
y el 6to la carga de todos los precios de la BD
#### Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
#### Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
#### Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
#### Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
#### Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)

La solución se realizó siguiendo las indicaciones del txt donde describe la problematica.

