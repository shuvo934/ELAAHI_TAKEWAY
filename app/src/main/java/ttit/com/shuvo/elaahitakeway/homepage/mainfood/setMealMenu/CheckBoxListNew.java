package ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu;

public class CheckBoxListNew {


    private String checkBoxItem;
    private Boolean checkedItem;
    private String checkBoxDesc;

    public CheckBoxListNew(String myCheckBoxItem, String myCheckBoxDesc, Boolean myCheckedItem) {
        this.checkBoxItem = myCheckBoxItem;
        this.checkedItem = myCheckedItem;
        this.checkBoxDesc = myCheckBoxDesc;
    }

    public String getCheckBoxDesc() {
        return checkBoxDesc;
    }

    public void setCheckBoxDesc(String checkBoxDesc) {
        this.checkBoxDesc = checkBoxDesc;
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

