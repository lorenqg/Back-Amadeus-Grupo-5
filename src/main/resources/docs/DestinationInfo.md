# DestinationInfo Class Documentation

## Purpose
The `DestinationInfo` class represents detailed information about a travel destination, including attributes such as name, country, language, notable places, typical cuisine, and more. It also establishes relationships with other entities like `DestinationOptions` and `DestinationEntity`.

## Attributes

- **`id`**: Unique identifier for each destination (auto-generated).
- **`nombreDestino`**: Name of the destination.
- **`pais`**: Country where the destination is located.
- **`idioma`**: Primary language spoken in the destination.
- **`lugarImperdible`**: A must-visit place in the destination.
- **`comidaTipica`**: Typical food associated with the destination.
- **`img`**: Path or URL to an image representing the destination.
- **`continente`**: Continent where the destination is located.

## Relationships

- **`DestinationOptions`**: Many-to-one relationship that links this destination to a specific set of travel options.
- **`DestinationEntity`**: Many-to-one relationship for connecting the destination to a larger travel entity.

## Methods

- Getters and setters for each attribute to allow encapsulation and manipulation of destination details.

## Annotations

- **`@Entity`**: Indicates that this class is a JPA entity.
- **`@Table(name = "destination_info")`**: Specifies the table name in the database.
- **`@Id`** and **`@GeneratedValue`**: Define the primary key and its auto-generation strategy.
- **`@ManyToOne`** and **`@JoinColumn`**: Define relationships with other entities.

----

# DestinationInfo

## **Descripción**
La clase `DestinationInfo` representa un modelo de datos que contiene información detallada sobre un destino turístico, como su nombre, país, idioma, comida típica, entre otros. Es una entidad de JPA que se mapea a la tabla `destination_info` en la base de datos.

---

## **Atributos**
- **id**: Identificador único del destino (autogenerado).
- **nombreDestino**: Nombre del destino turístico.
- **pais**: País donde se encuentra el destino.
- **idioma**: Idioma principal del destino.
- **lugarImperdible**: Lugar destacado del destino.
- **comidaTipica**: Comida tradicional del destino.
- **img**: Ruta o URL de la imagen asociada al destino.
- **continente**: Continente al que pertenece el destino.

---

## **Relaciones**
1. **`DestinationOptions`**: Relación `@ManyToOne` que asocia este destino con las posibles opciones de destino (`destination_options` en la base de datos).
2. **`DestinationEntity`**: Relación `@ManyToOne` que asocia este destino con entidades adicionales relacionadas (`destination_entity_id`).

---

## **Métodos**
### **Getters y Setters**
Proporcionan acceso y modificación de cada uno de los atributos de la clase.

### **Uso**
La clase `DestinationInfo` se utiliza para almacenar y recuperar información detallada sobre destinos turísticos desde la base de datos.
