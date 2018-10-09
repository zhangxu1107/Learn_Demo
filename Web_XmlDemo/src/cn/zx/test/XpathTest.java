package cn.zx.test;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XpathTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		try {
			// 1.创建sax读取对象
			SAXReader reader = new SAXReader(); // jdbc-----classloader
			// 2.指定解析的xml源
			Document document = reader.read(new File("src/xml/stus.xml"));
			// 3.得到元素
			// 得到根元素
			Element rootElement = document.getRootElement();
			
			//想要使用Xpath ,记得添加支持的jar 获取的是第一个 ，只返回一个
			Element nameElement = (Element)rootElement.selectSingleNode("//name");
			System.out.println(nameElement.getText());
			
			System.out.println("----------------------");
			
			List<Element> nameElements = rootElement.selectNodes("//name");
			for (Element element : nameElements) {
				System.out.println(element.getText());
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
