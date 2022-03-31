package com.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.model.CustomerUnite;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class GsonUtil {

	private static final Logger logger = Logger.getLogger(GsonUtil.class);

	public static void main(String[] args) {
		// String jsonData = "{'name':'yang','age':2}";
		// Map<String, String> map = parseGsonToMap(jsonData);
		// System.out.println(map);

		CustomerUnite c = new CustomerUnite();
		c.setId(1L);

		String s = GsonUtil.toJSON(c);

		Map c_map = (Map) GsonUtil.parseGsonToMap(s);

		CustomerUnite customerUnite = GsonUtil.fromJSON(s, CustomerUnite.class);
	}

	/**
	 * 
	 * 函数名称: gsonToMap 函数描述: 将json字符串转换为map
	 * 
	 * @param data
	 * @return
	 */
	public static Map<String, String> parseGsonToMap(String data) {
		GsonBuilder gb = new GsonBuilder();
		Gson g = gb.create();
		Map<String, String> map = g.fromJson(data,
				new TypeToken<HashMap<String, String>>() {
				}.getType());
		return map;
	}

	public static <T> T fromJSON(String json, Class<T> clazz) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(json, clazz);
		} catch (JsonParseException e) {
			throw new RuntimeException(e);
		} catch (JsonMappingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static String toJSON(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		StringWriter writer = new StringWriter();
		try {
			mapper.writeValue(writer, obj);
		} catch (JsonGenerationException e) {
			throw new RuntimeException(e);
		} catch (JsonMappingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return writer.toString();
	}

}
