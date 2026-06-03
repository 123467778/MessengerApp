package com.example.Messenger.Base.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.Messenger.Base.Model.Message;
import com.example.Messenger.Base.Model.Status;

import lombok.AllArgsConstructor;

import java.util.List;

/**
 * This class has the implemention of the Message service interface ,which has a
 * business logic for the messenger App .
 */

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

	private final MessageRepository messageRepository;

	/**
	 * This constructor is used to pass object dependencies to this class.
	 * 
	 * @param messageRepository inject the dependencies of messageRepository
	 */

//	public MessageServiceImpl(MessageRepository messageRepository) {
//		this.messageRepository = messageRepository;
//	}

	/**
	 * This method get the list of all messages from the Table Message.
	 */

	@Override
	public List<Message> getAllMessage() {
		return messageRepository.getAllMessage();
	}

	/**
	 * This method creates a new message in Message table .
	 */

	@Override
	public int createMessage(Message message) {
		return messageRepository.createMessage(message);
	}

	/**
	 * This method updates the message for the particular ID.
	 */
    @Transactional
	@Override
	public int updateMessage(Long id, Message message) {
    	 Message existing = messageRepository.getMessageById(id);
    	           

    	    if (existing.getNstatus() != 1) {
    	    	 throw new ResponseStatusException(
    	                 HttpStatus.BAD_REQUEST,
    	                 "Inactive message cannot be edited"
    	         );    	    }
		return messageRepository.updateMessage(id, message);
	}
	

	/**
	 * This method update the particular id 's nstatus to -1 that is "inactive" which means deleted .
	 */

	@Override
	public int deleteMessage(Long id) {
		return messageRepository.deleteMessage(id);
	}
	
	/**
	 * This method get message of the particular Id.
	 */

	@Override
	public Message getMessageById(Long id) {
		return messageRepository.getMessageById(id);
	}
}
