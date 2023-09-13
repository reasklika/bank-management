import java.util.*;
import java.io.*;

public class CreateFile {
    public void CreateSalesFile (ArrayList<BPSale> BPS) {
        System.out.println("Writing data from arraylist to txt file.");
        BufferedWriter writer = null;
        try	{
			writer = new BufferedWriter(new FileWriter(new File("SALES_LIST.txt")));
			writer.write("\nSALES_LIST\n"+"{\n");
			for (BPSale bps : BPS){
				if (bps.type.equals("Loan") || bps.type.equals("LOAN")) {
					writer.write ("\t" + "SALES\n" + "\t{"+"\n"+"\t\t" + "BANKITEM_TYPE Loan"+"\n"+"\t\t"
					+ "SALESMAN_CODE " + bps.getSMCode(bps) + "\n"+"\t\t"+"BANKITEM_CODE " + bps.getBPCode(bps)
					+ "\n"+"\t\t"+"JUSTIFICATION "+ bps.getCausality(bps)+ "\n"+"\t}"+"\n");
				}
				else if (bps.type.equals("Card") || bps.type.equals("CARD")) {
					writer.write ("\t"+"SALES"+"\n"+"{"+"\n"+"\t\t"+"BANKITEM_TYPE Card"+"\n"+"\t\t"
					+"SALESMAN_CODE "+ bps.getSMCode(bps)+ "\n"+"\t\t"+"BANKITEM_CODE "+ bps.getBPCode(bps)
					+ "\n"+"\t\t"+"JUSTIFICATION "+ bps.getCausality(bps) + "\n"+"}"+"\n");
				}
			}
			writer.write("}");
			writer.close();
			System.out.println("SALES_LIST.txt is updated");
		}
			catch (IOException e) {
				System.err.println("Error writing file.");
			}
	    }
    public void CreateTRNFile (ArrayList<CCTransaction> CCT)  {
        System.out.println("Writing data from arraylist to txt file.");
        BufferedWriter writer = null;
        try	{
			writer = new BufferedWriter(new FileWriter(new File("TRN_LIST.txt")));
			writer.write("\nTRN_LIST\n"+"{\n");
			for (CCTransaction trn: CCT) {
				writer.write("\t"+"TRN\n" +"\t{\n"+"\t\t"+"BANKITEM_CODE "+trn.getCode(trn)+"\n"+"\t\t"+"VAL "
							+trn.getValue(trn)+"\n"+"\t\t"+"JUSTIFICATION "+trn.getCausality(trn)+"\n"+"\t}\n");
			}
			writer.write("}");
			writer.close();
			System.out.println("TRN_LIST.txt is updated");
		}catch(IOException e) {
			System.err.println("Error writing file.");
		}
	}
    }
