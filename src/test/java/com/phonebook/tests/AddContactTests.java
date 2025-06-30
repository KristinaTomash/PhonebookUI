package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }

        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLognForm(new User().setEmail("kris22@gmail.com").setPassword("Aa12345!"));
        app.getUser().clickOnLoginButton();
    }
    @Test
    public void addContactPositiveTest(){

        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact().setName("Karl")
                .setLastName("Tomash")
                .setPhone("1234567890")
                .setEmail("Karl@gmail.com")
                .setAddress("Berlin")
                .setDescription("QA"));
        app.getContact().clickOnSaveButtton();
        Assert.assertTrue(app.getContact().isContactAdded("Karl"));

    }

    @AfterMethod
    public void postCondition(){
            app.getContact().deleteContact();
        }

}


