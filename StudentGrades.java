public class StudentGrades {
    
    public static double calculateAverage(int[] scores) {
        // Input validation
        if (scores == null) {
            throw new IllegalArgumentException("Scores array cannot be null.");
        }
        if (scores.length == 0) {
            throw new IllegalArgumentException("Scores array cannot be empty.");
        }
        
        int sum = 0;
        for (int score : scores) {
            if (score < 0 || score > 100) {
                throw new IllegalArgumentException(
                    "Score cannot be " + (score < 0 ? "less than 0." : "greater than 100.")
                );
            }
            sum += score;
        }
        
        double average = (double) sum / scores.length;
        
        // Custom exception check
        if (average < 40) {
            throw new FailedSignificantlyException(
                "Student average is " + average + ", which is a significant failure."
            );
        }
        
        return average;
    }
}
