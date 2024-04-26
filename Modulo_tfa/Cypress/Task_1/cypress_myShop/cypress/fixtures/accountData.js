const faker = require("faker");

export const accountData = {
    validEmail: faker.internet.email(),
    validPassword: faker.internet.password(),
    firstName: faker.name.firstName(),
    lastName: faker.name.lastName(),
    day: faker.datatype.number({ min: 1, max: 31 }),
    month: faker.date.month(),
    year: faker.datatype.number({ min: 1900, max: 2022 }),
    
}

