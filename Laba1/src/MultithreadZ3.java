public class MultithreadZ3 implements Runnable{
    private int interval =0;
    public MultithreadZ3(int interval){
        this.interval = interval;
    }

    @Override
    public void run() {

        while(true){

            try {
                Thread.sleep(interval);
                System.out.println("Сообщение кадждые " + interval/1000 + " секунд");
            } catch (InterruptedException e) {}

        }
    }
}
