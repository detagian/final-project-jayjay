package com.api;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.json.JSONObject;

import java.io.File;

public class ApiModel {
    private ValidatableResponse Response;
    public ApiModel(ValidatableResponse Response){
        this.Response = Response;
    }
    private String app_Id =  "64dc4dbd40e42033bae619a5";

    public void setup() {
        RestAssured.baseURI = "https://dummyapi.io/data/v1";
    }

    public void setEndpointMethodGet(String url){
        Response =RestAssured
                .given()
                .header("app-id",app_Id)
                .when()
                .get(url)
                .then().log().all();
    }

    public void validateResponseCode(int responseCode){
        Response.assertThat().statusCode(responseCode);

    }

    public void validatePageIndex(int pageIndex){
        Response.assertThat().body("page", Matchers.equalTo(pageIndex));
    }

    public void validateLimitUser(int limitUser){
        Response.assertThat().body("limit", Matchers.equalTo(limitUser));
    }

    public void validateJSONScheme(String filename){
        String location ="src/test/resources/JsonScheme/"+filename ;
        File jsonScheme = new File(location);
        Response.assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonScheme));
    }

    public void validateUserId(String id){
        Response.assertThat().body("id", Matchers.equalTo(id));
    }

    public void setEndpointPOSTForCreateUser(String firstName,String lastName, String email, String url){
        JSONObject bodyObj = new JSONObject();
        bodyObj.put("firstName",firstName);
        bodyObj.put("lastName",lastName);
        bodyObj.put("email",email);
        Response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "applicaiton/json")
                .header("app-id",app_Id)
                .body(bodyObj.toString())
                .when()
                .post(url)
                .then().log().all();
    }
    public void setEndpointPUTForUpdateLastName(String lastName,String url){
        JSONObject bodyObj = new JSONObject();
        bodyObj.put("lastName",lastName);
        Response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("app-id",app_Id)
                .body(bodyObj.toString())
                .when()
                .put(url)
                .then().log().all();
    }

    public void validateUpdateLastName(String lastName){
        Response.assertThat().body("lastName", Matchers.equalTo(lastName));
    }

    public void validateUserIdFromPost(String id){
        Response.assertThat().body("data[0].owner.id", Matchers.equalTo(id));
    }

    public void validatePostId(String id) {
        Response.assertThat().body("id", Matchers.equalTo(id));
    }

    public void validatePostIdFromComment(String postId) {
        Response.assertThat().body("data[0].post", Matchers.equalTo(postId));
    }

    public void validateUserIdFromComment(String userId) {
        Response.assertThat().body("data[0].owner.id", Matchers.equalTo(userId));
    }

    public void setEndpointPOSTForCreatePost(String userId,String textPost,String url){
        JSONObject bodyObj = new JSONObject();
        bodyObj.put("owner",userId);
        bodyObj.put("text",textPost);
        Response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "applicaiton/json")
                .header("app-id",app_Id)
                .body(bodyObj.toString())
                .when()
                .post(url)
                .then().log().all();
    }

    public void validateTextPost(String textPost){
        Response.assertThat().body("text", Matchers.equalTo(textPost));
    }

    public void setEndpointPUTForUpdateTextPost(String updateText,String url){
        JSONObject bodyObj = new JSONObject();
        bodyObj.put("text",updateText);
        Response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("app-id",app_Id)
                .body(bodyObj.toString())
                .when()
                .put(url)
                .then().log().all();
    }

    public void setEndpointPOSTForCreateComment(String post,String owner,String msg,String url){
        JSONObject bodyObj = new JSONObject();
        bodyObj.put("owner",owner);
        bodyObj.put("post",post);
        bodyObj.put("message",msg);
        Response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "applicaiton/json")
                .header("app-id",app_Id)
                .body(bodyObj.toString())
                .when()
                .post(url)
                .then().log().all();
    }

    public void validateCommentMessage(String msgComment){
        Response.assertThat().body("message", Matchers.equalTo(msgComment));
    }
}

