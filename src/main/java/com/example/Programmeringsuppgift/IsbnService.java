package com.example.Programmeringsuppgift;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import scala.Char;

@Service

public class IsbnService {

    /*  long isbn = 1234567894L;*/

 /*   String isbn = "123456789X";*/

    public String validateIsbn(String isbn) {

        //Replace x with 10
        String newISBN = isbn.replace("X", "10");

        int numSize = newISBN.length();

        String answer = null;

        int sum = 0;

        //ISBN 10
        if (numSize == 10 || numSize == 11) {

            int count = 10;

            for (int i = 0; i < numSize; i++) {

                char c = newISBN.charAt(i);
                int num = Character.getNumericValue(c);

                sum += num * count;

                // IF X in isbn
                if (i == 9 && num == 1) {
                    sum += 9;
                }

                System.out.println(sum);
                count--;
            }


            // Div by 11
            if (sum % 11 == 0) {
                answer = "ISBN10 is valid";
                System.out.println("isbn10 number is valid!");
            } else {
                System.out.println("isbn10 number is not valid");
                answer = "ISBN10  is not valid";
            }
        }




        //ISBN 13
        else if (numSize == 13) {

            int count = 13;

            for (int i = 0; i < numSize; i++) {

                char c = newISBN.charAt(i);
                int num = Character.getNumericValue(c);

                //Even number?
                if (i % 2 == 0) {
                    sum += num * 3;
                    System.out.println(sum);
                } else {
                    sum += num * 1;
                    System.out.println(sum);
                }
                count--;
            }

            // Div by 10
            if (sum % 10 == 0) {
                answer = "ISBN13 is valid!";
                System.out.println("isbn13 number is valid!");
            } else {
                System.out.println("isbn13 number is not valid");
                answer = "ISBN13 is not valid";
            }

            return answer;
        }





        // Not isbn10 or isbn13
        else{
            answer = "the number of digits must be 10 or 13, please try again!";
        }



        return answer;
    }
}



