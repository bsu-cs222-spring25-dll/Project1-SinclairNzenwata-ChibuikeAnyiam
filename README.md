# Wikipedia Revision History Fetcher 

## Project Summary  
This project retrieves and displays Wikipedia article revision history using Java.  
It fetches revision data via the Wikipedia API, processes it using JSONPath,  
and formats it for display while handling missing pages and redirections. 
It fetches the most recent revisions, including the timestamp and the user who made the edit.

## Authors  
- **Chibuike Anyiam**  
- **Sinclair Nzenwata**  

## Technologies Used  
- **Java 11+** (Main Programming Language)  
- **Gradle** (Build System)  
- **JSONPath** (For JSON Parsing)  
- **JUnit 5** (For Testing)  
- **HttpClient** (For API Calls)  

## API Details

This project utilizes the Wikipedia API to fetch the latest revisions of a given article.

### **API Endpoint:**

```
https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=<ARTICLE_NAME>&rvprop=timestamp|user&rvlimit=20&redirects
```

### **Parameters:**

- `<ARTICLE_NAME>` – The title of the Wikipedia article to fetch revisions for.
- `rvprop=timestamp|user` – Returns both the timestamp and user of each revision.
- `rvlimit=20` – Limits the result to 20 revisions.
- `redirects` – Automatically follows redirects.

## Expected Output

### **Example 1: Normal Article Revisions**

```
*************** Welcome to Wiki search ***************
Put in the article's name: Iran
1  2025-02-10T15:09:35Z  QwertyZ34
2  2025-02-09T08:45:38Z  WikiCleanerBot
3  2025-02-06T06:59:11Z  Worldbruce
```

### **Example 2: Redirected Article**

```
*************** Welcome to Wiki search ***************
Put in the article's name: General
Redirected to General officer
1  22025-02-10T19:59:15Z Gaismagorm
2  2025-02-10T19:57:39Z 184.105.252.226
```

### **Example 3: Missing Article**

```
*************** Welcome to Wiki search ***************
Put in the article's name: SomeFakePage
Error: No Wikipedia page found.
```
---

## Build Instructions

### **Prerequisites:**

- Java 11 or higher
- Gradle (for build system)

### Steps to Build and Run  

1. **Clone the Repository**  
   ```sh
   git clone https://github.com/bsu-cs222-spring25-dll/Project1-SinclairNzenwata-ChibuikeAnyiam.git
2. Open up the project on an IDE like IntelliJ IDEA Community Edition
3. Navigate to the WikipediaFetcher class and then run the project from that class.

---

## Testing
### Run Unit Tests
To execute JUnit tests: go inside IntelliJ, go to the test folder → Right-click on the which test class you want to run → and then click on Run (class name)Test.

---

## Errors
### Error Handling
| Scenario                  | Message                                 |
|---------------------------|-----------------------------------------|
| No Internet Connection     | Error: Failed to retrieve revisions. Try turning on your wifi or mobile data. |
| Invalid Wikipedia Page     | Error: Page does not exist              |
| API Error (HTTP 500, 404, etc.) | Error: Wikipedia API returned HTTP status 500 |
| Empty Input    | Error: No article name provided.  |

### Suppressed Errors
This project uses java.net.http.HttpClient and SLF4J is used by default for logging. To avoid unwanted logging errors related to missing SLF4J bindings, we use the slf4j-nop (No Operation) implementation by adding the code below to our **build.gradle.kts** file
```sh
implementation("org.slf4j:slf4j-nop:2.0.9")
```

---

## Resources Used  
- [Stack Overflow - Terminating a Java Program](https://stackoverflow.com/questions/22452930/terminating-a-java-program)  
- [W3Schools - Java Error Handling](https://www.w3schools.com/java/java_ref_errors.asp)  
- [Maven Repository - JSONPath](https://mvnrepository.com/artifact/com.jayway.jsonpath/json-path/2.9.0)  
- [RapidAPI - Making API Calls in Java](https://rapidapi.com/guides/make-api-call-java)  
- [Goessner - JSONPath](https://goessner.net/)  
- [Oracle Docs - Java HttpClient](https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpClient.html)  
- [SLF4J Logging Documentation](https://www.slf4j.org/codes.html#noProviders)  
- [JSONPath Testing Tool](https://jsonpath.com/)  
- [JSONPath GitHub Repository](https://github.com/json-path/JsonPath) 
- [How to Write a JavaFX Screen Without FXML/Scene Builder](https://pragmatic-coding.hashnode.dev/how-to-write-a-javafx-screen-without-fxmlscene-builder)
- [JavaFX Dialogs - Official Guide](https://code.makery.ch/blog/javafx-dialogs-official/)






