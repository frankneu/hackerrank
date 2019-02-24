package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;

public class FindNumber {

    // Complete the findNumber function below.
    static String findNumber(List<Integer> arr, int k) {
        for(Integer i : arr){
            if (i.intValue() == k){
                return "YES";
            }
        }
        return "NO";
    }

}
