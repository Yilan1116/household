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

    @Override
    public Furn queryFurnById(int id) {

        String sql = "SELECT id, NAME,maker,price,sales,stock,img_path imgPath\n" +
                "FROM furn WHERE id = ?";
        return querySingle(sql,Furn.class,id);
    }

    @Override
    public int updateFurn(Furn furn) {
        String sql = "UPDATE furn SET NAME =? ,maker=? , price=? ,sales=? ,stock = ? ,img_path=? " +
                "WHERE id = ? ";
        return update(sql,furn.getName(),furn.getMaker(),furn.getPrice(),furn.getSales(),furn.getStock(),furn.getImgPath(),furn.getId());
    }

    @Override
    public int getTotalRow() {
        String sql = "SELECT COUNT(*) FROM furn";
        return ((Number) queryScalar(sql)).intValue();
    }

    @Override
    public List<Furn> getPageItems(int pageNo, int pageSize) {
        String sql = "SELECT id, NAME,maker,price,sales,stock,img_path imgPath\n" +
                "FROM furn LIMIT ?,?";
        return queryMulti(sql,Furn.class,pageNo,pageSize);
    }

    @Override
    public int getTotalRowByName(String name) {
        String sql = "SELECT COUNT(*) FROM furn WHERE name like ?";

        return ((Number)queryScalar(sql,"%"+name+"%")).intValue();
    }

    @Override
    public List<Furn> getPageItemsByName(int begin, int pageSize, String name) {
        String sql = "SELECT id, NAME,maker,price,sales,stock,img_path imgPath\n" +
                "FROM furn WHERE name LIKE ? LIMIT ?, ?";
        return queryMulti(sql,Furn.class,"%"+name+"%",begin,pageSize);
    }


}
