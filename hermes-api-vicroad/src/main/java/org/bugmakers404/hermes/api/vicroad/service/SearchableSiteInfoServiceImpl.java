package org.bugmakers404.hermes.api.vicroad.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bugmakers404.hermes.api.vicroad.dao.SiteInfoDAO;
import org.bugmakers404.hermes.api.vicroad.entity.site.SiteInfo;
import org.bugmakers404.hermes.api.vicroad.service.interfaces.SearchableSiteInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class SearchableSiteInfoServiceImpl implements SearchableSiteInfoService {

  @NonNull
  private final SiteInfoDAO siteInfoDAO;

  @Override
  public SiteInfo getLatestSiteInfo(Integer siteId) {
    return null;
  }
}
