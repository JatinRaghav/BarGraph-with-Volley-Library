Volley is a networking library for Android that manages network requests. It bundles the most important features you’ll need, such as accessing JSON APIs, loading images and String requests in an easier-to-use package.
Here I have make a android app with using volley library for fetching data from server and show in the Bar Graph


Gradle :-

repositories {
    maven { url "https://jitpack.io" }
}

dependencies {
    //...

    compile 'com.android.volley:volley:1.0.0'
    compile 'com.github.PhilJay:MPAndroidChart:v2.2.4'

}

AndroidManifest.xml :-
<uses-permission android:name="android.permission.INTERNET" />

