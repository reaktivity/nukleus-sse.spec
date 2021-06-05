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
package org.reaktivity.specification.nukleus.sse.streams.network;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.rules.RuleChain.outerRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.kaazing.k3po.junit.annotation.Specification;
import org.kaazing.k3po.junit.rules.K3poRule;

public class CustomIT
{
    private final K3poRule k3po = new K3poRule()
        .addScriptRoot("net", "org/reaktivity/specification/nukleus/sse/streams/network/custom");

    private final TestRule timeout = new DisableOnDebug(new Timeout(10, SECONDS));

    @Rule
    public final TestRule chain = outerRule(k3po).around(timeout);

    @Test
    @Specification({
        "${net}/name.only/request",
        "${net}/name.only/response" })
    public void shouldReceiveCustomFieldNameOnly() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${net}/empty/request",
        "${net}/empty/response" })
    public void shouldReceiveEmptyCustomField() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${net}/non.empty/request",
        "${net}/non.empty/response" })
    public void shouldReceiveNonEmptyCustomField() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${net}/invalid.utf8/request",
        "${net}/invalid.utf8/response" })
    public void shouldRejectCustomFieldWithInvalidUTF8() throws Exception
    {
        k3po.finish();
    }

    @Test
    @Specification({
        "${net}/initial.whitespace/request",
        "${net}/initial.whitespace/response" })
    public void shouldReceiveCustomFieldWithInitialWhitespace() throws Exception
    {
        k3po.finish();
    }
}