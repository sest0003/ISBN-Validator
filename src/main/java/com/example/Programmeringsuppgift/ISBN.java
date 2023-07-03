package com.example.Programmeringsuppgift;

import lombok.*;
import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class ISBN {

    long isbn10;
    long isbn13;

}
