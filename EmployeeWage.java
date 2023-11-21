package Assgn2;

import java.util.Scanner;

public class EmployeeWage {
    private static double calculatePartTime(int hoursWorked, double wagePerHour) {

        int fullDayHours = 8;
        int partTimeHours = 4;
        double dailyWage = 0.0;
        dailyWage = hoursWorked * wagePerHour;
        if (hoursWorked == fullDayHours || hoursWorked == partTimeHours) {
            dailyWage = hoursWorked * wagePerHour;
        } else {
            System.out.println("Invalid hours worked.");
        }

        return dailyWage;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        System.out.println("Enter the working hours of the employeee");
        Scanner sc = new Scanner(System.in);
        int hours = sc.nextInt();
        double wagePerHour = 20.0;
        double partTimeWage = calculatePartTime(hours, wagePerHour);
        System.out.println("Employee Wage: $" + partTimeWage);

       

        sc.close();

    }
}
