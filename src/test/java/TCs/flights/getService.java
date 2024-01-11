package TCs.flights;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class getService {

    testData testData = new testData();

    @Test(description = "(Search) Service- Happy Scenario")
    void Test1() {

        // Perform the GET request with Set dynamic data

        given()
                .param("Accept", testData.Accept)
                .param("Accept Encoding", testData.AcceptEncoding)
                .param("Accept Language", testData.AcceptLanguage)
                .when()
                .get(testData.generateGetEndpoint("HappyEndpoint"))
                .then()
                .statusCode(testData.SuccessResponseCode)
                .assertThat()
                .body(containsString("Flights Found"));
    }

    @Test(description = "(Search) Service- Validate Missing Dates")
    void Test2() {

        // Perform the GET request with Set dynamic data
        given()
                .param("Accept", testData.Accept)
                .param("Accept Encoding", testData.AcceptEncoding)
                .param("Accept Language", testData.AcceptLanguage)
                .when()
                .get(testData.generateGetEndpoint("missingDates"))
                .then()
                .statusCode(testData.SuccessResponseCode)
                .assertThat()
                .body(containsString(testData.notFindMessage));
    }

    @Test(description = "(Search) Service- Validate Missing Passengers")
    void Test3() {

        // Perform the GET request with Set dynamic data
        given()
                .param("Accept", testData.Accept)
                .param("Accept Encoding", testData.AcceptEncoding)
                .param("Accept Language", testData.AcceptLanguage)
                .when()
                .get(testData.generateGetEndpoint("missingPassengers"))
                .then()
                .statusCode(testData.SuccessResponseCode)
                .assertThat()
                .body(containsString(testData.notFindMessage));
    }

    @Test(description = "(Search) Service- Exceed Passengers No.")
    void Test4() {

        // Perform the GET request with Set dynamic data
        given()
                .param("Accept", testData.Accept)
                .param("Accept Encoding", testData.AcceptEncoding)
                .param("Accept Language", testData.AcceptLanguage)
                .when()
                .get(testData.generateGetEndpoint("ExceedPassengersNo"))
                .then()
                .statusCode(testData.SuccessResponseCode)
                .assertThat()
                .body(containsString(testData.notFindMessage));
    }

    @Test(description = "(Search) Service- Validate Missing Countries")
    void Test5() {

        // Perform the GET request with Set dynamic data
        given()
                .param("Accept", testData.Accept)
                .param("Accept Encoding", testData.AcceptEncoding)
                .param("Accept Language", testData.AcceptLanguage)
                .when()
                .get(testData.generateGetEndpoint("missingCountries"))
                .then()
                .statusCode(testData.SuccessResponseCode)
                .assertThat()
                .body(containsString(testData.notFindMessage));
    }

    @Test(description = "(Search) Service- Validate Missing All Filters")
    void Test6() {

        // Perform the GET request with Set dynamic data
        given()
                .param("Accept", testData.Accept)
                .param("Accept Encoding", testData.AcceptEncoding)
                .param("Accept Language", testData.AcceptLanguage)
                .when()
                .get(testData.generateGetEndpoint("withoutAnyFilters"))
                .then()
                .statusCode(testData.NotFoundResponseCode)
                .assertThat()
                .body(containsString(testData.notFoundMessage));
    }

    @Test(description = "(Search) Service- Validate GoDate Bigger BackDate")
    void Test7() {

        // Perform the GET request with Set dynamic data

        given()
                .param("Accept", testData.Accept)
                .param("Accept Encoding", testData.AcceptEncoding)
                .param("Accept Language", testData.AcceptLanguage)
                .when()
                .get(testData.generateGetEndpoint("GoDateBiggerBackDate"))
                .then()
                .statusCode(testData.SuccessResponseCode)
                .assertThat()
                .body(containsString(testData.notFindMessage));
    }

    @Test(description = "(Search) Service- Validate set invalid date")
    void Test8() {

        // Perform the GET request with Set dynamic data

        given()
                .param("Accept", testData.Accept)
                .param("Accept Encoding", testData.AcceptEncoding)
                .param("Accept Language", testData.AcceptLanguage)
                .when()
                .get(testData.generateGetEndpoint("UseInvalidDate"))
                .then()
                .statusCode(testData.SuccessResponseCode)
                .assertThat()
                .body(containsString(testData.notFindMessage));
    }

}