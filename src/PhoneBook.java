public class PhoneBook {
    public Contact contacts[];

    public int currentSize = 0;

    public int maxSize;

    public PhoneBook(int maxSize) {
        this.maxSize = maxSize;
        this.contacts = new Contact[maxSize];
    }

    public boolean addContact(Contact contact) {
        for (int i = 0; i < currentSize; i++) {
            if (contacts[i].getFirstName().equals(contact.getFirstName()) && contacts[i].getLastName().equals(contact.getLastName()) ){
                return false;
            }
        }
        contacts[currentSize] = contact;
        currentSize++;
        return true;
    }

    public boolean deleteContact(String firstName, String lastName) {
        for(int counter =0 ; counter<currentSize;counter++){
            if(contacts[counter].getFirstName().equals(firstName) && contacts[counter].getLastName().equals(lastName)){
                Contact temp ;
                temp = contacts[counter];
                contacts[counter] = contacts[currentSize];
                contacts[currentSize] = temp;
                contacts[currentSize] = null;
                currentSize--;
                return true;
            }
        }
        return false;
    }

    public Contact findContact(String firstName, String lastName) {
        for (int counter =0 ; counter<currentSize;counter++){
            if(contacts[counter].getFirstName().equals(firstName) && contacts[counter].getLastName().equals(lastName)){
                return contacts[counter];
            }
        }
        return null;
    }

    public Contact[] findContacts(String group) {
        Contact[] res = new Contact[maxSize];
        int resCounter = 0;
        for (int counter = 0 ; counter<currentSize;counter++){
            if(contacts[counter].getGroup().equals(group)){
                res[resCounter] = contacts[counter];
                resCounter++;
            }
        }
        return res;
    }

    public void printContact() {
        for (int counter = 0 ; counter<currentSize;counter++){
            System.out.println(contacts[counter]);
        }
    }
}
