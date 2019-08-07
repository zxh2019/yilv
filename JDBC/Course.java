package day18.jdbc;

public class Course {

    private int cno;
    private String cname;
    private int cpno;
    private int ccredit;

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getCpno() {
        return cpno;
    }

    public void setCpno(int cpno) {
        this.cpno = cpno;
    }

    public int getCcredit() {
        return ccredit;
    }

    public void setCcredit(int ccredit) {
        this.ccredit = ccredit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cno=" + cno +
                ", cname='" + cname + '\'' +
                ", cpno=" + cpno +
                ", ccredit=" + ccredit +
                '}';
    }
}
