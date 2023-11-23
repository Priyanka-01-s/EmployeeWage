package Assgn2;

import java.util.Random;

class Employee {
    public static final int ABSENT = 0;
    public static final int PART_TIME = 1;
    public static final int FULL_TIME = 2;

    // Class method to get the type of employee for the day
    static int getEmployeeType() {
        double randomNumber = Math.random();
        if (randomNumber < 0.2)
            return ABSENT;
        else if (randomNumber < 0.66)
            return PART_TIME;
        else
            return FULL_TIME;
    }
}

class EmployeeWageCalculator {
    // private static final int WAGE_PER_HOUR = 20;
    // private static final int FULL_DAY_HOUR = 8;
    // private static final int PART_TIME_HOUR = 4;
    // private static final int WORKING_DAYS_PER_MONTH = 20;

    private static int calculateDailyWage(int wagePerHour, int hours) {
        return wagePerHour * hours;
    }

    static int calculateTotalWage(String companyName, int wagePerHour, int fullDayHour, int partTimeHour, int workingDaysPerMonth) {
        int totalWage = 0;
        System.out.println("Calculating wages for " + companyName);
        for (int day = 0; day < workingDaysPerMonth; day++) {
            int employeeType = Employee.getEmployeeType();
            switch (employeeType) {
                case Employee.ABSENT:
                    System.out.println("Day " + (day + 1) + ": Employee is Absent");
                    break;
                case Employee.PART_TIME:
                    System.out.println("Day " + (day + 1) + ": Employee is Part-time");
                    totalWage += calculateDailyWage(wagePerHour,partTimeHour);
                    break;
                case Employee.FULL_TIME:
                    System.out.println("Day " + (day + 1) + ": Employee is Full-time");
                    totalWage += calculateDailyWage(wagePerHour,fullDayHour);
                    break;
            }
        }
        return totalWage;
    }
}

public class EmployeeWage {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        String company1 = "Company1";
        int wagePerHour1 = 25;
        int fullDayHour1 = 8;
        int partTimeHour1 = 4;
        int workingDaysPerMonth1 = 20;

        // Calculate and display total wage for Company 1
        int totalWage1 = EmployeeWageCalculator.calculateTotalWage(company1, wagePerHour1, fullDayHour1, partTimeHour1, workingDaysPerMonth1);
        System.out.println("Total Wage for " + company1 + ": " + totalWage1);

        // Define parameters for Company 2
        String company2 = "Company2";
        int wagePerHour2 = 22;
        int fullDayHour2 = 7;
        int partTimeHour2 = 3;
        int workingDaysPerMonth2 = 25;

        // Calculate and display total wage for Company 2
        int totalWage2 = EmployeeWageCalculator.calculateTotalWage(company2, wagePerHour2, fullDayHour2, partTimeHour2, workingDaysPerMonth2);
        System.out.println("Total Wage for " + company2 + ": " + totalWage2);
    }
}
