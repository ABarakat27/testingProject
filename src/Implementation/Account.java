package Implementation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Account {

    ArrayList<BankStatement>statements=new ArrayList<BankStatement>();


    private BankStatement intiateAStatement(String operation,double amount){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        ArrayList<String>sb=new ArrayList<String>();
        sb.add(operation);
        sb.add(String.valueOf(amount));
        sb.add(dtf.format(now));
        BankStatement s=new BankStatement(sb);
        return  s ;
    }



}
