package org.improving.workshop.domain.customer.address;

import net.datafaker.Faker;
import org.improving.workshop.domain.faker.BaseFaker;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressFaker extends BaseFaker {

  private static final List<String> ADDRESS_FORMAT_CODES = List.of("US", "MX", "CA", "EU");
  private static final String RESID_TYPE_CODE = "RESID";
  private static final String VENUE_TYPE_CODE = "VENUE";

  public AddressFaker(Faker faker) {
    super(faker);
  }

  public Address generateCustomerAddress(String customerId) {
    return generateCustomerAddress(randomId(), customerId);
  }

  public Address generateCustomerAddress(String addressId, String customerId) {
    return generateAddress(addressId, customerId, RESID_TYPE_CODE);
  }

  public Address generateVenueAddress(String customerId) {
    return generateAddress(randomId(), customerId, VENUE_TYPE_CODE);
  }

  private Address generateAddress(String addressId, String customerId, String addressType) {
    String stateAbbr = faker.address().stateAbbr();
    String zipByState = faker.address().zipCodeByState(stateAbbr);

    return new Address(
            addressId,
            customerId,
            faker.options().nextElement(ADDRESS_FORMAT_CODES),
            addressType,
            faker.address().mailBox(),
            faker.address().streetAddress(),
            faker.address().cityName(),
            stateAbbr,
            zipByState,
            faker.number().digits(4),
            faker.address().countryCode()
    );
  }
}
