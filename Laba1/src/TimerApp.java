public class TimerApp implements Runnable{
    private long startTime;
    public TimerApp(){
        this.startTime = System.currentTimeMillis();
    }
    @Override
    public void run() {
        while(true){
            long elapseTime = (System.currentTimeMillis() - startTime)/1000;
            System.out.println("Прошло времени: "+ elapseTime);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
