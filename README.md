# Iron Gym Demo (CRUD)

Es una aplicación móvil desarrollada en **Android Studio** con **Kotlin**, que permite gestionar ejercicios de un gimnasio mediante operaciones CRUD (Crear, Leer, Actualizar y Eliminar). La app se comunica con una API desarrollada en **Node.js con Express**, y utiliza **MongoDB** como base de datos.

---

## Funcionalidades actuales

- Añadir nuevos ejercicios (nombre, descripción, tipo, etc.)
- Editar ejercicios existentes
- Eliminar ejercicios
- Listar todos los ejercicios desde el servidor

---

## Tecnologías utilizadas

### Cliente (App móvil)
- Kotlin
- Android Studio
- Retrofit

### Servidor (Backend)
- Node.js
- Express
- MongoDB
- Mongoose (ODM)

---

## Estructura de comunicación

La app se comunica con un servidor backend mediante llamadas HTTP usando Retrofit. Las operaciones CRUD se gestionan a través de endpoints definidos en el servidor Express.

```bash
GET     /api/ejercicios        -> Listar ejercicios
POST    /api/ejercicios        -> Crear nuevo ejercicio
PUT     /api/ejercicios/:id    -> Editar ejercicio
DELETE  /api/ejercicios/:id    -> Eliminar ejercicio
```

---

## Posibles mejoras futuras

- **Autenticación de usuarios**: Implementar inicio de sesión y registro con JWT.
- **Acceso con código QR**: Generación automática de un QR único para cada usuario registrado que permita el acceso a las instalaciones.
- **Sincronización en la nube**: Guardar progreso de ejercicios y rutinas por usuario.
- **Estadísticas**: Visualizar métricas como frecuencia de entrenamiento, progreso, etc.

---

