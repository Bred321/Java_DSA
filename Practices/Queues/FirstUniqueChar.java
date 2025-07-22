package Practices.Queues;

// Time Complexity: O(n^2)
public class FirstUniqueChar {
    public static void main(String[] args) {
        FirstUniqueChar firstUniqueChar = new FirstUniqueChar();
        String input = "loveleetcode";
        int result = firstUniqueChar.firstUniqChar(input);
        System.out.println("The index of the first unique character is: " + result);
    }

    public int firstUniqChar(String s) {
        int size = s.length();
        int[] freArr = new int[size];
        char[] str = s.toCharArray();
        int count = 0;
        int position = -1;

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(str[i] == str[j]){
                    count += 1;
                }
            }
            freArr[i] = count;
            count = 0;
        }

        for(int i = 0; i < size; i++){
            System.out.println("Character: " + str[i] + ", Frequency: " + freArr[i]);
            if(freArr[i] == 1){
                return i;
            }
        }

        return position;
    }
}
