## Model Mapper
Service always receive DTO type data and now to give these data to repository we need to convert this DTO type into Entity because Repository only receive Entity type data and store it into database.

This project use: https://modelmapper.org/

## Steps to use:
1. Add dependencies `implementation 'org.modelmapper:modelmapper:3.0.0'` in `build.gradle`
2. Create bean in `/configuration/AppConfig.java` so that it available in all services files.
3. Use constructor injection in service files and add it.
4. Use mapper as following
```java
// To convert data of Entity type into DTO
mapper.map(dataEntity, KeyResultsDTO.class);

// To convert data of DTO type into Enity
mapper.map(dataDTO, KeyResultsEntity.class);
```