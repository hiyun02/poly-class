package kopo.poly.persistance.redis.impl;

import kopo.poly.dto.RedisDTO;
import kopo.poly.persistance.redis.IMyRedisMapper;
import kopo.poly.util.CmmUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component("MyRedisMapper")
public class MyRedisMapper implements IMyRedisMapper {

    public final RedisTemplate<String, Object> redisDB;


    public MyRedisMapper(RedisTemplate<String, Object> redisDB) {
        this.redisDB = redisDB;
    }

    @Override
    public int saveRedisString(String redisKey, RedisDTO pDTO) throws Exception {

    log.info(this.getClass().getName()+".saveRedisString Start!!");

    int res =0;

    String saveData = CmmUtil.nvl(pDTO.getTest_text());

    // redis 저장 및 읽기에 대한 데이터 타입 지정 (String 타입으로 지정함)
    redisDB.setKeySerializer(new StringRedisSerializer()); //String 타입
    redisDB.setValueSerializer(new StringRedisSerializer()); //String 타입

    if(!redisDB.hasKey(redisKey)) {

        //RedisDB에 저장되는 데이터의 유효시간 설정(TTL 설정)
        //2일이 지나면, 자동적으로 데이터가 삭제되도록 설정함
        redisDB.opsForValue().set(redisKey, saveData);
        redisDB.expire(redisKey,2, TimeUnit.DAYS);

        log.info("Save Data!!");
        res = 1;
    }

    log.info(this.getClass().getName()+".saveRedisString End!");

    return res;

    }

    @Override
    public RedisDTO getRedisString(String redisKey) throws Exception {
        log.info(this.getClass().getName()+".saveRedisString Start!!");

        log.info("String redisKey : "+redisKey);
        RedisDTO rDTO = new RedisDTO();

        //반드시 저장할 때 사용한 타입과 동일하게 맞추기
        redisDB.setKeySerializer(new StringRedisSerializer()); //String 타입
        redisDB.setValueSerializer(new StringRedisSerializer()); //String 타입

        if (redisDB.hasKey(redisKey)) {
            String res = (String)redisDB.opsForValue().get(redisKey);
            log.info("res : "+res);

            //RedisDB에 저장된 데이터를 DTO에 저장하기
            rDTO.setTest_text(res);
        }

        log.info(this.getClass().getName()+".saveRedisString End!");


        return rDTO;
    }

    @Override
    public int saveRedisStringJSON(String redisKey, RedisDTO pDTO) throws Exception {
        log.info(this.getClass().getName() + ".saveRedisStringJSON Start!");

        int res = 0;

        //redisDB의 키의 데이터 타입을 String으로 정의(항상 String으로 설정함)
        redisDB.setKeySerializer(new StringRedisSerializer());

        //RedisDTO에 저장된 데이터를 자동으로 JSON으로 변경하기
        redisDB.setValueSerializer(new Jackson2JsonRedisSerializer<>(RedisDTO.class));

        if (!redisDB.hasKey(redisKey)) {

            //데이터 저장하기
            redisDB.opsForValue().set(redisKey,pDTO);

            //RedisDB에 저장되는 데이터의 유효시간 설정(TTL 설정)
            //2일이 지나면 자동으로 데이터가 삭제되도록 설정함
            redisDB.expire(redisKey, 2, TimeUnit.DAYS);

            log.info("Save Data!!");

            res = 1;

        }

        log.info(this.getClass().getName()+".saveRedisStringJSON End!");


        return res;
    }

    @Override
    public int saveRedisList(String redisKey, List<RedisDTO> pList) throws Exception {

        log.info(this.getClass().getName()+".saveRedisList Start!");
        int res = 0;
        redisDB.setKeySerializer(new StringRedisSerializer());
        redisDB.setValueSerializer(new StringRedisSerializer());

        for(RedisDTO dto : pList) {
            //오름차순 저장
            redisDB.opsForList().rightPush(redisKey, CmmUtil.nvl(dto.getTest_text()));

        }

        redisDB.expire(redisKey, 5, TimeUnit.HOURS);

        res = 1;

        log.info(this.getClass().getName()+".saveRedisList End!");

        return res;
    }

    @Override
    public List<String> getRedisList(String redisKey) throws Exception {

        log.info(this.getClass().getName()+".getRedisList Start!");

        List<String> rList = null;

        redisDB.setKeySerializer(new StringRedisSerializer());
        redisDB.setValueSerializer(new StringRedisSerializer());

        if(redisDB.hasKey(redisKey)){
            rList = (List) redisDB.opsForList().range(redisKey,0,-1);
        }

        log.info(this.getClass().getName()+".getRedisList End!");

        return null;
    }

    @Override
    public int saveRedisListJSON(String redisKey, List<RedisDTO> pList) throws Exception {

        log.info(this.getClass().getName()+".saveRedisListJSON Start!!");

        int res = 0;

        redisDB.setKeySerializer(new StringRedisSerializer());
        redisDB.setValueSerializer(new StringRedisSerializer());

        redisDB.setValueSerializer(new Jackson2JsonRedisSerializer<>(RedisDTO.class));

        for(RedisDTO dto : pList) {
            //오름차순 저장
            redisDB.opsForList().rightPush(redisKey, dto);
        }

        redisDB.expire(redisKey, 5, TimeUnit.HOURS);

        res = 1;

        log.info(this.getClass().getName()+".saveRedisListJSON End!");

        return res;
    }

    @Override
    public List<RedisDTO> getRedisListJSON(String redisKey) throws Exception {

        log.info(this.getClass().getName()+".getRedisListJSON");

        List<RedisDTO> rList = null;

        redisDB.setKeySerializer(new StringRedisSerializer());
        redisDB.setValueSerializer(new Jackson2JsonRedisSerializer<>(RedisDTO.class));

        if(redisDB.hasKey(redisKey)){
            rList = (List) redisDB.opsForList().range(redisKey, 0 , -1);
        }

        log.info(this.getClass().getName()+".getRedisListJSON");


        return rList;
    }

    @Override
    public int saveRedisListJSONRamda(String redisKey, List<RedisDTO> pList) throws Exception {

        log.info(this.getClass().getName()+".saveRedisListJSONRamda Start!!");
        int res = 0;
        redisDB.setKeySerializer(new StringRedisSerializer());
        redisDB.setValueSerializer(new Jackson2JsonRedisSerializer<>(RedisDTO.class));
        pList.forEach(dto -> redisDB.opsForList().rightPush(redisKey,dto));
        redisDB.expire(redisKey, 5, TimeUnit.HOURS);
        res=1;
        log.info(this.getClass().getName()+".saveRedisListJSONRamda End!!");

        return res;
    }

    @Override
    public int saveRedisHash(String redisKey, RedisDTO pDTO) throws Exception {

        log.info(this.getClass().getName()+".saveRedisHash Start!");

        int res = 0;

        redisDB.setKeySerializer(new StringRedisSerializer());
        redisDB.setValueSerializer(new StringRedisSerializer());

        redisDB.opsForHash().put(redisKey, "name", CmmUtil.nvl(pDTO.getName()));
        redisDB.opsForHash().put(redisKey, "email", CmmUtil.nvl(pDTO.getEmail()));
        redisDB.opsForHash().put(redisKey, "addr", CmmUtil.nvl(pDTO.getAddr()));

        redisDB.expire(redisKey, 100, TimeUnit.MINUTES);

        res = 1;

        log.info(this.getClass().getName()+".saveRedisHash End!");


        return res;
    }

    @Override
    public RedisDTO getRedisHash(String redisKey) throws Exception {

        log.info(this.getClass().getName()+".getRedisHashStart!!");

        RedisDTO rDTO = new RedisDTO();

        redisDB.setKeySerializer(new StringRedisSerializer());
        redisDB.setValueSerializer(new StringRedisSerializer());

        if(redisDB.hasKey(redisKey)){
            String name = CmmUtil.nvl((String)redisDB.opsForHash().get(redisKey, "name"));
            String email = CmmUtil.nvl((String)redisDB.opsForHash().get(redisKey, "email"));
            String addr = CmmUtil.nvl((String)redisDB.opsForHash().get(redisKey, "addr"));

            log.info("name : "+ name);
            log.info("email : "+ email);
            log.info("addr : "+ addr);

            rDTO.setName(name);
            rDTO.setEmail(email);
            rDTO.setAddr(addr);
        }

        log.info(this.getClass().getName()+".getRedisHash End!");

        return rDTO;
    }

    @Override
    public int saveRedisSetJSONRamda(String redisKey, Set<RedisDTO> pSet) throws Exception {

        log.info(this.getClass().getName()+".sasveRedisSetJSONRamda Start!!");

        int res = 0;

        //redisDB의 키의 데이터 타입을 String으로 정의 (항상 String으로 설정함)
        redisDB.setKeySerializer(new StringRedisSerializer());

        //RedisDTO에 저장된 데이터를 자동으로 JSON으로 변경하기
        redisDB.setValueSerializer(new Jackson2JsonRedisSerializer<>(RedisDTO.class));
        //데이터 저장하기
        pSet.forEach(dto->redisDB.opsForSet().add(redisKey,dto));

        //저장되는 데이터의 유효기간(TTL)은 5시간으로 정의
        redisDB.expire(redisKey,5, TimeUnit.HOURS);

        res = 1;

        log.info(this.getClass().getName()+".saveRedisSetJSONRamda End !");

        return res;
    }

    @Override
    public Set<RedisDTO> getRedisSetJSONRamda(String redisKey) throws Exception {

        log.info(this.getClass().getName()+".getRedisSetJSONRamda Start!!");

        Set<RedisDTO> rSet = null;

        //redisDB의 키의 데이터 타입을 String으로 정의(항상 String으로 설정함)
        redisDB.setKeySerializer(new StringRedisSerializer());

        //RedisDTO에 저장된 데이터를 자동으로 JSON으로 변경하기
        redisDB.setValueSerializer(new Jackson2JsonRedisSerializer<>(RedisDTO.class));

        if(redisDB.hasKey(redisKey)){
            rSet = (Set) redisDB.opsForSet().members(redisKey);
        }

        log.info(this.getClass().getName()+".getRedisSetJSONRamda End!!");

        return rSet;
    }

    @Override
    public int saveRedisZSetJSON(String redisKey, List<RedisDTO> pList) throws Exception {

        log.info(this.getClass().getName()+".saveRedisZSetJSON Start!!");

        int res =0;

        redisDB.setKeySerializer(new StringRedisSerializer());
        redisDB.setValueSerializer(new Jackson2JsonRedisSerializer<>(RedisDTO.class));

        int idx = 0;

        for(RedisDTO dto : pList) {
            redisDB.opsForZSet().add(redisKey, dto, ++idx);
        }

        redisDB.expire(redisKey, 5, TimeUnit.HOURS);

        res = 1;

        log.info(this.getClass().getName()+".saveRedisZSetJSON End!!");

        return res;
    }

    @Override
    public Set<RedisDTO> getRedisZSetJSON(String redisKey) throws Exception {

        log.info(this.getClass().getName()+".getRedisZSetJSON Start!!");

        Set<RedisDTO> rSet = null;

        redisDB.setKeySerializer(new StringRedisSerializer());
        redisDB.setValueSerializer(new StringRedisSerializer());

        if(redisDB.hasKey(redisKey)) {
            long cnt = redisDB.opsForZSet().size(redisKey);
            rSet = (Set) redisDB.opsForZSet().range(redisKey, 0, cnt);
        }

        log.info(this.getClass().getName()+".getRedisZSetJSON End !!");

        return rSet;
    }

    @Override
    public boolean deleteDataJSON(String redisKey) throws Exception {
        log.info(this.getClass().getName()+".deleteDataJSON Start!!");

        redisDB.setKeySerializer(new StringRedisSerializer());
        redisDB.setValueSerializer(new Jackson2JsonRedisSerializer<>(RedisDTO.class));

        boolean res = false;

        if(redisDB.hasKey(redisKey)){
            redisDB.delete(redisKey);

            res=true;
        }

        log.info(this.getClass().getName()+".deleteDataJSON End!!");

        return res;
    }

    @Override
    public boolean deleteDataString(String redisKey) throws Exception {
        log.info(this.getClass().getName()+".deleteDataString Start!!");

        redisDB.setKeySerializer(new StringRedisSerializer());
        redisDB.setValueSerializer(new StringRedisSerializer());

        boolean res = false;

        if(redisDB.hasKey(redisKey)){
            redisDB.delete(redisKey);
            res=true;
        }

        log.info(this.getClass().getName()+".deleteDataString End!!");

        return res;
    }


}
