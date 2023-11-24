package Patterns.Proxy;

import Models.Customer;

public class ReviewProxy implements ReviewManager {
    private ItemReviewManager reviewManager;
    private Customer currentUser;

    public ReviewProxy() {
        this.reviewManager = new ItemReviewManager();
    }

    
    public Customer getCurrentUser() {
        return currentUser;
    }


    public void setCurrentUser(Customer currentUser) {
        this.currentUser = currentUser;
    }


    @Override
    public void addReviewToList(int itemId, String review, int rating) {
        if (currentUser != null){
            if (currentUser.isAuthorized()) {
                reviewManager.addReviewToList(itemId, review, rating);
            } else {
                System.out.println("Access denied: User not authorized to add reviews.");
            }
        }
    }

    @Override
    public String viewReviews(int itemId) {
        if (currentUser != null){
            if (currentUser.isAuthorized()) {
                return reviewManager.viewReviews(itemId);
            }else {
                return "Access denied: User not authorized to add reviews.";
            }
        }
        return "Set the user in the proxy to view reviews";
    }


    
}

