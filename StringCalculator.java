package TestClasses;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",";
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex);
            numbers = numbers.substring(delimiterIndex + 1);
        }

        String[] nums = numbers.split("[" + delimiter + "\n]");
        int sum = 0;
        StringBuilder negatives = new StringBuilder();

        for (String num : nums) {
            int n = Integer.parseInt(num);
            if (n < 0) {
                if (negatives.length() > 0) {
                    negatives.append(",");
                }
                negatives.append(n);
            }
            sum += n;
        }

        if (negatives.length() > 0) {
            throw new IllegalArgumentException("negative numbers not allowed: " + negatives);
        }

        return sum;
    }
}