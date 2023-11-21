package Assgn2;

public class EmployeeWage {

    private static double calculateWage(int hoursWorked, double wagePerHour) {
        double dailyWage = hoursWorked * wagePerHour;
        return dailyWage;
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");

        int hoursWorked = 8;
        double wagePerHour = 20.0;
        double dailyWage = calculateWage(hoursWorked, wagePerHour);
        System.out.println("Daily Employee Wage: $" + dailyWage);
    }
}
