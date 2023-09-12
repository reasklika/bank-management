public class BPSale {
    
    String SMCode;
    String BPCode;
    String causality;
    String type;

    BPSale(String SMCode, String BPCode, String causality, String type){
        this.SMCode = SMCode;
        this.BPCode = BPCode;
        this.causality = causality;
        this.type = type;
    }

    BPSale(){

    }
    
    void setType(String type) {
        this.type = type;
    }
        
    void setSMCode(String SMCode) {
        this.SMCode = SMCode;
    }
    
    void setBPCode(String BP) {
        this.BPCode = BP;
    }
    
    void setCausality(String causality) {
        this.causality = causality;
    }

    String getSMCode(BPSale bpsale) {
        return SMCode;
    }

    String getBPCode(BPSale bpsale) {
        return BPCode;
    }

    String getType (BPSale bpsale) {
        return type;
    }

    String getCausality (BPSale bpsale) {
        return causality;
    }
}