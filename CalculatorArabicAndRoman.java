import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorArabicAndRoman {
    public static void main(String[] args) throws IOException {
        CalcRead calcread = new CalcRead();
        calcread.reads();
    }
}

class CalcRead {
    private int num1;
    private int num2;
    private int result;
    private char operator;
    private boolean trueOrFalse;

    public void reads() throws IOException {

        String[] roman={"X","IX","VIII","VII","VI","V","IV","III","II","I"};
        System.out.println("Введите выражение математическое из 2х чисел арабских или римских от 1 до 10, используя +, -, *, /!!!");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        String[] word = str.split("[/*+-]");
        for(int i=0; i<roman.length;i++) {
            if (roman[i].equals(word[0]) || roman[i].equals(word[1]))  {
                trueOrFalse=true;
            }
        }
        if(trueOrFalse){
            num1=romaToArabic(word[0]);
            num2=romaToArabic(word[1]);
        }else{
            num1=Integer.parseInt(word[0]);
            num2=Integer.parseInt(word[1]);
        }
        operator=str.charAt(word[0].length());
        if(num1<1||num1>10 && num2<1||num2>10){
            System.out.println("Введите правильные значения!!!");
        }
        else {
            calcValue();
            System.out.println(result);
        }
    }

    private static int romaToArabic(String roman){
        if(roman.equals("I")){
            return 1;
        }else if(roman.equals("II")){
            return 2;
        }else if(roman.equals("III")){
            return 3;
        }else if(roman.equals("IV")){
            return 4;
        }else if(roman.equals("V")){
            return 5;
        }else if(roman.equals("VI")){
            return 6;
        }else if(roman.equals("VII")){
            return 7;
        }else if(roman.equals("VIII")){
            return 8;
        }else if(roman.equals("IX")){
            return 9;
        }else if(roman.equals("X")){
            return 10;
        }
        else {
            return -1;
        }
    }

    public void calcValue(){
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result=num1-num2;
                break;
            case '*':
                result=num1*num2;
                break;
            case '/':
                result=num1/num2;
                break;
        }

        if (trueOrFalse){
            result=Math.min(3999, Math.max(1,result));
            String romanNumeral="";
            String[] rn={"I", "V", "X", "L", "C", "D", "M"};
            int i=0;
            while (result>0){
                switch (result%10){
                    case 1: romanNumeral=rn[i]+romanNumeral; break;
                    case 2: romanNumeral=rn[i]+rn[i]+romanNumeral;break;
                    case 3: romanNumeral=rn[i]+rn[i]+rn[i]+romanNumeral;break;
                    case 4:romanNumeral=rn[i]+rn[i+1]+romanNumeral;break;
                    case 5:romanNumeral=rn[i+1]+romanNumeral;break;
                    case 6:romanNumeral=rn[i+1]+rn[i]+romanNumeral; break;
                    case 7:romanNumeral=rn[i+1]+rn[i]+rn[i]+romanNumeral;break;
                    case 8:romanNumeral=rn[i+1]+rn[i]+rn[i]+rn[i]+romanNumeral;break;
                    case 9:romanNumeral=rn[i]+rn[i+2]+romanNumeral;break;
                }
                result=(int)result/10;
                i+=2;
            }
            System.out.println(romanNumeral);
            System.exit(0);
        }
    }
}
