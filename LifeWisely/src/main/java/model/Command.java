package model;

import spring.controllers.CreateRem;

public interface Command {
public void performDelete(CreateRem reminder);
public CreateRem undo();
}
