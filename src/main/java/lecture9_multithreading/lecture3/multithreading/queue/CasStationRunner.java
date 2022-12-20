package lecture9_multithreading.lecture3.multithreading.queue;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CasStationRunner {
    public static void main(String[] args) throws InterruptedException {
        Queue<FuelDispenser> stations = new ArrayDeque<FuelDispenser>(
                List.of(new FuelDispenser(), new FuelDispenser(), new FuelDispenser()));
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
