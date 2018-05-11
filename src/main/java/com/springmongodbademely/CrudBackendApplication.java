package com.springmongodbademely;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springmongodbademely.model.User;
import com.springmongodbademely.repository.UserRepository;

@Component
public class CrudBackendApplication implements CommandLineRunner {
	private UserRepository userRepository;

    public CrudBackendApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	@Override
	public void run(String... args) throws Exception {
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
