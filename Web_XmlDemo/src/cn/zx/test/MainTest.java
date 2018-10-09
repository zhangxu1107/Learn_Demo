package cn.zx.test;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class MainTest {
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
			// ��ȡ��Ԫ���µ���Ԫ��age
			// System.out.println(rootElement.element("stu").element("age").getText());

			//��ȡ��Ԫ�������������Ԫ�ء�stuԪ��
			List<Element> elements = rootElement.elements();
			
			System.out.println(elements.size());
			
			//�������е�stuԪ��
			for (Element element : elements) {
				System.out.println(element.getName());
				//��ȡstu�µ�name Ԫ��
				String name = element.element("name").getText();
				String age = element.element("age").getText();
				String address = element.element("address").getText();
				System.out.println("name=" + name + "age=" + age + "address=" + address);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
