package Week99_Final_Test_Sample;


public class P2_DoraemonCake{
    public static void main(String[] args){
        Topic[] topics = {
            new Topic(8.0, 7.0),
            new Topic(10.0, 8.0),
            new Topic(5.0, 3.0)
        };  
        double A = 10;
        P2_DoraemonCake p2_DoraemonCake = new P2_DoraemonCake(topics, A);
        
        // Find at most X topics
        System.out.println(p2_DoraemonCake.weightByNumber(1));
        System.out.println(p2_DoraemonCake.weightByNumber(2));
        System.out.println(p2_DoraemonCake.weightByNumber(3));
        System.out.println(p2_DoraemonCake.largestWeight());
    }

    private Topic[] topics;
    private double A;

    public P2_DoraemonCake(Topic[] topics, double A){
        this.topics = topics;
        this.A = A;
    }

    public double weightByNumber(int X){
      Subset subset = new Subset(topics, A, X, false);
      subset.start();
      return subset.returnBestWeight();
    }

    public double largestWeight(){
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

class Subset {
  Topic[] items;
  boolean[] bestAreaSubset;
  boolean[] bestWeightSubet;
  double maxArea;
  double maxWeight;
  double capacity;
  int k;
  boolean respectArea;

  public Subset(Topic[] i, double c, int k, boolean respectArea) {
    items = i;
    bestAreaSubset = bestWeightSubet = new boolean[i.length];
    capacity = c;
    maxArea = 0;
    this.k = k;
    this.respectArea = respectArea;
  }

  void start() {
    subset(new boolean[items.length], 0, 0);
  }

  void subset(boolean[] selected, int idx, int selectedCount) {
    if(selectedCount > k) return;
    if (idx == items.length) {
      if(selectedCount == k) process(selected);
      return;
    }

    // Not selected
    selected[idx] = false;
    subset(selected, idx + 1, selectedCount);

    // Selected
    selected[idx] = true;
    subset(selected, idx + 1, selectedCount + 1);
  }

  void process(boolean[] selected) {
    double w = 0, s = 0;
    for (int i = 0; i < selected.length; i++) {
      if (selected[i]) {
        w += items[i].W;
        s += items[i].S;
        if (respectArea && s > capacity) return;
      }
    }
    if (w > maxWeight) {
      maxWeight = w;
      bestWeightSubet = selected.clone();
    }
    if (s > maxArea) {
      maxArea = s;
      bestAreaSubset = selected.clone();
    }
  }

  void displayBest() {
    StringBuilder res = new StringBuilder("Best subset:");
    double totalWeight = 0;
    for (int i = 0; i < bestAreaSubset.length; i++) {
      if (bestAreaSubset[i]) {
        totalWeight += items[i].S;
        res.append(String.format(" item(weight: %lf, value: %f)", items[i].W, items[i].S));
      }
    }
    res.append(String.format(" with total weight %lf and total value %lf", totalWeight, maxArea));
    System.out.println(res);
  }

  double returnBestWeight(){
    return maxWeight;
  }

}
