package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests  extends TestBase{
    //precondition
    //login
    //add contact

    @BeforeMethod
    public void precondition(){

        clickOnLoginLink();
        fillRegisterLognForm(new User().setEmail("kris22@gmail.com").setPassword("Aa12345!"));
        clickOnLoginButton();
        clickOnAddLink();
        fillContactForm(new Contact("Karl", "Tomash", "1234567890", "Karl@gmail.com", "Berlin", "QA"));
        clickOnSaveButtton();
    }
        @Test
    public void deleteContactTest(){

            int sizeBefore = sizeOfContacts();
            deleteContact();
            pause(1000);
            int sizeAfter = sizeOfContacts();
            Assert.assertEquals(sizeAfter,sizeBefore-1);
        }

}
