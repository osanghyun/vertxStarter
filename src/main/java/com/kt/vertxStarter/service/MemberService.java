package com.kt.vertxStarter.service;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

public interface MemberService {

  String findAll();

  String findByName(String name);

  void join(JsonObject body);

  void upload(JsonArray arr);

  void update(JsonObject body);

  void delete(String name);
}
