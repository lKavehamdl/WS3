import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String line = "first";
        String tempName ;
        String tempFamily ;
        String tempGroup ;
        PhoneBook phoneBook = new PhoneBook(20);
        Scanner scanner = new Scanner(System.in);
        while (!line.equals("exit")) {
            line = scanner.nextLine();
            String[] arr = line.split(" ");
            if (arr[0].equals("contacts")) {
                if (arr[1].equals("-a")) {
                    tempName = arr[2];
                    tempFamily = arr[3];
                    Contact newContact = new Contact(tempName, tempFamily);
                    phoneBook.addContact(newContact);
                    System.out.println("enter group");
                    newContact.setGroup(scanner.nextLine());
                    System.out.println("enter email");
                    newContact.setEmail(scanner.nextLine());
                    System.out.println("enter country code");
                    String countryCode = scanner.nextLine();
                    System.out.println("enter phone number");
                    String phoneNumber = scanner.nextLine();
                    newContact.setPhoneNumber(new PhoneNumber(countryCode , phoneNumber));
                    System.out.println("enter zip code");
                    String zipCode = scanner.nextLine();
                    System.out.println("enter country");
                    String country = scanner.nextLine();
                    System.out.println("enter city");
                    String city = scanner.nextLine();
                    newContact.setAddress(new Address(zipCode , country , city));
                    System.out.println("added");
                }
                if (arr[1].equals("-r")) {
                    tempName = arr[2];
                    tempFamily = arr[3];
                    phoneBook.deleteContact(tempName, tempFamily);
                    System.out.println("removed");
                }
            }
            if (arr[0].equals("show")) {
                if(line.equals("show")){
                    phoneBook.printContact();
                }
                else if (arr[1].equals("-g")) {
                    tempGroup = arr[2];
                    Contact[] contacts = phoneBook.findContacts(tempGroup);
                    for (int i=0; contacts[i] != null ; i++) {
                        System.out.println(contacts[i]);
                    }
                } else if (arr[1].equals("-c")) {
                    tempName = arr[2];
                    tempFamily = arr[3];
                    System.out.println(phoneBook.findContact(tempName, tempFamily));
                }
            }
        }

        System.out.println("GoodBye!");
    }
}
