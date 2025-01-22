# Juego 2D: Aventura con Monstruos

¡Bienvenido a **Cantares de Iberia**! Este es un emocionante juego 2D en el que los jugadores pueden enfrentarse a monstruos de varios tipos, mejorar sus habilidades, adquirir objetos y disfrutar de un modo historia inmersivo.

## 🚀 Características del Juego

- **Modo Historia**: Vive una narrativa épica mientras exploras el mundo del juego.
- **Monstruos Variados**: Encuentra y enfréntate a diferentes tipos de monstruos con habilidades únicas.
- **Sistema de Inventario**: Compra y gestiona objetos que te ayudarán en tu aventura como espadas o pociones.
- **Progresión del Jugador**: Mejora tus estadísticas, como velocidad, resistencia y daño, para volverte más poderoso.
- **Interacciones con el Entorno**: Utiliza combinaciones de teclas para acceder a tiendas, inventarios y más.

## 🛠️ Tecnologías Utilizadas

- **Java**: Lenguaje principal del proyecto.
- **Swing**: Para la interfaz gráfica del usuario (GUI).
- **AWT**: Para manejar gráficos y eventos clave.
- **SQL**: Para almacenar y cargar el progreso del jugador.
- **Audio**: Soporte para efectos de sonido y música de fondo mediante archivos `.wav`.
- **BufferedImage**: Para manejar las colisiones en el mapa.

## 🎮 Controles del Juego

- **W, A, S, D**: Movimiento del jugador.
- **Shift**: Correr (consume resistencia).
- **Ctrl + T**: Abrir la tienda (cuando estás en la zona correspondiente).
- **Ctrl + E**: Abrir el inventario.

## 📋 Requisitos del Sistema

- **Java SE 8 o superior**.
- **Sistema Operativo**: Windows, macOS o Linux.
- **Resolución de Pantalla**: Mínimo 1280x720.
- **Memoria RAM**: 2GB o superior.
- **Espacio en Disco**: 200MB para archivos del juego.

## 📂 Estructura del Proyecto

├── src │ ├── Main.java # Archivo principal que inicia el juego. │ ├── Jugador.java # Clase para gestionar las estadísticas del jugador. │ ├── VentanaMapa.java # Clase para manejar la ventana principal del juego. │ ├── VentanaAudio.java # Clase para gestionar la música de fondo. │ ├── VentanaInicio.java # Clase para el menú de inicio. │ ├── VentanaTienda.java # Clase para gestionar la tienda. │ ├── VentanaInventario.java # Clase para el inventario. │ └── BD.java # Clase para manejo de la base de datos. ├── resources │ ├── Imagenes/ # Directorio con sprites y mapas del juego. │ ├── Sonidos/ # Directorio con efectos de sonido y música. │ └── Datos/ # Archivos para guardar el progreso. └── README.md # Este archivo.


## ⚙️ Cómo Ejecutar el Proyecto

1. **Clona el repositorio**:
   ```bash
   git clone https://github.com/usuario/aventura-con-monstruos.git
   cd aventura-con-monstruos

   
