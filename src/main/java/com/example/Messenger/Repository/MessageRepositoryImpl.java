package com.example.Messenger.Repository;

import com.example.Messenger.Model.JsonUtil;
import com.example.Messenger.Model.Message;
import com.example.Messenger.Model.Status;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MessageRepositoryImpl implements  MessageRepository {

    private JdbcTemplate jdbcTemplate;
    private JsonUtil jsonUtil;


    public MessageRepositoryImpl(JdbcTemplate jdbcTemplate, JsonUtil jsonUtil) {
        this.jdbcTemplate = jdbcTemplate;
        this.jsonUtil = jsonUtil;
    }


    @Override
    public List<Message> getAllMessage() {
        String sql = "Select * from message ";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Message m = new Message();
            m.setId(rs.getLong("id"));
            m.setSender(rs.getString("sender"));
            m.setText(rs.getString("text"));
            m.setData(jsonUtil.fromJson(rs.getString("data")));
            m.setNstatus(Status.fromValue(rs.getInt("nstatus")));

            return m;
        });

    }

    @Override
    public int createMessage(Message message) {
        String sql = "Insert into message (sender,text,data,nstatus)values('" + message.getSender() + "','" + message.getText() + "','" + jsonUtil.toJsonString(message.getData()) + "','" + message.getNstatus().getVal() + "'" + ")";

        return jdbcTemplate.update(sql);
    }

    @Override
    public int updateMessage(Long id, Message message) {

        String sql =
                "UPDATE message SET " +
                        "sender = '" + message.getSender() + "', " +
                        "text = '" + message.getText() + "', " +
                        "data = '" + jsonUtil.toJsonString(message.getData()) + "', " +
                        "nstatus = " + message.getNstatus().getVal() +
                        " WHERE id = " + id;

        return jdbcTemplate.update(sql);


    }

    @Override
    public int deleteMessage(Long id) {
        String sql = "update message set nstatus = " +Status.InActive.getVal() +" where id = " +id;

        return jdbcTemplate.update(sql);
    }

    @Override
    public Message getMessageById(Long id) {

        String sql = "select * from message where id =" +id;

        return jdbcTemplate.queryForObject(sql,(rs,rowNum)->{
            Message m = new Message();
            m.setId(id);
            m.setSender(rs.getString("sender"));
            m.setText(rs.getString("text"));
            m.setData(jsonUtil.fromJson(rs.getString("data")));
            m.setNstatus(Status.fromValue(rs.getInt("nstatus")));
            return m;
        });


    }


}
