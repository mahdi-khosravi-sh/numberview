# NumberView
Android NumberView Widget

A beautiful widget for displaying numbers with animation

[![](https://jitpack.io/v/mahdidev78/scrolltotop.svg)](https://jitpack.io/#mahdidev78/scrolltotop)
![GitHub repo size](https://img.shields.io/github/repo-size/mahdidev78/scrolltotop)
![GitHub language count](https://img.shields.io/github/languages/count/mahdidev78/scrolltotop)
![GitHub top language](https://img.shields.io/github/languages/top/mahdidev78/scrolltotop)
![GitHub last commit](https://img.shields.io/github/last-commit/mahdidev78/scrolltotop?color=red)

<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#download">Download</a></li>
        <li><a href="#usage">Usage</a></li>
      </ul>
    </li>
    <li><a href="#stats">Stats</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>

<!-- GETTING STARTED -->
## Getting Started

### Download

Download the latest AAR from jitpack via Gradle:

<ul>
  <li>
Gradle

Project build.gradle
  
```gradle
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```
app module build.gradle

```gradle
dependencies {
  implementation 'com.github.mahdidev78:scrolltotop:2.1.9'
}
```
    
  </li>
  <li>
Maven
    
Add the JitPack repository to your build file
    
```xml
<repositories>
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
</repositories>
```
Add the dependency
```xml
<dependency>
  <groupId>com.github.mahdidev78</groupId>
  <artifactId>scrolltotop</artifactId>
  <version>Tag</version>
</dependency>
```
  </li>
</ul>

<!-- USAGE EXAMPLES -->
## Usage

### Step 1

Add the NumberView to your layout :

```xml
<com.mahdikh.vision.numberview.widget.NumberView
  android:id="@+id/numberView"
  android:layout_width="wrap_content"
  android:layout_height="wrap_content"
  android:textColor="#000000"
  android:textSize="45sp"
  app:animator="@string/SlideAnimator"
  app:duration="300"
  app:interpolator="@android:interpolator/overshoot"
  app:number="10" />
```
### Step 2

Setup your code : 
<ul>
  <li>
    Kotlin
    
```kotlin
val scrollToTop:ScrollToTop = findViewById(R.id.scrollToTop)
scrollToTop.setupWithRecyclerView(recyclerView)    
```
  </li>
  <li>
    Java
    
```java
ScrollToTop scrollToTop = findViewById(R.id.scrollToTop);
scrollToTop.setupWithRecyclerView(recyclerView);
```
  </li>
</ul>

### Advanced Step 3

<ul>
  <li>
  kotlin

```kotlin
scrollToTop.animator = ScaleAnimator().apply {
  duration = 250
  fromScale = 0.8F
  maxAlpha = 0.8F
  interpolator = FastOutSlowInInterpolator()
}
```
  </li>
  <li>
  Java

```java
ScaleAnimator animator = new ScaleAnimator();    
animator.setDuration(250);
animator.setFromScale(0.8F);
animator.setMaxAlpha(0.8F);
animator.setInterpolator(new FastOutSlowInInterpolator());
scrollToTop.setAnimator(animator);
```
  </li>
</ul>

#### Animators

`DefaultAnimator`, `FadeAnimator`, `ScaleAnimator`, `SlideAnimator`, `FlipAnimator`

## Attributes

| attribute | Description | Options(examples)|
| --- | --- | --- |
| number |  | 20,486, ... |
| animator |  | FadeAnimator,ScaleAnimator, etc |
| duration |  | 500, 600, etc |
| interpolator |  | @android:interpolator/overshoot |

<!-- _For more examples, please refer to the [Documentation](https://example.com)_ -->

## Stats

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![Apache License][license-shield]][license-url]

<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<!-- LICENSE -->
## License

Distributed under the Apache2.0 License. See `LICENSE` for more information.

<!-- CONTACT -->
## Contact

Mahdi Khosravi - mahdi.khosravi.dev78@gmail.com

Project Link: [https://github.com/mahdidev78/scrolltotop](https://github.com/mahdidev78/scrolltotop)


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/mahdidev78/ScrollToTop.svg?
[contributors-url]: https://github.com/mahdidev78/scrolltotop/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/mahdidev78/ScrollToTop.svg?
[forks-url]: https://github.com/mahdidev78/scrolltotop/network/members
[stars-shield]: https://img.shields.io/github/stars/mahdidev78/ScrollToTop.svg?
[stars-url]: https://github.com/mahdidev78/scrolltotop/stargazers
[issues-shield]: https://img.shields.io/github/issues/mahdidev78/ScrollToTop.svg?
[issues-url]: https://github.com/mahdidev78/scrolltotop/issues
[license-shield]: https://img.shields.io/github/license/mahdidev78/ScrollToTop.svg?
[license-url]: https://github.com/mahdidev78/scrolltotop/blob/master/LICENSE.txt
[product-screenshot]: images/screenshot.png
