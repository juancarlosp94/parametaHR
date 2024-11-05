> [!IMPORTANT]  
> El proyecto falla en configurar adecuadamente el servicio SOAP para gestionar la persistancia de los datos de los empleados. El proyecto tuvo un enfoque Java a XML y no al revés como es generalmente recomendado. Próximas actuializaciones se haran para hacer un enfoque XML a Java. Para mejorar las buenas prácticas se debe agregar seguridad, tests y conterización para minimizar problemas de dependencia.

# Empleado API
Este proyecto es una aplicación Spring Boot que permite recibir solicitudes POST para crear un empleado y almacenar los datos en una base de datos MySQL a traves de un servicio web SOAP que se encarga de gestionar la lógica de negocio relacionada con el empleado.

## Características
- Recibe solicitudes POST en el endpoint /api/empleado.
- Convierte la solicitud en un objeto DTO (EmpleadoRequestDTO).
- Almacena la información del empleado en una base de datos MySQL.
- Proporciona un servicio SOAP para manejar la creación y respuesta del empleado.
## Tecnologías Utilizadas
- Spring Boot: Para el desarrollo del backend.
- JPA/Hibernate: Para la gestión de la base de datos.
- MySQL: Para el almacenamiento de datos.
- SOAP: Para la comunicación entre servicios.
- Lombok: Para la reducción de código boilerplate.

![SOAP](https://github.com/user-attachments/assets/76cfa073-daa0-416e-aea2-66eb5ce7d686)


## Cómo Ejecutar el Proyecto
1. Clonar el repositorio:


```
<git clone <url-del-repositorio>
 cd <nombre-del-repositorio> >
```

2. Configurar la base de datos: Asegúrate de tener una instancia de MySQL en funcionamiento y    configura la conexión en el archivo `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/tu_base_de_datos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```

3.Ejecutar la aplicación: Puedes ejecutar la aplicación utilizando el siguiente comando:

```
mvn spring-boot:run
```

4. Probar el endpoint: Envía una solicitud POST al endpoint /api/empleado con el siguiente JSON (puedes usas Postman creando una Request POST copiando la ruta correcta y con las opciones `raw` y `JSON`):

```
{
  "nombres": "Juan",
  "apellidos": "Pérez",
  "tipoDocumento": "CC",
  "numeroDocumento": "123456789",
  "fechaNacimiento": "1985-06-15",
  "fechaVinculacion": "2020-01-10",
  "cargo": "Desarrollador",
  "salario": 3000.00
}
```

## Ejemplo de Respuesta
La respuesta del endpoint será un objeto EmpleadoResponseDTO que incluye los datos del empleado y su edad, así como el tiempo de vinculación.

```
{
  "nombres": "Juan",
  "apellidos": "Pérez",
  "tipoDocumento": "CC",
  "numeroDocumento": "123456789",
  "edad": "39 años, 4 meses, 3 días",
  "tiempoVinculacion": "4 años, 9 meses, 7 días"
}
```


