import Entity.Employee;
import Entity.Fresher;
import Entity.ProductManager;
import Entity.TechnicalLead;
import Issue.PhoneIssue;

import java.util.*;

public class Main {
    public static final int ISSUES = 10;
    public static final int NUMBER_OF_FRESH = 8;
    public static void main(String[] args) {
        Random issueLevel = new Random();
        Queue<Employee>[] employees = new LinkedList[3];
        Queue<Employee> freshers = new LinkedList<>();
        for(int i=0; i<NUMBER_OF_FRESH; i++) {
            freshers.offer(new Fresher("Fresher" + i, i, 1));
        }
        Queue<Employee> technicalLead = new LinkedList<>();
        Queue<Employee> productManager = new LinkedList<>();
        technicalLead.offer(new TechnicalLead("TL", 98, 2));
        productManager.offer(new ProductManager("PM", 99, 3));
        employees[0] = freshers;
        employees[1] = technicalLead;
        employees[2] = productManager;

        PhoneIssue[] phoneIssue = new PhoneIssue[ISSUES];
        for(int i=0; i<ISSUES; i++) {
            phoneIssue[i] = new PhoneIssue("第" + (i+1) + "個問題", issueLevel.nextInt(3)+1 );
        }

        for(int i=0; i<ISSUES; i++) {
            if(!canProcessByEmployee(employees[0], phoneIssue[i])) {
                // fresher cannot handle
                if(!canProcessByEmployee(employees[1], phoneIssue[i])) {
                    // TL cannot handle
                    canProcessByEmployee(employees[2], phoneIssue[i]);
                }
            }
        }
    }

    private static boolean canProcessByEmployee(Queue<Employee> employees, PhoneIssue issue) {
        Employee employee = employees.poll();
        if(employee != null && employee.isFree() && employee.process(issue)) {
            waitToFree();
            employee.setFree(true);
            employees.offer(employee);
            return true;
        }
        return false;
    }

    private static void waitToFree() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
