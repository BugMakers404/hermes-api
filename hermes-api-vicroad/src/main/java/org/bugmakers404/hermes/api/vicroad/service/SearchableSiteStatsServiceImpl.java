package org.bugmakers404.hermes.api.vicroad.service;

import java.time.OffsetDateTime;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bugmakers404.hermes.api.vicroad.dao.SiteStatsDAO;
import org.bugmakers404.hermes.api.vicroad.entity.SiteStats;
import org.bugmakers404.hermes.api.vicroad.service.interfaces.SearchableSiteStatsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class SearchableSiteStatsServiceImpl implements SearchableSiteStatsService {

  @NonNull
  private final SiteStatsDAO siteStatsDAO;

  @Override
  public SiteStats getSiteStats(Integer siteId, OffsetDateTime timestamp) {
    return null;
  }

  @Override
  public SiteStats getLatestSiteStats(Integer siteId) {
    return null;
  }
}
