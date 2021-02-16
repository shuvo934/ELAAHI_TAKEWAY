package ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult;

public class ElaahiItem {
    private String myElaahiItem;
    private String myElaahiQuantity;
    private String myElaahiDescription;

    public ElaahiItem(String myElaahiItem, String myElaahiQuantity, String myElaahiDescription) {
        this.myElaahiItem = myElaahiItem;
        this.myElaahiQuantity = myElaahiQuantity;
        this.myElaahiDescription = myElaahiDescription;

    }

    public String getMyElaahiDescription() {
        return myElaahiDescription;
    }

    public void setMyElaahiDescription(String myElaahiDescription) {
        this.myElaahiDescription = myElaahiDescription;
    }

    public String getMyElaahiQuantity() {
        return myElaahiQuantity;
    }

    public void setMyElaahiQuantity(String myElaahiQuantity) {
        this.myElaahiQuantity = myElaahiQuantity;
    }

    public String getMyElaahiItem() {
        return myElaahiItem;
    }

    public void setMyElaahiItem(String myElaahiItem) {
        this.myElaahiItem = myElaahiItem;
    }

}
