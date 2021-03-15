# Proxy Design Pattern

Proxy is a structural design pattern that lets you provide a substitute or placeholder for another object. A proxy 
controls the access to the original object, allowing to perform something either before or after the request gets through 
to the original object.

Proxies delegate all of the real work to some other object. Each proxy method should, in the end,
refer to a service object unless the proxy is a subclass of a service.

For heavy Java object like JDBC connection, or a SessionFactory that requires some initial configuration, we only want
them to be initialized on demand. And once they are initialized, we want to reuse them for all calls.

![Alt text](./proxy.jpg?raw=true "title")


## When to Use ##
 - *When we want a simplified version of a complex or heavy object*.
   In this case, we may represent it with a skeleton object which loads the original object on demand, also called as
   lazy initialization. This is known as the Virtual Proxy.
   
 - *When the original object is present in different address space, and we want to represent it locally*. We can create
   a proxy which does all the necessary boilerplate stuff like creating and maintaining the connection, encoding,
   decoding, etc., while the client accesses it as it was present in their local address space. 
   This is called the Remote Proxy.
   
 - *When we want to add a layer of security to the original underlying object to provide controlled access based on 
   access rights of the client*. This is called Protection Proxy.

Reference: 
- [The Proxy Pattern in Java](https://www.baeldung.com/java-proxy-pattern#proxy-pattern-example)
- [Proxy in Java](https://refactoring.guru/design-patterns/proxy/java/example#:~:text=Proxy%20is%20a%20structural%20design,object%20used%20by%20a%20client.&text=The%20proxy%20object%20has%20the,when%20passed%20to%20a%20client.)
- [Proxy](https://refactoring.guru/design-patterns/proxy)