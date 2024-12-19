package Desafio.API.tests;

import Desafio.API.config.RestAssuredConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ViaCepTest extends RestAssuredConfig {

    @BeforeAll
    public static void setUp() {
        RestAssuredConfig.setUp();
    }

    @Test
    public void testCepValido() {
        String cep = "01001000";

        Response response = RestAssured
                .given()
                .pathParam("cep", cep)
                .when()
                .get("/{cep}/json/")
                .then()
                .statusCode(200)
                .extract()
                .response();


        assertNotNull(response.jsonPath().getString("logradouro"));
        assertNotNull(response.jsonPath().getString("bairro"));


        assertTrue(response.jsonPath().getString("logradouro").contains("Praça"));
        assertTrue(response.jsonPath().getString("bairro").contains("Sé"));
    }


    @Test
    public void testCepInvalido() {

        String cep = "00000000";


        Response response = RestAssured
                .given()
                .pathParam("cep", cep)
                .when()
                .get("/{cep}/json/")
                .then()
                .statusCode(200)
                .extract()
                .response();


        assertEquals("[]", response.asString());
    }
}
