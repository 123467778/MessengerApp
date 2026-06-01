package com.example.Messenger.Base.Model;

import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * This class is Json util for handling Json data .
 */

@Component
public class JsonUtil {

    private final ObjectMapper objectMapper;
    
    /**
     * This constructor pass the object 
     * @param objectMapper
     */

    public JsonUtil(ObjectMapper objectMapper){
        this.objectMapper=objectMapper;
    }


    public String toJsonString(Map<String,Object> data){
        try{
            return objectMapper.writeValueAsString(data);
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public Map<String,Object> fromJson(String json){
        try{
            return objectMapper.readValue(json,new TypeReference<Map<String,Object>>(){});
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
