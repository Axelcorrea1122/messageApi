https://gitlab.nacionservicios.com.ar/sre/gke/ns-sube.git# Message Api 
##### Versión: 1.0.0
Microservicios encargado de configurar cliente/keys para enviar notificaciones push a los distintos productos a traves del servicio de Firebase Cloud Messaging (FCM)

### Accesos.

Documentación Swagger Staging:  https://message-api.sube-staging.nacionservicios.com.ar:8081/swagger-ui/#/

Postman collection: https://www.getpostman.com/collections/34fdccee8d903fcbc370

### Modo de gestión
1. Pedir Token en Keycloak
2. Utilizar endpoint POST configureClientKey para registrar key asociada al cliente obtenido por el token
3. Utilizar endpoint PUT sendPushMessage para enviar notificación al device token es decir hacia el producto especificado
