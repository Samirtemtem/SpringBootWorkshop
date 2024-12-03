package tn.esprit.SamirTemtem.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import tn.esprit.SamirTemtem.entities.Skieur;
import tn.esprit.SamirTemtem.entities.Subscription;
import tn.esprit.SamirTemtem.Services.SubscriptionServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subscription")
public class SubscriptionRestController {

    private final SubscriptionServiceImpl subscriptionService;

    @PostMapping("/add")
    public Subscription addSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.addSubscription(subscription);
    }

    @PutMapping("/update")
    public Subscription updateSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.updateSubscription(subscription);
    }

    @GetMapping("/get/{numSubscription}")
    public Subscription getSubscription(@PathVariable Long numSubscription) {
        return subscriptionService.retrieveSubscription(numSubscription);
    }

    @GetMapping("/all")
    public List<Subscription> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions();
    }

    @DeleteMapping("/delete/{numSubscription}")
    public void deleteSubscription(@PathVariable Long numSubscription) {
        subscriptionService.removeSubscription(numSubscription);
    }
    @PutMapping("/addAndAssignToCourse/{numCourse}")
    public Skieur addSkieurAndAssignToCourse(@RequestBody Skieur skieur, @PathVariable("numCourse") Long numCourse) {
        return subscriptionService.addSkieurAndAssignToCourse(skieur, numCourse);
    }
    
}
