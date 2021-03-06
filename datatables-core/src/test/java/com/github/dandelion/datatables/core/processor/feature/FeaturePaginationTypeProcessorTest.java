/*
 * [The "BSD licence"]
 * Copyright (c) 2012 Dandelion
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 * 1. Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * 3. Neither the name of Dandelion nor the names of its contributors 
 * may be used to endorse or promote products derived from this software 
 * without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.github.dandelion.datatables.core.processor.feature;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import com.github.dandelion.datatables.core.exception.AttributeProcessingException;
import com.github.dandelion.datatables.core.extension.feature.PaginationType;
import com.github.dandelion.datatables.core.processor.Processor;
import com.github.dandelion.datatables.core.processor.ProcessorBaseTest;

public class FeaturePaginationTypeProcessorTest extends ProcessorBaseTest {

	@Override
	public Processor getProcessor() {
		return new FeaturePaginationTypeProcessor();
	}

	@Test
	public void should_set_null_when_value_is_null() throws Exception {
		processor.process(null, tableConfiguration, confToBeApplied);
		assertThat(tableConfiguration.getFeaturePaginationType()).isNull();
	}
	
	@Test
	public void should_set_null_when_value_is_empty() throws Exception {
		processor.process("", tableConfiguration, confToBeApplied);
		assertThat(tableConfiguration.getFeaturePaginationType()).isNull();
	}
	
	@Test
	public void should_set_paginationtype() throws Exception {
		processor.process("bootstrap", tableConfiguration, confToBeApplied);
		assertThat(tableConfiguration.getFeaturePaginationType()).isEqualTo(PaginationType.BOOTSTRAP);
		processor.process("BOOTSTRAP", tableConfiguration, confToBeApplied);
		assertThat(tableConfiguration.getFeaturePaginationType()).isEqualTo(PaginationType.BOOTSTRAP);
		processor.process("input", tableConfiguration, confToBeApplied);
		assertThat(tableConfiguration.getFeaturePaginationType()).isEqualTo(PaginationType.INPUT);
		processor.process("listbox", tableConfiguration, confToBeApplied);
		assertThat(tableConfiguration.getFeaturePaginationType()).isEqualTo(PaginationType.LISTBOX);
		processor.process("scrolling", tableConfiguration, confToBeApplied);
		assertThat(tableConfiguration.getFeaturePaginationType()).isEqualTo(PaginationType.SCROLLING);
		processor.process("four_button", tableConfiguration, confToBeApplied);
		assertThat(tableConfiguration.getFeaturePaginationType()).isEqualTo(PaginationType.FOUR_BUTTON);
		processor.process("two_button", tableConfiguration, confToBeApplied);
		assertThat(tableConfiguration.getFeaturePaginationType()).isEqualTo(PaginationType.TWO_BUTTON);
		processor.process("full_numbers", tableConfiguration, confToBeApplied);
		assertThat(tableConfiguration.getFeaturePaginationType()).isEqualTo(PaginationType.FULL_NUMBERS);
	}
	
	@Test(expected = AttributeProcessingException.class)
	public void should_raise_an_exception() throws Exception {
		processor.process("booootstrap", tableConfiguration, confToBeApplied);
	}
}
