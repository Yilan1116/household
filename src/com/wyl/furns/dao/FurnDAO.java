package com.wyl.furns.dao;

import com.wyl.furns.entity.Furn;

import java.util.List;

public interface FurnDAO {
    public List<Furn> queryFurns();
    public int addFurn(Furn frun);
    public int deleteFurnById(int id);
}
