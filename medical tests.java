import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicalTestResults {
    public static void main(String[] args) {
        List<Integer> testResults = new ArrayList<>();
        testResults.add(120);
        testResults.add(150);
        testResults.add(200);
        testResults.add(250);
        testResults.add(300);
        testResults.add(350);

        Map<String, List<Integer>> resultRanges = new HashMap<>();
        resultRanges.put("normal", new ArrayList<>());
        resultRanges.put("borderline", new ArrayList<>());
        resultRanges.put("high", new ArrayList<>());

        for (int result : testResults) {
            if (result <= 130) {
                resultRanges.get("normal").add(result);
            } else if (result <= 180) {
                resultRanges.get("borderline").add(result);
            } else {
                resultRanges.get("high").add(result);
            }
        }

        System.out.println("Number of patients in each range:");
        for (Map.Entry<String, List<Integer>> entry : resultRanges.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().size());
        }

        System.out.println("\nAverage value for each range:");
        for (Map.Entry<String, List<Integer>> entry : resultRanges.entrySet()) {
            double sum = entry.getValue().stream().mapToInt(Integer::intValue).sum();
            double average = sum / entry.getValue().size();
            System.out.println(entry.getKey() + ": " + average);
        }
    }
}
