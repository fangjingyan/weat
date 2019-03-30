package com.example.olivia.weat;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoodsEntityTest {
    private GoodsEntity mGoodsEntity;

    @Before
    public void setUp() throws Exception {
         mGoodsEntity = new GoodsEntity();
    }

    @Test
    public void getImgPath() {
        mGoodsEntity.setImgPath("a");
        assertEquals("Wrong ImgPath", mGoodsEntity.getImgPath(), "a");
    }

    @Test
    public void setImgPath() {
    }

    @Test
    public void getGoodsName() {
        mGoodsEntity.setGoodsName("a");
        assertEquals("Wrong GoodsName", mGoodsEntity.getGoodsName(), "a");
    }

    @Test
    public void setGoodsName() {
    }

    @Test
    public void getGoodsPrice() {
        mGoodsEntity.setGoodsPrice("a");
        assertEquals("Wrong GoodsPrice", mGoodsEntity.getGoodsPrice(), "a");
    }

    @Test
    public void setGoodsPrice() {
    }

}