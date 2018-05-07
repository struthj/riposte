package com.nike.helloworld.controllers;

import com.google.gson.Gson;
import com.nike.helloworld.models.ProductItem;
import com.nike.riposte.server.http.RequestInfo;
import com.nike.riposte.server.http.ResponseInfo;
import com.nike.riposte.server.http.StandardEndpoint;
import com.nike.riposte.util.Matcher;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpMethod;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class ProductsEndpoint {

    public static final String MATCHING_PATH = "/products";

    public static class Get extends StandardEndpoint<Void, String> {

        private static final Matcher MATCHER = Matcher.match(MATCHING_PATH, HttpMethod.GET);

        //Use GSON for object deserialization
        private Gson gson = new Gson();

        @Override
        public Matcher requestMatcher() {
            return MATCHER;
        }

        @Override
        public CompletableFuture<ResponseInfo<String>> execute(
                RequestInfo<Void> requestInfo,
                Executor longRunningTaskExecutor,
                ChannelHandlerContext context)
        {
            return CompletableFuture.completedFuture(
                    ResponseInfo.newBuilder(
                            gson.toJson( new ProductItem("1","Running Shoe", "Shoes","Men's running shoe"))
                    ).withDesiredContentWriterMimeType("text/plain").build()
            );
        }
    }

}
