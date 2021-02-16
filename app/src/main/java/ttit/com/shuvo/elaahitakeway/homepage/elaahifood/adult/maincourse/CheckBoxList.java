package ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse;

public class CheckBoxList {

    private String checkBoxItem;
    private Boolean checkedItem;

    public CheckBoxList(String myCheckBoxItem, Boolean myCheckedItem) {
        this.checkBoxItem = myCheckBoxItem;
        this.checkedItem = myCheckedItem;
    }

    public String getCheckBoxItem() {
        return checkBoxItem;
    }

    public void setCheckBoxItem(String checkBoxItem) {
        this.checkBoxItem = checkBoxItem;
    }

    public Boolean getCheckedItem() {
        return checkedItem;
    }

    public void setCheckedItem(Boolean checkedItem) {
        this.checkedItem = checkedItem;
    }
}


