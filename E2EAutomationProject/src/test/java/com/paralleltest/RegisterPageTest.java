package com.paralleltest;

import org.testng.annotations.Test;

import com.datasource.db.CommonDataProvider;
import com.pageFactory.ClickAcadamyLandingPage;
import com.pageFactory.ClickAcadamyRegisterPage;
import com.paralleltest.basetest.BaseTest;

public class RegisterPageTest extends BaseTest{

    ClickAcadamyLandingPage landing;
    ClickAcadamyRegisterPage reg;

    @Test(dataProvider = "getData", dataProviderClass = CommonDataProvider.class)
    public void registerUsingPageFactory (String username, String password)
    {
        // logger.info("registerUsingPageFactory");
        System.err.println("Running Test=> " + this + " -> on thread [" + Thread.currentThread().getId() + "]");
       
       
    }
 
    @Test(dataProvider = "getDataExcel", dataProviderClass = CommonDataProvider.class)
    public void registerUsingPageFactoryExcelData (String username, String password)
    {
        // logger.info("registerUsingPageFactory");
        System.err.println("Running Test=> " + this + " -> on thread [" + Thread.currentThread().getId() + "]");
       

       
    }
    

    
}