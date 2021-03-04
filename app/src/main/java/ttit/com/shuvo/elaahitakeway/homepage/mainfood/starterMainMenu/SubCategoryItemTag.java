package ttit.com.shuvo.elaahitakeway.homepage.mainfood.starterMainMenu;

public class SubCategoryItemTag {

    private String fName;
    private String fTag;
    private String fId;
    private String fNote;
    private String fRate;
    private String fTest;

    public SubCategoryItemTag(String id, String name, String tag, String note, String rate, String test) {
        this.fId = id;
        this.fName= name;
        this.fTag = tag;
        this.fNote = note;
        this.fRate = rate;
        this.fTest = test;
    }

    public String getfTest() {
        return fTest;
    }

    public void setfTest(String fTest) {
        this.fTest = fTest;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfTag() {
        return fTag;
    }

    public void setfTag(String fTag) {
        this.fTag = fTag;
    }

    public String getfId() {
        return fId;
    }

    public void setfId(String fId) {
        this.fId = fId;
    }

    public String getfNote() {
        return fNote;
    }

    public void setfNote(String fNote) {
        this.fNote = fNote;
    }

    public String getfRate() {
        return fRate;
    }

    public void setfRate(String fRate) {
        this.fRate = fRate;
    }
}
