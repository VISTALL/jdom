package org.jdom.test.cases.xpath;

import org.jdom.JDOMException;
import org.jdom.xpath.XPath;
import org.jdom.xpath.jaxen.JDOMXPath;

/**
 * 
 * @author Rolf Lear
 * @deprecated in lieu of TestJaxenCompiled
 */
@Deprecated
public class TestLocalJaxenXPath extends AbstractTestXPath {
	
	@Override
	@Deprecated
	XPath buildPath(String path) throws JDOMException {
		final XPath ret = new JDOMXPath(path);
		return ret;
	}
	
}
