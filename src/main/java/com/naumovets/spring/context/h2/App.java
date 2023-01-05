package com.naumovets.spring.context.h2;

import com.naumovets.spring.context.h2.appConfig.AppConfig;
import com.naumovets.spring.context.h2.model.Customer;
import com.naumovets.spring.context.h2.model.Product;
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
            System.out.println("Введите номер продукта или покупателя о которых хотите узнать данные.\n\rПример: product 1, customer 1");
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String line = bf.readLine();
                if (line != null) {
                    String[] str = line.split(" ");
                    String productOrCustomer = str[0];
                    Long id = Long.parseLong(str[1]);

                    if (productOrCustomer.equals("product")) {
                        System.out.println("Продукт: " + cps.getProductById(id));
                        System.out.println("Покупатели продукта:" + cps.getProductCustomersById(id));
                    } else if (productOrCustomer.equals("customer")) {
                        System.out.println("Покупатель: " + cps.getCustomerById(id));
                        System.out.println("Продукты покупателя: " + cps.getCustomerProductsById(id));
                    } else {
                        System.out.println("Введите слово PRODUCT или CUSTOMER и номер продукты или покупателя");
                    }
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shutdown();
        }
    }
}
