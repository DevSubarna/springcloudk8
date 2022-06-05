package com.example.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PaymentApplication {

    @GetMapping("/message")
    public String displayMessage(){
        return "Congratulation you payment successfully deployed your application to kubernetes !!";
    }

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }
}
