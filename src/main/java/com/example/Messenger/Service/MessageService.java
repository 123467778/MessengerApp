package com.example.Messenger.Service;

import com.example.Messenger.Model.Message;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MessageService {
    List<Message> getAllMessage();

    int createMessage(Message message);

    int updateMessage(Long id, Message message);

  int deleteMessage(Long id);

  Message getMessageById(Long id);
}
