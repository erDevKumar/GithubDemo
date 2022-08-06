 plugins{
     `kotlin-dsl`
 }

 repositories {
     gradlePluginPortal()
     mavenCentral()
     google()
 }

 dependencies{
     implementation( "com.android.tools.build:gradle:7.1.2")
     implementation( "org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
     implementation( "com.google.dagger:hilt-android-gradle-plugin:2.40.5")
     implementation(kotlin("gradle-plugin", version = "1.6.21"))
 }