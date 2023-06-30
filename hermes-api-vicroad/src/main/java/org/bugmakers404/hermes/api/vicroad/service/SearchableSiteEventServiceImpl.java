package org.bugmakers404.hermes.api.vicroad.service;

import java.time.OffsetDateTime;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bugmakers404.hermes.api.vicroad.dao.SiteEventDAO;
import org.bugmakers404.hermes.api.vicroad.entity.site.SiteEvent;
import org.bugmakers404.hermes.api.vicroad.service.interfaces.SearchableSiteEventService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class SearchableSiteEventServiceImpl implements SearchableSiteEventService {

  @NonNull
  private final SiteEventDAO siteEventDAO;

  @Override
  public SiteEvent getSiteEvent(Integer siteId, OffsetDateTime timestamp) {
    return null;
  }

  @Override
  public SiteEvent getLatestSiteEvent(Integer siteId) {
    return null;
  }
}
