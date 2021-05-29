package com.stranglemoon.stranglemoon.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
public class AccountController {

    @GetMapping("/auth") // remplacer par un mdp et username qui renverra un token adapté.
    public String returnToken() {
        return  "45678";
    }

    //exemple ou on reprend le body :
    //@PostMapping("/postbody")
    //public String postBody(@RequestBody String fullName) {
    //  return "Hello " + fullName;
    //}

}
