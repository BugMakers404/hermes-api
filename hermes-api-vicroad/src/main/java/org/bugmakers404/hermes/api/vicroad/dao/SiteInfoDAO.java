package org.bugmakers404.hermes.api.vicroad.dao;

import org.bugmakers404.hermes.api.vicroad.entity.site.SiteInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SiteInfoDAO extends MongoRepository<SiteInfo, String> {

  List<SiteInfo> findAllBySiteId(Integer linkId);

  SiteInfo findTopBySiteIdOrderByTimestampDesc(Integer siteId);

}
