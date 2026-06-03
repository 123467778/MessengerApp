package com.example.Messenger.Controller;

import com.example.Messenger.Base.Model.Message;
import com.example.Messenger.Base.Service.MessageService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



/**
 * This class is act as the Rest controller for the Message which used to dispatch the requests  .
 */
@RestController
@RequestMapping("/message")
@AllArgsConstructor

public class MessengerController {

    private final MessageService messageService;
    
    /**
     * This constructor injection is used to pass object dependencies  to 
     * class.
     * @param messageService MessageService
     */
   
//    public MessengerController(MessageService messageService){
//        this.messageService=messageService;
//    }

    
    /**
     *This method is a GET method returns all the message from the database 
     *
     * @return responseEntity with OK message AND list of messages
     * 
     */
    

    @GetMapping("/get")
    public ResponseEntity<?> getAllMessage(){
       List <Message> messages =messageService.getAllMessage();
       
      for(Message m : messages) {
    	  m.setDisplayMessage("From" +" " +m.getSender() +" ,"  + " Message:" +m.getText());
      }
       
       
       return ResponseEntity.ok(messages);

    }

    /**
     * This is A POST method that creates  a message in the message table in Database 
     * @param message takes message input .
     * @return ResponseEntity with OK and "Message created .... " message 
     */
    
    

    @PostMapping("/create")
    public ResponseEntity<String> createMessage( @Valid  @RequestBody Message message){
         messageService.createMessage(message);
         return  ResponseEntity.ok("Message Created ....");
    }
    
    /**
     * This method returns updated message for the id ,where the data should be updated .
     * @param id id is used to update the message where the id match .
     * @param message ,message has the updated value .
     * @return responseEntity with OK and updated message .
     */
    
     @PutMapping("/{id}")
    public ResponseEntity<?> updateMessage(@PathVariable Long id , @RequestBody Message message){

                messageService.updateMessage(id,message);
        return ResponseEntity.ok("Updated Message.");
    }


     /**
      * This method update the nstatus to -1 when the message get delete
      * @param id used to find the id that need to be deleted.
      * @return  ResponseEntity with OK message ,if deleted else returns "Message not found". 
      */
     
     
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMessage(@PathVariable Long id) {

        int rowAffected = messageService.deleteMessage(id);
        System.out.println(rowAffected);

        if (rowAffected>0) {
          return ResponseEntity.ok("Message deleted....");


        }
        return ResponseEntity.badRequest().body("Message  not found");
    }

    /**
     * This method gets the message of the particular id ,
     * @param id used to find particular id .
     * @return ResponseEntity with OK and the message .
     */
    

    @GetMapping("/{id}")
    public ResponseEntity<?> getMessageById(@PathVariable  Long id){
       Message m = messageService.getMessageById(id);
        return ResponseEntity.ok(m);
    }



}
