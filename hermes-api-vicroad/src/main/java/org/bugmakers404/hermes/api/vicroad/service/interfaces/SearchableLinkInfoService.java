package org.bugmakers404.hermes.api.vicroad.service.interfaces;


import org.bugmakers404.hermes.api.vicroad.entity.link.LinkInfo;

public interface SearchableLinkInfoService {

  LinkInfo getLatestLinkInfo(Integer linkId);
}
