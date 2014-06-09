package be.coruscantit.tastify.query.review;

import be.coruscantit.tastify.domain.api.review.ReviewRegistered;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @since 11/05/14
 */
@Service
public class ReviewQueryModelUpdater {


    @EventHandler
    @Transactional
    @SuppressWarnings("unused")
    public void handle(final ReviewRegistered reviewRegistered) {
        // TODO Connect to Parse.com services and update the query model
    }

}
