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
package org.reaktivity.specification.sse;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.rules.RuleChain.outerRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.kaazing.k3po.junit.annotation.ScriptProperty;
import org.kaazing.k3po.junit.annotation.Specification;
import org.kaazing.k3po.junit.rules.K3poRule;

public class IdIT
{
    private final K3poRule k3po = new K3poRule()
        .addScriptRoot("scripts", "org/reaktivity/specification/sse/id");

    private final TestRule timeout = new DisableOnDebug(new Timeout(10, SECONDS));

    @Rule
    public final TestRule chain = outerRule(k3po).around(timeout);

    @Test
    @Specification({
        "${scripts}/name.only/request",
        "${scripts}/name.only/response" })
    @ScriptProperty("serverTransport \"nukleus://streams/sse#0\"")
    public void shouldReceiveIdNameOnly() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/empty/request",
        "${scripts}/empty/response" })
    @ScriptProperty("serverTransport \"nukleus://streams/sse#0\"")
    public void shouldReceiveEmptyId() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/non.empty/request",
        "${scripts}/non.empty/response" })
    @ScriptProperty("serverTransport \"nukleus://streams/sse#0\"")
    public void shouldReceiveNonEmptyId() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/invalid.utf8/request",
        "${scripts}/invalid.utf8/response" })
    @ScriptProperty("serverTransport \"nukleus://streams/sse#0\"")
    public void shouldRejectIdWithInvalidUTF8() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/initial.whitespace/request",
        "${scripts}/initial.whitespace/response" })
    @ScriptProperty("serverTransport \"nukleus://streams/sse#0\"")
    public void shouldReceiveIdWithInitialWhitespace() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/reject.header.length.exceeding.255/request",
        "${scripts}/reject.header.length.exceeding.255/response" })
    @ScriptProperty("serverTransport \"nukleus://streams/sse#0\"")
    public void shouldRejectHeaderLengthExceeding255() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/reject.query.param.length.exceeding.255/request",
        "${scripts}/reject.query.param.length.exceeding.255/response" })
    @ScriptProperty("serverTransport \"nukleus://streams/sse#0\"")
    public void shouldRejectQueryParamLengthExceeding255() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }
}
