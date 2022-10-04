package com.kt.vertxStarter;

import com.kt.vertxStarter.service.MemberService;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.TimeoutHandler;

public class MainVerticle extends AbstractVerticle {

  private final AppConfig appConfig = new AppConfig();
  private final MemberService memberService = appConfig.memberService();
  public static void main(String[] args) {
    Vertx.vertx().deployVerticle(new MainVerticle());
  }

  @Override
  public void start(Promise<Void> startPromise) throws Exception {

    loadJsonFile("/Users/osanghyun/KT/Projects/VertX/vertxStarter/src/main/resources/data.json");

    Router router = Router.router(vertx);

    router.route().handler(TimeoutHandler.create(5000));
    router.get("/member").handler(this::findAll);
    router.get("/member/:name").handler(this::findByName);

    router.route().handler(BodyHandler.create());
    router.post("/member").handler(this::createMember);
    router.put("/member").handler(this::updateMember);
    router.delete("/member").handler(this::deleteMember);

    vertx.createHttpServer().requestHandler(router).listen(9090);
  }

  private void findAll(RoutingContext ctx) {
    ctx.response()
      .setStatusCode(200)
      .putHeader("content-type", "application/json")
      .end(memberService.findAll());
  }

  private void findByName(RoutingContext ctx) {
    String name = ctx.pathParam("name");
    ctx.response()
      .setStatusCode(200)
      .putHeader("content-type", "application/json")
      .end(memberService.findByName(name));
  }

  private void createMember(RoutingContext ctx) {
    JsonObject member = ctx.body().asJsonObject();
    memberService.join(member);

    ctx.response()
      .setStatusCode(200)
      .putHeader("content-type", "text/plain; charset=utf-8")
      .end("Create Success");
  }

  private void updateMember(RoutingContext ctx) {
    JsonObject member = ctx.body().asJsonObject();
    memberService.update(member);

    ctx.response()
      .setStatusCode(200)
      .putHeader("content-type", "text/plain; charset=utf-8")
      .end("Update Success");
  }

  private void deleteMember(RoutingContext ctx) {
    String name = ctx.body().asJsonObject().getString("name");
    memberService.delete(name);

    ctx.response()
      .setStatusCode(200)
      .putHeader("content-type", "text/plain; charset=utf-8")
      .end("Delete Success");
  }

  private void loadJsonFile(String path){
    vertx.fileSystem().readFile(path, result -> {
      if (result.succeeded()) {
        memberService.upload(result.result().toJsonArray());
      } else {
        System.err.println("data.json readFile Error" + result.cause());
      }
    });
  }
}
