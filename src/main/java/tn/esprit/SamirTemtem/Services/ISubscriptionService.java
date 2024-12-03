package tn.esprit.SamirTemtem.Services;

import tn.esprit.SamirTemtem.entities.Skieur;
import tn.esprit.SamirTemtem.entities.Subscription;
import java.util.List;

public interface ISubscriptionService {
    Subscription addSubscription(Subscription subscription);
    Subscription updateSubscription(Subscription subscription);
    void removeSubscription(Long numSubscription);
    Subscription retrieveSubscription(Long numSubscription);
    List<Subscription> getAllSubscriptions();

    /* @Override
         public List<Subscription> getAllSubscriptions() {
             return (List<Subscription>) subscriptionRepository.findAll();
         }
           public Skieur addSkieurAndAssignToCourse(Skieur skieur, Long numCourse) {
             Course course = courseRepository.findById(numCourse).orElse(null);
             Set<Course> courseSet = new HashSet<>();

             courseSet.add(course);
             skieur.setSubscription(courseSet);
             return subscriptionRepository.save(skieur);
         }
         */
    Skieur addSkieurAndAssignToCourse(Skieur skieur, Long numCourse);

    Skieur addSkierAndAssignToCourse(Skieur skier, Long numCourse);
}
