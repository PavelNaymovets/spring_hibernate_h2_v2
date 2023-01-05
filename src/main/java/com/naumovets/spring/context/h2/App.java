package com.naumovets.spring.context.h2;

import com.naumovets.spring.context.h2.appConfig.AppConfig;
import com.naumovets.spring.context.h2.repository.SessionFactoryUtils;
import com.naumovets.spring.context.h2.service.CustomerProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SessionFactoryUtils sessionFactoryUtils = context.getBean(SessionFactoryUtils.class);

        CustomerProductService cps = context.getBean(CustomerProductService.class);

        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String line = bf.readLine();
                if (line != null) {

                } else {
                    break;
                }
            }
            System.out.println(cps.getCustomerProductsById(1L));
            System.out.println(cps.getProductCustomersById(1L));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shutdown();
        }
    }
}
