package spring.controllers;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class CreateRem {
	private String Owner;
	private String Name;
	private String Title;
	private String Category;
	private String Frequency;
	private String NotifMode;
	private String  StartTime;
	private String EndTime;
	private int RewardPoints;
	@Autowired
	public CreateRem(String owner, String name, String title, String category, String frequency, String notifMode, String startTime,
			String endTime, int rewardPoints) {
		super();
		Owner=owner;
		Name = name;
		Title = title;
		Category = category;
		Frequency = frequency;
		NotifMode = notifMode;
		StartTime = startTime;
		EndTime = endTime;
		RewardPoints = rewardPoints;
	}
	public CreateRem(){
		
	}
	public String getOwner() {
		return Owner;
	}
	public void setOwner(String owner) {
		Owner = owner;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getFrequency() {
		return Frequency;
	}
	public void setFrequency(String frequency) {
		Frequency = frequency;
	}
	public String getNotifMode() {
		return NotifMode;
	}
	public void setNotifMode(String notifMode) {
		NotifMode = notifMode;
	}
	public String getStartTime() {
		return StartTime;
	}
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}
	public String getEndTime() {
		return EndTime;
	}
	public void setEndTime(String endTime) {
		EndTime = endTime;
	}
	public int getRewardPoints() {
		return RewardPoints;
	}
	public void setRewardPoints(int rewardPoints) {
		RewardPoints = rewardPoints;
	}
	
}
