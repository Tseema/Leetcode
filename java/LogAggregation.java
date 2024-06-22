import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LogAggregation {

    public static void main(String [] args){
        String [] arr = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        reorderLogFiles(arr);

    }


    public static String[] reorderLogFiles(String[] logs) {
        //make 2 list one for letter and another for digit
        List<String> l=new ArrayList<>();
        List<String> d=new ArrayList<>();

        //check whether last character is digit or not and on basis of that divide in both list
        for(int i=0;i<logs.length;i++){
            if(logs[i].charAt(logs[i].length()-1)>='0'&&logs[i].charAt(logs[i].length()-1)<='9'){
                d.add(logs[i]);
            }else{
                l.add(logs[i]);
            }
        }

        //The letter-logs are sorted lexicographically by their contents.
        //If their contents are the same, then sort them lexicographically by their identifiers.
        //d list will remain same as per instructed in question.
        Collections.sort(l,(a,b)->{
         String s1=a.substring(a.indexOf(' ')+1);
         String s2=b.substring(b.indexOf(' ')+1);
         return s1.equals(s2)?a.compareTo(b):s1.compareTo(s2);
        });

        //make an array of size of original string array or sum of both list
        String[] ans=new String[l.size()+d.size()];
        int index=0;

        //add l list in ans array and increase index simantaneously
        for(int i=0;i<l.size();i++){
            ans[index]=l.get(i);
            index++;
        }

        //add d list in remaing array
        for(int i=0;i<d.size();i++){
            ans[index]=d.get(i);
            index++;
        }
        return ans;
    }

}
