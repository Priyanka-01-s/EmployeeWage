package Assgn2;

import java.util.Scanner;

public class EmployeeWage {

    public static double monthlyAmount(int workingdays){
        int hours = 8;
        double wage = 20.0;
        double amount = hours*wage*workingdays;

        return amount;
    }
    public static void main(String[] args){
        System.out.println("Welcome to Employee Wage Computation Program");
        System.out.println("Enter the number of working days in a month");
        Scanner sc = new Scanner(System.in);
        int workingdays = sc.nextInt();
        double totalAmt;
        totalAmt = monthlyAmount(workingdays);
        System.out.print("The monthly salary of the employee(only full working days): "+ totalAmt);

        sc.close();

    }
}
