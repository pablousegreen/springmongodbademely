package com.springmongodbademely;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springmongodbademely.model.Address;
import com.springmongodbademely.model.Hotel;
import com.springmongodbademely.model.Review;
import com.springmongodbademely.model.User;
import com.springmongodbademely.repository.HotelRepository;
import com.springmongodbademely.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {
    private HotelRepository hotelRepository;
    private UserRepository userRepository;

    public DbSeeder(HotelRepository hotelRepository, UserRepository userRepository) {
        this.hotelRepository = hotelRepository;
        this.userRepository = userRepository;
    }
    @Override
    public void run(String... strings) throws Exception {
        Hotel marriot = new Hotel(
                "Marriot",
                130,
                new Address("Paris", "France"),
                Arrays.asList(
                        new Review("John", 8, false),
                        new Review("Mary", 7, true)
                )
        );

        Hotel ibis = new Hotel(
                "Ibis",
                90,
                new Address("Bucharest", "Romania"),
                Arrays.asList(
                        new Review("Teddy", 9, true)
                )
        );

        Hotel sofitel = new Hotel(
                "Sofitel",
                200,
                new Address("Rome", "Italy"),
                new ArrayList<>()
        );

        // drop all hotels
        this.hotelRepository.deleteAll();

        //add our hotels to the database
        List<Hotel> hotels = Arrays.asList(marriot, ibis, sofitel);
        this.hotelRepository.save(hotels);
    }
    
    public void generateUser(){
    	userRepository.save(new User("one", "one"));
		userRepository.save(new User("two", "one"));
		userRepository.save(new User("three", "one"));
		
		//////////////
		User marriot = new User(
                "Marriot",
                "130"
                /*new Address("Paris", "France"),
                Arrays.asList(
                        new Review("John", 8, false),
                        new Review("Mary", 7, true)
                )*/
        );

        User ibis = new User(
                "Ibis",
                "90"/*,
                new Address("Bucharest", "Romania"),
                Arrays.asList(
                        new Review("Teddy", 9, true)
                )*/
        );

        User sofitel = new User(
                "Sofitel",
                "200"/*,
                new Address("Rome", "Italy"),
                new ArrayList<>()*/
        );

        // drop all hotels
        this.userRepository.deleteAll();

        //add our hotels to the database
        List<User> users = Arrays.asList(marriot, ibis, sofitel);
        this.userRepository.save(users);
    }
}
