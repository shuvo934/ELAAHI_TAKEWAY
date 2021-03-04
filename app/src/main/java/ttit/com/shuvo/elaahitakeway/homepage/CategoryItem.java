package ttit.com.shuvo.elaahitakeway.homepage;

public class CategoryItem {
    private String mText;
    private String iem_id;

    public CategoryItem(String id, String text) {
        iem_id = id;
        mText = text;
    }

    public String getmText() {
        return mText;
    }

    public String getIem_id() {
        return iem_id;
    }

    public void setIem_id(String iem_id) {
        this.iem_id = iem_id;
    }
    public void setmText(String mText) {
        this.mText = mText;
    }
}
