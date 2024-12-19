package Desafio.API.config;

import io.restassured.RestAssured;
// import io.restassured.config.RestAssuredConfig;
// import io.restassured.config.ConnectionConfig;
// import io.restassured.config.HttpClientConfig;
import org.junit.jupiter.api.BeforeAll;

public class RestAssuredConfig {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://viacep.com.br/ws";

        // RestAssured.config = RestAssuredConfig.config()
        // .connectionConfig(new ConnectionConfig().closeIdleConnectionsAfterEachResponse())
        // .httpClient(HttpClientConfig.httpClientConfig().setParam("timeout", 5000));
    }
}
