# jaxrs-speedtest
App for performance comparison of jax-rs 2.0 implementations based on 
http://dummywarhead.blogspot.cz/2014/12/performance-comparison-of-jax-rs-20.html and 
https://github.com/DummyWarhead/jaxrs-speedtest

Building
-------------------
> mvn clean package

Version customization
-------------------
Chech and modify properties section of webapps/pom.xml or define properties from command line
> mvn clean package -Djersey.version=2.22

Where are deployable apps
-------------------
* webapps/jaxrs-jersey/target/jaxrs-jersey.war
* webapps/jaxrs-resteasy/target/jaxrs-resteasy.war
* webapps/jaxrs-cxf/target/jaxrs-cxf.war

Deploying
-------------------
* Get and unzip Jetty container from http://download.eclipse.org/jetty/ for example jetty-distribution-9.3.7.v20160115.zip
* Copy deployable apps into jetty-distribution-9.3.7.v20160115/webapps
* Open jetty-distribution-9.3.7.v20160115/bin/jetty.sh
* Add JAVA_OPTIONS="-Xms1303m -Xmx1303m -XX:MetaspaceSize=96M -XX:MaxMetaspaceSize=256m -Djava.net.preferIPv4Stack=true -server" around line 48

> jetty-distribution-9.3.7.v20160115/bin/jetty.sh start

Testing with Siege tool
-----------------------

Edit ~/.siege/siege.conf and set verbose to false and connection to keep-alive.

CXF:
> siege "http://127.0.0.1:8080/jaxrs-cxf/s/r/hello/advanced/?firstName=AA&lastName=BB" -d0.0001 -r20000 -c10

> siege "http://127.0.0.1:8080/jaxrs-cxf/s/r/hello/advanced/?firstName=AA&lastName=BB" -d0.0001 -r200000 -c50

RESTEasy:
> siege "http://127.0.0.1:8080/jaxrs-resteasy/hello/advanced/?firstName=AA&lastName=BB" -d0.0001 -r20000 -c10

> siege "http://127.0.0.1:8080/jaxrs-resteasy/hello/advanced/?firstName=AA&lastName=BB" -d0.0001 -r200000 -c50

Jersey:
> siege "http://127.0.0.1:8080/jaxrs-jersey/hello/advanced/?firstName=AA&lastName=BB" -d0.0001 -r20000 -c10

> siege "http://127.0.0.1:8080/jaxrs-jersey/hello/advanced/?firstName=AA&lastName=BB" -d0.0001 -r200000 -c50


Testing with Apache Bench tool
-------------------
CXF:
> ab -n 100000 -c 5 "http://10.20.30.40:8080/jaxrs-cxf/s/r/hello/advanced/?firstName=AA&lastName=BB"

> ab -n 4500000 -c 150 -g cxf.data "http://10.20.30.40:8080/jaxrs-cxf/s/r/hello/advanced/?firstName=AA&lastName=BB" | tee cxf.log

RESTEasy:
> ab -n 100000 -c 5 "http://10.20.30.40:8080/jaxrs-resteasy/hello/advanced/?firstName=AA&lastName=BB"

> ab -n 4500000 -c 150 -g resteasy.data "http://10.20.30.40:8080/jaxrs-resteasy/hello/advanced/?firstName=AA&lastName=BB" | tee resteasy.log

Jersey:
> ab -n 100000 -c 5 "http://10.20.30.40:8080/jaxrs-jersey/hello/advanced/?firstName=AA&lastName=BB"

> ab -n 4500000 -c 150 -g jersey.data "http://10.20.30.40:8080/jaxrs-jersey/hello/advanced/?firstName=AA&lastName=BB" | tee jersey.log

Consider option -k to enable keep-alive on Apache Bench tool side (but note that currently Apache CXF doesn't properly work with Keep-Alive on HTTP 1.0, which is what ab use)

For results visualization you can use https://github.com/rsvoboda/ab-results-graphs
