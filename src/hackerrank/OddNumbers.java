package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
public class OddNumbers {
    // Complete the oddNumbers function below.
    static List<Integer> oddNumbers(int l, int r) {
        List<Integer> result = new LinkedList<Integer>();
        while(l<=r){
            if (l%2 == 0){
                l++;
            }else{
                result.add(l);
                l += 2;
            }
        }
        return result;
    }

}
