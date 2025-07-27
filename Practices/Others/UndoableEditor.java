package Practices.Others;

public class UndoableEditor {
    static class Action {
        String type;
        char value;

        public Action(String type, char value) {
            this.type = type;
            this.value = value;
        }
    }

    private int actionSize, textSize;
    private static int MAX_SIZE = 100;
    private Action[] actionStack;
    private char[] textStack;
    private char latestChar;
    static final String TYPE = "type";
    static final String DELETE = "delete";

    public UndoableEditor() {
        actionSize = textSize = 0;
        actionStack = new Action[MAX_SIZE];
        textStack = new char[MAX_SIZE];
    }

    private int size(){
        return textSize;
    }

    private boolean isTextEmpty(){
        return textSize == 0;
    }

    private boolean isActionEmpty(){
        return textSize == 0;
    }

    public void type(char c){
        if(textSize < MAX_SIZE){
            actionStack[actionSize] = new Action(TYPE, c);
            textStack[textSize] = c;
            textSize++;
            actionSize++;
            return;
        }
        return;
    }

    public void delete(){
        if(isTextEmpty()) return;
        actionStack[actionSize] = new Action(DELETE, ' ');
        latestChar = textStack[textSize - 1];
        textSize--;
        actionSize++;
        return;
    }

    public void undo(){
        if(isActionEmpty()) return;
        Action latestAction = actionStack[actionSize - 1];
        if(latestAction.type.equals(TYPE)){
            textSize--;
            actionSize--;
        } else if (latestAction.type.equals(DELETE)){
            textStack[textSize] = latestChar;
            textSize++;
            actionSize--;
        }
        return;
    }

    // Returns the current text
    public String getText(){
        String str = "";
        for(int i = 0; i < textSize; i++){
            str += textStack[i];
        }
        return str;
    }



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
}
