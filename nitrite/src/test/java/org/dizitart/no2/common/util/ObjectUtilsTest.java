/*
 *
 * Copyright 2017-2018 Nitrite author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.dizitart.no2.common.util;

import org.junit.Test;

import static org.dizitart.no2.common.util.ObjectUtils.isKeyedRepository;
import static org.dizitart.no2.common.util.ObjectUtils.isRepository;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Anindya Chatterjee.
 */
public class ObjectUtilsTest {

    @Test
    public void testIsObjectStore() {
        assertFalse(isRepository(""));
        assertFalse(isRepository(null));
        assertFalse(isRepository("abcd"));
        assertTrue(isRepository("java.lang.String"));
        assertTrue(isRepository("java.lang.String+key"));
        assertFalse(isRepository("java.lang.String-key"));
    }

    @Test
    public void testIsKeyedObjectStore() {
        assertTrue(isKeyedRepository("java.lang.String+key"));
        assertFalse(isKeyedRepository("java.lang.String2+key"));
        assertFalse(isKeyedRepository("java.lang.String"));
        assertFalse(isKeyedRepository(null));
        assertFalse(isKeyedRepository(""));
        assertFalse(isKeyedRepository("abcd"));
        assertFalse(isKeyedRepository("+"));
        assertFalse(isKeyedRepository("abcd+e"));
    }

}
