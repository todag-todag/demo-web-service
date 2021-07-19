package com.teamproject.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamproject.demo.dao.MemberDAO;
import com.teamproject.demo.vo.MemberVO;


@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO memberDAO;
	
	
	@Override
	public MemberVO searchMember(String id, String password) {
		
		
		System.out.println("MemberServiceImpl "+ id);
		System.out.println("MemberServiceImpl "+ password);
		
		MemberVO mb = memberDAO.selectMember(new MemberVO(id, password));
		
		
		System.out.println("MemberServiceImpl after memberDAO "+ mb.getId());
		System.out.println("MemberServiceImpl after memberDAO "+ mb.getName());
	
		return mb;
	}

	@Override
	public void registerMember(MemberVO mb) {
		memberDAO.insertMember(mb);
	}

}
