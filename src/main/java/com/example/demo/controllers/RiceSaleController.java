package com.example.demo.controllers;

import com.example.demo.services.RiceSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/rice-profit")



public class RiceSaleController {
    @Autowired
    private RiceSaleService riceSaleService;

    @GetMapping("/weekly-profit")
    public Map<Integer, Double> getWeeklyProfits() {
        Map<Integer, Double> weeklyProfits = riceSaleService.calculateWeeklyProfits();
        return weeklyProfits;
    }

    @GetMapping("/weekly/{weekNumber}")
    public double getProfitByWeek(@PathVariable int weekNumber  ) {
        double profit = riceSaleService.calculateProfitByWeek(weekNumber );
        return profit ;
    }

    @GetMapping("/daily-profit")
    public Map<Integer, Double> getDailyProfits() {
        Map<Integer, Double> dailyProfits = riceSaleService.calculateDailyProfits();
        return dailyProfits;
    }

}
