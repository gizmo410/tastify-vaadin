package be.coruscantit.tastify.domain.review;

import be.coruscantit.tastify.domain.api.review.RegisterReview;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * @since 11/05/14
 */
@Component
public class ReviewCommandHandler {

    private final Repository<ReviewAR> reviewRepository;

    @Inject
    public ReviewCommandHandler(final Repository<ReviewAR> reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @CommandHandler
    public void handle(final RegisterReview command) {
        reviewRepository.add(new ReviewAR(
                command.getReviewId(),
                command.getName(),
                command.getEmail(),
                command.hasRudeWords(),
                command.isMarkedAsAbuse(),
                command.isPublic(),
                command.getComment(),
                command.getCleanlinessRate(),
                command.getQosRate(),
                command.getKindnessRate(),
                command.getAccessibilityRate(),
                command.getDiversityRate(),
                command.getOverallRate(),
                command.getQualityPriceRate(),
                command.getPlaceId()));
    }
}
