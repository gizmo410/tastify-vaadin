package be.coruscantit.tastify.domain.api.review;

import org.axonframework.domain.IdentifierFactory;

import javax.annotation.concurrent.Immutable;

/**
 * @since 11/05/14
 */
@Immutable
public class ReviewId {

    private final String identifier;

    protected ReviewId() {
        identifier = IdentifierFactory.getInstance().generateIdentifier();
    }

    public String getIdentifier() {
        return identifier;
    }
}
