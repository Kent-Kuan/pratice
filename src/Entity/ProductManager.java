package Entity;

import Issue.PhoneIssue;

public class ProductManager extends Employee {
    public ProductManager(String name, int id, int level) {
        super(name, id, level);
    }

    @Override
    public boolean process(PhoneIssue issue) {
        this.setFree(false);
        System.out.println(this.getName() + " Process " + issue.getName());
        return true;
    }
}
