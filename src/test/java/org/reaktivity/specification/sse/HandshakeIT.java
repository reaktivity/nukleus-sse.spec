/**
 * Copyright 2016-2020 The Reaktivity Project
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

public class HandshakeIT
{
    private final K3poRule k3po = new K3poRule()
        .addScriptRoot("scripts", "org/reaktivity/specification/sse/handshake");

    private final TestRule timeout = new DisableOnDebug(new Timeout(10, SECONDS));

    @Rule
    public final TestRule chain = outerRule(k3po).around(timeout);

    @Test
    @Specification({
        "${scripts}/connection.succeeded/request",
        "${scripts}/connection.succeeded/response" })
    @ScriptProperty("serverTransport \"nukleus://streams/sse#0\"")
    public void shouldHandshake() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/cors.preflight/request",
        "${scripts}/cors.preflight/response" })
    @ScriptProperty("serverTransport \"nukleus://streams/sse#0\"")
    public void shouldHandshakeWithCorsPreflight() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/request.method.unsupported/request",
        "${scripts}/request.method.unsupported/response" })
    @ScriptProperty("serverTransport \"nukleus://streams/sse#0\"")
    public void shouldFailHandshakeWhenRequestMethodUnsupported() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/request.header.last.event.id/request",
        "${scripts}/request.header.last.event.id/response" })
    @ScriptProperty("serverTransport \"nukleus://streams/sse#0\"")
    public void shouldHandshakeWithRequestHeaderLastEventId() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/request.header.last.event.id.overflow/request",
        "${scripts}/request.header.last.event.id.overflow/response" })
    @ScriptProperty("serverTransport \"nukleus://streams/sse#0\"")
    public void shouldFailHandshakeWithRequestHeaderLastEventIdOverflow() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/request.header.last.event.id.overflow.multibyte/request",
        "${scripts}/request.header.last.event.id.overflow.multibyte/response" })
    @ScriptProperty("serverTransport \"nukleus://streams/sse#0\"")
    public void shouldFailHandshakeWithRequestHeaderLastEventIdOverflowMultibyte() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/initial.comment/request",
        "${scripts}/initial.comment/response" })
    @ScriptProperty("serverTransport \"nukleus://streams/sse#0\"")
    public void shouldSendInitialComment() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/request.parameter.last.event.id/request",
        "${scripts}/request.parameter.last.event.id/response" })
    @ScriptProperty("serverTransport \"nukleus://streams/sse#0\"")
    public void shouldHandshakeWithRequestParameterLastEventId() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/request.parameter.last.event.id.empty/request",
        "${scripts}/request.parameter.last.event.id.empty/response" })
    @ScriptProperty("serverTransport \"nukleus://streams/sse#0\"")
    public void shouldHandshakeWithRequestParameterLastEventIdEmpty() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/request.parameter.last.event.id.overflow/request",
        "${scripts}/request.parameter.last.event.id.overflow/response" })
    @ScriptProperty("serverTransport \"nukleus://streams/sse#0\"")
    public void shouldFailHandshakeWithRequestParameterLastEventIdOverflow() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/request.parameter.last.event.id.url.encoded/request",
        "${scripts}/request.parameter.last.event.id.url.encoded/response" })
    @ScriptProperty("serverTransport \"nukleus://streams/sse#0\"")
    public void shouldHandshakeWithURLEncodedRequestParameterLastEventId() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/response.header.content.type.missing/request",
        "${scripts}/response.header.content.type.missing/response" })
    @ScriptProperty("serverTransport \"nukleus://streams/sse#0\"")
    public void shouldFailHandshakeWhenResponseHeaderContentTypeMissing() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }

    @Test
    @Specification({
        "${scripts}/response.header.content.type.unsupported/request",
        "${scripts}/response.header.content.type.unsupported/response" })
    @ScriptProperty("serverTransport \"nukleus://streams/sse#0\"")
    public void shouldFailHandshakeWhenResponseHeaderContentTypeUnsupported() throws Exception
    {
        k3po.start();
        k3po.notifyBarrier("ROUTED_SERVER");
        k3po.finish();
    }
}
