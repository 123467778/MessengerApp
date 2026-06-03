package com.example.Messenger.Base.Model;

import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * This class is Json util for handling Json data .
 */

@Component
public class JsonUtil {

    private final ObjectMapper objectMapper;
    
    /**
     * This constructor pass the object dependencies to this class 
     * @param objectMapper used to covert json object  to string and json string to Object.
     */

    public JsonUtil(ObjectMapper objectMapper){
        this.objectMapper=objectMapper;
    }

    /**
     * This method converts the json object to string while performing insert,update operation.
     * @param data Json data 
     * @return string value of the data to store in Db.
     */

    public String toJsonString(Map<String,Object> data){
        try{
            return objectMapper.writeValueAsString(data);
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    
    /**
     * This method coverts json String to object while performing select query .
     * @param json  ->json a String
     * @return object value of the json data.
     */

    public Map<String,Object> fromJson(String json){
        try{
            return objectMapper.readValue(json,new TypeReference<Map<String,Object>>(){});
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
