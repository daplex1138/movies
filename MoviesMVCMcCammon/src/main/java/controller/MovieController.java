package controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.DirectorDAO;
import dao.MovieDAO;
import edu.dmacc.spring.springmvc.Car;
import model.Definitions;
import model.Director;
import model.Movie;

@Controller
public class MovieController {
	@Autowired DirectorDAO directorDao;
	@Autowired MovieDAO movieDao;
	
	@RequestMapping(value = "/newDirector")
	public ModelAndView newDirector() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addDirector");
		modelAndView.addObject("director", new Director());
		modelAndView.addObject("genders", Definitions.GENDERS);

		return modelAndView;
	}
	
	// Point the action of the add director form here.
	@RequestMapping(value = "/newDirectorResult")
	public ModelAndView processNewDirector(Director director) {
		ModelAndView modelAndView = new ModelAndView();
		directorDao.insert(director);
		modelAndView.setViewName("newDirectorResult");
		modelAndView.addObject("message", Definitions.SUCCESS_MESSAGE);

		return modelAndView;
	}
	.
	@RequestMapping(value = "/viewDirectors")
	public ModelAndView viewDirector(Director director) {
		ModelAndView modelAndView = new ModelAndView();
		List<Director> allDirectors = directorDao.getAll();
		modelAndView.setViewName("viewDirectors");
		modelAndView.addObject("allDirectors", allDirectors);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/newMovie")
	public ModelAndView newMovie(Movie movie) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addMovie");
		modelAndView.addObject("movie", new Movie());

		return modelAndView;
	}
	
	// Point the action of the new director form here.
	@RequestMapping(value = "/newDirectorResult")
	public ModelAndView processNewMovie(Movie movie) {
		ModelAndView modelAndView = new ModelAndView();
		movieDao.insert(movie);
		modelAndView.setViewName("newDirectorResult");
		modelAndView.addObject("message", Definitions.SUCCESS_MESSAGE);

		return modelAndView;
	}
	
	// Point the action of the add director form here.
	@RequestMapping(value = "/viewMovies")
	public ModelAndView viewMovies(Movie movie) {
		ModelAndView modelAndView = new ModelAndView();
		List<Movie> allMovies = movieDao.getAll();
		modelAndView.setViewName("viewAllMovies");
		modelAndView.addObject("allMovies", allMovies);
		
		return modelAndView;
	}
	
	@Bean
	public DirectorDAO directorDal() {
		DirectorDAO bean = new DirectorDAO();
		return bean;
	}
	
	@Bean
	public MovieDAO movieDao() {
		MovieDAO bean = new MovieDAO();
		return bean;
	}
}
