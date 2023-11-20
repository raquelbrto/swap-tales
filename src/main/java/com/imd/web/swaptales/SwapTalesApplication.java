package com.imd.web.swaptales;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableWebMvc
public class SwapTalesApplication implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
	}

	public static void main(String[] args) {
		SpringApplication.run(SwapTalesApplication.class, args);
	}

	@Bean
	public Cloudinary cloudinary(){
		return new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dwqdho4ni",
				"api_key", "158537978691443",
				"api_secret", "vbZgW4QfbBnCF8OifEZ6b1FssJM"
		));
	}
}