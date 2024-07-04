package com.enigma.tokonyadia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {
    @GetMapping
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/hobbies")
    public String[] getHobbies() {
        return new String[]{"Tidur", "Ibadah"};
    }

    @GetMapping("/person")
    public Map<String, Object> getPerson() {
        Map<String, Object> person = new HashMap<>();
        person.put("name", "Vhierdy");
        person.put("age", 22);
        person.put("is_married", false);

        String[] hobbies = new String[]{"Tidur", "Ibadah"};
        person.put("Hobbies", hobbies);

        Map<String, String> address = new HashMap<>();
        address.put("rt", "08");
        address.put("rw", "04");
        address.put("street", "Jl. H Dahlan");
        person.put("address", address);

        return person;
    }

    // Path Variabel
    // Cara 1 : kalo nama path di getMapping dengan di parameter beda, kita dapat menyamakan menggunakan (name = "id")
    @GetMapping("/person/{id}")
    public String getPersonById(@PathVariable(name = "id") String personId){
        return "Person " + personId;
    }
    // Cara 2
    /*@GetMapping("/person/{id}")
    public String getPersonById(@PathVariable String id) {
        return "Person " + id;
    }*/

    // ParamMethod
    // required false = tidak wajib, default value kalo nama dan price gadiisi
    /*@GetMapping("/products")
    public String getProductByNameAndPrice(
            @RequestParam(required = false, defaultValue = "Baju") String name,
            @RequestParam(required = false, defaultValue = "10000") Integer price) {
        return name + " : " + price;
    }*/

    /*// Cara 2 untuk memfilter tanpa menggunakan nilai default
    @GetMapping("/products")
    public String getProductByNameAndPrice(@RequestParam String name, @RequestParam Integer price) {
        return name + " : " + price;
    }*/


}
