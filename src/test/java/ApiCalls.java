import org.testng.annotations.Test;

import com.trello.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class ApiCalls extends TestBase{
	
	public ApiCalls(){
		super();
	}

	@Test
	public void createBoard(){
		
		/*given()
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.queryParam("key", prop.getProperty("apiKey"))
			.queryParam("token", prop.getProperty("token"))
			.queryParam("name", "Test")
		.when()
			.baseUri(prop.getProperty("baseUrl"))
			.basePath("1/boards/")
			.post()
		.then()
			.log().all();*/
		
		baseURI = prop.getProperty("baseUrl");
		
		RequestSpecification request = RestAssured.given();
		
		RequestSpecification response = request.accept(ContentType.JSON).
												contentType(ContentType.JSON).
												queryParam("key", prop.getProperty("apiKey")).
												queryParam("token", prop.getProperty("token")).
												queryParam("name", "Test3");
		
		Response postResponse= response.baseUri(prop.getProperty("baseUrl"))
										.basePath("1/boards/")
										.post();
		
		String jsonString = postResponse.asString();
		System.out.println(jsonString);
		String boardId = postResponse.jsonPath().get("id");
		System.out.println(boardId);
		 System.out.println(postResponse.getStatusCode()); 
	}
	
	
	
	
}
