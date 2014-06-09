package be.coruscantit.tastify.domain.api.review;

import be.coruscantit.tastify.domain.api.IsBuilder;
import be.coruscantit.tastify.domain.api.place.PlaceId;
import com.google.common.base.Objects;

import java.io.Serializable;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @since 08/05/14
 */
public class RegisterReview implements Serializable {

    private ReviewId reviewId;
    private String name;
    private String email;
    private boolean hasRudeWords;
    private boolean markedAsAbuse;
    private boolean isPublic;
    private String comment;
    private int cleanlinessRate;
    private int qosRate;
    private int kindnessRate;
    private int accessibilityRate;
    private int diversityRate;
    private int overallRate;
    private int qualityPriceRate;
    private PlaceId placeId;

    // Forces usage of builder pattern
    protected RegisterReview() {
    }

    public RegisterReview(final Builder builder) {
        this.reviewId = reviewId;
        this.name = builder.name;
        this.email = builder.email;
        this.hasRudeWords = builder.hasRudeWords;
        this.markedAsAbuse = builder.marked_as_abuse;
        this.isPublic = builder.isPublic;
        this.comment = builder.comment;
        this.cleanlinessRate = builder.cleanlinessRate;
        this.qosRate = builder.qosRate;
        this.kindnessRate = builder.kindnessRate;
        this.accessibilityRate = builder.accessibilityRate;
        this.diversityRate = builder.diversityRate;
        this.overallRate = builder.overallRate;
        this.qualityPriceRate = builder.qualityPriceRate;
        this.placeId = builder.placeId;
    }

    public ReviewId getReviewId() {
        return reviewId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean hasRudeWords() {
        return hasRudeWords;
    }

    public boolean isMarkedAsAbuse() {
        return markedAsAbuse;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public String getComment() {
        return comment;
    }

    public int getCleanlinessRate() {
        return cleanlinessRate;
    }

    public int getQosRate() {
        return qosRate;
    }

    public int getKindnessRate() {
        return kindnessRate;
    }

    public int getAccessibilityRate() {
        return accessibilityRate;
    }

    public int getDiversityRate() {
        return diversityRate;
    }

    public int getOverallRate() {
        return overallRate;
    }

    public int getQualityPriceRate() {
        return qualityPriceRate;
    }

    public PlaceId getPlaceId() {
        return placeId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(reviewId,
                name,
                email,
                hasRudeWords,
                markedAsAbuse,
                isPublic,
                comment,
                cleanlinessRate,
                qosRate,
                kindnessRate,
                accessibilityRate,
                diversityRate,
                overallRate,
                qualityPriceRate,
                placeId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final RegisterReview other = (RegisterReview) obj;
        return Objects.equal(reviewId, reviewId)
                && Objects.equal(this.name, other.name)
                && Objects.equal(this.email, other.email)
                && Objects.equal(this.hasRudeWords, other.hasRudeWords)
                && Objects.equal(this.markedAsAbuse, other.markedAsAbuse)
                && Objects.equal(this.isPublic, other.isPublic)
                && Objects.equal(this.comment, other.comment)
                && Objects.equal(this.cleanlinessRate, other.cleanlinessRate)
                && Objects.equal(this.qosRate, other.qosRate)
                && Objects.equal(this.kindnessRate, other.kindnessRate)
                && Objects.equal(this.accessibilityRate, other.accessibilityRate)
                && Objects.equal(this.diversityRate, other.diversityRate)
                && Objects.equal(this.overallRate, other.overallRate)
                && Objects.equal(this.qualityPriceRate, other.qualityPriceRate)
                && Objects.equal(this.placeId, other.placeId);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("reviewId", reviewId.getIdentifier())
                .add("name", name)
                .add("email", email)
                .add("hasRudeWords", hasRudeWords)
                .add("markedAsAbuse", markedAsAbuse)
                .add("isPublic", isPublic)
                .add("comment", comment)
                .add("cleanlinessRate", cleanlinessRate)
                .add("qosRate", qosRate)
                .add("kindnessRate", kindnessRate)
                .add("accessibilityRate", accessibilityRate)
                .add("diversityRate", diversityRate)
                .add("overallRate", overallRate)
                .add("qualityPriceRate", qualityPriceRate)
                .add("placeId", placeId)
                .toString();
    }

    public static class Builder implements IsBuilder<RegisterReview> {

        private ReviewId reviewId;
        private String name;
        private String email;
        private boolean hasRudeWords;
        private boolean marked_as_abuse;
        private boolean isPublic;
        private String comment;
        private int cleanlinessRate;
        private int qosRate;
        private int kindnessRate;
        private int accessibilityRate;
        private int diversityRate;
        private int overallRate;
        private int qualityPriceRate;
        private PlaceId placeId;


        public Builder reviewId(final ReviewId reviewId) {
            this.reviewId = reviewId;
            return this;
        }

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public Builder email(final String email) {
            this.email = email;
            return this;
        }

        public Builder hasRudeWords(final boolean hasRudeWords) {
            this.hasRudeWords = hasRudeWords;
            return this;
        }

        public Builder marked_as_abuse(final boolean marked_as_abuse) {
            this.marked_as_abuse = marked_as_abuse;
            return this;
        }

        public Builder isPublic(final boolean aPublic) {
            isPublic = aPublic;
            return this;
        }

        public Builder comment(final String comment) {
            this.comment = comment;
            return this;
        }

        public Builder cleanlinessRate(final int cleanlinessRate) {
            this.cleanlinessRate = cleanlinessRate;
            return this;
        }

        public Builder qosRate(final int qosRate) {
            this.qosRate = qosRate;
            return this;
        }

        public Builder kindnessRate(final int kindnessRate) {
            this.kindnessRate = kindnessRate;
            return this;
        }

        public Builder accessibilityRate(final int accessibilityRate) {
            this.accessibilityRate = accessibilityRate;
            return this;
        }

        public Builder diversityRate(final int diversityRate) {
            this.diversityRate = diversityRate;
            return this;
        }

        public Builder overallRate(final int overallRate) {
            this.overallRate = overallRate;
            return this;
        }

        public Builder qualityPriceRate(final int qualityPriceRate) {
            this.qualityPriceRate = qualityPriceRate;
            return this;
        }

        public Builder placeId(final PlaceId placeId) {
            this.placeId = placeId;
            return this;
        }

        @Override
        public RegisterReview build() {
            checkNotNull(reviewId, "review id cannot be null");
            return new RegisterReview(this);
        }
    }

}
