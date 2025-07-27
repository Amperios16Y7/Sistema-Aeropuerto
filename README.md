# Sistema-Aeropuerto

**✈️ Sistema de Punto de Venta – Skywell Airlines**

Equipo 9 – Proyecto de Programación Java

👥 Integrantes:

* Jarquín Rivera Orlando Miguel – Desarrollador principal e interfaz

* Pérez Ríos Yael Amir – Base de datos, validaciones y documentación


**🛫 ¿Qué hace el sistema?**
Skywell Airlines es un sistema de venta de boletos de avión, que permite gestionar vuelos, pasajeros, aeropuertos y empleados. El sistema valida usuarios al iniciar sesión, permite registrar nuevos pasajeros y realiza la venta de boletos generando un PDF y enviándolo por correo.

**💻 Tipo de sistema**
Aplicación de escritorio (Desktop App) desarrollada en Java con Swing como interfaz gráfica, y conectada a una base de datos MySQL.

**🔌 Librería externa implementada**
Se utilizó la librería "Validación de correos y contraseñas" del Equipo 16 para validar los campos del formulario de registro.
🔗 

**🧩 Componente visual integrado**
No se utilizó un componente visual externo de otro equipo. Sin embargo, implementamos tablas dinámicas personalizadas para mostrar y modificar datos como usuarios, vuelos y aeropuertos usando JTable y JScrollPane.

# 🚀 Funcionalidades Clave

**🔐 Integración de validación**

Validación de correo y contraseña en el registro de usuarios mediante la librería del Equipo 16.

**👤 CRUD de Usuarios**

Alta, baja, modificación y consulta de usuarios desde una interfaz sencilla.

**🛬 CRUD de Vuelos, Aeropuertos y Empleados**

Administración completa de registros relacionados con los vuelos.

**🎫 Proceso principal: Venta de boletos de avión**

El usuario selecciona un vuelo disponible, registra al pasajero y genera automáticamente un boleto con número de asiento, vuelo y fecha.

**📧 Envío de correo electrónico con PDF adjunto**

Se genera un boleto en formato PDF con los datos del vuelo y pasajero usando PDFBox.

El archivo se adjunta automáticamente y se envía al correo del pasajero mediante Jakarta Mail y Activation API.

Se realizaron ajustes al diseño del PDF y mensajes de correo.

**🆕 Funcionalidades únicas del proyecto:**

Validación en tiempo real de asientos disponibles.

Control de relaciones entre vuelos, aeropuertos y pasajeros mediante claves foráneas.

Uso de calendario para seleccionar fecha del vuelo.

# ⚙️ Dependencias y Configuración

**📦 Librerías externas utilizadas:**

| Librería              | Uso principal                     |
| --------------------- | --------------------------------- |
| `jakarta.mail`        | Envío de correos electrónicos     |
| `PDFBox`              | Creación de boletos en PDF        |
| `MySQL Connector`     | Conexión con base de datos        |
| `jcalendar`           | Selección de fechas               |
| `absolute-layout.jar` | Posicionamiento de componentes    |
| `jgoodies looks`      | Mejorar apariencia de interfaz    |
| `Equipo 16 Validator` | Validación de correo y contraseña |


**🛠️ Pasos para ejecutar el sistema**

Clonar este repositorio.

Abrir el proyecto en NetBeans 12+.

Asegurarse de tener Java JDK 11 o superior instalado.

Agregar las librerías externas (.jar) al proyecto.

Configurar tu base de datos MySQL con el script aeropuerto_db.sql.

Cambiar credenciales de acceso a base de datos en la clase Conexion.java.

Ejecutar el archivo Main.java.

**✅ Requisitos mínimos**

Java: JDK 11 o superior

MySQL: 8.0 o compatible

NetBeans: 12 o superior

Conexión a internet (para envío de correos)

¡Gracias por revisar nuestro proyecto!
Skywell Airlines – Porque volar también es una experiencia digital. 🛫🌐
