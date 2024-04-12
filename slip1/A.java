public class slip1_a {
    public static void main(String[] args) {
        char start = 'A';
        char end = 'Z';
        for (char c = start; c <= end; c++) {
            System.out.print(c + " ");
            try {
                Thread.sleep(2000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
