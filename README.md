When a package name is escaped, IDEA code completion does not work as expected.

> [!NOTE]
> 
> This might seem like a corner issue, but as more and more domains are allocated, it is quite
> hard to find good names for open-source projects. I had to choose `adaptive.fun` for my project
> which implies that the package names start with `fun.adaptive`. Otherwise, I cannot upload to 
> Maven Central and to Gradle plugin portal.
> 

[Test.kt](/declaration/src/commonMain/kotlin/hello world/a/b/Test.kt):

```kotlin
package `hello world`.a.b

class SomeClass()
```

To reproduce (see video):

1. open [main.kt](/use/src/jvmMain/kotlin/main.kt)
2. position caret at `<caret>`
3. type `some`
4. hit Enter

```kotlin
fun main(<caret>) {
}
```

- the result is syntactically incorrect
- I would expect the short class name and an import

```kotlin
fun main(someClass: hello world.a.b.SomeClass) {
}
```

![Screen Recording 2024-08-23 at 11.44.17.mov](Screen%20Recording%202024-08-23%20at%2011.44.17.mov)

> [!NOTE]
> 
> Seems like this happens only when package name has to be escaped. For example,
> a simple `hello` does not produce this issue, even if escaped.
>

```text
IntelliJ IDEA 2024.2.1 RC (Ultimate Edition)
Build #IU-242.21829.40, built on August 18, 2024
Runtime version: 21.0.3+13-b509.11 aarch64 (JCEF 122.1.9)
VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.
Toolkit: sun.lwawt.macosx.LWCToolkit
macOS 14.6.1
Kotlin plugin: K2 mode (Beta)
GC: G1 Young Generation, G1 Concurrent GC, G1 Old Generation
Memory: 3072M
Cores: 8
Metal Rendering is ON
Registry:
  ide.experimental.ui=true
  i18n.locale=
  ide.images.show.chessboard=true
  kotlin.k2.only.bundled.compiler.plugins.enabled=false
Non-Bundled Plugins:
  com.intellij.ml.llm (242.21829.40)
  PlantUML integration (7.10.1-IJ2023.2)
  com.intellij.exposed (242.21829.3)
Kotlin: 242.21829.40-IJ
```