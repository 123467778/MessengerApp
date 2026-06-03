package com.example.Messenger.Base.Service;

import com.example.Messenger.Base.Model.JsonUtil;
import com.example.Messenger.Base.Model.Message;
import com.example.Messenger.Base.Model.Status;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * This class implements the Message Repository interface 
 */

@Repository
@AllArgsConstructor
public class MessageRepositoryImpl implements  MessageRepository {

    private final JdbcTemplate jdbcTemplate;
    private final  JsonUtil jsonUtil;

    /**
     * This Constructor injection pass the object dependencies to this class .
     * @param jdbcTemplate provides method writeValueAsString , readValue.
     * @param jsonUtil provides method to covert json String to object , Object to String.
     */

//    public MessageRepositoryImpl(JdbcTemplate jdbcTemplate, JsonUtil jsonUtil) {
//        this.jdbcTemplate = jdbcTemplate;
//        this.jsonUtil = jsonUtil;
//    }

    /**
     * Retrieves all messages from the database.
     * Executes a query on the message table and maps each row
     * to a Message object. The JSON data stored in the data
     * column is deserialized into the corresponding object using
     * jsonUtil.fromJson()
     *
     * @return a list of Message objects representing all records
     *         in the message table; returns an empty list if no records exist
     */

    @Override
    public List<Message> getAllMessage() {
        String sql = "Select * from message where nstatus = " +Status.Active.getVal();
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Message m = new Message();
            m.setId(rs.getLong("id"));
            m.setSender(rs.getString("sender"));
            m.setText(rs.getString("text"));
            m.setData(jsonUtil.fromJson(rs.getString("data")));
            m.setNstatus(rs.getShort("nstatus"));
            return m;
        });

    }

    /**
     * Create new Message in the table Message
     * execute insert query by setting the values for the field sender,text,data,nstatus . nad getting the values from getters.
     * @return the Id of the inserted row using jdbcTemplate 's query method .
     */
    
    @Override
    public int createMessage(Message message) {
        String sql = "Insert into message (sender,text,data,nstatus)values('" + message.getSender() + "','" + message.getText() + "','" + jsonUtil.toJsonString(message.getData()) + "','" + message.getNstatus() + "'" + ")";

        return jdbcTemplate.update(sql);
    }

    /**
     * Update the message for the particular id
     * execute the update query sets updated value for the particular id . 
     */
    
    
    @Override
    public int updateMessage(Long id, Message message) {

        String sql =
                "UPDATE message SET " +
                        "sender = '" + message.getSender() + "', " +
                        "text = '" + message.getText() + "', " +
                        "data = '" + jsonUtil.toJsonString(message.getData()) + "', " +
                        "nstatus = " + message.getNstatus() +
                        " WHERE id = " + id;

        return jdbcTemplate.update(sql);


    }
    /**
     * update the message's nstatus to -1 making the row inactive 
     * return Id of the deleted row .
     */

    @Override
    public int deleteMessage(Long id) {
        String sql = "update message set nstatus = " +Status.InActive.getVal() +" where id = " +id;

        return jdbcTemplate.update(sql);
    }
    
    /**
     * Retrieve the message of the particular id 
     * execute the query for retrieving the particular id from the message 
     * returns the jdbcTemplate.queryForObject for getting single object .
     */

    @Override
    public Message getMessageById(Long id) {

        String sql = "select * from message where id =" +id;

        return jdbcTemplate.queryForObject(sql,(rs,rowNum)->{
            Message m = new Message();
            m.setId(id);
            m.setSender(rs.getString("sender"));
            m.setText(rs.getString("text"));
            m.setData(jsonUtil.fromJson(rs.getString("data")));
            m.setNstatus(rs.getShort("nstatus"));
            return m;
        });


    }


}
