package Hospital;

public class Billing {

    private int[] b_no;
    private int[] b_amt;
    private String[] p_name;
    Patient patient;
    // Patient p = new Patient();
    // String[] p_name = p.getP_name();
    // int[] p_id = p.getP_id();

    public Billing() {

    }

    public Billing(int[] b_no, int[] b_amt, Patient patient) {
        this.b_no = b_no;
        this.b_amt = b_amt;
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

    public int[] getB_no() {
        return b_no;
    }

    public int[] getB_amt() {
        return b_amt;
    }
}