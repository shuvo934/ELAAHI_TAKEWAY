package ttit.com.shuvo.elaahitakeway.homepage.mainfood;

public class NormalFoodItem {

    private String myFood;
    private String myFoodDesc;
    private String myFoodPrice;


    public NormalFoodItem(String myFood, String myFoodDesc, String myFoodPrice) {
        this.myFood = myFood;
        this.myFoodDesc = myFoodDesc;
        this.myFoodPrice = myFoodPrice;
    }

    public String getMyFoodDesc() {
        return myFoodDesc;
    }

    public void setMyFoodDesc(String myFoodDesc) {
        this.myFoodDesc = myFoodDesc;
    }

    public String getMyFood() {
        return myFood;
    }

    public void setMyFood(String myFood) {
        this.myFood = myFood;
    }

    public String getMyFoodPrice() {
        return myFoodPrice;
    }

    public void setMyFoodPrice(String myFoodPrice) {
        this.myFoodPrice = myFoodPrice;
    }
}
