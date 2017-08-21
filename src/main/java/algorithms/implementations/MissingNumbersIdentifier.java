package algorithms.implementations;

import java.util.*;
import java.util.stream.Collectors;

public class MissingNumbersIdentifier {
    public static List<Integer> identifyMissingNumbers(List<Integer> values1, List<Integer> values2) {
        Map<Integer, Integer> numberCounts = new HashMap<>();

        for (Integer value : values1) {
            Integer count = numberCounts.get(value);
            if (count == null) {
                numberCounts.put(value, 1);
            } else {
                numberCounts.put(value, count + 1);
            }
        }

        List<Integer> missingNumbers = new ArrayList<>();

        for (Integer value : values2) {
            Integer count = numberCounts.get(value);
            if (count != null) {
                numberCounts.put(value, count - 1);
            } else if (!missingNumbers.contains(value)){
                missingNumbers.add(value);
            }
        }

        missingNumbers.addAll(numberCounts.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .map(Map.Entry<Integer, Integer>::getKey)
                .collect(Collectors.toList()));

        Collections.sort(missingNumbers);

        return missingNumbers;
    }
}
