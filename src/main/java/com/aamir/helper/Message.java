package com.aamir.helper;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Message {
    private String from;
    private String content;
}
