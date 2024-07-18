package com.safeplatform.samples.web.service;

import com.safeplatform.samples.web.dao.Collision;
import com.safeplatform.samples.web.dao.CollisionList;

import java.util.List;

public interface CollisionService{


    int deleteByPrimaryKey(Integer id);

    int insert(Collision record);

    int insertSelective(Collision record);

    Collision selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Collision record);

    int updateByPrimaryKey(Collision record);

    List<CollisionList> selectCollisionList(String assignee);

}
