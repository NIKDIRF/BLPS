package com.example.BLPS.throwable;

import com.example.BLPS.throwable.exception.GetArticleValidateRequestParamException;
import com.example.BLPS.throwable.exception.NotNullRequestParamException;
import com.example.BLPS.throwable.exception.NotPageParamException;
import com.example.BLPS.throwable.exception.ParsePageParamException;

import java.util.Arrays;
import java.util.Map;

public class AssertController {

    public static void nullRequestParam(Map <String, String> requestParam) {
        if (requestParam.size() > 0)
            throw new NotNullRequestParamException(Arrays.toString(requestParam.keySet().toArray()));
    }

    public static void getArticleValidateRequestParam(Map <String, String> requestParam) {
        if (!requestParam.containsKey("page"))
            throw new NotPageParamException();

        checkParseToInt(requestParam.get("page"));

        if (requestParam.containsKey("page") && requestParam.containsKey("name") && requestParam.containsKey("tags") && requestParam.size() == 3)
            return;
        if (requestParam.containsKey("page") && requestParam.containsKey("name") && requestParam.size() == 2)
            return;
        if (requestParam.containsKey("page") && requestParam.containsKey("tags") && requestParam.size() == 2)
            return;
        if (requestParam.containsKey("page") && requestParam.size() == 1)
            return;
        throw new GetArticleValidateRequestParamException("[name, tags, page]");
    }

    private static void checkParseToInt(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            throw new ParsePageParamException();
        }
    }
}
