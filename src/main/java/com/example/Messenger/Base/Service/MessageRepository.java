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
	 */

	List<Message> getAllMessage();

	/**
	 * This method creates a new message in Message table .
	 */

	int createMessage(Message message);

	/**
	 * This method updates the message for the particular ID.
	 */

	int updateMessage(Long id, Message message);

	/**
	 * This method update the particular id 's nstatus to -1 that is "inactive"
	 * which means deleted .
	 */

	int deleteMessage(Long id);

	/**
	 * This method get message of the particular Id.
	 */

	Message getMessageById(Long id);
}
