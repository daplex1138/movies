package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="movie")
public class Movie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	private String year;
	private String rating;
	private String genre;
	private int duration;
	@ManyToOne
	@JoinColumn (name = "director_id")
	private Director director;
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(String title, String year, String rating, String genre, int duration, Director director) {
		super();
		this.title = title;
		this.year = year;
		this.rating = rating;
		this.genre = genre;
		this.duration = duration;
		this.director = director;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirectorId(Director director) {
		this.director = director;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", rating=" + rating + ", genre=" + genre
				+ ", duration=" + duration + ", directorId=" + director + "]";
	}
}
