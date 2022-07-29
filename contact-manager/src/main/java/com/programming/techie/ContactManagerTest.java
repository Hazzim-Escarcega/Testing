package com.programming.techie;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ContactManagerTest {
    @Test
    public void shouldCreateContact(){
        ContactManager contactManager = new ContactManager();
        contactManager.addContact("Jabalino", "Ramirez", "0146669999");
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        Assertions.assertEquals(1, contactManager.getAllContacts().size());
    }
    @Test
    @DisplayName("Should not create contact when FIRST names is null")
    public void shouldThrowRuntimeExceptionWhenFirstNameIsNull(){
        ContactManager contactManager = new ContactManager();
        Assertions.assertThrows(RuntimeException.class, ()->{
            contactManager.addContact(null, "Ramirez", "0146669999");
        });
    }
    @Test
    @DisplayName("Should not create contact when LAST name is null")
    public void shouldThrowRuntimeExceptionWhenLastNameIsNull(){
        ContactManager contactManager = new ContactManager();
        Assertions.assertThrows(RuntimeException.class, ()->{
            contactManager.addContact("Jabalino", null, "0146669999");
        });
    }
    @Test
    @DisplayName("Should not create contact when PHONE is null")
    public void shouldThrowRuntimeExceptionWhenPhoneIsNull(){
        ContactManager contactManager = new ContactManager();
        Assertions.assertThrows(RuntimeException.class, ()->{
            contactManager.addContact("Jabalino", "Ramirez", null);
        });
    }
    @BeforeEach
    public void beforeEach(){
        System.out.println("Printed before each test");
    }
    @BeforeAll
    public void beforeAll(){
        System.out.println("Printed at the beggining of the test");
    }

    @AfterEach
    public void tearDown(){
    System.out.println("Printed after each test");
    }
    @AfterAll
    public void tearDownAll(){
    System.out.println("Printed at the end of the test");
    }
}