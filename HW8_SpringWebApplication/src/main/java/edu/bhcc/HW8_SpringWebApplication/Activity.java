package edu.bhcc.HW8_SpringWebApplication;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/* ***************************
 *  @Author : Matthew Dobler
 *  @Date   : 5/11/2024
 *  @File   : Activity
 *  @Class  : CSC-285
 * ***************************/

/**
 * Represents an activity for fitness activity web app.
 * Each activity has an ID, a route, distance in miles, and a date.
 */
@Entity
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long activityId;

    private String route;
    private Double miles;
    private String date;

    /**
     * Protected Constructor, used by JPA.
     */
    protected Activity()
    {
    }

    /**
     * Constructs a new Activity with specified route, distance, and date.
     *
     * @param route The path or location of the activity.
     * @param miles The distance covered in miles.
     * @param date  The date the activity took place.
     */
    public Activity(String route, Double miles, String date)
    {
        this.route = route;
        this.miles = miles;
        this.date = date;
    }

    // Getters

    public Long getActivityId()
    {
        return activityId;
    }

    public String getRoute()
    {
        return route;
    }

    public Double getMiles()
    {
        return miles;
    }

    public String getDate()
    {
        return date;
    }

}
