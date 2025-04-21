package com.example.education.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HeadersController {

    @GetMapping("/headers")
    public String ShowHeaders(HttpServletRequest request, Model model){
        Map<String, String> headers = new HashMap<>();
        Enumeration<String> headersNames = request.getHeaderNames();

        while (headersNames.hasMoreElements()){
            String headerName = headersNames.nextElement();
            String headerValue = request.getHeader(headerName);
            headers.put(headerName, headerValue);
        }

        model.addAttribute("headers", headers);
        return "headers";
    }

}
