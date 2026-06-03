package com.example.Messenger.Base.Service;

import org.springframework.http.ResponseEntity;

import com.example.Messenger.Base.Model.Message;

import java.util.List;

/**
 * Repository interface for managing Message entities. Provides operations for
 * creating, retrieving, updating, and deleting messages.
 */
public interface MessageRepository {

	/**
	 * This method get the list of all messages from the Table Message.
	 * 
	 * @return List of Messages 
	 */

	List<Message> getAllMessage();

	/**
	 * This method creates a new message in Message table .
	 * @param message  has the values for the fields in table
	 * @return the id Of New message
	 */

	int createMessage(Message message);

	/**
	 * This method updates the message for the particular ID. 
	 * @param id that need to be updated   .
	 * @param message to be updated
	 * @return the id of updated message.
	 */

	int updateMessage(Long id, Message message);

	/**
	 * This method update the particular id 's nstatus to -1 that is "inactive"
	 * which means deleted .
	 * @param id that should be deleted 
	 * @return The id of the deleted messsage
	 */

	int deleteMessage(Long id);

	/**
	 * This method get message of the particular Id.
	 * @param id that should be 
	 * @return the message of particular id .
	 */

	Message getMessageById(Long id);
}
