package br.com.fiap.beans;

public class Medal {

    private int id;
    private String name;
    private Scenario scenario;
    private String tier;
    private int scoreRequirement;
    private String iconUrl;

    public Medal() {
        super();
    }

    public Medal(int id, String name, String tier, int scoreRequirement, String iconUrl) {
        super();

        this.id = id;
        this.name = name;
        this.tier = tier;
        this.scoreRequirement = scoreRequirement;
        this.iconUrl = iconUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public int getScoreRequirement() {
        return scoreRequirement;
    }

    public void setScoreRequirement(int scoreRequirement) {
        this.scoreRequirement = scoreRequirement;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    @Override
    public String toString() {
        return "Medal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", scenario=" + scenario +
                ", tier='" + tier + '\'' +
                ", scoreRequirement=" + scoreRequirement +
                ", iconUrl='" + iconUrl + '\'' +
                '}';
    }

}
