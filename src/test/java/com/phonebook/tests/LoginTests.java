package com.phonebook.tests;

import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test(priority = 1)
    public void loginPositiveTest(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLognForm(new User().setEmail("kris22@gmail.com").setPassword("Aa12345!"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());

    }

    @Test(priority = 2)
    public void loginNegativeTest(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLognForm(new User().setEmail("").setPassword("Aa12345!"));
        app.getUser().pause(5000);
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertDisplyed());

    }

}
