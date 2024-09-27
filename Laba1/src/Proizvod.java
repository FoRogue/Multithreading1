import java.util.Random;

public class Proizvod implements  Runnable{

    private final Buffer buffer;
    public Proizvod(Buffer bufffer){
        this.buffer =bufffer;
    }


    private int generator(){
        int rnd = new Random().nextInt(1000);
        return rnd;
    }

    @Override
    public void run() {
        int value = 0;
        try {
            while (true) {
                value = generator();
                buffer.produce(value++);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
