package com.example.Programmeringsuppgift;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IsbnController {


    @Autowired
    ISBN isbn;

    @Autowired
    IsbnService service;



    @GetMapping("/")
    public String ShowAnswer(Model model) {
       /* String isbn = "123456789X";
        service.validateIsbn(isbn);*/
        return "home";
    }

    @PostMapping("/")
    public String sendForm(Model model, @RequestParam String isbn) {

        String answer;

        answer = service.validateIsbn(isbn);


        model.addAttribute("answer", answer);






        return "home";
    }

}
