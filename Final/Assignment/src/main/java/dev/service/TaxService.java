package dev.service;

import dev.domain.Cost;
import dev.repository.TaxRepository;
import org.springframework.stereotype.Service;

@Service
public class TaxService {
    private TaxRepository taxRepository;

    public TaxService(TaxRepository taxRepository) {
        this.taxRepository = taxRepository;
    }
    public int totalTax(Cost cost) {
        int totalCost = cost.getHouseRent() +
                cost.getTransportation() +
                cost.getMedicalCost() +
                cost.getSavings() +
                cost.getEducationalCost() +
                cost.getFoodCost() +
                cost.getGroceryCost() +
                cost.getShoppingCost() +
                cost.getTelecomCost() +
                cost.getSubscriptionCost() +
                cost.getOtherCost();

        double taxPercentage = 0.15;
        int tax = 0;
        if(cost.getGender().equals("male")){
            if(totalCost>350000 && totalCost <= 500000){
                tax =(int)Math.round(totalCost * 0.05); //5%
            }
            else if(totalCost > 500000 && totalCost<= 800000)
            {
                tax =(int)Math.round(totalCost * 0.1); //10%
            }
            else if(totalCost > 800000 && totalCost<= 1200000)
            {
                tax =(int)Math.round(totalCost * 0.15); //15%
            }
            else if(totalCost > 1200000 && totalCost<= 1700000)
            {
                tax =(int)Math.round(totalCost * 0.2); //20%
            }
            else if(totalCost>1700000){
                tax =(int)Math.round(totalCost * 0.25); //25%
            }
        }
        else {
            if(totalCost>400000 && totalCost <= 500000){
                tax =(int)Math.round(totalCost * 0.05); //5%
            }
            else if(totalCost > 500000 && totalCost<= 800000)
            {
                tax =(int)Math.round(totalCost * 0.1); //10%
            }
            else if(totalCost > 800000 && totalCost<= 1200000)
            {
                tax =(int)Math.round(totalCost * 0.15); //15%
            }
            else if(totalCost > 1200000 && totalCost<= 1700000)
            {
                tax =(int)Math.round(totalCost * 0.2); //20%
            }
            else if(totalCost>1700000){
                tax =(int)Math.round(totalCost * 0.25); //25%
            }
        }

        return tax;
    }
}
