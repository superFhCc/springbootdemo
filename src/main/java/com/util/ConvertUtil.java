package com.util;

import net.sf.json.JSONObject;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ConvertUtil {

	@SuppressWarnings({ "rawtypes" })
	public static HashMap objToHashMap(Object object) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		try {
			if(object!=null){
				JSONObject jsonObject = toJSONObject(object);
				Iterator it = jsonObject.keys();
				while (it.hasNext()) {
					String key = String.valueOf(it.next());
					Object value = jsonObject.get(key);


					data.put(key, value);
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return data;
	}

	public static Map jsonStringToHashMap(String str) {
		return GsonUtil.parseGsonToMap(str);
	}

	private static JSONObject toJSONObject(Object object) {
		return JSONObject.fromObject(object);
	}

	public static Map<String, String> objToMap(Object obj) {

		Map<String, String> map = new HashMap<String, String>();
		// System.out.println(obj.getClass());
		// 获取f对象对应类中的所有属性域
		Field[] fields = obj.getClass().getDeclaredFields();
		for (int i = 0, len = fields.length; i < len; i++) {
			String varName = fields[i].getName();
			try {
				// 获取原来的访问控制权限
				boolean accessFlag = fields[i].isAccessible();
				// 修改访问控制权限
				fields[i].setAccessible(true);
				// 获取在对象f中属性fields[i]对应的对象中的变量
				Object o = fields[i].get(obj);
				if (o != null)
					map.put(varName, o.toString());
				// System.out.println("传入的对象中包含一个如下的变量：" + varName + " = " + o);
				// 恢复访问控制权限
				fields[i].setAccessible(accessFlag);
			} catch (IllegalArgumentException ex) {
				ex.printStackTrace();
			} catch (IllegalAccessException ex) {
				ex.printStackTrace();
			}
		}
		return map;

	}

}
