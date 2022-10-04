package com.kt.vertxStarter.repository;

import com.kt.vertxStarter.entity.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{
  private static Map<String, Member> store = new HashMap<>();

  @Override
  public List<Member> findAll() {
    return store.values().stream().toList();
  }

  @Override
  public Member findByName(String name) {
    return store.get(name);
  }

  @Override
  public void save(Member member) {
    store.put(member.getName(), member);
  }

  @Override
  public void update(Member member) {
    store.replace(member.getName(), member);
  }

  @Override
  public void delete(String name) {
    store.remove(name);
  }

}
