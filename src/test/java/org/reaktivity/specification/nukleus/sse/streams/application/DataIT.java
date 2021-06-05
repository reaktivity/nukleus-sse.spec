/**
 * Copyright 2016-2021 The Reaktivity Project
 *
 * The Reaktivity Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.reaktivity.specification.nukleus.sse.streams.application;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.rules.RuleChain.outerRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.kaazing.k3po.junit.annotation.Specification;
import org.kaazing.k3po.junit.rules.K3poRule;

public class DataIT
{
    private final K3poRule k3po = new K3poRule()
        .addScriptRoot("app", "org/reaktivity/specification/nukleus/sse/streams/application/data");

    private final TestRule timeout = new DisableOnDebug(new Timeout(5, SECONDS));

    @Rule
    public final TestRule chain = outerRule(k3po).around(timeout);

    @Test
    @Specification({
        "${app}/name.only/request",
        "${app}/name.only/response" })
    public void shouldReceiveDataNameOnly() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${app}/empty/request",
        "${app}/empty/response" })
    public void shouldReceiveEmptyData() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${app}/non.empty/request",
        "${app}/non.empty/response" })
    public void shouldReceiveNonEmptyData() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${app}/fragmented/request",
        "${app}/fragmented/response" })
    public void shouldReceiveFragmentedData() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${app}/invalid.utf8/request",
        "${app}/invalid.utf8/response" })
    public void shouldRejectDataWithInvalidUTF8() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${app}/initial.whitespace/request",
        "${app}/initial.whitespace/response" })
    public void shouldReceiveDataWithInitialWhitespace() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${app}/multi.line/request",
        "${app}/multi.line/response" })
    public void shouldReceiveMultiLineData() throws Exception
    {
        k3po.finish();
    }
}
