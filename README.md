Running `SpringPulsarTransactionApplicationTests` produces those logs :

```
2026-04-08T09:32:00.909+09:00 DEBUG 45296 --- [spring-pulsar-transaction] [r-client-io-1-3] p.c.i.t.TransactionCoordinatorClientImpl : Transaction meta store assign partition is 1.
2026-04-08T09:32:02.825+09:00  INFO 45296 --- [spring-pulsar-transaction] [r-client-io-1-3] o.a.pulsar.client.impl.ConsumerImpl      : [persistent://public/default/test-topic][message] Subscribing to topic on cnx [id: 0x0106da62, L:/127.0.0.1:55118 - R:localhost/127.0.0.1:37673], consumerId 0
2026-04-08T09:32:03.092+09:00  INFO 45296 --- [spring-pulsar-transaction] [r-client-io-1-5] o.a.pulsar.client.impl.ConsumerImpl      : [persistent://public/default/test-topic][message] Subscribed to topic on localhost/127.0.0.1:37673 -- consumer: 0
2026-04-08T09:32:03.093+09:00 DEBUG 45296 --- [spring-pulsar-transaction] [r-client-io-1-5] o.a.pulsar.client.impl.ConsumerImpl      : [persistent://public/default/test-topic] Sending permit-cmd to broker with available permits = 1000
2026-04-08T09:32:03.093+09:00 DEBUG 45296 --- [spring-pulsar-transaction] [r-client-io-1-5] o.a.pulsar.client.impl.ConsumerImpl      : [persistent://public/default/test-topic] [message] Adding 1000 additional permits
2026-04-08T09:32:03.096+09:00 DEBUG 45296 --- [spring-pulsar-transaction] [r-client-io-1-5] o.a.pulsar.client.impl.ConsumerImpl      : Consumer 0 sent 1000 permits to broker
2026-04-08T09:32:03.522+09:00 DEBUG 45296 --- [spring-pulsar-transaction] [r-client-io-1-5] o.a.pulsar.client.impl.ConsumerImpl      : [persistent://public/default/test-topic][message] Received message: 6:0
2026-04-08T09:32:03.645+09:00 DEBUG 45296 --- [spring-pulsar-transaction] [t-internal-27-1] o.a.p.c.i.t.TransactionBuilderImpl       : 'newTransaction' command completed successfully for transaction: (0,0)
2026-04-08T09:32:03.651+09:00  INFO 45296 --- [spring-pulsar-transaction] [ntainer#0-0-C-1] c.g.r.s.listener.MessageListener         : Received message ID 6:0:-1, with txn ID (0,0) and txn state OPEN
2026-04-08T09:32:03.753+09:00 DEBUG 45296 --- [spring-pulsar-transaction] [r-client-io-1-5] o.a.pulsar.client.impl.ConsumerImpl      : [persistent://public/default/test-topic][message] Received message: 6:1
2026-04-08T09:32:03.959+09:00 DEBUG 45296 --- [spring-pulsar-transaction] [t-internal-27-1] o.a.p.c.i.t.TransactionBuilderImpl       : 'newTransaction' command completed successfully for transaction: (0,1)
2026-04-08T09:32:03.960+09:00  INFO 45296 --- [spring-pulsar-transaction] [ntainer#0-0-C-1] c.g.r.s.listener.MessageListener         : Received message ID 6:1:-1, with txn ID (0,1) and txn state OPEN
2026-04-08T09:32:04.009+09:00  INFO 45296 --- [spring-pulsar-transaction] [r-client-io-1-5] o.a.pulsar.client.impl.ConsumerImpl      : [persistent://public/default/test-topic] [message] Closed consumer
```
