import java.util.Scanner;

public class Calculator {
    /*список доступных операций
     EeQqSs - выход из программ   ы s w
     Сс - сброс результата
    */
    static final String MATH_OPERATION = "+-*/=";
    static final String EXIT_OPERATION = "EeQqSs";
    static final String CLEAR_OPERATION = "Cc";
    static final String VALID_OPERATION = MATH_OPERATION+EXIT_OPERATION+CLEAR_OPERATION;
    //
    public static void main(String[] args) {
        /*
          возможные операции:
          +          -          /          *          =
          e || E - выход из программы
          с || C - Сброс результата
        */
        Scanner vScan = new Scanner(System.in);
        int vNum1 = 0, vNum2;
        boolean vIsNewCalc = true;
        char vOperation;
        do {
            if (vIsNewCalc) {
                vNum1 = readInt(vScan, "Input number1: ");
                vIsNewCalc = false;
            }
            //считывание операции с проверкой значения
            vOperation = readOperation(vScan);
            //выход из приложения
            if (EXIT_OPERATION.contains(vOperation + "")) {
                continue;
                //закрыть приложение
            } else if (CLEAR_OPERATION.contains(vOperation + "")) {
                vNum1 = 0;
                vIsNewCalc = true;
            }
            //произвести вычисление
            if (MATH_OPERATION.contains(vOperation + "")) {
                if (vOperation != '=') {
                    vNum2 = readInt(vScan, "Input number2: ");
                    switch (vOperation) {
                        case '+' -> vNum1 += vNum2;
                        case '-' -> vNum1 -= vNum2;
                        case '*' -> vNum1 *= vNum2;
                        case '/' -> {
                            if (vNum2 == 0) {
                                System.out.println("Can't / 0");
                                continue;
                            }
                            vNum1 /= vNum2;
                        }
                        default -> System.out.println("Unknown operation! " + vOperation);
                    }
                }
            }
            System.out.println("Result: " + vNum1);
        } while (!EXIT_OPERATION.contains(vOperation + ""));
    }
    //считать операцию
    private static char readOperation(Scanner pScanner) {
        char vOperation;
        do {
            System.out.println("Input operation: ");
            vOperation = pScanner.next().charAt(0);
            if (!VALID_OPERATION.contains(vOperation + "")) {
                System.out.println("Unknown operation! " + vOperation);
            }
        }while (!VALID_OPERATION.contains(vOperation+""));
        return vOperation;
    }
    //считать число
    private static int readInt(Scanner pScanner, String pLabel) {
        System.out.println(pLabel);
        while(!pScanner.hasNextInt()) {
            pScanner.next();
        }
        return pScanner.nextInt();
    }
}
