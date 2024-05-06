package be.intecbrussel.demo.config;

import be.intecbrussel.demo.model.Student;
import be.intecbrussel.demo.repository.IStudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner  clr(IStudentRepository repository){

        return (args) -> {
            Student mariam = new Student(
                    "Mariam",
                    "mariam@gmail.com",
                    LocalDate.of(2024, 1, 1)
            );
            Student alex = new Student(
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2024, 1, 2)
            );
            Student jo = new Student(
                    "Jo",
                    "jo@gmail.com",
                    LocalDate.of(2024, 1, 3)
            );
            Student raf = new Student(
                    "raf",
                    "raf@gmail.com",
                    LocalDate.of(2024, 1, 4)
            );
            Student deepika = new Student(
                    "Deepika",
                    "deepika@gmail.com",
                    LocalDate.of(2024, 1, 5)
            );
            Student janan = new Student(
                    "Janan",
                    "janan@gmail.com",
                    LocalDate.of(2024, 1, 6)
            );
            Student abdul = new Student(
                    "Abdul",
                    "abdul@gmail.com",
                    LocalDate.of(2024, 1, 7)
            );
            Student rugter = new Student(
                    "Rugter",
                    "rugter@gmail.com",
                    LocalDate.of(2024, 1, 8)
            );
            Student nina = new Student(
                    "Nina",
                    "nina@gmail.com",
                    LocalDate.of(2024, 1, 9)
            );
            Student mausam = new Student(
                    "Mausam",
                    "mausam@gmail.com",
                    LocalDate.of(2024, 1, 10)
            );
            repository.saveAll(List.of(mariam, alex, jo, raf, deepika, mausam, nina, rugter, janan, abdul));
        };
    }
}
