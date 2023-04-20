# PicturesApp

This project demonstrates with 
1. Kotlin MVVM architecture 
2. Dagger Hilt for Dependency Injection
3. Retrofit for API call
4. Navigation Component for nav_graph
5. Coil for image loading

The main components of this project are:
1. model package : represents Data Layer
2. viewmodel package : represents Domain Layer
3. view package : represents Presentation Layer
4. di package 

Data Layer -> Repository is dependent with Service (API calls)
Domain Layer -> ViewModel is dependent with Repository 
Presentation Layer -> View (Activity, Fragment) is dependent with ViewModel 
So presentation layer don't know about Data Layer.
 
