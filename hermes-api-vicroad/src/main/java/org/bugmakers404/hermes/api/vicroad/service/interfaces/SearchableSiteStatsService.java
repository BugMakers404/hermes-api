package org.bugmakers404.hermes.api.vicroad.service.interfaces;


import java.time.OffsetDateTime;
import org.bugmakers404.hermes.api.vicroad.entity.SiteStats;

public interface SearchableSiteStatsService {

  SiteStats getSiteStats(Integer siteId, OffsetDateTime timestamp);

  SiteStats getLatestSiteStats(Integer siteId);

}
