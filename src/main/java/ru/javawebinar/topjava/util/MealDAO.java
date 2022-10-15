package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class MealDAO {

    private List<Meal> meals = new ArrayList<>();
    public static final int CALORIESPERDAY = 2000;

    public MealDAO() {
        meals.add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500));
        meals.add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000));
        meals.add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500));
        meals.add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100));
        meals.add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000));
        meals.add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500));
        meals.add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410));
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void add(Meal meal){
        meals.add(meal);
    }

    public void delete(Meal meal){
        meals.remove(meal);
    }

    public void update(Meal meal){
        for(Meal curentMeal : meals){
            if(curentMeal.equals(meal)){
                curentMeal.setCalories(meal.getCalories());
                curentMeal.setDateTime(meal.getDateTime());
                curentMeal.setDescription(meal.getDescription());
            }
        }
    }

}
