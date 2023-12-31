package dev.domain;

import javax.validation.constraints.NotNull;

public class Cost {
    @NotNull
    private String Gender;
    @NotNull
    private int HouseRent;
    @NotNull
    private int Transportation;
    @NotNull
    private int MedicalCost;
    @NotNull
    private int savings;
    @NotNull
    private int educationalCost;
    @NotNull
    private int foodCost;
    @NotNull
    private int groceryCost;
    @NotNull
    private int shoppingCost;
    @NotNull
    private int telecomCost;
    @NotNull
    private int subscriptionCost;
    @NotNull
    private int otherCost;

    public Cost() {
    }

    public Cost(String gender, int houseRent, int transportation, int medicalCost, int savings, int educationalCost, int foodCost, int groceryCost, int shoppingCost, int telecomCost, int subscriptionCost, int otherCost) {
        Gender = gender;
        HouseRent = houseRent;
        Transportation = transportation;
        MedicalCost = medicalCost;
        this.savings = savings;
        this.educationalCost = educationalCost;
        this.foodCost = foodCost;
        this.groceryCost = groceryCost;
        this.shoppingCost = shoppingCost;
        this.telecomCost = telecomCost;
        this.subscriptionCost = subscriptionCost;
        this.otherCost = otherCost;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public int getHouseRent() {
        return HouseRent;
    }

    public void setHouseRent(int houseRent) {
        HouseRent = houseRent;
    }

    public int getTransportation() {
        return Transportation;
    }

    public void setTransportation(int transportation) {
        Transportation = transportation;
    }

    public int getMedicalCost() {
        return MedicalCost;
    }

    public void setMedicalCost(int medicalCost) {
        MedicalCost = medicalCost;
    }


    public int getSavings() {
        return savings;
    }

    public void setSavings(int savings) {
        this.savings = savings;
    }

    public int getEducationalCost() {
        return educationalCost;
    }

    public void setEducationalCost(int educationalCost) {
        this.educationalCost = educationalCost;
    }

    public int getFoodCost() {
        return foodCost;
    }

    public void setFoodCost(int foodCost) {
        this.foodCost = foodCost;
    }

    public int getGroceryCost() {
        return groceryCost;
    }

    public void setGroceryCost(int groceryCost) {
        this.groceryCost = groceryCost;
    }

    public int getShoppingCost() {
        return shoppingCost;
    }

    public void setShoppingCost(int shoppingCost) {
        this.shoppingCost = shoppingCost;
    }

    public int getTelecomCost() {
        return telecomCost;
    }

    public void setTelecomCost(int telecomCost) {
        this.telecomCost = telecomCost;
    }

    public int getSubscriptionCost() {
        return subscriptionCost;
    }

    public void setSubscriptionCost(int subscriptionCost) {
        this.subscriptionCost = subscriptionCost;
    }

    public int getOtherCost() {
        return otherCost;
    }

    public void setOtherCost(int otherCost) {
        this.otherCost = otherCost;
    }
}
