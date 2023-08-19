package com.example.demo.services;

import com.example.demo.models.Rice;
import com.example.demo.repositories.RiceSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RiceSaleService {
    @Autowired

    private RiceSaleRepository riceSaleRepository;

    public Map<Integer, Double> calculateWeeklyProfits() {
        List<Rice> allSales = riceSaleRepository.findAll();
        Map<Integer, Double> weeklyProfits = new HashMap<>();

        for (Rice sale : allSales) {
            int weekNumber = (sale.getNgay() - 1) / 7 + 1;
            double profit = calculateProfit(sale.getSotien());

            weeklyProfits.put(weekNumber, weeklyProfits.getOrDefault(weekNumber, 0.0) + profit);
        }

        return weeklyProfits;
    }

    private double calculateProfit(int amountSold) {
        double badRice = (amountSold / 5) * 0.3;


        double profit = badRice * 20000- badRice* 2000;
        return profit;
    }
    public double calculateProfitByWeek(int weekNumber){
        double total = 0;
        List<Rice> allSales = riceSaleRepository.findAll();
        for(Rice rice: allSales){
            int week = (rice.getNgay() - 1) / 7 + 1;
            double profit = calculateProfit(rice.getSotien());
            if(weekNumber == week ){
                total = total + profit;


            }
        }
        return total;
    }
    public Map<Integer, Double> calculateDailyProfits() {
        List<Rice> allSales = riceSaleRepository.findAll();
        Map<Integer, Double> dailyProfits = new HashMap<>();

        for (Rice sale : allSales) {

            double profit = calculateProfit(sale.getSotien());

            dailyProfits.put(sale.getNgay(), dailyProfits.getOrDefault(sale.getNgay(), 0.0) + profit);
        }

        return dailyProfits;
    }
}
