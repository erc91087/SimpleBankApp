import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class UtilityPage {
    
    public ArrayList<Account> readFile(String fileName) {
        
        ArrayList<Account> accounts = new ArrayList<>();
        try {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr); // efficient way of processing file
        String line;
        while((line = br.readLine()) != null){
            String[] currentAccount = line.split("<>");
            String accNumber = currentAccount[0];
            String accHolder = currentAccount[1];
            String openDate = currentAccount[2];
            double balance = Double.parseDouble(currentAccount[3]);
            Account acc = new Account(accNumber, accHolder, openDate, balance);
            accounts.add(acc);
        }
        br.close();
    }
        catch (Exception e) {
            System.out.println(e);  // in case filename doesn't exist or have access, try/catch
        }
        return accounts;
    }
    
    public static void writeFile(ArrayList<Account> accounts, String fileName) {
      
            try{
                FileWriter fw = new FileWriter(fileName);
                BufferedWriter bw = new BufferedWriter(fw);
                for (Account a : accounts) {
                    bw.write(a.toString() + "<>" + a.getAccountHolder() + "<>" + a.getOpenDate() + "<>" + String.valueOf(a.getAccountBalance()) + "\n");
                }
                bw.close(); // must close or will keep processing
            }
            catch (Exception e) {
                System.out.println(e);
            }
        
    }
}
