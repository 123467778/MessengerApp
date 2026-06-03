package com.example.Messenger;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.Messenger.Base.Model.Message;
import com.example.Messenger.Base.Service.MessageRepositoryImpl;
import com.example.Messenger.Base.Service.MessageServiceImpl;




@ExtendWith(MockitoExtension.class)
class MessengerServiceTest {
	
	@InjectMocks
	MessageServiceImpl messageServiceImp;
	
	@Mock
	MessageRepositoryImpl  messageRepositoryImpl;

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}
//	
	
	
	@Test
	void shouldGetAllMessage() {
		Message m1 = new Message();
		m1.setId(1L);
		m1.setSender("Mathew");
		m1.setText("Good morning");
		Map<String, Object> data = new HashMap<>();
		data.put("likes", 12);
		data.put("dislikes", 2);
		data.put("status", "send");
		m1.setData(data);
		
		Message m2 = new Message();
		m2.setId(2L);
		m2.setSender("peter");
		m2.setText("Good evening");
		Map<String, Object> data2 = new HashMap<>();
		data2.put("likes", 12);
		data2.put("dislikes", 2);
		data2.put("status", "send");
		m2.setData(data2);
		
		List<Message> msg = new ArrayList<>();
		msg.add(m1);
		msg.add(m2);
		
		when(messageRepositoryImpl.getAllMessage()).thenReturn(msg);
		List<Message> result = messageServiceImp.getAllMessage();
		assertEquals(2,result.size());
		assertEquals("Mathew" ,result.get(0).getSender());
		
		
		
	}
	
	@Test
	void shouldCreateMessage() {
		Message m = new Message();
		m.setId(1L);
		m.setSender("Mathew");
		m.setText("Good morning");
		Map<String, Object> data = new HashMap<>();
		data.put("likes", 12);
		data.put("dislikes", 2);
		data.put("status", "send");
		m.setData(data);
		m.setNstatus((short) 1);
		
		when(messageRepositoryImpl.createMessage(m)).thenReturn(1);
	    assertEquals(1,messageServiceImp.createMessage(m));
	    
	}
	
	@Test
	
	void shouldUpdateMessage() {
		Message m = new Message();
		m.setId(1L);
		m.setSender("Mathew");
		m.setText("Good morning");
		Map<String, Object> data = new HashMap<>();
		data.put("likes", 12);
		data.put("dislikes", 2);
		data.put("status", "send");
		m.setData(data);
		m.setNstatus((short) 1);
		
		List<Message> msg =new ArrayList<>();
		msg.add(m);
		
		
		Message m2 = new Message();
		Long id = 1L;
		m2.setSender("Mathew Das");
		m2.setText("Good morning");
		Map<String, Object> data1 = new HashMap<>();
		data1.put("dislikes", 2);
		data1.put("status", "send");
		m.setData(data1);
		m.setNstatus((short) 1);
		
		 when(messageRepositoryImpl.getMessageById(id))
         .thenReturn(m);
		
		  when(messageRepositoryImpl.updateMessage(anyLong(), any(Message.class)))
          .thenReturn(1);

		assertEquals(1,messageServiceImp.updateMessage(id, m2));
		
	}
	
	@Test
	void deleteMessage() {
		Message m = new Message();
		m.setId(1L);
		m.setNstatus((short)1);
		
		Long id = m.getId();
		
		when(messageRepositoryImpl.deleteMessage(id)).thenReturn(1);
		assertEquals(1,messageServiceImp.deleteMessage(id));
		
	}
	
	
	@Test
	void getMessageById() {
		Message m1 = new Message();
		m1.setId(1L);
		m1.setSender("Mathew");
		m1.setText("Good morning");
		Map<String, Object> data = new HashMap<>();
		data.put("likes", 12);
		data.put("dislikes", 2);
		data.put("status", "send");
		m1.setData(data);
		
		Message m2 = new Message();
		m2.setId(2L);
		m2.setSender("peter");
		m2.setText("Good evening");
		Map<String, Object> data2 = new HashMap<>();
		data2.put("likes", 12);
		data2.put("dislikes", 2);
		data2.put("status", "send");
		m2.setData(data2);
		
		List<Message> msg = new ArrayList<>();
		msg.add(m1);
		msg.add(m2);
		
		Long Id =1L;
		
		when(messageRepositoryImpl.getMessageById(Id)).thenReturn(m1);
		Message result = messageServiceImp.getMessageById(Id);
		assertEquals(m1,result);
		
	}

}
