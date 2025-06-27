package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest(){
        int i=(int)((System.currentTimeMillis()/1000)%3600);

        clickOnLoginLink();
        fillRegisterLognForm(new User().setEmail("kris22@gmail.com").setPassword("Aa12345!"));
        clickOnRegistrationButton();
        Assert.assertTrue(isSignOutButtonPresent());
    }

    @Test
    public void existedUserRegistrationNegativeTest(){
        clickOnLoginLink();
        fillRegisterLognForm(new User().setEmail("kris22@gmail.com").setPassword("Aa12345!"));
        clickOnRegistrationButton();
        Assert.assertTrue(isAlertDisplyed());

    }

}
