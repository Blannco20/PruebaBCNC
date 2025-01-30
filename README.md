# Prueba Técnica Alejandro Blanco Pérez

Este proyecto es un proyecto para la realización de una prueba Técnica con las tecnologías de Spring y Java principalemente.

Las versiones utilizadas son:
- Spring -> 3.3.8
- Java -> 17

El proyecto no necesita instalación ninguna ni configuración con base de datos. Todo está ya realizado en el propio código, ya que la base de datos es en memoria y está configurada para que su creación y destrucción junto al inicio y final de la aplicación.

Se ha optado por una arquitectura hexagonal, donde cada parte del proyecto están separadas en varias capas con una función única cada una. Principalmente se basa en un controlador para obtener los datos de las base de datos, un servicio que implementa la lógica de la prueba y un controlador REST desde el que se pueda acceder mediante llamadas de tipo GET. En cuanto al repositorio, sé que se podría hacer la consulta mediante métodos de JPA, pero debido al extenso nombre del método, he decidido usar una SQL nativa. Los componentes han sido injectados mediante constructores, otro método sería mediante @Autowired pero debido a la simpleza del proyecto, veo más recomendable como lo he hecho.

En cuanto a la cobertura de test se ha realizado tests unitarios y test de integración con los casos que se pedían en el ejercicio, como esto es una prueba y la base de datos es en memoria, los test de integración se lanzan contra la propia base de datos de la aplicación.

Por último, se han añadido las dependencias y configuración necesarias para realizar los análisis de sonar y realizar los cambios y mejoras pertinentes.
