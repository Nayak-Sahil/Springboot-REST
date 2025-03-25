## How to enable automatic restart springboot application?

- Go to `build.gradle` file
- Add following dependency in `dependencies { }`

```groovy
developmentOnly 'org.springframework.boot:spring-boot-devtools'
```

- Open settings, Search for "Compiler"
  - Enable "Build project automatically"
- Then, Search for "Advanced" settings
  - Enable "Allow auto-make to start even if developed application is currently running"
- Done, You good to go with it, Restart SpringBoot Application.

You should see restart after some delay when you change something in any file.