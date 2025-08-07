package Week6_Brute_Force.SampleWorking;

public class Permutation {
  public static void main(String[] args) {
    int[] input = {1, 2, 3};
    int[] current = new int[input.length];  // default value is 0
    boolean[] taken = new boolean[input.length];  // default value is false
    permute(input, taken, current, 0);
  }

  static void permute(int[] input, boolean[] taken, int[] current, int idx) {
    if (idx == input.length) {
      process(current);
      return;
    }

    for (int i = 0; i < input.length; i++) {
      if (taken[i]) {
        continue;
      }
      current[idx] = input[i];
      taken[i] = true;
      permute(input, taken, current, idx + 1);
      taken[i] = false;
    }
  }

  static void process(int[] permutation) {
    for (int v : permutation) {
      System.out.print(v);
    }
    System.out.println();
  }
}