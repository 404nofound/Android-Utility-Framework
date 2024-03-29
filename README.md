# Android-Utility-Framework
This repository provides basic Android Development Utility.

### Get Application Context

Override Application class and define **static** context variable and **getContext()** function.

### Log Util Tool

Debug / Release, change the **level** variable in **LogUtil.java** before release, all log info will be hidden.

### Passing Object Value by Intent

Implement Serializable / Parcelable. Recommend: Parcelable, becasue Serializable will serialize all object, so it has low producticity. Code in **model folder** and **activity files**.

### OkHttp Usage - (Http Get/Post Request)

Define a file: **HttpUtil.java**. Call functions when we need internet request, we can deal with success and failure condition.
Tips: We need to add **Internet permission** in **AndroidManifest.xml**

### Activity Collector

Recording all activities and finishing all of them when exiting the app.

### Best Way to Start Activity

Define construction function for SecondActivity, call it in MianActivity. (Better for working / job).

### Network & GPS Detection Listener

Using Broadcast Receiver to listener Intent Actions. 
