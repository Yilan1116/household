package com.wyl.furns.test;

import com.wyl.furns.dao.FurnDAO;
import com.wyl.furns.dao.impl.FurnDAOImpl;
import com.wyl.furns.entity.Furn;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.math.BigDecimal;
import java.util.List;

public class FurnDAOTest {
    private FurnDAO furnDAO= new FurnDAOImpl();
    @Test
    public void queryFurns(){

        List<Furn> furns = furnDAO.queryFurns();
        for (Furn furn : furns) {
            System.out.println(furn);
        }
    }
    @Test
    public void add(){
        Furn furn = new Furn(null, "台灯", "蚂蚁家居", new BigDecimal(88.88), 666, 7, "asset/images/product-image/14.jpg");
        System.out.println(furnDAO.addFurn(furn));
    }

    @Test
    public void getTotalRow(){
        System.out.println(furnDAO.getTotalRow());
    }

    @Test
    public void getPageItems(){
        List<Furn> pageItems = furnDAO.getPageItems(0, 3);
        for (Furn pageItem : pageItems) {
            System.out.println(pageItem);
        }
    }

}
