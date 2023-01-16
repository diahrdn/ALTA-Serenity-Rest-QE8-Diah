package starter.Reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.Utils.Constant;
import starter.Reqres.Utils.ReqresResponses;
import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class CreateUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //Latihan
    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(Constant.JSON_REQUEST+"/RequestUser.json");
        reqresAPI.postCreateUser(json);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }

    @And("Response body name should be {string} and Job {string}")
    public void responseBodyNameShouldBeAndJob(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponses.NAME, equalTo(name))
                .body(ReqresResponses.JOB, equalTo(job));
    }
    @And("validate json schema create user")
    public void validateJsonSchemaCreateUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/CreateUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Scenario 1
    @Given("Post create user without input name")
    public void postCreateUserWithoutInputName() {
        File json = new File(Constant.JSON_REQUEST+"/InvalidRequestUser.json");
        reqresAPI.postCreateUser(json);
    }

    //Scenario 2
    @Given("Post create user with invalid url")
    public void postCreateUserWithInvalidUrl() {
        File json = new File(Constant.JSON_REQUEST+"/InvalidRequestUser.json");
        reqresAPI.postCreateUser(json);
    }

    @When("Send request post create user and invalid url")
    public void sendRequestPostCreateUserAndInvalidUrl() {
        SerenityRest.when().post(ReqresAPI.INVALID_POST_CREATE_USER);
    }

    //Scenario 3
    @Given("Post create new input with invalid json")
    public void postCreateNewInputWithInvalidJson() {
        File json = new File(Constant.JSON_REQUEST+"/NumericRequestUser.json");
        reqresAPI.postCreateUser(json);
    }
    @And("Response body name should be {int}, Job {int}, and {string}")
    public void responseBodyNameShouldBeJobAnd(int name, int job, String createdAt) {
        SerenityRest.then()
                .body(ReqresResponses.NAME, equalTo(name))
                .body(ReqresResponses.JOB, equalTo(job))
                .body(ReqresResponses.CREATEDAT, equalTo(createdAt));
    }
}
