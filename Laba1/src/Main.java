import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        //boolean flag = false;
        while(true) {
            System.out.println("Выберете номер задания");
            int opt=in.nextInt();
            switch (opt) {
                case (1):
                    System.out.println("Задание 1");
                    MultithreadStuff myStuff = new MultithreadStuff();
                    myStuff.start();

                    break;
                case (2):
                    System.out.println("Задание 2");
                    MultithreadThing myThing = new MultithreadThing();
                    Thread myThread = new Thread(myThing);
                    myThread.start();
                    break;
                case(3):
                    System.out.println(" ");
                    Thread timerThread = new Thread(new TimerApp());
                    Thread message5 = new Thread(new MultithreadZ3(5000));
                    Thread message7 = new Thread(new MultithreadZ3(7000));

                    timerThread.start();
                    message5.start();
                    message7.start();

                    break;
                default:
                    System.out.println("Введи нормальный номер задания кожанный");
                    break;
            }
        }

    }
}