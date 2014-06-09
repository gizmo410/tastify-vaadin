package be.coruscantit.tastify.domain.api.place;

import be.coruscantit.tastify.domain.api.IsBuilder;
import com.google.common.base.Objects;

/**
 * @since 08/05/14
 */
public class Address {

    private String streetName;
    private Integer streetNumber;
    private String zipcode;
    private String city;
    private String country;

    // Forces usage of builder pattern
    protected Address() {
    }

    public Address(final Builder builder) {
        this.streetName = builder.streetName;
        this.streetNumber = builder.streetNumber;
        this.zipcode = builder.zipcode;
        this.city = builder.city;
        this.country = builder.country;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(streetName, streetNumber, zipcode, city, country);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Address other = (Address) obj;
        return Objects.equal(this.streetName, other.streetName)
                && Objects.equal(this.streetNumber, other.streetNumber)
                && Objects.equal(this.zipcode, other.zipcode)
                && Objects.equal(this.city, other.city)
                && Objects.equal(this.country, other.country);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .addValue(streetName)
                .addValue(streetNumber)
                .addValue(zipcode)
                .addValue(city)
                .addValue(country)
                .toString();
    }

    public static class Builder implements IsBuilder<Address> {

        private String streetName;
        private Integer streetNumber;
        private String zipcode;
        private String city;
        private String country;

        public Builder streetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder streetNumber(Integer streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder zipcode(String zipcode) {
            this.zipcode = zipcode;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        @Override
        public Address build() {
            return new Address(this);
        }
    }


}
