public class MultithreadStuff extends Thread {


    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(i%10 == 0) System.out.print(i + " ");


            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}

        }
    }
}
