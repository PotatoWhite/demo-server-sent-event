package me.potato.ssedemo.config;

import me.potato.ssedemo.dto.SampleDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Configuration
public class SinkConfig {

    // input
    @Bean
    public Sinks.Many<SampleDto> sink(){
        return Sinks.many().replay().limit(1);
    }

    // output
    @Bean
    public Flux<SampleDto> sampleDtoFlux(Sinks.Many<SampleDto> sink){
        return sink.asFlux();
    }
}
