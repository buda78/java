public class A extends Thread {
    String str;
    int n;

    A(String str, int n) {
        this.str = str;
        this.n = n;
    }
    
    public void run() {
        try {
            for (int i=0;i<n;i++) {
                System.out.println(getName() + " : " + str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        A t1 = new A("COVID19", 10);
        A t2 = new A("LOCKDOWN2020", 20);
        A t3 = new A("VACCINATED", 30);

        t1.start();
        t2.start();
        t3.start();

    }
}

