package org.jdom.test.cases;

import org.jdom.DefaultJDOMFactory;
import org.jdom.JDOMFactory;

@SuppressWarnings("javadoc")
public class TestDefaultJDOMFactory extends AbstractTestJDOMFactory {

	/**
	 * @param located
	 */
	public TestDefaultJDOMFactory() {
		super(false);
	}

	@Override
	protected JDOMFactory buildFactory() {
		return new DefaultJDOMFactory();
	}
	
}
