package Week_3_Linear_Structures.exes;


public class P5_ArrayStack<T> {
  private int size;
  private static int MAX_SIZE = 100;
  private T[] items;

  public P5_ArrayStack() {
    size = 0;
    items = (T[])new Object[MAX_SIZE];
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean push(T item) {
    // make sure the stack still have empty slot
    if (size < MAX_SIZE) {
      items[size] = item;
      size++;
      return true;
    }
    return false;
  }

  public boolean pop() {
    // make sure the stack is not empty
    if (isEmpty()) {
      return false;
    }
    size--;
    return true;
  }

  public T peek() {
    // make sure the stack is not empty
    if (isEmpty()) {
      return null;
    }
    return items[size - 1];
  }

  public static boolean checkBalanced(String str){
    P5_ArrayStack<Character> stack = new P5_ArrayStack<Character>();

    for(char c: str.toCharArray()){
      if (c == '[' || c == '{' || c == '('){
        stack.push(c);
      } else if (c == ']' || c == '}' || c == ')') {
          if (stack.isEmpty()){
            return false;
          }

          char top = stack.peek();
          if ((c == ']' && top != '[') ||
              (c == '}' && top != '{') ||
              (c == ')' && top != '(')){
                return false;
              }
          stack.pop();
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    String[] str = {"{{[[}}]]", "{[()]}", "{[()()]}", "((()))", "((())", "((())])", "((()))[]{}", "[]"};

    for(String s: str){
      System.out.println("Checking string: " + s);
      if (checkBalanced(s)){
        System.out.println("The string: " + s + " is balanced");
      } else {
        System.out.println("The string: " + s + " is not balanced");
      }
    }

  }
}