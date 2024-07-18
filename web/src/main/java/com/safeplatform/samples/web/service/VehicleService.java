package com.safeplatform.samples.web.service;

import com.safeplatform.samples.web.dao.Vehicle;

public interface VehicleService{


    int deleteByPrimaryKey(Integer id);

    int insert(Vehicle record);

    int insertSelective(Vehicle record);

    Vehicle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Vehicle record);

    int updateByPrimaryKey(Vehicle record);

}
