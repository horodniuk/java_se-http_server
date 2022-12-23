package lecture9_multithreading.lecture3.concurrent.semaphore;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CasStationRunner {
    public static void main(String[] args) throws InterruptedException {
        Semaphore stations = new Semaphore(2);
        final var threads = Stream.of(
                        new PetrolStation(100, stations),
                        new PetrolStation(100, stations),
                        new PetrolStation(100, stations),
                        new PetrolStation(100, stations),
                        new PetrolStation(100, stations),
                        new PetrolStation(100, stations),
                        new PetrolStation(100, stations),
                        new PetrolStation(100, stations)
                ).map(Thread::new)
                 .peek(Thread::start)
                 .collect(Collectors.toList());

        for (Thread thread:threads) {
            thread.join();
        }
    }
}
