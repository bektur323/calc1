package MyGym;
import java.util.*;


class myClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String input = scanner.nextLine();

        try {
            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String calc(String input) throws Exception {
        boolean isRome;
        String result = "";
        String[] parts = input.split("[+\\-*/]");
        int num1;
        int num2;
        if (parts.length != 2) {
            throw new Exception("Неверное количество элементов");
        }
        String operator = operFound(input);
        if (operator == null) {
            throw new  Exception("Неверный знак");
        }
            if (RomeNumber.isFound(parts[0]) && RomeNumber.isFound(parts[1])) {
                num1 = RomeNumber.convertArab(parts[0]);
                num2 = RomeNumber.convertArab(parts[1]);
                isRome = true;
                
                }

            else if (!RomeNumber.isFound(parts[0]) && !RomeNumber.isFound(parts[1])) {

                 num1 = Integer.parseInt(parts[0]);
                 num2 = Integer.parseInt(parts[1]);
                 isRome = false;

            } else {
                throw new Exception("Разные системы счисления");
            }
            if (num1 >= 10 || num2 >= 10){
                throw new Exception("Больше 10");
            }
            int arab = arabCalc(num1, num2, operator);
            if (isRome){
                if (arab <= 0){
                    throw new Exception("Римское число должно быть больше 0");
                }
                result = String.valueOf(arab);
            }else {
                result = String.valueOf(arab);
            }

            return result;


    }
    static String operFound(String el){
        if (el.contains("+")) {
            return "+";
        }
        else if (el.contains("-")) {
            return "-";
        }
        else if (el.contains("*")){
            return "*";
        }
        else if (el.contains("/")){
            return "/";
        }
        else return null;

    }

     static int arabCalc(int a, int b, String operator){
            if (operator.equals("+")) return a + b;
            else if (operator.equals("-")) return a - b;
            else if (operator.equals("*")) return a * b;
            else if (operator.equals("/")) {
                if (b != 0) {
                    return a / b;
                }
            }return 0;
    }

}
class RomeNumber{

    public static Map<Character, Integer> roma = new HashMap<Character,Integer>();


    public static boolean isFound(String list) {
        Map<String, Integer> roma = new HashMap<String, Integer>();

        roma.put("X", 10);
        roma.put("IX", 9);
        roma.put("VIII", 8);
        roma.put("VII", 7);
        roma.put("VI", 6);
        roma.put("V", 5);
        roma.put("IV", 4);
        roma.put("III", 3);
        roma.put("II", 2);
        roma.put("I", 1);


            return roma.containsKey(list);

    }

    public static int convertArab(String list){
        roma.put('I',1);
        roma.put('V',5);
        roma.put('X',10);
        roma.put('L',50);
        roma.put('C',100);

        int result = 0;
        int prevValue = 0;

        for (int i = list.length() - 1; i >= 0; i--) {
            int currentValue =  roma.get(list.charAt(i));
            if (currentValue >= prevValue) {
                result += currentValue;
            } else {
                result -= currentValue;
            }

            prevValue = currentValue;
        }

        return result;
    }
    public static String convertRome(int num){

        String result = "";


        return result;
    }

}

