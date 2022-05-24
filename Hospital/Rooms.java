package Hospital;

public class Rooms {
    private int[] r_no;
    private String[] r_loc;

    public Rooms(int[] r_no, String[] r_loc) {
        this.r_no = r_no;
        this.r_loc = r_loc;
    }

    public String[] getR_loc() {
        return r_loc;
    }

    public int[] getR_no() {
        return r_no;
    }
}
