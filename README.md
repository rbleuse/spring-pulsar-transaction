Running `SpringPulsarTransactionApplicationTests` produces those logs :

```
2026-04-07T14:11:31.607+09:00 DEBUG 29672 --- [spring-pulsar-transaction] [r-client-io-1-3] p.c.i.t.TransactionCoordinatorClientImpl : Transaction meta store assign partition is 1.
2026-04-07T14:11:33.444+09:00  INFO 29672 --- [spring-pulsar-transaction] [r-client-io-1-3] o.a.pulsar.client.impl.ConsumerImpl      : [persistent://public/default/test-topic][message] Subscribing to topic on cnx [id: 0x3d8a4425, L:/127.0.0.1:50169 - R:localhost/127.0.0.1:44473], consumerId 0
2026-04-07T14:11:33.690+09:00  INFO 29672 --- [spring-pulsar-transaction] [r-client-io-1-5] o.a.pulsar.client.impl.ConsumerImpl      : [persistent://public/default/test-topic][message] Subscribed to topic on localhost/127.0.0.1:44473 -- consumer: 0
2026-04-07T14:11:33.691+09:00 DEBUG 29672 --- [spring-pulsar-transaction] [r-client-io-1-5] o.a.pulsar.client.impl.ConsumerImpl      : [persistent://public/default/test-topic] Sending permit-cmd to broker with available permits = 1000
2026-04-07T14:11:33.691+09:00 DEBUG 29672 --- [spring-pulsar-transaction] [r-client-io-1-5] o.a.pulsar.client.impl.ConsumerImpl      : [persistent://public/default/test-topic] [message] Adding 1000 additional permits
2026-04-07T14:11:33.694+09:00 DEBUG 29672 --- [spring-pulsar-transaction] [r-client-io-1-5] o.a.pulsar.client.impl.ConsumerImpl      : Consumer 0 sent 1000 permits to broker
2026-04-07T14:11:34.147+09:00 DEBUG 29672 --- [spring-pulsar-transaction] [r-client-io-1-5] o.a.pulsar.client.impl.ConsumerImpl      : [persistent://public/default/test-topic][message] Received message: 6:0
2026-04-07T14:11:34.247+09:00 DEBUG 29672 --- [spring-pulsar-transaction] [t-internal-27-1] o.a.p.c.i.t.TransactionBuilderImpl       : 'newTransaction' command completed successfully for transaction: (0,0)
2026-04-07T14:11:34.253+09:00  INFO 29672 --- [spring-pulsar-transaction] [ntainer#0-0-C-1] c.g.r.s.listener.MessageListener         : Received message ID 6:0:-1
txn = (0,0), state = OPEN
2026-04-07T14:11:34.336+09:00 DEBUG 29672 --- [spring-pulsar-transaction] [r-client-io-1-5] o.a.pulsar.client.impl.ConsumerImpl      : [persistent://public/default/test-topic][message] Received message: 6:1
2026-04-07T14:11:34.531+09:00 DEBUG 29672 --- [spring-pulsar-transaction] [t-internal-27-1] o.a.p.c.i.t.TransactionBuilderImpl       : 'newTransaction' command completed successfully for transaction: (0,1)
2026-04-07T14:11:34.532+09:00  INFO 29672 --- [spring-pulsar-transaction] [ntainer#0-0-C-1] c.g.r.s.listener.MessageListener         : Received message ID 6:1:-1
txn = (0,1), state = OPEN
```
