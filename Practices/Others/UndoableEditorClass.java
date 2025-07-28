package Practices.Others;

public class UndoableEditorClass {
    public static void main(String[] args){
        UndoableEditor editor = new UndoableEditor();

        editor.type('H');
        editor.type('i');
        System.out.println(editor.getText()); // Hi

        editor.delete();
        System.out.println(editor.getText()); // H

        editor.undo();
        System.out.println(editor.getText()); // Hi

        editor.undo();
        System.out.println(editor.getText()); // H

        editor.undo();
        System.out.println(editor.getText()); // (empty)
    }

    static class Action {
        String type;
        char value;

        public Action(String type, char value) {
            this.type = type;
            this.value = value;
        }
    }

    private ArrayStack<Action> actionStack;
    private ArrayStack<Character> textStack;
    char latestCharacter;
   

    public UndoableEditorClass() {
        actionStack = new ArrayStack<Action>();
        textStack = new ArrayStack<Character>();

    }


    public void type(char c){
        actionStack.push(new Action("Type", c));
        textStack.push(c);
        return;
    }

    public void delete(){
        if(textStack.isEmpty()) return;
        actionStack.push(new Action("Delete", ' '));
        latestCharacter = textStack.peek();
        textStack.pop();
        return;
    }

    public void undo(){
        if(actionStack.isEmpty()) return;
        Action latestAction = actionStack.peek();
        if(latestAction.type.equals("Type")){
            textStack.pop();
            actionStack.pop();
        } else if (latestAction.type.equals("Delete")){
            textStack.push(latestCharacter);
            actionStack.pop();
        }
        return;
    }

    // Returns the current text
    public String getText(){
        String str = "";
        ArrayStack<Character> traverseStack = textStack;
        while(!traverseStack.isEmpty()){
            char letter = traverseStack.peek();
            str = letter + str;
            traverseStack.pop();
        }
        return str;
    }

    static class ArrayStack<T> {
        private int size;
        private static int MAX_SIZE = 100;
        private T[] items;

        public ArrayStack() {
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
    }
}
