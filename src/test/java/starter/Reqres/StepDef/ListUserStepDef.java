package starter.Reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.Utils.Constant;
import starter.Reqres.Utils.ReqresResponses;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class ListUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //Scenario 1
    @Given("Get list user with page {int}")
    public void getListUserWithPage(int page) {
        reqresAPI.getListUser(page);
    }

    @When("Send request get list user")
    public void sendRequestGetListUser() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USER);
    }

    @Then("should return status code {int}")
    public void shouldReturnStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Response body page should be {int}")
    public void responseBodyShouldPageShouldBe(int page) {
        SerenityRest.then().body(ReqresResponses.PAGE, equalTo(page));
    }

    @And("Validate json schema list user")
    public void validateJsonSchemaListUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/ListUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @When("Send invalid request get list user")
    public void sendInvalidRequestGetListUser() {
        SerenityRest.when().get(ReqresAPI.INVALID_GET_LIST_USER);
    }

    @And("Response body page should be {int}, ID {int}, Email {string}, and First Name {string}")
    public void responseBodyPageShouldBeIDEmailAndFirstName(int page, int id, String email, String firstName) {
        SerenityRest.then()
                .body(ReqresResponses.PAGE, equalTo(page))
                .body(ReqresResponses.DATA_ID, equalTo(id))
                .body(ReqresResponses.DATA_EMAIL, equalTo(email))
                .body(ReqresResponses.FIRST_NAME, equalTo(firstName));
    }
}
