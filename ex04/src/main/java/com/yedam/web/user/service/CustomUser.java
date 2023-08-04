package com.yedam.web.user.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUser implements UserDetails {
	
	
	private MemberVO member;
	
	public CustomUser(MemberVO member) { //생성자 통해 memberVO 가질 수 있게 생성
		this.member = member;
		
	}
	
	public MemberVO getMemberInfo() {
		return this.member;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auth = new ArrayList<>(); //권한은 복수라서 list로 출력, 디폴트가 배열?
		auth.add(new SimpleGrantedAuthority(member.getRole())); //권한 정보를 집어넣는데 감싼다..? 부여된 권한을 따로 처리하는, 조회하는게 하나라서 이런 방식으로 처리 여러개면 반복문 처리
		return auth;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.member.getPwd();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.member.getId();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	} //false를 true로 변경
	
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
