package util;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.company.Company;
import io.codearte.jfairy.producer.person.Person;

public class DataGenerator {
    private Fairy fairy;
    private Person person;
    private Company company;

    //Generate fake person/company data
    public DataGenerator() {
        fairy = Fairy.create();
        person = fairy.person();
        company = fairy.company();
    }

    public Person getPerson(){
        return person;
    }

    public Company getCompany(){
        return company;
    }

    public String getCompanyVat(){
        return company.getVatIdentificationNumber();
    }




}
