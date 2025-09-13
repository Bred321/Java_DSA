package Week99_Final_Test_Sample;

public class P2_DoraemonCake {
    public static void main(String[] args){
        Topic[] topics = {
            new Topic(8.0, 8.0),
            new Topic(10.0, 8.0),
            new Topic(5.0,3.0)
        };

        P2_DoraemonCake p2_DoraemonCake = new P2_DoraemonCake(topics);
        System.out.println(p2_DoraemonCake.weightByNumber(2));
    }   

    Topic[] topics;
    double A;
    public P2_DoraemonCake(Topic[] topics, double A) {
        this.topics = topics;
        this.A = A;
    }

    public double weightByNumber(double X){
        double[] weights = new double[topics.length];
        double total = 0;
        int n = weights.length;
        for(int i = 0; i < weights.length; i++){
            weights[i] = topics[i].W;
        }
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(weights);

        while(X > 0){
            total += weights[n - 1];
            n--;
            X--;
        }

        return total;

    }

    public double largestWeight(){
        Subset.subset();
        
        return 0;
    }
}

class Topic {
    double W;
    double S;

    public Topic(double W, double S){
        this.W = W;
        this.S = S;
    }
}

class MergeSort {
    public void mergeSort(double arr[]) {
    if (arr.length > 1) {
        int n = arr.length;
        int middle = n / 2;
        // create 2 sub-arrays from arr
        double[] sub1 = new double[middle];
        for (int i = 0; i < middle; i++) {
        sub1[i] = arr[i];
    }
    double[] sub2 = new double[n - middle];
    for (int i = middle; i < n; i++) {
        sub2[i - middle] = arr[i];
    }
    // sort first and second halves
    mergeSort(sub1);
    mergeSort(sub2);
    // merge sub1 and sub2 into the original array
    merge(sub1, sub2, arr);
    }
    }
    // merge two sub-arrays sub1 and sub2 into the array dest
    public void merge(double[] sub1, double[] sub2, double[] dest) {
        int p1 = 0, p2 = 0, pDest = 0; // pointers to 3 arrays
        while (p1 < sub1.length && p2 < sub2.length) {
            if (sub1[p1] <= sub2[p2]) {
                dest[pDest] = sub1[p1];
                p1++;
            } else {
                dest[pDest] = sub2[p2];
                p2++;
            }
            pDest++;
        }
        // copy remaining elements, if any
        while (p1 < sub1.length) {
            dest[pDest++] = sub1[p1++];
            }
            while (p2 < sub2.length) {
            dest[pDest++] = sub2[p2++];
            }
        }
}

class SubSet {
  static double bestW = 0;
  static boolean[] bestSet = {};

  static void subset(Topic[] input, boolean[] selected, int idx, double A) {
    if (idx == input.length) {
      process(input, selected, A);
      return;
    }

    // Not selected
    selected[idx] = false;
    subset(input, selected, idx + 1, A);

    // Selected
    selected[idx] = true;
    subset(input, selected, idx + 1, A);
  }

  static void process(Topic[] set, boolean[] selected, double A ) {
    double totalW = 0;
    double totalS = 0;
    for(int i = 0; i < set.length; i++){
        if(selected[i]){
            totalS += set[i].S;
            totalW += set[i].W;
            if(totalS > A) return;
        }
    }
    if(totalW > bestW){
        bestW = totalW;
        bestSet = selected.clone();
    }
  }
}