import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        String [] even = splitString("ABCD");
//        System.out.println(even.toString());
//        for (int i = 0; i < even.length; i++) {
//            System.out.println("Even = " + even[i]);
//        }

        String [] odd = splitString("ABCDE");
        for (int i = 0; i < odd.length; i++) {
            System.out.println("Odd = " + odd[i]);
        }


    }

    private static String[] splitString(String s){

        StringBuilder sb = new StringBuilder();
        String[] result = new String[s.length()/2 + 1];

        if (s.length() % 2 == 0){
            for (int i = 0, j=0; i < s.length(); i+=2, j++) {
                sb.append(s.charAt(i)).append(s.charAt(i+1));
                result[j] = sb.toString();
                sb.delete(0,2);
            }

        }else {
            for (int i = 0, j=0; i < s.length(); i++, j++) {
                    sb.append(s.charAt(i));

                    if ( i == s.length()-1) {
                        sb.append('_');
                    }
                    else {
                        sb.append(s.charAt(i + 1));
                        i++;
                    }

                    result[j] = sb.toString();
                    sb.delete(0, 2);
            }
        }
        return result;
    }

}