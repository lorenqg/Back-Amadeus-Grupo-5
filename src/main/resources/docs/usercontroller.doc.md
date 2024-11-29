# Clase UserController

## Descripción
La clase `UserController` es un controlador de la API que maneja las solicitudes relacionadas con los usuarios. Proporciona métodos para listar, crear, actualizar, eliminar y buscar usuarios por diferentes criterios como ID, nombre o correo electrónico.

---

## Anotaciones
- **@RestController**: Indica que la clase es un controlador de la API.
- **@RequestMapping("/user")**: Especifica la ruta base para las solicitudes relacionadas con usuarios.
- **@CrossOrigin(origins = "*")**: Permite solicitudes de origen cruzado desde cualquier URL.
- **@Autowired**: Marca la inyección automática de dependencias en la clase.

---

## Campos
- **_userRepository**: Instancia del repositorio `UserRepository` utilizado para interactuar con la base de datos.

---

## Métodos

### `index()`
- **Descripción**: Devuelve una lista de todos los usuarios en la base de datos.
- **Ruta**: `GET /user/index`
- **Parámetros**: Ninguno.
- **Retorno**: Lista de objetos `User`.

---

### `create(User user)`
- **Descripción**: Crea un nuevo usuario en la base de datos.
- **Ruta**: `POST /user/create`
- **Parámetros**:
    - **user** (en el cuerpo de la solicitud): Objeto `User` con los detalles del usuario.
- **Retorno**: Objeto `User` creado.

---

### `update(int id, User user)`
- **Descripción**: Actualiza los datos de un usuario existente.
- **Ruta**: `PUT /user/update/{id}`
- **Parámetros**:
    - **id**: ID del usuario a actualizar.
    - **user** (en el cuerpo de la solicitud): Objeto `User` con los datos actualizados.
- **Retorno**: Objeto `User` actualizado.

---

### `delete(int id)`
- **Descripción**: Elimina un usuario de la base de datos.
- **Ruta**: `DELETE /user/delete/{id}`
- **Parámetros**:
    - **id**: ID del usuario a eliminar.
- **Retorno**: Objeto `User` eliminado.

---

### `searchId(int id)`
- **Descripción**: Busca usuarios por ID.
- **Ruta**: `GET /user/searchId/{id}`
- **Parámetros**:
    - **id**: ID del usuario a buscar.
- **Retorno**: Lista de usuarios que coinciden con el ID especificado.

---

### `searchName(String name)`
- **Descripción**: Busca usuarios por nombre.
- **Ruta**: `GET /user/searchName/{name}`
- **Parámetros**:
    - **name**: Nombre del usuario a buscar.
- **Retorno**: Lista de usuarios que coinciden con el nombre especificado.

---

### `searchEmail(String email)`
- **Descripción**: Busca usuarios por correo electrónico.
- **Ruta**: `GET /user/searchEmail/{email}`
- **Parámetros**:
    - **email**: Correo electrónico del usuario a buscar.
- **Retorno**: Lista de usuarios que coinciden con el correo especificado.

---

## Uso
La clase `UserController` se utiliza para manejar las solicitudes relacionadas con los usuarios en la API. Ejemplos de uso incluyen:

### Crear un usuario
```bash
curl -X POST \
  http://localhost:8080/user/create \
  -H 'Content-Type: application/json' \
  -d '{
    "name": "Juan Pérez",
    "email": "juan.perez@example.com"
  }'
