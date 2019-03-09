import java.io.*;
        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

        import static java.util.stream.Collectors.joining;

public class FrequencyQueries {

    private static final Integer NO = 0;
    private static final Integer YES = 1;
    private static final int INSERT = 1;
    private static final int DELETE = 2;
    private static final int PRINT = 3;

    // Complete the freqQuery function below.
    private static List<Integer> freqQuery(int[][] queries, int q) {
        Map<Integer, Integer> mapFrequency = new HashMap<>();
        List<Integer> result = new ArrayList<>(1);
        Map<Integer, Integer> tracker = new HashMap<>();

        for (int i = 0; i < q; i++) {
            int frequencyValue = queries[i][1];
            int action = queries[i][0];
            int currentValue = mapFrequency.getOrDefault(frequencyValue, 0);

            if (action == INSERT) {
                updateTracker(tracker, currentValue, currentValue + 1);
                addFrequencyValue(mapFrequency, frequencyValue, currentValue);
            } else if (action == DELETE) {
                updateTracker(tracker, currentValue, currentValue - 1);
                removeFrequencyValue(mapFrequency, frequencyValue, currentValue);
            } else if (action == PRINT) {
                updateResultList(result, tracker, frequencyValue);
            }
        }
        return result;
    }

    private static void addFrequencyValue(Map<Integer, Integer> mapFrequency, int frequencyValue, int currentValue) {
        mapFrequency.put(frequencyValue, ++currentValue);
    }

    private static void removeFrequencyValue(Map<Integer, Integer> mapFrequency, int frequencyValue, int currentValue) {
        if (currentValue - 1 <= 0) {
            mapFrequency.remove(frequencyValue);
        } else {
            mapFrequency.put(frequencyValue, --currentValue);
        }
    }

    private static void updateResultList(List<Integer> result, Map<Integer, Integer> tracker, int frequencyValue) {
        if (tracker.containsKey(frequencyValue)) {
            result.add(YES);
        } else {
            result.add(NO);
        }
    }

    private static void updateTracker(Map<Integer, Integer> tracker, int oldKey, int newKey) {
        updateOldKeyIfExists(tracker, oldKey);
        updateNewKeyIfExists(tracker, newKey);
    }

    private static void updateNewKeyIfExists(Map<Integer, Integer> tracker, int newKey) {
        if (tracker.containsKey(newKey)) {
            tracker.put(newKey, tracker.get(newKey) + 1);
        } else {
            tracker.put(newKey, 1);
        }
    }

    private static void updateOldKeyIfExists(Map<Integer, Integer> tracker, int oldKey) {
        if (tracker.containsKey(oldKey)) {
            if (tracker.get(oldKey) - 1 == 0) {
                tracker.remove(oldKey);
            } else {
                tracker.put(oldKey, tracker.get(oldKey) - 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        int[][] queries = new int[q][2];

        for (int i = 0; i < q; i++) {
            String[] input = bufferedReader.readLine().trim().split("\\s+");
            queries[i][0] = Integer.parseInt(input[0]);
            queries[i][1] = Integer.parseInt(input[1]);
        }

        List<Integer> ans = freqQuery(queries, q);

        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

