package com.example.Messenger.Base.Service;

import org.springframework.http.ResponseEntity;

import com.example.Messenger.Base.Model.Message;

import java.util.List;

/**
 * This is a Message Service interface that contains the definition for the
 * methods which will be implemented by Message Service Imp class .
 */

public interface MessageService {

	/**
	 * This method has the definition for getting all the message from the database.
	 * 
	 * @return List of message .
	 */

	List<Message> getAllMessage();

	/**
	 * Creates a new message.
	 *
	 * @param message the message to create
	 * @return the ID of the newly created message
	 */
	int createMessage(Message message);

	/**
	 * This method update the message based on the parameter id.
	 * 
	 * @param id  that need to be updated
	 * @param message contains input values sender,text,data,nstatus
	 * @return the ID of updated message
	 */

	int updateMessage(Long id, Message message);
	
	
	/**
	 * This method updates the message nstatus to -1 ,when the message get deleted.
	 * @param id that need to be deleted 
	 * @return the ID of deleted message.
	 */

	int deleteMessage(Long id);
	
	
	/**
	 * This method get message from the particular id.
	 * @param id that need to be retrieved.
	 * @return the Message from the particular ID.
	 */

	Message getMessageById(Long id);
}
