    package utils;

    import java.util.Scanner;

    public class Validation {

        private static final Scanner scanner = new Scanner(System.in);

        public static int getInt(String msginfo,int min, int max,String msgoutofrange, String msgtypeerror) {
            int num;
            while (true) {
                System.out.print(msginfo);
                try {
                    num = Integer.parseInt(scanner.nextLine());
                    if (num >= min && num <= max) {
                        return num;
                    }
                    System.out.println("Please enter a number between " + min + " and " + max);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Please try again.");
                }
            }
        }

        public static String getString(String msginfo,final String REGEX,String msgerror) {
            while (true) {
                System.out.print(msginfo);
                String input = scanner.nextLine();
                if(input.matches(REGEX)){
                    return input;
                }else{
                    System.out.println(msgerror);
                }
            }
        }     
    }
