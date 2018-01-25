package Informatics_improved;

import java.io.ObjectStreamException;

public class Que1{
	private Object[] content=new Object[10];
	private int tail=0;
	private int head=0;
	public void push(Object i) { content[tail++]=i; }
	public boolean empty() { return (tail==head); }
	public Object pop() { return content[head++]; }
}


class Que{
	protected Object[] content=new Object[10];
	protected int tail=0;
	protected int head=0;
	public void push(Object i) { content[tail++]=i; }
	public boolean empty() { return (tail==head); }
	public Object pop() { return content[head++]; }
}