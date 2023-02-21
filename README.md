
# **Eris Command Library**

<p>
  <img align="left" src="https://user-images.githubusercontent.com/81843550/220237605-2440cab5-c3b7-4971-bfdc-13875d3a3362.png" width=300/>
  
  ErisCL is a command library for Spigot and Paper API. It is designed to be easy to use and to be lightweight and simplistic. It is also designed with beginners in mind, so it is easy to learn and formed in a way that is easy to understand and hard to abuse.

</p>
<p>
Note: the library is still in development and features may be added or removed
</p>

## **Features**

- Command registration
- Subcommands
- CommandBuilder
- LabelBuilder

## **Creating your first command**
===
### **Labels**
---
Before we can start making our commands we need to undesrtand labels and how to make them.

When a player executes a command the server needs to know what command to execute. for this reason labels are used. They point to a command and tell the server what command to execute and also provide other information such as aliases and descriptions.

Below I will demonstrate the two ways to make Labels. The first via the ErisLabelBuilder and the second via the ErisLabel class.

**Eris Label Builder**
  
The ErisLabelBuilder can be accessed via the ErisCL class or by accessing the static instance of the ErisLabelBuilder class. in this example I will be using the former.
```java
ErisLabel label = ErisCL.label("test", "test.admin")
    .description("This is a test command")
    .alias("test1")
    .alias("test2")
    .usage("/test <arg1>")
    .build().make();
```

**Eris Label Instance**
```java
ErisLabel label = new ErisLabel("test", "test.admin");
label.setDescription("This is a test command");
label.setUsage("/test <arg1>");
label.addAlias("test1");
label.addAlias("test2");
```

Now that we have our label we can start making our command.

---

### **Making a Command**
With ErisCL there are two ways to make a command. The first is to use the CommandBuilder class which provides a functional approach to commands. The second is to extend the ErisCommand class which provides a more object oriented approach to commands. Both methods will be demonstrated below.

**Making a Command with the CommandBuilder**

As with the label builder the ErisCommandBuilder can be accessed via the ErisCL class or by accessing the static instance of the ErisCommandBuilder class. in this example I will be using the former as well.

```java
ErisCommmand command = ErisCL.command(label)
    .nativeExecutor((sender, args) -> {
        sender.sendMessage("Hello World!");
    })
    .build().make();
```

**Making a Command by extending the ErisCommand class**

```java
public class TestCommand extends ErisCommand {

    public TestCommand(ErisLabel label) {
        super(label);
        setNativeExecutor((sender, args) -> {
            sender.sendMessage("Hello World!");
        });
    }
}
```

### **Registering a Command**

Registering a command is very simple and can be done inside of the ErisCL class aditionally you can register a command by using the ErisBukkitBridge class, but this is not recommended.

**ErisCL Method**
```java
ErisCL.registerCommand(command);
```

**ErisBukkitBridge Method**
```java
ErisBukkitBridge.register(new ErisBukkitBridge(command));
```

---

### **Instalation**

**Maven**
```xml
<repositories>
  <repository>
    <id>miles-repos-snapshots</id>
    <name>Miles Repositories</name>
    <url>https://maven.miles.sh/snapshots</url>
  </repository>
</repositories>

<dependencies>
  <dependency>
    <groupId>sh.miles.eriscl</groupId>
    <artifactId>eriscl</artifactId>
    <version>1.0-SNAPSHOT</version>
  </dependency>
</dependencies>
```


**Gradle Groovy**
```gradle
repositories {
  maven {
    url 'https://maven.miles.sh/snapshots'
  }
}

dependencies {
  implementation "sh.miles.eriscl:eriscl:1.0-SNAPSHOT"
}
```
