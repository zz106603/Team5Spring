package com.mycompany.webapp.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.webapp.mqtt.MqttTemplate;



@CrossOrigin(origins="*")
@Controller
public class testController {
	
	@Autowired
	private MqttTemplate mqttTemplate;
	
	
	@RequestMapping("/sendMqttMessage")
	public void sendMqttMessage(String topic, String content, HttpServletResponse res) {

		try {
			mqttTemplate.sendMessage(topic, content);
		
			JSONObject json = new JSONObject();
			json.put("result", "success");
			res.setContentType("application/json; charset=UTF-8");
			PrintWriter writer = res.getWriter();
			writer.write(json.toString());
			writer.flush();
			writer.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	
}
