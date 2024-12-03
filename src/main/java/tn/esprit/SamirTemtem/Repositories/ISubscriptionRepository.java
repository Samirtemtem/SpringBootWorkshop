package tn.esprit.SamirTemtem.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.SamirTemtem.entities.Subscription;

public interface ISubscriptionRepository extends CrudRepository<Subscription, Long> {
}
