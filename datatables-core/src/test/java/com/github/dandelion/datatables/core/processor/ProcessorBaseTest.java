package com.github.dandelion.datatables.core.processor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.springframework.mock.web.MockPageContext;
import org.springframework.mock.web.MockServletContext;

import com.github.dandelion.datatables.core.configuration.Configuration;
import com.github.dandelion.datatables.core.configuration.TableConfiguration;

public abstract class ProcessorBaseTest {

	protected Processor processor;
	protected TableConfiguration tableConfiguration;
	protected HttpServletRequest request;
	protected Map<Configuration, Object> confToBeApplied;
	
	@Before
	public void setup() throws Exception{
		processor = getProcessor();
		MockServletContext mockServletContext = new MockServletContext();
		MockPageContext mockPageContext = new MockPageContext(mockServletContext);
		request = (HttpServletRequest) mockPageContext.getRequest();
		tableConfiguration = TableConfiguration.getInstance(request);
		confToBeApplied = new HashMap<Configuration, Object>();
	}
	
	public abstract Processor getProcessor() throws Exception;
}
