package com.sms.be.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Page<T> {
   private Integer page;
    private Integer count;
    private List<T> data;
}
