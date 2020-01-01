package synthesizer;
import synthesizer.ArrayRingBuffer;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        arb.enqueue(10);
        arb.enqueue(9);
        arb.enqueue(8);
        arb.enqueue(7);
        arb.enqueue(6);
        System.out.println(arb.peek());
        arb.dequeue();
        System.out.println(arb.peek());

    }
    @Test
    public void iterationTest(){
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(4);
        Iterator<Integer> it=arb.iterator();
        System.out.println("Printing arb through iterator");
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("Printing arb through iterator again");
        Iterator<Integer> it2=arb.iterator();
        while(it2.hasNext()){
            System.out.println(it2.next());
        }
    }
    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
