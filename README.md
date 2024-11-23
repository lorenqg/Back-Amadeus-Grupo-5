# AdventureAPI

## Descripción

Este proyecto es una aplicación backend desarrollada con Spring Boot que proporciona una API REST para gestionar destinos turísticos. La aplicación incluye funcionalidades para crear, buscar, listar y eliminar destinos.

## Estructura del Proyecto

El proyecto está estructurado de la siguiente manera:

* `.gitignore`
* `.gradle/`
* `.idea/`
* `build/`
* `build.gradle`
* `gradle/`
* `gradlew`
* `gradlew.bat`
* `README.md`
* `settings.gradle`
* `src/`
    + `main/`
        - `java/`
            - `com/`
                - `adventureAPI/`
                    - `AdventureAPI/`
                        - `controllers/`
                        - `models/`
                        - `repositories/`
                        - `services/`
        - `resources/`
            - `application.properties`
    + `test/`
        - `java/`
            - `com/`
                - `adventureAPI/`
                    - `AdventureAPI/`

## Configuración

### Variables de Entorno

Asegúrate de configurar las siguientes variables de entorno en el archivo `application.properties` ubicado en `src/main/resources`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/yourdatabase
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Dependencias

Las dependencias del proyecto están gestionadas por Gradle. Aquí están algunas de las principales dependencias utilizadas:

- **Spring Boot Starter**
- **Spring Boot Starter Web**
- **Spring Boot Starter Data JPA**
- **PostgreSQL Driver**
- **Hibernate ORM**
- **Lombok**

## Ejecución del Proyecto

### Requisitos Previos

- **Java 17**
- **Gradle 8.10.2**

## Construcción y Ejecución

Para construir y ejecutar el proyecto, utiliza los siguientes comandos:

```shell
./gradlew build
./gradlew bootRun
```

## Endpoints de la API

### Crear Destino

- **URL:** `/destination/guardarDestino`
- **Método:** `POST`

### Parámetros:

- `nombreDestino (String)`
- `pais (String)`
- `idioma (String)`
- `lugarImperdible (String)`
- `comidaTipica (String)`
- `img (String)`
- `continente (String)`

### Buscar Destino por Nombre

- **URL:** `/destination/searchName/{destino1}/{destino2}`
- **Método:** `GET`

### Parámetros:

- `destino1 (String)`
- `destino2 (String)`

### Listar Destinos

- **URL:** `/destination/index`
- **Método:** `GET`

### Buscar Destino por ID

- **URL:** `/destination/searchById/{id}`
- **Método:** `GET`

### Parámetros:

- `id (int)`

### Eliminar Destino

- **URL:** `/destination/delete/{id}`
- **Método:** `DELETE`

### Parámetros:

- `id (int)`

## Estructura del Código

### Configuración de la Base de Datos

- **Archivo:** `application.properties`
- **Descripción:** Configura las propiedades de la base de datos utilizando `variables de entorno`.

### Entidades

- **Archivo:** `DestinationInfo.java`
- **Descripción:** Define la entidad `DestinationInfo` que mapea a la tabla `destino_info` en la base de datos.

### Repositorios

- **Archivo:** `DestinationInfoRepository.java`
- **Descripción:** Interfaz que extiende `JpaRepository` para realizar operaciones CRUD en la entidad `DestinationInfo`.

### Servicios

- **Archivo:** `DestinationService.java`
- **Descripción:** Contiene la lógica de negocio para gestionar destinos turísticos.

### Controladores

- **Archivo:** `DestinationController.java`
- **Descripción:** Define los endpoints de la API para gestionar destinos turísticos.

## Documentación

**Archivo:** `README.md`
* En el proyecto se encuentra una carpeta llamada **`docs`** en la cual se encuentra una documentación más detallada de los archivos, su funcionalidad y más, esta se encuentra en la carpeta **`resources`**.

## Instalación

Para instalar el proyecto, sigue estos pasos:

1. Clona el repositorio en tu máquina local:

```shell
git clone https://github.com/lorenqg/Back-Amadeus-Grupo-5
```

2. Configura las variables de entorno en el archivo `application.properties`.

3. Construye y ejecuta el proyecto con Gradle:

```shell
./gradlew build
./gradlew bootRun
```

4. Accede a la API REST utilizando Postman o cualquier otra herramienta de prueba de API.

5. ¡Listo! Ya puedes empezar a utilizar la aplicación.

## Contribuciones

Las contribuciones son bienvenidas. Para contribuir, sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama:

```bash
git checkout -b nombre-rama
```

3. Realiza tus cambios.
4. Haz un commit:

```bash
git add .
git commit -m "Comentario"
```

5. Sube tus cambios:

```bash
git push origin nombre-rama
```

6. Crea una solicitud de pull:

```bash
git pull origin master
```