package kopo.poly.controller;

import kopo.poly.dto.RedisDTO;
import kopo.poly.service.IMyRedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Slf4j
@RestController
public class RedisController {

    @Resource(name = "MyRedisService")
    private IMyRedisService myRedisService;

    //Redis 문자열 저장 실습
    @GetMapping(value = "redis/saveRedisString")
    public String saveRedisString() throws Exception {
        log.info(this.getClass().getName() + ".saveRedisString STart!");

        String msg;
        int res = myRedisService.saveRedisString();

        if (res == 1) {
            msg = "success";
        } else {
            msg = "fail";
        }

        log.info(this.getClass().getName() + ".saveRedisString End !");

        return msg;
    }

    //Redis 문자열 저장된 값 가져오기
    @GetMapping(value = "redis/getRedisString")
    public RedisDTO getRedisString() throws Exception {
        log.info(this.getClass().getName()+".getRedisString Start!");

        RedisDTO rDTO = myRedisService.getRedisString();

        log.info(this.getClass().getName() + ".getRedisString End!");

        return rDTO;

    }


    @GetMapping(value="redis/saveRedisStringJSON")
    public String saveRedisStringJSON() throws Exception {
        log.info(this.getClass().getName() + ".saveRedisStringJSON Start!");

        String msg;

        int res = myRedisService.saveRedisStringJSON();

        if (res == 1) {
            msg = "success";
        } else {
            msg = "fail";
        }

        log.info(this.getClass().getName() + ".saveRedisStringJSON End!");
        return msg;
    }

    @GetMapping(value = "redis/saveRedisList")
    public String saveRedisList() throws Exception{
        log.info(this.getClass().getName()+".saveRedisList Start!!");

        String msg;

        int res = myRedisService.saveRedisList();

        if(res==1){
            msg="success";
        } else{
            msg="fail";
        }

        log.info(this.getClass().getName()+".saveRedisList Start!!");

        return msg;
    }

    @GetMapping(value = "redis/getRedisList")
    public List<String> getRedisList() throws Exception {
        log.info(this.getClass().getName()+".getRedisList Start!!");

        List<String> rList = myRedisService.getRedisList();

        log.info(this.getClass().getName()+".getRedisList End!!");


        return rList;
    }

    @GetMapping(value = "redis/saveRedisListJSON")
    public String saveListJSON() throws Exception {
        log.info(this.getClass().getName()+".saveRedisListJSON Start!!");

        String msg;

        int res = myRedisService.saveRedisListJSON();
        if(res ==1 ){
            msg ="success";
        } else {
            msg="fail";
        }

        log.info(this.getClass().getName()+".saveRedisListJSON End!!");

        return msg;
    }

    @GetMapping(value="redis/saveRedisListJSONRamda")
    public String saveRedisListJSONRamda() throws Exception {
        log.info(this.getClass().getName()+".saveRedisListJSON Start!!");
        String msg;
        int res = myRedisService.saveRedisListJSONRamda();
        if(res==1){
            msg="success";
        } else{
            msg="fail";
        }
        log.info(this.getClass().getName()+".saveRedisListJSONRamda End!!");
        return msg;
    }
    @GetMapping(value="redis/getRedisListJSONRamda")
    public List<RedisDTO> getRedisListJSONRamda() throws Exception{
        log.info(this.getClass().getName()+".getRedisListJSONRamda Start!");

        List<RedisDTO> rList = myRedisService.getRedisListJSONRamda();


        log.info(this.getClass().getName()+".getRedisListJSONRamda End!");

        return rList;
    }

    @GetMapping(value="redis/saveRedisHash")
    public String saveRedisHash() throws Exception {

        log.info(this.getClass().getName()+".saveRedisHash Start!");
        String msg;
        int res = myRedisService.saveRedisHash();
        if(res == 1){
            msg = "success";
        } else {
            msg = "fail";
        }

        log.info(this.getClass().getName()+".saveRedisHash End !");

        return msg;
    }

    @GetMapping(value ="redis/getRedisHash")
    public RedisDTO getRedisHash() throws Exception {
        log.info(this.getClass().getName()+".getRedisHash Start!");

        RedisDTO rDTO = myRedisService.getRedisHash();

        log.info(this.getClass().getName()+".getRedisHash End!");

        return rDTO;
    }

    @GetMapping(value="redis/saveRedisSetJSONRamda")
    public String saveRedisSetJSONRamda() throws Exception {
        log.info(this.getClass().getName()+".saveRedisSetJSONRamda Start!!");

        //수집 결과 출력
        String msg;

        int res = myRedisService.saveRedisSetJSONRamda();

        if(res==1){
            msg="success";
        } else{
            msg="fail";
        }

        log.info(this.getClass().getName()+".saveRedisSetJSONRamda End!!");
        return msg;
    }

    @GetMapping(value="redis/getRedisSetJSONRamda")
    public Set<RedisDTO> getRedisSetJSONRamda() throws Exception{
        log.info(this.getClass().getName()+".getRedisSetJSONRamda Start!!");

        Set<RedisDTO> rSet = myRedisService.getRedisSetJSONRamda();

        log.info(this.getClass().getName()+".getRedisSetJSONRamda End!!");

        return rSet;
    }
}