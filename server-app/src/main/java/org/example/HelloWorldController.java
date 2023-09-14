package org.example;

import com.cboe.clear.example.server.hello.world.api.HelloWorldApi;
import com.cboe.clear.example.server.hello.world.model.HelloWorld;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class HelloWorldController implements HelloWorldApi {
    @Override
    public ResponseEntity<HelloWorld> sayHello(String name) {
        return ResponseEntity.ok(new HelloWorld().name(name));
    }
}
