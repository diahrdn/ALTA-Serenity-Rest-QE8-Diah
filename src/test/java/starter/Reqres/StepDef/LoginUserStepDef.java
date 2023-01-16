package starter.Reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.Utils.Constant;
import starter.Reqres.Utils.ReqresResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;


public class LoginUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    //Scenario 1
    @Given("Post login user with valid json")
    public void postLoginUserWithValidJson() {
        File json = new File(Constant.JSON_REQUEST+"/LoginUser.json");
        reqresAPI.postLoginUser(json);
    }

    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when().post(ReqresAPI.LOGIN_USER);
    }

    @And("Response body token should be {string}")
    public void responseBodyTokenShouldBe(String token) {
        SerenityRest.then()
                .body(ReqresResponses.TOKEN, equalTo(token));
    }

    @And("validate json schema login user")
    public void validateJsonSchemaLoginUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/LoginUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Scenario 2

    @Given("Post login user without password")
    public void postLoginUserWithoutPassword() {
        File json = new File(Constant.JSON_REQUEST+"/UnsuccessfulLoginUser.json");
        reqresAPI.postLoginUser(json);
    }

    @And("Response body error message should be {string}")
    public void responseBodyErrorMessageShouldBe(String errorMessage) {
        SerenityRest.then()
                .body(ReqresResponses.ERROR_MESSAGE, equalTo(errorMessage));
    }

    @And("validate json schema unsuccessful login user")
    public void validateJsonSchemaUnsuccessfulLoginUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/UnsuccessfulLoginUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
