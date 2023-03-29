import java.util.Scanner;
public class App {
    static final Scanner inputScanner = new Scanner(System.in);
   
    public static void main (String[] args) {
        boolean checkCont = true;
        while(checkCont){
        String thisFun = getString("Enter the numbers you wish to math seperated by a space");
        // double num1 = getDouble("Enter first number");
        // double num2 = getDouble("Enter second number");
        
        double num1 = 
        String whatDo = getString("Add, Subtract, Multiply, or Divide?");
        Calculator ans = new Calculator();
        double addAns = ans.add(num1,num2);
        double subAns = ans.subtract(num1,num2);
        double multAns = ans.multiply(num1,num2);
        double diviAns = ans.divide(num1,num2);
        if (whatDo.equals("Add")){
            System.out.println(String.format("%f plus %f equals %f",num1,num2,addAns));
        }
        if (whatDo.equals("Subtract")){
            System.out.println(String.format("%f minus %f equals %f",num1,num2,subAns));
        }
        if (whatDo.equals("Multiply")){
            System.out.println(String.format("%f times %f equals %f",num1,num2,multAns));
        }
        if (whatDo.equals("Divide")){
            if (Double.isInfinite(diviAns)){
                System.out.println("ONLY GOD CAN DIVIDE BY ZERO!! HEATHEN!!!");
                break;
            }
            else {
            System.out.println(String.format("%f divide by %f equals %f",num1,num2,diviAns));
            }
        }
        //System.out.println(String.format("You want to math with %f and %f - addition is %f, subtraction is %f, multiplication is %f, and division is %f", num1, num2, addAns, subAns, multAns, diviAns));
        String cont = getString("Do you want to Continue Yes or No?");
        if (!cont.equals("Yes")){
            System.out.println("Goodbye");
            break;}
        }
    }
    

    private static String getString(String prompt){
        System.out.println(prompt);
        return inputScanner.next();
    }
    private static double getDouble(String prompt){
        System.out.println(prompt);
        return inputScanner.nextDouble();
    }
}