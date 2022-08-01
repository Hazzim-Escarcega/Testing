package com.programming.techie;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ContactManagerTest {
    ContactManager contactManager = new ContactManager();
    @Test
    public void shouldCreateContact(){
        contactManager.addContact("Jabalino", "Ramirez", "0146669999");
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        Assertions.assertEquals(1, contactManager.getAllContacts().size());
    }
    @Test
    @DisplayName("Should not create contact when FIRST names is null")
    public void shouldThrowRuntimeExceptionWhenFirstNameIsNull(){
        Assertions.assertThrows(RuntimeException.class, ()->{
            contactManager.addContact(null, "Ramirez", "0146669999");
        });
    }
    @Test
    @DisplayName("Should not create contact when LAST name is null")
    public void shouldThrowRuntimeExceptionWhenLastNameIsNull(){
        Assertions.assertThrows(RuntimeException.class, ()->{
            contactManager.addContact("Jabalino", null, "0146669999");
        });
    }
    @Test
    @DisplayName("Should not create contact when PHONE is null")
    public void shouldThrowRuntimeExceptionWhenPhoneIsNull(){
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
    @Test
    @DisplayName("Should create contact only on mac os")
    @EnabledOnOs(value = OS.WINDOWS, disabledReason = "Enabled ony on mac os")
    public void shouldCreateContactOnlyOnMac(){
        contactManager.addContact("Juan", "Martinez", "0146669999");
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        Assertions.assertEquals(1, contactManager.getAllContacts().size());
        Assertions.assertTrue(contactManager.getAllContacts().stream()
                .filter(contact -> contact.getFirstName().equals("Juan") &&
                contact.getLastName().equals("Martinez") &&
                contact.getPhoneNumber().equals("0146669999"))
                .findAny()
                .isPresent());


    }
    @Test
    @DisplayName("Test contact creation on dev machine")
    public void shouldTestContactCreationOnDEV(){
        Assumptions.assumeTrue("DEV".equals(System.getProperty("DEV")));
        contactManager.addContact("John", "Doe", "0146669999");
        assertFalse(contactManager.getAllContacts().isEmpty());
        assertEquals(1, contactManager.getAllContacts().size());

    }
    @DisplayName("Repeat contact creation test 5 times")
    @RepeatedTest(value = 5, name = "Repeating contact creation test {currentRepetition} of {totalRepetitions}")
    public void shouldTestContactCreationRepeatedly(){
        contactManager.addContact("asdf", "Doe", "0146669999");
        assertFalse(contactManager.getAllContacts().isEmpty());
        assertEquals(1, contactManager.getAllContacts().size());
    }
}