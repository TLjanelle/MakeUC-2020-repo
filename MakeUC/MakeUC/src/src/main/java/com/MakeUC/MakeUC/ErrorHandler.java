package com.MakeUC.MakeUC;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorHandler implements ErrorController {
    @GetMapping("/error")
    public String error() {
        return "Error";
    }
    @Override
    public String getErrorPath() {
        return "/error";
    }
}
