package com.wkcto.service;

import java.util.ArrayList;
import java.util.List;

import com.wkcto.beans.Movie;

public class MovieServiceImpl implements MovieService {

	@Override
	public List<Movie> getMovieList() {
		Movie m1  = new Movie();
		m1.setName("死侍2");
		m1.setActor("瑞安·雷诺兹");
		m1.setMinutes(119);
		
		Movie m2  = new Movie();
		m2.setName("湮灭");
		m2.setActor("娜塔莉·波特曼");
		m2.setMinutes(115);
		
		List<Movie> movies = new ArrayList<>();
		movies.add(m1);
		movies.add(m2);
		return movies;
	}

}
