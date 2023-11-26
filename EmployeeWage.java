package Assgn2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    public static final int ABSENT = 0;
    public static final int PART_TIME = 1;
    public static final int FULL_TIME = 2;

    // Class method to get the type of employee for the day
    static int getEmployeeAttendance() {
        double randomNumber = Math.random();
        if (randomNumber < 0.2)
            return ABSENT;
        else if (randomNumber < 0.66)
            return PART_TIME;
        else
            return FULL_TIME;
    }
}

// class to get the instance variable and methods
class CompanyDetails {
    private String companyName;
    private int wagePerHour;
    private int fullDayHours;
    private int partTimeHours;
    private int workingDaysPerMonth;

    // parameterised constructor (for instance variable )
    public CompanyDetails(String companyName, int wagePerHour, int fullDayHours, int partTimeHours,
            int workingDaysPerMonth) {
        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.fullDayHours = fullDayHours;
        this.partTimeHours = partTimeHours;
        this.workingDaysPerMonth = workingDaysPerMonth;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getWagePerHour() {
        return wagePerHour;
    }

    public int getFullDayHours() {
        return fullDayHours;
    }

    public int getPartTimeHours() {
        return partTimeHours;
    }

    public int getWorkingDaysPerMonth() {
        return workingDaysPerMonth;
    }

}

class EmployeeWageCalculator {
    // private static final int WAGE_PER_HOUR = 20;
    // private static final int FULL_DAY_HOUR = 8;
    // private static final int PART_TIME_HOUR = 4;
    // private static final int WORKING_DAYS_PER_MONTH = 20;

    private final List<CompanyDetails> companyList;

    // constructor for array of comapnies
    public EmployeeWageCalculator(int companyNum) {
        companyList = new ArrayList<>();
    }

    public void addCompanies(CompanyDetails companyDetails, int index) {
        companyList.add(companyDetails);

    }

    public void calculateEmployeeWage() {
        for (CompanyDetails companyDetails : companyList) {
            calculateTotalWage(companyDetails);
        }
    }

    private static int calculateDailyWage(int wagePerHour, int hours) {
        return wagePerHour * hours;
    }

    static int calculateTotalWage(CompanyDetails details) {
        int totalWage = 0;
        System.out.println("\n\nCalculating wages for ".toUpperCase() + details.getCompanyName());
        for (int day = 0; day < details.getWorkingDaysPerMonth(); day++) {
            int employeeType = Employee.getEmployeeAttendance();
            switch (employeeType) {
                case Employee.ABSENT:
                    System.out.println("Day " + (day + 1) + ": Employee is Absent for" + details.getCompanyName());
                    break;
                case Employee.PART_TIME:
                    System.out.println("Day " + (day + 1) + ": Employee is Part-time for " + details.getCompanyName());
                    totalWage += calculateDailyWage(details.getWagePerHour(), details.getPartTimeHours());
                    // System.out.println("Wage of that day
                    // :"+calculateDailyWage(details.getWagePerHour(),details.getPartTimeHours()));
                    break;
                case Employee.FULL_TIME:
                    System.out.println("Day " + (day + 1) + ": Employee is Full-time  " + details.getCompanyName());
                    totalWage += calculateDailyWage(details.getWagePerHour(), details.getFullDayHours());
                    // System.out.println("Wage of that day
                    // :"+calculateDailyWage(details.getWagePerHour(),details.getFullDayHours()));
                    break;
            }
            System.out.println("\nTotal amount till the day :" + totalWage);
        }
        return totalWage;
    }
}

public class EmployeeWage {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program".toUpperCase());

        System.out.println("Enter the number of compaies");
        Scanner sc = new Scanner(System.in);

        int companyNum = sc.nextInt();

        EmployeeWageCalculator empWageCal = new EmployeeWageCalculator(companyNum);

        for (int i = 0; i < companyNum; i++) {
            System.out.println("\nEnter the name of company");
            String companyName = sc.next();
            System.out.println("Enter the wage amount per hour");
            int wagePerHour = sc.nextInt();
            System.out.println("Enter the hours for a full day work");
            int fullDayHours = sc.nextInt();
            System.out.println("Enter the hours for a part time work");
            int partTimeHours = sc.nextInt();
            System.out.println("Enter the working days in a month");
            int workingDaysPerMonth = sc.nextInt();

            CompanyDetails companyDetails = new CompanyDetails(companyName, wagePerHour, fullDayHours, partTimeHours,
                    workingDaysPerMonth);

            empWageCal.addCompanies(companyDetails, i);
        }
        empWageCal.calculateEmployeeWage();
        sc.close();

        // String company1 = "ABC";
        // int wagePerHour1 = 25;
        // int fullDayHour1 = 8;
        // int partTimeHour1 = 4;
        // int workingDaysPerMonth1 = 20;

        // int totalWage1 = EmployeeWageCalculator.CompanyDetails(company1,
        // wagePerHour1, fullDayHour1, partTimeHour1, workingDaysPerMonth1);

        // String company2 = "XYZ";
        // int wagePerHour2 = 22;
        // int fullDayHour2 = 7;
        // int partTimeHour2 = 3;
        // int workingDaysPerMonth2 = 25;
        // CompanyDetails companyDetails = new CompanyDetails(company1, wagePerHour1,
        // fullDayHour1, partTimeHour1, workingDaysPerMonth1);

        // int totalWage2 = EmployeeWageCalculator.calculateTotalWage(company2,
        // wagePerHour2, fullDayHour2, partTimeHour2, workingDaysPerMonth2);
        // System.out.println("\nTOTAL WAGE FOR COMPANY " + company2 + ": " +
        // totalWage2);
    }
}
