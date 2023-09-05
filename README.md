# Final Project 

A final project contains:
- Web Testing
- Api Testing

This project use [Demo Blaze](https://www.demoblaze.com/) as a sample for Web Testing
And use [Dummy API](https://dummyapi.io) as a sample for API testing


## 1. Configuration (build.gradle)

Please follow this Configuration. This all are dependencies and setup that used for this project

Dependencies and Configuration file is on ```build.gradle```

**Dependencies**
```java
dependencies {
    implementation group: 'org.seleniumhq.selenium', name: 'selenium-java', version: '4.11.0'
    testImplementation('io.github.bonigarcia:webdrivermanager:5.3.2')
    implementation group: 'io.cucumber', name: 'cucumber-java', version: '7.12.1'
    testImplementation group: 'io.cucumber', name: 'cucumber-junit', version: '7.12.1'

    testImplementation platform('org.junit:junit-bom:5.9.2')
    testImplementation 'org.junit.jupiter:junit-jupiter:5.9.2'

    implementation group: 'io.rest-assured', name: 'json-schema-validator', version: '5.3.0'
    implementation group: 'org.json', name: 'json', version: '20230227'
    testImplementation group: 'io.rest-assured', name: 'rest-assured', version: '5.3.0'
    testImplementation group: 'org.testng', name: 'testng', version: '7.7.1'


}
```
**configurations**  
```java
configurations {
    cucumberRuntime{
        extendsFrom testImplementation
    }
}
```
**Cucumber Setup**  
```java
def tags =(findProperty('tags')==null)?'not @exluce' : findProperty('tags')+' and not @exclude'

task cucumber() {
    description("Running Cucumber Test")
    dependsOn assemble, compileTestJava
    doLast {
        javaexec {
            main = "io.cucumber.core.cli.Main"
            classpath = configurations.cucumberRuntime + sourceSets.main.output + sourceSets.test.output
            args = [
                    '--plugin', 'html:reports/index.html',
                    '--plugin', 'json:reports/report-api.html',
                    '--plugin', 'pretty',
                    '--glue', 'com.stepdefinition',
                    '--tags', "${tags}",
                    'src/test/resources/feature'
            ]
        }
    }
}
```

**Note:**
- If you want to change the version of dependencies there might be some error/failed to run this project
## 2. Test Cases
There are 3 Features for API and 4 Features for WEB. These scenario just a sample for testing purposes. in real cases should be different. Scenario quite straight forward with Gherkin language
### API
**User**
- get list user by default
- get list user by page
- get user list limited
- get a specific user information
- create a new user
- update user information

**Comment**
- get list comment by default
- get list comment by post id
- get list comment by user id
- create comment

**Post**
- get list post by default
- get list post by tag
- get all post by Specific User
- get single post information
- create post
- update post

Gherkin file is located in ```src/test/resources/feature/Api```

**example**: 
- get list user by default
```Gherkin
    Scenario: get list user by default
      Given I set service api
      When I set Header method GET using Endpoint "/user"
      Then I received a valid HTTP response code 200
      And I received a valid page index 0
      And I received a valid limit 20 user
      And I received a valid "user/getListUserByDefault.json"
```

### WEB

**Login**
- user login with invalid username
- user login with invalid password
- user not input username or password
- user logout successfully
- user login successfully login with valid credential

**Signup**
- user signup empty username and password
- user signup with existed credentials
- user signup with existed credentials
- user signup successfully

**Home**
- user can see items products at home
- user can see products details

**Cart**
- user can add multiple item to cart
- user successfully delete item from cart
- user not input name or credit card in place order
- user successfully place order items

Gherkin file is located in ```src/test/resources/feature/Web```

**example**: 
- user login successfully login with valid credential
```Gherkin
   @positive
    Scenario: user login successfully login with valid credential
      Given user is on home page
      And user click login button from navbar
      And user input login username "deta_mainuser"
      And user input login password "deta_mainuser"
      When user click login button
      Then user see profile name "Welcome deta_mainuser"
```

## 3.Running

You can run this project using some method: 

**Using terminal**

- Quick run all 

``` bash 
./gradlew cucumber

```

- Run with Tags 

``` bash 
./gradlew cucumber -Ptags="@positive"

```

``` bash 
Tag Option :
"@positive"
"@negative"
"@web"
"@api"
"@web"
"@api-comment"
"@api-post"
"@api-user"
"@web-cart"
"@web-home"
"@web-login"
"@web-signup"
```
![gradlew_cucumber_with_tag](https://raw.githubusercontent.com/detagian/final-project-jayjay/main/run%20cucumber.png)

## 4.Report

Report is generated in ```reports``` folder location for local report

Setup report is inside the ```build.gradle``` file

```java
task cucumber() {
    description("Running Cucumber Test")
    dependsOn assemble, compileTestJava
    doLast {
        javaexec {
            main = "io.cucumber.core.cli.Main"
            classpath = configurations.cucumberRuntime + sourceSets.main.output + sourceSets.test.output
            args = [
                    '--plugin', 'html:reports/index.html',
                    '--plugin', 'json:reports/report-api.html',
                    '--plugin', 'pretty',
                    '--glue', 'com.stepdefinition',
                    '--tags', "${tags}",
                    'src/test/resources/feature'
            ]
        }
    }
}
```
![Reports](https://raw.githubusercontent.com/detagian/final-project-jayjay/main/reports%20html.png)

