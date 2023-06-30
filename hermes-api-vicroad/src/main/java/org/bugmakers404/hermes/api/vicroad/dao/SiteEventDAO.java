package org.bugmakers404.hermes.api.vicroad.dao;

import org.bugmakers404.hermes.api.vicroad.entity.site.SiteEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.OffsetDateTime;
import java.util.List;

public interface SiteEventDAO extends MongoRepository<SiteEvent, String> {

  List<SiteEvent> findAllBySiteId(Integer siteId);

  List<SiteEvent> findAllByTimestamp(OffsetDateTime timestamp);

  SiteEvent findBySiteIdAndTimestamp(Integer siteId, OffsetDateTime timestamp);

  SiteEvent findTopBySiteIdOrderByTimestampDesc(Integer siteId);
}
