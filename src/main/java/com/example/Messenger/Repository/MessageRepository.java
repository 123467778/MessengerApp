package com.example.Messenger.Repository;

import com.example.Messenger.Model.Message;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MessageRepository {
  List<Message> getAllMessage();

    int createMessage(Message message);

    int updateMessage(Long id, Message message);

    int deleteMessage(Long id);

    Message getMessageById(Long id);
}
