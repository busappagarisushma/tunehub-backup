package com.kodnest.tunehub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.Song;
import com.kodnest.tunehub.repository.SongRepisotry;
import com.kodnest.tunehub.service.SongService;

@Service
public class SongServiceImpl implements SongService {

	@Autowired
	SongRepisotry songRepisotry;

	public  String  addSong(Song song) {
		songRepisotry.save(song);
		return "Song added Successfully";
	}

	@Override
	public boolean songExists(String name) {
		Song song=songRepisotry.findByName(name);
		if(song == null) {
			return false;
		}
		else {
			return  true;
		}

	}

	@Override
	public List<Song> fetchAllSongs() {
		List<Song>songs = songRepisotry.findAll();
		return songs;
	}

	@Override
	public void updateSong(Song s) {
		songRepisotry.save(s);
		
	}
}
