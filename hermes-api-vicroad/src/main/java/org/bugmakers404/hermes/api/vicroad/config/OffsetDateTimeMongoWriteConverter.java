package org.bugmakers404.hermes.api.vicroad.config;

import org.springframework.core.convert.converter.Converter;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class OffsetDateTimeMongoWriteConverter implements Converter<OffsetDateTime, String> {

  @Override
  public String convert(OffsetDateTime source) {
    return source.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
  }
}
