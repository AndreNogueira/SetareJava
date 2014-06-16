package beans;

public class CreditCard {
    private String firstName;
    private String lastName;
    private String cardType;
    private Integer cardNumber;
    private Integer cvv;
    private Integer year;
    private Integer month;
    
    public boolean validateCreditCard(){
        return true;
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

    public Integer getCardNumber() {
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

    public void setCardNumber(Integer cardNumber) {
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
