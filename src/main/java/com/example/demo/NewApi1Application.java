package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewApi1Application {

	public static void main(String[] args) {
		SpringApplication.run(NewApi1Application.class, args);
	}
//	@Bean
//    public CommandLineRunner specificationsDemo(EmployeeRepository employeeRepository) {
//        return args -> {
//
////             employeeRepository.saveAll(Arrays.asList(
////                    new Employee(201, "Drama1"),
////                    new Employee(202, "Drama2"),
////                    new Employee(203, "Drama3"),
////                    new Employee(204, "Drama4"),
////                    new Employee(205, "Drama5"),
////                    new Employee(206, "Drama6")
////            ));
////
////
////            EmployeeSpecification msGenre = new EmployeeSpecification();
////            msGenre.add(new SearchCriteria("id", 2, SearchOperation.EQUAL));
////            List<Employee> msGenreList = employeeRepository.findAll(msGenre);
////            msGenreList.forEach(System.out::println);
//
////            EmployeeSpecification es = new EmployeeSpecification();
////            es.add(new SearchCriteria("name", "Drama", SearchOperation.MATCH));
////            List<Employee> esGenreList = employeeRepository.findAll(es);
////            esGenreList.forEach(System.out::println);
//
////            // search movies by `title` and `rating` > 7
////            MovieSpecification msTitleRating = new MovieSpecification();
////            msTitleRating.add(new SearchCriteria("title", "black", SearchOperation.MATCH));
////            msTitleRating.add(new SearchCriteria("rating", 7, SearchOperation.GREATER_THAN));
////            List<Movie> msTitleRatingList = movieRepository.findAll(msTitleRating);
////            msTitleRatingList.forEach(System.out::println);
////
////            // search movies by release year < 2010 and rating > 8
////            MovieSpecification msYearRating = new MovieSpecification();
////            msYearRating.add(new SearchCriteria("releaseYear", 2010, SearchOperation.LESS_THAN));
////            msYearRating.add(new SearchCriteria("rating", 8, SearchOperation.GREATER_THAN));
////            List<Movie> msYearRatingList = movieRepository.findAll(msYearRating);
////            msYearRatingList.forEach(System.out::println);
////
////            // search movies by watch time >= 150 and sort by `title`
////            MovieSpecification msWatchTime = new MovieSpecification();
////            msWatchTime.add(new SearchCriteria("watchTime", 150, SearchOperation.GREATER_THAN_EQUAL));
////            List<Movie> msWatchTimeList = movieRepository.findAll(msWatchTime, Sort.by("title"));
////            msWatchTimeList.forEach(System.out::println);
////
////            // search movies by `title` <> 'white' and paginate results
////            MovieSpecification msTitle = new MovieSpecification();
////            msTitle.add(new SearchCriteria("title", "white", SearchOperation.NOT_EQUAL));
////
////            Pageable pageable = PageRequest.of(0, 3, Sort.by("releaseYear").descending());
////            Page<Movie> msTitleList = movieRepository.findAll(msTitle, pageable);
//
////            msTitleList.forEach(System.out::println);
////         // combine using `AND` operator
////            List<Movie> movies = movieRepository.findAll(Specification.where(msTitle).and(msYearRating));
////
////            // combine using `OR` operator
////            List<Movie> movies = movieRepository.findAll(Specification.where(msTitle).or(msYearRating));
//        };
//    }
}
