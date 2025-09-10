package Week99_Final_Test_Sample;

public class P1_SecretSearch {
    public static void main(String[] args){
        P1_SecretSearch p1_SecretSearch = new P1_SecretSearch(-1, 1 ,1, 1, -2, 0.5);
        System.out.println(p1_SecretSearch.timeFromA(0));
        return;
    } 

    double xa, ya, va, xb, yb, vb = 0;
    public P1_SecretSearch(double xa, double ya, double va,
                        double xb, double yb, double vb){
        this.xa = xa;
        this.ya = ya;
        this.va = va;
        this.xb = xb;
        this.yb = yb;
        this.vb = vb;
    }

    public double timeFromA(double XZ){
        double xz = XZ;
        double yz = 0;

        // Math.pow(base, 2); // Raise to the power of 2
        double distance = Math.sqrt(Math.pow(Math.abs(xz - xa), 2) + Math.sqrt(Math.pow(Math.abs(yz - ya), 2)));
        double timeRes = distance * va;

        return timeRes;
    }
}
