package me.potato.ssedemo.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SampleDto {
    private String id;
    private String name;
    private Integer price;
}
