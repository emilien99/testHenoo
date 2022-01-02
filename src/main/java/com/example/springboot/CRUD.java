package com.example.springboot;

import java.util.*;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class CRUD {

    @GetMapping("/accueil")
    public String accueil() {
        return "accueil";
    }
    @GetMapping("/affichage")
    public String affichage() {
        return "affichage";
    }
}
