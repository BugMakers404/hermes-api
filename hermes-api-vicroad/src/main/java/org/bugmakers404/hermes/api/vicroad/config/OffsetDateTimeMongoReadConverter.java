package org.bugmakers404.hermes.api.vicroad.config;

import org.springframework.core.convert.converter.Converter;

import java.time.OffsetDateTime;

public class OffsetDateTimeMongoReadConverter implements Converter<String, OffsetDateTime> {

  @Override
  public OffsetDateTime convert(String source) {
    return OffsetDateTime.parse(source);
  }
}
