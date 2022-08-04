package com.company;

import com.company.dao.repository.UserRepository;
import com.company.entity.Country;
import com.company.entity.EmploymentHistory;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootApplication
@EnableCaching
public class ResumeDpAppJpaSpringApplication {
    /*
    @Autowired
    @Qualifier("userRepositoryCustom")
    UserRepositoryCustom userDao;

    @Autowired
    CountryDaoInter countryDao;

    @Autowired
    EmploymentHistoryDaoInter employmentHistoryDao;

    @Autowired
    UserSkillDaoInter userSkillDao;

    @Autowired
    UserServiceInter userService;

    @Autowired
    UserRepository userRepository;


    @Autowired
    @Qualifier("obj")
    Object object;



    @Autowired
    UserRepository userRepo;
*/
    public static void main(String[] args) {
        SpringApplication.run(ResumeDpAppJpaSpringApplication.class, args);
    }

/*
    @Bean
    public CommandLineRunner run() {
        CommandLineRunner clr = new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                List<User> u = userRepo.getAll();
                System.out.println(u.get(0).getUserSkillList().get(0).getSkill().getName());
            }

        };
        return clr;
    }

    /*
    @Bean
    public CommandLineRunner run() {
        CommandLineRunner clr = new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                userRepository.getAll();

                List<User> list = userRepository.findAll();
                System.out.println(list);
                list = userRepository.findAll(Sort.by(Sort.Order.desc("id")));
                System.out.println(list);
                User u = userRepository.findByNameOrSurname("Cemil", "Khitlov");
                System.out.println(u);
                u = userRepository.findByEmail("cmil.camalov@mail.ru");
                System.out.println(u);

                list = userRepository.getAll();
                System.out.println(list);

                List<User> list = userRepository.findAll();
                System.out.println(list);
                list = userRepository.findAll(Sort.by(Sort.Order.desc("id")));
                System.out.println(list);

                List<Country> countries = countryDao.getAll();
                List<EmploymentHistory> employmentHistoryList = employmentHistoryDao.getAllEmploymentHistoryByUserId(1);
                EmploymentHistory eh = new EmploymentHistory();
                eh.setId(3);
                eh.setHeader("Camalov");
                eh.setJobDescription("sadsadda");
                eh.setBeginDate(new java.util.Date(12231));
                eh.setEndDate(new java.util.Date(12231));
                eh.setUser(new User(1));

                System.out.println(employmentHistoryDao.remove(16));
                System.out.println(employmentHistoryList);

            }

            }

        };
        return clr;
    }
 */

}
