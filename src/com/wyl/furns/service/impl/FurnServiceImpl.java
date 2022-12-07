package com.wyl.furns.service.impl;

import com.wyl.furns.dao.FurnDAO;
import com.wyl.furns.dao.impl.FurnDAOImpl;
import com.wyl.furns.entity.Furn;
import com.wyl.furns.service.FurnService;

import java.util.List;

public class FurnServiceImpl implements FurnService {

    private FurnDAO furnDAO = new FurnDAOImpl();
    @Override
    public List<Furn> queryFurns() {
        return furnDAO.queryFurns();

    }

    @Override
    public int addFurn(Furn furn) {
        return furnDAO.addFurn(furn);
    }

    @Override
    public int deleteFurnById(int id) {
        return furnDAO.deleteFurnById(id);
    }
}
