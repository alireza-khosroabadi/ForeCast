# Forecast



With this little and minimal application, we received mocked Gothenburg location to get its forecast data,the main goal in this project
is writing a dynamic UI forced from backend. we should find UI elements and its orders from JSON file received from API.
I selected RecyclerView to develop it, using recyclerview is one of the most popular and more efficient way to develop this kind of application
and dynamic UIs. for this so I built different types of views, to better reusing and I wrote it as custom view. for simplicity of this 
application I implemented its UI in a Activity.


## Project Structure ⚙️

This Application is based on **CLEAN** architecture combined with **MVVM** architecture and is written in **Kotlin**.
For dependency injection I us **Hilt** and **Coroutine Flow** for reactive programming. I try to follow up **SOLID** and **KISS** principles.
Wrote unit tests and ui tests for add more stability and trust ability to my codes.



**Application**

The application contains these packages:

* `base/` : contains application class, base classes, constant variables, extension functions and convertors.
* `presentation/` : contains all UI related classes (ViewModel, Activity), and custom UIs
* `data/` : the duty of this layer is provide data, and implemented Repositories, it works with different kind of data stores. and upper layer does`nt have any knowledge about data layer implementation.
* `di/` : contains dependency injection classes
* `domain/` : domain layer, we should implement this layer for implementing logics. and in addition I develop Domain data model (UseCaseModel) for UI related Data, because the data received from API is not well to use in UI so I map it to domain data model in this layer and use this model on UIs.


**Tests**
* `unit tests` automated tests to check api calls
* `Functional tests` automated tests to check UI components (used Espresso)


## Screenshots

  Light Mode               |  Dark Mode
:-------------------------:|:-------------------------:
<img src="https://github.com/alireza-khosroabadi/ForeCast/blob/master/screenshots/light.jpg" width="280">  | <img src="https://github.com/alireza-khosroabadi/ForeCast/blob/master/screenshots/dark.jpg" width="280">


## Libraries and tools 🛠

- Kotlin
- Retrofit
- Kotlin coroutines
- Coroutines flow
- Room
- Dagger Hilt
- View Binding
- Espresso



## Appendix

Contact address

* Email  : khosroabadi.alireza@gmail.com
