package API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {
  static String employee_id;
  String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
  String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NTUzMzYxOTIsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY1NTM3OTM5MiwidXNlcklkIjoiMzg1OSJ9.2Z7ZYeFNS1_dvMpTVVXPM9BqGsIanW3E1T04wr0Vxhc";

  @Test
  public void aCreateEmployee() {
    RequestSpecification request = given().header("Content-Type", "application/json").
            header("Authorization", token).body("{\n" +
                    "  \"emp_firstname\": \"manana\",\n" +
                    "  \"emp_lastname\": \"patsatsia\",\n" +
                    "  \"emp_middle_name\": \"MS\",\n" +
                    "  \"emp_gender\": \"F\",\n" +
                    "  \"emp_birthday\": \"2000-06-11\",\n" +
                    "  \"emp_status\": \"Probation\",\n" +
                    "  \"emp_job_title\": \"QA\"\n" +
                    "}");

    Response response = request.when().post("/createEmployee.php");
    response.prettyPrint();
    response.then().assertThat().body("Message", equalTo("Employee Created"));
    response.then().assertThat().body("Employee.emp_firstname", equalTo("manana"));
    employee_id = response.jsonPath().getString("Employee.employee_id");
    System.out.println(employee_id);

  }

  @Test
  public void bgetCreatedEmployee() {
    RequestSpecification preparedRequest = given().header("Content-Type", "application/json").
            header("Authorization", token).queryParam("employee_id", employee_id);

    Response response = preparedRequest.when().get("/getOneEmployee.php");
    response.prettyPrint();

    response.then().assertThat().statusCode(200);

    String tempId = response.jsonPath().getString("employee.employee_id");
    System.out.println(tempId);
    Assert.assertEquals(tempId, employee_id);
  }
  @Test
  public void cUpdateEmployee(){
     RequestSpecification preparedRequest= given().header("Content-Type","Application/json").
             header("Authorization",token).body("{\n" +
                     "  \"employee_id\": \""+employee_id+"\",\n" +
                     "  \"emp_firstname\": \"Asel\",\n" +
                     "  \"emp_lastname\": \"Isak\",\n" +
                     "  \"emp_middle_name\": \"MS\",\n" +
                     "  \"emp_gender\": \"F\",\n" +
                     "  \"emp_birthday\": \"1984-09-27\",\n" +
                     "  \"emp_status\": \"confirmed\",\n" +
                     "  \"emp_job_title\": \"CEO\"\n" +
                     "}");
     Response response = preparedRequest.when().post("/updateEmployee.php");
     response.prettyPrint();
     response.then().assertThat().statusCode(200);
  }
  @Test
  public void dGetUpdatedEmployee(){
    RequestSpecification request = given().header("Content-Type","application/json").
            header("Authorization",token).queryParam("employee_id",employee_id);
    Response response = request.when().get("/getOneEmployee.php");
    response.then().assertThat().statusCode(200);
    response.prettyPrint();
  }
  @Test
  public void eGetAllEmployees(){
    RequestSpecification request = given().header("Authorization",token).
            header("Content-Type","Application/json");
    Response response = request.when().get("/getAllEmployees.php");
    //it returns string of response
   String allEmployees =  response.prettyPrint();
    //jsonPath() vs jsonPath
    //jsonPath is a class that contains method for converting the values into json object
    //jsonpath() is a method belongs to jsonPath class

    //creating object jsonPath class
    JsonPath js = new JsonPath(allEmployees);
    //retrieving the total number of employees
    int count = js.getInt("Employees.size()");
    System.out.println(count);
    for (int i=0; i<count; i++){
      String empId = js.getString("Employees["+ i +"].employee_id");
        System.out.println(empId);
    }

  }
}