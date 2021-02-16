package ttit.com.shuvo.elaahitakeway.homepage.mainfood.setMealMenu;

public class NameWithDesc {
    private String name;

    private String description;

    public NameWithDesc(String myName, String myDescription) {
        this.name = myName;
        this.description = myDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
