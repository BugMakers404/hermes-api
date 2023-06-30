package org.bugmakers404.hermes.api.vicroad.dao;

import java.util.Optional;
import org.bugmakers404.hermes.api.vicroad.entity.link.LinkInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LinkInfoDAO extends MongoRepository<LinkInfo, String> {
  Optional<LinkInfo> findTopByLinkIdOrderByTimestampDesc(Integer linkId);
}
