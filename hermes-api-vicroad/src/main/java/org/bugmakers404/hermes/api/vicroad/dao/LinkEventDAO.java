package org.bugmakers404.hermes.api.vicroad.dao;

import java.time.OffsetDateTime;
import java.util.Optional;
import org.bugmakers404.hermes.api.vicroad.entity.link.LinkEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LinkEventDAO extends MongoRepository<LinkEvent, String> {
  Optional<LinkEvent> findByLinkIdAndTimestamp(Integer linkId, OffsetDateTime timestamp);

  Optional<LinkEvent> findTopByLinkIdOrderByTimestampDesc(Integer linkId);
}
