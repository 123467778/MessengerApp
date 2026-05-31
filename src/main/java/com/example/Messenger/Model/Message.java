package com.example.Messenger.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.Map;
@Data
public class Message {

    private Long id ;
    @NotNull
    @NotBlank(message="Sender should not be empty")
   
    private String sender;

    private String text;
    private Map<String,Object> data ;
    @NotNull(message = "nstatus cannot be null")
    private Status nstatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Status getNstatus() {
        return nstatus;
    }

    public void setNstatus(Status nstatus) {
        this.nstatus = nstatus;
    }
}
