package kr.or.ddit.servlet05.service;

import java.io.InputStream;
import java.util.Properties;

import kr.or.ddit.servlet01.DescriptionServlet;

public class PropertiesServiceImpl implements PropertiesService {

	@Override
	public Properties retrieveData() {
		Properties properties = new Properties();
		try (InputStream is = DescriptionServlet.class.getResourceAsStream("/kr/or/ddit/props/Message_en.properties");) {
			properties.load(is);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		return properties;
	}
}
