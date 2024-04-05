package myquiz.myfirstquiz.model;

import java.util.List;

public class Contact {

    private String firstName;
    private String lastName;
    private String company;
    private String jobTitle;
    private List <PhoneNumber> phoneNumbers;
    private List<EmailAdress> emailAddresses;

    public Contact(String firstName, String lastName, String company, String jobTitle,
                   List<PhoneNumber> phoneNumbers, List<EmailAdress> emailAddresses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.jobTitle = jobTitle;
        this.phoneNumbers = phoneNumbers;
        this.emailAddresses = emailAddresses;
    }

    public Contact(String firstName, String lastName, String company, String jobTitle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.jobTitle = jobTitle;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<EmailAdress> getEmailAddresses() {
        return emailAddresses;
    }

    public void setEmailAddresses(List<EmailAdress> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company='" + company + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                ", emailAddresses=" + emailAddresses +
                '}';
    }

    public String JSONString() {
        return String.format("\t{  \"firstName\":\"%s\", \"lastName\":\"%s\", \"company\":\"%s\", \"jobTitle\":\"%s\" }",
                firstName, lastName, company, jobTitle);
    }
}
