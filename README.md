# ButtonLink Add-on for Vaadin 7.3

ButtonLink is basically a Link component that looks like a Button

## Demo

[http://maxschuster.eu:8080/ButtonLink/#!demo-valo](http://maxschuster.eu:8080/ButtonLink/#!demo-valo)

## Maven

```xml
<repositories>
    <repository>
        <id>buttonlink-mvn-repo</id>
        <url>https://raw.github.com/maxschuster/vaadin-buttonlink/mvn-repo/</url>
        <snapshots>
            <enabled>true</enabled>
            <updatePolicy>always</updatePolicy>
        </snapshots>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>eu.maxschuster.vaadin</groupId>
        <artifactId>buttonlink</artifactId>
        <version>1.0.0</version>
    </dependency>
<dependencies>
```

## Ivy
### ivysettings.xml
```xml
<resolvers>
    <ibiblio name="maxschuster-buttonlink" usepoms="true" m2compatible="true"
            root="https://raw.github.com/maxschuster/vaadin-buttonlink/mvn-repo/" />
</resolvers>
```
### ivy.xml
```xml
<dependency org="eu.maxschuster.vaadin" name="buttonlink" rev="1.0.0" />
```