# BackendProject
Backend Assessment for Clip.

This Project was built on spring-boot and it is connected to a mongoDb data base trough spring-data. The connection information with de DB is in the file application.properties, for this particular case it uses the default options.

The application requires that the user install mongoDB and **it is advisable that the monogoDB starts with the option –dbpath pointing  the folder where the aplplication is.**

The application runs from the command line and it consists of 4 operations that deliver information about transaction in a json form. These operations are:
- Add -> Adds a transaction with the user indicated.
- Show -> Show a transaction that corresponds to a particular id.
- List -> Show all the transaction from an user.
- Sum -> Returns the sum of all the transactions amounts that corresponds an user.

**When you are introducing the arguments you must remember to escape the quotes characters.**

The way to invoke the operations are:
- `./application <user_id> add <transaction_json>` --->Add
- `./application <user_id> <transaction_id>` --->Show 
- `./application <user_id> list` --->List 
- `./application <user_id> sum` --->Sum
