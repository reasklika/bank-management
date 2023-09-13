import java.io.*;
import java.util.*;


public class ReadFile {

    ArrayList<BankingProduct> loadBankItem(String data){
        BufferedReader reader= null;
        ArrayList<BankingProduct> array1 = new ArrayList<BankingProduct>();
        try {
            reader = new BufferedReader (new FileReader(data));
            StringTokenizer lineTokens;
            String token;
            String line;

            line = reader.readLine();  
            while(line!=null){
                String SSN = "00000000";
                String LoanValue = "0";
                String interest = "0";
                String CommissionRate = "0";
                String Maxamount = "0"; 
                String Maxannual = "0";
                int Objcreation = 0;
                if (line.trim().equals("BANKITEM")) {
                    ArrayList<String> array = new ArrayList<String>();
                    while ( !(line.trim().equals("}")) && line!=null ) {
                        lineTokens = new StringTokenizer(line);
                        if(lineTokens.hasMoreTokens()){
                            token = lineTokens.nextToken();  
                            if (token.equalsIgnoreCase("CODE")) {
                                token = lineTokens.nextToken();
                                Objcreation += 1;
                                array.add(token); 
                            }else if (token.equalsIgnoreCase("DESCR")) {
                                token = lineTokens.nextToken();
                                Objcreation += 1; 
                                array.add(line.trim().substring(5));
                            }else if (token.equalsIgnoreCase("TYPE")){
                                Objcreation = Objcreation + 1;
                            }else if (token.equalsIgnoreCase("AFM")){
                                AFM = lineTokens.nextToken();
                                array.add(AFM);
                            }else if (token.equalsIgnoreCase("LOAN_VALUE")) {
                                LoanValue = lineTokens.nextToken();
                                array.add(LoanValue);
                            }else if(token.equalsIgnoreCase("INTEREST")) {
                                interest = lineTokens.nextToken();
                                array.add(interest);
                            }else if (token.equalsIgnoreCase("COMMISSION_RATE")) {
                                CommissionRate = lineTokens.nextToken();
                                array.add(CommissionRate);
                            }else if(token.equalsIgnoreCase("MAX_AMOUNT")) {
                                Maxamount = lineTokens.nextToken();
                                array.add(Maxamount);
                            }else if(token.equalsIgnoreCase("MAX_ANNUAL")) {
                                Maxannual = lineTokens.nextToken();
                                array.add(Maxannual);
                            }
                        }   
                        line = reader.readLine();
                    }
                    String Create = Integer.toString(Objcreation);
                    if ((Create.equals("3"))){
                        if (array.size() == 5){
                            Loan item1 = new Loan(array.get(0), array.get(1), AFM, Float.parseFloat(LoanValue), Double.parseDouble(interest));
                            array1.add(item1);
                        }else if (array.size() == 6){
                            CreditCard item2 = new CreditCard(array.get(0), array.get(1), AFM, Double.parseDouble(CommissionRate), Long.parseLong(Maxamount), Long.parseLong(Maxannual));
                            array1.add(item2);
                        }
                    }else{
                        System.out.println("Some of the basic tags on "+data+" did not exist!");
                    }
                }
                line = reader.readLine();
            }
            System.out.println(data + " loaded successfully.");
        }catch(IOException ex){
            System.err.println("Error Reading " + data + ".");
        }
        return array1;
    }

    ArrayList<SalesMan> loadSalesman(String data) throws IOException {
        BufferedReader reader= null;
        ArrayList<SalesMan> array2 = new ArrayList<SalesMan>();
        try {
            reader = new BufferedReader (new FileReader(data));
            StringTokenizer lineTokens;
            String token;
            String line;    
            line = reader.readLine();
            while(line!=null) {
                String AFM= "00000000";
                int Objcreation = 0;
                if(line.trim().equals("SALESMAN")) {
                    SalesMan sm = new SalesMan();
                    while ( !(line.trim().contains("}")) && line!=null ) {
                        lineTokens = new StringTokenizer(line);
                        if(lineTokens.hasMoreTokens()){
                            token = lineTokens.nextToken();
                            if (token.equalsIgnoreCase("CODE")) {
                                token = lineTokens.nextToken();
                                Objcreation += 1; 
                                sm.setCode(token);
                            }else if(token.equalsIgnoreCase("SURNAME")) {
                                token = lineTokens.nextToken();
                                Objcreation += 1; 
                                sm.setSurname(line.trim().substring(7));
                            }else if (token.equalsIgnoreCase("NAME")) {
                                token = lineTokens.nextToken();
                                Objcreation = Objcreation + 1; 
                                sm.setName(line.trim().substring(4));
                            }else if (token.equalsIgnoreCase("AFM")) {
                                AFM = lineTokens.nextToken(); 
                                sm.setAFM(AFM);
                            }
                        }
                        line = reader.readLine();
                    }
                    String Create = Integer.toString(Objcreation);
                    if (Create.equals("3")){
                        array2.add(sm);
                    }else{
                        System.out.println("Some of the basic tags on "+data+" did not exist!");
                    }
                    
                }
                line = reader.readLine();
            }
            System.out.println(data+" loaded successfully.");
        }catch(IOException ex){
            System.err.println("Error Reading "+data+".");
        }
        return array2;
    }

    ArrayList<BPSale> loadSales(String data) {
        BufferedReader reader= null;
        ArrayList<BPSale> array3 = new ArrayList<BPSale>();
        try {
            reader = new BufferedReader (new FileReader(data));
            StringTokenizer lineTokens;
            String token;
            String line;    
            line = reader.readLine();         
            while(line!=null){
                String justification = "personal reasons";
                int Objcreation = 0;
                if (line.trim().equals("SALES")){
                    BPSale sale = new BPSale();
                    sale.setCausality(justification);
                    while ( !(line.trim().contains("}")) && line!=null) {                        
                        lineTokens = new StringTokenizer(line);
                        if(lineTokens.hasMoreTokens()){
                            token = lineTokens.nextToken();  

                            if (token.equalsIgnoreCase("SALESMAN_CODE")) {
                                token = lineTokens.nextToken();
                                Objcreation += 1; 
                                sale.setSMCode(token);
                            }else if(token.equalsIgnoreCase("BANKITEM_TYPE")) {
                                token = lineTokens.nextToken();
                                Objcreation += 1; 
                                sale.setType(token);
                            }else if (token.equalsIgnoreCase("BANKITEM_CODE")) {
                                token = lineTokens.nextToken();
                                Objcreation = Objcreation + 1; 
                                sale.setBPCode(token);
                            }else if (token.equalsIgnoreCase("JUSTIFICATION")) {
                                justification = line.trim().substring(13);
                                sale.setCausality(justification);
                            }
                        }
                        line = reader.readLine();
                    }
                    String Create = Integer.toString(Objcreation);
                    if (Create.equals("3")){
                        array3.add(sale);
                    }else{
                        System.out.println("Some of the basic tags on "+data+" did not exist!");
                    }
                }
                line = reader.readLine();
            }
            System.out.println(data + " loaded successfully.");
        }catch(IOException ex){
            System.err.println("Error Reading " + data +".");
        }
        return array3;
    }

    ArrayList<CCTransaction> loadTRN(String data) {
        BufferedReader reader= null;
        ArrayList<CCTransaction> array4 = new ArrayList<CCTransaction>();           
        try {
            reader = new BufferedReader (new FileReader(data));
            StringTokenizer lineTokens;
            String token;
            String line;    
            line = reader.readLine();  
            while (line!= null){
                int Objcreation = 0;
                if (line.trim().equals("TRN")){
                    CCTransaction trn = new CCTransaction();
                    while ( !(line.trim().contains("}")) && line != null) {
                        lineTokens = new StringTokenizer(line);
                        if (lineTokens.hasMoreTokens()) {
                            token = lineTokens.nextToken();  
                            if (token.equalsIgnoreCase("BANKITEM_CODE")) {
                                token = lineTokens.nextToken();
                                Objcreation += 1; 
                                trn.setCardCode(token);
                            }else if (token.equalsIgnoreCase("VAL")) {
                                token = lineTokens.nextToken();
                                Objcreation += 1; 
                                trn.setTV(Long.parseLong(token));
                            }else if (token.equalsIgnoreCase("JUSTIFICATION")) {
                                token = lineTokens.nextToken();
                                Objcreation = Objcreation + 1;
                                trn.setCausality(line.trim().substring(13));
                            }
                        }
                        line = reader.readLine();
                    }
                    String Create = Integer.toString(Objcreation);
                    if (Create.equals("3")){
                        array4.add(trn);
                    }else{
                        System.out.println("Some of the basic tags on "+data+" did not exist!");
                    }
                }
                line = reader.readLine();
            }
            System.out.println(data+" loaded successfully.");
        }catch(IOException ex){
            System.err.println("Error Reading "+data+".");
        }
        return array4;
    }
}
