package com.safeplatform.samples.web.controller;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.safeplatform.samples.web.dao.Collision;
import com.safeplatform.samples.web.dao.CollisionList;
import com.safeplatform.samples.web.service.CollisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RestController
@RefreshScope
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CollisionController {

    private final CollisionService collisionService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ConsumerService consumerService;


    @Autowired
    public CollisionController(CollisionService collisionService) {
        this.collisionService = collisionService;
    }


    @GetMapping("/configdata")
    public String configdata() {
        String result = consumerService.config();
        // String result = restTemplate.getForObject("cse://dataprocess/api/config", String.class);
        // String result = restTemplate.getForObject("http://dataprocess/api/config", String.class);
        return result;
    }

    @GetMapping("selectOne")
    public Collision selectOne(Integer id) {
        return collisionService.selectByPrimaryKey(id);
    }

    @GetMapping("/getMyEmergencyInfos")
    public List<CollisionList> getMyEmergencyInfos(@RequestParam String assignee) {
        return consumerService.getMyEmergencyInfos(assignee);
    }

    @GetMapping("/getCarInfo")
    public String getCarInfo(@RequestParam String vin) {
        if (Strings.isNullOrEmpty(vin)) {
            System.out.println("getCarInfo vin is empty!");
            return "getCarInfo vin is empty!";
        }
        List<VehicleRealtimeData> list = consumerService.vehicleRealtimeData(vin);
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @GetMapping("/assignEmergencyInfo")
    public ResultModel assignEmergencyInfo(@RequestParam Integer id, @RequestParam String assignee) {
        return consumerService.assignEmergencyInfo(id, assignee);
    }

    
}


