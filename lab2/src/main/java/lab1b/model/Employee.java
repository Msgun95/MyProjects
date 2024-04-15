package lab1b.model;

import java.time.LocalDate;

public class Employee {

private Long employeeId;
private String firstname;
private String lastname;
private LocalDate employmentDate;
private Double yearlySalary;
private PensionPlan pensionPlan = new PensionPlan();



public Employee(long l, String string, String string2, LocalDate localDate, int i, double d) {
}
public Employee(Long employeeId, String firstname, String lastname, LocalDate employmentDate, int i, int j,
                Double yearlySalary,
                String planReferenceNumber, LocalDate enrollmentDate,
                Double monthlyContribution) {
    this.employeeId = employeeId;
    this.firstname = firstname;
    this.lastname = lastname;
    this.employmentDate = employmentDate;
    this.yearlySalary = yearlySalary;
    pensionPlan = (planReferenceNumber == null) ? null : new PensionPlan(planReferenceNumber, enrollmentDate, monthlyContribution);
}

public Long getEmployeeId() {
    return employeeId;
}
public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
}
public String getFirstname() {
    return firstname;
}
public void setFirstname(String firstname) {
    this.firstname = firstname;
}
public String getLastname() {
    return lastname;
}
public void setLastname(String lastname) {
    this.lastname = lastname;
}
public LocalDate getEmploymentDate() {
    return employmentDate;
}
public void setEmploymentDate(LocalDate employmentDate) {
    this.employmentDate = employmentDate;
}
public Double getYearlySalary() {
    return yearlySalary != null ? yearlySalary : 0.0;
}
public void setYearlySalary(Double yearlySalary) {
    this.yearlySalary = yearlySalary;
}


// @Override
// public String toString() {
//     return "Employee [employeeId=" + employeeId + ", firstname=" + firstname + ", lastname=" + lastname
//             + ", employmentDate=" + employmentDate + ", yearlySalary=" + yearlySalary + "]";
// }




public PensionPlan getPensionplan() {
    return pensionPlan;
}
public void setPensionplan(PensionPlan pensionplan) {
    this.pensionPlan = pensionPlan;
}


//@Override
//public String toString() {
//    final StringBuilder sb = new StringBuilder("Employee{");
//    sb.append("employeeId=").append(employeeId);
//    sb.append(", firstname='").append(firstname).append('\'');
//    sb.append(", lastname=").append(lastname);
//    sb.append(", employmentDate=").append(employmentDate);
//    sb.append(", yearlySalary=").append(yearlySalary);
//    sb.append('}');
//    return sb.toString();
//}


    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", employmentDate=" + employmentDate +
                ", yearlySalary=" + yearlySalary +
                ", pensionPlan=" + pensionPlan +
                '}';
    }

    public String JSONString() {
    return String.format("\t{ \"employeeId\":%d, \"firstName\":\"%s\", \"lastName\":\"%s\", \"employmentDate\":\"%s\", \"yearlySalary\":%,.2f }",
            employeeId, firstname, lastname, employmentDate, yearlySalary);
}


    
}
