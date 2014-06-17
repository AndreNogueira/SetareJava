package beans;

import java.util.Calendar;
import org.apache.commons.validator.routines.CreditCardValidator;

public class CreditCard {

    private String firstName;
    private String lastName;
    private String cardType;
    private String cardNumber;
    private Integer cvv;
    private Integer year;
    private Integer month;

    public boolean validateCreditCard() {
        CreditCardValidator ccv = new CreditCardValidator();
        boolean cardNumberValid = ccv.isValid(cardNumber);
        int yearNow = Calendar.getInstance().get(Calendar.YEAR);
        return cardNumberValid && this.year >= yearNow;
    }

    /* Getters and Setters */
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCardType() {
        return cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Integer getCvv() {
        return cvv;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }
}
