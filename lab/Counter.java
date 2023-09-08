package lab;
import java.io.PrintWriter;

public class Counter {
    // counter value
    int value;
    int starting;

    // Initialize counter at 0
    public Counter() {
        this.value = 0;
        this.starting = 0;
    }

    // Initialize counter at starting value
    public Counter(int starting) {
        this.value = starting;
        this.starting = starting;
    }

    // Increment counter value
    public void increment() {
        this.value++;
    }
    // Increment counter value
    public void reset() {
        this.value = this.starting;
    }
    // Return current counter value
    public int get() {
        return this.value;
    }
    // Return current counter value
    public String toString() {
        return "< " + this.value + " >";
    }
    public static void main(String[] args) {
        PrintWriter pen = new PrintWriter(System.out, true);
        Counter c1 = new Counter(100);
        Counter c2 = new Counter();
        c1.increment();
        c1.increment();
        c2.increment();
        pen.println("c1: " + c1);
        c1.reset();
        pen.println("reset c1: " + c1);
        pen.println("c2: " + c2);
    }
}
