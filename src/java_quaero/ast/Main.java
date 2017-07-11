package java_quaero.ast;

import java.io.*;

import java_cup.runtime.*;
import java_quaero.parser.*;

/** Implementación del lenguaje con la siguiente gramática:

```
lines : lines line ;
lines : line ;

line : nums \n ;

nums : nums , num ;
nums : num ;

num : [0-9]+ ;
```


 */
public class Main {

	public static void showTokens(String input) throws Exception {
		Lexer lexer = Parser.makeLexer(input);
		Symbol token = lexer.next_token();
		while (token.sym != Tokens.EOF) {
			System.out.println(token.sym +": "+ token.value);
			token = lexer.next_token();
		}
		System.out.println("FIN");
	}
	
	public static void showParse(String input) throws Exception {
		Parser parser = Parser.makeParser(input);
		Symbol result = parser.parse();
		System.out.println(result.sym +": "+ result.value);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder source = new StringBuilder();
		for (String line = stdIn.readLine(); line != null; line = stdIn.readLine()) {
			if (line.length() > 0) {
				source.append(line).append("\n");
			} else { // Empty line means input ends.
				//showTokens(source.toString());
				showParse(source.toString());
			}
		}
	}

}
