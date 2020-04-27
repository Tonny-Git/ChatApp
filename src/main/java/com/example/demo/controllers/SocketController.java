package com.example.demo.controllers;

import com.example.demo.services.MessageService;
import com.example.demo.services.SocketService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

@Controller
public class SocketController extends TextWebSocketHandler {

    Gson gson = new Gson();

    @Autowired
    MessageService messageService;

    // NOTE: Can not use @Autowired here due to WebSocketConfig instantiating the SocketController
    private SocketService socketService;
    public void setSocketService(SocketService socketService) {
        this.socketService = socketService;
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        System.out.println("Received msg: " + message.getPayload());

        //Socket socket = gson.fromJson(message.getPayload(), com.example.demo.entities.Socket.class);
        //System.out.println("Action: " + socket.getAction());
        //System.out.println("Message: " + socket.getMessage());
        //System.out.println("Timestamp: " + socket.getTimestamp());

        //socketService.sendToAll(socket, Socket.class);

        //socketService.sendToAll("Hello " + message.getPayload());

        //Working on message websocket here
        //MessageExample messageExample = gson.fromJson(message.getPayload(), MessageExample.class);
        //ArrayList<Message> namedMessage = new ArrayList<>();
        //namedMessage.add(messageExample.getMessage());
        //Message fixedMessage =  messageService.addSenderName(namedMessage).get(0);
        //messageExample.setMessage(fixedMessage);

        //socketService.sendToAll(messageExample, MessageExample.class);


        // Example with a generic Map instead of converting the JSON to a specific class
        // Map keysAndValues = new Gson().fromJson(message.getPayload(), Map.class);
        // Get the value of a key named "firstname"
        // String firstname = keysAndValues.get("firstname");
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        socketService.addSession(session);;
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        socketService.removeSession(session);
    }
}
