package org.example.model;

import lombok.*;

import java.io.Serializable;

@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {

    private Long id;
    private String name;
    private String description;
    private Status status = Status.UNCHECKED;
    private String price;

    public enum Status {
        UNCHECKED, CHECKED
    }
}
