package com.safeplatform.samples.web.dao;


import java.util.List;

public interface CollisionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Collision record);

    int insertSelective(Collision record);

    Collision selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Collision record);

    int updateByPrimaryKey(Collision record);

    List<CollisionList> selectCollisionList(String assignee);


}