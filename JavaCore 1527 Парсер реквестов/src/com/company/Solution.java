package com.company;

/*

1527. Level 15 Lection 12. Requests parser

Read the URL link from the console.
Display a list of all parameters through a space (Parameters go after? And are separated by &, for example, lvl = 15).
URL contains at least 1 parameter.
If the obj parameter is present, then pass its value to the desired alert method.
alert (double value) - for numbers (fractional numbers are separated by a dot)
alert (String value) - for strings
Please note that the alert method must be called AFTER the list of all parameters is displayed.
Example 1
Input:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Conclusion:
lvl view name
Example 2
Input:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Conclusion:
obj name
double 3.14

Requirements:
1. The program should read only one line from the keyboard.
2. The program should display data on the screen in accordance with the condition.
3. The program should call the alert method with the double parameter if the value of the obj parameter
can be correctly converted to a double.
4. The program must call the alert method with the String parameter if the value of the obj parameter
can NOT be correctly converted to a double.


 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;


public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            List<String> values = new LinkedList<>();
            for (String line : reader.readLine().split("\\?")[1].split("&")) {
                String[] splitParams = line.split("=");
                if (splitParams[0].equals("obj")) {
                    values.add(splitParams[1]);
                }
                System.out.print(splitParams[0] + " ");
            }
            System.out.println();

            for (String value : values) {
                try {
                    alert(Double.parseDouble(value));
                } catch (NumberFormatException e) {
                    alert(value);
                }
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}


