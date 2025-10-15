# Agenda de Usuarios - Spring Boot + Thymeleaf + Bootstrap

📒 Proyecto de ejemplo que permite gestionar una agenda de usuarios almacenada en un archivo JSON.  
El proyecto está desarrollado con **Spring Boot 3**, **Thymeleaf** y **Bootstrap 5** para la interfaz web.

---

![Debian](https://img.shields.io/badge/Linux-Debian-red?logo=debian&logoColor=white)
![Java](https://img.shields.io/badge/Java-SpringBoot-green?logo=java&logoColor=white)



## Características

- Mostrar todos los usuarios registrados en un archivo JSON.
- Agregar nuevos usuarios a la agenda mediante un formulario web.
- Interfaz responsiva y moderna usando Bootstrap.
- Datos persistentes en `usuario.json`.



## Tecnologías
- Java 24
- Spring Boot 3.5.x
- Thymeleaf 3
- Bootstrap 5
- Jackson (para lectura/escritura de JSON)

---
## 📷 Captura de pantalla

![Agenda de Usuarios](pantalla.png)

## Estructura del Proyecto
```text
agenda-json/
│
├─ src/main/java/com/anamuc/jsonReader/
│ ├─ AgendaJsonApplication.java # Clase principal de Spring Boot
│ └─ AgendaController.java # Controlador que maneja la lógica de usuarios
│
├─ src/main/resources/templates/
│ └─ index.html # Plantilla Thymeleaf con Bootstrap
│
├─ src/main/resources/static/
│ └─ (opcional: archivos CSS/JS adicionales)
│
├─ usuario.json # Archivo JSON con los usuarios
├─ pom.xml # Dependencias Maven
└─ README.md
```

---

## Cómo ejecutar el proyecto
```text
Clone el proyecto
cd agenda-json
mvn clean install
mvn spring-boot:run
http://localhost:8080/
```
 # Uso
Completar el formulario Agregar Usuario y hacer clic en "Agregar Usuario".
Ver los usuarios registrados en la tabla debajo del formulario.
Todos los datos se guardan en usuario.json.
# Nota
El proyecto no requiere base de datos, todos los datos se almacenan en un JSON local.
Se puede mejorar añadiendo validaciones, eliminación de usuarios y edición de registros.

###  
[![LinkedIn](https://img.shields.io/badge/LinkedIn-%230A66C2.svg?logo=linkedin&logoColor=white)](https://www.linkedin.com/in/moleculax) [![Instagram](https://img.shields.io/badge/Instagram-%23E4405F.svg?logo=instagram&logoColor=white)](https://www.instagram.com/moleculax)   [![Build with ❤️](https://img.shields.io/badge/built%20with-%E2%9D%A4-red)]() [![Status](https://img.shields.io/badge/status-en%20evolución-8A2BE2)]()  [![Debian](https://img.shields.io/badge/Debian-A81D33.svg?logo=debian&logoColor=white)](https://www.debian.org/) [![Docker Hub](https://img.shields.io/badge/Docker-%230db7ed.svg?logo=docker&logoColor=white)](https://hub.docker.com/u/moleculax)


 “Cada sistema tiene errores. Cada error, una historia. Cada historia, una evolución.”
###
