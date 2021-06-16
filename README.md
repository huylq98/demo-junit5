# Junit 5 and check code coverage when run unit test
_The legend continues.._
- Junit 4 vs Junit 5  
- Coverage  
Please see part one at: 
https://github.com/atulaa1/demo-junit-mockito  
## I. Junit 5  
### 1. Change GroupId of dependency  
    
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter</artifactId>
      <version>5.4.0</version>
      <scope>test</scope>
    </dependency>
    
### 2. Change annotation for setup, tearDown method  
JUnit 4's **@Before**, **@BeforeClass**, **@After**, and **@AfterClass** annotations have been replaced by **@BeforeEach**, **@BeforeAll**, **@AfterEach**, and **@AfterAll**, respectively.  
**Example**: _JunitLifeCycle.java_  
### 3. JUnit 4's @Ignore annotation has been replaced by the @Disabled annotation  
**Example**: _JunitLifeCycle.java_  
### 4. The Assertions class and its methods  
**Example**: _AssertionsDemo.java_  
### 5. RepeatedTest  
**Example**: _JunitLifeCycle.java_  
### 6. Config dependency for run junit 5 from maven project  
**Note:** 
- it need to config _maven-surefire-plugin_ to run Junit5 from maven project with old junit 5 version  
- This example require maven version >= 3.6.0  
### 7. Test suites  
Junit 5 allow select test classes in some packages or specify classes.  
**Note**: Need add dependency for _junit-platform-runner_  
    
        <dependency>
          <groupId>org.junit.platform</groupId>
          <artifactId>junit-platform-runner</artifactId>
          <version>1.4.0</version>
          <scope>test</scope>
        </dependency>
        
**Example**: _LoginSuccessAndWelcomeTest.java_  
### 8. Run same test case on a data set  
#### 8.1 Using Dynamic Test  
**Example**: _DynamicTestDemoTest.java_  
#### 8.2 Using Parameterized Tests and data source
**Example**: _ParameterizedTestDemoTest.java_
### 9. Assumptions  
**Example**: _AssumptionDemoTest.java_
## II. Code Coverage  
- Use Jacoco plugin. Include dependency in pom file:  
    
        <plugin>
                <groupId>org.jacoco</groupId>
                <artifactId>jacoco-maven-plugin</artifactId>
                <version>0.8.2</version>
                <executions>
                  <execution>
                    <goals>
                      <goal>prepare-agent</goal>
                    </goals>
                  </execution>
                  <!-- attached to Maven test phase -->
                  <execution>
                    <id>report</id>
                    <phase>test</phase>
                    <goals>
                      <goal>report</goal>
                    </goals>
                  </execution>
                </executions>
              </plugin>
     
- after load dependency try to run below command  
      
        mvn clean test   
    
The report only generate at _target/site/jacoco/*_  if all test case was passed  
## III. Mockito
### 1. Config dependencies for Mockito
- `mockito-inline` is Java 16 ready version of mockito-core. It also supports mocking of static methods and final classes
- `mockito-junit-jupiter` for MockitoExtension
  
      <dependency>
        <groupId>org.mockito</groupId>
          <artifactId>mockito-inline</artifactId>
          <version>3.9.0</version>
          <scope>test</scope>
      </dependency>
      <dependency>
          <groupId>org.mockito</groupId>
          <artifactId>mockito-junit-jupiter</artifactId>
          <version>3.9.0</version>
          <scope>test</scope>
      </dependency>
### 2. Declare and config mock object
**Example**: _CarServiceMockDemo.java_
- Difference between mock and spy

**Example**: _MockSpyDemo_.java
### 3. Stub method
####3.1 Stub returned value
####3.2 Stub throw exception
**Note**: If the throwable class is a checked exception then it has to match one of the checked exceptions of the stubbed method signature.
####3.3 Stub multiple returned value
####3.4 Stub void method
####3.5 ArgumentMatchers
**Example**: _StubMethodDemo.java_
### 4. Verify
- Mockito.times(invocationTimes) vs Mockito.calls(invocationTimes)

**Example**: _VerifyDemo.java_
### 5. Answer
**Example**: _AnswerDemo.java_
## IV. References  
https://www.baeldung.com/junit-5  
https://www.infoworld.com/article/3537563/junit-5-tutorial-part-1-unit-testing-with-junit-5-mockito-and-hamcrest.html?nsdr=true    
https://howtodoinjava.com/junit-5-tutorial/  
https://www.vogella.com/tutorials/JUnit/article.html#junit5  
https://examples.javacodegeeks.com/core-java/junit/junit-code-coverage/    
https://mkyong.com/maven/maven-jacoco-code-coverage-example/
https://site.mockito.org/javadoc/current/allclasses-noframe.html
