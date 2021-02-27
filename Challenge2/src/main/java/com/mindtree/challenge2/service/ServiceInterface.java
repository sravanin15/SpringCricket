package com.mindtree.challenge2.service;

import java.util.List;

import com.mindtree.challenge2.entity.Player;
import com.mindtree.challenge2.entity.Team;
import com.mindtree.challenge2.exceptions.PlayerIdNotFoundException;
import com.mindtree.challenge2.exceptions.ServiceException;
import com.mindtree.challenge2.exceptions.TeamIdNotFoundException;

public interface ServiceInterface {

	void addTeamDetails(Team team) throws ServiceException;

	void addPlayerDetails(Player player, int teamId) throws TeamIdNotFoundException;

	List<Player> getPlayersinTeam(String teamName) throws ServiceException;

	Team updateLocation(int id, String location) throws TeamIdNotFoundException;

	void deleteMind(int playerId) throws PlayerIdNotFoundException;



}
