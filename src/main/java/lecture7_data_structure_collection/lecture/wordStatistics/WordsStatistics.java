package lecture7_data_structure_collection.lecture.wordStatistics;

import java.util.*;

public class WordsStatistics {
    public static void main(String[] args) {
        String text = "Hello hello java Java JAVA world";
        String[] words = text.split(" ");
        System.out.println(getStatisticMap(words));
    }

    private static Map<String, Integer> getStatisticMap(String[] words) {
        Map<String, Integer> wordsCountMap = new HashMap<>();
        for (String word : words) {
            String w = word.toLowerCase();
            Integer count = wordsCountMap.get(w);
            if (count == null) {
                count = 1;
            } else {
                count += 1;
            }
            wordsCountMap.put(w, count);
        }
        return sort(Collections.unmodifiableMap(wordsCountMap));
    }

    private static Map<String, Integer> sort(Map<String, Integer> original) {
        Map<Integer, String> treeMap = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : original.entrySet()) {
            String prevValue = treeMap.put(entry.getValue(), entry.getKey());
            if (prevValue != null) {
                throw new IllegalStateException("Change the algorithm for this task");
            }
        }
        Map<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }
        return Collections.unmodifiableMap(result);
    }
}
