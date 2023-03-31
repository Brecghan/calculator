import java.util.Scanner;
import java.util.Set;

public class App {
    static final Scanner inputScanner = new Scanner(System.in);
    private static final Set<String> yesValues = Set.of("yes", "y");
    private static final Set<String> noValues = Set.of("no", "n");
    private static final Set<String> addValues = Set.of("add", "+", "addition", "a");
    private static final Set<String> subValues = Set.of("subtract", "sub", "subtraction", "s");
    private static final Set<String> multValues = Set.of("multiply", "*", "x", "multiplication", "m");
    private static final Set<String> diviValues = Set.of("divide", "/", "division", "d");

    public static void main(String[] args) {
        boolean checkCont = true;
        Boolean reUse = false;
        Double totalAns = 0.0;
        
        while (checkCont) {
            Double num1 = 0.0;
            Double num2 = 0.0;
            String oper = "";
            if (reUse == false) {
                String thisFun = getInput("Enter your equation in this format - Number*SPACE*Operation*SPACE*Number");
                num1 = inputScanner.nextDouble();
                oper = inputScanner.next();
                num2 = inputScanner.nextDouble();
            } else {
                oper = getString("Which operation would you like to use?");
                num2 = getDouble("With what number?");
                num1 = totalAns;
            }
            System.out.println("Num 1 is " + num1);
            System.out.println("Oper is " + oper);
            System.out.println("Num 2 is " + num2);
            Calculator ans = new Calculator();
            double addAns = ans.add(num1, num2);
            double subAns = ans.subtract(num1, num2);
            double multAns = ans.multiply(num1, num2);
            double diviAns = ans.divide(num1, num2);
            if (addValues.contains(oper)){
                System.out.println(String.format("%f plus %f equals %f", num1, num2, addAns));
                totalAns = addAns;
            }
            if (subValues.contains(oper)) {
                System.out.println(String.format("%f minus %f equals %f", num1, num2, subAns));
                totalAns = subAns;
            }
            if (multValues.contains(oper)) {
                System.out.println(String.format("%f times %f equals %f", num1, num2, multAns));
                totalAns = multAns;
            }
            if (diviValues.contains(oper)) {
                if (Double.isInfinite(diviAns)) {
                    System.out.println("ONLY GOD CAN DIVIDE BY ZERO!! HEATHEN!!!");
                    break;
                } else {
                    System.out.println(String.format("%f divide by %f equals %f", num1, num2, diviAns));
                    totalAns = diviAns;
                }
            }
            String cont = getString("Do you want to Continue Yes or No?");
            if (noValues.contains(cont.toLowerCase())) {
                System.out.println("Goodbye");
                break;
            }
            String reMath = getString("Do you want use this answer in the next equation?");
            if (yesValues.contains(reMath.toLowerCase())) {
                reUse = true;
            } else {
                reUse = false;
            }
        }
    }

    private static String getString(String prompt) {
        System.out.println(prompt);
        return inputScanner.next();
    }

    private static double getDouble(String prompt) {
        System.out.println(prompt);
        return inputScanner.nextDouble();
    }

    private static String getInput(String prompt) {
        System.out.println(prompt);
        String ans = "";
        return ans;
    }
}