package com.project.kitsuapi.manga.response;

import java.util.List;

import com.project.kitsuapi.response.KitsuResponse;

import lombok.Data;

@Data
public class MangaTrendingResponse {
    List<KitsuResponse.Data<Manga>> data;
}
