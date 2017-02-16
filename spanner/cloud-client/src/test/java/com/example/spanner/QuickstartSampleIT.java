/*
  Copyright 2017, Google, Inc.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/

package com.example.spanner;

import static com.google.common.truth.Truth.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Tests for quickstart sample.
 */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class QuickstartSampleIT {
  private String instanceId = System.getProperty("spanner.test.instance");
  // This database needs to exist for test to pass.
  private String dbId = System.getProperty("spanner.quickstart.database");
  private ByteArrayOutputStream bout;
  private PrintStream out;

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
  }

  @After
  public void tearDown() {
    System.setOut(null);
  }

  @Test
  public void testQuickstart() throws Exception {
    assertThat(instanceId).isNotNull();
    assertThat(dbId).isNotNull();
    QuickstartSample.main(instanceId, dbId);
    String got = bout.toString();
    assertThat(got).contains("1");
  }
}