package org.bugmakers404.hermes.api.vicroad.dao.projection;

import java.time.OffsetDateTime;
import lombok.Data;

@Data
public class LinkNameProjection {

  Integer linkId;

  OffsetDateTime timestamp;

  String name;
}

