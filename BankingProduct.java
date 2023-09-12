public class BankingProduct{

    protected String code;
    protected String number;
    protected String AFM;
    
    BankingProduct (String code, String number, String AFM){
        this.code = code;
        this.number = number;
        this.AFM = AFM;
    }

    BankingProduct() {
        
    }

    void setCode(String code) {
        this.code = code;
    } 

    void setNumber(String number) {
        this.number = number;
    }

    void setAFM(String AFM) {
        this.AFM = AFM;
    }

    String getCode(BankingProduct bpr) {
        return this.code;
    }


    public String toString(){
        return "Code: " + code + "\nNumber: " + number + "\nAFM: " + AFM;
    }

}