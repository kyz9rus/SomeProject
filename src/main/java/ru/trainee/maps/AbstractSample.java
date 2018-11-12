package ru.trainee.maps;

import com.google.common.base.Joiner;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractSample {
    protected static String encodeParams(final Map<String, String> params) {
        final String paramsUrl = Joiner.on('&').join(// получаем значение вида key1=value1&key2=value2...
                params.entrySet().stream().map(input -> {
                    try {
                        final StringBuffer buffer = new StringBuffer();
                        buffer.append(input.getKey());// получаем значение вида key=value
                        buffer.append('=');
                        buffer.append(URLEncoder.encode(input.getValue(), "utf-8"));// кодирует строку в
                        // соответствии со стандартом
                        // HTML 4.01
                        return buffer.toString();
                    } catch (final UnsupportedEncodingException e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toList()));
        return paramsUrl;
    }
}