package com.example.Frontend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/frontend")
public class MyWebService {

    @Value("${backEndURL}")
    private String backEndURL;

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/bonjour")
    public String hello() {
        try {
            String backendResponse = restTemplate.getForObject(backEndURL + "/bonjour", String.class);
            return "Hello (from the front end) - " + backendResponse + " (from the back end)";
        } catch (Exception e) {
            return "Erreur: " + e.getMessage();
        }
    }

    @GetMapping("/cars")
    public Object getCars() {
        return restTemplate.getForObject(backEndURL + "/cars", Object.class);
    }

    @GetMapping("/motos")
    public Object getMotos() {
        return restTemplate.getForObject(backEndURL + "/motos", Object.class);
    }

    @GetMapping("/cars/{id}") 
    public Object getCarById(@PathVariable("id") int id) {
        return restTemplate.getForObject(backEndURL + "/cars/" + id, Object.class);
    }
    
    @GetMapping("/motos/{id}")
    public Object getMotoById(@PathVariable("id") int id) {
        return restTemplate.getForObject(backEndURL + "/motos/" + id, Object.class);
    }

}
