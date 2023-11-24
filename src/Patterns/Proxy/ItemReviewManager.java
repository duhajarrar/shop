package Patterns.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class ItemReviewManager implements ReviewManager {
    private Map<String, List<String>> itemReviews;

    public ItemReviewManager() {
        itemReviews = new HashMap<>();
    }

    @Override
    public void addReviewToList(int itemId, String review, int rating) {
        itemReviews.computeIfAbsent(Integer.toString(itemId), k -> new ArrayList<>()).add(review + " - Rating: " + rating);
        System.err.println("Review: "+itemReviews.toString());
    }

    @Override
    public String viewReviews(int itemId) {
        return String.join("\n", itemReviews.getOrDefault(Integer.toString(itemId), new ArrayList<>()));
    }
}

