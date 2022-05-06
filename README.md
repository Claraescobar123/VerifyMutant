# :godmode: VerifyMutant
Es una API REST que verifica según una secuencia de ADN si eres mutante o humano, se subió a una instancia EC2 de AWS, y los datos se almacenan en una Base de Datos No Relacional DynamoDB también de AWS.

## :rocket: Instrucciones para ejecutar la API

1. Esta es la dirección publica que debes tener en cuenta para probar la API que se encuentra en una instancia en EC2 de AWS: **54.167.33.219:8080**
2. Para probar la API abre tu plataforma preferida de testo de APIs, puede ser Postman o la que prefieras.
3. Para consumir el servicio y verificar si la secuencia de ADN que ingreses en el body corresponda a mutante o no, debes apuntar al siguiente endpoint: **54.167.33.219:8080/demo/mutant**
4. 
5. Para ver las estadisticas de las secuencias de adn que se han ingresado en la base de datos DynamoDB, debes apuntar al siguiente endpoint: **54.167.33.219:8080/demo/stats**
