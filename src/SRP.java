
// Single Responsibility Principle

// Don’t confuse the number of methods with number of responsibilities. 
// If the methods serve the same purpose (sending emails), 
// it’s fine to keep them together.


// For example, a EmailService class that:

// Sends welcome emails
// Sends password reset emails
// Sends payslip emails
// That’s fine — they all fall under the same responsibility: sending emails.

// But if that class also starts doing PDF generation or user authentication, 
// it’s time to split it up.

// Bad example of the Single Responsibility Principle
// Employee class has multiple responsibilities like calculating salary, saving to database, 
// generating payslip, and sending email
// This class should have only one responsibility
// Separate classes for each responsibility
// class Employee {
//     private String name;
//     private String email;
//     private double salary;

//     // Constructor, getters, setters...

//     public void calculateSalary() {
//         // Complex salary calculation logic
//         // Includes tax calculations
//     }

//     public void saveToDatabase() {
//         // Connect to database
//         // Prepare SQL
//         // Execute query
//     }

//     public void generatePayslip() {
//         // Format payslip
//         // Add company logo
//         // Convert to PDF
//     }

//     public void sendPayslipEmail() {
//         // Connect to email server
//         // Create email with attachment
//         // Send email
//     }
// }

// Good example of the Single Responsibility Principle
// Employee class has only one responsibility which is to store employee details only
class Employee {
    private String name;
    private String email;
    private double baseSalary;

    // Constructor
    public Employee(String name, String email, double baseSalary) {
        this.name = name;
        this.email = email;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getBaseSalary() {
        return baseSalary;
    }
}

// salary calculation class

class PayrollCalculator {
    public double calculateNetPay(Employee employee) {
        double base = employee.getBaseSalary();
        double tax = base * 0.2; // Sample tax logic
        double benefits = 1000; // Fixed benefit deduction
        return base - tax + benefits;
    }
}

// Persisence to db

class EmployeeRepository {
    public void save(Employee employee) {
        // Save employee details to the database
        System.out.println("Employee saved to the database." + employee.getName());
    }
}

// payslip generation class

class PayslipGenerator {
    public String generatePayslip(Employee employee, double netPay) {
        return "Payslip for: " + employee.getName() + "\n" +
                "Email: " + employee.getEmail() + "\n" +
                "Net Pay: ₹" + netPay + "\n" +
                "----------------------------\n";
    }
}

// email the payslip
class EmailService {
    public void sendPaySlip(Employee employee, String payslip) {
        System.out.println("Email sent to: " + employee.getEmail());
        System.out.println(payslip);
    }
}

public class SRP {

}
