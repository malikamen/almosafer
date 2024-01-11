# Project README

## Developer Challenge - Test Engineering Skills

The purpose of this project is to showcase test engineering skills through the automation of GET and POST APIs from the flights module on [Almosafer](https://www.almosafer.com/en).

### Task Overview

1. Navigate to https://www.almosafer.com/en and automate GET & POST APIs from the flights module.
2. Use dynamic data for parameters like dates, jsonBody and endpoints.
3. Implement reporting for better visibility.
4. Create the request JSON body dynamically.
5. Perform necessary validations on API responses.

### Project Structure

The project follows these conventions:

- **Rest Assured Framework:** The project is built using the Rest Assured framework with Java.
- **Page Object Model (POM):** Utilizes the Page Object Model for better maintainability and reusability >> getService, postService and testData classes.
- **TestNG Integration:** Integrates with TestNG for test execution and reporting for passed and failed cases, make sure the listener Reporting is added.

### How to Run the Tests

1. Clone the repository:

    ```bash
    git clone https://github.com/malikamen/almosafer.git
    ```

2. Open the project in your preferred IDE.

3. Configure your test environment if necessary.

4. Run the tests using TestNG.

### Reporting

Test execution results and reports can be found in [test-output/emailable-report.html].

### Notes

- This code is designed for testing purposes only. Successful execution does not guarantee the functionality of the application. It is advised to validate the testing code itself.
- Followed best practices and coding standards for maintainability and reliability.

### Contact

For any inquiries or feedback, please contact [malik.amen.97@gmail.com].

Thank you for reviewing the code!

