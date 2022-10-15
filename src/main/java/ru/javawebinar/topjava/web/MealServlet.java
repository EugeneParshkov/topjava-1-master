package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealDAO;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class MealServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(MealServlet.class);
    private List<MealTo> mealToList;
    MealDAO mealDAO = new MealDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("redirect to meals");

        mealToList = MealsUtil.filteredByStreams(mealDAO.getMeals(), LocalTime.of(0,0), LocalTime.of(23, 59),MealDAO.CALORIESPERDAY);

            request.setAttribute("mealToList", mealToList);

        request.getRequestDispatcher("/meals.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF8");
        String name = req.getParameter("name");
        String password = req.getParameter("pass");

         Meal meal = new Meal(LocalDateTime.now(),name,Integer.parseInt(password));

        mealDAO.add(meal);
        mealToList = MealsUtil.filteredByStreams(mealDAO.getMeals(), LocalTime.of(0,0), LocalTime.of(23, 59),MealDAO.CALORIESPERDAY);


        doGet(req,resp);
    }
}
