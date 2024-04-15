package myquiz.myfirstquiz;

import myquiz.myfirstquiz.model.Contact;
import myquiz.myfirstquiz.model.EmailAdress;
import myquiz.myfirstquiz.model.Myenum;
import myquiz.myfirstquiz.model.PhoneNumber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static myquiz.myfirstquiz.model.Myenum.Home;


public class MyfirstQuizApplication {

	public static void main(String[] args) {

		PhoneNumber phoneNumber1 = new PhoneNumber("240-133-0011", Myenum.Home);
		PhoneNumber phoneNumber2 = new PhoneNumber("240-112-0123", Myenum.Work);
		EmailAdress emailAdress1 = new EmailAdress("dave.sang@gmail.com", Home);
		EmailAdress emailAdress2 = new EmailAdress("dsanger@argos.com", Myenum.Work);

		PhoneNumber phoneNumberunique = new PhoneNumber("412-116-9988", Myenum.Work);
		EmailAdress emailAdressunique = new EmailAdress("Ali@bmi.com", Myenum.Work);


		List<PhoneNumber> phoneNumbers = new ArrayList<>();
		phoneNumbers.add(phoneNumber1);
		phoneNumbers.add(phoneNumber2);

		List<EmailAdress> emailAddresses = new ArrayList<>();
		emailAddresses.add(emailAdress1);
		emailAddresses.add(emailAdress2);

		List<PhoneNumber> phoneNumbers3 = new ArrayList<>();
		phoneNumbers3.add(phoneNumberunique);

		List<EmailAdress> emailAddresses3 = new ArrayList<>();
		emailAddresses3.add(emailAdressunique);

		List<Contact> contacts = new ArrayList<>();
		contacts.add(new Contact("Dvid", "Snger", "Argos LLC",
						"sale manager",  phoneNumbers,emailAddresses ),
				new Contact("Carlos","Jimenez", "Zappos","Director" ),
				new Contact("Ali","Gafar", "BMI Services","HR Manager",phoneNumbers3,emailAddresses3 ),

		);


		printAllContacts(contacts);
		printasJsonFormat(contacts);

	}

	private static void printAllContacts(List<Contact> contacts) {
		contacts.stream()
				.sorted(Comparator.comparing(Contact::getLastName))
				.forEach(System.out::println);
	}

	private static void printasJsonFormat( List<Contact> contacts){

		for (int i = 0; i < contacts.size(); i++) {
			if((i + 1) < contacts.size() ) {
				System.out.printf("%s,\n", contacts.get(i).JSONString());
			} else {
				System.out.println(contacts.get(i).JSONString());
			}
		}

	}
}