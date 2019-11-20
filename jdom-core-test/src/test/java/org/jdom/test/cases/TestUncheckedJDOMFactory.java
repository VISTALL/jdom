package org.jdom.test.cases;

import org.jdom.JDOMFactory;
import org.jdom.UncheckedJDOMFactory;

@SuppressWarnings("javadoc")
public class TestUncheckedJDOMFactory extends AbstractTestJDOMFactory {

	/**
	 * @param located
	 */
	public TestUncheckedJDOMFactory() {
		super(false);
	}

	@Override
	protected JDOMFactory buildFactory() {
		return new UncheckedJDOMFactory();
	}
	
}
