import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.notNullValue;
import static reqres.Constants.*;

public class ReqresTest {

    @Test
    public void getListOfAllUsers() {
        when().get(URL_REQRES + API + USERS + PAGES + "2").then().statusCode(OK).body(DATA, notNullValue());
    }

    @Test
    public void getSingleUser() {
        when().get(URL_REQRES + API + USERS + "/2").then().assertThat().statusCode(OK).body(DATA, notNullValue());
    }

    @Test
    public void getNonExistentUser() {
        when().get(URL_REQRES + API + USERS + "/23").then().statusCode(NOT_FOUND).body(DATA, isEmptyOrNullString());
    }

    @Test
    public void getListAllResources() {
        when().get(URL_REQRES + API + UNKNOWN).then().statusCode(OK).body(DATA, notNullValue());
    }

    @Test
    public void getSingleResources() {
        when().get(URL_REQRES + API + UNKNOWN + "/2").then().statusCode(OK).body(DATA, notNullValue());
    }

    @Test
    public void getNonExistentResources() {
        when().get(URL_REQRES + API + UNKNOWN + "/23").then().statusCode(NOT_FOUND).body(DATA, isEmptyOrNullString());
    }

    @Test
    public void createUser() {
        given().body(BODY_CREATE_USERS).post(URL_REQRES + API + USERS).then().statusCode(CREATED);
    }

    @Test
    public void updateUser() {
        given().body(BODY_UPDATE_USER).put(URL_REQRES + API + USERS + "/2").then().statusCode(OK);
    }

    @Test
    public void updateAnotherUser() {
        given().body(BODY_UPDATE_ANOTHER_USER).patch(URL_REQRES + API + USERS + "/2").then().statusCode(OK);
    }

    @Test
    public void deleteUser() {
        when().delete(URL_REQRES + API + USERS + "/2").then().statusCode(NO_CONTENT);
    }

    @Test
    public void successfulUserRegistration() {
        given().contentType(CONTENT_TYPE).body(BODY_SUCCESSFUL_REGISTRATION).post(URL_REQRES + API + REGISTER).then().statusCode(OK);
    }

    @Test
    public void unsuccessfulUserRegistration() {
        given().body(BODY_UNSUCCESSFUL_REGISTRATION).post(URL_REQRES + API + REGISTER).then().statusCode(BAD_REQUEST);
    }

    @Test
    public void successfulUserLogin() {
        given().contentType(CONTENT_TYPE).body(BODY_SUCCESSFUL_LOGIN).post(URL_REQRES + API + LOGIN).then().statusCode(OK);
    }

    @Test
    public void unsuccessfulUserLogin() {
        given().body(BODY_UNSUCCESSFUL_LOGIN).post(URL_REQRES + API + LOGIN).then().statusCode(BAD_REQUEST);
    }

    @Test
    public void delayedResponse() {
        when().get(URL_REQRES + API + USERS + DELAY + "3").then().statusCode(OK);
    }
}
