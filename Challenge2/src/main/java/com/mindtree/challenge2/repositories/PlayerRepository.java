package com.mindtree.challenge2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.challenge2.entity.Player;

public interface PlayerRepository extends JpaRepository<Player,Integer>{

}
