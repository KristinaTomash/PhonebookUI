package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginPositiveTest(){
        clickOnLoginLink();
        fillRegisterLognForm(new User().setEmail("kris22@gmail.com").setPassword("Aa12345!"));
        clickOnLoginButton();
        Assert.assertTrue(isSignOutButtonPresent());

    }
    @Test
    public void loginNegativeTest(){
        clickOnLoginLink();
        fillRegisterLognForm(new User().setPassword("Aa12345!"));
        clickOnLoginButton();
        Assert.assertTrue(isAlertDisplyed());

    }

}
