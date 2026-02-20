# Programación - Preguntas Teóricas

## 15. ¿Cuáles son los tipos de datos primitivos en Java?

Java tiene **8 tipos de datos primitivos**:

| Tipo | Tamaño | Descripción | Ejemplo |
|------|--------|-------------|---------|
| `byte` | 8 bits | Entero pequeño (-128 a 127) | `byte b = 100;` |
| `short` | 16 bits | Entero corto (-32,768 a 32,767) | `short s = 1000;` |
| `int` | 32 bits | Entero estándar | `int i = 42;` |
| `long` | 64 bits | Entero grande | `long l = 100000L;` |
| `float` | 32 bits | Decimal simple precisión | `float f = 3.14f;` |
| `double` | 64 bits | Decimal doble precisión | `double d = 3.14159;` |
| `char` | 16 bits | Un carácter Unicode | `char c = 'A';` |
| `boolean` | 1 bit | Verdadero o falso | `boolean x = true;` |

---

## 16. ¿Cómo funcionan las estructuras de control de flujo en Java?

### `if / else`
Ejecuta un bloque de código según una condición:

```java
int edad = 18;
if (edad >= 18) {
    System.out.println("Mayor de edad");
} else {
    System.out.println("Menor de edad");
}
```

### `switch`
Selecciona entre múltiples opciones según el valor de una variable:

```java
int dia = 2;
switch (dia) {
    case 1: System.out.println("Lunes"); break;
    case 2: System.out.println("Martes"); break;
    default: System.out.println("Otro día");
}
```

### Bucles

```java
// for: número de iteraciones conocido
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}

// while: se repite mientras la condición sea verdadera
int i = 0;
while (i < 5) {
    System.out.println(i);
    i++;
}

// do-while: ejecuta al menos una vez
do {
    System.out.println(i);
    i++;
} while (i < 5);
```

---

## 17. ¿Por qué es importante usar nombres significativos para variables y métodos?

Usar **nombres descriptivos** mejora la legibilidad y mantenibilidad del código. Un nombre claro comunica la intención sin necesidad de comentarios adicionales.

```java
// ❌ Malo - difícil de entender
int x = 86400;
boolean f(int a, int b) { return a > b; }

// ✅ Bueno - autodocumentado
int segundosPorDia = 86400;
boolean esMayor(int valorActual, int limite) { return valorActual > limite; }
```

Además facilita la colaboración en equipo, reduce errores al modificar el código y sigue principios como el **Clean Code** de Robert C. Martin.

---

## 18. ¿Qué es la Programación Orientada a Objetos (POO)?

La **Programación Orientada a Objetos (POO)** es un paradigma de programación que organiza el software en torno a **objetos**, que son instancias de **clases**. Una clase define atributos (datos) y métodos (comportamientos) que describen entidades del mundo real o conceptual.

```java
public class Persona {
    String nombre;
    int edad;

    public void saludar() {
        System.out.println("Hola, soy " + nombre);
    }
}

Persona p = new Persona();
p.nombre = "Ana";
p.saludar(); // "Hola, soy Ana"
```

---

## 19. ¿Cuáles son los cuatro pilares de la POO?

### 1. 🔒 Encapsulamiento
Ocultar los detalles internos de un objeto y exponer solo lo necesario mediante modificadores de acceso (`private`, `public`) y métodos getters/setters.

### 2. 🧬 Herencia
Una clase puede **heredar** atributos y métodos de otra clase, promoviendo la reutilización de código.

### 3. 🎭 Polimorfismo
Un objeto puede comportarse de múltiples formas. Un mismo método puede tener diferentes implementaciones según el objeto que lo invoque.

### 4. 🧩 Abstracción
Simplificar la complejidad mostrando solo los aspectos esenciales de un objeto, ocultando los detalles de implementación (mediante clases abstractas o interfaces).

---

## 20. ¿Qué es la herencia en POO y cómo se utiliza en Java?

La **herencia** permite que una clase (subclase o clase hija) adquiera los atributos y métodos de otra clase (superclase o clase padre), usando la palabra clave `extends`.

```java
// Clase padre
public class Animal {
    String nombre;

    public void comer() {
        System.out.println(nombre + " está comiendo.");
    }
}

// Clase hija que hereda de Animal
public class Perro extends Animal {
    public void ladrar() {
        System.out.println("¡Guau!");
    }
}

Perro perro = new Perro();
perro.nombre = "Rex";
perro.comer();   // heredado de Animal
perro.ladrar();  // propio de Perro
```

Java solo permite **herencia simple** (una clase hereda de una sola clase padre), pero soporta herencia múltiple mediante interfaces.

---

## 21. ¿Qué son los modificadores de acceso en Java?

Los **modificadores de acceso** controlan la visibilidad de clases, atributos y métodos:

| Modificador | Misma clase | Mismo paquete | Subclase | Cualquier clase |
|-------------|:-----------:|:-------------:|:--------:|:---------------:|
| `private`   | ✅ | ❌ | ❌ | ❌ |
| *(default)* | ✅ | ✅ | ❌ | ❌ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| `public`    | ✅ | ✅ | ✅ | ✅ |

```java
public class CuentaBancaria {
    private double saldo;          // solo accesible dentro de la clase

    public double getSaldo() {     // accesible desde cualquier lugar
        return saldo;
    }

    protected void depositar(double monto) {  // accesible en subclases
        saldo += monto;
    }
}
```

---

## 22. ¿Qué es una variable de entorno y por qué son importantes?

Una **variable de entorno** es una variable del sistema operativo que almacena información de configuración accesible por cualquier proceso del sistema. Son importantes porque permiten separar la configuración del código fuente.

**En Java**, la variable de entorno más importante es:

- **`JAVA_HOME`**: Apunta al directorio de instalación del JDK. La utilizan herramientas como Maven, Gradle y otros IDEs para encontrar Java.
- **`PATH`**: Incluye el directorio `bin` de Java para poder ejecutar `java` y `javac` desde cualquier terminal.

```bash
# Configurar JAVA_HOME en Linux/Mac
export JAVA_HOME=/usr/lib/jvm/java-17
export PATH=$JAVA_HOME/bin:$PATH

# Verificar
java -version
```

En general, las variables de entorno permiten manejar credenciales, rutas y configuraciones **sin hardcodearlas** en el código, lo que es una práctica esencial de seguridad y buenas prácticas de desarrollo.

---

> **Recursos recomendados:**
> - [Documentación oficial de Java](https://docs.oracle.com/en/java/)
> - [NetBeans IDE](https://netbeans.apache.org/)
> - [Tutoriales NetBeans Java](https://netbeans.apache.org/tutorial/main/kb/docs/java/)
