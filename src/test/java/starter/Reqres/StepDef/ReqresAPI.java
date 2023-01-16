package starter.Reqres.StepDef;

import io.restassured.http.ContentType;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.Utils.Constant;

import javax.print.DocFlavor;
import java.io.File;

public class ReqresAPI {
    //buat base URL
//    public static String BASE_URL = "https://reqres.in";
//    public static final String DIR = System.getProperty("user.dir");
//    public static String JSON_REQUEST = DIR+"/src/test/resources/JSON/Request";
//    public static String JSON_SCHEMA = DIR+"/src/test/resources/JSON/JsonSchema";
    public static String GET_LIST_USER = Constant.BASE_URL+"/api/users?page={page}";
    public static String POST_CREATE_USER = Constant.BASE_URL+"/api/users";
    public static String PUT_UPDATE_USER = Constant.BASE_URL+"/api/users/{id}";
    public static String DELETE_USER = Constant.BASE_URL+"/api/users/{id}";
    public static String LOGIN_USER = Constant.BASE_URL+"/api/login";
    public static String INVALID_POST_CREATE_USER = Constant.BASE_URL+"/api/usersssssss";
    public static String INVALID_DELETE_USER = Constant.BASE_URL+"/api/usersssss/{id}";
    public static String INVALID_GET_LIST_USER = Constant.BASE_URL+"/api/users?page={page}";

    @Step("Get list users")
    public void getListUser(int page){
        SerenityRest.given().pathParam("page", page);
    }
    @Step("Post create user")
    public void postCreateUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put update user")
    public void putUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Delete User")
    public void deleteUser(int id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step("Invalid Delete User")
    public void invalidDeleteUser(String id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step("Invalid Get list users")
    public void invalidGetListUser(String page){
        SerenityRest.given().pathParam("page", page);
    }
    @Step("Post login User")
    public void postLoginUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
