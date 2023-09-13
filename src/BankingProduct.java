public class BankingProduct{

    protected String code;
    protected String number;
    protected String SSN;
    
    BankingProduct (String code, String number, String SSN){
        this.code = code;
        this.number = number;
        this.SSN = SSN;
    }

    BankingProduct() {
        
    }

    void setCode(String code) {
        this.code = code;
    } 

    void setNumber(String number) {
        this.number = number;
    }

    void setSSN(String SSN) {
        this.SSN = SSN;
    }

    String getCode(BankingProduct bpr) {
        return this.code;
    }


    public String toString(){
        return "Code: " + code + "\nNumber: " + number + "\nSSN: " + SSN;
    }

}