package APIreview;


import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class APIExamples {

   String baseURI = RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";

   String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NTYxNzM3MjQsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY1NjIxNjkyNCwidXNlcklkIjoiMzg1OSJ9.xKqwX53TRK3_7NFTDWREMhd7M-isDYbtiC2_khaoOqA";

   @Test
    public void createEmployee(){

       RequestSpecification request = given().header("Content-type","Application/json").
               header("Authorization",token).body("{\n" +
                       "  \"emp_firstname\": \"Asghar\",\n" +
                       "  \"emp_lastname\": \"Nazir\",\n" +
                       "  \"emp_middle_name\": \"Mama\",\n" +
                       "  \"emp_gender\": \"M\",\n" +
                       "  \"emp_birthday\": \"2000-06-11\",\n" +
                       "  \"emp_status\": \"Probation\",\n" +
                       "  \"emp_job_title\": \"Teacher\"\n" +
                       "}");
            Response response = request.when().post("/createEmployee.php");
             //System.out.println(response.asString());
       response.prettyPrint();

       //understanding GSON
       //reading the response returned to us by restAssured and converting it into jsonelement
       JsonElement json_element = new JsonParser().parse(response.asString());
      JsonObject json_data = json_element.getAsJsonObject();
      JsonElement key_message =json_data.get("Message");
       System.out.println(key_message);

       JsonElement Employee = json_data.get("Employee");
       System.out.println(Employee);

       JsonObject Employee_details = Employee.getAsJsonObject();
       System.out.println(Employee_details.get("emp_firstname"));
       System.out.println(Employee_details.get("emp_middle_name"));
       System.out.println(Employee_details.get("emp_lastname"));
       System.out.println(Employee_details.get("emp_birthday"));

       Assert.assertEquals(Employee,Employee_details);

   }

}
