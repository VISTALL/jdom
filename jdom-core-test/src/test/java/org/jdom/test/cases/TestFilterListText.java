package org.jdom.test.cases;

import java.util.List;

import org.jdom.Element;
import org.jdom.Text;
import org.jdom.filter.Filters;
import org.jdom.test.util.AbstractTestList;

@SuppressWarnings("javadoc")
public class TestFilterListText extends AbstractTestList<Text> {
	
	public TestFilterListText() {
		super(Text.class, false);
	}

	@Override
	public List<Text> buildEmptyList() {
		Element root = new Element("root");
		return root.getContent(Filters.text());
	}

	@Override
	public Text[] buildSampleContent() {
		return new Text[] {
				new Text("kida"),
				new Text("kidb"),
				new Text("kidc"),
				new Text("kidd"),
				new Text("kide"),
				new Text("kidf"),
				new Text("kidg"),
				new Text("kidh"),
				new Text("kidi"),
				new Text("kidj"),
		};
	}
	
	@Override
	public Text[] buildAdditionalContent() {
		return new Text[] { };
	}

	@Override
	public Text[] buildIllegalArgumentContent() {
		return new Text[] { };
	}

	@Override
	public Object[] buildIllegalClassContent() {
		return new Object[] {};
	}


}
