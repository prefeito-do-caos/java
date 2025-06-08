package br.com.fiap.beans;

public class Scenario {

    private int id;
    private String title;
    private String description;
    private String story;
    private String coverUrl;
    private String preparationBgUrl;
    private String actionBgUrl;
    private int initialBudget;
    private int initialFireUnits;
    private int initialMilitarySupport;
    private int initialLogistics;
    private String difficulty;

    public Scenario() {
        super();
    }

    public Scenario(int id, String title, String description, String story, String coverUrl, String preparationBgUrl, String actionBgUrl, int initialBudget, int initialFireUnits, int initialMilitarySupport, int initialLogistics, String difficulty) {
        super();

        this.id = id;
        this.title = title;
        this.description = description;
        this.story = story;
        this.coverUrl = coverUrl;
        this.preparationBgUrl = preparationBgUrl;
        this.actionBgUrl = actionBgUrl;
        this.initialBudget = initialBudget;
        this.initialFireUnits = initialFireUnits;
        this.initialMilitarySupport = initialMilitarySupport;
        this.initialLogistics = initialLogistics;
        this.difficulty = difficulty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getPreparationBgUrl() {
        return preparationBgUrl;
    }

    public void setPreparationBgUrl(String preparationBgUrl) {
        this.preparationBgUrl = preparationBgUrl;
    }

    public String getActionBgUrl() {
        return actionBgUrl;
    }

    public void setActionBgUrl(String actionBgUrl) {
        this.actionBgUrl = actionBgUrl;
    }

    public int getInitialBudget() {
        return initialBudget;
    }

    public void setInitialBudget(int initialBudget) {
        this.initialBudget = initialBudget;
    }

    public int getInitialFireUnits() {
        return initialFireUnits;
    }

    public void setInitialFireUnits(int initialFireUnits) {
        this.initialFireUnits = initialFireUnits;
    }

    public int getInitialMilitarySupport() {
        return initialMilitarySupport;
    }

    public void setInitialMilitarySupport(int initialMilitarySupport) {
        this.initialMilitarySupport = initialMilitarySupport;
    }

    public int getInitialLogistics() {
        return initialLogistics;
    }

    public void setInitialLogistics(int initialLogistics) {
        this.initialLogistics = initialLogistics;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Scenario{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", story='" + story + '\'' +
                ", coverUrl='" + coverUrl + '\'' +
                ", preparationBgUrl='" + preparationBgUrl + '\'' +
                ", actionBgUrl='" + actionBgUrl + '\'' +
                ", initialBudget=" + initialBudget +
                ", initialFireUnits=" + initialFireUnits +
                ", initialMilitarySupport=" + initialMilitarySupport +
                ", initialLogistics=" + initialLogistics +
                ", difficulty='" + difficulty + '\'' +
                '}';
    }

}
