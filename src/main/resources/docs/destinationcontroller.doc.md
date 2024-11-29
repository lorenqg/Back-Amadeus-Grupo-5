# Clase DestinationController

## Descripción
La clase **DestinationController** es un controlador REST que maneja las solicitudes relacionadas con los destinos turísticos. Permite realizar operaciones como listar destinos, guardar nuevos destinos, buscar por nombre o ID, obtener recomendaciones personalizadas y eliminar registros de la base de datos.

---

## Anotaciones
- **@CrossOrigin(origins = "*")**: Permite solicitudes de origen cruzado desde cualquier dominio.
- **@RestController**: Declara la clase como un controlador REST.
- **@RequestMapping("/destination")**: Especifica la ruta base para todas las solicitudes relacionadas con destinos.

---

## Campos
- **destinationService**: Instancia del servicio `DestinationService` para la lógica de negocio.
- **_destinoInfoRespository**: Repositorio que interactúa con la base de datos para las operaciones sobre `DestinationInfo`.

---

## Métodos

### index()
**Descripción:** Obtiene una lista de todos los destinos registrados en la base de datos.  
**Ruta:** `GET /destination/index`  
**Parámetros:** Ninguno.  
**Retorno:** Una lista de objetos con información de los destinos.
- `nombreDestino (String)`
- `pais (String)`
- `idioma (String)`
- `lugarImperdible (String)`
- `comidaTipica (String)`
- `img (String)`
- `continente (String)` 

---

### enviarDestino()
**Descripción:** Procesa una solicitud para generar recomendaciones de destinos basadas en las preferencias del usuario.  
**Ruta:** `POST /destination/enviarDestino`  
**Parámetros (en el cuerpo de la solicitud):**
- `pDestino`: Preferencia de destino (ej. Playa, Ciudad, Montaña).
- `pClimatica`: Preferencia climática (ej. Frío, Caluroso, Templado).
- `pActividad`: Tipo de actividad preferida (ej. Relax, Aventura, Cultura).
- `pAlojamiento`: Preferencia de alojamiento (ej. Hotel, Airbnb).
- `dViaje`: Duración del viaje (ej. 1-2 semanas).
- `edad`: Edad del usuario.  
  **Retorno:** Un objeto `DestinationResponse` con las recomendaciones generadas.

---

### guardarDestino()
**Descripción:** Guarda un nuevo destino en la base de datos.  
**Ruta:** `POST /destination/guardarDestino`  
**Parámetros (en el cuerpo de la solicitud):**
- `nombreDestino (String)`
- `pais (String)`
- `idioma (String)`
- `lugarImperdible (String)`
- `comidaTipica (String)`
- `img (String)`
- `continente (String)`  
  **Retorno:** El objeto con los valores anteriores creado.

---

### searchByName()
**Descripción:** Busca destinos que coincidan con los nombres especificados.  
**Ruta:** `GET /destination/searchByName/{destino1}/{destino2}`  
**Parámetros:**
- `destino1`: Nombre del primer destino.
- `destino2`: Nombre del segundo destino.  
  **Retorno:**
- Una lista de objetos `DestinationInfo` que coincidan con los nombres.
- Código **404 (NOT FOUND)** si no se encuentran coincidencias.

---

### searchById()
**Descripción:** Busca destinos por su ID.  
**Ruta:** `GET /destination/searchById/{id}`  
**Parámetros:**
- `id`: ID del destino a buscar.  
  **Retorno:** Una lista de objetos `DestinationInfo` con el ID especificado.

---

### delete()
**Descripción:** Elimina un destino de la base de datos según su ID.  
**Ruta:** `DELETE /destination/delete/{id}`  
**Parámetros:**
- `id`: ID del destino a eliminar.  
  **Retorno:** El objeto `DestinationInfo` eliminado.

---

## Uso
La clase **DestinationController** permite gestionar destinos turísticos mediante sus métodos. Los siguientes ejemplos muestran cómo interactuar con la API.

### Ejemplo 1: Obtener todos los destinos
```bash
curl -X GET http://localhost:8080/destination/index
