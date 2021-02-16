package ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult;

public class AppitiserItem {

    private String myAppitiserItem;
    private String myApptQuantity;
    private String myItemDescription;

    public AppitiserItem(String myAppitiserItem, String myApptQuantity, String myItemDescription) {
        this.myAppitiserItem = myAppitiserItem;
        this.myApptQuantity = myApptQuantity;
        this.myItemDescription = myItemDescription;

    }

    public String getMyItemDescription() {
        return myItemDescription;
    }

    public void setMyItemDescription(String myItemDescription) {
        this.myItemDescription = myItemDescription;
    }

    public String getMyApptQuantity() {
        return myApptQuantity;
    }

    public void setMyApptQuantity(String myApptQuantity) {
        this.myApptQuantity = myApptQuantity;
    }

    public String getMyAppitiserItem() {
        return myAppitiserItem;
    }

    public void setMyAppitiserItem(String myAppitiserItem) {
        this.myAppitiserItem = myAppitiserItem;
    }
}
