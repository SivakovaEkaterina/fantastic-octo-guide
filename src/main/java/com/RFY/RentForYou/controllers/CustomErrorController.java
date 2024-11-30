/*
package com.RFY.RentForYou.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute("javax.servlet.error.status_code");
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            // Проверяем код статуса
            if (statusCode == 403) {
                return "403"; // Возвращаем страницу для ошибки 403
            }
        }
        return null; // Возвращаем страницу по умолчанию для остальных ошибок
    }
}
*/
