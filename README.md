# Spring Boot ELK Example

This repository contains a simple example demonstrating how to set up logging with Spring Boot applications and integrate them with the ELK (Elasticsearch, Logstash, Kibana) stack for centralized log management and analysis.

## Architecture Overview

In this setup, a Spring Boot application communicates with Logstash to send its logs. Logstash processes these logs and forwards them to Elasticsearch for storage and indexing. Kibana, running on a separate port, provides a user-friendly interface to visualize and analyze the logs stored in Elasticsearch.

-  <img src="https://github.com/srikanth-josyula/springboot-elk-stack-example/blob/main/docs/ELK1.png" width="750" height="400">

- **Spring Boot Application:** Generates logs which are collected by Logstash. This is facilitated by the `logstash.conf` file, which needs to be created. In this configuration file, specify the input file path and the output Elasticsearch host along with its port.
- **Logstash**: Collects logs from the Spring Boot application and sends them to Elasticsearch.
- **Elasticsearch**: Stores and indexes the logs received from Logstash.
- **Kibana**: Provides a web interface to interact with Elasticsearch, allowing users to visualize and analyze logs.

-  <img src="https://github.com/srikanth-josyula/springboot-elk-stack-example/blob/main/docs/ELK3.png" width="750" height="400">

## ELK Setup
Find Detailed Steps involved [Steps for ELK Setup](https://github.com/srikanth-josyula/springboot-elk-stack-example/blob/main/docs/Springboot%20%20ELKs%20Setup.pdf)

### Starting the Spring Boot Application Locally
1. Clone the repository containing the Spring Boot application to your local machine.
2. Do a mvn clean install
3. mvn spring-boot:run

### Install Elasticsearch
1. Visit [Elasticsearch Downloads](https://www.elastic.co/downloads/elasticsearch) and download the appropriate file for your system.
2. Extract the downloaded tar file and navigate to the Elasticsearch bin directory (e.g., `${location}/elasticsearch-8.12.2/bin`)
3. Run `./elasticsearch` to start Elasticsearch. Access `localhost:9200` in your browser to verify successful startup. If issues arise, consider disabling X-Pack security by running `./elasticsearch -E xpack.security.enabled=false`.
4. Note that starting from Elasticsearch 8, SSL/TLS is enabled by default for HTTP clients. If you encounter a warning message regarding server certificate trust, ensure your browser trusts the certificate or disable SSL in the `elasticsearch.yml` configuration.

### Install Logstash
1. Get Logstash from [Logstash Downloads](https://www.elastic.co/downloads/logstash).
2. Create a `logstash.conf` file specifying the location of your logs for Logstash to ingest.
3. In `logstash.conf`, define the input source (e.g., file location) and the output destination (your Elasticsearch host).
4. Launch Logstash by running `./logstash -f /path/to/logstash.conf`. Access Logstash console logs via `http://localhost:9600/`.

### Install Kibana
1. Download Kibana from [Kibana Downloads](https://www.elastic.co/downloads/kibana).
2. Extract the tar file and navigate to the Kibana config directory. Open the `.yml` file and enable the Elasticsearch host to ensure Kibana can communicate with Elasticsearch.
3. Navigate to the Kibana bin directory and start Kibana with `kibana.sh`. Access Kibana at `http://localhost:5601/`.

## View Logs in Kibana
1. Visit `http://localhost:9200/_cat` to view all available categories. Navigate to `http://localhost:9200/_cat/indices` to see the internally created indexes.
2. Open Kibana and navigate to Analytics. Create a data view by selecting index patterns. Upon saving, access the logs via the Discover tab, where you can view logs and related details in JSON format.



