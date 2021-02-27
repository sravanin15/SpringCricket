package com.mindtree.challenge2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.challenge2.entity.Team;

public interface TeamRepository extends JpaRepository<Team,Integer>{

	Team getTeamByTeamName(String teamName);

}
