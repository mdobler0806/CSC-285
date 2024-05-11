package edu.bhcc.HW8_SpringWebApplication;
import org.springframework.data.repository.CrudRepository;

/* ***************************
 *  @Author : Matthew Dobler
 *  @Date   : 5/11/2024
 *  @File   : ActivityRepository
 *  @Class  : CSC-285
 * ***************************/

/**
 * Repository interface for managing {@link Activity} entities.
 * Extends Spring Data's CrudRepository for basic CRUD operations.
 */
public interface ActivityRepository extends CrudRepository<Activity, Long> {

    /**
     * Finds an activity by its ID.
     *
     * @param activityId The ID of the activity to find.
     * @return The found Activity or null if no activity found with the given ID.
     */
    Activity findByActivityId(long activityId);

}