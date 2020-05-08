package duarte.wesley.banda.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HelloWorldController {

    @GetMapping("/")
    public String index() { return "Seja Bem Vindo";}
}
