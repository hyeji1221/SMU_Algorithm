import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();
        char[] arr = (br.readLine() + "\n").toCharArray();
        boolean istag = false;
        
        for(int i = 0; i < arr.length; ++i){
            char c = arr[i];
            if(c == '<') istag = true;

            if(istag || c == ' ' || c == '\n'){
                while(!stack.isEmpty()){
                     wr.write(stack.pop());
                }
                if(c != '\n') wr.write(c);
            } else {
               stack.push(c);
            }
            if(c == '>') istag = false;
        }
        wr.flush();
    }
}
