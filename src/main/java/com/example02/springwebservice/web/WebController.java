package com.example02.springwebservice.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@AllArgsConstructor
public class WebController {

    @GetMapping("/")
    public String main(){
        return "main";
    }
}
