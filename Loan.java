public class Loan extends BankingProduct{

    public float LoanValue;
    private double interest;
    
    Loan(String code, String number, String AFM, float LoanValue, double interest){
        super(code,number,AFM);
        this.LoanValue = LoanValue;
        this.interest = interest;
    }

    void setLoanValue(long LoanValue) {
        this.LoanValue = LoanValue;
    }

    void setInterest(double interest) {
        this.interest = interest;
    }

    public String toString(){
        return super.toString() + "\nLoan Value: " + LoanValue + "\nInterest: " + interest + "\n\n";
    }

}