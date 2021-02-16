package ttit.com.shuvo.elaahitakeway.homepage.order;


public class OrderItem {
    public String myOrderFood;
    public String myItemNo;
    public String myPriceTag;
    public String myQuantity;

    public OrderItem(String orderFood, String itemNo, String priceTag, String quantity) {
        this.myOrderFood = orderFood;
        this.myItemNo = itemNo;
        this.myPriceTag = priceTag;
        this.myQuantity = quantity;
    }

    public String getMyOrderFood() {
        return myOrderFood;
    }

    public void setMyOrderFood(String myOrderFood) {
        this.myOrderFood = myOrderFood;
    }

    public String getMyItemNo() {
        return myItemNo;
    }

    public void setMyItemNo(String myItemNo) {
        this.myItemNo = myItemNo;
    }

    public String getMyPriceTag() {
        return myPriceTag;
    }

    public void setMyPriceTag(String myPriceTag) {
        this.myPriceTag = myPriceTag;
    }

    public String getMyQuantity() {
        return myQuantity;
    }

    public void setMyQuantity(String myQuantity) {
        this.myQuantity = myQuantity;
    }
}

