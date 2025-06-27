package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        clickOnLoginLink();
        fillRegisterLognForm(new User().setEmail("kris22@gmail.com").setPassword("Aa12345!"));
        clickOnLoginButton();
    }
    @Test
    public void addContactPositiveTest(){

        clickOnAddLink();
        fillContactForm(new Contact("Karl", "Tomash", "1234567890", "Karl@gmail.com", "Berlin", "QA"));
        clickOnSaveButtton();
        Assert.assertTrue(isContactAdded("Karl"));

    }

    @AfterMethod
    public void postCondition(){
            deleteContact();
        }

}


