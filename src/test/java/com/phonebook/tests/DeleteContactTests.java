package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests  extends TestBase{
    //precondition
    //login
    //add contact

    @BeforeMethod
    public void precondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLognForm(new User().setEmail("kris22@gmail.com").setPassword("Aa12345!"));
        app.getUser().clickOnLoginButton();

        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact().setName("Karl")
                .setLastName("Tomash")
                .setPhone("1234567890")
                .setEmail("Karl@gmail.com")
                .setAddress("Berlin")
                .setDescription("QA"));
        app.getContact().clickOnSaveButtton();
    }
        @Test
    public void deleteContactTest(){

            int sizeBefore = app.getContact().sizeOfContacts();
            app.getContact().deleteContact();
            app.getContact().pause(1000);
            int sizeAfter = app.getContact().sizeOfContacts();
            Assert.assertEquals(sizeAfter,sizeBefore-1);
        }

}
