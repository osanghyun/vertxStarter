package com.kt.vertxStarter;

import com.kt.vertxStarter.repository.MemberRepository;
import com.kt.vertxStarter.repository.MemoryMemberRepository;
import com.kt.vertxStarter.service.MemberService;
import com.kt.vertxStarter.service.MemberServiceImpl;

public class AppConfig {
  public MemberService memberService() {
    return MemberServiceImpl.getInstance();
  }
}
