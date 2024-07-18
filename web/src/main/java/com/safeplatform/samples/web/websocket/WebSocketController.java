package com.safeplatform.samples.web.websocket;


import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


@Controller
public class WebSocketController {

	//@MessageMapping("/subscribe-database")
	@SendTo("/topic/collisionlist")
	public String subscribeDatabaseUpdates() {
		return "";
	}

}
