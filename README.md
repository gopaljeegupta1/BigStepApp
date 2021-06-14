# BigStepApp

## Problem statement ##

Build an Android app that will show videos in tab using iTunes api. You’ve to use networking library to fetch the data from the api and display it in recycler view

Requirements:
The main activity should have 2 tabs (swipe to change)

1. First Tab <br/>

      a) Video <br/>
      • Inputs: You've to fetch the data from API ( https://itunes.apple.com/search?term=Michael+jackson&amp;media=musicVideo )
      • Outputs: Name of the song, thumbnail profile.
      • Upon selecting a video in the list, the Video info page for that video will be displayed (in a
      new activity / page).

      b) Video info page <br/>
      • Video thumbnail top of the page.
      • Display Song name, author name, date, price etc.

2. Second Tab <br/>

      a) History <br/>
      • Outputs: Clicked item will be shown in history tab.
      For ex. If you&#39;ve clicked on a video &quot;Thriller&quot; then this item will be shown in history.
      NOTE: You&#39;ve to use a local database to store the history locally and display it at each
      time when app launched (Realm/Room/Any)

      
## Skills Set

  * Kotlin 
  * Coroutines for asynchronous.
  * Dagger-Hilt for dependency injection.
  * JetPack
  * LiveData - notify domain layer data to views.
  * ViewModel - UI related data holder, lifecycle aware.
  * Data Binding - declarative bind observable data to UI elements.
  * Architecture <br/>
      o   MVVM Architecture (View - DataBinding - ViewModel - Model) <br/>
      o   Repository pattern
  * Glide - loading images.
  * Retrofit2 & OkHttp3 - construct the REST APIs and paging network data.
   
## Screenshots   

<div style="display: flex;width: 100%;justify-content: space-between;">
    <img style="margin-right: 10px;" src="/screenshot/screen1.jpg" width="250" height="600">   
    <img style="margin-right: 10px;" src="/screenshot/screen2.jpg" width="250" height="600"> 
    <img style="margin-right: 10px;" src="/screenshot/screen3.jpg" width="250" height="600"> 
</div>

<br/><br/>
--- Don't forget to comments for more improvement ---
