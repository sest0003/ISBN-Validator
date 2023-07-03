package com.example.Programmeringsuppgift;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service

public class IsbnService {

/*  long isbn = 1234567894L;*/

    public String validateIsbn(long isbn) {

        int numSize = String.valueOf(isbn).length();

        String answer = null;

        //ISBN 10
        if (numSize == 10) {
            answer = "";

            int[] numArray = new int[numSize];

            // From long to array
            long temp = isbn;
            for (int i = numSize - 1; i >= 0; i--) {

                int num = (int) (temp % 10);
                numArray[i] = num;

                temp /= 10;
            }

            // New Arraynumbers and sum
            int arrayPosition = 0;
            int newArrNum = 0;
            long sum = 0;

            for (int i = numArray.length; i >= 1; i--) {
                newArrNum = numArray[arrayPosition] * i;
                numArray[arrayPosition] = newArrNum;


                sum += newArrNum;

                arrayPosition++;

                System.out.println(sum);
            }

            // Div by 11
            if (sum % 11 == 0) {
                answer = "isbn number is valid!";
                System.out.println("isbn number is valid!");
            } else {
                System.out.println("isbn number is not valid");
                answer = "isbn number is not valid";
            }
        }


        //ISBN 13
        else if (numSize == 13) {




            int[] numArray = new int[numSize];

            // From long to array
            long temp = isbn;
            for (int i = numSize - 1; i >= 0; i--) {


                int num = (int) (temp % 10);
                numArray[i] = num;

                temp /= 10;
            }

            // New Arraynumbers and sum
            int arrayPosition = 0;
            int newArrNum = 0;
            long sum = 0;

            for (int i : numArray) {

                if (i % 2 == 0) {
                    newArrNum = numArray[arrayPosition] * 3;
                    numArray[arrayPosition] = newArrNum;
                    sum += newArrNum;
                    arrayPosition++;

                    System.out.println(sum);
                } else {
                    newArrNum = numArray[arrayPosition] * 1;
                    numArray[arrayPosition] = newArrNum;
                    sum += newArrNum;
                    arrayPosition++;
                }
            }

            // Div by 10
            if (sum % 10 == 0) {
                answer = "isbn number is valid!";
                System.out.println("isbn number is valid!");
            } else {
                System.out.println("isbn number is not valid");
                answer = "isbn number is not valid";
            }



            return answer;

        }

        // Not isbn10 or isbn13
        else{
            answer = "incorrect number of digits";
        }
        return answer;

    }
}



