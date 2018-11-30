# FASTTACK
The FASTTACK platform performs primarily an integration role for the organization of interaction between the bank's systems and tokenization platforms VTS (VISA) and MDES (Mastercard) in a scheme where bank cards are digitized through a third-party provider of a mobile wallet. As part of this project, a third-party provider is Android Pay (Google).
Subsequently, the platform's capabilities can be extended to support the purses of other providers, for example, such as Android Pay, Samsung Pay, etc.

## Installing / Getting started
* Download servlet container such as JBOSS EAP or Apache Tomcat
* Download DBMS (PostgreSql or ORACLE)

To run JBOSS EAP
```shell
standalone.bat --server-config=standalone-full.xml --debug
```
To run Tomcat
```shell
catalina.bat jpda start
```
## Developing
All rest services must accept request messages in XML and JSON formats. To enable such feature each
web configuration should extend 
```java
@Configuration
@EnableWebMvc
class WebConfig extends DefaultWebMvcConfigurerAdapter {}
```
All request and response POJO must be annotated with
```java
@XmlRootElement
class SimpleRequest {}

@XmlRootElement
class SimpleResponse {}
```
## Building
```shell
svn checkout svn://svn.profitsoft/FASTTACK/branches/fasttack PROJECT_NAME
cd PROJECT_NAME
mvnw clean install -P cts_local
```
You need to specify which profile should to use:
* cts_local - local access to the ProfITsoft Nexus
* cts_remote - remote access to the ProfITsoft Nexus
* spring-boot-tomcat - build an executable war

### Run boot application
In IDEA create a new maven run configuration, then fill next parameters:
- Working directory - working directory of spring-boot module
- Command line - spring-boot:run -Dfasttack.home.dir=PATH_TO_FOLDER_WHERE_CONFIG_IS_PLACES
- Profiles - cts_local (cts_remote)

## Configuration
Each web module has it's own configuration files. To override default values you need to create
configuration files for each modules inside configuration folder of servlet container.
* Tomcat - ${catalina.home}/conf/MODULE_NAME-application.properties
* JBOSS EAP - ${jboss.home.dir}/standalone/configuration/MODULE_NAME-application.properties
* Embedded - ${fasttack.home.dir}/conf/MODULE_NAME-application.properties

In the future we can use some third party solutions to the centralized configuration management, such as[Consul](https://www.consul.io/). 
Default properties are places in classpath of each sub-project

## Logging
By default all sub-projects write logs to separate directories.  
This directories is container-specific:
- Tomcat - ${catalina.home}/logs/fastack/
- JBOSS EAP - ${jboss.home.dir}/standalone/log/fasttack
- Embedded - ${project.buildDir}/logs/fasttack

## Liquibase
All migration scripts are places in module ```liquibase```

## JMS brokers
Used JMS broker depends on the application deploying place.
####1. Apache Tomcat 8
The ActiveMQ message broker should be started.
Settings example in fasttack-core-application.properties file:
```shell
spring.activemq.broker-url=tcp://localhost:61616 #URL of the ActiveMQ broker.
spring.activemq.user=admin # Login user of the broker.
spring.activemq.password=admin # Login password of the broker.
spring.activemq.pool.enabled=true Whether a PooledConnectionFactory should be created instead of a regular ConnectionFactory.
spring.activemq.pool.max-connections=8 # Maximum number of pooled connections.
```

####2. JBoss EAP 7
The started ActiveMQ message broker are not required.
Default configuration for the messaging-activemq subsystem is included when starting the JBoss EAP server with the full or full-ha configuration.
Settings example in fasttack-core-application.properties file:
```shell
spring.artemis.mode=embedded # Artemis deployment mode, auto-detected by default.
spring.artemis.embedded.enabled=true # Enable embedded mode if the Artemis server APIs are available.
spring.artemis.embedded.persistent=true # Enable persistent store.
spring.artemis.embedded.data-directory=/artemis # Journal file directory. Not necessary if persistence is turned off.
```

Also Artemis support native mode to connect to a broker using the netty transport protocol.
Settings for native mode:
```shell
spring.artemis.mode=native # Artemis deployment mode.
spring.artemis.host= # Artemis broker host.
spring.artemis.port= # Artemis broker port.
spring.artemis.user= # Login user of the broker.
spring.artemis.password= # Login password of the broker.
```

## REST client

#### Timeouts
```shell
spring.client.rest.connectionTimeoutInMills = 10000 # Connection timeout in milliseconds
spring.client.rest.readTimeoutInMills = 15000 # Read timeout in milliseconds
```

#### Proxy
Proxy settings:
```shell
spring.client.rest.proxy.port = # Proxy port
spring.client.rest.proxy.host = # Proxy host
```

##Message Queuing
For example, we have information class**Human**that contain**name**and**age**field. 
####1. Create Producer 
```java
@RestController
public class HumanController {
    
    @GetMapping("/human")
    public void human(){
        Human human = new Human("Alex", 24);
        JmsEventMessage jmsEventMessage = new JmsEventMessage();
        jmsEventMessage.setContent(JsonUtil.toJson(human));
        jmsEventMessage.setMessageId("Alex");
        integrationBus.publish("queueMessage", new PersistJmsMessage().body(jmsEventMessage));    
    }    
}


```
####2. Create first consumer for add message in queue
* Create RouteBuilder
```java
@Component
public class HumanIdempotentRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jms:topic:queueMessage")
                .process("humanIdempotentProcessor");

    }
}
```
* Create IdempontentProcessor extends AbstractIdempotentCamelProcessor where set the duplicate message strategy and unique**processorName.** For example, use**CANCEL_PROCESSING** which doesn`t add duplicate queue. 
```java
@Component
public class HumanIdempotentProcessor extends AbstractIdempotentCamelProcessor {

    @Override
    public DuplicateDetectionStrategy setDuplicateDetectionStrategy() {
        return DuplicateDetectionStrategy.CANCEL_PROCESSING;
    }

    @Override
    public String setProcessorName() {
        return "humanIdempotentProcessor";
    }
}
```
####3. Create second consumer which read messages
* Create routeBuilder where set `consumer.processorName` and `consumer.delay`
```java
@Component
public class HumanConnectorReader extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jpa-jms:?consumer.processorName=HumanIdempotentProcessor")
                .process("humanProcessor");
    }
}
```
* Create processor extends AbstractReaderCamelProcessor which processes messages
```java
@Component
public class HumanProcessor extends AbstractReaderCamelProcessor {
    
    @Override
    public void process(JmsEventMessage eventMessage) throws Exception {
        eventMessage.getContent();
    }
}
```

####The frequency of reading and the number of retries set in `.properties` files
For example in `fasttack-core-application.properties`
```shell
camel.message.queue.consumer.delay=5000
camel.message.queue.replay.count=5
``` 

##Implementation of versioning in the project
- for Dev branch `fasttack-X.X.X-SNAPSHOT`
- for Release branch `fasttack-X.X.X`
- for Dev branch `fasttack`

    For the current version, see the MANUFEST.MF
    ```manifest
    Manifest-Version: 1.0
    Implementation-Title: release
    Major-Version: 1.1.648
    Build-Number: 2
    Implementation-Version: 1.1.648
    Archiver-Version: Plexus Archiver
    Built-By: jenkins
    Build-Time: 2018-09-14T17:22:43Z
    Build-OS: Linux
    Created-By: Apache Maven 3.3.9
    Build-Jdk: 1.8.0_181
    ```

Script for automatic version upgrade:
```bash
./version-up.sh 1.1.649-SNAPSHOT
```
or
```bash
./release-version-up.sh 1.1.649
```

##Implementation of profiles in the project
- -P dev
- -P dev-ih-sv
- -P **release**
- -P **release-ih-sv**
- -P **Alfa** (`prod`)
- -P **Alfa-TEST** (`prod`)
- -P **OTP** (`prod`)