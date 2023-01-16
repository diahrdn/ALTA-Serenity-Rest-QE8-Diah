package starter.Reqres.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class DeleteUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //Scenario 1
    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidIdId(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }

    //Scenario 2
    @Given("Delete user with invalid id {int}")
    public void deleteUserWithInvalidIdId(int id) {
        reqresAPI.deleteUser(id);
    }

    //Scenario 3
    @Given("Delete user with input string id {string}")
    public void deleteUserWithInputStringId(String id) {
        reqresAPI.invalidDeleteUser(id);
    }

    //Scenario 4
    @Given("Delete user with invalid url with id {int}")
    public void deleteUserWithInvalidUrlWithIdId(int id) {
        reqresAPI.deleteUser(id);
    }
    @When("Send invalid request delete user")
    public void sendInvalidRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.INVALID_DELETE_USER);
    }
}
