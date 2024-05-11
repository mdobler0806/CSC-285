package edu.bhcc.HW8_SpringWebApplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

/* ***************************
 *  @Author : Matthew Dobler
 *  @Date   : 5/11/2024
 *  @File   : FitnessTrackerController
 *  @Class  : CSC-285
 * ***************************/

/**
 * Controller for handling web requests related to fitness tracker web app.
 * Provides methods for displaying, adding, and deleting activities.
 */
@Controller
public class FitnessTrackerController {
    private ActivityRepository activityRepo;

    /**
     * Constructs a new controller with the given activity repository.
     *
     * @param activityRepo The repository used for accessing activities data.
     */
    public FitnessTrackerController(ActivityRepository activityRepo)
    {
        this.activityRepo = activityRepo;
    }

    /**
     * Handles the root ("/") GET request and adds activities to the model.
     *
     * @param model The UI model that attributes are added to.
     * @return The name of the template to render (index).
     */
    @GetMapping("/")
    public String home(Model model)
    {
        addActivities(model);
        return "index";
    }

    /**
     * Handles POST request for adding a new activity.
     *
     * @param route The route of the activity.
     * @param miles The miles covered.
     * @param date  The date of the activity.
     * @param model The UI model that attributes are added to.
     * @return The name of the template to render (index).
     */
    @PostMapping("/add_activity")
    public String addActivity(String route, Double miles, String date, Model model)
    {
        Activity activity = new Activity(route, miles, date);
        activityRepo.save(activity);
        model.addAttribute("toast", "New activity added:  " + route);
        addActivities(model);
        return "index";
    }

    /**
     * Handles POST request for deleting an activity.
     *
     * @param id    The ID of the activity to delete.
     * @param model The UI model that attributes are added to.
     * @return The name of the template to render (index).
     */
    @PostMapping("/delete_activity")
    public String deleteActivity(Long id, Model model)
    {
        Activity activity = activityRepo.findByActivityId(id);
        if (activity != null)
        {
            activityRepo.delete(activity);
            model.addAttribute("toast", "Deleted activity:  " + activity.getRoute());
        } else
        {
            model.addAttribute("toast", "Could not find activity ID:  " + id);
        }
        addActivities(model);
        return "index";
    }

    // Private helper methods

    private void addActivities(Model model)
    {
        List<Activity> activityList = getAllActivities();
        Double totalMiles = calculateTotalMiles(activityList);
        model.addAttribute("total_activities", activityList.size());
        model.addAttribute("total_miles", totalMiles);
        model.addAttribute("activity_list", activityList);
    }

    private List<Activity> getAllActivities()
    {
        List<Activity> activityList = new ArrayList<>();
        for (Activity currentActivity : activityRepo.findAll())
        {
            activityList.add(currentActivity);
        }
        return activityList;
    }

    private double calculateTotalMiles(List<Activity> activityList)
    {
        double totalMiles = 0;
        for (Activity currentActivity : activityList)
        {
            totalMiles += currentActivity.getMiles();
        }
        return totalMiles;
    }
}
