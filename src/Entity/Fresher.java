package Entity;

import Issue.PhoneIssue;

public class Fresher extends Employee implements Runnable{

    public Fresher(String name, int id, int level) {
        super(name, id, level);
    }

    @Override
    public boolean process(PhoneIssue issue) {
        this.setFree(false);
        if(this.getLevel() < issue.getLevel()) {
            System.out.println(this.getName() + " 無法處理此問題，請 TL 協助。");
            return false;
        } else {
            System.out.println(this.getName() + " Process " + issue.getName());
            return true;
        }
    }

    @Override
    public void run() {
        this.setFree(true);
    }
}
