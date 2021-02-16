package ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters;


// FOR Starter and Main Course
public class StarterItem {
    private String typeOfFood;
    private String foodDescribed;
    private String foodCount;


    public StarterItem(String mytypeOfFood, String myfoodDescribed, String myFoodCount) {
        this.typeOfFood = mytypeOfFood;
        this.foodDescribed = myfoodDescribed;
        this.foodCount = myFoodCount;

    }

    public String getFoodCount() {
        return foodCount;
    }

    public void setFoodCount(String foodCount) {
        this.foodCount = foodCount;
    }

    public String getTypeOfFood() {
        return typeOfFood;
    }

    public void setTypeOfFood(String typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

    public String getFoodDescribed() {
        return foodDescribed;
    }

    public void setFoodDescribed(String foodDescribed) {
        this.foodDescribed = foodDescribed;
    }
}
