package com.safeplatform.samples.web.service.impl;

import com.safeplatform.samples.web.dao.Vehicle;
import com.safeplatform.samples.web.dao.VehicleMapper;
import com.safeplatform.samples.web.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleMapper vehicleMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return vehicleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Vehicle record) {
        return vehicleMapper.insert(record);
    }

    @Override
    public int insertSelective(Vehicle record) {
        return vehicleMapper.insertSelective(record);
    }

    @Override
    public Vehicle selectByPrimaryKey(Integer id) {
        return vehicleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Vehicle record) {
        return vehicleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Vehicle record) {
        return vehicleMapper.updateByPrimaryKey(record);
    }

}
