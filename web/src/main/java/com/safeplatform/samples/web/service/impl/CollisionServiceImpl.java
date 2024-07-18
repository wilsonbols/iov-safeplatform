package com.safeplatform.samples.web.service.impl;

import com.safeplatform.samples.web.dao.CollisionList;
import com.safeplatform.samples.web.dao.Collision;
import com.safeplatform.samples.web.service.CollisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.safeplatform.samples.web.dao.CollisionMapper;

import java.util.List;

@Service
public class CollisionServiceImpl implements CollisionService {


    @Autowired
    private CollisionMapper collisionMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return collisionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Collision record) {
        return collisionMapper.insert(record);
    }

    @Override
    public int insertSelective(Collision record) {
        return collisionMapper.insertSelective(record);
    }

    @Override
    public Collision selectByPrimaryKey(Integer id) {
        return collisionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Collision record) {
        return collisionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Collision record) {
        return collisionMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<CollisionList> selectCollisionList(String assignee) {
        return collisionMapper.selectCollisionList(assignee);
    }



}
