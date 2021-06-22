/* Code is refactored for a Reverse Polish Notation Calculator */

import java.util.Scanner;

class StackNode {
	
	
   public StackNode(double data, StackNode underneath) {
   this.data = data;
   this.underneath = underneath;
   }
   
   public StackNode underneath;
   public double data;
   
   }
   
class RPN {
	
   // Underscore in names and variables remove
   private void push(double NewData) {
   StackNode NewNode = new StackNode(NewData, top);
   top = NewNode;
   
   }

   public double pop() {
      double TopData = top.data;
      top = top.underneath;
      return TopData;
   }
      
public RPN(String command) {
   top = null;
   this.command = command;
   
   }
   
   // Method to get numbers of the popped 2 numbers
   public double get() {
      double a, b;
      int j;
      
      for(int i = 0; i < command.length( ); i++) {
         // if it's a digit
         if(Character.isDigit(command.charAt(i))) {
            double number;
         
            // get a string of the number
            String temp = "";
            for(j = 0; (j < 100) && (Character.isDigit(command.charAt(i)) || (command.charAt(i) == '.'));j++) {
               temp = temp + String.valueOf(command.charAt(i));
            
            }

            // Convert to double and add to the stack
            // The push method refer to the removal of the "items" from the stack.
            number = Double.parseDouble(temp);
            push(number);
            
       } else if(command.charAt(i) == '+') {
          b = pop( );
          a = pop( );
          push(a + b);
       } else if(command.charAt(i) == '-') {
          b = pop( );
          a = pop( );
          push(a - b);
       } else if(command.charAt(i) == '*') {
          b = pop( );
          a = pop( );
          push(a * b);
       } else if(command.charAt(i) == '/') {
          b = pop( );
          a = pop( );
          push(a / b);
       }
         else if(command.charAt(i) == '^') {
          b = pop( );
          a = pop( );
          push(Math.pow(a, b));
       } else if(command.charAt(i) != ' ') {
          throw new IllegalArgumentException( );
       }
     }
     
     // Value of numbers removed from stack
     double val = pop( );

     if(top != null) {
        throw new IllegalArgumentException( );
     }

        return val;
      }
      
	  public String command;
      public StackNode top;

   /* main method */
   public static void main(String args[]) {
      while(true) {
      Scanner in = new Scanner(System.in);
	  System.out.println("Enter RPN expression or \"quit\".");
      String line = in.nextLine( );
      if(line.equals("quit")) {
         break;
      } else {
         RPN calc = new RPN(line);
         System.out.printf("Answer is %F\n", calc.get());
         //double result = String.format("%4d", calc.get());
         //System.out.println(result);
      }
    
    } 
   
  } 

}