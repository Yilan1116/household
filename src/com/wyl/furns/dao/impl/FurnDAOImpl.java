package com.wyl.furns.dao.impl;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import com.wyl.furns.dao.BasicDAO;
import com.wyl.furns.dao.FurnDAO;
import com.wyl.furns.entity.Furn;

import java.util.List;

public class FurnDAOImpl extends BasicDAO<Furn> implements FurnDAO {
    @Override
    public List<Furn> queryFurns() {
        String sql = "SELECT id, NAME,maker,price,sales,stock,img_path imgPath\n" +
                "FROM furn";
        return queryMulti(sql,Furn.class);
    }

    @Override
    public int addFurn(Furn furn) {
        String sql = "INSERT INTO furn(id,NAME,maker,price,sales,stock,img_path)\n" +
                "VALUES(NULL,?,?,?,?,?,?)";
        return update(sql,furn.getName(),furn.getMaker(),furn.getPrice(),furn.getSales(),furn.getStock(),furn.getImgPath());
    }

    @Override
    public int deleteFurnById(int id) {
        String sql ="DELETE FROM furn\n" +
                "WHERE id =?";
        return update(sql,id);
    }
}
