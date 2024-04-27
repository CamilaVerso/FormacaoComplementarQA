const faker = require("faker");

export const addressData = {
  company: faker.company.suffixes(),
  address: faker.address.streetAddress(),
  addressSecondary: faker.address.secondaryAddress(),
  city: faker.address.city(),
  state: faker.address.state(),
  zipCode: faker.address
    .zipCode()
    .replace(/[^0-9]/g, "")
    .slice(0, 5),
  phoneNumber: faker.phone.phoneNumberFormat(0).replace(/\D/g, "").slice(0, 5),
  addInformation: faker.lorem.words(2),
  invalidData: " ",
};
