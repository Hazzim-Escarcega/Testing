import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContactManager {

    Map<String, Contact> contactList = new ConcurrentHashMap<>();

    public void addContact(String firstName, String lastName, String phoneNumber){
        Contact contact = new Contact(firstName, lastName, phoneNumber);
        validateContact(contact);
        checkIfContactAlreadyExists(contact);
        contactList.put(generateKey(contact), contact);
    }

    public Collection<Contact> getAllContacts(){return contactList.values();}

    public void checkIfContactAlreadyExists(Contact contact){
        if(contactList.containsKey((generateKey(contact))))
            throw new RuntimeException("Key already exists)");

    }

    private void validateContact(Contact contact){
        contact.validateFirstName();
        contact.validateLastName();
        contact.validatePhoneNumber();
    }

    private String generateKey(Contact contact) {
        return String.format("%s-%s", contact.getFirstName(), contact.getLastName());
    }
}
