package com.kt.vertxStarter.service;

import com.google.gson.Gson;
import com.kt.vertxStarter.entity.Member;
import com.kt.vertxStarter.repository.MemberRepository;
import com.kt.vertxStarter.repository.MemoryMemberRepository;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.List;

public class MemberServiceImpl implements MemberService{
  private static final MemberServiceImpl memberServiceImpl = new MemberServiceImpl(MemoryMemberRepository.getInstance());

  private final MemberRepository memberRepository;
  private final Gson gson = new Gson();

  public MemberServiceImpl(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  public static MemberServiceImpl getInstance() {
    return memberServiceImpl;
  }


  @Override
  public String findAll() {
    return gson.toJson(memberRepository.findAll(), List.class);
  }

  @Override
  public String findByName(String name) {
    return gson.toJson(memberRepository.findByName(name));
  }

  @Override
  public void join(JsonObject body) {
    Member member = gson.fromJson(body.toString(), Member.class);

    memberRepository.save(member);
  }

  public void upload(JsonArray jsonArray) {
    for (Object jsonObj : jsonArray) {
      memberRepository.save(gson.fromJson(jsonObj.toString(), Member.class));
    }
  }

  @Override
  public void update(JsonObject body) {
    Member member = gson.fromJson(body.toString(), Member.class);
    memberRepository.update(member);
  }

  @Override
  public void delete(String name) {
    memberRepository.delete(name);
  }
}
