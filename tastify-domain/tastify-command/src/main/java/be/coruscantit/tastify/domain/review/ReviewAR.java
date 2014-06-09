package be.coruscantit.tastify.domain.review;

import be.coruscantit.tastify.domain.api.place.PlaceId;
import be.coruscantit.tastify.domain.api.review.ReviewId;
import be.coruscantit.tastify.domain.api.review.ReviewRegistered;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;

import javax.persistence.*;

import static be.coruscantit.tastify.domain.review.ReviewAR.TABLE;

/**
 * @since 11/05/14
 */
@Entity
@Table(name = TABLE)
public class ReviewAR extends AbstractAnnotatedAggregateRoot<ReviewId> {

    public static final String TABLE = "REVIEW_AR";
    public static final String IDENTIFIER = "identifier";
    public static final String REVIEW_ID = "review_id";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String HAS_RUDE_WORDS = "has_rude_words";
    public static final String MARKED_AS_ABUSE = "markedAsAbuse";
    public static final String IS_PUBLIC = "is_public";
    public static final String COMMENT = "comment";
    public static final String CLEANLINESS_RATE = "cleanliness_rate";
    public static final String QOS_RATE = "qos_rate";
    public static final String KINDNESS_RATE = "kindness_rate";
    public static final String ACCESSIBILITY_RATE = "accessibility_rate";
    public static final String DIVERSITY_RATE = "diversity_rate";
    public static final String OVERALL_RATE = "overall_rate";
    public static final String QUALITY_PRICE_RATE = "quality_price_rate";
    public static final String PLACE_ID = "place_id";

    @AggregateIdentifier
    @EmbeddedId
    @AttributeOverrides({@AttributeOverride(name = IDENTIFIER, column = @Column(name = REVIEW_ID, length = 255))})
    private ReviewId reviewId;

    @Column(name = NAME)
    private String name;

    @Column(name = EMAIL)
    private String email;

    @Column(name = HAS_RUDE_WORDS)
    private boolean hasRudeWords;

    @Column(name = MARKED_AS_ABUSE)
    private boolean marked_as_abuse;

    @Column(name = IS_PUBLIC)
    private boolean isPublic;

    @Column(name = COMMENT)
    private String comment;

    @Column(name = CLEANLINESS_RATE)
    private int cleanlinessRate;

    @Column(name = QOS_RATE)
    private int qosRate;

    @Column(name = KINDNESS_RATE)
    private int kindnessRate;

    @Column(name = ACCESSIBILITY_RATE)
    private int accessibilityRate;

    @Column(name = DIVERSITY_RATE)
    private int diversityRate;

    @Column(name = OVERALL_RATE)
    private int overallRate;

    @Column(name = QUALITY_PRICE_RATE)
    private int qualityPriceRate;

    @Column(name = PLACE_ID)
    @AttributeOverrides({@AttributeOverride(name = IDENTIFIER, column = @Column(name = PLACE_ID, length = 255))})
    private PlaceId placeId;

    // Needed by Axon
    protected ReviewAR() {
    }

    public ReviewAR(final ReviewId reviewId, final String name, final String email, final boolean hasRudeWords, final boolean markedAsAbuse, final boolean isPublic, final String comment, final int cleanlinessRate, final int qosRate, final int kindnessRate, final int accessibilityRate, final int diversityRate, final int overallRate, final int qualityPriceRate, final PlaceId placeId) {
        apply(ReviewRegistered.newBuilder()
                .reviewid(reviewId)
                .name(name)
                .email(email)
                .hasRudeWords(hasRudeWords)
                .markedAsAbuse(markedAsAbuse)
                .isPublic(isPublic)
                .comment(comment)
                .cleanlinessRate(cleanlinessRate)
                .qosRate(qosRate)
                .kindnessRate(kindnessRate)
                .accessibilityRate(accessibilityRate)
                .diversityRate(diversityRate)
                .overallRate(overallRate)
                .qualityPriceRate(qualityPriceRate)
                .placeId(placeId)
                .build());
    }

    @EventSourcingHandler
    public void handle(final ReviewRegistered event) {
        this.reviewId = event.getReviewId();
        this.name = event.getName();
        this.email = event.getEmail();
        this.hasRudeWords = event.hasRudeWords();
        this.marked_as_abuse = event.isMarkedAsAbuse();
        isPublic = event.isPublic();
        this.comment = event.getComment();
        this.cleanlinessRate = event.getCleanlinessRate();
        this.qosRate = event.getQosRate();
        this.kindnessRate = event.getKindnessRate();
        this.accessibilityRate = event.getAccessibilityRate();
        this.diversityRate = event.getDiversityRate();
        this.overallRate = event.getOverallRate();
        this.qualityPriceRate = event.getQualityPriceRate();
        this.placeId = event.getPlaceId();
    }
}
