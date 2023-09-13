import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class mainApp {
    public static void main(String[] args) throws IOException {
        
        ReadFile store = new ReadFile();

        HashMap<String, ArrayList<BPSale>> Salesmen = new HashMap<String, ArrayList<BPSale>>();
        HashMap<String, Loan> Loans = new HashMap<String, Loan>();
        HashMap<String, CreditCard> CreditCards = new HashMap<String, CreditCard>();
        HashMap<String, ArrayList<CCTransaction>> CCTransactions = new HashMap<String, ArrayList<CCTransaction>>(); 
        ArrayList<BankingProduct> BP = new ArrayList<BankingProduct>();
        ArrayList<SalesMan> SM = new ArrayList<SalesMan>();
        ArrayList<BPSale> BPS = new ArrayList<BPSale>();
        ArrayList<CCTransaction> CCT = new ArrayList<CCTransaction>();
        
        
        
        SalesMan sm1 = new SalesMan("3210163", "Pergantis", "Nikolaos", "111111111");
        SalesMan sm2 = new SalesMan("3210177", "Samouelian", "Sarkis", "222222222");
        SalesMan sm3 = new SalesMan("3210181", "Sklika", "Rea", "333333333");        
        SM.add(sm1);
        SM.add(sm2);
        SM.add(sm3);
        SM.addAll(store.loadSalesman("SALESMAN_LIST.txt"));
        
        Loan l1 = new Loan("123456", "Loan 1", "444444444", 200000, 0.01);
        Loan l2 = new Loan("234567", "Loan 2", "555555555", 100000, 0.012);
        Loan l3 = new Loan("345678", "Loan 3", "666666666", 400000, 0.015);
        CreditCard cc1 = new CreditCard("456789", "Card 1", "444444444",0.01, 300, 40000);
        CreditCard cc2 = new CreditCard("567891", "Card 2", "555555555", 0.013, 450, 70000);
        CreditCard cc3 = new CreditCard("678912", "Card 3", "666666666", 0.02, 280, 30000);
        Loans.put(l1.code, l1);
        Loans.put(l2.code, l2);
        Loans.put(l3.code, l3);
        CreditCards.put(cc1.code, cc1);
        CreditCards.put(cc2.code, cc2);
        CreditCards.put(cc3.code, cc3);
        BP.add(l1);
        BP.add(l2);
        BP.add(l3);
        BP.add(cc1);
        BP.add(cc2);
        BP.add(cc3);
        for (BankingProduct bp: store.loadBankItem("BANKITEM_LIST.txt")){
            if (bp instanceof Loan){
                Loans.put(bp.code, (Loan)bp);
                BP.add(bp);
            }else{
                CreditCards.put(bp.code, (CreditCard)bp);
                BP.add(bp);
            }
        }

        
        BPSale bps1 = new BPSale("3210163", "123456", "house build", "Loan");
        BPSale bps2 = new BPSale("3210177", "234567", "enterprise beginning", "Loan");
        BPSale bps3 = new BPSale("3210181", "345678", "car purchase", "Loan");
        BPSale bps4 = new BPSale("3210163", "456789", "private use", "Card");
        BPSale bps5 = new BPSale("3210177", "567891", "private use", "Card");
        BPSale bps6 = new BPSale("3210181", "678912", "private use", "Card");
        ArrayList<BPSale> s1 = new ArrayList<BPSale>();
        Salesmen.put("3210163", s1);
        Salesmen.get("3210163").add(bps1);
        ArrayList<BPSale> s2 = new ArrayList<BPSale>();
        Salesmen.put("3210177", s2);
        Salesmen.get("3210177").add(bps2);
        ArrayList<BPSale> s3 = new ArrayList<BPSale>();
        Salesmen.put("3210181", s3);
        Salesmen.get("3210181").add(bps3);
        Salesmen.get("3210163").add(bps4);
        Salesmen.get("3210177").add(bps5);
        Salesmen.get("3210181").add(bps6);
        for (BPSale bps: store.loadSales("SALES_LIST.txt")){
            if(Salesmen.containsKey(bps.SMCode)){
                Salesmen.get(bps.SMCode).add(bps);
                BPS.add(bps);
            }else{
                ArrayList<BPSale> Array = new ArrayList<BPSale>();
                Salesmen.put(bps.SMCode, Array);
                Salesmen.get(bps.SMCode).add(bps);
                BPS.add(bps);
            }
        }
        
        CCTransaction cct1 = new CCTransaction("456789", 100, "bills");
        CreditCards.get(cct1.CardCode).sum += cct1.TransactionValue;
        CCTransaction cct2 = new CCTransaction("456789", 20, "clothes");
        CreditCards.get(cct2.CardCode).sum += cct2.TransactionValue;
        CCTransaction cct3 = new CCTransaction("456789", 50, "gifts");
        CreditCards.get(cct3.CardCode).sum += cct3.TransactionValue;
        CCTransaction cct4 = new CCTransaction("456789", 20, "savings");
        CreditCards.get(cct4.CardCode).sum += cct4.TransactionValue;
        CCTransaction cct5 = new CCTransaction("567891", 80, "night out");
        CreditCards.get(cct5.CardCode).sum += cct5.TransactionValue;
        CCTransaction cct6 = new CCTransaction("567891", 20, "food");
        CreditCards.get(cct6.CardCode).sum += cct6.TransactionValue;
        CCTransaction cct7 = new CCTransaction("567891", 20, "books");
        CreditCards.get(cct7.CardCode).sum += cct7.TransactionValue;
        CCTransaction cct8 = new CCTransaction("567891", 60, "bills");
        CreditCards.get(cct8.CardCode).sum += cct8.TransactionValue;
        CCTransaction cct9 = new CCTransaction("678912", 20, "food");
        CreditCards.get(cct9.CardCode).sum += cct9.TransactionValue;
        CCTransaction cct10 = new CCTransaction("678912", 100, "travel");
        CreditCards.get(cct10.CardCode).sum += cct10.TransactionValue;
        CCTransaction cct11 = new CCTransaction("678912", 60, "savings");
        CreditCards.get(cct11.CardCode).sum += cct11.TransactionValue;
        CCTransaction cct12 = new CCTransaction("678912", 60, "self care");
        CreditCards.get(cct12.CardCode).sum += cct12.TransactionValue;
        ArrayList<CCTransaction> CCT1 = new ArrayList<CCTransaction>();
        CCTransactions.put(cct1.CardCode, CCT1);
        CCTransactions.get(cct1.CardCode).add(cct1);
        CCTransactions.get(cct2.CardCode).add(cct2);
        CCTransactions.get(cct3.CardCode).add(cct3);
        CCTransactions.get(cct4.CardCode).add(cct4);
        ArrayList<CCTransaction> CCT2 = new ArrayList<CCTransaction>();
        CCTransactions.put(cct5.CardCode, CCT2);
        CCTransactions.get(cct5.CardCode).add(cct5);
        CCTransactions.get(cct6.CardCode).add(cct6);
        CCTransactions.get(cct7.CardCode).add(cct7);
        CCTransactions.get(cct8.CardCode).add(cct8);
        ArrayList<CCTransaction> CCT3 = new ArrayList<CCTransaction>();
        CCTransactions.put(cct9.CardCode, CCT3);
        CCTransactions.get(cct9.CardCode).add(cct9);
        CCTransactions.get(cct10.CardCode).add(cct10);
        CCTransactions.get(cct11.CardCode).add(cct11);
        CCTransactions.get(cct12.CardCode).add(cct12);
        CCT.addAll(store.loadTRN("TRN_LIST.txt"));

        boolean done=false;
        Scanner in = new Scanner(System.in);


        do{
            System.out.println("1. Insert seller");
            System.out.println("2. Insert Banking Product");
            System.out.println("3. Insert new sale of a banking product");
            System.out.println("4. Insert new Credit Card Transaction");
            System.out.println("5. Print loans");
            System.out.println("6. Calculate a seller's commission");
            System.out.println("7. Seller's credit card moves");
            System.out.println("8. Calculate all sellers' commissions");
            System.out.println("9. Print final sellers commission");
            System.out.println("10. Load banking product sales and credit card transactions into txt files");
            System.out.println("0. Exit");
            System.out.print("> ");
            String answer = in.nextLine();
            String answer4;
            if (answer.equals("1")){
                System.out.print("Are you sure of your decision? (1. YES 2. NO) ");
                answer4 = in.nextLine();
                while(!answer4.equals("1") && !answer4.equals("2")) {
                    System.out.println("Choice does not exist. Please insert 1 for YES or 2 for NO.");
                    answer4 = in.nextLine();
                }
                if (answer4.equals("2")){
                    continue;
                }else if (answer4.equals("1")){
                    System.out.println("Please insert seller's info");
                    System.out.print("Name:");
                    String name = in.nextLine();
                    System.out.print("\nSurname:");
                    String surname = in.nextLine();
                    System.out.print("\nCode:");
                    String code = in.nextLine();
                    System.out.print("\nSSN:");
                    String SSN = in.nextLine();
                    SalesMan newSM = new SalesMan(code, surname, name, SSN);
                    SM.add(newSM);
                    ArrayList<BPSale> newsales = new ArrayList<BPSale>();
                    Salesmen.put(code, newsales);
                }
                
            }else if (answer.equals("2")){
                System.out.print("Are you sure of your decision? (1. YES 2. NO) ");
                answer4 = in.nextLine();
                while(!answer4.equals("1") && !answer4.equals("2")) {
                    System.out.println("Choice does not exist. Please insert 1 for YES or 2 for NO.");
                    answer4 = in.nextLine();
                }
                if (answer4.equals("2")){
                    continue;
                }else if (answer4.equals("1")){
                    System.out.println("Please insert banking product's info (Credit Card or Loan)");
                    System.out.print("Do you want to create a credit card? (1. YES 2. NO) ");
                    String answer1 = in.nextLine();
                    if (! (answer1.equals("1") || answer1.equals("2"))){
                        System.out.println("Your answer has to be either 1 or 2.Please try again.");
                        System.out.print("Do you want to create a credit card? (1. YES 2. NO)");
                        answer1 = in.nextLine();
                    }
                    System.out.print("\nCode:");
                    String code = in.nextLine();
                    if (Loans.containsKey(code) || CreditCards.containsKey(code)){
                        System.out.println("The code you gave already exists. Please try again!");
                        System.out.print("\nCode:");
                        code = in.nextLine();
                    }
                    System.out.print("\nNumber:");
                    String number = in.nextLine();
                    System.out.print("\nSSN:");
                    String SSN1 = in.nextLine();
                    if (answer1.equals("1")){
                        System.out.print("\nCommission Rate:");
                        float CommissionRate = Float.parseFloat(in.nextLine());
                        System.out.print("\nMax amount:");
                        long maxAmount = Long.parseLong(in.nextLine());
                        System.out.print("\nMax annual:");
                        long maxAnnual = Long.parseLong(in.nextLine());
                        CreditCard newCC = new CreditCard(code, number, SSN1, CommissionRate, maxAmount, maxAnnual);
                        BP.add(newCC);
                        CreditCards.put(newCC.code, newCC);
                        ArrayList<CCTransaction> newCCTransaction = new ArrayList<CCTransaction>();
                        CCTransactions.put(newCC.code, newCCTransaction);
                    }else{
                        System.out.print("\nLoan Value:");
                        float LoanValue1 = Float.parseFloat(in.nextLine());
                        System.out.print("\nLoan Interest:");
                        float LoanInterest1 = Float.parseFloat(in.nextLine());
                        Loan newL = new Loan(code, number, SSN1, LoanValue1, LoanInterest1);
                        BP.add(newL);
                        Loans.put(newL.code, newL);
                    }
                }
            }else if(answer.equals("3")){
                System.out.print("Are you sure of your decision? (1. YES 2. NO) ");
                answer4 = in.nextLine();
                while(!answer4.equals("1") && !answer4.equals("2")) {
                    System.out.println("Choice does not exist. Please insert 1 for YES or 2 for NO.");
                    answer4 = in.nextLine();
                }
                if (answer4.equals("2")){
                    continue;
                }else if (answer4.equals("1")){
                    boolean found1 = false;
                    String SMCode="";
                    while(found1 != true) {
                        System.out.println("Please insert the code of one of the following Salesmen!\n");
                        for(SalesMan sm: SM){
                            System.out.println("Salesman name: " + sm.name + "\nSalesman code: " + sm.code + "\nSalesman surname: " + sm.surname + "\n");
                        }
                        System.out.print("\nSalesMan Code:");
                        SMCode = in.nextLine();
                        for (SalesMan person : SM) {
                            if (SMCode.equals(person.getCode(person))) {
                                found1 = true;
                                break;
                            }
                        }
                        if (found1 != true) {
                            System.out.println("\nCode does not exist. Try again.");
                        }
                    }
                    
                    String type = null;
                    String BPCode = null;
                    Boolean found2 = false;
                    while (found2 != true) {
                        System.out.println("Please insert the code of one of the following Banking Products!\n");
                        for (BankingProduct bp: BP){
                            System.out.println("Banking Product code: " + bp.code + "\nBanking product number: " + bp.number + "\n");
                        }
                        System.out.print("\nBanking Product Code:");
                        BPCode = in.nextLine();
                        for(BankingProduct item : BP){
                            if (BPCode.equals(item.getCode(item))) {
                                if (item instanceof Loan) {
                                    type = "Loan";
                                }else{
                                    type = "Card";
                                }
                                found2 = true;
                                break;
                            }
                        }
                        if (found2 != true) {
                            System.out.println("\nCode does not exist. Try again.");
                        }
                    }
                    System.out.print("\nCausality:");
                    String Causality = in.nextLine();
                    BPSale newBPS = new BPSale(SMCode, BPCode, Causality, type);
                    BPS.add(newBPS);
                }
            }
            else if(answer.equals("4")){
                System.out.print("Are you sure of your decision? (1. YES 2. NO) ");
                answer4 = in.nextLine();
                while(!answer4.equals("1") && !answer4.equals("2")) {
                    System.out.println("Choice does not exist. Please insert 1 for YES or 2 for NO.");
                    answer4 = in.nextLine();
                }
                if (answer4.equals("2")){
                    continue;
                }else if (answer4.equals("1")){
                    System.out.println("Select credit card:");
                    for(BankingProduct bp :BP) {
                        if (bp instanceof CreditCard) {
                            System.out.println("Credit card code: " + bp.code + "\nCredit card number: " + bp.number + "\nCustomer's SSN: " + bp.SSN + "\n");
                        }
                    }
                    System.out.print("Please enter code:");
                    String getCode = in.nextLine();
                    while (! CreditCards.containsKey(getCode)){
                        System.out.println("Credit card code not found. Please try again:");
                        getCode = in.nextLine();
                    }
                    System.out.print("Value of transaction: ");
                    int getValue = Integer.parseInt(in.nextLine());
                    if(getValue > CreditCards.get(getCode).MaxAmount){
                        System.out.println("The Transaction Value surpasses the max amount of transaction. Please give a smaller amount.");
                        System.out.print("Value of transaction: ");
                        getValue = Integer.parseInt(in.nextLine());
                    }else if(getValue + CreditCards.get(getCode).sum > CreditCards.get(getCode).MaxAnnual){
                        System.out.println("The Transaction Value surpasses the max annual amount of transaction. Please give a smaller amount.");
                        System.out.print("Value of transaction:");
                        getValue = Integer.parseInt(in.nextLine());
                    }else{
                        System.out.println("The transaction is now completed.");
                        CreditCards.get(getCode).sum += getValue;
                    }
                    System.out.println("Causality of transaction: ");
                    String causality = in.nextLine();
                    CCTransaction cct13 = new CCTransaction(getCode, getValue, causality);
                    CCT.add(cct13);
                    CCTransactions.get(getCode).add(cct13);
                }
            }else if (answer.equals("5")){
                System.out.print("Are you sure of your decision? (1. YES 2. NO) ");
                answer4 = in.nextLine();
                while(!answer4.equals("1") && !answer4.equals("2")) {
                    System.out.println("Choice does not exist. Please insert 1 for YES or 2 for NO.");
                    answer4 = in.nextLine();
                }
                if (answer4.equals("2")){
                    continue;
                }else if (answer4.equals("1")){    
                    for(BankingProduct bp : BP) {
                        if (bp instanceof Loan) {
                            System.out.println(bp);
                            for (SalesMan sm: SM){
                                for (BPSale bps: BPS){
                                    if (sm.code.equalsIgnoreCase(bps.SMCode)){
                                        System.out.println(sm);
                                        break;
                                    }
                                break;
                                }
                            }
                        }
                    }
                }
            }else if (answer.equals("6")){
                System.out.print("Are you sure of your decision? (1. YES 2. NO) ");
                answer4 = in.nextLine();
                while(!answer4.equals("1") && !answer4.equals("2")) {
                    System.out.println("Choice does not exist. Please insert 1 for YES or 2 for NO.");
                    answer4 = in.nextLine();
                }
                if (answer4.equals("2")){
                    continue;
                }else if (answer4.equals("1")){
                    String answer2="";
                    double sumsup=0;
                    boolean found = false;
                    while (!found) {
                        for(SalesMan sm: SM){
                            System.out.println(sm);
                        }
                        System.out.print("\nPlease give the code of the seller you want to calculate the commission:");
                        answer2 = in.nextLine(); 
                        for (SalesMan sm : SM) {
                            if (sm.code.equals(answer2)) {
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Code does not exist. Please try again.");
                        }
                    }
                    if (Salesmen.get(answer2) == null){
                        System.out.println("The Salesman " + answer2 + " has not made any sales!");
                    }else{
                        for (BPSale bps: Salesmen.get(answer2)){
                            if (Loans.containsKey(bps.BPCode)){
                                System.out.printf("The value of the loan with number %s is %f.", Loans.get(bps.BPCode).code, Loans.get(bps.BPCode).LoanValue);
                                float sum2 = Loans.get(bps.BPCode).LoanValue;
                                if (sum2 <= 500000){
                                    sumsup = sum2 * 0.01 + sumsup;
                                    System.out.printf("The total commission of the loans is %.2f.%n", sum2 * 0.01);
                                } else if (sum2 <= 2000000){
                                    sumsup = sum2 * 0.02 + sumsup;
                                    System.out.printf("The total commission of the loans is %.2f.%n", sum2 * 0.02);
                                }else{
                                    sumsup = sum2 * 0.025 + sumsup;
                                    System.out.printf("The total commission of the loans is %.2f.%n", sum2 * 0.025);
                                } 
                            }else{
                                System.out.printf("The commission of the card with number %s is %.2f.%n", bps.BPCode, CreditCards.get(bps.BPCode).sum * CreditCards.get(bps.BPCode).CommissionRate);
                                sumsup = CreditCards.get(bps.BPCode).sum * CreditCards.get(bps.BPCode).CommissionRate + sumsup;
                            }  
                        }
                    }
                    
                    System.out.printf("The total commission the seller %s is gonna take is %.2f.%n", answer2, sumsup);
                }
            }else if(answer.equals("7")){
                System.out.print("Are you sure of your decision? (1. YES 2. NO) ");
                answer4 = in.nextLine();
                while(!answer4.equals("1") && !answer4.equals("2")) {
                    System.out.println("Choice does not exist. Please insert 1 for YES or 2 for NO.");
                    answer4 = in.nextLine();
                }
                if (answer4.equals("2")){
                    continue;
                }else if (answer4.equals("1")){
                    for (SalesMan sm: SM){
                        System.out.println(sm);
                    }
                    System.out.print("\nPlease insert the code of the seller you want to check:");
                    String answer3 = in.nextLine();
                    if (Salesmen.get(answer3) == null){
                        System.out.println("The Salesman " + answer3 + " has not made any sales!");
                    }else{
                        for(BPSale bp: Salesmen.get(answer3)){
                            if(CreditCards.containsKey(bp.BPCode)){
                                System.out.println(CCTransactions.get(bp.BPCode));
                            }
                        }
                    }
                    
                }
            }else if (answer.equals("8")){
                System.out.print("Are you sure of your decision? (1. YES 2. NO) ");
                answer4 = in.nextLine();
                while(!answer4.equals("1") && !answer4.equals("2")) {
                    System.out.println("Choice does not exist. Please insert 1 for YES or 2 for NO.");
                    answer4 = in.nextLine();
                }
                if (answer4.equals("2")){
                    continue;
                }else if (answer4.equals("1")){
                    for(SalesMan sm: SM){
                        System.out.println(sm);
                        double sumsup = 0;
                        if (Salesmen.get(sm.code) == null){
                            System.out.println("The Salesman " + sm.code + " has not made any sales!");
                        }else{
                            for (BPSale bps: Salesmen.get(sm.code)){
                                if (Loans.containsKey(bps.BPCode)){
                                    System.out.printf("The value of the loan with number %s is %f.", Loans.get(bps.BPCode).code, Loans.get(bps.BPCode).LoanValue);
                                    float sum2 = Loans.get(bps.BPCode).LoanValue;
                                    if (sum2 <= 500000){
                                        sumsup = sum2 * 0.01 + sumsup;
                                        System.out.printf("The total commission of the loans is %.2f.%n", sum2 * 0.01);
                                    } else if (sum2 <= 2000000){
                                        sumsup = sum2 * 0.02 + sumsup;
                                        System.out.printf("The total commission of the loans is %.2f.%n", sum2 * 0.02);
                                    }else{
                                        sumsup = sum2 * 0.025 + sumsup;
                                        System.out.printf("The total commission of the loans is %.2f.%n", sum2 * 0.025);
                                    } 
                                }else{
                                    System.out.printf("The commission of the card %s is %.2f.%n", bps.BPCode, CreditCards.get(bps.BPCode).CommissionRate * CreditCards.get(bps.BPCode).sum);
                                    sumsup = CreditCards.get(bps.BPCode).sum * CreditCards.get(bps.BPCode).CommissionRate + sumsup;
                                }  
                            }
                            System.out.printf("The total commission the seller %s is gonna take is %.2f.%n", sm.code, sumsup);
                        }
                    }
                }
            }else if(answer.equals("9")){
                System.out.print("Are you sure of your decision? (1. YES 2. NO) ");
                answer4 = in.nextLine();
                while(!answer4.equals("1") && !answer4.equals("2")) {
                    System.out.println("Choice does not exist. Please insert 1 for YES or 2 for NO.");
                    answer4 = in.nextLine();
                }
                if (answer4.equals("2")){
                    continue;
                }else if (answer4.equals("1")){
                    double sum3 = 0;
                    for(SalesMan sm: SM){
                        double sumsup = 0;
                        if (Salesmen.get(sm.code) == null){
                            System.out.println("The Salesman " + sm.code + " has not made any sales!");
                        }else{
                            for (BPSale bps: Salesmen.get(sm.code)){
                                if (Loans.containsKey(bps.BPCode)){
                                    System.out.printf("The value of the loan %s is %.2f.%n", Loans.get(bps.BPCode).code, Loans.get(bps.BPCode).LoanValue);
                                    float sum2 = Loans.get(bps.BPCode).LoanValue;
                                    if (sum2 <= 500000){
                                        sumsup = sum2 * 0.01 + sumsup;
                                        System.out.printf("The total commission of the loans is %.2f.%n", sum2 * 0.01);
                                    } else if (sum2 <= 2000000){
                                        sumsup = sum2 * 0.02 + sumsup;
                                        System.out.printf("The total commission of the loans is %.2f.%n", sum2 * 0.02);
                                    }else{
                                        sumsup = sum2 * 0.025 + sumsup;
                                        System.out.printf("The total commission of the loans is %.2f.%n", sum2 * 0.025);
                                    } 
                                }else{
                                    System.out.printf("The commission of the card %s is %.2f.%n", bps.BPCode, CreditCards.get(bps.BPCode).CommissionRate * CreditCards.get(bps.BPCode).sum);
                                    sumsup = CreditCards.get(bps.BPCode).sum * CreditCards.get(bps.BPCode).CommissionRate + sumsup;
                                }  
                            }
                            sum3 = sum3 + sumsup;
                        }
                    }
                    System.out.printf("The total commission of all the sellers is %.2f.%n",  sum3);
                }
            }else if (answer.equals("10")){
                System.out.print("Are you sure of your decision? (1. YES 2. NO) ");
                answer4 = in.nextLine();
                while(!answer4.equals("1") && !answer4.equals("2")) {
                    System.out.println("Choice does not exist. Please insert 1 for YES or 2 for NO.");
                    answer4 = in.nextLine();
                }
                if (answer4.equals("2")){
                    continue;
                }else if (answer4.equals("1")){
                    CreateFile cf = new CreateFile();
                    cf.CreateSalesFile(BPS);
                    cf.CreateTRNFile(CCT);
                }
            }else if (answer.equals("0")){
                System.out.print("Are you sure of your decision? (1. YES 2. NO) ");
                answer4 = in.nextLine();
                while(!answer4.equals("1") && !answer4.equals("2")) {
                    System.out.println("Choice does not exist. Please insert 1 for YES or 2 for NO.");
                    answer4 = in.nextLine();
                }
                if (answer4.equals("2")){
                    continue;
                }else if (answer4.equals("1")){
                    CreateFile cf = new CreateFile();
                    cf.CreateSalesFile(BPS);
                    cf.CreateTRNFile(CCT);
                    System.out.println("You are exiting the App menu!");
                    done = true;
                    in.close();
                }
            }else{
                System.out.println("Please give only one of the numbers presented!");
                continue;
            }
        }while ( ! done);
    }
}
