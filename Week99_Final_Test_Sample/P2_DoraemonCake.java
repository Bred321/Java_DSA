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
        System.out.println(p2_DoraemonCake.weightByNumber(2));
    }

    private Topic[] topics;
    private double A;

    public P2_DoraemonCake(Topic[] topics, double A){
        this.topics = topics;
        this.A = A;
    }


    public double weightByNumber(int X){

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
  boolean[] bestSubset;
  int maxValue;
  int capacity;

  public Subset(Topic[] i, int c) {
    items = i;
    bestSubset = new boolean[i.length];
    capacity = c;
    maxValue = 0;
  }

  public void start() {
    subset(new boolean[items.length], 0);
  }

  void subset(boolean[] selected, int idx) {
    if (idx == items.length) {
      process(selected);
      return;
    }

    // Not selected
    selected[idx] = false;
    subset(selected, idx + 1);

    // Selected
    selected[idx] = true;
    subset(selected, idx + 1);
  }

  void process(boolean[] selected) {
    int w = 0, v = 0;
    for (int i = 0; i < selected.length; i++) {
      if (selected[i]) {
        w += items[i].W;
        v += items[i].S;
        if (w > capacity) {
          return;
        }
      }
    }
    if (v > maxValue) {
      maxValue = v;
      bestSubset = selected.clone();
    }
  }

  void displayBest() {
    StringBuilder res = new StringBuilder("Best subset:");
    int totalWeight = 0;
    for (int i = 0; i < bestSubset.length; i++) {
      if (bestSubset[i]) {
        totalWeight += items[i].S;
        res.append(String.format(" item(weight: %d, value: %d)", items[i].W, items[i].S));
      }
    }
    res.append(String.format(" with total weight %d and total value %d", totalWeight, maxValue));
    System.out.println(res);
  }

//   public static void main(String[] args) {
//     Topic[] items = new Topic[] {
//       new Topic(7, 42),
//       new Topic(3, 12),
//       new Topic(4, 40),
//       new Topic(5, 25)
//     };
//     Subset knapsack = new Subset(items, 7);
//     knapsack.start();
//     knapsack.displayBest();
//   }
}
