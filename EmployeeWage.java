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
    private static final int WAGE_PER_HOUR = 20;
    private static final int FULL_DAY_HOUR = 8;
    private static final int PART_TIME_HOUR = 4;
    private static final int WORKING_DAYS_PER_MONTH = 20;

    // Class method to calculate daily wage based on hours
    private static int calculateDailyWage(int hours) {
        return WAGE_PER_HOUR * hours;
    }

    // Class method to calculate total wage for the month
    static int calculateTotalWage() {
        int totalWage = 0;
        for (int day = 0; day < WORKING_DAYS_PER_MONTH; day++) {
            int employeeType = Employee.getEmployeeType();
            switch (employeeType) {
                case Employee.ABSENT:
                    System.out.println("Day " + (day + 1) + ": Employee is Absent");
                    break;
                case Employee.PART_TIME:
                    System.out.println("Day " + (day + 1) + ": Employee is Part-time");
                    totalWage += calculateDailyWage(PART_TIME_HOUR);
                    break;
                case Employee.FULL_TIME:
                    System.out.println("Day " + (day + 1) + ": Employee is Full-time");
                    totalWage += calculateDailyWage(FULL_DAY_HOUR);
                    break;
            }
        }
        return totalWage;
    }
}

public class EmployeeWage {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        int totalWage = EmployeeWageCalculator.calculateTotalWage();
        System.out.println("Total Wage for the Month: " + totalWage);
    }
}
