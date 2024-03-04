# Spring Boot ELK Example

This repository contains a simple example demonstrating how to set up logging with Spring Boot applications and integrate them with the ELK (Elasticsearch, Logstash, Kibana) stack for centralized log management and analysis.

## Architecture Overview

In this setup, a Spring Boot application communicates with Logstash to send its logs. Logstash processes these logs and forwards them to Elasticsearch for storage and indexing. Kibana, running on a separate port, provides a user-friendly interface to visualize and analyze the logs stored in Elasticsearch.

- **Spring Boot Application:** Generates logs which are collected by Logstash. This is facilitated by the `logstash.conf` file, which needs to be created. In this configuration file, specify the input file path and the output Elasticsearch host along with its port.
- **Logstash**: Collects logs from the Spring Boot application and sends them to Elasticsearch.
- **Elasticsearch**: Stores and indexes the logs received from Logstash.
- **Kibana**: Provides a web interface to interact with Elasticsearch, allowing users to visualize and analyze logs.
