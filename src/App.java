import java.util.Scanner;
import Models.*;
import Models.Notification.*;

import Patterns.ChainOfResponsibility.*;
import Patterns.Command.*;
import Patterns.Decorator.*;
import Patterns.Factory.*;
import Patterns.Memento.*;
import Patterns.Observer.*;
import Patterns.Proxy.*;
import Patterns.State.*;
import Patterns.Strategy.*;

public class App {
    static Scanner scanner = new Scanner(System.in);
    static PaymentProcessor paymentProcessor = new PaymentProcessor();
    
    static AuthManager customersManager = new AuthManager();
    
    static Customer currentUser = null;
    static Store currentStore = null;
    static Item currentItem = null;
    static Order currentOrder = null;

    static String username = "user";
    static String password = "pass";
    
    static CartObserver shoppingObserver = new CartObserverImp();
    static CustomerObserver customerObserver = new CustomerObserverImp();
    static OrderObserver orderObserver = new OrderObserverImp();
    
    static OrderInvoker invoker = new OrderInvoker();
    static Mall mall = Mall.getInstance();

    static ShoppingCart shoppingCart = mall.getShoppingCart();
    static NotificationSubject notificationSystem = new NotificationSystem();
    static ShoppingCartMemento shoppingCartMemento;
    static ReviewProxy reviewProxy = new ReviewProxy();
    
    public static void main(String[] args) throws Exception {
        notificationSystem.addObserver(customerObserver);
        shoppingCart.addObserver(shoppingObserver);
        
        initializeCustomers(); 
        initializeDate();
        run();      
    }

    private static void initializeCustomers(){
        customersManager.signUp(username+"0", password+"0");
        customersManager.signUp(username+"1", password+"1");
        customersManager.signUp(username+"2", password+"2");
        customersManager.signUp(username+"3", password+"3");
    }

    private static void initializeDate() {
        Mall mall = Mall.getInstance();

        StoreFactory bookStoreFactory = BookStoreFactory.getInstance();
        StoreFactory gameStoreFactory = GameStoreFactory.getInstance();
        StoreFactory shoeStoreFactory = ShoeStoreFactory.getInstance();
        
        Store bookStore = bookStoreFactory.createStore("Book Store");
        Store gameStore = gameStoreFactory.createStore("Puzzles Store");
        Store shoeStore = shoeStoreFactory.createStore("Shoes Store"); 

        Item book = bookStoreFactory.getItemFactory().createItem("Design Book 1",bookStore.getStoreId(),100);
        Item book1 = bookStoreFactory.getItemFactory().createItem("Security Book",bookStore.getStoreId(),50);
        Item book2 = bookStoreFactory.getItemFactory().createItem("Arabic Book",bookStore.getStoreId(),70);
        Item book3 = bookStoreFactory.getItemFactory().createItem("English Book",bookStore.getStoreId(),80);
        Item discBook = bookStoreFactory.getItemFactory().createItem("Math Book",bookStore.getStoreId(),100);
        Item discountedBook = new PercentageDiscountDecorator(discBook,10);

        Item puzzle100 = gameStoreFactory.getItemFactory().createItem("Puzzles 100",gameStore.getStoreId(),10);
        Item puzzle500 = gameStoreFactory.getItemFactory().createItem("Puzzles 500",gameStore.getStoreId(),50);
        Item puzzle1000 = gameStoreFactory.getItemFactory().createItem("Puzzles 1000",gameStore.getStoreId(),100);
        Item puzzle2000 = gameStoreFactory.getItemFactory().createItem("Puzzles 2000",gameStore.getStoreId(),200);
        Item puzzle4000 = gameStoreFactory.getItemFactory().createItem("Puzzles 4000",gameStore.getStoreId(),400);


        Item sandal = shoeStoreFactory.getItemFactory().createItem("Sandal",shoeStore.getStoreId(),150);
        Item sportBoot = shoeStoreFactory.getItemFactory().createItem("Sports boot",shoeStore.getStoreId(),300);
        Item sportBoot1 = shoeStoreFactory.getItemFactory().createItem("Nike boot",shoeStore.getStoreId(),200);
        Item discountedSportBoot = new QuantityDiscountDecorator(sportBoot1,100);
        Item kidsBoot = shoeStoreFactory.getItemFactory().createItem("Kids Boot",shoeStore.getStoreId(),50);
        Item boyBoot = shoeStoreFactory.getItemFactory().createItem("Boy Boot",shoeStore.getStoreId(),150);


        DiscountHandler quantDiscountHandler = new QuantityDiscountHandler(10);
        DiscountHandler percDiscountHandler = new PercentageDiscountHandler(20);
        quantDiscountHandler.setNextHandler(percDiscountHandler);       
        
        book.setPrice(quantDiscountHandler.applyDiscount(book));
        sandal.setPrice(quantDiscountHandler.applyDiscount(sandal));

        

        bookStore.addItem(book);
        bookStore.addItem(discountedBook);
        bookStore.addItem(book1);
        bookStore.addItem(book2);
        bookStore.addItem(book3);


        gameStore.addItem(puzzle100);
        gameStore.addItem(puzzle500);
        gameStore.addItem(puzzle1000);
        gameStore.addItem(puzzle2000);
        gameStore.addItem(puzzle4000);

        
        shoeStore.addItem(sandal);
        shoeStore.addItem(sportBoot);
        shoeStore.addItem(discountedSportBoot);
        shoeStore.addItem(kidsBoot);
        shoeStore.addItem(boyBoot);

        mall.addStore(gameStore);
        mall.addStore(shoeStore);
        mall.addStore(bookStore);
        
    }

    public static void run() {
        boolean exit = false;
        while (!exit) {
            if (currentUser == null) {
                showLoginMenu();
            } else {
                showFirstMenu();
            }
        }
    }

    private static void showLoginMenu() {
        System.out.println("\n=== Login / Registration ===");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Enter choice: ");
        String choice = scanner.next();
        switch (choice) {
            case "1":
                login();
                break;
            case "2":
                register();
                break;
            case "3":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    
    static void showFirstMenu(){
        System.out.println("\nOnline Shopping Mall Menu");
        System.out.println("1. Enter Mall");
        System.out.println("2. Logout");
        System.out.print("Enter your choice: ");
        String choice = scanner.next();
        switch (choice) {
            case "1":{
                mall.enter(currentUser);
                currentUser.setShoppingCart(shoppingCart);
                System.out.println("Shopping cart of "+ currentUser.getCustomerName() + ": "+currentUser.getShoppingCart().toString());
                shoppingCart.addObserver(shoppingObserver);
                showMainMenu();
            }
                break;
            case "2":{
                customersManager.logout(currentUser);
                showLoginMenu();
            }
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
 
    static void showMainMenu(){
        System.out.println("\nOnline Shopping Mall Menu");
        System.out.println("1. Browse Stores");
        System.out.println("2. View Shopping Cart");
        System.out.println("3. Checkout");
        System.out.println("4. Exit Mall");
        System.out.print("Enter your choice: ");
        String choice = scanner.next();
        switch (choice) {
            case "1":{
                
                System.out.println("\nBrowse Stores");
                mall.displayStores();
                System.out.println("Did you want to enter store? if yes type its number OR type -1 to back the main menu");
                int choice1 = scanner.nextInt();
                if(choice1 == -1){
                    showMainMenu();
                }else if(choice1 >= mall.getStoresCount() || choice1 < 0){
                    System.out.println("Invalid choice. Please try again.");
                }else{
                    currentStore = mall.getStores().get(choice1);
                    currentStore.enter(currentUser);
                    currentUser.setStore(currentStore);
                    showStoresMenu();
                }

            }
                break;
            case "2":{
                showShoppingCartMenu();
            }
                break;
            case "3":{
                currentOrder.nextStage();
                checkout();
                currentOrder.printStatus();
                currentOrder.nextStage();
                shoppingCart = mall.getShoppingCart();
            }
                break;
            case "4":{
                mall.exit(currentUser);
                showFirstMenu();
            }
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    static void showStoresMenu(){
        System.out.println("Welcome to "+currentStore.getStoreName());
        System.out.println("1. Browse Products");
        System.out.println("2. Search for a product");
        System.out.println("3. Back to main menu");

        System.out.print("Enter your choice: ");
        String choice = scanner.next();
        switch (choice) {
            case "1":{
                System.out.println("\nBrowse Products");
                currentStore.displayProducts();
                System.out.println("Did you want to preview any item? if yes type its number OR type -1 to back the main menu");
                int choice1 = scanner.nextInt();
                if(choice1 == -1){
                    showMainMenu();
                }else if(choice1 >= currentStore.getItems().size() || choice1 < 0){
                    System.out.println("Invalid choice. Please try again.");
                }else{
                    currentItem = currentStore.getItems().get(choice1);
                    showItemMenu();
                }
                
            }
                break;
            case "2":{
                System.out.print("Enter product name: ");
                currentItem = currentStore.searchProduct(scanner.next());
                if(currentItem == null)
                    System.out.println("Product not found");
                else
                    showItemMenu();
            }
                break;
            case "3":{
                showMainMenu();
            }
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    
    static void showItemMenu(){
        System.out.println("Product: "+currentItem.getItemName());
        System.out.println("1. Add to my cart");
        System.out.println("2. Review and rate the product");
        System.out.println("3. View reviews product");
        System.out.println("4. Back to main menu");

        System.out.print("Enter your choice: ");
        String choice = scanner.next();
        reviewProxy.setCurrentUser(currentUser);
        switch (choice) {
            case "1":{
                shoppingCart.addItem(currentItem);
                shoppingCartMemento = shoppingCart.saveToMemento();
                currentOrder = new Order(shoppingCart.toString());
            }
                break;
            case "2":{
                System.out.println("Write your review: ");
                String review_message = scanner.next();
                System.out.println("Enter your rate up to 10: ");
                
                reviewProxy.addReviewToList(currentItem.getItemId(),review_message, scanner.nextInt());
            }
                break;
            case "3":{
                System.out.println(reviewProxy.viewReviews(currentItem.getItemId()));
            }
                break;
            case "4":{
                showMainMenu();
            }
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    static void showShoppingCartMenu(){
        shoppingCart.displayProducts();
        System.out.println("1. Place Order");
        System.out.println("2. Modify Order");
        System.out.println("3. Cancel Order");
        System.out.println("4. Back to main menu");

        System.out.print("Enter your choice: ");
        String choice = scanner.next();
        
        switch (choice) {
            case "1":{
                currentOrder = new Order(shoppingCart.toString());
                currentOrder.printStatus();
                System.out.println(currentOrder.toString());  
                
            }
                break;
            case "2":{
                System.out.println("Select the Product number you want to modify: ");
                int choice1 = scanner.nextInt();
                if(choice1 == -1){
                    showMainMenu();
                }else if(choice1 >= shoppingCart.getItems().size() || choice1 < 0){
                    System.out.println("Invalid choice. Please try again.");
                }else{
                    currentItem = shoppingCart.getItems().get(choice1);
                    showModifyOrderMenu();
                    
                    OrderCommand modifyOrderCommand = new ModifyOrderCommand(currentOrder, shoppingCart.toString());
                    invoker.setCommand(modifyOrderCommand);
                    invoker.executeCommand();
                    
                }
                
            }
                break;
            case "3":{
                
                OrderCommand cancOrderCommand = new CancelOrderCommand(currentOrder);
                cancOrderCommand.execute();
                shoppingCart = mall.getShoppingCart();
            }
                break;
            case "4":{
                showMainMenu();
            }
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    
    private static void showModifyOrderMenu(){
        System.out.println("1. Remove product");
        System.out.println("2. Incress quantity of product by 1");
        System.out.println("3. Decress quantity of product by 1");
        System.out.println("4. Back to main menu");
        String choice = scanner.next();
        switch (choice) {
            case "1":{
                shoppingCart.removeItem(currentItem);
                currentOrder.modify(shoppingCart.toString());
            }
                break;
            case "2":{
                shoppingCart.addItem(currentItem);
                currentOrder.modify(shoppingCart.toString());
            }
                break;
            case "3":{
                shoppingCart.decressItemQuantity(currentItem);
                currentOrder.modify(shoppingCart.toString());
            }
                break;
            case "4":{
                showMainMenu();
            }
                break;
            default:
                break;
        }
    }
    
    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();
        currentUser = customersManager.login(username, password);
        if (currentUser == null) {
            System.out.println("Login failed.");
        }
    }

    private static void register() {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();
        boolean success = customersManager.signUp(username, password);
        if (success) {
            System.out.println("Registration successful.");
        } else {
            System.out.println("Registration failed. Username already exists.");
        }
    }

    private static void checkout() {
        System.out.println("Select a payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");
        System.out.println("3. Bitcoin");
        String choice = scanner.next();
        switch (choice) {
            case "1":
                paymentProcessor.setPaymentStrategy(new CreditCardStrategy());
                break;
            case "2":
                paymentProcessor.setPaymentStrategy(new PayPalStrategy());
                break;
            case "3":
                paymentProcessor.setPaymentStrategy(new BitcoinStrategy());
                break;
        }
        
        double totalAmount = shoppingCart.calculateTotal();
        paymentProcessor.processPayment(totalAmount);
        System.out.println("You pay "+totalAmount+"$");
    }
    

}
