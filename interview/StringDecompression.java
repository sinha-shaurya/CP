import java.util.*;

class StringDecompression {
    String multiply(String s,int k){
        System.out.println(k);
        String temp="";
        for(int i=0;i<k;i++){
            temp=temp+s;
        }
        return temp;
    }
    public String decodeAtIndex(String s, int k) {
        String decode="";
        int i=0;
        while(i<s.length()){
            String current="";
            while(i<s.length() && Character.isLetter(s.charAt(i))){
                current+=s.charAt(i);
                i+=1;
            }
            int num=0;
            while(i<s.length() && Character.isDigit(s.charAt(i))){
                num=num*10+Integer.parseInt(s.substring(i,i+1));
                i+=1;
            }
            String temp=multiply(current,num);
            decode+=temp;
            // System.out.println(temp);
        }
        System.out.println(decode);
        return decode.substring(k,k+1);
    }

    public static void main(String[] args) {
        String s="leet2code3";
        int k=10;
        System.out.println(new StringDecompression().decodeAtIndex(s, k));
    }
}