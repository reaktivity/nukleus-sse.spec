# Server-Sent Events Nukleus Specification

[![Build Status][build-status-image]][build-status]
[![Code Coverage][code-coverage-image]][code-coverage]

[Server-Sent Events specification](https://html.spec.whatwg.org/multipage/server-sent-events.html#server-sent-events)

Also support for setting the initial value of `Last-Event-ID` via `lastEventId` query parameter. 
Also support for adding new field for timestamp with `accept:text/event-stream;ext=timestamp` and `content-type:text/event-stream;ext=timestamp`

```
data:example\n
timestamp:0x1619fe172c7\n
\n
```

#### Build
```bash
./mvnw clean install
```
#### Build on Windows
```bash
mvnw.cmd clean install
```

[build-status-image]: https://travis-ci.org/reaktivity/nukleus-sse.spec.svg?branch=develop
[build-status]: https://travis-ci.org/reaktivity/nukleus-sse.spec
[code-coverage-image]: https://codecov.io/gh/reaktivity/nukleus-sse.spec/branch/develop/graph/badge.svg
[code-coverage]: https://codecov.io/gh/reaktivity/nukleus-sse.spec
