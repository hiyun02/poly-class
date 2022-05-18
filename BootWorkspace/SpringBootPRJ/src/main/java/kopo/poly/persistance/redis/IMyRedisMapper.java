package kopo.poly.persistance.redis;

import kopo.poly.dto.RedisDTO;

import java.util.List;
import java.util.Set;

public interface IMyRedisMapper {

    /**
     * String 타입 저장하기
     *
     * @param redisKey Redis 저장 키
     * @param pDTO     저장할 정보
     * @return 저장 성공 여부
     */
    int saveRedisString(String redisKey, RedisDTO pDTO) throws Exception;


    /**
     * String 타입 가져오기
     *
     * @param redisKey 가져올 RedisKey
     * @return 결과 값
     */
    RedisDTO getRedisString(String redisKey) throws Exception;

    /**
     * String 타입에 JSON 형태로 저장하기
     *
     * @param redisKey Redis 저장 키
     * @param pDTO     저장할 정보
     * @return 결과 값
     */
    int saveRedisStringJSON(String redisKey, RedisDTO pDTO) throws Exception;

    /**
     * List 타입에 JSON 형태로 저장하기
     *
     * @param redisKey Redis 저장 키
     * @param pList    저장할 정보
     * @return 결과 값
     */
    int saveRedisList(String redisKey, List<RedisDTO> pList) throws Exception;

    /**
     * List 타입에 여러 문자열로 저장된 데이터 가져오기
     *
     * @param redisKey 가져올 redisKey
     * @return 결과 값
     */
    List<String> getRedisList(String redisKey) throws Exception;

    int saveRedisListJSON(String redisKey, List<RedisDTO> pList) throws Exception;

    List<RedisDTO> getRedisListJSON(String redisKey) throws Exception;

    int saveRedisListJSONRamda(String redisKey, List<RedisDTO> pList) throws Exception;

    int saveRedisHash(String redisKey, RedisDTO pDTO) throws Exception;

    RedisDTO getRedisHash(String redisKey) throws Exception;

    int saveRedisSetJSONRamda(String redisKey, Set<RedisDTO> pSet) throws Exception;

    Set<RedisDTO> getRedisSetJSONRamda(String redisKey) throws Exception;

    int saveRedisZSetJSON(String redisKey, List<RedisDTO> pList) throws Exception;

    Set<RedisDTO> getRedisZSetJSON(String redisKey) throws Exception;

    boolean deleteDataJSON(String redisKey) throws Exception;

    boolean deleteDataString(String redisKey) throws Exception;

}