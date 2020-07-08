package com.udacity.jwdnd.c1.review.controller;

import com.udacity.jwdnd.c1.review.model.MessageForm;
import com.udacity.jwdnd.c1.review.service.MessageListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private MessageListService messageListService;

    public HomeController(MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    @GetMapping("/home")
    public String getHomePage(@ModelAttribute("newMessage") MessageForm newMessage, Model model) {
        model.addAttribute("greetings", this.messageListService.getMessages());

        return "home";
    }

    @PostMapping("/home")
    public String addMessage(@ModelAttribute("newMessage") MessageForm newMessage, Model model) {
        messageListService.addMessage(newMessage.getText());
        model.addAttribute("greetings", messageListService.getMessages());
        newMessage.setText("");
        return "home";
    }



}
