package musicapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Music {

    private final List<Integer> starsList;
    private double meanStars;

    public Music() {
        this.starsList = new ArrayList<>();
        this.meanStars = 0.0;
    }

    public Music(List<Integer> starsList) {
        this();
        if (starsList == null) {
            return;
        }

        for (Integer star : starsList) {
            if (star != null) {
                addStar(star);
            }
        }
    }

    public List<Integer> getStarsList() {
        return Collections.unmodifiableList(starsList);
    }

    public double getMeanStars() {
        return meanStars;
    }

    public void addStar(int star) {
        if (star < 1 || star > 5) {
            throw new IllegalArgumentException("Star value must be between 1 and 5.");
        }

        starsList.add(star);
        updateMeanStars();
    }

    private void updateMeanStars() {
        if (starsList.isEmpty()) {
            meanStars = 0.0;
            return;
        }

        int total = 0;
        for (int star : starsList) {
            total += star;
        }
        meanStars = (double) total / starsList.size();
    }

    @Override
    public String toString() {
        return "Music{meanStars=" + meanStars + ", ratings=" + starsList.size() + "}";
    }
}
