package ttit.com.shuvo.elaahitakeway.homepage.cart;


public class CartItem {

    private String myCartFood;
    private String myFoodQuantity;
    private String myPrices;
    public CartItem(String cartFood, String foodQuantity, String prices) {
        this.myCartFood = cartFood;
        this.myFoodQuantity = foodQuantity;
        this.myPrices = prices;
    }

    public String getMyPrices() {
        return myPrices;
    }

    public void setMyPrices(String myPrices) {
        this.myPrices = myPrices;
    }

    public String getMyCartFood() {
        return myCartFood;
    }

    public void setMyCartFood(String myCartFood) {
        this.myCartFood = myCartFood;
    }

    public String getMyFoodQuantity() {
        return myFoodQuantity;
    }

    public void setMyFoodQuantity(String myFoodQuantity) {
        this.myFoodQuantity = myFoodQuantity;
    }
}
