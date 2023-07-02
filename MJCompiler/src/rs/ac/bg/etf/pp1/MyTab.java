package rs.ac.bg.etf.pp1;

import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*; 

public class MyTab extends Tab {
	public static final Struct boolType = new Struct(Struct.Bool);
	
	public static void myInit() {
		init();
		currentScope.addToLocals(new Obj(Obj.Type, "bool", boolType));
	}

}
