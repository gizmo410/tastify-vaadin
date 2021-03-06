package be.coruscantit.tastify.domain.api.place;

import be.coruscantit.tastify.domain.api.IsBuilder;
import com.google.common.base.Objects;

import java.io.Serializable;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @since 05/05/14
 */
public class RegisterPlace implements Serializable {

    private PlaceId placeId;
    private String name;
    private String detail;
    private Address address;
    private String userId;
    private PlaceType placeType;
    private String phoneNumber;


    // Forces usage of builder pattern
    protected RegisterPlace() {
    }

    public RegisterPlace(final Builder builder) {
        this.placeId = builder.placeId;
        this.name = builder.name;
        this.detail = builder.detail;
        this.address = builder.address;
        this.userId = builder.userId;
        this.placeType = builder.placeType;
        this.phoneNumber = builder.phoneNumber;
    }

    public PlaceId getPlaceId() {
        return placeId;
    }

    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }

    public Address getAddress() {
        return address;
    }

    public String getUserId() {
        return userId;
    }

    public PlaceType getPlaceType() {
        return placeType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(placeId, name, detail, address, userId, placeType, phoneNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final RegisterPlace other = (RegisterPlace) obj;
        return Objects.equal(this.placeId, other.placeId)
                && Objects.equal(this.name, other.name)
                && Objects.equal(this.detail, other.detail)
                && Objects.equal(this.address, other.address)
                && Objects.equal(this.userId, other.userId)
                && Objects.equal(this.placeType, other.placeType)
                && Objects.equal(this.phoneNumber, other.phoneNumber);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .addValue(placeId)
                .addValue(name)
                .addValue(detail)
                .addValue(address)
                .addValue(userId)
                .addValue(placeType)
                .addValue(phoneNumber)
                .toString();
    }

    public static class Builder implements IsBuilder<RegisterPlace> {

        private PlaceId placeId;
        private String name;
        private String detail;
        private Address address;
        private String userId;
        private PlaceType placeType;
        private String phoneNumber;


        public Builder placeId(PlaceId placeId) {
            this.placeId = placeId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder placeType(PlaceType placeType) {
            this.placeType = placeType;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        @Override
        public RegisterPlace build() {
            checkNotNull(placeId, "Place identifier must not be null");
            checkNotNull(name, "Place name must not be null");
            checkNotNull(detail, "Place detail must not be null");
            checkNotNull(address, "Place address must not be null");
            checkNotNull(userId, "Place user must not be null");
            checkNotNull(placeType, "Place type must not be null");
            checkNotNull(phoneNumber, "Place phonenumber must not be null");
            return new RegisterPlace(this);
        }
    }
}
