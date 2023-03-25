import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws InterruptedException {
/*        ArrayList<Integer> arr = new ArrayList<>();
        for(int i =0; i < 100; i++)
            arr.add(i);
        System.out.println(arr);
        System.out.println(arr.get(ar.get(0)));
        System.out.println(arr.get(arr.get(99)));
        System.out.println(arr.size());
        for (int i = 0; i < arr.size(); i++){
            System.out.println(arr.get(i));
        }
        for (Integer x : arr){
            System.out.println(x);
        }
        list.remove(5);
        System.out.println(arr);*/
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            list.add(i);
        System.out.println(list);
        System.out.println(list.get(list.get(0)));
        System.out.println(list.get(list.get(9)));
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        for (Integer x : list) {
            System.out.println(x);
        }
        list.remove(5);
        System.out.println(list);

        list = new LinkedList<Integer>();

/*        MyThead myThead = new MyThead();
        myThead.start();

        MyThead myThead1 = new MyThead();
        myThead1.start();*/

/*        System.out.println("I am going ro sleep");
        Thread.sleep(3000);
        System.out.println("I am wake");*/

/*        Thread thread = new Thread(new Runner());
        thread.start();
        System.out.println("Hello from main thead");*/

        MyThead1 myThead1 = new MyThead1();
        myThead1.start();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        myThead1.shutdown();
        new ThreadExample();
        new ThreadExample();
        new ThreadExample();
    }
}

class Runner implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from MyThead " + i);
        }
    }
}

class MyThead extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from MyThead " + i);
        }
    }
}

class MyThead1 extends MyThead {
    private volatile boolean running = true;

    public void run() {
        while (running) {
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        this.running = false;
    }
}
class ThreadExample extends Thread {
    public ThreadExample()
    {
        this.start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "Уступает место другим");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "Завершает выполнение");
    }
}

