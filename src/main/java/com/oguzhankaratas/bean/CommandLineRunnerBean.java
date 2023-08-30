package com.oguzhankaratas.bean;

import com.oguzhankaratas.business.dto.TodoDto;
import com.oguzhankaratas.business.services.TodoService;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Log4j2  // log yazmak için kullanılır.
public class CommandLineRunnerBean {



    @Bean
    public CommandLineRunner commandLineRunnerMethod() {
        return args -> {
            log.info("Data set oluşturuldu"); // tercihen bu şekilde yazılması daha iyidir.
            System.out.println("Data set oluşturuldu."); // istersek bu şekildedede yazılabilir.

        }; //end return
    } //end CommandLineRunnerBean method

//    public void test(){
//        final TodoDto todoDto = createTodoDto();
//        final TodoDto todoDto1 = todoService.create(todoDto);
//        todoService.done(todoDto1.getId());
//    }

//    public TodoDto createTodoDto() {
//        final TodoDto todoDto = new TodoDto();
//        todoDto.setDescription("unutma2");
//        todoDto.setHeader("diş fırçala2");
//        return todoDto;
//    }

} //end class
