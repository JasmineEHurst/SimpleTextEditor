import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.text.StringCharacterIterator;

public class TextEditor {
    public static class basicStack{

    	public static void push(String s,LinkedList list){
    		list.add(s);
    	}
    	public static String pop(LinkedList list){
    		return (String) list.getFirst();
    	}
    	
    	public static void remove(LinkedList list){
    		list.remove(0);
    	}
    }
    public static void main(String[] args) {
        LinkedList stack = new LinkedList();
        int numOperations = 0;
        String buffer;
        String currentOperation = "";
        Scanner scan = new Scanner(System.in);
        String textArea = "";
        String previousTextArea = "";
        
        StringCharacterIterator textIterator = new StringCharacterIterator(textArea, 0);
        StringCharacterIterator operationIterator = new StringCharacterIterator(currentOperation);
        numOperations = scan.nextInt();
        buffer = scan.nextLine();
        
        do{
            currentOperation = scan.nextLine();
            operationIterator.setText(currentOperation);

            if(operationIterator.first() == '1'){

            	previousTextArea = textArea;
            	char[] append = new char[currentOperation.length()];
            	StringBuilder myStringBuilder = new StringBuilder(currentOperation);
            	myStringBuilder.getChars(2, operationIterator.getEndIndex(), append, 0);
            	textArea = append(textArea, new String(append));
            	basicStack.push(textArea, stack);
            	System.out.println(textArea); 
            }else if(operationIterator.first() == '2'){
            	previousTextArea = textArea;
            	char[] delete = new char[1];
            	StringBuilder myStringBuilder = new StringBuilder(currentOperation);
            	myStringBuilder.getChars(2, operationIterator.getEndIndex(), delete, 0);
            	String deletion = new String(delete);
            	textArea = delete(textArea, Integer.parseInt(deletion));
            	basicStack.push(textArea, stack);
            	System.out.println(textArea); 
            }else if(operationIterator.first() == '3'){
            	char[] print = new char[1];
            	StringBuilder myStringBuilder = new StringBuilder(currentOperation);
            	myStringBuilder.getChars(2, operationIterator.getEndIndex(), print, 0);
            	String printAt = new String(print);
            	System.out.println(textArea.charAt(Integer.parseInt(printAt)-1)); 
            }else{
            	textArea = basicStack.pop(stack);
//            	basicStack.remove(stack);
            	System.out.println(textArea);
            }
            numOperations--;
        }while(numOperations > 0);
    }
    
    public static String append(String textArea, String append){
        return textArea = textArea + append;
    }
    public static String delete(String textArea, int amount){
    	StringBuilder myStringBuilder = new StringBuilder(textArea);
    	myStringBuilder.delete(0, amount);
    	textArea = myStringBuilder.toString();
    	return textArea.trim();
    }
    
 
}


