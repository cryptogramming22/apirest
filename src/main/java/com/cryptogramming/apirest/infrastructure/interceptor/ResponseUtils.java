package com.cryptogramming.apirest.infrastructure.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class ResponseUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void writeErrorResponse(HttpServletResponse response, int statusCode, String errorMessage) {
        response.setStatus(statusCode);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter writer = response.getWriter()) {
            writer.println(objectMapper.writeValueAsString(Map.of("error", errorMessage)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
