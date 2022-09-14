package de.neuefische.hhjava222helloworld.controller;

import de.neuefische.hhjava222helloworld.service.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingsController {

    private GreetingsService greetingsService;

    String name = "";

    @Autowired
    public GreetingsController(GreetingsService greetingsService){
        this.greetingsService = greetingsService;
    }

    @GetMapping
    public String sayHello(){
        return greetingsService.greetingsService();
    }

    @GetMapping("/en")
    public String sayHello2(){
        return "Hellooooo";
    }

    @GetMapping(path = "{name}")
    public String sayHello3(@PathVariable String name, @RequestParam String q){
        return q + " " + name;
    }

    @PostMapping
    public String postName(@RequestBody String newName){
        name = newName;
        return "Name was updated to " + name;
    }


}
