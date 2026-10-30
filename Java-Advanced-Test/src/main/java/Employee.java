/**
 * @author : Sipho Sehlapelo
 * Project: IntelliJ IDEA
 * Date: 10/30/2026
 **/

public class Employee implements IEmployee{
    private static final double TAX = 0.15;
    private static final double HOUSE_ALLOWANCE = 0.08;

    private String employeeID;
    private String employeeName;
    private double salary;
    private String jobTitle;
    private Positions position;
    private String department;

    /**
     * Overloaded constructor to set the employee id, name, job title, position, department, basic salary of an Employee
     * @param employeeID
     * @param employeeName
     * @param salary
     * @param jobTitle
     * @param position
     */
    public Employee(String employeeID, String employeeName, double salary, String jobTitle, Positions position,String department) {
        setEmployeeID(employeeID);
        setEmployeeName(employeeName);
        setSalary(salary);
        setJobTitle(jobTitle);
        setPosition(position);
        setDepartment(department);
    }

    /**
     * Function that takes percentage as a parameter then increases the basic salary by the specified percentage  and return the new basic salary
     * @param percentage
     * @return the new basic salary of an empolyee after the get their increase
     */
    @Override
    public double raiseSalary(double percentage){
        if(percentage == 0){
            return getSalary();
        }

        double increaseAmount = getSalary() * percentage;

        if (increaseAmount > 5000.0) {
            throw new HighSalaryIncrease("Salary increase of R" + increaseAmount + " exceeds the limit of R5000!");
        }

        double newBasicSalary = getSalary() + increaseAmount;
        setSalary(newBasicSalary);
        return newBasicSalary;
    }

    /**
     * Function  takes no parameters, calculates and returns house allowance amount
     * @return house allowance amount
     */
    @Override
    public double calcHouseAllowance(){
        double houseAllowance;
        houseAllowance = getSalary() * HOUSE_ALLOWANCE;
        return houseAllowance;
    }

    /**
     * Function takes no parameters, calculates and returns thegross salary.
     * @return gross salary
     */
    @Override
    public double calcGrossSalary(){
        double houseAllowance = calcHouseAllowance();
        double grossSalary;
        grossSalary = getSalary() + houseAllowance;
        return  grossSalary;
    }

    /**
     * Function takes no parameters, calculates and returns the taxdeduction.
     * @return the tax deduction
     */
    @Override
    public double calcTax(){
        double grossSalary = calcGrossSalary();
        double taxDeduction = grossSalary * TAX;
        return taxDeduction;
    }

    /**
     * Function takes no parameters, calculates and returns the net salary
     * @return the net salary
     */
    @Override
    public double calcNetSalary(){
        double grossSalary = calcGrossSalary();
        double taxDeduction = calcTax();
        double netSalary = grossSalary - taxDeduction;
        return netSalary;
    }

    /**
     * Function  takes years of experience as a parameter and returns the new position of the employee
     * @param years
     * @return the new position of the employee
     */
        public Positions promote(int years) {
            if (years >= 3 && years <= 5) {
                if (getPosition() == Positions.Junior) {
                    return Positions.Intermediate;
                } else if (getPosition() == Positions.Intermediate) {
                    return Positions.Senior;
                }
            } else if (years >= 6 && years <= 10) {
                if (getPosition() == Positions.Intermediate) {
                    return Positions.Senior;
                } else if (getPosition() == Positions.Senior) {
                    return Positions.Director;
                }
            } else if (years > 10) {
                if (getPosition() == Positions.Senior) {
                    return Positions.Director;
                } else if (getPosition() == Positions.Director) {
                    return Positions.Executive;
                }
            }

            return getPosition();
        }


    @Override
    public String toString() {
        return String.format(
                "Employee: [%s] %s\n" +
                        "Title: %s\n" +
                        "Position: %s\n" +
                        "Department: %s\n" +
                        "======= Salary Breakdown =======\n" +
                        "Basic: R%.1f\n" +
                        "House Allowance: R%.1f\n" +
                        "Gross: R%.1f\n" +
                        "Tax Deduction: R%.1f\n" +
                        "Net: R%.1f\n" +
                        "++++++++++++++++++++++++++++++++++++",
                employeeID, employeeName, jobTitle, position, department,
                salary, calcHouseAllowance(), calcGrossSalary(), calcTax(), calcNetSalary()
        );
    }

    /**
     * Getter function to return the value of an Employees ID
     * @return the ID of an employee
     */
    public String getEmployeeID() {
        return employeeID;
    }

    /**
     * Setter function to set an Empolyees ID
     * @param employeeID
     */
    public void setEmployeeID(String employeeID) {
        if (employeeID == null || !employeeID.startsWith("EM")) {
            throw new IllegalArgumentException("Employee ID must start with 'EM'.");
        }
        this.employeeID = employeeID;
    }

    /**
     * Getter function to return the value of an Employees name
     * @return the name of an employee
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * Setter function to set an Empolyees name
     * @param employeeName
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * Getter function to return the value of an Employees salary
     * @return salary of an employee
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Setter function to set an Empolyees salary
     * @param salary
     */
    public void setSalary(double salary) {
        if (salary < 4000.0) {
            throw new IllegalArgumentException("Basic salary cannot be less than R4000.");
        }
        this.salary = salary;
    }

    /**
     * Getter function to return the value of an Employees Job tile
     * @return the jobTitle of an Employee
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * Setter function to set an Empolyees Job Title
     * @param jobTitle
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     * Getter function to return the value of an Empolyees position
     * @returns the position of an employee
     */
    public Positions getPosition() {
        return position;
    }

    /**
     * Setter function to set the Empolyees Position
     * @param position
     */
    public void setPosition(Positions position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
