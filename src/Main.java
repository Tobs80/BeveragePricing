import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BeveragePricing app = new BeveragePricing(1,0,0,0, 0);
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("Input Client ID, A qty., B qty., C qty., D qty., Separated by a space ");
            String input = scanner.nextLine();
            //Parse the input and convert the string[] to an int[]
            try
            {
                int[] arguments = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
                app.New_Order(arguments[0], arguments[1], arguments[2], arguments[3], arguments[4]);
                app.get_summary();
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input please make sure all values are integers and separated by a space");
            }
            finally {
                System.out.println("-------------------------------------------------------------");
                System.out.println("-------------------------------------------------------------");
            }

        }

    }

}

