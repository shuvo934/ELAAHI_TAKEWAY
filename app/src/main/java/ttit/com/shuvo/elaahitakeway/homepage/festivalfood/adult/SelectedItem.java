package ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult;

public class SelectedItem {

    private String myChosenItem;
    private String myChosenQuantity;


    public SelectedItem(String myChosenItem, String myChosenQuantity) {
        this.myChosenItem = myChosenItem;
        this.myChosenQuantity = myChosenQuantity;

    }


    public String getMyChosenQuantity() {
        return myChosenQuantity;
    }

    public void setMyChosenQuantity(String myChosenQuantity) {
        this.myChosenQuantity = myChosenQuantity;
    }

    public String getMyChosenItem() {
        return myChosenItem;
    }

    public void setMyChosenItem(String myChosenItem) {
        this.myChosenItem = myChosenItem;
    }

}
