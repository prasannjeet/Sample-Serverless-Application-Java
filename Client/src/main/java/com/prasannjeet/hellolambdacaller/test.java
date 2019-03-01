/*
 * Copyright (c) 2019. Prasannjeet Singh. Master's Student, Linnaeus University
 */

package com.prasannjeet.hellolambdacaller;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

import static com.sun.javafx.fxml.expression.Expression.divide;

public class test {
    // Complete the count_coins function below.
    static List<Integer> count_coins(List<Integer> coinDenominations, int monetaryValue) {
        Collections.sort(coinDenominations);
        Collections.reverse(coinDenominations);

        List<Integer> returnItem = new ArrayList<>();
        int totalCount = 0;

        for (Integer i: coinDenominations) {
            while (true) {
                totalCount = totalCount + i;
                if (totalCount > monetaryValue) {
                    totalCount = totalCount - i;
                    break;
                }
                returnItem.add(i);
            }
        }

        if (totalCount == monetaryValue) {
            return returnItem;
        }
        else {
            returnItem = new ArrayList<Integer>();
            returnItem.add(0);
            return returnItem;
        }

    }


    public static void main(String [] args) {
//        divide(4,0);
//        List<Integer> okay = new ArrayList<>();
//        okay.add(5);
//        okay.add(9);
//        okay.add(1);
//        Collections.sort(okay);
//        Collections.reverse(okay);
//        System.out.println(okay);

        ArrayList<Integer> one = new ArrayList<>();
        one.add(20); one.add(10); one.add(5); one.add(4);

        System.out.println(count_coins(one, -1));
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int coinDenominationsCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<String> coinDenominationsTemp = new ArrayList<>();
//
//        IntStream.range(0, coinDenominationsCount).forEach(i -> {
//            try {
//                coinDenominationsTemp.add(bufferedReader.readLine().replaceAll("\\s+$", ""));
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        List<Integer> coinDenominations = coinDenominationsTemp.stream()
//                .map(String::trim)
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        int monetaryValue = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> res = count_coins(coinDenominations, monetaryValue);
//
//        bufferedWriter.write(
//                res.stream()
//                        .map(Object::toString)
//                        .collect(joining("\n"))
//                        + "\n"
//        );
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
}
