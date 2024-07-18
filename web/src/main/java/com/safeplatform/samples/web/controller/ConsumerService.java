package com.safeplatform.samples.web.controller;

import com.safeplatform.samples.web.dao.CollisionList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "dataprocess")
public interface ConsumerService {

    @GetMapping("/api/config")
    String config();

    @GetMapping("/api/getvehicledata")
    List<VehicleRealtimeData> vehicleRealtimeData(@RequestParam String vin);

    @PostMapping("/api/control")
    ResultModel control(@RequestBody String controlInfo);

    @GetMapping("/api/assignEmergencyInfo")
    ResultModel assignEmergencyInfo(@RequestParam Integer id,@RequestParam String assignee);

    @GetMapping("/api/getMyEmergencyInfos")
    List<CollisionList> getMyEmergencyInfos(@RequestParam String assignee);






}
