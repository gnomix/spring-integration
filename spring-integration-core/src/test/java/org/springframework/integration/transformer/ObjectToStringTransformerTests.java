/*
 * Copyright 2002-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.integration.transformer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import org.springframework.integration.Message;
import org.springframework.integration.message.GenericMessage;

/**
 * @author Mark Fisher
 */
public class ObjectToStringTransformerTests {

	@Test
	public void stringPayload() {
		Transformer transformer = new ObjectToStringTransformer();
		Message<?> result = transformer.transform(new GenericMessage<String>("foo"));
		assertEquals("foo", result.getPayload());
	}

	@Test
	public void objectPayload() {
		Transformer transformer = new ObjectToStringTransformer();
		Message<?> result = transformer.transform(new GenericMessage<TestBean>(new TestBean()));
		assertEquals("test", result.getPayload());
	}


	private static class TestBean {

		public String toString() {
			return "test";
		}
	}

}
