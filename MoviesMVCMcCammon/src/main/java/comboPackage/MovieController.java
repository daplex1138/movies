package comboPackage;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value = "/deleteDirectorResult")
	public ModelAndView deleteDirectorDirector(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("directorId"));
		Director result = directorDao.searchForDirectorById(id);
		directorDao.delete(result);
		changeToDirectorViewAll(modelAndView);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/updateDirector")
	public ModelAndView updateDirector(Director director, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		//String gender= request.getParameter("gender");
		//System.out.println(gender);
		directorDao.update(director);
		changeToDirectorViewAll(modelAndView);

		return modelAndView;
	}

	
	
/*
* ToDo Create new controller /updateDirector
*/	
	
	@RequestMapping(value = "/editDirectorResult")
	public ModelAndView editDirectorDirector(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("directorId"));
		Director result = directorDao.searchForDirectorById(id);
		modelAndView.setViewName("editDirector");
		modelAndView.addObject("director", new Director());
		modelAndView.addObject("id", result.getId());
		modelAndView.addObject("firstName", result.getFirstName());
		modelAndView.addObject("lastName", result.getLastName());
		modelAndView.addObject("address", result.getAddress());
		modelAndView.addObject("genders", Definitions.GENDERS);
			
		return modelAndView;
	}
		
	@RequestMapping(value = "/updateDirector", method = RequestMethod.POST)
	public ModelAndView updateDirector(@ModelAttribute("director") Director director) {
		ModelAndView modelAndView = new ModelAndView();
		//String gender= request.getParameter("gender");
		//System.out.println(gender);
		directorDao.update(director);
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
	
	@RequestMapping(value = "/deleteMovieResult")
	public ModelAndView deleteMovie(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("movieId"));
		Movie result = movieDao.searchForMovieById(id);
		movieDao.delete(result);
		changeToMovieViewAll(modelAndView);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/editMovieResult")
	public ModelAndView editMovie(HttpServletRequest request) {
		List<Director> directorList = directorDao.getAll();	
		ModelAndView modelAndView = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("movieId"));
		Movie result = movieDao.searchForMovieById(id);
		modelAndView.setViewName("editMovie");
		modelAndView.addObject("movie", new Movie());
		modelAndView.addObject("id", result.getId());
		modelAndView.addObject("title", result.getTitle());
		modelAndView.addObject("year", result.getYear());
		modelAndView.addObject("ratings", Definitions.RATINGS);
		modelAndView.addObject("genre", result.getGenre());
		modelAndView.addObject("genres", Definitions.GENRES);
		modelAndView.addObject("duration", result.getDuration());
		modelAndView.addObject("allDirectors", directorList);
					
		return modelAndView;
	}
	
	@RequestMapping(value = "/updateMovie")
	public ModelAndView updateMovie(Movie movie, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		String title = request.getParameter("title");
		
		System.out.println(title);
		
		int id = Integer.parseInt(request.getParameter("id"));
		Movie result = movieDao.searchForMovieById(id);
		movieDao.update(result);
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
		Collections.sort(allMovies, new Comparator<Movie>() {
		    public int compare(Movie a, Movie b) {
		        // For descending order: -1 = less than, 1 = greater than, 0 = equal,
		        return a.getId() > b.getId() ? -1 : (a.getId() < b.getId()) ? 1 : 0;
		    }
		});
		modelAndView.addObject("allMovies", allMovies);
	}
	
	private void changeToDirectorViewAll(ModelAndView modelAndView) {
		modelAndView.setViewName("viewAllDirectors");
		List<Director> allDirectors = directorDao.getAll();		
		Collections.sort(allDirectors, new Comparator<Director>() {
		    public int compare(Director a, Director b) {
		        // For descending order: -1 = less than, 1 = greater than, 0 = equal,
		        return a.getId() > b.getId() ? -1 : (a.getId() < b.getId()) ? 1 : 0;
		    }
		});
		modelAndView.addObject("allDirectors", allDirectors);
	}
}
