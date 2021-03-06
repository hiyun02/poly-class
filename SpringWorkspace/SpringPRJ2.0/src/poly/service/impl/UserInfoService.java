package poly.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.dto.MailDTO;
import poly.dto.UserInfoDTO;
import poly.persistance.mapper.IUserInfoMapper;
import poly.service.IMailService;
import poly.service.IUserInfoService;
import poly.util.CmmUtil;
import poly.util.EncryptUtil;

@Service("UserInfoService")
public class UserInfoService implements IUserInfoService {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "UserInfoMapper")
	private IUserInfoMapper userInfoMapper;

	@Resource(name = "MailService")
	private IMailService mailService;
	
	@Override
	public int insertUserInfo(UserInfoDTO pDTO) throws Exception {
		log.info(this.getClass().getName()+" 서비스 시작 !!");
		// 회원가입 성공 : 1, 아이디 중복으로 인한 가입 취소 : 2, 기타 에러 발생 : 0
		int res = 0;

		// controller에서 값이 정상적으로 못 넘어오는 경우를 대비하기 위해 사용함
		if (pDTO == null) {
			pDTO = new UserInfoDTO();
		}

		// 회원 가입 중복 방지를 위해 DB에서 데이터 조회
		UserInfoDTO rDTO = userInfoMapper.getUserExists(pDTO);
		log.info("DB로부터 중복체크를 위해 값을 받아옴");
		
		// mapper에서 값이 정상적으로 넘어오지 못하는 경우를 대비하기 위한 처리
		if (rDTO == null) {
			rDTO = new UserInfoDTO();
			log.info("null 값이 DB로부터 넘어옴");
		}

		// 중복된 회원 정보가 있는 경우, 결과값을 2로 변경하고 더이상 작업을 진행하지 않음
		if (rDTO.getExists_yn().equals("Y")) {
			log.info("유저 아이디 중복");;
			rDTO=null;
			res = 2;
		}

		else {
			log.info("유저 아이디가 중복되지 않으므로 회원가입 로직 시작.");
			// 회원가입
			int success = userInfoMapper.insertUserInfo(pDTO);
			log.info("DB에 insert쿼리를 날림");
			// db에 데이터가 등록 성공했다면 success==1
			if (success > 0) {
				res = 1;
				
				log.info("회원가입 성공 후 축하 메일 발송 시작 !!");
				MailDTO mDTO = new MailDTO();	
				mDTO.setToMail(EncryptUtil.decAES128CBC(CmmUtil.nvl(pDTO.getEmail())));
				mDTO.setTitle(CmmUtil.nvl(pDTO.getUser_name())+"님의 회원가입을 축하드립니다 !!");
				mDTO.setContents("김하윤 과제 완료했습니다 !!");
				int sendmail = mailService.doSendMail(mDTO);
				mDTO=null; pDTO=null;
				
				if(sendmail==1) {
					log.info("가입자 메일발송 성공");
				} else {
					log.info("메일 발송 실패");
				}
				
			} else {
				log.info("회원가입 실패.");
				res = 0;
			}
			
		
		}
			log.info(this.getClass().getName()+" 서비스 종료");
		return res;
	}

}
