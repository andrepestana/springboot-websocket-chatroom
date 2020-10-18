package io.github.andrepestana.chatroom.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import io.github.andrepestana.chatroom.model.Greeting;
import io.github.andrepestana.chatroom.model.HelloMessage;

@Controller
public class GreetingController {
    @MessageMapping("/hello")
    @SendTo("/topic/chat")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
