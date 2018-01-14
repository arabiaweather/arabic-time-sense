# AWTimeSense

 ![alt text](https://github.com/arabiaweather/arabic-time-sense/blob/master/topbanner.png)

Android / Java Library to display time ago in both Arabic and English, if you pass a date older than 2 days, a date will be returned

[![license](https://img.shields.io/github/license/mashape/apistatus.svg)]()
<a href="http://www.methodscount.com/?lib=com.github.arabiaweather%3Aarabic-time-sense%3A1.0"><img src="https://img.shields.io/badge/Methods and size-17 | 5 KB-e91e63.svg"/></a>
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/90251ffcc45149b6af5aea08f46118e2)](https://www.codacy.com/app/AhmedDroid/arabic-time-sense?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=arabiaweather/arabic-time-sense/&amp;utm_campaign=Badge_Grade)
<a href="http://www.methodscount.com/?lib=com.github.arabiaweather%3Aarabic-time-sense%3A1.0"><img src="https://img.shields.io/badge/Min%20SDK-16-blue.svg"/></a>

# How to use:

Step 1:
Add the JitPack repository to your build file

```groovy
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
  ```
  
Step 2:
Add the dependency
  
  ```groovy
 dependencies {
	   implementation 'com.github.arabiaweather:arabic-time-sense:1.0.1'
	}
  ```
 
 That's it, you've included the library, now moving onto coding:
 
 ```java
 // pass on the context, the time to be evaluated agains the current time, a separator to separate date units
 AWTimeSense.getTimeAgo(getApplicationContext(), 30 * 1000, "/");
```

# License

```
Copyright (c) 2018 ArabiaWeather Inc. All rights reserved

        Permission is hereby granted, free of charge, to any person obtaining a copy
        of this software and associated documentation files (the "Software"), to deal
        in the Software without restriction, including without limitation the rights
        to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
        copies of the Software, and to permit persons to whom the Software is
        furnished to do so, subject to the following conditions:

        The above copyright notice and this permission notice shall be included in all
        copies or substantial portions of the Software.

        THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
        IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
        FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
        AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
        LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
        OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
        SOFTWARE.
```



