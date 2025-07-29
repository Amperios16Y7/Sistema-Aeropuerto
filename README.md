# Sistema-Aeropuerto

**✈️ Sistema de Punto de Venta – Skywell Airlines**

**Equipo 9 – Proyecto de Programación Java**

**👥 Integrantes:**

* Jarquín Rivera Orlando Miguel – Desarrollador principal e interfaz

* Pérez Ríos Yael Amir – Base de datos, validaciones y documentación


**🛫 ¿Qué hace el sistema?**

Skywell Airlines es un sistema de venta de boletos de avión, que permite gestionar vuelos, pasajeros, aeropuertos y empleados. El sistema valida usuarios al iniciar sesión, permite registrar nuevos pasajeros y realiza la venta de boletos generando un PDF y enviándolo por correo.

<img width="1199" height="402" alt="image" src="https://github.com/user-attachments/assets/8ef6237b-7ecf-4780-a9dd-664cb0376ef2" />


**💻 Tipo de sistema**

Aplicación de escritorio (Desktop App) desarrollada en Java con Swing como interfaz gráfica, y conectada a una base de datos MySQL.

<img width="565" height="324" alt="image" src="https://github.com/user-attachments/assets/2ca6d62a-6426-48c6-aff5-6c88c269df6a" />


**🔌 Librería externa implementada**

Se utilizó la librería "Validación de correos y contraseñas" del Equipo 16 para validar los campos del formulario de registro.
🔗 https://github.com/YHUDIEL/Login-con-validaciones

**🧩 Componente visual integrado**

No se utilizó un componente visual externo de otro equipo. Sin embargo, implementamos tablas dinámicas personalizadas para mostrar y modificar datos como usuarios, vuelos y aeropuertos usando JTable y JScrollPane.

<img width="738" height="236" alt="image" src="https://github.com/user-attachments/assets/4f8a7af1-31ad-4154-8b96-af0757f69304" />


# 🚀 Funcionalidades Clave

**✅ Integración de CAPTCHA**

Se implementó el componente CAPTCHA del Equipo 2 en el formulario de inicio de sesión.

Su función es evitar accesos automatizados: el usuario debe introducir correctamente el texto del CAPTCHA generado antes de iniciar sesión.

El componente fue adaptado para mostrar una imagen con letras aleatorias y validar la entrada manual antes de verificar el correo y contraseña.

<img width="573" height="356" alt="image" src="https://github.com/user-attachments/assets/f5d4f079-d876-413c-b0e0-137a80ac0fc9" />


**🔐 Integración de validación**

Validación de correo y contraseña en el registro de usuarios mediante la librería del Equipo 16.

**Implementaciòn en el boton registrar:**

<img width="990" height="557" alt="image" src="https://github.com/user-attachments/assets/e04e341f-c18b-4a7c-9043-78346be7d52d" />

<img width="819" height="213" alt="image" src="https://github.com/user-attachments/assets/60326e59-29cf-4d6a-96e7-3a93843550d3" />

**Validar correo:**

<img width="1358" height="1068" alt="image" src="https://github.com/user-attachments/assets/8c0a4d90-91da-4324-b11f-4a2ccc35b422" />

**Validar contraseña:**

<img width="658" height="1072" alt="image" src="https://github.com/user-attachments/assets/62478db0-fc57-4982-a027-65e7fc898be8" />


**👤 CRUD de Usuarios**

Alta, baja, modificación y consulta de usuarios desde una interfaz sencilla.

<img width="1920" height="654" alt="image" src="https://github.com/user-attachments/assets/cf9fa971-d6b7-445b-b6a5-c97b376ff5f9" />


**🛬 CRUD de Vuelos, Aeropuertos, Pasajeros y Empleados**

Administración completa de registros relacionados con los vuelos, aeropuertos, pasajeros y empleados.

**Vuelos:**
<img width="1908" height="646" alt="image" src="https://github.com/user-attachments/assets/d5ddba00-1a76-4507-b44d-16a04b436e77" />

**Aeropuertos:**
<img width="2004" height="658" alt="image" src="https://github.com/user-attachments/assets/9fec80fa-389f-4c0f-bb96-31638e3561db" />

**Pasajeros:**
<img width="1910" height="644" alt="image" src="https://github.com/user-attachments/assets/0d08e6c3-9ba2-4912-8137-8fcdfc450771" />

**Empleados:**
<img width="1912" height="648" alt="image" src="https://github.com/user-attachments/assets/8ef81585-4afd-49ec-b44d-cb9967973928" />


**🎫 Proceso principal: Venta de boletos de avión**

El usuario selecciona un vuelo disponible, registra al pasajero y genera automáticamente un boleto con número de asiento, vuelo y fecha.

<img width="2400" height="920" alt="image" src="https://github.com/user-attachments/assets/4d5aedfb-13b9-421c-af39-a4ecc56ca403" />


**📧 Envío de correo electrónico con PDF adjunto**

Se genera un boleto en formato PDF con los datos del vuelo y pasajero usando PDFBox.

<img width="362" height="432" alt="image" src="https://github.com/user-attachments/assets/5a84f21b-502c-4304-be11-33b59198faf1" />

El archivo se adjunta automáticamente y se envía al correo del pasajero mediante Jakarta Mail y Activation API.

<img width="2866" height="840" alt="image" src="https://github.com/user-attachments/assets/bbad76c8-8e34-4fdb-8c70-6da813929519" />

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

1. Clonar este repositorio.

2. Abrir el proyecto en NetBeans 12+.

3. Asegurarse de tener Java JDK 11 o superior instalado.

4. Agregar las librerías externas (.jar) al proyecto.

5. Configurar tu base de datos MySQL con el script aero_db.sql.

6. Cambiar credenciales de acceso a base de datos en la clase Conexion.java.

7. Ejecutar el archivo Main.java.

**✅ Requisitos mínimos**

Java: JDK 11 o superior

MySQL: 8.0 o compatible

NetBeans: 12 o superior

Conexión a internet (para envío de correos)

**¡Gracias por revisar nuestro proyecto!
Skywell Airlines – Porque volar también es una experiencia digital. 🛫🌐**
