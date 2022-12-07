package com.wyl.furns.test;

import com.wyl.furns.entity.Furn;
import com.wyl.furns.service.FurnService;
import com.wyl.furns.service.impl.FurnServiceImpl;
import org.junit.Test;

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


}
