package org.bugmakers404.hermes.api.vicroad.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.Arrays;

@Configuration
public class MongoConfig {

  @Bean
  public MongoCustomConversions customConversions() {
    return new MongoCustomConversions(Arrays.asList(
        new OffsetDateTimeMongoWriteConverter(),
        new OffsetDateTimeMongoReadConverter()
    ));
  }
}
