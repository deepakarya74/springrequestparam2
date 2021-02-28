package com.aryaspring.example.HelloWorldApplication02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldExm02 {

    @GetMapping(value = "/app/v1/msg")
    public String greeting(){
        return "Hello World";
    }

    //With requestparam
    @GetMapping(value = "/app/v1/person")
    public String getName(@RequestParam(value = "name",defaultValue = "blank",required = false) String name, @RequestParam String age){
        return "My name is " + name + " and age is " + age;
    }

    //Using object example, without requestParam
    @GetMapping(value = "/app/v1/personobject")
    public String getNameUsingPojo(Person newPerson){
        return "My name is " + newPerson.getName()+ "and age is " + newPerson.getAge();
    }

    //Pass array or list as RequestParam
    @GetMapping(value="app/v1/list")
    public StringBuilder getListOfPoeple(@RequestParam String[] name){
        StringBuilder builder = new StringBuilder("List of People:");
        for(String i: name){
         builder.append(i);
        }
    return builder;
    }
}
