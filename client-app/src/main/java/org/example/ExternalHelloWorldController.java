package org.example;

import com.cboe.clear.example.client.hello.world.api.HelloWorldApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExternalHelloWorldController {
    private final HelloWorldApi helloWorldApi;

    @Autowired
    public ExternalHelloWorldController(HelloWorldApi helloWorldApi) {
        this.helloWorldApi = helloWorldApi;
        var apiClient = this.helloWorldApi
                .getApiClient()
                .setBasePath("http://localhost:9000");
        this.helloWorldApi.setApiClient(apiClient);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/hello"
    )
    public ResponseEntity<String> getHelloName() {
        return ResponseEntity.ok(
                helloWorldApi.sayHello("Bob").getName()
        );
    }
}
