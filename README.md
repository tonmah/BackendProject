# BackendProject
Backend Assessment para Clip.

Proyecto realizado con Spring Boot conectado a una base de datos monogoDB mediante spring-data.
La información de conexión con la base de datos se establece por medio del archivo application.properties en éste caso en particular se dejaron los parámetros por default.

La aplicación consiste en una aplicación de linea de comando que puede procesar 4 operaciones básicas sobre un conjunto de transacciones.
Estas operaciones son:
Add -> Añade una nueva transacción al usuario indicado
Show -> Muestra la información de una transacción.
List -> Muestra la información de las transacciones de un usuario.
Sum -> Muestra la suma de las cantidades de todas las transacciones de un usuario.

La forma de invocar estas operaciones sería introducir en la linea de comandos los siguientes comandos respectivamente:

./application <user_id> add <transaction_json>  --->Add
./application <user_id> <transaction_id> --->Show
./application <user_id> list  --->List
./application <user_id> sum   --->Sum
