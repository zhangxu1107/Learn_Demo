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
			// 1.����sax��ȡ����
			SAXReader reader = new SAXReader(); // jdbc-----classloader
			// 2.ָ��������xmlԴ
			Document document = reader.read(new File("src/xml/stus.xml"));
			// 3.�õ�Ԫ��
			// �õ���Ԫ��
			Element rootElement = document.getRootElement();
			
			//��Ҫʹ��Xpath ,�ǵ����֧�ֵ�jar ��ȡ���ǵ�һ�� ��ֻ����һ��
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
