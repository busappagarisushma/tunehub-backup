package com.kodnest.tunehub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.Playlist;
import com.kodnest.tunehub.repository.PlaylistRepisotry;
import com.kodnest.tunehub.service.PlaylistService;

@Service
public class PlaylistServiceImpl  implements PlaylistService{
	@Autowired
	PlaylistRepisotry playlistRepisotry;

	@Override
	public void addplaylist(Playlist playlist) {
		playlistRepisotry.save(playlist);
	}

	@Override
	public List<Playlist> fetchAllPlaylists() {
		List<Playlist> allPlaylists = playlistRepisotry.findAll();
		return allPlaylists;
	}
}
