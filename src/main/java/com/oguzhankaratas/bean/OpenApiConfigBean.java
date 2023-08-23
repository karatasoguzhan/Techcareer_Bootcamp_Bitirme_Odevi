package com.oguzhankaratas.bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfigBean {

    public OpenAPI openAPIMethod() {
        return new OpenAPI()
                .info(
                        new Info()
                                .description("blog tanımlama")
                                .version("v1")
                                .contact(new Contact().email("oguzhan.krts@hotmail.com").url("url"))
                                .title("title")
                                .termsOfService("Software INC")
                                .license(new License().url("http://www.").name("name")));
    }
}

