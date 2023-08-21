package com.stepdefinition.api;

import com.api.ApiModel;
import com.base.BaseModel;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.UUID;


public class ApiStepDefinition extends BaseModel {
    protected ApiModel TEST_API;

    @Given("I set service api")
    public void iSetServiceApi() {
        TEST_API = new ApiModel(Response);
        TEST_API.setup();
    }

    @When("I set Header method GET using Endpoint {string}")
    public void iSetHeaderMethodGETUsingEndpoint(String url) {
        valueUrl = url;
        TEST_API.setEndpointMethodGet(valueUrl);
    }

    @Then("I received a valid HTTP response code {int}")
    public void iReceivedAValidHTTPResponseCode(int httpsResponse) {
        TEST_API.validateResponseCode(httpsResponse);
    }

    @And("I received a valid page index {int}")
    public void iReceivedAValidPageIndex(int pageIndex) {
        TEST_API.validatePageIndex(pageIndex);
    }

    @And("I received a valid limit {int} user")
    public void iReceivedAValidLimitUser(int limitUser) {
        TEST_API.validateLimitUser(limitUser);
    }

    @And("I received a valid {string}")
    public void iReceivedAValidJSONScheme(String jsonscheme) {
        TEST_API.validateJSONScheme(jsonscheme);
    }

    @And("I set first name {string} and last name {string}")
    public void iSetFirstNameAndLastName(String firstName, String lastName) {
        valueFirstName=firstName;
        valueLastName=lastName;
    }

    @And("I set my email name {string} and email domain {string}")
    public void iSetMyEmailNameAndEmailDomain(String emailName, String emailDomain) {
        UUID randomStr = UUID.randomUUID();
        String save = randomStr.toString().substring(0,5);
        valueEmail = emailName+save+emailDomain;
    }

    @When("I set Header method POST using Endpoint {string} to create new user")
    public void iSetHeaderMethodPOSTUsingEndpoint(String url) {
        TEST_API.setEndpointPOSTForCreateUser(valueFirstName,valueLastName,valueEmail,url);
    }

    @When("I set Header method PUT using Endpoint {string}")
    public void iSetHeaderMethodPUTUsingEndpoint(String url) {
        TEST_API.setEndpointPUTForUpdateLastName(valueLastName,url);
    }

    @And("I want to update last name to {string}")
    public void iUpdateLastNameTo(String lastName) {
        valueLastName=lastName;
    }

    @And("I received an update last name to {string}")
    public void iReceivedAnUpdateLastNameTo(String lastName) {
        TEST_API.validateUpdateLastName(lastName);
    }

    @And("I received a valid id {string}")
    public void iReceivedAValidId(String id) {
        TEST_API.validateUserId(id);
    }

    @And("I received a valid user id {string} from post")
    public void iReceivedAValidUserIdFromPost(String id) {
        TEST_API.validateUserIdFromPost(id);
    }

    @And("I received a valid post id {string}")
    public void iReceivedAValidPostId(String id) {
        TEST_API.validatePostId(id);
    }

    @And("I set user id {string}")
    public void iSetUserId(String userId) {
        valueUserId = userId;
    }

    @And("I set text to post {string}")
    public void iSetTextToPost(String textPost) {
        valueTextPost = textPost;
    }

    @When("I set Header method POST using Endpoint {string} to create post")
    public void iSetHeaderMethodPOSTUsingEndpointToCreatePost(String url) {
        TEST_API.setEndpointPOSTForCreatePost(valueUserId,valueTextPost,url);
    }

    @When("I set Header method PUT using Endpoint {string} to create post")
    public void iSetHeaderMethodPUTUsingEndpointToCreatePost(String url) {
        TEST_API.setEndpointPUTForUpdateTextPost(valueTextPost,url);
    }

    @And("I received a valid text post {string}")
    public void iReceivedAValidTextPost(String textPost) {
        TEST_API.validateTextPost(textPost);
    }

    @And("I received a valid post id {string} from comment")
    public void iReceivedAValidPostIdFromComment(String postId) {
        TEST_API.validatePostIdFromComment(postId);
    }

    @And("I received a valid user id {string} from comment")
    public void iReceivedAValidUserIdFromComment(String userId) {
        TEST_API.validateUserIdFromComment(userId);
    }

    @And("I set comment id {string}")
    public void iSetCommentId(String commentId) {
        valueCommentId = commentId;
    }

    @And("I set message to comment {string}")
    public void iSetMessageToComment(String commentMsg) {
        valueMsgcomment = commentMsg;
    }

    @And("I received a valid message to comment {string}")
    public void iReceivedAValidMessageToComment(String commentMsg) {
        TEST_API.validateCommentMessage(commentMsg);
    }

    @When("I set Header method POST using Endpoint {string} to comment a post")
    public void iSetHeaderMethodPOSTUsingEndpointToCommentAPost(String url) {
        TEST_API.setEndpointPOSTForCreateComment(valueCommentId,valueUserId,valueMsgcomment,url);
    }
}
