# Algoritmos de búsqueda

Búsqueda binaria y lineal sobre arreglos de enteros, con soporte para valores repetidos y una salida que marca las posiciones encontradas.

## Características

- Búsqueda lineal (sin ordenar) y binaria (requiere el arreglo ordenado).
- Búsqueda de la primera coincidencia o de todas las apariciones.
- Fábrica `SearchFactory` para elegir el algoritmo.

## Requisitos

- JDK 21 y Maven 3.9 o superior.

## Compilar y ejecutar

```bash
mvn compile exec:java
```

## Estructura

```text
src/main/java/com/juniverse/search/
├── Main.java
└── algorithms/
```

## Notas

- La búsqueda binaria solo es correcta si el arreglo está ordenado de menor a mayor.

## JAR ejecutable (fat jar)

```bash
mvn clean package
java -jar target/mvn-search-1.0.0-SNAPSHOT-launcher.jar
```

El archivo `-launcher.jar` incluye todas las dependencias.

## Licencia

Código de ejemplo de uso libre con fines educativos.
