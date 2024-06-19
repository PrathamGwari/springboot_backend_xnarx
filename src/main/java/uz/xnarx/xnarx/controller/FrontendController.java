package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontendController {
    @RequestMapping(value = "/{path:[^\\.]*}")
    public String redirect() {
        // Forward to the index.html to handle client-side routing
        return "forward:/index.html";
    }
}
