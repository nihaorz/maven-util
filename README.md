# maven工具包
## 概述
本工具包提供一系列的maven操作，后面根据需求将持续集成
## 依赖声明

- 声明`repositories`

  ```xml
  <repositories>
      <repository>
          <id>github-maven-repo</id>
          <url>https://raw.githubusercontent.com/nihaorz/maven-repo/master/repository</url>
      </repository>
  </repositories>
  ```

- 声明`dependency`

  ```xml
  <dependency>
      <groupId>com.github.nihaorz</groupId>
      <artifactId>nihaorz-maven-util</artifactId>
      <version>1.0.0-SNAPSHOT</version>
  </dependency>
  ```

## 功能点

| java类                                    | 功能点                          |
| ---------------------------------------- | ---------------------------- |
| `com.github.nihaorz.maven.util.MavenVersionUpdateUtils` | 实现`pom.xml`文件中`version`的自动更新 |

