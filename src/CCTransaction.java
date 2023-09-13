public class CCTransaction{

    String CardCode;
    long TransactionValue;
    String causality;
    
    CCTransaction(String CardCode, long TransactionValue, String causality){
            this.CardCode = CardCode;
            this.TransactionValue = TransactionValue;
            this.causality = causality;
    }

    CCTransaction() {
        
    }
    
    void setCardCode(String CardCode) {
        this.CardCode = CardCode;
    }

    void setTV(long TV) {
        TransactionValue = TV;
    }

    void setCausality(String causality) {
        this.causality = causality;
    }

    String getCode (CCTransaction trn) {
        return CardCode;
    }


    long getValue (CCTransaction trn) {
        return TransactionValue;
    }

    String getCausality (CCTransaction trn) {
        return causality;
    }

    public String toString(){
        return "Card Code: " + CardCode + "\nTransaction Value: " + TransactionValue + "\nJustification: " + causality + "\n";
    }

}