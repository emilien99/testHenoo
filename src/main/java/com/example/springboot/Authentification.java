package com.example.springboot;

import java.util.*;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class Authentification {

    @GetMapping("/")
    public String index() {
        return "bienvenue";
    }
    @GetMapping("/inscription")
    public String inscription() {
        return "inscription";
    }
    @PostMapping("/accueil")
    public String inscriptionCorrecte(@RequestParam("user") String user, @RequestParam("password") String password, ModelMap modelMap) {
        modelMap.put("user",user);
        modelMap.put("password",password);
        return "inscriptionCorrect";
    }

    @GetMapping("/connexion")
    public String connexion() {
        return "Connexion";
    }

}
