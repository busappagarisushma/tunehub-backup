package com.kodnest.tunehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodnest.tunehub.entity.Song;

public interface SongRepisotry extends JpaRepository<Song, Integer> {

	public	Song findByName(String name);

}
