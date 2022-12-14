package com.wyl.furns.dao;

import com.wyl.furns.entity.Furn;

import java.util.List;

public interface FurnDAO {
    public List<Furn> queryFurns();
    public int addFurn(Furn furn);
    public int deleteFurnById(int id);
    public Furn queryFurnById(int id);
    public int updateFurn(Furn furn);
    public int getTotalRow();
    public List<Furn> getPageItems(int pageNo, int pageSize);

    public int getTotalRowByName(String name);
    public List<Furn> getPageItemsByName(int begin, int pageSize, String name);

}
