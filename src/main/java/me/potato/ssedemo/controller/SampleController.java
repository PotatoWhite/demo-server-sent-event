package me.potato.ssedemo.controller;

import lombok.RequiredArgsConstructor;
import me.potato.ssedemo.dto.SampleDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@RequiredArgsConstructor
@RestController
@RequestMapping("sse")
public class SampleController {
    private final Flux<SampleDto>       flux;
    private final Sinks.Many<SampleDto> sink;

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<SampleDto> getSSE(){
        return flux;
    }

    @PostMapping(value = "/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<Void> create(@RequestBody SampleDto sampleDto){
        sink.tryEmitNext(sampleDto);
        return Mono.empty();
    }
}
