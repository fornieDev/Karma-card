# KARMA CARD

Karma card es una app nativa Android que sirve para establecer unas normas de casa con los hijos y penalizaciones por puntos,pudiendo notificar cualquier infracción y descontando puntos (como un carnet por puntos de comportamiento).De igual manera,se pueden establecer requisitos para ciertas actividades (por ejemplo,jugar a la consolo necesitas un saldo de al menos 6 puntos).También se deben establecer sistemas de obtención de puntos para recuperar los puntos perdidos.

## 👨‍💻 Autores (proyecto colaborativo)
- Jazmi
- [@fornieDev](https://github.com/fornieDev)

## 🛠️ Tecnologías:

### 🖥️ IDE:
-Android Studio
### 💻 Lenguaje:
-Kotlin (sealed class, flow, extension functiones,result pattern).
### 🏗️ Arquitectura:
-MVVM,Clean architecture,multimodule.
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
-Springboot,PostgreSQL.

## 📂 Estructura del proyecto:
### app
### core
  logger
  errorHandler
  network
### data
  local
  remote
  repository implementations
  mapper
### domain
  model
  repository interfaces
  usecase
### design-system
  colors
  themes
  fonts
  components
### ui
  view
  viewmodel
  state
  event
### feature-splash
  splashView
  splashViewModel
  splashUIState
  spashEvent
  splashNavigation
### feature-login
### feature-home
### feature-dashboard






