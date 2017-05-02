package model;

import java.util.Stack;

import spring.controllers.CreateRem;

public class FinalDelete implements Command{
	Stack<CreateRem> userCommands;
	public FinalDelete()
	{
		userCommands=new Stack<CreateRem>();
	}
public void performDelete(CreateRem reminder){
	System.out.println("pushed reminder to stack from class");
	userCommands.push(reminder);
	System.out.println(reminder.getID());
	System.out.println(userCommands.size());
}

public CreateRem undo() {
	System.out.println("called pop from class");
	System.out.println(userCommands.size());
	CreateRem rem = userCommands.peek();
	System.out.println(rem.getID());
	return (CreateRem)userCommands.pop();
	
}
}
