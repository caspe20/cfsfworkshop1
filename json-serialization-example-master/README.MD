# JSON Serialization/Deserialization Example
This example shows how to serialize and deserialize Java objects to and from JSON using the Jackson library.

*Prerequisites:*  
- Java 17  
- Maven 3.8

## What is Serialization?
Serialization is the act of translating a data structure or object into a format which can be stored or transmitted and later reconstructed.  
For more information on serialization read here: [wikipedia.org/wiki/Serialization](https://en.wikipedia.org/wiki/Serialization) 

## JSON Object
The snippet below shows the JSON object created from the Java object in the source code. 
```json
{
    "timestampMs":1648647465593,
    "sender":"Flemming Henning",
    "content":"Hi, Flemming Henning is here."
}
```

## Source Code
The source code contains two Java files:
- Main.java
- Message.java

### Main.java
This file is the application entrypoint. 
The main method creates a Message object, 
serializes it to a JSON string, 
and deserializes it back to a Message object.

### Message.java
This file contains the Message class. 
A Message consists of a UNIX timestamp in milliseconds, 
the name of the sender, and the content of the message.  
