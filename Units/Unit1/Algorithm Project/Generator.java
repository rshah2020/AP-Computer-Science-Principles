/*
	Java Implementation
	
	
	1. Write down the name of the website the password is for:
	Facebook
	
	2. Take the first 2 letters of the site name:
	Facebook -> Fa
	
	3. Take the last 2 letters of the site name:
	Facebook -> ok
	
	4. Reverse the two Strings and combine them:
	ok + Fa -> okFa

	5. Get the length of the site name (Facebook is 8 letters long) and append that number:
	okFa" + 8 -> okFa8
	
	6. add the shift symbol for the site name's length:
	shift + 8 -> '*'
   	
	Current password is: okFa8*

	In order to make it more secure:
	7. make the first letter of the current password uppercase (O) and append it
	we now have: okFa8*O
	
	8. add the remaining letters like before
	Your current password is: okFa8*OkFa
	
	9. Lastly, add the opposite of your initials
	John Smith -> SJ
	
	10. Add to password
	Your final password is: okFa8*OkFaSJ
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Generator
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the site name that this password is for:");
        String siteName = input.next();

        System.out.println("Please enter your initials backwards");
        String initials = input.next();

        System.out.print("Your password is: ");

        char first = Character.toUpperCase(siteName.charAt(0));
        char second = Character.toLowerCase(siteName.charAt(1));

        char last = Character.toLowerCase(siteName.charAt(siteName.length() - 1));
        char secondToLast = Character.toLowerCase(siteName.charAt(siteName.length() - 2));

        char upperSecondToLast = Character.toUpperCase(siteName.charAt(siteName.length() - 2));

        StringBuilder symbol = new StringBuilder();

        int x = siteName.trim().length();
        Integer[] digits = getDigits(x);

        int count = 0;

        while ( !(count == digits.length) )
        {
            if (digits[count] == 1)
            {
                symbol.append("!");
            }
            else if (digits[count] == 2)
            {
                symbol.append("@");
            }
            else if (digits[count] == 3)
            {
                symbol.append("#");
            }
            else if (digits[count] == 4)
            {
                symbol.append("$");
            }
            else if (digits[count] == 5)
            {
                symbol.append("%");
            }
            else if (digits[count] == 6)
            {
                symbol.append("^");
            }
            else if (digits[count] == 7)
            {
                symbol.append("&");
            }
            else if (digits[count] == 8)
            {
                symbol.append("*");
            }
            else if (digits[count] == 9)
            {
                symbol.append("(");
            }
            else if (digits[count] == 0)
            {
                symbol.append(")");
            }
            else
            {
                System.out.println("symbol error");
            }
            count++;
        }

        String partOne = "" + secondToLast + "" + last + "" + first + "" + second + "" + x + "" + symbol + "";
        String partTwo = "" + upperSecondToLast + "" + last + "" + first + "" + second + "" + initials + “”;

        System.out.print( partOne );
        System.out.print( partTwo );
        System.out.println();
    }

    // The below methods are for splitting the site name’s length if it is greater than 10
    private static Integer[] getDigits(int num)
    {
        List<Integer> digits = new ArrayList<>();
        collectDigits(num, digits);
        return digits.toArray(new Integer[]{});
    }

    private static void collectDigits(int num, List<Integer> digits)
    {
        if(num / 10 > 0) {
            collectDigits(num / 10, digits);
        }
        digits.add(num % 10);
    }
}
