package com.mindtree.challenge2.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.challenge2.entity.Player;
import com.mindtree.challenge2.entity.Team;
import com.mindtree.challenge2.exceptions.PlayerIdNotFoundException;
import com.mindtree.challenge2.exceptions.ServiceException;
import com.mindtree.challenge2.exceptions.TeamIdNotFoundException;
import com.mindtree.challenge2.service.ServiceInterface;

@RestController
@RequestMapping("/TeamDetails")
public class SportsController {
	@Autowired
	private ServiceInterface ser;
	@PostMapping("/addTeam")
	public ResponseEntity<?> addTeam(@RequestBody Team team) {
		Map<String,Object> map=new LinkedHashMap<>();
		try {
			ser.addTeamDetails(team);
			map.put("message:","added successfully");
			return new ResponseEntity<>(map,HttpStatus.CREATED);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			map.put("message:","Failed");
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/addPlayer/{id}")
	public ResponseEntity<?> addPlayer(@RequestBody Player player,@PathVariable("id") int teamId) {
		Map<String,Object> map=new LinkedHashMap<>();
		try {
			ser.addPlayerDetails(player,teamId);
			map.put("message:","added successfully");
			return new ResponseEntity<>(map,HttpStatus.CREATED);
		} catch (TeamIdNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			map.put("message:","Failed");
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		}
		
	}
	@GetMapping("/getPlayersinTeam/{teamName}")
	public ResponseEntity<?> getMindsinTrack(@PathVariable("teamName") String teamName) {
		
	List<Player> playersList=new ArrayList<>();
		Map<String,Object> map=new LinkedHashMap<>();
		try {
			playersList=ser.getPlayersinTeam(teamName);
			map.put("message:",playersList);
			return new ResponseEntity<>(map,HttpStatus.CREATED);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			map.put("message:","Failed");
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);}
	}
	@PutMapping("/updateLocation/{id}/{location}")
	public ResponseEntity<?> updateLocation(@PathVariable("id") int id,@PathVariable("location") String location) 
	{
		
		Map<String,Object> map=new LinkedHashMap<>();
		try {
			
			map.put("message:",ser.updateLocation(id,location));
			return new ResponseEntity<>(map,HttpStatus.CREATED);
		} catch (TeamIdNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			map.put("message:","Failed");
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);}
	}
	@DeleteMapping("/delete/{playerId}")
	public ResponseEntity<?> deletePlayer(@PathVariable("playerId") int playerId) {
		
			
			Map<String,Object> map=new LinkedHashMap<>();
			try {
				ser.deleteMind(playerId);
				map.put("message:","Successfully deleted");
				return new ResponseEntity<>(map,HttpStatus.CREATED);
			} catch (PlayerIdNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				map.put("message:","Failed");
				return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);}
		
		
	}
}
