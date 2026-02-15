# Laboratorio 2 - Patrones de Diseño y Programación Funcional

## Descripción General
Este laboratorio implementa dos sistemas de gestión utilizando patrones de diseño creacionales y programación funcional con Java. Se aplican expresiones lambda, streams y métodos de referencia para crear soluciones elegantes y mantenibles.

---

## Reto #1 – Tienda Don Pepe

### Descripción
Sistema de gestión de una tienda de abarrotes que permite a los clientes ver productos categorizados y realizar compras con descuentos según el tipo de cliente (nuevo o frecuente).

### Patrón de Diseño
**Creacional → Factory Method**

### Justificación
El patrón Factory Method es ideal para este escenario porque:
- Permite crear diferentes tipos de productos (Bebidas, Cárnicos, Dulces, Empaquetados, Ropa) sin especificar sus clases exactas
- Centraliza la lógica de creación de objetos en la clase `FabricaDeProductos`
- Facilita la extensión del sistema al agregar nuevos tipos de productos sin modificar el código existente
- Desacopla el código cliente de las clases concretas de productos

### Estructura del Proyecto

```
reto1/
├── Productos.java                    # Clase abstracta base
├── FabricaDeProductos.java          # Factory que crea productos
├── Bebidas.java                     # Producto concreto
├── Carnicos.java                    # Producto concreto
├── Dulces.java                      # Producto concreto
├── Empaquetados.java                # Producto concreto
├── Ropa.java                        # Producto concreto
├── FacturaDeCompra.java             # Gestión del carrito y factura
├── ManejoDeTienda.java              # Constantes y mensajes
├── Reto1TiendaDonPepe.java          # Programa principal
└── productos.txt                     # Base de datos de productos
```

### Funcionalidades

1. **Carga de Productos**: Lee productos desde un archivo de texto (`productos.txt`) y utiliza la fábrica para crear instancias según su categoría.

2. **Visualización de Productos**: Muestra todos los productos disponibles con nombre, precio y descripción.

3. **Sistema de Compras**:
   - Permite agregar productos al carrito indicando número y cantidad
   - Genera factura detallada con:
     - Lista de productos comprados
     - Subtotal
     - Descuento aplicado (5% nuevos, 10% frecuentes)
     - Total a pagar

4. **Tipos de Clientes**:
   - **Nuevo**: Descuento del 5%
   - **Frecuente**: Descuento del 10%

### Aplicación de Programación Funcional

#### 1. Streams para mostrar productos
```java
String productosDisponibles = IntStream.range(0, limite)
    .mapToObj(i -> (i + 1) + ". " + productos.get(i).getNombre() +
    " - $" + productos.get(i).getPrecio() + " - " +
    productos.get(i).getDescripcion())
    .reduce("", (a, b) -> a + b + "\n");
```

#### 2. Filter y forEach para la factura
```java
Arrays.stream(productosComprados)
    .filter(fila -> fila != null && fila[0] != null)
    .forEach(fila -> 
        System.out.println(fila[0] + " x" + fila[2] + " - $" + fila[1])
    );
```

#### 3. MapToDouble y Sum para calcular totales
```java
double subtotal = Arrays.stream(productosComprados)
    .filter(fila -> fila != null && fila[0] != null)
    .mapToDouble(fila -> 
        Double.parseDouble(fila[1]) * Integer.parseInt(fila[2])
    )
    .sum();
```

### Cómo Ejecutar
```bash
cd Laboratorio2/reto1
javac *.java
java Reto1TiendaDonPepe
```

---

## Reto #2 – El Chef de 5 Estrellas

### Descripción
Sistema interactivo para construir hamburguesas personalizadas, permitiendo al usuario seleccionar ingredientes de un menú y calcular el precio total de forma dinámica.

### Patrón de Diseño
**Creacional → Builder**

### Justificación
El patrón Builder es perfecto para este caso porque:
- Permite construir objetos complejos (hamburguesas) paso a paso
- Facilita la creación de hamburguesas con diferentes combinaciones de ingredientes opcionales
- Separa la construcción de un objeto complejo de su representación
- Permite crear diferentes representaciones usando el mismo proceso de construcción
- Ideal para productos con múltiples configuraciones posibles

### Estructura del Proyecto

```
reto2/
├── Ingredient.java                  # Clase inmutable de ingrediente
├── Hamburger.java                   # Producto final
├── HamburgerBuilder.java            # Constructor de hamburguesas
├── Chef.java                        # Director (opcional)
└── Application.java                 # Programa principal
```

### Funcionalidades

1. **Menú Interactivo**: Presenta opciones de ingredientes con sus precios individuales

2. **Construcción Paso a Paso**: Permite agregar ingredientes uno por uno:
   - Pan ($2000)
   - Carne ($5000)
   - Queso ($1500)
   - Vegetales ($1000)
   - Salsa ($800)

3. **Cálculo Automático**: Calcula el precio total de la hamburguesa sumando todos los ingredientes seleccionados

4. **Visualización Final**: Muestra la hamburguesa completa con:
   - Lista de todos los ingredientes
   - Precio de cada ingrediente
   - Precio total

### Aplicación de Programación Funcional

#### 1. Expresiones Lambda en el Switch
```java
switch (option) {
    case 1 -> builder.addIngredient("Pan", 2000);
    case 2 -> builder.addIngredient("Carne", 5000);
    case 3 -> builder.addIngredient("Queso", 1500);
    // ...
}
```

#### 2. Stream para calcular precio total
```java
public double getTotalPrice() {
    return ingredients.stream()
            .mapToDouble(i -> i.getPrice())
            .sum();
}
```

#### 3. ForEach para mostrar ingredientes
```java
public void show() {
    System.out.println("\nHAMBURGUESA FINAL");
    ingredients.forEach(i ->
            System.out.println("- " + i.getName() + " ($" + i.getPrice() + ")")
    );
    System.out.println("Total a pagar: $" + getTotalPrice());
}
```

### Cómo Ejecutar
```bash
cd Laboratorio2/reto2
javac *.java
java Application
```

---

## Tecnologías Utilizadas

- **Java 8+**: Streams, Lambdas, Method References
- **Patrones de Diseño**: Factory Method, Builder
- **Programación Funcional**: Filter, Map, Reduce, ForEach
- **I/O**: BufferedReader para lectura de archivos

## Conceptos Aplicados

### Programación Funcional
- Expresiones Lambda
- Streams API
- Operaciones de filtrado (filter)
- Transformaciones (map, mapToDouble, mapToObj)
- Operaciones terminales (forEach, sum, reduce)
- Inmutabilidad (final fields en Ingredient y Hamburger)

### Patrones de Diseño
- **Factory Method**: Creación flexible de productos categorizados
- **Builder**: Construcción paso a paso de objetos complejos

### Buenas Prácticas
- Separación de responsabilidades
- Encapsulamiento
- Código limpio y mantenible
- Uso de constantes para mensajes
- Validación de entrada de usuario

---

## Autores
- **Camilo Alfonso Leon Acosta**
- **Roger Mauricio Duran Guacaneme**

Laboratorio desarrollado para el curso de Diseño Orientado a Software (DOSW 401)

## Fecha
Febrero 2026
