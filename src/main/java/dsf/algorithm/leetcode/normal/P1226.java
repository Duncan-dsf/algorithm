package dsf.algorithm.leetcode.normal;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/9/1 13:21
 */
public class P1226 {



    Semaphore semaphore = new Semaphore(4);
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        semaphore.acquire();
        locks[philosopher].lock();
        locks[(philosopher+1)%4].lock();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putRightFork.run();
        putLeftFork.run();
        locks[(philosopher+1)%4].unlock();
        locks[philosopher].unlock();
        semaphore.release();
    }

    public void wantsToEat2(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        synchronized (this) {
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putRightFork.run();
            putLeftFork.run();
        }
    }

    private final ReentrantLock[] locks = new ReentrantLock[5];
    {
        locks[0] = new ReentrantLock();
        locks[1] = new ReentrantLock();
        locks[2] = new ReentrantLock();
        locks[3] = new ReentrantLock();
        locks[4] = new ReentrantLock();
    }
    public void wantsToEat1(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        int l = philosopher, r = (philosopher+1)%5;
        if (l % 2 == 0) {
            locks[l].lock();
            locks[r].lock();
        } else {
            locks[r].lock();
            locks[l].lock();

        }
        pickRightFork.run();
        pickLeftFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        locks[l].unlock();
        locks[r].unlock();
    }

//    public static void main(String[] args) {
//        P1226 ob = new P1226();
//        int n = 1;
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<5; j++) {
//                ob.wantsToEat(j);
//            }
//        }
//    }
//
//    class Pick implements Runnable {
//
//        int
//        @Override
//        public void run() {
//
//        }
//    }
}
