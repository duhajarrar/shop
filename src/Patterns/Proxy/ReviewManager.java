package Patterns.Proxy;

public interface ReviewManager {
    void addReviewToList(int itemId, String review, int rating);
    String viewReviews(int itemId);
}

