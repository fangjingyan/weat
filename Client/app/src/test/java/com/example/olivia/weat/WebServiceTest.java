package com.example.olivia.weat;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class WebServiceTest {

    private  WebService mWebService;

    @Before
    public void setUp() throws Exception {
        mWebService = new WebService();
    }

    @Test
    public void executeHTTPGetRegister() {
        Map<String, String> test = new HashMap<>();
        test.put("Username", "olivia");
        test.put("Password", "123");
        test.put("Email", "123@gmail.com");
        assertEquals(false, mWebService.executeHTTPGetRegister(test));
    }

    @Test
    public void executeHTTPGetAddRecord() {
        Map<String, String> test = new HashMap<>();
        test.put("Uid", "1");
        test.put("Date", "2019.03.26");
        test.put("Day", "Tuesday");
        test.put("Meal", "lunch");
        test.put("Content", "rice");
        assertEquals(false, mWebService.executeHTTPGetAddRecord(test));
    }
}