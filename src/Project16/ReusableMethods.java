package Project16;

public class ReusableMethods {
    public void Waiter(int sec){
        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
