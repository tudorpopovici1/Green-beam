package server.controller;

import server.model.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class GreetingController {


    private static final String template = "Hello, %s!";

    private long counter = 0;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="Nume") String name)
    {
        return new Greeting(counter++, String.format(template, name));
    }

}
