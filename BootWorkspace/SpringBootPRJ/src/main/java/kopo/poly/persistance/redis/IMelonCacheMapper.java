package kopo.poly.persistance.redis;

import kopo.poly.dto.MelonDTO;

import java.util.List;

public interface IMelonCacheMapper {

    /**
     * 멜론 노래 리스트 저장하기
     */
    int insertSong(List<MelonDTO> pList, String redisKey) throws Exception;

    /**
     * 멜론 노래 키 정보 존재여부 체크하기
     */
    boolean getExistKey(String redisKey) throws Exception;

    /**
     * 오늘 수집된 멜론 노래리스트 가져오기
     *
     */
    List<MelonDTO> getSongList(String redisKey) throws Exception;


}
