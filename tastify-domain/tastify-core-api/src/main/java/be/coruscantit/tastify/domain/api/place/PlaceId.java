package be.coruscantit.tastify.domain.api.place;

import org.axonframework.domain.IdentifierFactory;

import javax.annotation.concurrent.Immutable;

/**
 * @since 08/05/14
 */
@Immutable
public class PlaceId {

    private final String identifier;

    protected PlaceId() {
        identifier = IdentifierFactory.getInstance().generateIdentifier();
    }



    public String getIdentifier() {
        return identifier;
    }
}
