
# Dust Chat

<p>
  <img align="left" src="https://user-images.githubusercontent.com/81843550/215218942-ebc72b3f-0e8b-48bd-a06d-84847243155c.png" />
  Simple Chat Utilities for Spigot plugins that make it easy to create colored chat messages.

  ## All Avaliable Word Colors
  For a list of all avaliable word colors, see spigot's documentation on [Chat Colors](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/ChatColor.html)
  ```
  <word:red>This is my red text!
  ```

  ## Gradients
  Gradients are a special type of color that allows you to create a gradient between two colors. The format is as follows:
  ```
  <gradient:color1:color2>Text</gradient>
  ```
  color1 and color2 are the colors that the gradient will go between. The text will be colored with the gradient between the two colors.
  
  only hex colors are supported for gradients. The format for hex inside of a gradient tag should be without the #. For example:
  ```
  <gradient:333000:000333>Text</gradient>
  ```

  ## Hex Colors
  Hex colors are a special type of color that allows you to use basically any color you want. The format is as follows:
  ```
  <color:color1>
  ```
  color1 is the hex color that you want to use. The format for hex inside of a color tag should be without the #. For example:
  ```
  <color:333000>
  ```

  ## Mods
  Mods are a special type of color that allows you to modify the text in some way. The format is as follows:
  ```
  <mod:mod1>Text</mod>
  ```
  mod1 is the mod that you want to use. The following mods are supported:
  - bold
  - italic
  - underlined
  - strikethrough
  - obfuscated
  - reset

  # Code examples

  ```java
  player.sendMessage(DustChat.color("<red>This is my red text!"));
  ```
  ```java
  player.sendMessage(DustChat.color("<gradient:333000:000333>This is my gradient text!"));
  ```
  ```java
  player.sendMessage(DustChat.color("<color:333000>This is my hex text!"));
  ```
  ```java
  player.sendMessage(DustChat.color("<mod:bold>This is my bold text!"));
  ```

  # Depending on Dust Chat
  ## Maven
  ```xml
    <repository>
      <id>miles-repos-releases</id>
      <url>https://maven.miles.sh/snapshots</url>
    </repository>

    <dependency>
      <groupId>sh.miles.dustchat</groupId>
      <artifactId>dustchat</artifactId>
      <version>1.0-SNAPSHOT</version>
    </dependency>
 ```

 ### Shading
 ```xml
       <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-shade-plugin</artifactId>
        <version>3.4.1</version>
        <executions>
          <execution>
            <phase>package</phase>
            <goals>
              <goal>shade</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
```

## Gradle
```groovy
repositories {
    maven {
        url 'https://maven.miles.sh/snapshots'
    }
}

dependencies {
    implementation 'sh.miles.dustchat:dustchat:1.0-SNAPSHOT'
}
```

### Shading
```groovy
plugins {
    id 'com.github.johnrengelman.shadow' version '7.0.0'
}
```


</p>



