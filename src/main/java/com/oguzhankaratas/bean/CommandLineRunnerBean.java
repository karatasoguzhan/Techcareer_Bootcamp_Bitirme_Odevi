package com.oguzhankaratas.bean;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@Log4j2  // log yazmak için kullanılır.
public class CommandLineRunnerBean {
    public CommandLineRunner commandLineRunnerMethod() {
        return args -> {
            log.info("Data set oluşturuldu"); // tercihen bu şekilde yazılması daha iyidir.
            System.out.println("Data set oluşturuldu."); // istersek bu şekildedede yazılabilir.
        }; //end return
    } //end CommandLineRunnerBean method
} //end class
