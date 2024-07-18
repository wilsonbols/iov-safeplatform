package com.safeplatform.samples.web.websocket;

import com.google.gson.Gson;
import com.safeplatform.samples.web.dao.CollisionList;
import com.safeplatform.samples.web.service.CollisionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class DatabaseService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseService.class);
    private final SimpMessagingTemplate messagingTemplate;
    private final AtomicLong counter = new AtomicLong();


    private final CollisionService collisionService;
    @Autowired
    public DatabaseService(SimpMessagingTemplate messagingTemplate, CollisionService collisionService) {
        this.messagingTemplate = messagingTemplate;
        this.collisionService = collisionService;
    }

    @Scheduled(fixedRate = 1000) // Execute every 1 second
    public void fetchDataAndPushToClients() {
    try {
        // Simulate the logic of fetching data from the database
        String assignee = "user";
        List<CollisionList> list = collisionService.selectCollisionList(assignee);
        String str = "Database data #" + counter.incrementAndGet() + " at " + System.currentTimeMillis() + " size " + list.size();
        //System.out.println(str);
        Gson gson = new Gson();
        String jsonInputString = gson.toJson(list);
        messagingTemplate.convertAndSend("/topic/collisionlist", jsonInputString);
    } catch (Exception e) {
        LOGGER.error("Database connection exception, check whether the connection string is configured in the configuration center");
        LOGGER.error("WebSocket", e);
        System.exit(1);
    }
}

}
