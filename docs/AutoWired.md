## Autowired: Field Injection
```java
@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    // No need to write assignment code
}
```

## Autowired: Constructor Injection
```java
@Component
public class UserService {
    private final UserRepository userRepository;
    
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository; // Explicit assignment required
    }

    // You might wonder why `@Autowired` is still needed with constructor injection. 
    // It is required when you have multiple constructors. 
    // Without `@Autowired`, Spring wouldn't know which constructor to use for dependency injection.
    
    public UserService(){}
    
    public UserService(int number, UserRepository userRepository){}
    
    // Try each case by commenting @Autowired and any of constructor.
    
    // Conclusion: @Autowired is required when Spring needs to know where to inject dependencies.
}
```

## The reasons constructor injection is often preferred:
- `Immutability`: Only on objection creation, Dependency injected and assigned.
  - Although You can make fields final which prevents them from being changed after initialization
- `Testability`: Easier to provide mock dependency
- Required dependencies: Constructor injection **makes it clear which dependencies are mandatory** (they're constructor parameters)

## Remember
- @Autowired is required **when Spring needs to know where to inject dependencies**.
- Where there might be possible of multiple thing, Example:
  - **In multiple field**:  @Autowired specifies in which variable inject dependency given by spring.
  - **In multiple constructor**: @Autowired tells Spring which constructor should be used for dependency injection.
  - **In multiple setter injection function**: @Autowired helps Spring determine which setter should be used to inject the dependency.