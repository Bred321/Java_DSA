package Week6_Brute_Force.Problems;

public class P4 {
    public static void main(String[] args){
        
    }
}

/*
 * Pseudo code for pruning
 * For idx from 0 to size -1:
 *  int val = arr[idx];
 *  For i from 0 to size - 1:
 *      if i != idx:
 *          if arr[i] == val or absolute(arr[i] - val) == absolute(idx - i):
 *              return "Invalid"
 * return "Valid"
 */