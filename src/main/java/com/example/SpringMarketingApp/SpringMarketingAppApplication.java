package com.example.SpringMarketingApp;

import com.example.SpringMarketingApp.models.MarketingManager;
import com.example.SpringMarketingApp.services.AreaService;
import com.example.SpringMarketingApp.services.MarketingManagerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SpringMarketingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMarketingAppApplication.class, args);
	}


}
