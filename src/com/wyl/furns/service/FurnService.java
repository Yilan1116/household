package com.wyl.furns.service;

import com.wyl.furns.entity.Furn;

import java.util.List;

public interface FurnService {
    public List<Furn> queryFurns();
    public int addFurn(Furn furn);
    public int deleteFurnById(int id);
    public Furn queryFurnById(int id);
}
