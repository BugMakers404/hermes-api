package org.bugmakers404.hermes.api.vicroad.service;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import java.time.OffsetDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.bugmakers404.hermes.api.vicroad.dao.LinkStatsDAO;
import org.bugmakers404.hermes.api.vicroad.entity.LinkStats;
import org.bugmakers404.hermes.api.vicroad.service.interfaces.SearchableLinkStatsService;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchableLinkStatsServiceTest {

  @Mock
  private LinkStatsDAO linkStatsDAO;

  private SearchableLinkStatsService searchableLinkStatsService;

  @BeforeMethod
  public void setup() {
    MockitoAnnotations.openMocks(this);
    searchableLinkStatsService = new SearchableLinkStatsServiceImpl(linkStatsDAO);
  }

  @Test
  public void testGetLinkStats() {
    Integer linkId = 1;
    OffsetDateTime timestamp = OffsetDateTime.now();

    LinkStats mockLinkStats = new LinkStats();
    // Populate mockLinkStats with test data

    when(linkStatsDAO.findByLinkIdAndTimestamp(eq(linkId), eq(timestamp)))
        .thenReturn(Optional.of(mockLinkStats));

    LinkStats result = searchableLinkStatsService.getLinkStats(linkId, timestamp);

    assertEquals(result, mockLinkStats);
  }

  @Test(expectedExceptions = NoSuchElementException.class)
  public void testGetLinkStatsThrowsException() {
    Integer linkId = 1;
    OffsetDateTime timestamp = OffsetDateTime.now();

    when(linkStatsDAO.findByLinkIdAndTimestamp(eq(linkId), eq(timestamp)))
        .thenReturn(Optional.empty());

    searchableLinkStatsService.getLinkStats(linkId, timestamp);
  }

  @Test
  public void testGetLatestLinkStats() {
    Integer linkId = 1;

    LinkStats mockLatestLinkStats = new LinkStats();
    // Populate mockLatestLinkStats with test data

    when(linkStatsDAO.findTopByLinkIdOrderByTimestampDesc(eq(linkId)))
        .thenReturn(Optional.of(mockLatestLinkStats));

    LinkStats result = searchableLinkStatsService.getLatestLinkStats(linkId);

    assertEquals(result, mockLatestLinkStats);
  }

  @Test(expectedExceptions = NoSuchElementException.class)
  public void testGetLatestLinkStatsThrowsException() {
    Integer linkId = 1;

    when(linkStatsDAO.findTopByLinkIdOrderByTimestampDesc(eq(linkId)))
        .thenReturn(Optional.empty());

    searchableLinkStatsService.getLatestLinkStats(linkId);
  }
}
