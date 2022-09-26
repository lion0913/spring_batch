package com.ll.lion.spring_batch.app.base;

import com.ll.lion.spring_batch.app.cart.service.CartService;
import com.ll.lion.spring_batch.app.member.entity.Member;
import com.ll.lion.spring_batch.app.member.service.MemberService;
import com.ll.lion.spring_batch.product.entity.ProductOption;
import com.ll.lion.spring_batch.product.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("dev")
public class DevInitData {
    @Bean
    public CommandLineRunner initData(MemberService memberService, ProductService productService) {
        return args ->
        {
            String password = "{noop}1234";
            Member member1 = memberService.join("user1", password, "user1@test.com");
            Member member2 = memberService.join("user2", password, "user2@test.com");
            Member member3 = memberService.join("user3", password, "user3@test.com");
            Member member4 = memberService.join("user4", password, "user4@test.com");

            productService.create("단가라 OPS", 68000, "청평화 A-1-15", Arrays.asList(new ProductOption("RED", "44"), new ProductOption("RED", "55"), new ProductOption("BLUE", "44"), new ProductOption("BLUE", "55")));
            productService.create("쉬폰 OPS", 72000, "청평화 A-1-15", Arrays.asList(new ProductOption("BLACK", "44"), new ProductOption("BLACK", "55"), new ProductOption("WHITE", "44"), new ProductOption("WHITE", "55")));
        };
    }
}
