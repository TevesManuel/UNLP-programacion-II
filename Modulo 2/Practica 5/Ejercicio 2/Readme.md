# 2
- ## a) Defina el concepto de herencia.
        La herencia es cuando una clase extiende a otra clase padre o superclase, heredando sus atributos y metodos
- ## b) Defina el concepto de clase abstracta y método abstracto. ¿Cuál es su utilidad
        Una clase abstracta es una clase que no puede instanciarse y puede contener metodos abstractos, que deben redefinirse cuando una subclase extiende esta clase abstracta, su utilidad es permitir el uso de herencia y polimorfismo, entonces podriamos castear una instancia de la subclase con el tipo padre y acceder a el metodo redefinido para esa subclase.
- ## c) Describa los pasos que se siguen cuando se busca un método en la jerarquía de clases. En particular, para la siguiente sentencia, indique qué métodos se ejecutan y cómo se localizan en la jerarquía de clases:
```java
        Entrenador e = new Entrenador(…);
        System.out.println(e.toString());
```
        Se busca el metodo toString en la clase Entrenador, si no esta se busca en la superclase directa y asi sucesivamente hasta llegar a la clase Object y encontrar el metodo definido por Object o que haya un metodo toString en alguna superclase