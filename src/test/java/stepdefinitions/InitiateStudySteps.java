//package stepdefinitions;
//
//import com.sogeti.automation.framework.constants.AppConstants.Api;
//import com.sogeti.automation.framework.constants.AppConstants.Api.AuthenticationType;
//import com.sogeti.automation.framework.utils.APIUtils;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import org.apache.logging.log4j.ThreadContext;
//import org.apache.xmlbeans.impl.xpath.XPath;
//import org.apache.xmlbeans.impl.xpath.XPathFactory;
//import org.json.JSONObject;
//import org.testng.Assert;
//import org.testng.asserts.SoftAssert;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//
//import java.io.ByteArrayInputStream;
//import java.io.StringWriter;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import javax.xml.xpath.XPathConstants;

package stepdefinitions;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.ThreadContext;
import org.testng.Assert;

import com.sogeti.automation.framework.basetest.TestContext;
import com.sogeti.automation.framework.constants.AppConstants.Web;
import com.sogeti.automation.framework.utils.PropertyReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import com.sogeti.automation.test.pageFactory.InitiateStudyPage;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import utils.StudyIdStore;

public class InitiateStudySteps {

    //private static final String DB_URL = "jdbc:sqlserver://YVAV2750\\SQLI01;databaseName=OSCSQ01;encrypt=true;trustServerCertificate=true";
    private static final String DB_URL = "jdbc:sqlserver://YVAV2750\\SQLI01;databaseName=" + PropertyReader.getFieldValue("DB_NAME") + ";encrypt=true;trustServerCertificate=true";
    private static final String DB_USER = "contribsqlpprod";
    private static final String DB_PASS = "123456";
    
    // OLD (hardcoded): private static final String BASE_URL = "https://ws.contribfs.citroen.preprod.inetpsa.com";
    // OLD (hardcoded): private static final String BASE_URL = "https://ws.contribfs.peugeot.preprod.inetpsa.com";
    // NEW: Brand-driven URL - reads Brand from qa.properties
    private static final String BASE_URL = resolveBaseUrl();

    private static String resolveBaseUrl() {
        String brand = Web.Brand.toUpperCase();
        switch (brand) {
            case "PEUGEOT":          return "https://ws.contribfs.peugeot.preprod.inetpsa.com";
            case "OPEL":             return "https://ws.contribfs.opel.preprod.inetpsa.com";
            case "FIAT":             return "https://ws.contribfs.fiat.preprod.inetpsa.com";
            case "CITROEN":
            default:                 return "https://ws.contribfs.citroen.preprod.inetpsa.com";
        }
    }
    // Replace with exact SOAPAction from WSDL if required

    private Connection connection;
    private Exception connectionException;
    private List<Map<String, String>> queryResultsList;
    private String xmlRequestBody;
    private String xmlRequestBody2; 
    private Response apiResponse2;
    private Response apiResponse;
    private String xmlRequestBody3;
    private Response apiResponse3;
    
    //Citroen 
   private static final String SOAP_ACTION ="http://xmldefs.bcpraha.com/Customer/Psa/Ppas4Pms/v1/pamInitiateProfitabilityStudy";
   private static final String SOAP_ACTION1 ="http://xmldefs.bcpraha.com/Customer/Psa/Ppas4Pms/v1/pamGetProfitabilityStudyDealSheetData";
    
    // PEUGEOT
   // private static final String SOAP_ACTION ="http://xmldefs.bcpraha.com/Customer/Psa/Ppas4Pms/v1/pamInitiateProfitabilityStudy";
    //private static final String SOAP_ACTION1 ="http://xmldefs.bcpraha.com/Customer/Psa/Ppas4Pms/v1/pamGetProfitabilityStudyDealSheetData";
    
    public String studyId;
    private String xmlRequestFilePath;
    
    TestContext testContext;
    InitiateStudyPage initiateStudyPage;

    public InitiateStudySteps(TestContext context) throws Exception {
        this.testContext = context;
        initiateStudyPage = testContext.getPageObjectManager().getinitiateStudy();
        ThreadContext.pop();
        ThreadContext.push(this.getClass().getSimpleName());
    }

    @Given("Validate database credentials")
    public void validate_database_credentials() {
        System.out.println("Database credentials initialized");
        System.out.println("DB URL: " + DB_URL);
        System.out.println("DB User: " + DB_USER);
    }

    @When("Establish a connection to the OSCQTZV database")
    public void establish_a_connection_to_database() {
        try {
            connectionException = null;
            System.out.println("Attempting to connect to database: " + DB_URL);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("Connection established successfully");
        } catch (Exception e) {
            connectionException = e;
            System.err.println("Connection failed: " + e.getMessage());
        }
    }


    @And("Execute a query to fetch LCDV, CAR MODEL NAME, CAR MODEL RANGE, MARKET ID")
    public void execute_a_query_to_fetch_lcdv_car_model_name_car_model_range_and_market_id() throws SQLException {
        final String query =
                "SELECT TOP (10)\r\n"
                + "    YV.YV_CODE_LCDV AS LCDV,\r\n"
                + "    YF.YF_LIB_FAMILLE AS CAR_MODEL_NAME,\r\n"
                + "    YV.YV_CODE_FAMILLE AS CAR_MODEL_RANGE,\r\n"
                + "    YV.YV_ID_PAYS AS MARKET_ID\r\n"
                + "FROM OSCQTYV YV\r\n"
                + "INNER JOIN OSCQTYF YF\r\n"
                + "    ON YF.YF_ID_PAYS = YV.YV_ID_PAYS\r\n"
                + "    AND YF.YF_CODE_FAMILLE = YV.YV_CODE_FAMILLE\r\n"
                + "INNER JOIN OSCQTZV ZV\r\n"
                + "    ON ZV.ZV_CODE_LCDV = YV.YV_CODE_LCDV\r\n"
                // OLD (hardcoded): + "WHERE YV.YV_CODE_LCDV='1CK9K0PL5KB0A070'"
                // NEW: reads LCDV_CODE from qa.properties
                + "WHERE YV.YV_CODE_LCDV='" + PropertyReader.getFieldValue("LCDV_CODE") + "'";
                 
//                 "SELECT TOP (100)\r\n"
//                 + "    YV.YV_CODE_LCDV AS LCDV,\r\n"
//                 + "    YF.YF_LIB_FAMILLE AS CAR_MODEL_NAME,\r\n"
//                 + "    YV.YV_CODE_FAMILLE AS CAR_MODEL_RANGE,\r\n"
//                 + "    YV.YV_ID_PAYS AS MARKET_ID\r\n"
//                 + "FROM OSCQTYV YV\r\n"
//                 + "INNER JOIN OSCQTYF YF\r\n"
//                 + "    ON YF.YF_ID_PAYS = YV.YV_ID_PAYS\r\n"
//                 + "    AND YF.YF_CODE_FAMILLE = YV.YV_CODE_FAMILLE\r\n"
//                 + "INNER JOIN OSCQTZV ZV\r\n"
//                 + "    ON ZV.ZV_CODE_LCDV = YV.YV_CODE_LCDV\r\n"
//                 + "where YV.YV_ID_PAYS = 'GB'\r\n"
//                 + "AND YV.YV_CODE_LCDV = '1PK9CLTZIFB0A070'";
//       
        queryResultsList = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                Map<String, String> row = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.put(metaData.getColumnLabel(i), rs.getString(i));
                }
                queryResultsList.add(row);
            }
        }

        if (queryResultsList.isEmpty()) {
            throw new SQLException("No data found for query");
        }

        System.out.println("Query result: " + queryResultsList);
        System.out.println("Query executed successfully");
    }


    @Then("the connection should be successful")
    public void the_connection_should_be_successful() {
        assert connectionException == null : "Connection failed: " + connectionException.getMessage();
        assert connection != null : "Connection object is null";
        System.out.println("✓ Database connection successful");
    }

    @And("the query results should be returned")
    public void the_query_results_should_be_returned() {
        assert queryResultsList != null && !queryResultsList.isEmpty() : "No DB results returned";
        System.out.println("✓ Query results retrieved: " + queryResultsList.size() + " rows");
    }

    @And("the results should be printed to the console")
    public void the_results_should_be_printed_to_the_console() {
        System.out.println("\n========== Query Results ==========");
        queryResultsList.forEach(row -> {
            row.forEach((k, v) -> System.out.println(k + " : " + v));
            System.out.println("-----------------------------------");
        });
        System.out.println("===================================\n");
    }

    @Given("The XML request file {string}")
    public void the_xml_request_file(String filePath) throws Exception {
        xmlRequestFilePath = filePath;
        xmlRequestBody = Files.readString(Paths.get(filePath), StandardCharsets.UTF_8);
        System.out.println("XML request loaded from: " + filePath);
    }

    @And("update XML field {string} with first DB value from column {string}")
    public void update_xml_field_with_first_db_value_from_column(String fieldOrXPath, String columnName) {
        String value = getFirstDbValue(columnName);
        updateXmlTagValue(fieldOrXPath, value);
    }

    @And("update XML field {string} with DB columns {string},{string} in format {string}")
    public void update_xml_field_with_db_columns_in_format(String fieldOrXPath, String col1, String col2, String format) {
        String v1 = getFirstDbValue(col1);
        String v2 = getFirstDbValue(col2);
        String combined = format.replace("{0}", v1).replace("{1}", v2);
        System.out.println("Combined value: " + combined);
        updateXmlTagValue(fieldOrXPath, combined);
    }

    @And("update XML field {string} with property {string}")
    public void update_xml_field_with_property(String fieldOrXPath, String propertyKey) {
        String value = PropertyReader.getFieldValue(propertyKey).trim();
        updateXmlTagValue(fieldOrXPath, value);
    }
    
    @And("set start date to {string}-{string}-{string}")
    public void set_start_date_to(String year, String month, String day) {
        updateXmlTagByOccurrence("year", 1, year);
        updateXmlTagByOccurrence("month", 1, month);
        updateXmlTagByOccurrence("day", 1, day);
    }
    
    @And("update second XML field {string} with property {string}")
    public void update_second_xml_field_with_property(String fieldOrXPath, String propertyKey) {
        String value = PropertyReader.getFieldValue(propertyKey).trim();
        String tagName = normalizeTagName(fieldOrXPath);
        String regex = "(<(?:\\w+:)?" + Pattern.quote(tagName) + "\\b[^>]*>)([\\s\\S]*?)(</(?:\\w+:)?" + Pattern.quote(tagName) + ">)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(xmlRequestBody2);
        if (!m.find()) throw new RuntimeException("Tag '" + tagName + "' not found in second XML");
        StringBuffer sb = new StringBuffer();
        m.appendReplacement(sb, Matcher.quoteReplacement(m.group(1) + value + m.group(3)));
        m.appendTail(sb);
        xmlRequestBody2 = sb.toString();
        System.out.println("✓ Updated second XML tag: " + tagName + " = " + value);
    }

    @And("set end date to {string}-{string}-{string}")
    public void set_end_date_to(String year, String month, String day) {
        updateXmlTagByOccurrence("year", 2, year);
        updateXmlTagByOccurrence("month", 2, month);
        updateXmlTagByOccurrence("day", 2, day);
    }

    @When("send a POST request to {string}")
    public void send_a_post_request_to(String endpoint) {
        apiResponse = RestAssured.given()
            .baseUri(BASE_URL)
            .header("Content-Type", "text/xml; charset=utf-8")
            .header("SOAPAction", SOAP_ACTION)
            .body(xmlRequestBody)
            .log().all()
            .when()
            .post(endpoint)
            .then()
            .log().all()
            .extract().response();

        System.out.println("API Response saved");
    }

    @Then("the API response status code should be {int}")
    public void the_api_response_status_code_should_be(Integer expectedStatusCode) {
        Assert.assertEquals(apiResponse.getStatusCode(), expectedStatusCode.intValue(), "Status code mismatch");
        System.out.println("✓ Status code verified: " + expectedStatusCode);
    }

    @And("save the API response")
    public void save_the_api_response() throws IOException {
        System.out.println("\n========== API Response ==========");
        System.out.println(apiResponse.getBody().asString());
        System.out.println("==================================\n");
        String xml = apiResponse.getBody().asString();
        XmlPath xp = new XmlPath(xml);

        // Namespace-safe extraction using node name
        studyId = xp.getString("**.find { it.name() == 'studyId' }");
        if (studyId == null || studyId.trim().isEmpty()) {
            throw new RuntimeException("studyId not found in API response");
        }
        
        System.out.println("Extracted studyId: " + studyId);
        StudyIdStore.set(studyId);
        // save UPDATED request XML back to same file
        if (xmlRequestFilePath != null && xmlRequestBody != null) {
            Files.writeString(
                Path.of(xmlRequestFilePath),
                xmlRequestBody,
                StandardCharsets.UTF_8,
                StandardOpenOption.TRUNCATE_EXISTING
            );
            System.out.println("Updated request XML saved to: " + xmlRequestFilePath);
        }
    }

    
    @And("the database connection should be closed")
    public void the_database_connection_should_be_closed() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("✓ Database connection closed");
            }
        } catch (SQLException e) {
            System.err.println("Error closing DB connection: " + e.getMessage());
        }
    }
    
  //2nd xml changes  
    @Given("I have the second XML request file {string}")
    public void i_have_the_second_xml_request_file(String filePath) throws Exception {
        xmlRequestFilePath = filePath;
        xmlRequestBody2 = Files.readString(Paths.get(filePath), StandardCharsets.UTF_8);
        System.out.println("Second XML request loaded from: " + filePath);
    }

    @And("I update second XML field {string} with extracted studyId")
    public void i_update_second_xml_field_with_extracted_study_id(String fieldOrXPath) {
        if (studyId == null || studyId.trim().isEmpty()) {
            studyId = StudyIdStore.get(); // <-- LOAD from shared store
            System.out.println("studyId from xml2: "+studyId);

        }

        String tagName = normalizeTagName(fieldOrXPath);
        String regex = "(<(?:\\w+:)?" + Pattern.quote(tagName) + "\\b[^>]*>)([\\s\\S]*?)(</(?:\\w+:)?" + Pattern.quote(tagName) + ">)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(xmlRequestBody2);


        if (!m.find()) {
            throw new RuntimeException("Tag '" + tagName + "' not found in second XML");
        }

        StringBuffer sb = new StringBuffer();
        m.appendReplacement(sb, Matcher.quoteReplacement(m.group(1) + studyId + m.group(3)));
        m.appendTail(sb);
        xmlRequestBody2 = sb.toString();
        System.out.println("✓ Updated second XML tag: " + tagName + " = " + studyId);
    }

    @When("I send a POST request with second XML to {string}")
    public void i_send_a_post_request_with_second_xml_to(String endpoint) {
        apiResponse2 = RestAssured.given()
            .baseUri(BASE_URL)
            .header("Content-Type", "text/xml; charset=utf-8")
            .header("SOAPAction", SOAP_ACTION1)
            .body(xmlRequestBody2)
            .log().all()
            .when()
            .post(endpoint)
            .then()
            .log().all()
            .extract().response();

        System.out.println("Second API Response saved");
    }

    @Then("the second API response status code should be {int}")
    public void the_second_api_response_status_code_should_be(Integer expectedStatusCode) {
        Assert.assertEquals(apiResponse2.getStatusCode(), expectedStatusCode.intValue(),
                "Second API status code mismatch");
        System.out.println("✓ Second API status code verified: " + expectedStatusCode);
    }
    @Then("the second API response should be successful")
    public void the_second_api_response_should_be_successful() {
        String xml = apiResponse2.getBody().asString();

        // fail if backend returned error block
        Assert.assertFalse(xml.contains("studyDealSheetDataErrors"),
                "Second API returned error block: " + xml);

        System.out.println("✓ Second API success block returned");
    }
    @And("the second API response should contain error code {string}")
    public void the_second_api_response_should_contain_error_code(String expectedCode) {
        String xml = apiResponse2.getBody().asString();
        XmlPath xp = new XmlPath(xml);

        String code = xp.getString("**.find { it.name() == 'code' }");
        Assert.assertEquals(code, expectedCode, "Second API error code mismatch");

        System.out.println("✓ Second API error code verified: " + expectedCode);
    }

    @And("the second API response should contain error description {string}")
    public void the_second_api_response_should_contain_error_description(String expectedText) {
        String xml = apiResponse2.getBody().asString();
        XmlPath xp = new XmlPath(xml);

        String desc = xp.getString("**.find { it.name() == 'description' }");
        Assert.assertTrue(desc != null && desc.contains(expectedText),
                "Second API error description mismatch");

        System.out.println("✓ Second API error description verified");
    }
    @And("I save the second API response")
    public void i_save_the_second_api_response() throws IOException {
        System.out.println("\n========== Second API Response ==========");
        System.out.println(apiResponse2.getBody().asString());
        System.out.println("=========================================\n");
   
        if (xmlRequestFilePath != null && xmlRequestBody != null) {
            Files.writeString(
                Path.of(xmlRequestFilePath),
                xmlRequestBody2,
                StandardCharsets.UTF_8,
                StandardOpenOption.TRUNCATE_EXISTING
            );
            System.out.println("Updated request XML saved to: " + xmlRequestFilePath);
        }
    }


    //3rd xml changes
    @Given("I have the third XML request file {string}")
    public void i_have_the_third_xml_request_file(String filePath) throws Exception {
        xmlRequestFilePath = filePath; // store path
        xmlRequestBody3 = Files.readString(Paths.get(filePath), StandardCharsets.UTF_8);
        System.out.println("Third XML request loaded from: " + filePath);
    }

    @And("I update third XML field {string} with extracted studyId")
    public void i_update_third_xml_field_with_extracted_study_id(String fieldOrXPath) {
        if (studyId == null || studyId.trim().isEmpty()) {
            studyId = StudyIdStore.get();
            System.out.println("studyId from xml3: "+studyId);
        }

        String tagName = normalizeTagName(fieldOrXPath);
        String regex = "(<(?:\\w+:)?" + Pattern.quote(tagName) + "\\b[^>]*>)([\\s\\S]*?)(</(?:\\w+:)?" + Pattern.quote(tagName) + ">)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(xmlRequestBody3);

        if (!m.find()) {
            throw new RuntimeException("Tag '" + tagName + "' not found in third XML");
        }

        StringBuffer sb = new StringBuffer();
        m.appendReplacement(sb, Matcher.quoteReplacement(m.group(1) + studyId + m.group(3)));
        m.appendTail(sb);
        xmlRequestBody3 = sb.toString();
        System.out.println("✓ Updated third XML tag: " + tagName + " = " + studyId);
    }

    @When("I send a POST request with third XML to {string}")
    public void i_send_a_post_request_with_third_xml_to(String endpoint) {
        apiResponse3 = RestAssured.given()
            .baseUri(BASE_URL)
            .header("Content-Type", "text/xml; charset=utf-8")
            .body(xmlRequestBody3)
            .log().all()
            .when()
            .post(endpoint)
            .then()
            .log().all()
            .extract().response();

        System.out.println("Third API Response saved");
    }

    @Then("the third API response status code should be {int}")
    public void the_third_api_response_status_code_should_be(Integer expectedStatusCode) {
        Assert.assertEquals(apiResponse3.getStatusCode(), expectedStatusCode.intValue(),
                "Third API status code mismatch");
        System.out.println("✓ Third API status code verified: " + expectedStatusCode);
    }
    @And("I save the third API response")
    public void i_save_the_third_api_response() throws IOException {
        System.out.println("\n========== Third API Response ==========");
        System.out.println(apiResponse3.getBody().asString());
        System.out.println("========================================\n");
    
        if (xmlRequestFilePath != null && xmlRequestBody != null) {
            Files.writeString(
                Path.of(xmlRequestFilePath),
                xmlRequestBody3,
                StandardCharsets.UTF_8,
                StandardOpenOption.TRUNCATE_EXISTING
            );
            System.out.println("Updated request XML saved to: " + xmlRequestFilePath);
        }
    }
    
    // ---------- Helpers ----------

    private String getFirstDbValue(String columnName) {
        if (queryResultsList == null || queryResultsList.isEmpty()) {
            throw new RuntimeException("No DB results available. Execute query first.");
        }

        Map<String, String> firstRow = queryResultsList.get(0);

        // direct lookup
        String value = firstRow.get(columnName);

        // case-insensitive lookup
        if (value == null) {
            for (Map.Entry<String, String> e : firstRow.entrySet()) {
                if (e.getKey().equalsIgnoreCase(columnName)) {
                    value = e.getValue();
                    break;
                }
            }
        }

        // compatibility mapping: old DB names -> current aliases
        if (value == null) {
            Map<String, String> compat = Map.of(
                "YF_LIB_FAMILLE", "CAR_MODEL_NAME",
                "YV_CODE_FAMILLE", "CAR_MODEL_RANGE",
                "YF_CODE_FAMILLE", "CAR_MODEL_RANGE",
                "YV_CODE_LCDV", "LCDV",
                "YV_ID_PAYS", "MARKET_ID"
            );
            String mapped = compat.get(columnName.toUpperCase());
            if (mapped != null) {
                value = firstRow.get(mapped);
            }
        }

        if (value == null) {
            throw new RuntimeException("Column '" + columnName + "' not found in DB results. Available: " + firstRow.keySet());
        }
        return value;
    }

    private String normalizeTagName(String fieldOrXPath) {
        // Supports both: "carModelName" and "//*[local-name()='carModelName']"
        Matcher m = Pattern.compile("local-name\\(\\)='([^']+)'").matcher(fieldOrXPath);
        return m.find() ? m.group(1) : fieldOrXPath;
    }

    private void updateXmlTagValue(String fieldOrXPath, String newValue) {
        String tagName = normalizeTagName(fieldOrXPath);

        // Supports namespaced and non-namespaced tags:
        // <carModelName>...</carModelName> OR <ns10:carModelName>...</ns10:carModelName>
        String regex = "(<(?:\\w+:)?" + Pattern.quote(tagName) + "\\b[^>]*>)([\\s\\S]*?)(</(?:\\w+:)?" + Pattern.quote(tagName) + ">)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(xmlRequestBody);

        if (!m.find()) {
            throw new RuntimeException("Tag '" + tagName + "' not found in XML");
        }

        StringBuffer sb = new StringBuffer();
        m.appendReplacement(sb, Matcher.quoteReplacement(m.group(1) + newValue + m.group(3)));
        m.appendTail(sb);
        xmlRequestBody = sb.toString();

        System.out.println("✓ Updated XML tag: " + tagName + " = " + newValue);
    }

    private void updateXmlTagByOccurrence(String tagName, int occurrence, String newValue) {
        String regex = "(<(?:\\w+:)?" + Pattern.quote(tagName) + "\\b[^>]*>)([\\s\\S]*?)(</(?:\\w+:)?" + Pattern.quote(tagName) + ">)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(xmlRequestBody);

        StringBuffer sb = new StringBuffer();
        int count = 0;
        boolean updated = false;

        while (m.find()) {
            count++;
            if (count == occurrence) {
                m.appendReplacement(sb, Matcher.quoteReplacement(m.group(1) + newValue + m.group(3)));
                updated = true;
            } else {
                m.appendReplacement(sb, Matcher.quoteReplacement(m.group(0)));
            }
        }
        m.appendTail(sb);

        if (!updated) {
            throw new RuntimeException("Tag '" + tagName + "' occurrence " + occurrence + " not found in XML");
        }

        xmlRequestBody = sb.toString();
        System.out.println("✓ Updated " + tagName + " occurrence " + occurrence + " = " + newValue);
    }
      
    
  //  ------------------------------------------UI Part-----------------------------------------------
  //added method for initiatStudy api
    
    //added method for initiatStudy api
  
    
    @When("user click on brand")
    public void user_click_on_brand() throws Exception {
        initiateStudyPage.verifyHomePageBrand();

    }
   
    
    
  @Given("user navigate to profatibility tab")
  public void user_navigate_to_profatibility_tab() throws Exception {
      initiateStudyPage.ContribPStab();
  }
  
  @When("user click on search tab")
  public void user_click_on_search_tab() throws Exception {
      initiateStudyPage.ContriSearchTab();
  }
  
  @Then("user click on quick step")
  public void user_click_on_quick_step() throws Exception {
     
      studyId = StudyIdStore.get(); // <-- LOAD from shared store
      System.out.println("value of studyId: "+studyId);
      initiateStudyPage.QuickSearchTabdelete(studyId);
  }
}