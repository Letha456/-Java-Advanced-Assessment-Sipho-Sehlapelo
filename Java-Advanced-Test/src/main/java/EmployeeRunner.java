/**
 * @author : Sipho Sehlapelo
 * Project: IntelliJ IDEA
 * Date: 10/30/2026
 **/

public class EmployeeRunner {
    public static void main(String[] args) {
        Employee[] employees = new Employee[4];

        employees[0] = new Employee("EM123", "Mike", 25000.0, "Developer", Positions.Junior,"IT");
        employees[1] = new Employee("EM124", "Thabo", 26000.0, "Recruiter", Positions.Director,"HR");
        employees[2] = new Employee("EM125", "Jessica", 31000.0, "Tester", Positions.Intermediate,"IT");
        employees[3] = new Employee("EM126", "Lerato", 34000.0, "Accountant", Positions.Senior,"FINANCE");


        System.out.println("========================================");
        System.out.println("       INITIAL EMPLOYEE DETAILS         ");
        System.out.println("========================================");
        for (Employee emp : employees) {
            System.out.println(emp);
            System.out.println();
        }

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("========================================");
        System.out.println("  AFTER 15% RAISE & PROMOTION (7 YEARS) ");
        System.out.println("========================================");

        for (Employee emp : employees) {
            try {
                double newSalary = emp.raiseSalary(0.15);
                emp.setSalary(newSalary);


                Positions newPosition = emp.promote(7);
                emp.setPosition(newPosition);

            } catch (HighSalaryIncrease e) {
                System.out.println("Notice for " + emp.getEmployeeName() + ": " + e.getMessage());
            }


            System.out.println(emp);
            System.out.println();
        }
    }
}