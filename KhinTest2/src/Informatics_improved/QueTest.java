package Informatics_improved;
import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

//import java.io.IOException;
import org.junit.Test;
public class QueTest {
	
	@Test
	public void specTest1() throws NoSuchFieldException, SecurityException, NoSuchMethodException, Exception {
		   Que1 q = new Que1();
	       //check the variable name
		   Field f1=q.getClass().getDeclaredField("content");//variable 1
	       Field f2=q.getClass().getDeclaredField("tail");//variable 2
	       Field f3=q.getClass().getDeclaredField("head");//variable 3
	       
	       //check the modifier name
	       assertEquals(f1.getModifiers(),Modifier.PRIVATE);
	       assertEquals(f2.getModifiers(),Modifier.PRIVATE);
	       assertEquals(f3.getModifiers(),Modifier.PRIVATE);
	    
           //check data type for each variable
	       assertEquals(f1.getType(),Object[].class);
	       assertEquals(f2.getType(),int.class);
	       assertEquals(f3.getType(),int.class);
	       
	       //check the number of variables in que class. 
		   Field[] f=q.getClass().getDeclaredFields();
		   assertEquals(3, f.length);
		  
		    //check method name
		    Method m1 = q.getClass().getDeclaredMethod("empty", null);//method 1
	        Method m2 = q.getClass().getDeclaredMethod("pop", null);//method 2
	        Method m3=  q.getClass().getDeclaredMethod("push", Object.class);
	       	        
	        //check modifier name
		    assertEquals(m1.getModifiers(),Modifier.PUBLIC);
		    assertEquals(m2.getModifiers(),Modifier.PUBLIC);
	        assertEquals(m3.getModifiers(),Modifier.PUBLIC);
	       
		    //check data type for each Method
		    assertEquals(m1.getReturnType(),boolean.class);
		    assertEquals(m2.getReturnType(),Object.class);
		    assertEquals(m3.getReturnType(),void.class);
		    
		   //check the number of methods in que class. 
		   Method[] m=q.getClass().getDeclaredMethods();
		   assertEquals(3, m.length);
	}
	
	@Test
	//check the behaviors of method and variables
	public void test2() throws NoSuchFieldException, SecurityException, IllegalAccessException  {
		Que1 q= new Que1();
		//Declare Field
		Field f1=q.getClass().getDeclaredField("content");//variable 1
	    Field f2=q.getClass().getDeclaredField("tail");//variable 2
	    Field f3=q.getClass().getDeclaredField("head");//variable 3
	    f1.setAccessible(true);
		f2.setAccessible(true);
		f3.setAccessible(true);
		
		//check the behaviors of push method
		q.push(10); 
		q.push(20);
		q.push("a");
		
		//check the value of variables 
		Object[] content=(Object[])f1.get(q);
		int tail=(int) f2.get(q);
		assertEquals(10,content[0]);
		assertEquals(20,content[1]);
		assertEquals("a",content[2]);
		assertEquals(3, tail);//after push
		
		//check the behaviors of pop and empty method
		if(!q.empty()){
			  assertEquals(10,q.pop()); //
		      assertEquals(20,q.pop()); //
		      assertEquals("a",q.pop()); //
		}
		
		//check the value of variables
		int head=(int) f3.get(q);
	    assertEquals(3,head);//after pop
	}
}
