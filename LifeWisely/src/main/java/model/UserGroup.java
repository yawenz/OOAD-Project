package model;
import java.util.List;
import spring.controllers.CreateRem;

import org.springframework.beans.factory.annotation.Autowired;

public class UserGroup {
	private int id;
	private String GroupName;
	private String GroupDescription;
	private String GroupMember1;
	private CreateRem rem;
	public CreateRem getRem() {
		return rem;
	}
	public void setRem(CreateRem rem) {
		this.rem = rem;
	}
	@Autowired
	public UserGroup(String GroupName, String GroupDescription, String GroupMember1){
		this.GroupName=GroupName;
		this.GroupDescription=GroupDescription;
		this.GroupMember1=GroupMember1;
	}
	public UserGroup(){
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGroupName() {
		return GroupName;
	}
	public void setGroupName(String groupName) {
		GroupName = groupName;
	}
	public String getGroupDescription() {
		return GroupDescription;
	}
	public void setGroupDescription(String groupDescription) {
		GroupDescription = groupDescription;
	}
	public String getGroupMember1() {
		return GroupMember1;
	}
	public void setGroupMember1(String groupMember1) {
		GroupMember1 = groupMember1;
	}
	
	
	

}
