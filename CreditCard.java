public class CreditCard extends BankingProduct{

    public double CommissionRate;
    public long MaxAmount;
    public long MaxAnnual;
    protected float sum;

    CreditCard(String code, String number, String AFM, double CommissionRate, long MaxAmount, long MaxAnnual){
        super(code, number, AFM);
        this.CommissionRate = CommissionRate;
        this.MaxAmount = MaxAmount;
        this.MaxAnnual = MaxAnnual;
        sum = 0;
    }

    void setComRate(double ComRate) {
        CommissionRate = ComRate;
    }

    void setMaxAmount(long MaxAmount) {
        this.MaxAmount = MaxAmount;
    }

    void setMaxAnnual(long MaxAnnual) {
        this.MaxAnnual = MaxAnnual;
    }

    public String toString(){
        return super.toString() + "\nCommission Rate: " + CommissionRate + "\nWithdrawal max amount: " + MaxAmount + "\nWithdrawal annual max amount: " + MaxAnnual + "\n\n";
    }
}