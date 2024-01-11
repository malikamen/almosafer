package TCs.flights;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class postService {

    testData testData = new testData();

    @Test(description = "(AirportList) Service- Happy Scenario")
    void Test1() {

        // Perform the GET request with Set dynamic data

        given()
                .contentType(ContentType.JSON) // Specify the content type as JSON
                .body(testData.generateBody("HappyBody")) // Set the JSON payload
                .when()
                .post(testData.generatePostEndpoint("HappyEndpoint"))
                .then()
                .statusCode(testData.SuccessResponseCode)
                .assertThat()
                .body(containsString("Saudi Arabia"));
    }

    @Test(description = "(AirportList) Service- Validate Missing Template Behavior")
    void Test2() {

        // Perform the GET request with Set dynamic data

        given()
                .contentType(ContentType.JSON) // Specify the content type as JSON
                .body(testData.generateBody("missingTemplate")) // Set the JSON payload
                .when()
                .post(testData.generatePostEndpoint("HappyEndpoint"))
                .then()
                .statusCode(testData.SuccessResponseCode)
                .assertThat()
                .body(containsString("")); //Return empty body
    }

    @Test(description = "(AirportList) Service- Validate Missing Country Behavior")
    void Test3() {

        // Perform the GET request with Set dynamic data

        given()
                .contentType(ContentType.JSON) // Specify the content type as JSON
                .body(testData.generateBody("missingCountry")) // Set the JSON payload
                .when()
                .post(testData.generatePostEndpoint("HappyEndpoint"))
                .then()
                .statusCode(testData.SuccessResponseCode)
                .assertThat()
                .body(containsString("Saudi Arabia"));
    }

    @Test(description = "(AirportList) Service- Validate Missing Media Behavior")
    void Test4() {

        // Perform the GET request with Set dynamic data

        given()
                .contentType(ContentType.JSON) // Specify the content type as JSON
                .body(testData.generateBody("missingMedia")) // Set the JSON payload
                .when()
                .post(testData.generatePostEndpoint("HappyEndpoint"))
                .then()
                .statusCode(testData.SuccessResponseCode)
                .assertThat()
                .body(containsString("404"));
    }

    @Test(description = "(AirportList) Service- Validate Missing local Behavior")
    void Test5() {

        // Perform the GET request with Set dynamic data

        given()
                .contentType(ContentType.JSON) // Specify the content type as JSON
                .body(testData.generateBody("missingLocal")) // Set the JSON payload
                .when()
                .post(testData.generatePostEndpoint("HappyEndpoint"))
                .then()
                .statusCode(testData.SuccessResponseCode);
    }

    @Test(description = "(AirportList) Service- Validate Missing Body Behavior")
    void Test6() {

        // Perform the GET request with Set dynamic data

        given()
                .contentType(ContentType.JSON) // Specify the content type as JSON
                .body(testData.generateBody("missingAll")) // Set the JSON payload
                .when()
                .post(testData.generatePostEndpoint("HappyEndpoint"))
                .then()
                .statusCode(testData.SuccessResponseCode)
                .assertThat()
                .body(containsString(""));  //Return empty body
    }

    @Test(description = "(AirportList) Service- Validate Missing Endpoint Behavior (page)")
    void Test7() {

        // Perform the GET request with Set dynamic data

        given()
                .contentType(ContentType.JSON) // Specify the content type as JSON
                .body(testData.generateBody("HappyBody")) // Set the JSON payload
                .when()
                .post(testData.generatePostEndpoint("missingPage"))
                .then()
                .statusCode(testData.SuccessResponseCode)
                .assertThat()
                .body(containsString("Saudi Arabia"));
    }

    @Test(description = "(AirportList) Service- Validate Missing Endpoint Behavior (page, cms)")
    void Test8() {

        // Perform the GET request with Set dynamic data

        given()
                .contentType(ContentType.JSON) // Specify the content type as JSON
                .body(testData.generateBody("HappyBody")) // Set the JSON payload
                .when()
                .post(testData.generatePostEndpoint("missingPageAndCms")) // Replace with your API endpoint
                .then()
                .statusCode(testData.NotFoundResponseCode)
                .assertThat()
                .body(containsString("404"));
    }

    @Test(description = "(AirportList) Service- Validate Missing Endpoint Behavior (api)")
    void Test9() {

        // Perform the GET request with Set dynamic data

        given()
                .contentType(ContentType.JSON) // Specify the content type as JSON
                .body(testData.generateBody("HappyBody")) // Set the JSON payload
                .when()
                .post(testData.generatePostEndpoint("missingApi")) // Replace with your API endpoint
                .then()
                .statusCode(testData.temporarilyMovedResponseCode)
                .assertThat()
                .body(containsString("Redirecting to /en/cms/page"));
    }

    @Test(description = "(AirportList) Service- Validate Missing Endpoint Behavior (cms)")
    void Test10() {

        // Perform the GET request with Set dynamic data

        given()
                .contentType(ContentType.JSON) // Specify the content type as JSON
                .body(testData.generateBody("HappyBody")) // Set the JSON payload
                .when()
                .post(testData.generatePostEndpoint("missingCms"))
                .then()
                .statusCode(testData.NotFoundResponseCode)
                .assertThat()
                .body(containsString("404"));
    }
}
