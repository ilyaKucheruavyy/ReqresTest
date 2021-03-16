package reqres;

public class Constants {

    // constants for api
    public static final String URL_REQRES = "https://reqres.in/";
    public static final String API = "api/";
    public static final String PAGES = "?page=";
    public static final String DELAY = "?delay=";
    public static final String USERS = "users";
    public static final String LOGIN = "login";
    public static final String REGISTER = "register";
    public static final String UNKNOWN ="unknown";
    public static final String CONTENT_TYPE = "application/json";
    public static final String DATA = "data";

    // constants for status codes
    public static final int OK = 200;
    public static final int CREATED = 201;
    public static final int NO_CONTENT = 204;
    public static final int BAD_REQUEST = 400;
    public static final int NOT_FOUND = 404;

    // constants for body
    public static final String BODY_CREATE_USERS = "{\"name\": \"morpheus\"job\": \"leader\"}";
    public static final String BODY_UPDATE_USER = "{\"name\": \"morpheus\"job\": \"zion resident\"}";
    public static final String BODY_UPDATE_ANOTHER_USER = "{\"name\": \"morpheus\"\"job\": \"zion resident\"}";
    public static final String BODY_SUCCESSFUL_REGISTRATION ="{\"email\": \"eve.holt@reqres.in\",\"password\": \"pistol\"}";
    public static final String BODY_UNSUCCESSFUL_REGISTRATION = "{ \"email\": \"sydney@fife\"}";
    public static final String BODY_SUCCESSFUL_LOGIN = "{\"email\": \"eve.holt@reqres.in\",\"password\": \"cityslicka\"}";
    public static final String BODY_UNSUCCESSFUL_LOGIN = "{\"email\": \"peter@klaven\"}";
}
