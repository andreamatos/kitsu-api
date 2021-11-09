package com.project.kitsuapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Image {
    private String tiny;
    private String small;
    private String medium;
    private String large;
    private String original;
}