package com.example.bankingproject;

import com.example.bankingproject.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BankingProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankingProjectApplication.class, args);

    }

    @Bean
    CommandLineRunner run(AccountService account) {
        return args -> {
            System.out.println("=== TEST ACCOUNT ===");
            account.deposit(1000);
            account.deposit(2000);
            account.withdraw(500);
            try {
                account.deposit(-400);
            } catch (Exception e) {
                System.out.println("Deposit error : " + e.getMessage());
            }

            try {
                account.withdraw(-400);
            } catch (Exception e) {
                System.out.println("Withdraw error : " + e.getMessage());
            }

            try {
                account.withdraw(100000);
            } catch (Exception e) {
                System.out.println("Withdraw error : " + e.getMessage());
            }
            account.printStatement();
        };
    }
}
