package lab1b;

import java.time.LocalDate;

import lab1b.model.Employee;
import lab1b.model.PensionPlan;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
//import java.util.stream.Collectors;

public class Main {

     static Employee[] employees = new Employee[]{
             new Employee(1L, "Daniel", "Agar", LocalDate.of(2018, 01, 17), 842,74, 105945.50
                      ,"EX1089", LocalDate.of(2023,1,17), 100.00),
             new Employee(2L, "Benard", "Shaw", LocalDate.of(2019, 04, 03), 842,74,  197750.00
                      ,null, null, null),
             new Employee(3L, "Carly", "Agar", LocalDate.of(2019, 04, 03), 842,74,842842.00
                     ,"SM2307", LocalDate.of(2019,11,4), 1555.50),
             new Employee(4L, "Wesley", "Schneider", LocalDate.of(2019, 05, 02), 842,74,500.00
                   ,null, null, null)


             //     employees.get().setPensionPlan(new PensionPlan("EX1089", LocalDate.of(2018, 01, 17), 100.00)),
    //     employees.get().setPensionPlan(new PensionPlan("SM2307", LocalDate.of(2019, 11, 04), 1555.50)),
    //
 };

    static PensionPlan [] pensionPlans = new PensionPlan[]{
        new PensionPlan("EX1089", LocalDate.of(2018, 01, 17), 100.00),
       // new PensionPlan("", LocalDate.of(0, 0, 0), null),
        new PensionPlan("SM2307", LocalDate.of(2019, 11, 04) ,555.50)
 };



    public static void main(String[] args) {


//        employees[0].setPensionplan(new PensionPlan("EX1089", LocalDate.of(2018, 01, 17), 100.00));
//       employees[2].setPensionplan(new PensionPlan("SM2307", LocalDate.of(2019, 11, 04), 555.50));


        printEmployeesInJSON(employees);
        printMonthlyUpcomingEnrollees();

    }
    private static void printEmployeesInJSON(Employee[] employees) {
        if(employees != null) {
            if(employees.length > 0) {
                // Sort by product's name in ascending order
                var sortedemployees = Arrays.stream(employees)
                        .sorted(Comparator.comparing(Employee::getLastname)
                                .thenComparing(Employee::getYearlySalary, Comparator.reverseOrder()))
                        .toList();
                // Print in JSON format
              //  System.out.println("Printed in JSON Format");
                System.out.println("[");
//                sortedProducts.forEach(p -> System.out.println(p.toJSONString()));
                long numemployees = sortedemployees.size();
                for (int i = 0; i < numemployees; i++) {
                    if((i + 1) < numemployees ) {
                        System.out.printf("%s,\n", sortedemployees.get(i).JSONString());
                    } else {
                        System.out.println(sortedemployees.get(i).JSONString());
                    }

}
}

System.out.println("]");
}
}  private static void printMonthlyUpcomingEnrollees( ) {
        LocalDate nextMonth = LocalDate.now().plusMonths(1);
        LocalDate firstDayOfNextMonth = nextMonth.withDayOfMonth(1);
        LocalDate lastDayOfNextMonth = nextMonth.withDayOfMonth(nextMonth.lengthOfMonth());

        List<Employee> upcomingEnrollees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getEmploymentDate().plusYears(5).isBefore(lastDayOfNextMonth) ||
                    employee.getEmploymentDate().plusYears(5).isEqual(lastDayOfNextMonth)) {
                if (employee.getPensionplan() == null) {
                    upcomingEnrollees.add(employee);
                }
            }
        }

        printEmployeesInJSON(upcomingEnrollees.toArray(new Employee[0]));
    }


}