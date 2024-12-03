package tn.esprit.SamirTemtem.Services;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import tn.esprit.SamirTemtem.Repositories.ICourseRepository;
import tn.esprit.SamirTemtem.Repositories.IRegistrationRepository;
import tn.esprit.SamirTemtem.Repositories.ISkieurRepository;
import tn.esprit.SamirTemtem.entities.Course;
import tn.esprit.SamirTemtem.entities.Registration;
import tn.esprit.SamirTemtem.entities.Skieur;
import tn.esprit.SamirTemtem.entities.Subscription;
import tn.esprit.SamirTemtem.Repositories.ISubscriptionRepository;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements ISubscriptionService {

    private final ISubscriptionRepository subscriptionRepository;
    private final ICourseRepository courseRepository;
    private final ISkieurRepository skieurRepository;
    private final IRegistrationRepository registrationRepository;

    @Override
    public Subscription addSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription updateSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public void removeSubscription(Long numSubscription) {
        subscriptionRepository.deleteById(numSubscription);
    }

    @Override
    public Subscription retrieveSubscription(Long numSubscription) {
        return subscriptionRepository.findById(numSubscription).orElse(null);
    }

    @Override
    public List<Subscription> getAllSubscriptions() {
        return (List<Subscription>) subscriptionRepository.findAll();
    }

    @Override
    public Skieur addSkieurAndAssignToCourse(Skieur skieur, Long numCourse) {
        Skieur savedSkier = skieurRepository.save(skieur);
        System.out.println("Skieur="+savedSkier);
        Course course = this.courseRepository.findById(numCourse).orElse(null);
        System.out.println("Course="+course);
        Set<Registration> registrations = savedSkier.getRegistrations();
        for (Registration r : registrations) {
            r.setSkieur(savedSkier);
            r.setCourse(course);
            registrationRepository.save(r);
        }
        return savedSkier;
    }


    @Override
    public Skieur addSkierAndAssignToCourse(Skieur skier, Long numCourse) {
        Skieur savedSkier = skieurRepository.save(skier);
        System.out.println("Skieur="+savedSkier);
        Course course = this.courseRepository.findById(numCourse).orElse(null);
        System.out.println("Course="+course);
        Set<Registration> registrations = savedSkier.getRegistrations();
        for (Registration r : registrations) {
            r.setSkieur(savedSkier);
            r.setCourse(course);
            registrationRepository.save(r);
        }
        return savedSkier;
    }

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

    //}
}