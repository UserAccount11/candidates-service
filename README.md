# candidates-service

1. Descargar el código fuente
2. Ejecutar el comando: docker-compose up -d para levantar un contenedor MySQL8
3. Ejecutar la aplicación 
4. Los endpoints http://localhost:8080/candidates/v1/api para la obtención de todos los candidatos y el endpoint http://localhost:8080/auth/login son los que no están protegidos, se puede usar el primero para ver que candidatos estan registrados y usar dichas credenciales para consultar los demás endpoint securizados.

PDTA: Estaba full con la chamba y no me alcanzó el tiempo para documentar los endpoint con Swagger y desplegar el servicio en heroku :( pero lo demás creo que está :D
