package org.bugmakers404.hermes.api.vicroad.service.interfaces;


import org.bugmakers404.hermes.api.vicroad.entity.SiteInfo;

public interface SearchableSiteInfoService {

  SiteInfo getLatestSiteInfo(Integer siteId);

}
