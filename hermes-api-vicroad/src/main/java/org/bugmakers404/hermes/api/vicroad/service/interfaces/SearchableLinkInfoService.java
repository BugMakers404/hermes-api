package org.bugmakers404.hermes.api.vicroad.service.interfaces;


import java.util.List;
import org.bugmakers404.hermes.api.vicroad.dao.projection.LinkNameProjection;
import org.bugmakers404.hermes.api.vicroad.entity.LinkInfo;

public interface SearchableLinkInfoService {

  LinkInfo getLatestLinkInfo(Integer linkId);

  List<LinkNameProjection> getAllDistinctLinkNames();
}
