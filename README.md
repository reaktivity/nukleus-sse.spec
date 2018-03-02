# Server Sent Events Nukleus Specification

[![Build Status][build-status-image]][build-status]

See official [Server-sent events specification](https://html.spec.whatwg.org/multipage/server-sent-events.html#server-sent-events).

Also support for setting the initial value of `Last-Event-ID` via `lastEventId` query parameter. 
Also support for adding new field for timestamp with `accept:text/event-stream;ext=timestamp` and `content-type:text/event-stream;ext=timestamp`

```
data:example\n
timestamp:0x1619fe172c7\n
\n
```

[build-status-image]: https://travis-ci.org/reaktivity/nukleus-sse.spec.svg?branch=develop
[build-status]: https://travis-ci.org/reaktivity/nukleus-sse.spec
