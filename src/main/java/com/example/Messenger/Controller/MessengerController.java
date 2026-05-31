package com.example.Messenger.Controller;

import com.example.Messenger.Model.Message;
import com.example.Messenger.Service.MessageService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessengerController {

    private MessageService messageService;
    public MessengerController(MessageService messageService){
        this.messageService=messageService;
    }


    @GetMapping("/get")
    public ResponseEntity<?> getAllMessage(){
       List <Message> messages =messageService.getAllMessage();

       return ResponseEntity.ok(messages);

    }


    @PostMapping("/create")
    public ResponseEntity<String> createMessage( @Valid  @RequestBody Message message){
         messageService.createMessage(message);
         return  ResponseEntity.ok("Message Created ....");
    }
     @PutMapping("/{id}")
    public ResponseEntity<?> updateMessage(@PathVariable Long id , @RequestBody Message message){

                messageService.updateMessage(id,message);
        return ResponseEntity.ok("Updated Message.");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMessage(@PathVariable Long id) {

        int rowAffected = messageService.deleteMessage(id);
        System.out.println(rowAffected);

        if (rowAffected>0) {
          return ResponseEntity.ok("Message deleted....");


        }
        return ResponseEntity.badRequest().body("Message  not found");
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getMessageById(@PathVariable  Long id){
       Message m = messageService.getMessageById(id);
        return ResponseEntity.ok(m);
    }



}
