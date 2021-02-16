package ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult;

public class SelectedElahiItem {

    private String myChosenItem;
    private String myChosenQuantity;


    public SelectedElahiItem(String myChosenItem, String myChosenQuantity) {
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
