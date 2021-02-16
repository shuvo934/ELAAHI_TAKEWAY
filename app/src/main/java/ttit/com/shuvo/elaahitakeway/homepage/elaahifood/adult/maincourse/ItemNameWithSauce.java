package ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse;

public class ItemNameWithSauce {

    private String ItemSauce;
    private String quantity;

    public ItemNameWithSauce(String mItemsauce, String mQuantity) {
        this.ItemSauce = mItemsauce;
        this.quantity = mQuantity;
    }

    public String getItemSauce() {
        return ItemSauce;
    }

    public void setItemSauce(String itemSauce) {
        ItemSauce = itemSauce;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
