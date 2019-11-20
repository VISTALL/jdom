package org.jdom.test.cases.xpath;

import org.jdom.xpath.XPathFactory;
import org.jdom.xpath.jaxen.JaxenXPathFactory;

@SuppressWarnings("javadoc")
public class TestJaxenXPathHelper extends AbstractTestXPathHepler {
	@Override
	XPathFactory getFactory() {
		return XPathFactory.newInstance(JaxenXPathFactory.class.getName());
	}
}
