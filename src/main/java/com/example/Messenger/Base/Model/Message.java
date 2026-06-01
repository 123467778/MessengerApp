package com.example.Messenger.Base.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Transient;

import java.util.Map;

/**
 * This class is used to map fields in the message table of the Database messenger_db
 * 
 */

@Data
public class Message {
	
	

    private Long id ;
    @NotNull
    @NotBlank(message="Sender should not be empty")
   
    private String sender;

    private String text;
    private Map<String,Object> data ;
    @NotNull(message = "nstatus cannot be null")
    private short nstatus;
    
    @Transient
    private String displayMessage;

    public String getDisplayMessage() {
		return displayMessage;
	}

//	public void setDisplayMessage(String displayMessage) {
//		this.displayMessage = displayMessage;
//	}
//
//	public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getSender() {
//        return sender;
//    }
//
//    public void setSender(String sender) {
//        this.sender = sender;
//    }
//
//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
//
//    public Map<String, Object> getData() {
//        return data;
//    }
//
//    public void setData(Map<String, Object> data) {
//        this.data = data;
//    }
//
//    public short getNstatus() {
//        return nstatus;
//    }
//
//    public void setNstatus(short nstatus) {
//        this.nstatus = nstatus;
//    }
}
