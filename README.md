# KARMA CARD

Karma card es una app nativa Android que sirve para establecer unas normas de casa con los hijos y penalizaciones por puntos,pudiendo notificar cualquier infracción y descontando puntos (como un carnet por puntos de comportamiento).De igual manera,se pueden establecer requisitos para ciertas actividades (por ejemplo,jugar a la consola necesitas un saldo de al menos 6 puntos).También se deben establecer sistemas de obtención de puntos para recuperar los puntos perdidos.

## 👨‍💻 Autores (proyecto colaborativo)
- [@jazminaconjota](https://github.com/jazminaconjota)
- [@fornieDev](https://github.com/fornieDev)

## 🛠️ Tecnologías:

### 🖥️ IDE:
-Android Studio,VS Code.
### 💻 Lenguaje:
-Kotlin (sealed class, flow, extension functiones,result pattern).
### 🏗️ Arquitectura:
-MVVM,Clean architecture.
### 🔀 Control de versiones:
-Git, GitFlow.
### 🔧 Dependencias:
-Dagger Hilt.
### 🎨 UI:
-Jetpack compose(Material 3, navigation compose, state hoisting, UI State pattern).
### 🗄️ Persistencia:
-Room(offlinea first),DataStore,Encrypted datastore,Retrofit,OkHttp,Kotlinx Serialization,Workmanager,paginación.
### ⏱️ Concurrencia:
-corrutines,dispatcher injection.
### 🔄 Control de estados: 
-stateFlow y sharedFlow.
### ⚠️ Manejo de errores:
sin try cath con sealed class o ...
### 🧪 Testing: 
-JUnit,MockK,Compose Testing,CI/CD,Turbine,test de integración.
### 🌐 Backend:
-Springboot,PostgreSQL,Supabase,Render.

## 📂 Estructura del proyecto:

```

root/
│
├── ui/
│   ├── view/
│   │   ├── activities/
│   │   └── screens/
│   │
│   ├── viewmodel/
│   │
│   └── state?/
│
├── domain/
│   ├── model/
│   │
│   ├── repositoryInt/
│   │
│   └── usecase/
│
├── data/
│   ├── repositoryImp/
│   │
│   ├── mapper/
│   │
│   └── datasource/
│       ├── remote/
│       │
│       └── local/
│
├── di/
│
└── core/
    ├── components/
    │
    ├── theme/
    │
    ├── network/
    │
    └── error/


```







