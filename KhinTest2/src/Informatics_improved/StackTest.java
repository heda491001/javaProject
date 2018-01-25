package Informatics_improved;
import static org.junit.Assert.*;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;
public class StackTest {
	@Test
	public void test_spe1() throws NoSuchFieldException, Exception, SecurityException, NoSuchMethodException{
		 Stack s=new Stack();
		 Class<?> parentClass = s.getClass().getSuperclass();
		 
		 //check the variable name in parent class 
		 Field f1=parentClass.getDeclaredField("content");
		 Field f2=parentClass.getDeclaredField("tail");
		 Field f3=parentClass.getDeclaredField("head");
		 
		 //check variable modifier in parent class
		 assertEquals(f1.getModifiers(),Modifier.PROTECTED);
		 assertEquals(f2.getModifiers(),Modifier.PROTECTED);
		 assertEquals(f3.getModifiers(),Modifier.PROTECTED);
		 
		 //check data type for each variable in parent class
	     assertEquals(f1.getType(),Object[].class);
	     assertEquals(f2.getType(),int.class);
	     assertEquals(f3.getType(),int.class);
		 
		 //check the number of variables in stack class 
		  Field[] fno=s.getClass().getDeclaredFields();
		  assertEquals(0,fno.length); 
		  
		//check the methods name in parent class 
		  Method m1=parentClass.getDeclaredMethod("empty",null);
		  Method m2=parentClass.getDeclaredMethod("pop",null);
		  Method m3=parentClass.getDeclaredMethod("push", Object.class);
		  
	      //check method modifier in parent class
		  assertEquals(m1.getModifiers(),Modifier.PUBLIC);
		  assertEquals(m2.getModifiers(),Modifier.PUBLIC);
		  assertEquals(m3.getModifiers(),Modifier.PUBLIC);

		  //check data type for each method in parent class
		  assertEquals(m1.getReturnType(),boolean.class);
		  assertEquals(m2.getReturnType(),Object.class);
		  assertEquals(m3.getReturnType(),void.class);

	     //check method in stack class like its name, modifier and return type
		  Method mstack1=s.getClass().getDeclaredMethod("pop", null);
		  assertEquals(mstack1.getModifiers(),Modifier.PUBLIC);
		  assertEquals(mstack1.getReturnType(),Object.class);
			
		//check the number of methods in stack class
		  Method[] mno=s.getClass().getDeclaredMethods();
		  
		  assertEquals(1,mno.length); 	  
	}

	@Test
	public void test2() throws IOException, NoSuchFieldException, SecurityException, IllegalAccessException {		
		Stack s = new Stack(); 
		//Declare Field in parent class
		Class<?> parentClass = s.getClass().getSuperclass();
	    Field f1= parentClass.getDeclaredField("content");
	    Field f2= parentClass.getDeclaredField("tail");
	    f1.setAccessible(true);
	    f2.setAccessible(true);
	    
	    //check behavior of push method
		s.push(50);
		s.push(60);
		s.push("e");
		s.push("f");
		
		//check the value of variables
		Object [] content=(Object[])f1.get(s);
		int tail=(int) f2.get(s);
		assertEquals(50, content[0]);
		assertEquals(60, content[1]);
		assertEquals("e", content[2]);
		assertEquals("f",content[3]);
		assertEquals(4,tail);
		
		//check the behaviors of pop and empty method
		if(!s.empty()){
			assertEquals("f", s.pop());
		    assertEquals("e", s.pop());
			assertEquals(60, s.pop());
		    assertEquals(50, s.pop());
		}
		
		//check the value of variables
		tail=(int) f2.get(s);
		assertEquals(0, tail);
	}
}
