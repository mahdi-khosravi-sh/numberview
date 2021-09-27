# NumberView

![Peek 2021-09-27 19-44](https://user-images.githubusercontent.com/88603424/134947044-05d3301c-7bd1-4bcf-91aa-47bdd26f4c98.gif)

#

[![](https://jitpack.io/v/mahdidev78/numberview.svg)](https://jitpack.io/#mahdidev78/numberview)
![GitHub repo size](https://img.shields.io/github/repo-size/mahdidev78/numberview)
![GitHub language count](https://img.shields.io/github/languages/count/mahdidev78/numberview)
![GitHub top language](https://img.shields.io/github/languages/top/mahdidev78/numberview)
![GitHub last commit](https://img.shields.io/github/last-commit/mahdidev78/numberview?color=red)

A beautiful widget for displaying numbers with animation

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
  implementation 'com.github.mahdidev78:numberview:TAG'
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
  <artifactId>numberview</artifactId>
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
  app:animator="@string/DefaultAnimator"
  app:duration="300"
  app:interpolator="@android:interpolator/accelerate_decelerate"
  app:number="10" />
```
### Step 2

Setup your code : 
<ul>
  <li>
    Kotlin
    
```kotlin
val numberView:NumberView = findViewById(R.id.numberView)
numberView.setOnClickListener {
  numberView.increment()
}
```
  </li>
  <li>
    Java
    
```java
NumberView numberView = findViewById(R.id.numberView);
numberView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        numberView.increment();
    }
});
```
  </li>
</ul>

### Advanced Step 3

<ul>
  <li>
  kotlin

```kotlin
numberView.animator = SlideAnimator().apply {
    setDuration(450)
    setInterpolator(FastOutSlowInInterpolator())
    gravity = Gravity.END
}
```
  </li>
  <li>
  Java

```java
SlideAnimator animator = new SlideAnimator(Gravity.END);
animator.setDuration(450);
animator.setInterpolator(new FastOutSlowInInterpolator());
numberView.setAnimator(animator);
```
  </li>
</ul>

#### Animators

`DefaultAnimator`, `SlideAnimator`, `FadeAnimator`, `ScaleAnimator`, `RotationAnimator` , `FlipAnimator`

## Attributes

| attribute | Description | Options(examples)|
| --- | --- | --- |
| number | The desired number to set as text  | 20,486, ... |
| animator | animator class name | FadeAnimator,ScaleAnimator, etc |
| duration | animator duration | 500, 600, etc |
| interpolator | animator interpolator | @android:interpolator/overshoot |

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

Project Link: [https://github.com/mahdidev78/numberview](https://github.com/mahdidev78/numberview)

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/mahdidev78/NumberView.svg?
[contributors-url]: https://github.com/mahdidev78/numberview/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/mahdidev78/NumberView.svg?
[forks-url]: https://github.com/mahdidev78/numberview/network/members
[stars-shield]: https://img.shields.io/github/stars/mahdidev78/NumberView.svg?
[stars-url]: https://github.com/mahdidev78/numberview/stargazers
[issues-shield]: https://img.shields.io/github/issues/mahdidev78/NumberView.svg?
[issues-url]: https://github.com/mahdidev78/numberview/issues
[license-shield]: https://img.shields.io/github/license/mahdidev78/NumberView.svg?
[license-url]: https://github.com/mahdidev78/numberview/blob/master/LICENSE.txt
[product-screenshot]: images/screenshot.png
