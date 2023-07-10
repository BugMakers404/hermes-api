package org.bugmakers404.hermes.api.vicroad.dao;

import java.util.List;
import java.util.Optional;
import org.bugmakers404.hermes.api.vicroad.dao.projection.LinkNameProjection;
import org.bugmakers404.hermes.api.vicroad.entity.LinkInfo;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LinkInfoDAO extends MongoRepository<LinkInfo, String> {
  Optional<LinkInfo> findTopByLinkIdOrderByTimestampDesc(Integer linkId);

  @Aggregation(pipeline = {
      "{ $group: { _id: '$name', linkId: { $first: '$linkId' }, timestamp: { $first: '$timestamp' } } }",
      "{ $project: { _id: 0, name: '$_id', linkId: 1, timestamp: 1 } }"
  })
  List<LinkNameProjection> findDistinctByName();
}
