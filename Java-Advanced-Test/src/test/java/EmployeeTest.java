import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author : Sipho Sehlapelo
 * Project: IntelliJ IDEA
 * Date: 10/30/2026
 **/

public class EmployeeTest {

    Employee objEmp;

    @BeforeEach
    void setupAccount(){
        objEmp = new Employee("EM123", "Sipho",10000,"SQA",Positions.Junior,"IT");
    }

    @Test
    @DisplayName("TC1 - Raise Salary")
    void testRaiseSalary(){
        double expectedNewBasicSalary = 11000;
        double percentageIncrease = 0.10;
        double actualNewBasicSalary = objEmp.raiseSalary(percentageIncrease);
        assertEquals(expectedNewBasicSalary, actualNewBasicSalary);
    }

    @Test
    @DisplayName("TC2 - Calculate House Allowance")
    void testCalculateHouseAllowance(){
        double expectedHouseAllowance = 10000 * 0.08;
        double actualHouseAllowance = objEmp.calcHouseAllowance();
        assertEquals(expectedHouseAllowance, actualHouseAllowance);
    }

    @Test
    @DisplayName("TC3 - Calculate Gross Salary")
    void testCalcGrossSalary(){
        double expectedGrossSalary = 10000 + (10000 * 0.08);
        double actualGrossSalary = objEmp.calcGrossSalary();
        assertEquals(expectedGrossSalary,actualGrossSalary);
    }

    @Test
    @DisplayName("TC4 - Calculate Tax Deduction")
    void testCalcTax(){
        double expectedTaxDeduction =  (10000 + (10000 * 0.08)) * 0.15;
        double actualTaxDeduction = objEmp.calcTax();
        assertEquals(expectedTaxDeduction,actualTaxDeduction);
    }

    @Test
    @DisplayName("TC5 - Calculate Net Salary")
    void testCalcNetSalary(){
        double expectedNetSalary = (10000 + (10000 * 0.08)) - ((10000 + (10000 * 0.08)) * 0.15);
        double actualNetSalary = objEmp.calcNetSalary();
        assertEquals(expectedNetSalary,actualNetSalary);
    }

}
