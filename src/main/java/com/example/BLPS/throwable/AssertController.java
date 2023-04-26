package com.example.BLPS.throwable;

import com.example.BLPS.throwable.exception.GetArticleValidateRequestParamException;
import com.example.BLPS.throwable.exception.NotNullRequestParamException;

import java.util.Arrays;
import java.util.Map;

public class AssertController {

    //В пост запросе не может быть пустых параметров
    public static void nullRequestParam(Map <String, String> requestParam) {

        if (requestParam.size() > 0)
            throw new NotNullRequestParamException(Arrays.toString(requestParam.keySet().toArray()));
    }

    //Валидация GET параметров GET запроса article
    public static void getArticleValidateRequestParam(Map <String, String> requestParam) {
        if (requestParam.containsKey("name") && requestParam.containsKey("tags") && requestParam.size() == 2)
            return;
        if (requestParam.containsKey("name") && requestParam.size() == 1)
            return;
        if (requestParam.containsKey("tags") && requestParam.size() == 1)
            return;
        if (requestParam.size() == 0)
            return;
        throw new GetArticleValidateRequestParamException("[name, tags]");
    }
}
