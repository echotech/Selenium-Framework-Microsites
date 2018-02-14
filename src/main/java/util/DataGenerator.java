package util;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.company.Company;
import io.codearte.jfairy.producer.person.Person;

public class DataGenerator {
    private Fairy fairy;
    private Person person;

    //Generate fake person/company data
    public DataGenerator() {
        fairy = Fairy.create();
        fairy.person();
        Company company = fairy.company();
    }
}
