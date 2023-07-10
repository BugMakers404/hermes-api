package org.bugmakers404.hermes.api.vicroad.dao;

import java.time.OffsetDateTime;
import java.util.List;
import org.bugmakers404.hermes.api.vicroad.entity.SiteStats;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SiteStatsDAO extends MongoRepository<SiteStats, String> {

  List<SiteStats> findAllBySiteId(Integer siteId);

  List<SiteStats> findAllByTimestamp(OffsetDateTime timestamp);

  SiteStats findBySiteIdAndTimestamp(Integer siteId, OffsetDateTime timestamp);

  SiteStats findTopBySiteIdOrderByTimestampDesc(Integer siteId);
}
