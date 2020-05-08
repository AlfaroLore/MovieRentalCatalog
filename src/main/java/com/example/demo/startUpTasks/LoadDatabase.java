package com.example.demo.startUpTasks;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.example.demo.Models.Actor;
import com.example.demo.Models.Member;
import com.example.demo.Models.Movie;
import com.example.demo.Models.MovieCatalog;
import com.example.demo.Models.MovieRate;
import com.example.demo.Models.MovieRental;
import com.example.demo.Models.Price;
import com.example.demo.Repositories.ActorRepository;
import com.example.demo.Repositories.MemberRepository;
import com.example.demo.Repositories.MovieCatalogRepository;
import com.example.demo.Repositories.MovieRentalRepository;
import com.example.demo.Repositories.MovieRepository;
import com.example.demo.Repositories.PriceRepository;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(MovieRepository movierepository, MemberRepository memberRepository,
            PriceRepository priceRepository, ActorRepository actorRepository,
            MovieCatalogRepository movieCatalogRepository, MovieRentalRepository movieRentalRepository) {
        return args -> {

            Actor actor = new Actor("Elijah Wood");
            Set<Actor> actors = new HashSet<Actor>() {
                {
                    add(actor);
                }
            };

            log.info("Preloading price" + actorRepository.save(actor));

            Movie movie1 = new Movie("Lord of the Rings, The Fellowship of the Ring", "2001",
                    "Frodo's adventure begins", MovieRate.PG13, actors);

            Movie movie2 = new Movie("Spirited Away", "2001", "Chihiro's Journey", MovieRate.PG13, actors);

            Member member1 = new Member("pepito@perez.com", "Pepito Perez", "591 79388257");

            Price price1 = new Price(15.5, Calendar.getInstance().getTime());

            log.info("Preloading movie" + movierepository.save(movie1));
            log.info("Preloading movie" + movierepository.save(movie2));
            log.info("Preloading member" + memberRepository.save(member1));
            log.info("Preloading price" + priceRepository.save(price1));

            /*
             * MovieCatalog movieCatalog = new MovieCatalog(movie1, price1, 2);
             * log.info("Preloading movie catalog" +
             * movieCatalogRepository.save(movieCatalog));
             * 
             * 
             * MovieRental movieRental = new MovieRental(member1, movieCatalog,
             * Calendar.getInstance().getTime(), "RENT"); log.info("Preloading movie rental"
             * + movieRentalRepository.save(movieRental));
             */

        };
    }
}
