package com.example.demo.common;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonObjectMapper {
//	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public String getJsonStr(Object object) {
		String result = null;
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
		try {
//			logger.debug("ObjectMapperUtil >> jsonStr 변환시도");
			result = objectMapper.writeValueAsString(object);
//			logger.debug("ObjectMapperUtil >> jsonStr 변환성공 :: {}", result);
		} catch (Exception e) {
//			logger.error("ObjectMapperUtil >> jsonStr 변환실패");
			result = "";
		}

		return result;
	}
}
