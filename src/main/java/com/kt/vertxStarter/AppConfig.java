package com.kt.vertxStarter;

import com.kt.vertxStarter.repository.MemberRepository;
import com.kt.vertxStarter.repository.MemoryMemberRepository;
import com.kt.vertxStarter.service.MemberService;
import com.kt.vertxStarter.service.MemberServiceImpl;

public class AppConfig {
  public MemberRepository memberRepository() {
    return MemoryMemberRepository.getInstance();
  }

  public MemberService memberService() {
    return new MemberServiceImpl(memberRepository());
  }
}
