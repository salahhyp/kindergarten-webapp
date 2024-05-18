package com.daaw.project.Controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "chat"; // Return the name of the HTML file without the extension
    }}
    /*@GetMapping("/track")
    public String track(@RequestParam Long parentId, Model model) {
        model.addAttribute("parentId", parentId);
        return "track";
    }*/
