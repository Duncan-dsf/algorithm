package dsf.algorithm.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/6 11:15
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.submit(ConcurrentTest::test);
//        executorService.submit(ConcurrentTest::test);
//        executorService.submit(SynchronizedTest::test);
//        executorService.submit(SynchronizedTest::test);
        executorService.submit(CASTest::test);
        executorService.submit(CASTest::test);

        Thread.sleep(1000);
        executorService.shutdownNow();
        // 2.6kw
//        System.out.println(ConcurrentTest.v);
        // 2.0kw
//        System.out.println(SynchronizedTest.v);
        // 5000w
        System.out.println(CASTest.v.get());
    }


}

class ConcurrentTest {

    static long v;
    static ReentrantLock lock = new ReentrantLock();
    public static void add() {
        lock.lock();
        try {
            v++;
        } finally {
            lock.unlock();
        }
    }

    public static void test() {
        while (!Thread.interrupted()) {
            add();
        }
    }
}

class SynchronizedTest {

    static long v;
    public static void add() {
        synchronized (SynchronizedTest.class) {
            v++;
        }
    }

    public static void test() {
        while (!Thread.interrupted()) {
            add();
        }
    }
}

/**
 * AtomicInteger 9000w
 */
class CASTest {

    static AtomicLong v = new AtomicLong(0);
    public static void add() {

        v.incrementAndGet();
    }
    public static void test() {
        while (!Thread.interrupted()) {
            add();
        }
    }
}
