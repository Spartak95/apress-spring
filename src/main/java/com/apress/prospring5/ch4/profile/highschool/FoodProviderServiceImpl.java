package com.apress.prospring5.ch4.profile.highschool;

import java.util.ArrayList;
import java.util.List;

import com.apress.prospring5.ch4.profile.Food;
import com.apress.prospring5.ch4.profile.FoodProviderService;

public class FoodProviderServiceImpl implements FoodProviderService {
    @Override
    public List<Food> provideLunchSet() {
        List<Food> lunchSet = new ArrayList<>();
        lunchSet.add(new Food("Coke"));
        lunchSet.add(new Food("Hamburger"));
        lunchSet.add(new Food("French Fries"));
        return lunchSet;
    }
}
