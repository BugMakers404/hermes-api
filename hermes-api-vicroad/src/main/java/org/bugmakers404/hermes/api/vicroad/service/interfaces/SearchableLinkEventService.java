package org.bugmakers404.hermes.api.vicroad.service.interfaces;


import java.time.OffsetDateTime;
import org.bugmakers404.hermes.api.vicroad.entity.link.LinkEvent;

public interface SearchableLinkEventService {
  LinkEvent getLinkEvent(Integer linkId, OffsetDateTime timestamp);

  LinkEvent getLatestLinkEvent(Integer linkId);
}
