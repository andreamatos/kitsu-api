package com.project.kitsuapi.response;

import java.util.List;

import com.project.kitsuapi.dto.KitsuResponse;

import lombok.Data;

@Data
public class AnimeTrendingResponse {
    List<KitsuResponse.Data<AnimeResponse>> data;
}
