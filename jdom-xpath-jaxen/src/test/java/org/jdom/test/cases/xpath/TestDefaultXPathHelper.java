package org.jdom.test.cases.xpath;

import org.jdom.xpath.XPathFactory;

@SuppressWarnings("javadoc")
public class TestDefaultXPathHelper extends AbstractTestXPathHepler {
	@Override
	XPathFactory getFactory() {
		return XPathFactory.instance();
	}
}
