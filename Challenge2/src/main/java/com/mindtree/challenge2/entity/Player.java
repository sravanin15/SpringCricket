package com.mindtree.challenge2.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Player {
@Id
private int playerId;
private String playerName;
private int age;
private String role;
@ManyToOne
@JsonIgnore
private Team team;
public int getPlayerId() {
	return playerId;
}
public void setPlayerId(int playerId) {
	this.playerId = playerId;
}
public String getPlayerName() {
	return playerName;
}
public void setPlayerName(String playerName) {
	this.playerName = playerName;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public Team getTeam() {
	return team;
}
public void setTeam(Team team) {
	this.team = team;
}
public Player() {
	super();
}
public Player(int playerId, String playerName, int age, String role) {
	super();
	this.playerId = playerId;
	this.playerName = playerName;
	this.age = age;
	this.role = role;
}

}
