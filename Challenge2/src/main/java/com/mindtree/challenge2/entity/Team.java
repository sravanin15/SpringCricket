package com.mindtree.challenge2.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Team {
@Id
private int teamId;
private String teamName;
private String location;
@OneToMany(mappedBy="team")
private List<Player> playersList;
public int getTeamId() {
	return teamId;
}
public void setTeamId(int teamId) {
	this.teamId = teamId;
}
public String getTeamName() {
	return teamName;
}
public void setTeamName(String teamName) {
	this.teamName = teamName;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public List<Player> getPlayersList() {
	return playersList;
}
public void setPlayersList(List<Player> playersList) {
	this.playersList = playersList;
}
public Team() {
	super();
}
public Team(int teamId, String teamName, String location) {
	super();
	this.teamId = teamId;
	this.teamName = teamName;
	this.location = location;
}

}
