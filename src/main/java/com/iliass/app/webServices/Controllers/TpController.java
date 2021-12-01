package com.iliass.app.webServices.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tps")
public class TpController {
    @GetMapping
    public String helloWorld(){
        return "Hello World";
    }
}
