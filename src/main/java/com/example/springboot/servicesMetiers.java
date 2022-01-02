package com.example.springboot;

import java.util.*;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

public class servicesMetiers {

    @GetMapping("/recherche")
    public String recherche() {
        return "recherche";
    }

    @GetMapping("/recherche/resultats")
    public String resultats() {
        return "resultats";
    }

}
