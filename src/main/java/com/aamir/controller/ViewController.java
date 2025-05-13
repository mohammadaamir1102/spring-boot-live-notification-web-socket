package com.aamir.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/sender")
    public String senderPage() {
        return "sender";
    }

    @GetMapping("/receiver-one")
    public String receiver1Page() {
        return "receiverOne";
    }

    @GetMapping("/receiver-two")
    public String receiver2Page() {
        return "receiverTwo";
    }
}
