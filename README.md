# README.md – InternetBot Selenium Java Automation Framework

# InternetBot – Selenium Java Automation Framework

Automation framework developed for advanced Selenium practice scenarios using
[The Internet Herokuapp](https://the-internet.herokuapp.com?utm_source=chatgpt.com)

---

# 📌 Project Objective

This framework automates multiple Selenium challenge modules using:

* Selenium WebDriver
* Java
* TestNG
* Page Object Model (POM)
* WebDriverManager
* Extent Reports
* Explicit Waits

# 🏗️ Framework Architecture

```text
InternetBot/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── base/
│   │   │   │   ├── BasePage.java
│   │   │   │   └── BaseTest.java
│   │   │   │
│   │   │   ├── pages/
│   │   │   │   ├── LoginPage.java
│   │   │   │   ├── AlertPage.java
│   │   │   │   ├── CheckboxPage.java
│   │   │   │   ├── DropdownPage.java
│   │   │   │   ├── UploadPage.java
│   │   │   │   └── DynamicPage.java
│   │   │   │
│   │   │   ├── utilities/
│   │   │   │   ├── ConfigReader.java
│   │   │   │   ├── DriverFactory.java
│   │   │   │   ├── WaitUtils.java
│   │   │   │   ├── ScreenshotUtils.java
│   │   │   │   ├── ExtentManager.java
│   │   │   │   └── RetryAnalyzer.java
│   │   │   │
│   │   │   └── listeners/
│   │   │       └── TestListener.java
│   │
│   ├── test/
│   │   ├── java/
│   │   │   ├── tests/
│   │   │   │   ├── LoginTest.java
│   │   │   │   ├── AlertTest.java
│   │   │   │   ├── CheckboxTest.java
│   │   │   │   ├── DropdownTest.java
│   │   │   │   ├── UploadTest.java
│   │   │   │   └── DynamicLoadingTest.java
│
├── src/test/resources/
│   ├── config.properties
│   ├── testng.xml
│   └── testdata/
│       └── loginData.json
│
├── screenshots/
├── reports/
├── pom.xml
└── README.md
```

---

# ⚙️ Technologies Used

| Technology         | Purpose                  |
| ------------------ | ------------------------ |
| Java               | Programming Language     |
| Selenium WebDriver | Browser Automation       |
| TestNG             | Testing Framework        |
| Maven              | Build Tool               |
| WebDriverManager   | Driver Management        |
| ExtentReports      | HTML Reporting           |
| POM                | Framework Design Pattern |

---

# 📦 Required Maven Dependencies

```xml
<dependencies>

    <!-- Selenium -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.21.0</version>
    </dependency>

    <!-- TestNG -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.10.2</version>
        <scope>test</scope>
    </dependency>

    <!-- WebDriverManager -->
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.8.0</version>
    </dependency>

    <!-- Extent Reports -->
    <dependency>
        <groupId>com.aventstack</groupId>
        <artifactId>extentreports</artifactId>
        <version>5.1.1</version>
    </dependency>

</dependencies>
```

---

# 🔧 config.properties

```properties
browser=chrome
baseUrl=https://the-internet.herokuapp.com
timeout=10
headless=false

username=tomsmith
password=SuperSecretPassword!
invalidPassword=wrongPassword
```

---

# 🧪 Test Modules

# 1️⃣ Authentication Module

## Page Class

`LoginPage.java`

## Test Class

`LoginTest.java`

## Test Cases

| Test Case            | Description                |
| -------------------- | -------------------------- |
| verifyValidLogin     | Valid login                |
| verifyInvalidLogin   | Invalid login              |
| verifySuccessMessage | Success message validation |
| verifyLogout         | Logout validation          |

## DataProvider Example

```java
@DataProvider(name = "loginData")
public Object[][] loginData() {
    return new Object[][]{
        {"tomsmith", "SuperSecretPassword!", true},
        {"tomsmith", "wrong", false}
    };
}
```

---

# 2️⃣ JavaScript Alerts Module

## Page Class

`AlertPage.java`

## Test Class

`AlertTest.java`

## Test Cases

| Test Case              | Description            |
| ---------------------- | ---------------------- |
| verifyJsAlert          | Alert accept           |
| verifyJsConfirmDismiss | Confirm dismiss        |
| verifyJsPrompt         | Prompt text validation |
| verifyAlertResultReset | Result validation      |

---

# 3️⃣ Checkbox & Dropdown Module

## Page Classes

* CheckboxPage.java
* DropdownPage.java

## Test Classes

* CheckboxTest.java
* DropdownTest.java

## Test Cases

### Checkbox

| Test Case                  | Description         |
| -------------------------- | ------------------- |
| verifyCheckbox1Selection   | Select checkbox 1   |
| verifyCheckbox1Deselection | Unselect checkbox 1 |
| verifyCheckbox2Toggle      | Toggle checkbox 2   |

### Dropdown

| Test Case             | Description    |
| --------------------- | -------------- |
| verifyDropdownOptions | Option count   |
| verifyOptionSelection | Select options |

---

# 4️⃣ File Upload Module

## Page Class

`UploadPage.java`

## Test Class

`UploadTest.java`

## Test Cases

| Test Case               | Description     |
| ----------------------- | --------------- |
| verifyFileUpload        | Upload file     |
| verifyInvalidFileUpload | Invalid file    |
| verifyUploadPageVisible | Page validation |

---

# 5️⃣ Dynamic Loading Module

## Page Class

`DynamicPage.java`

## Test Class

`DynamicLoadingTest.java`

## Test Cases

| Test Case                 | Description              |
| ------------------------- | ------------------------ |
| verifyDynamicText         | Dynamic text             |
| verifyDisappearingElement | Refresh validation       |
| verifyElementLoads        | Explicit wait validation |

---

# 🧩 BasePage Responsibilities

`BasePage.java`

Contains shared reusable methods:

```java
click()
type()
waitForVisibility()
getText()
handleAlert()
scrollToElement()
```

---

# 🧩 BaseTest Responsibilities

`BaseTest.java`

Handles:

* Browser launch
* Driver initialization
* Browser teardown

Uses:

```java
@BeforeMethod
@AfterMethod
```

# 📸 Screenshot on Failure

Implemented using:
<img width="1107" height="562" alt="image" src="https://github.com/user-attachments/assets/8bd26bbf-b2d0-4b43-a6f8-e0ed3872691b" />

```java
ITestListener
```

Screenshots stored inside:

```text
/screenshots/
```

Filename format:

```text
testName_timestamp.png
```

---

# 📊 Extent Reports

Reports generated inside:

```text
/reports/
```

Contains:

* Pass/Fail status
* Test names
* Execution logs
* Screenshot on failure

---

# 🔄 Retry Mechanism

Implemented using:

```java
IRetryAnalyzer
```

Purpose:

* Retry flaky tests automatically

---
# ✅ Best Practices Followed

* No hardcoded URLs
* No hardcoded waits
* No duplicate code
* POM strictly followed
* Explicit waits used everywhere
* Clean naming conventions
* Separate utility classes
* Data-driven testing
* Retry mechanism added
* Extent reporting added

---

# 🚫 Strictly Avoided

❌ Thread.sleep()

❌ findElement inside Test classes

❌ Hardcoded browser values

❌ Duplicate Selenium code

❌ Direct WebDriver logic in tests

---

# 📈 Future Enhancements

* Jenkins CI/CD Integration
* Docker execution
* Cross-browser grid execution
* API + UI hybrid framework
* Allure Reports
* Excel driven framework
* Database validation




