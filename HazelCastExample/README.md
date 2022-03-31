# Service Registry Example - Hazelcast

# Prerequisites
The code is only tested with:
 - Java 17  
 - Maven 3.8.4
 - Hazelcast 5.1
 - Docker 20.10.11

# Hazelcast
Hazelcast is a technology used for various distributed data types.

This repo contains an example for how to implement a service registry using Hazelcast's distributed MultiMap. The code contains an example of how to register and query a service.


## Running the Example

1. Get Hazelcast. Choose one of the options below.

    * The quickest way to get started is to use the [Docker Images](https://hub.docker.com/r/hazelcast/hazelcast) (go directly to step 2).
    * Otherwise, download and decompress the [ZIP](https://download.hazelcast.com/download.jsp?version=hazelcast-5.1&p=) or [TAR](https://download.hazelcast.com/download.jsp?version=hazelcast-5.1&type=tar&p=) distribution.
      
      ‌‌ 
1. To create a Hazelcast Member process run one of the following commands. Hazelcast default configuration choices mean that it will seek available ports and discover via multicast on ports 5701 - 5703.

    Start Hazelcast Member using:

    Docker
    ```sh
    docker run -p 5701:5701 hazelcast/hazelcast
    ```

    Windows
    ```sh
    bin/start.bat
    ```

    Linux
    ```sh
    bin/start.sh
    ```

1. Start the example program in the terminal or IDE of choice.

    **Within the terminal:**
    ```sh
    mvn clean compile exec:java -Dexec.mainClass="Main"
    ```

1. Watch the output from the example:
    ```sh
    127.0.0.1:8001
    127.0.0.1:8002
    ```
