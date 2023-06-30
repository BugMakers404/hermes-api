package org.bugmakers404.hermes.api.vicroad.service.interfaces;


import java.time.OffsetDateTime;
import org.bugmakers404.hermes.api.vicroad.entity.site.SiteEvent;

public interface SearchableSiteEventService {

  SiteEvent getSiteEvent(Integer siteId, OffsetDateTime timestamp);

  SiteEvent getLatestSiteEvent(Integer siteId);

}
