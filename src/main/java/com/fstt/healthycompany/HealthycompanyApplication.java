package com.fstt.healthycompany;

import com.fstt.healthycompany.Repositories.*;
import com.fstt.healthycompany.entities.*;
import org.apache.coyote.Response;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.stream.Stream;

@SpringBootApplication
public class HealthycompanyApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthycompanyApplication.class, args);
    }

    @Bean
    CommandLineRunner start(TestpsyRepository tp, QuestionRepository q, ReponseRepository r, EmployeeRepository emp, TestResponsesRepository tr){

        return args->{
            tp.deleteAll();
            Stream.of("t1 test1","t2 test2").forEach(t->{
                tp.save(new Testpsy(t.split(" ")[0],t.split(" ")[1],new ArrayList<>()));
            });

            tp.findAll().forEach(System.out::println);

            q.deleteAll();
            Testpsy t1=tp.findById("t1").get();
            Stream.of("t1q1 question1","t1q2 question2").forEach(qs->{
                Question question = q.save(new Question(qs.split(" ")[0],qs.split(" ")[1],new ArrayList<>(),t1));
                t1.getQuestions().add(question);
                tp.save(t1);
            });
            Testpsy t2=tp.findById("t2").get();
            Stream.of("t2q1 question1","t2q2 question2").forEach(qs->{
                Question question = q.save(new Question(qs.split(" ")[0],qs.split(" ")[1],new ArrayList<>(),t2));
                t2.getQuestions().add(question);
                tp.save(t2);
            });

            r.deleteAll();
            Question q1 = q.findById("t1q1").get();
            Stream.of("t1q1r1 reponse1","t1q1r2 reponse2").forEach(rs->{
                Reponse reponse = r.save(new Reponse(rs.split(" ")[0],rs.split(" ")[1],q1));
                q1.getReponses().add(reponse);
                q.save(q1);
            });
            Question q2 = q.findById("t1q2").get();
            Stream.of("t1q2r1 reponse1","t1q2r2 reponse2").forEach(rs->{
                Reponse reponse = r.save(new Reponse(rs.split(" ")[0],rs.split(" ")[1],q2));
                q2.getReponses().add(reponse);
                q.save(q2);
            });
            emp.deleteAll();
            tr.deleteAll();
            Stream.of("e1 emp1","e2 emp2").forEach(rs->{
                Employee employee = emp.save(new Employee(rs.split(" ")[0],rs.split(" ")[1],"prenggom","emp@gmail.com",new ArrayList<>()));

            });
            Employee emp1 = emp.findById("e1").get();
            Reponse rep1= r.findById("t1q1r1").get();
            Reponse rep2 = r.findById("t1q2r1").get();
            TestResponses testReponse = tr.save(new TestResponses(null,emp1,t1,new ArrayList<>()));
            Stream.of(rep1,rep2).forEach(rp->{


                testReponse.getReponses().add(rp);
                tr.save(testReponse);

            });
            emp1.getTestsCompleted().add(testReponse);
            emp.save(emp1);





        };
    }
}
