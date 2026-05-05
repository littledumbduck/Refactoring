# SauceDemo Automation Refactoring Project

This repository demonstrates a professional refactoring process of a Selenium automation suite. The project transitions
from a monolithic "Smelly" script to a clean, scalable architecture based on the **Page Object Model (POM)** and **SOLID
** principles.
The project automates a core user journey on the [SauceDemo](https://www.saucedemo.com/) web application. Specifically,
it executes a complete end-to-end flow where a user logs in with valid credentials, selects a "Sauce Labs Backpack" from
the product catalog, and successfully adds it to the shopping cart.

From a technical perspective, the project serves as a **Refactoring Case Study**. It is designed to demonstrate:

* **Functional Automation**: A stable Selenium script that completes a business-critical path.
* **Design Patterns**: The implementation of the **Page Object Model (POM)** to separate UI interactions from test
  assertions.
* **Clean Code Standards**: The identification and removal of 10 common "Code Smells" to transform fragile code into a
  maintainable and professional automation framework.

## Project Structure

```text
Refactoring/
├── .idea/
├── .mvn/
├── src/
│   ├── main/
│   └── test/
│       └── java/
│           ├── pages/                  # Package for Page Object Model (POM) classes
│           │   ├── InventoryPage       # Locators and actions for the product catalog
│           │   └── LoginPage           # Locators and actions for the login screen
│           └── test/                   # Package for test suites and infrastructure
│               ├── BaseTest            # Parent class for browser setup and teardown
│               ├── CleanSauceTest      # Refactored test suite following clean code
│               └── SmellySauceTest     # Legacy test containing the original code smells
├── .gitignore
├── pom.xml                             # Maven configuration for dependencies (Selenium, JUnit)
└── README.md                           # Project documentation and refactoring overview
```

---

## Code Smells & Refactoring Solutions

We identified and resolved 10 specific code smells categorized into five major groups:

### 1. Bloaters (Code that has grown too large)

* **Long Method (Smell 3)**: The initial test handled setup, login, navigation, and assertions in a single massive
  block.
    * **Fix**: Logic was distributed into small, single-responsibility methods within Page Objects.
* **Large Class (Smell 10)**: A single class managed the driver instance, locators, and test logic.
    * **Fix**: Split responsibilities into `BaseTest` (infrastructure) and specialized Page classes.

### 2. Object-Oriented Abusers

* **Temporary Field (Smell 1)**: Fields were declared at the class level but only used once, cluttering the object
  state.
    * **Fix**: Removed unnecessary class-level fields to maintain a clean object state.
* **Switch Statement (Smell 5)**: A rigid switch was used to select products, making the code hard to scale.
    * **Fix**: Replaced with specific methods (e.g., `addBackpackToCart()`) to improve readability and polymorphism.

### 3. Change Preventers

* **Divergent Change (Smell 7)**: Logic was mixed with hardcoded IDs. A simple UI change would require editing the test
  logic in multiple places.
    * **Fix**: Centralized all locators as `private final By` constants inside Page Objects.

### 4. Dispensables (Unnecessary code)

* **Duplicate Code (Smell 2 & 8)**: Browser setup and teardown were repeated or placed directly within the test flow.
    * **Fix**: Centralized infrastructure in a `BaseTest` class using JUnit 5 `@BeforeEach` and `@AfterEach`
      annotations.
* **Dead Code (Smell 6)**: Variables were declared but never used, increasing cognitive load.
    * **Fix**: Purged all unused code and variables.

### 5. Couplers (Excessive coupling)

* **Feature Envy (Smell 4)**: The test class was too interested in the internal structure (IDs/Classes) of the web
  pages.
    * **Fix**: Encapsulated UI interactions so the test only interacts with high-level business actions (e.g.,
      `login()`).
* **Inappropriate Intimacy (Smell 9)**: Internal methods or logic were exposed publicly, breaking encapsulation.
    * **Fix**: Applied proper access modifiers and hid internal implementation details.

---

## Getting Started

### Prerequisites

* **Java 25**
* **Maven**
* **IntelliJ IDEA**

### Execution

1. **Clone the repo**: `git clone <your-repository-url>`
2. **Run the Smelly Test**: Execute `SmellySauceTest.java` to see the functional but unoptimized version.
3. **Run the Clean Test**: Execute `tests/CleanSauceTest.java` to see the refactored POM architecture in action.