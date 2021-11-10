package com.project.kitsuapi.anime.response;

import java.util.List;

import com.project.kitsuapi.response.KitsuResponse;

import lombok.Data;

@Data
public class AnimeTrendingResponse {
    List<KitsuResponse.Data<AnimeResponse>> data;
}
