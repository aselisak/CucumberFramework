package utils;

import org.json.JSONObject;

public class APIPayloadConstants {
    //1. Hardcoded order
    //2.using datatble
    //3.using json object
    //4. using dynamic, method polymorphizm
    public static String createEmployeePayload() {
        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"Aymat\",\n" +
                "  \"emp_lastname\": \"tata\",\n" +
                "  \"emp_middle_name\": \"MS\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"1988-02-28\",\n" +
                "  \"emp_status\": \"Employee\",\n" +
                "  \"emp_job_title\": \"QA\"\n" +
                "}";

        return createEmployeePayload;
    }
    //passing the body from json object
    public static String createEmployeePayloadViaJson(){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname","Aymat");
        obj.put("emp_lastname","tata");
        obj.put("emp_middle_name","MS");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","1988-02-28");
        obj.put("emp_status","Employee");
        obj.put("emp_job_title","QA");

        return obj.toString();
    }
    public static String createEmployeeDynamic(String firstName,String lastName, String middleName,
    String gender, String dob, String status, String jobTitle){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", firstName);
        obj.put("emp_lastname", lastName);
        obj.put("emp_middle_name", middleName);
        obj.put("emp_gender", gender);
        obj.put("emp_birthday", dob);
        obj.put("emp_status", status);
        obj.put("emp_job_title", jobTitle);
        return obj.toString();
    }
}