# Android-Utility-Framework
This repository provides basic Android Development Utility.

### Get Application Context

Override Application class and define **static** context variable and **getContext()** function.

### Log Util Tool

Debug / Release, change the **level** variable in **LogUtil.java** before release, all log info will be hidden.

### Passing Object Value by Intent

Implement Serializable / Parcelable. Recommend: Parcelable, becasue Serializable will serialize all object, so it has low producticity. Code in **model folder** and **activity files**.
