package br.com.fiap.beans;

import br.com.fiap.dto.PublicUser;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;

public class GameSession {

    private int id;
    private String code;
    private PublicUser user;
    private Scenario scenario;
    private int turn;
    private int budget;
    private int fireUnits;
    private int militarySupport;
    private int logistics;
    private int savedLives;
    private int crisisControl;
    private int publicConfidence;
    private int structuralIntegrity;
    private int isEnded;
    private LocalDateTime createdAt;
    private LocalDateTime expireAt;

    public GameSession() {
        super();

        this.code = generateCode();
    }

    public GameSession(int id, String code, int turn, int budget, int fireUnits, int militarySupport, int logistics, int savedLives, int crisisControl, int publicConfidence, int structuralIntegrity, int isEnded) {
        super();

        this.id = id;
        this.code = code;
        this.turn = turn;
        this.budget = budget;
        this.fireUnits = fireUnits;
        this.militarySupport = militarySupport;
        this.logistics = logistics;
        this.savedLives = savedLives;
        this.crisisControl = crisisControl;
        this.publicConfidence = publicConfidence;
        this.structuralIntegrity = structuralIntegrity;
        this.isEnded = isEnded;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public PublicUser getUser() {
        return user;
    }

    public void setUser(PublicUser user) {
        this.user = user;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getFireUnits() {
        return fireUnits;
    }

    public void setFireUnits(int fireUnits) {
        this.fireUnits = fireUnits;
    }

    public int getMilitarySupport() {
        return militarySupport;
    }

    public void setMilitarySupport(int militarySupport) {
        this.militarySupport = militarySupport;
    }

    public int getLogistics() {
        return logistics;
    }

    public void setLogistics(int logistics) {
        this.logistics = logistics;
    }

    public int getSavedLives() {
        return savedLives;
    }

    public void setSavedLives(int savedLives) {
        this.savedLives = savedLives;
    }

    public int getCrisisControl() {
        return crisisControl;
    }

    public void setCrisisControl(int crisisControl) {
        this.crisisControl = crisisControl;
    }

    public int getPublicConfidence() {
        return publicConfidence;
    }

    public void setPublicConfidence(int publicConfidence) {
        this.publicConfidence = publicConfidence;
    }

    public int getStructuralIntegrity() {
        return structuralIntegrity;
    }

    public void setStructuralIntegrity(int structuralIntegrity) {
        this.structuralIntegrity = structuralIntegrity;
    }

    public int getIsEnded() {
        return isEnded;
    }

    public void setIsEnded(int isEnded) {
        this.isEnded = isEnded;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(LocalDateTime expireAt) {
        this.expireAt = expireAt;
    }

    private String generateCode() {
        byte[] randomBytes = new byte[15];
        new SecureRandom().nextBytes(randomBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
    }

    @Override
    public String toString() {
        return "GameSession{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", user=" + user +
                ", scenario=" + scenario +
                ", turn=" + turn +
                ", budget=" + budget +
                ", fireUnits=" + fireUnits +
                ", militarySupport=" + militarySupport +
                ", logistics=" + logistics +
                ", savedLives=" + savedLives +
                ", crisisControl=" + crisisControl +
                ", publicConfidence=" + publicConfidence +
                ", structuralIntegrity=" + structuralIntegrity +
                ", isEnded=" + isEnded +
                ", createdAt=" + createdAt +
                ", expireAt=" + expireAt +
                '}';
    }

}
