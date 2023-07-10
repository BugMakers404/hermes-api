package org.bugmakers404.hermes.api.vicroad.service.interfaces;


import java.time.OffsetDateTime;
import org.bugmakers404.hermes.api.vicroad.entity.LinkStats;

public interface SearchableLinkStatsService {
  LinkStats getLinkStats(Integer linkId, OffsetDateTime timestamp);

  LinkStats getLatestLinkStats(Integer linkId);
}
