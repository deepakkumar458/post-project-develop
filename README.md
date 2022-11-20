# Gojek Android Assignment

This project contains boilerplate code which candidate can build upon during machine coding round. In its different branches you'll find the same app implemented with different dependency injection framework. 

### Branches Description
|     Branch     | Description |
| ------------- | ------------- |
| master | This branch uses [Dagger 2](https://dagger.dev/) for DI|
| dependencies/koin | This branch uses [koin](https://insert-koin.io/docs/quickstart/android/) for DI |
| dependencies/hilt| This branch uses [hilt](https://developer.android.com/training/dependency-injection/hilt-android) for DI  |


## Opening the project
First checkout the branch according to DI framework you are most comfortable with and then open the root directory in Android Studio

## Packages
* **customviews**: This package contains a custom view named as FullScreenView which you can use to show loader or error view. 
* **dependencies**: This package contains basic DI framework setup. It contains dependencies providers for frequently used libraries like Retrofit, Picasso etc.
* **disptacher**: This package contains coroutine dispatcher setup classes.
* **extensions**: Basic utility methods.
* **persistance**: Room database setup.

**Note**: Initial code setup is provided to help you save time. You can choose to use part of it as per your requirement. 
