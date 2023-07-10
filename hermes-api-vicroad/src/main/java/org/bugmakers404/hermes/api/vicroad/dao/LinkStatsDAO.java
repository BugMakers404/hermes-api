package org.bugmakers404.hermes.api.vicroad.dao;

import java.time.OffsetDateTime;
import java.util.Optional;
import org.bugmakers404.hermes.api.vicroad.entity.LinkStats;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LinkStatsDAO extends MongoRepository<LinkStats, String> {
  Optional<LinkStats> findByLinkIdAndTimestamp(Integer linkId, OffsetDateTime timestamp);

  Optional<LinkStats> findTopByLinkIdOrderByTimestampDesc(Integer linkId);
}
