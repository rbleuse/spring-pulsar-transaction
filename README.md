Running `SpringPulsarTransactionApplicationTests` produces those logs :

```
2026-04-08T16:03:08.189+09:00 DEBUG 27392 --- [spring-pulsar-transaction] [r-client-io-1-3] p.c.i.t.TransactionCoordinatorClientImpl : Transaction meta store assign partition is 1.
2026-04-08T16:03:10.342+09:00 DEBUG 27392 --- [spring-pulsar-transaction] [    Test worker] o.s.p.c.MethodPulsarListenerEndpoint     : Listener w/ id [org.springframework.Pulsar.PulsarListenerEndpointContainer#0] requested no transactions
2026-04-08T16:03:10.630+09:00  INFO 27392 --- [spring-pulsar-transaction] [r-client-io-1-3] o.a.pulsar.client.impl.ConsumerImpl      : [persistent://public/default/test-topic][message] Subscribing to topic on cnx [id: 0x6093eec6, L:/127.0.0.1:57146 - R:localhost/127.0.0.1:39027], consumerId 0
2026-04-08T16:03:11.048+09:00  INFO 27392 --- [spring-pulsar-transaction] [r-client-io-1-5] o.a.pulsar.client.impl.ConsumerImpl      : [persistent://public/default/test-topic][message] Subscribed to topic on localhost/127.0.0.1:39027 -- consumer: 0
2026-04-08T16:03:11.049+09:00 DEBUG 27392 --- [spring-pulsar-transaction] [r-client-io-1-5] o.a.pulsar.client.impl.ConsumerImpl      : [persistent://public/default/test-topic] Sending permit-cmd to broker with available permits = 1000
2026-04-08T16:03:11.049+09:00 DEBUG 27392 --- [spring-pulsar-transaction] [r-client-io-1-5] o.a.pulsar.client.impl.ConsumerImpl      : [persistent://public/default/test-topic] [message] Adding 1000 additional permits
2026-04-08T16:03:11.053+09:00 DEBUG 27392 --- [spring-pulsar-transaction] [r-client-io-1-5] o.a.pulsar.client.impl.ConsumerImpl      : Consumer 0 sent 1000 permits to broker
2026-04-08T16:03:11.677+09:00 DEBUG 27392 --- [spring-pulsar-transaction] [r-client-io-1-5] o.a.pulsar.client.impl.ConsumerImpl      : [persistent://public/default/test-topic][message] Received message: 6:0
2026-04-08T16:03:11.827+09:00 DEBUG 27392 --- [spring-pulsar-transaction] [t-internal-27-1] o.a.p.c.i.t.TransactionBuilderImpl       : 'newTransaction' command completed successfully for transaction: (0,0)
2026-04-08T16:03:11.836+09:00  INFO 27392 --- [spring-pulsar-transaction] [ntainer#0-0-C-1] c.g.r.s.listener.MessageListener         : Received message ID 6:0:-1, with txn ID (0,0) and txn state OPEN
2026-04-08T16:03:11.939+09:00 DEBUG 27392 --- [spring-pulsar-transaction] [r-client-io-1-5] o.a.pulsar.client.impl.ConsumerImpl      : [persistent://public/default/test-topic][message] Received message: 6:1
2026-04-08T16:03:12.161+09:00 DEBUG 27392 --- [spring-pulsar-transaction] [t-internal-27-1] o.a.p.c.i.t.TransactionBuilderImpl       : 'newTransaction' command completed successfully for transaction: (0,1)
2026-04-08T16:03:12.162+09:00  INFO 27392 --- [spring-pulsar-transaction] [ntainer#0-0-C-1] c.g.r.s.listener.MessageListener         : Received message ID 6:1:-1, with txn ID (0,1) and txn state OPEN
2026-04-08T16:03:12.215+09:00  INFO 27392 --- [spring-pulsar-transaction] [r-client-io-1-5] o.a.pulsar.client.impl.ConsumerImpl      : [persistent://public/default/test-topic] [message] Closed consumer
```
