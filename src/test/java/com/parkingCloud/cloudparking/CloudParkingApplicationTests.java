package com.parkingCloud.cloudparking;

import com.parkingCloud.cloudparking.controller.DTO.ParkingCreateDTO;
import com.parkingCloud.cloudparking.controller.DTO.ParkingDTO;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Matches;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CloudParkingApplicationTests {
	@LocalServerPort
	private int randomPort;

	@BeforeEach
	public void setUpTest(){
		RestAssured.port = randomPort;

	}

	@Test
	void whenFindAllThenCheckResult() {
		RestAssured.given()
				.when()
				.get("/AllParking")
				.then()
				.statusCode(200);
	}

	@Test
	void WhenCreateThenCheckIsCreate(){

		ParkingDTO parking = new ParkingDTO();
		parking.setColor("preto");
		parking.setModel("Ford K");
		parking.setState("RS");
		parking.setLicense("MGF-9234");

		RestAssured.given()
				.when()
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.body(parking)
				.post("/AllParking")
				.then()
				.statusCode(HttpStatus.CREATED.value())
				.body("license", Matchers.equalTo( "MGF-9234"))
				.body("state", Matchers.equalTo( "RS"));



	}

}
