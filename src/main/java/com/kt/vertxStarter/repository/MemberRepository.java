package com.kt.vertxStarter.repository;

import com.kt.vertxStarter.entity.Member;

import java.util.List;

public interface MemberRepository {
  List<Member> findAll();
  Member findByName(String name);
  void save(Member member);

  void update(Member member);

  void delete(String name);



}
