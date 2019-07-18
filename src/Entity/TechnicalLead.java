package Entity;

import Issue.PhoneIssue;

public class TechnicalLead extends Employee {
    public TechnicalLead(String name, int id, int level) {
        super(name, id, level);
    }

    @Override
    public boolean process(PhoneIssue issue) {
        if(this.getLevel() < issue.getLevel()) {
            System.out.println(this.getName() + " 無法處理此問題，請 PM 協助。");
            return false;
        } else {
            this.setFree(false);
            System.out.println(this.getName() + " Process " + issue.getName());
            return true;
        }
    }
}
