package com.ssafy.eurekka.controller;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	private String naverClientId = "AxHLlIRdNj8xtwynt8hJ";
	private String redirectUri = "http://localhost:19000/";

	@ApiOperation(value = "네이버 로그인을 위한 url요청", notes = "url 리턴", response = String.class)
	@GetMapping("/naver/url")
	public ResponseEntity<String> getNaverLoginState() {
		System.out.println("url요청");
		ResponseEntity<String> result = null;

		try {
			SecureRandom random = new SecureRandom();
			String state = new BigInteger(130, random).toString(32);
			String url = "https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id="+naverClientId+
					"&redirect_uri="+redirectUri+"&state="+state;
			System.out.println(url);
			result = new ResponseEntity<String>(url, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			result = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return result;
	}

//	@ApiOperation(value = "네이버 로그인 및 프로필 가져오기", notes = "state 리턴", response = String.class)
//	@GetMapping("/naver/login")
//	public ResponseEntity<Object> naverLogin(String code, String state) {
//		// grant_type=authorization_code 고정!
//		ResponseEntity<Object> result = null;
//
//		// 상태코드 검증 해야하는데
//
//		String clientId = "AxHLlIRdNj8xtwynt8hJ";
//		String clientSecret = "d3QPfCSvIx";
//
//		// 인증코드(code)사용하여 접근토큰 발급받기
//		String url = "https://nid.naver.com/oauth2.0/token?client_id=" + clientId + "&client_secret=" + clientSecret
//				+ "&grant_type=authorization_code&state=" + state + "&code=" + code;
//		RestTemplate restTemplate = new RestTemplate();
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
//		ResponseEntity<String> tokenResponse = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers),
//				String.class);
//		ObjectMapper objectMapper = new ObjectMapper();
//		OAuthToken oauthToken = null;
//		try {
//			oauthToken = objectMapper.readValue(tokenResponse.getBody(), OAuthToken.class);
//		} catch (JsonMappingException e) {
//			e.printStackTrace();
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
//		
//		// 접근토큰을(OAuthToken.access_token)사용하여 사용자 프로필정보 접근
//		restTemplate = new RestTemplate();
//		headers = new HttpHeaders();
//		headers.add("Authorization", "Bearer " + oauthToken.getAccess_token());
//		
//		
//
//
//
//		return result;
//	}
}
