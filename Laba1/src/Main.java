import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Буфер для хранения данных
class Buffer {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity;

    public Buffer(int capacity) {
        this.capacity = capacity;
    }

    // Метод для добавления данных в буфер
    public synchronized void produce(int value) throws InterruptedException {
        while (queue.size() == capacity) {

            System.out.println("Буфер заполнен. Ожидание потребителя...");
            wait();
        }

        queue.add(value);
        System.out.println("Производитель добавил: " + value);

        notifyAll();
    }

    // Метод для извлечения данных из буфера
    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {

            System.out.println("Буфер пуст. Ожидание производителя...");
            wait();
        }

        int value = queue.poll();
        System.out.println("Потребитель забрал: " + value);

        notifyAll();
        return value;
    }
}



public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while(true) {
            System.out.println("Выберете номер задания");
            int opt=in.nextInt();
            switch (opt) {
                case (1):
                    System.out.println("Задание 1");
                    MultithreadStuff myStuff = new MultithreadStuff();
                    System.out.println(myStuff.getName());
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
                case(4):
                    System.out.println("Задание 4");
                    Buffer buffer = new Buffer(5);
                    Thread proizvod = new Thread(new Proizvod(buffer));
                    proizvod.start();

                    Thread potreb = new Thread(new Potrebitel(buffer));
                    potreb.start();

                    break;
                default:
                    System.out.println("Введи нормальный номер задания кожанный");
                    break;
            }
        }

    }
}