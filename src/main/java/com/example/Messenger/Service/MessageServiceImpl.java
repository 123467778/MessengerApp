package com.example.Messenger.Service;

import com.example.Messenger.Model.Message;
import com.example.Messenger.Repository.MessageRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{

    private MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository){
        this.messageRepository =messageRepository;
    }


    @Override
    public List<Message> getAllMessage() {
        return messageRepository.getAllMessage();
    }

    @Override
    public int createMessage(Message message) {
        return messageRepository.createMessage(message);
    }



    @Override
    public int updateMessage(Long id, Message message) {
        return messageRepository.updateMessage(id,message);
    }

    @Override
    public int deleteMessage(Long id) {
        return messageRepository.deleteMessage(id);
    }

    @Override
    public Message getMessageById(Long id) {
        return messageRepository.getMessageById(id);
    }
}
