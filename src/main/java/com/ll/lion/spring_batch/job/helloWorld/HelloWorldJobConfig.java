package com.ll.lion.spring_batch.job.helloWorld;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class HelloWorldJobConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;


    @Bean
    public Job helloWorldJob() {
        //jobBuilderFactory를 통해 JOB을 생성한다.
        return jobBuilderFactory.get("helloWorldJob")
                .incrementer(new RunIdIncrementer()) // 강제로 매번 다른 ID를 실행시에 파라미터로 부여
                .start(helloWorldStep1())
                .next(helloWorldStep2())
                .build();
    }

    @Bean
    @JobScope
    public Step helloWorldStep1() {
        return stepBuilderFactory.get("helloWorldStep1")
                .tasklet(helloWorldStep1Tasklet())
                .build();
    }

    @Bean
    @StepScope
    public Tasklet helloWorldStep1Tasklet() {
        return ((contribution, chunkContext) -> {
            System.out.println("헬로월드 테스클릿 1");

            return RepeatStatus.FINISHED;
        });
    }

    @Bean
    @JobScope
    public Step helloWorldStep2() {
        return stepBuilderFactory.get("helloWorldStep2")
                .tasklet(helloWorldStep2Tasklet())
                .build();
    }

    @Bean
    @StepScope
    public Tasklet helloWorldStep2Tasklet() {
        return (contribution, chunkContext) -> {
            System.out.println("헬로월드 테스클릿 2");

            if(true) {
                throw new Exception("실패 : 태스클릿2");
            }

            return RepeatStatus.FINISHED;
        };
    }
}
