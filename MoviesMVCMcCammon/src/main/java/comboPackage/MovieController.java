package comboPackage;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
		changeToDirectorViewAll(modelAndView);


		return modelAndView;
	}
	
	@RequestMapping(value = "/viewDirectors")
	public ModelAndView viewDirector(Director director) {
		ModelAndView modelAndView = new ModelAndView();
		changeToDirectorViewAll(modelAndView);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/newMovie")
	public ModelAndView newMovie(Movie movie) {
		List<Director> directorList = directorDao.getAll();	
		Arrays.sort(Definitions.RATINGS);
		Arrays.sort(Definitions.GENRES);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addMovie");
		modelAndView.addObject("movie", new Movie());
		modelAndView.addObject("ratings", Definitions.RATINGS);
		modelAndView.addObject("genres", Definitions.GENRES);
		modelAndView.addObject("allDirectors", directorList);

		return modelAndView;
	}
	
	// Point the action of the new Movie form here.
	@RequestMapping(value = "/newMovieResult")
	public ModelAndView processNewMovie(Movie movie, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("director"));
		Director director = directorDao.searchForDirectorById(id);
		movie.setDirectorId(director);
		movieDao.insert(movie);
		changeToMovieViewAll(modelAndView);

		return modelAndView;
	}
	
	@RequestMapping(value = "/viewMovies")
	public ModelAndView viewMovies(Movie movie) {
		ModelAndView modelAndView = new ModelAndView();
		changeToMovieViewAll(modelAndView);
		
		return modelAndView;
	}
	
	@Bean
	public DirectorDAO directorDao() {
		DirectorDAO bean = new DirectorDAO();
		return bean;
	}
	
	@Bean
	public MovieDAO movieDao() {
		MovieDAO bean = new MovieDAO();
		return bean;
	}
	
	private void changeToMovieViewAll(ModelAndView modelAndView) {
		modelAndView.setViewName("viewAllMovies");
		List<Movie> allMovies = movieDao.getAll();
		modelAndView.addObject("allMovies", allMovies);
	}
	
	private void changeToDirectorViewAll(ModelAndView modelAndView) {
		modelAndView.setViewName("viewAllDirectors");
		List<Director> allDirectors = directorDao.getAll();
		modelAndView.addObject("allDirectors", allDirectors);
	}
}
