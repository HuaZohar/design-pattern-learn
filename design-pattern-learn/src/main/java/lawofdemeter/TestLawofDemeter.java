package lawofdemeter;

public class TestLawofDemeter {
    public static void main(String[] args) {
        Agent agent = new Agent();
        agent.setMyCompany(new Company("中国传媒有限公司"));
        agent.setMyFans(new Fans("粉丝韩丞"));
        agent.setMyStar(new Star("林心如"));

        agent.meeting();

        agent.business();
    }
}

class Agent {
    private Star myStar;
    private Fans myFans;
    private Company myCompany;

    public void setMyStar(Star myStar) {
        this.myStar = myStar;
    }

    public void setMyFans(Fans myFans) {
        this.myFans = myFans;
    }

    public void setMyCompany(Company myCompany) {
        this.myCompany = myCompany;
    }


    public void meeting() {
        System.out.println(myFans.getName() + "与明星" + myStar.getName() + "见面了");
    }

    public void business() {
        System.out.println(myCompany.getName() + "与明星" + myStar.getName() + "进行洽谈");
    }

}

class Star {
    private String name;

    public Star(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Fans {
    private String name;

    public Fans(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

class Company {
    private String name;

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
