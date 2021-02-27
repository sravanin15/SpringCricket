package com.mindtree.challenge2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.challenge2.entity.Player;
import com.mindtree.challenge2.entity.Team;
import com.mindtree.challenge2.exceptions.IdAlreadyPresentException;
import com.mindtree.challenge2.exceptions.PlayerIdNotFoundException;
import com.mindtree.challenge2.exceptions.ServiceException;
import com.mindtree.challenge2.exceptions.TeamIdNotFoundException;
import com.mindtree.challenge2.repositories.PlayerRepository;
import com.mindtree.challenge2.repositories.TeamRepository;
import com.mindtree.challenge2.service.ServiceInterface;
@Service
public class ServiceImpl implements ServiceInterface{
@Autowired
private TeamRepository teamRepo;
@Autowired
private PlayerRepository playerRepo;
	@Override
	public void addTeamDetails(Team team) throws ServiceException {
		// TODO Auto-generated method stub
		Team teamr =teamRepo.findById(team.getTeamId()).orElse(null);
		try {
			if(teamr!=null)
				throw new IdAlreadyPresentException("Team already present with given Id");
			else {
					teamRepo.save(team);}
		}catch(IdAlreadyPresentException e) {throw new ServiceException(e.getMessage());}
	}

	@Override
	public void addPlayerDetails(Player player, int teamId) throws TeamIdNotFoundException {
		// TODO Auto-generated method stub
		Team team=teamRepo.findById(teamId).orElse(null);
		if(team==null) {
			throw new TeamIdNotFoundException("No Id Found");
		}
		else
		{
			player.setTeam(team);
			playerRepo.save(player);
			team.getPlayersList().add(player);
			teamRepo.save(team);
			
		}
	}

	@Override
	public List<Player> getPlayersinTeam(String teamName) throws ServiceException {
		// TODO Auto-generated method stub
		List<Player> playersList;
		try {
		Team team=teamRepo.getTeamByTeamName(teamName);
		 playersList=team.getPlayersList();
		}catch(Exception e) {throw new ServiceException("No team With the name");}
		return playersList;
	}

	@Override
	public Team updateLocation(int id, String location) throws TeamIdNotFoundException {
		// TODO Auto-generated method stub
		Team team=teamRepo.findById(id).orElse(null);
		try {
			team.setLocation(location);
			teamRepo.save(team);
		}catch(Exception e) {throw new TeamIdNotFoundException("No Id Found");}
		return team;
	}

	@Override
	public void deleteMind(int playerId) throws PlayerIdNotFoundException {
		// TODO Auto-generated method stub
		Player player=playerRepo.findById(playerId).orElse(null);
		try {
			playerRepo.delete(player);
		}catch(Exception e) {throw new PlayerIdNotFoundException("No Id Found");}
	}
	

}
