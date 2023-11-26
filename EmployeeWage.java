package Assgn2;


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

class CompanyDetails{
    private String companyName;
    private int wagePerHour;
    private int fullDayHours;
    private int partTimeHours;
    private int workingDaysPerMonth;
    
    //parameterised constructor (for instance variable )
    public CompanyDetails(String companyName,int wagePerHour,int fullDayHours,int partTimeHours,int workingDaysPerMonth){
        this.companyName= companyName;
        this.wagePerHour= wagePerHour;
        this.fullDayHours= fullDayHours;
        this.partTimeHours= partTimeHours;
        this.workingDaysPerMonth= workingDaysPerMonth;
    }

    public String getCompanyName(){
        return companyName;
    }

    public int getWagePerHour(){
        return wagePerHour;
    }
    public int getFullDayHours(){
        return fullDayHours;
    }
    public int getPartTimeHours(){
        return partTimeHours;
    }
    public int getWorkingDaysPerMonth(){
        return workingDaysPerMonth;
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

    static int calculateTotalWage(CompanyDetails details) {
        int totalWage = 0;
        System.out.println("Calculating wages for " + details.getCompanyName());
        for (int day = 0; day < details.getWorkingDaysPerMonth(); day++) {
            int employeeType = Employee.getEmployeeAttendance();
            switch (employeeType) {
                case Employee.ABSENT:
                    System.out.println("Day " + (day + 1) + ": Employee is Absent for" + details.getCompanyName());
                    break;
                case Employee.PART_TIME:
                    System.out.println("Day " + (day + 1) + ": Employee is Part-time for "+ details.getCompanyName());
                    totalWage += calculateDailyWage(details.getWagePerHour(),details.getPartTimeHours());
                    //System.out.println("Wage of that day :"+calculateDailyWage(details.getWagePerHour(),details.getPartTimeHours()));
                    break;
                case Employee.FULL_TIME:
                    System.out.println("Day " + (day + 1) + ": Employee is Full-time  "+details.getCompanyName());
                    totalWage += calculateDailyWage(details.getWagePerHour(),details.getFullDayHours());
                    //System.out.println("Wage of that day :"+calculateDailyWage(details.getWagePerHour(),details.getFullDayHours()));
                    break;
            }
            System.out.println("\nTotal amount till the day :"+ totalWage);
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
        CompanyDetails companyDetails = new CompanyDetails(company1, wagePerHour1, fullDayHour1, partTimeHour1, workingDaysPerMonth1);
        EmployeeWageCalculator.calculateTotalWage(companyDetails);
        //int totalWage1 = EmployeeWageCalculator.calculateTotalWage(company1, wagePerHour1, fullDayHour1, partTimeHour1, workingDaysPerMonth1);
        //System.out.println("Total Wage for " + company1 + ": " + totalWage1);

        // Define parameters for Company 2
        String company2 = "Company2";
        int wagePerHour2 = 22;
        int fullDayHour2 = 7;
        int partTimeHour2 = 3;
        int workingDaysPerMonth2 = 25;

        // Calculate and display total wage for Company 2
        CompanyDetails companyDetails2 = new CompanyDetails(company2, wagePerHour2, fullDayHour2, partTimeHour2, workingDaysPerMonth2);
        EmployeeWageCalculator.calculateTotalWage(companyDetails2);
        
        //System.out.println("Total Wage for " + company2 + ": " + totalWage2);
    }
}