/*
 * This class stores scores and provide calibrated average about the scores from 6 judges.
 * This class will be used as a part of the Competitor class.
 */
import java.util.Arrays;
import java.util.List;

public class Score {
    private double jumpScore; // declaration
    private double[] styleScore; // declaration

    //The constructor should set all given attributes to 0.
    public Score() {
        //TODO: Code HERE
        jumpScore = 0.0; // assignment "jumpScore"
        styleScore = new double[6]; // 6 elements in this arrays
    }

    //This method set the jumpScore to the given score
    public void setScores(double score) { // This method gets called by runtime
        jumpScore = score;
    }

    //This method set the styleScore to the given score
    public void setScores(double[] scores) { // This method gets called by runtime
        System.arraycopy(scores, 0, styleScore, 0, styleScore.length);
        /* method is in import java.util.Arrays;
        This method copies an array from a source array to a destination array, starting the copy action from
        source position to the target position till the specified*/

        // Rough Code = First Code
        /* for(int i = 0 ; i < styleScore.length; i++) {
            styleScore[i] = scores[i];
            is equivalent (For-each loop) to for (double i : styleScore) {i = scores;}
        }*/
    }

    //This method return the jumpScore
    public double getJumpScores() {
        //TODO: Code HERE
        return jumpScore;
    }

    //This method return the styleScore
    public double[] getStyleScore() {
        //TODO: Code HERE
        return styleScore;
    }

    /*
     * Return the average of the scores after excluding the minimum and maximum
     * value. In short, it should return
     *   (SUM(this.scores) - MIN(this.scores) - MAX(this.scores))/(n-2), where
     * n is the length of the score list.
     */
    public double getCalibratedAverage() {
        //TODO: Code HERE
        double min = styleScore[0], max = styleScore[0];
        double sum = 0;

        for (double v : styleScore) {
            sum += v; // sum = sum + v;
            if (v < min) {
                min = v;
            }
            if (v > max) {
                max = v;
            }
        }

         /* is equivalent (For-loop)
        for(int i = 0 ; i < styleScore.length; i++) {

            if(this.styleScore[i] < min) {
                min = styleScore[i];
            }
            if(styleScore[i] > max) {
                max = styleScore[i];
            }
        }
         */

        sum = sum - min - max; // (SUM(this.scores) - MIN(this.scores) - MAX(this.scores))
        return sum / (styleScore.length-2); // sum / (n-2)
    }

    //This main is for testing your output
    public static void main(String[] args) {
        Score s1 = new Score();
        s1.setScores(9.5);
        s1.setScores(new double[] {5.5, 4.5, 3.5, 2.5, 1.5, 6.5});
        System.out.println(s1.getJumpScores());
        System.out.println(Arrays.toString(s1.getStyleScore()));
        System.out.println(s1.getCalibratedAverage());
    }
}