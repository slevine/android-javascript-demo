# Android and Javascript

This is a simple Scala Android application that demonstrates how Javascript within an Android WebView can call native Android code.  It also shows how Android can polyfill core browser features such as intercepting console messagse.

In the future I will add additional examples of how Android can interact with local Javascript.

### Required Libraries

* SBT (Scala Build Tool) - https://github.com/harrah/xsbt/wiki
* Android SDK - http://developer.android.com/sdk/index.html

### How to Build

Set Required env variable

`export ANDROID_HOME=path_to_android-sdk-mac_86`

Enter the SBT console

`# sbt`

If you device is connected via USB

`# android:install-device`

To use Emulator

`# android:emulator-start <my_avd>   (use <tab> to get a list of avds)`

`# android:start-emulator`

Let me know if you have any questions.  
  

