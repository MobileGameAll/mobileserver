package br.eti.francisco.mobileserver.web.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.eti.francisco.mobileserver.model.Message;
import br.eti.francisco.mobileserver.repository.MessageDao;


@RestController
@RequestMapping(value="/message")
public class MessageController {

	@Autowired
	private MessageDao messageDao;
	
	@RequestMapping(value = "/{token}/{type}", method = RequestMethod.GET)
	public List<Map<String, Object>> message(@PathVariable("token") String token, @PathVariable("type") String type) {
		List<Map<String, Object>> target = new ArrayList<>();
		ObjectMapper obj = new ObjectMapper();
		messageDao.findByTokenType(token, type).forEach(v -> {
		    
		    try {
		        Map line = (Map)obj.readValue(v.getData(), Map.class);
		        line.put("_id", v.getId());
                line.put("_timestamp", v.getTimestamp());
                target.add(line);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		    
		 });
		return target;
	}
	@RequestMapping(value = "/{token}/{type}", method = RequestMethod.POST)
	public ResponseEntity<Void> save(@PathVariable("token") String token, @PathVariable("type") String type, @RequestBody Map<String, Object> msg) {
	    Message message = new Message();
	    message.setToken(token);
	    message.setType(type);
	    ObjectMapper obj = new ObjectMapper();
	    try {
            message.setData(obj.writeValueAsString(msg));
            if(msg.containsKey("_id")){
                message.setId((int)msg.get("_id"));
                msg.remove("_id");
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
		messageDao.save(message);
		return ResponseEntity.ok(null);
	}
}
