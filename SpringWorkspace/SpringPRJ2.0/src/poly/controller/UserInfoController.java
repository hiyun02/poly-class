package poly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.UserInfoDTO;
import poly.service.IUserInfoService;
import poly.util.CmmUtil;
import poly.util.EncryptUtil;

@Controller("UserInfoController")
public class UserInfoController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="UserInfoService")
	private IUserInfoService userInfoService;
	
	//회원가입 화면으로 이동
	@RequestMapping(value="user/userRegForm")
	public String userRegForm() {
		log.info(this.getClass().getName()+" user/userRegForm ok !!");
		return "/user/UserRegForm";
	}
	
	
	//회원가입 로직 처리
	@RequestMapping(value="user/insertUserInfo")
	public String insertUserInfo(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{
		
		log.info(this.getClass().getName()+" 회원가입 로직 시작 !!");
		
		//회원가입 결과에 대한 메시지를 전달할 변수
		String msg ="";
		//회원가입 후 이동할 jsp파일 경로
		String page="/user/UserRegForm";
		
		//웹(회원정보 입력화면)에서 받는 정보를 저장할 변수
		UserInfoDTO pDTO = null;
		
		try {
			//웹에서 받는 정보를 String 변수에 저장
			String user_id = CmmUtil.nvl(request.getParameter("user_id"));
			String user_name = CmmUtil.nvl(request.getParameter("user_name"));
			String password = CmmUtil.nvl(request.getParameter("password"));
			String email = CmmUtil.nvl(request.getParameter("email"));
			String addr1 = CmmUtil.nvl(request.getParameter("addr1"));
			String addr2 = CmmUtil.nvl(request.getParameter("addr2"));
		
			//*********값을 받았으면 꼭 로그를 찍어서 값이 제대로 들어오는 지 파악해야 함
			log.info("user_id : " + user_id);
			log.info("user_name : " +user_name);
			log.info("password : " +password);
			log.info("email : " +email);
			log.info("addr1 : " + addr1);
			log.info("addr2 : " + addr2);
			
			//입력화면에서 받는 정보를 저장할 변수를 메모리에 올리기
			pDTO=new UserInfoDTO();
			
			pDTO.setUser_id(user_id);
			pDTO.setUser_name(user_name);
			
			//비밀번호는 절대로 복호화되지 않도록 해시 알고리즘으로 암호화함
			pDTO.setPassword(EncryptUtil.encHashSHA256(password));
			//민감 정보인 이메일은 AES128-CBC로 암호화함
			pDTO.setEmail(EncryptUtil.encAES128CBC(email));
			pDTO.setAddr1(addr1);
			pDTO.setAddr2(addr2);
			//웹에서 받는 정보를 DTO에 저장하기 끝!!

			log.info("DTO에 담긴 값을 서비스의 회원가입 로직으로 넘겨 회원가입 진행");
			int res = userInfoService.insertUserInfo(pDTO);
			
			if(res==1) {
				msg= "회원가입되었습니다.";
				page="/user/Msg";
			} else if(res==2) {
				msg= "이미 가입된 이메일 주소입니다.";
			} else {
				msg = "오류가 발생하여 회원가입을 실패하였습니다.";
			}
			
			
		} catch(Exception e) {
			//저장에 실패하면 진입하게 됌
			msg = "데이터 저장을 실패하였습니다 ." + e.toString();
			log.info(e.toString());
			e.printStackTrace();
		} finally {
			log.info(this.getClass().getName()+" 회원가입 컨트롤러 종료 !");
			//회원가입 여부 결과 메시지 전달
			model.addAttribute("msg", msg);
			//회원가입 여부 결과 메시지 전달
			model.addAttribute("pDTO", pDTO);
			pDTO=null;
		
		}
		return page;
	}
	
}
