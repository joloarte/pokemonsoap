# Proyecto Pokemon SOAP API

Este proyecto es una aplicación Spring Boot 3 que consume la API REST pública de [PokeAPI](https://pokeapi.co/) y expone información de Pokémon a través de un servicio SOAP. Los datos de las peticiones se almacenan en una base de datos H2.

---

## **Características**

- **Consumo de API REST**: Se conecta a [PokeAPI](https://pokeapi.co/) para obtener información detallada sobre los Pokémon.
- **Exposición SOAP**: Proporciona endpoints SOAP para los métodos:
    - `abilities`
    - `base_experience`
    - `held_items`
    - `id`
    - `name`
    - `location_area_encounters`
- **Persistencia en base de datos**: Guarda las peticiones realizadas, incluyendo:
    - Dirección IP de origen
    - Fecha de la solicitud
    - Método ejecutado
    - Tiempo de duración de la petición
    - Request y response
- **Base de datos H2**: Base de datos en memoria para almacenar logs de peticiones.
- **Docker**: El proyecto está tiene la configuracion del dockerizado, incluyendo la aplicación y la base de datos.

---

## **Requisitos Previos**

1. **Java**: JDK 17 o superior.
2. **Maven**: Versión 3.0 o superior.
3. **Docker**

---

## **Configuración del Proyecto**
1. ejecutar desde IntelliJ IDEA
2. ejecutar compile para generar las clases del xml
3. ejecutar spring-boot:run para levantar el proyecto 
4. cargar el siguiente WSDL: localhost:8080/ws/pokemons.wsdl en soapUi para realizar pruebas.

### **Clonar el repositorio**

```bash
git clone https://github.com/usuario/proyecto-pokemon-soap.git
cd proyecto-pokemon-soap
