# Run the example
In order to run the example, execute `./gradlew build`

You should see the following test failure:
```
> Task :test FAILED

ImportTest > importBreaks() FAILED
    org.codehaus.groovy.control.MultipleCompilationErrorsException at ImportTest.java:16

```

See https://issues.apache.org/jira/browse/GROOVY-9407 for more information and also a possible workaround.
