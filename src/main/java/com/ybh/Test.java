package com.ybh;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class Test{
    
    @RequestMapping("/hello")
    private String Index(){
        
        return "ok";
    }
    
}