package org.bugmakers404.hermes.api.vicroad.service;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import java.time.OffsetDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.bugmakers404.hermes.api.vicroad.dao.LinkEventDAO;
import org.bugmakers404.hermes.api.vicroad.entity.link.LinkEvent;
import org.bugmakers404.hermes.api.vicroad.service.interfaces.SearchableLinkEventService;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchableLinkEventServiceTest {
  @Mock
  private LinkEventDAO linkEventDAO;

  private SearchableLinkEventService searchableLinkEventService;

  @BeforeMethod
  public void setup() {
    MockitoAnnotations.openMocks(this);
    searchableLinkEventService = new SearchableLinkEventServiceImpl(linkEventDAO);
  }

  @Test
  public void testGetLinkEvent() {
    Integer linkId = 1;
    OffsetDateTime timestamp = OffsetDateTime.now();

    LinkEvent mockLinkEvent = new LinkEvent();
    // Populate mockLinkEvent with test data

    when(linkEventDAO.findByLinkIdAndTimestamp(eq(linkId), eq(timestamp)))
        .thenReturn(Optional.of(mockLinkEvent));

    LinkEvent result = searchableLinkEventService.getLinkEvent(linkId, timestamp);

    assertEquals(result, mockLinkEvent);
  }

  @Test(expectedExceptions = NoSuchElementException.class)
  public void testGetLinkEventThrowsException() {
    Integer linkId = 1;
    OffsetDateTime timestamp = OffsetDateTime.now();

    when(linkEventDAO.findByLinkIdAndTimestamp(eq(linkId), eq(timestamp)))
        .thenReturn(Optional.empty());

    searchableLinkEventService.getLinkEvent(linkId, timestamp);
  }

  @Test
  public void testGetLatestLinkEvent() {
    Integer linkId = 1;

    LinkEvent mockLatestLinkEvent = new LinkEvent();
    // Populate mockLatestLinkEvent with test data

    when(linkEventDAO.findTopByLinkIdOrderByTimestampDesc(eq(linkId)))
        .thenReturn(Optional.of(mockLatestLinkEvent));

    LinkEvent result = searchableLinkEventService.getLatestLinkEvent(linkId);

    assertEquals(result, mockLatestLinkEvent);
  }

  @Test(expectedExceptions = NoSuchElementException.class)
  public void testGetLatestLinkEventThrowsException() {
    Integer linkId = 1;

    when(linkEventDAO.findTopByLinkIdOrderByTimestampDesc(eq(linkId)))
        .thenReturn(Optional.empty());

    searchableLinkEventService.getLatestLinkEvent(linkId);
  }
}
