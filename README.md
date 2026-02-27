# Spotify Simulation - Estructuras de Datos (Queue)
Este proyecto simula un reproductor de música tipo Spotify utilizando una estructura de datos de Cola desarrollada completamente desde cero en Java. La arquitectura es modular, utilizando Maven para separar la lógica de la estructura de datos de la lógica de aplicación.

## Guía de Compilación e Instalación
Para que el proyecto funcione correctamente, es necesario seguir estos pasos en orden debido a la dependencia de proyectos.

### 1. Cómo compilar e instalar la Librería
La estructura de datos se encuentra en el proyecto umg.edu.gt.data-structure.queue. Para que esté disponible localmente:

Abra una terminal en la carpeta raíz de la librería.

Ejecute el siguiente comando:

  mvn clean install
  
Esto compilará el código y guardará el archivo .jar en su repositorio local de Maven (.m2), permitiendo que el proyecto Handler lo consuma.

### 2. Cómo compilar el Handler
Una vez instalada la librería, diríjase a la carpeta queueHandler:

Abra una terminal en dicha carpeta.

Ejecute el comando:

Bash
mvn clean package
Este comando generará el ejecutable en la carpeta target, incluyendo un archivo con el sufijo -jar-with-dependencies.jar que contiene todo lo necesario para correr la simulación.

### 3. Cómo ejecutar desde la consola
Para una experiencia visual correcta (donde la barra de progreso se actualice en una sola línea), ejecute el siguiente comando desde la carpeta queueHandler:

Bash
java -jar target/queueHanlder-0.0.1-SNAPSHOT-jar-with-dependencies.jar

## Explicación del Diseño y Decisiones Técnicas
Estructura de Datos Manual
Se implementó una clase genérica Queue<T> basada en nodos para cumplir con los requisitos de rendimiento:

Complejidad O(1): Se mantienen referencias privadas tanto al head (frente) como al tail (final) de la cola. Esto permite que las inserciones (enqueue) y extracciones (dequeue) no requieran recorrer la lista, garantizando un tiempo constante independientemente del tamaño de la cola.

Encapsulamiento: La clase Node<T> es interna y privada, evitando exponer la implementación interna al usuario de la librería.

### Sistema de Prioridad
Para gestionar las prioridades sin romper el principio FIFO interno, se optó por una estrategia de Multi-Queue Scheduling:

El simulador gestiona dos colas independientes: highPriorityQueue (Prioridad 1) y normalPriorityQueue (Prioridad 2).

Al agregar una canción, el sistema la clasifica en su cola respectiva.

Al iniciar la reproducción, el motor consume de forma exhaustiva la cola de alta prioridad antes de procesar la cola normal.

## Simulación de Duración y Reproducción
La simulación realista se logró mediante:

Paso del tiempo: Uso de Thread.sleep(1000) dentro de un bucle que itera según los segundos de duración de la canción (entre 5 y 30 segundos).

Interfaz de Consola: Uso del carácter de escape \r (Carriage Return). Esto permite que la barra de progreso se sobrescriba en la misma línea de la consola, evitando generar múltiples líneas de texto y ofreciendo una visualización limpia.

## Extensiones de Complejidad Implementadas (Parte D)
Barra de Progreso Visual: Se muestra un indicador gráfico [#####-----] que representa el porcentaje de avance de la canción en tiempo real.

Contador y Tiempo Total: Al finalizar la playlist, el sistema arroja un reporte detallado con el total de canciones reproducidas y el tiempo acumulado de la sesión de escucha.


