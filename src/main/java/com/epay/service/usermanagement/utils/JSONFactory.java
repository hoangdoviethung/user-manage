package com.epay.service.usermanagement.utils;
/**
 * duantp
 */

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class JSONFactory {
    private static JsonSerializer<Date> date2Timestamp = new JsonSerializer<Date>() {
        @Override
        public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
            return src == null ? null : new JsonPrimitive(src.getTime());
        }
    };

    private static JsonDeserializer<Date> timestamp2Date = new JsonDeserializer<Date>() {
        @Override
        public Date deserialize(JsonElement json, Type typeOfT,
                                JsonDeserializationContext context) throws JsonParseException {
            return json == null ? null : new Date(json.getAsLong());
        }
    };

    public static Gson create() {
        return new GsonBuilder()
                .registerTypeAdapter(Long.class, new BadLongDeserializer())
                .registerTypeAdapter(Date.class, date2Timestamp)
                .registerTypeAdapter(Date.class, timestamp2Date)
                .disableHtmlEscaping().create();
    }

    public static String toJson(Object object) {
        return create().toJson(object);
    }

    public static String toJsonJackson(Object object) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(Include.NON_NULL);
        return mapper.writeValueAsString(object);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T> T fromJSON(String json, Class<T> paramClass) throws JsonSyntaxException {
        return create().fromJson(json, paramClass);
    }

    public static <T> T fromJSON(String json, Type paramClass) throws JsonSyntaxException {
        return create().fromJson(json, paramClass);
    }

    public static Gson createGson() {
        GsonBuilder localGsonBuilder = new GsonBuilder().setDateFormat(DateFormat.FULL, DateFormat.FULL);
        return localGsonBuilder.disableHtmlEscaping().create();
    }

}

class BadLongDeserializer implements JsonDeserializer<Long> {
    @Override
    public Long deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        try {
            String str = element.getAsString();
            str = str.replaceAll(",", "");
            str = str.split("\\.")[0];
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            throw new JsonParseException(e);
        }
    }

}
