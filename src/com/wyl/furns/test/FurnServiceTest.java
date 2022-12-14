package com.wyl.furns.test;

import com.wyl.furns.entity.Furn;
import com.wyl.furns.entity.Page;
import com.wyl.furns.service.FurnService;
import com.wyl.furns.service.impl.FurnServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class FurnServiceTest {
    private FurnService furnService = new FurnServiceImpl();

    @Test
    public void queryFurns(){
        List<Furn> furns = furnService.queryFurns();
        for (Furn furn : furns) {
            System.out.println(furn);
        }
    }

    @Test
    public void updateFurn(){
        Furn furn = new Furn(16,"ppaa","we", new
                BigDecimal(121.00),121,121,"assets/images/product-image/14.jpg");

        System.out.println(furnService.updateFurn(furn));
        System.out.println(furn);
    }

    @Test
    public void page(){
        Page<Furn> page = furnService.page(1, 3);
        System.out.println(page.getPageNo());
        System.out.println(page.getPageSize());
        System.out.println(page);
    }

    @Test
    public void pageByName(){
        Page<Furn> page = furnService.pageByName(1,3,"沙发" );
        System.out.println(page);
    }

}
