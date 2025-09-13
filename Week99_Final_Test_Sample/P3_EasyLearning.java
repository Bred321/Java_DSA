package Week99_Final_Test_Sample;

public class P3_EasyLearning {
    int[][] switchingCost;
    public static void main(String[] args){
        int[][] testArr = {
                            {0, 1, 5},
                            {4, 0, 3},
                            {2, 1, 9}
                        };
        P3_EasyLearning easyLearning = new P3_EasyLearning(testArr);    
        System.out.println(easyLearning.compare(new int[] {0, 2}, new int[] {0, 1, 2}));
    }

    public P3_EasyLearning(int[][] arr) {
        switchingCost = arr;
    }

    public int compare(int[] seq1, int[] seq2){
        int cost1 = 0;
        int cost2 = 0;

        if(seq1.length < 2 && seq2.length > 2){
            // The swithching cost of seq2 is higher
            return -1;
        } else if (seq1.length > 2 && seq2.length < 2){
            // The swithching cost of seq1 is higher
            return 1;
        } else if (seq1.length < 2 && seq2.length < 2){
            return 0;
        }

        // Compute the cost for seq1
        for(int i = 0; i < seq1.length - 1; i++){
            cost1 += switchingCost[seq1[i]][seq1[i+1]];
        }

        // Compute the cost for seq2
        for(int i = 0; i < seq2.length - 1; i++){
            cost2 += switchingCost[seq2[i]][seq2[i+1]];
        }

        if (cost1 > cost2){
            return 1;
        } else if (cost1 < cost2){
            return -1;
        } else {
            return 0;
        }
    }
}
