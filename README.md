# java_spring_todo

Based on https://www.baeldung.com/spring-boot-react-crud 


# Running

Run with Maven:
```
mvn spring-boot:run
```

Add a ToDo via Curl:

```
curl -X POST http://localhost:8080/notes -H 'Content-Type: application/json' -d '{"title":"L
earn Spring", "content":"Follow some tutorials"}'
```

Access at: http://localhost:8080/notes 

