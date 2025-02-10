package edu.bsu.cs;

import edu.bsu.cs.model.Revision;
import edu.bsu.cs.utils.RevisionFormatter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RevisionFormatterTest {
    @Test
    void formatWithRedirectTest() {
        Revision revision = new Revision("http://example.com");
        String formatted = RevisionFormatter.format(revision, 1);
        assertEquals("Redirected to: http://example.com", formatted);
    }
    @Test
    void formatWithUserAndTimestampTest() {
        Revision revision = new Revision("Alice", "2025-02-06", null, false);
        String formatted = RevisionFormatter.format(revision, 1);
        assertEquals("1  2025-02-06  Alice", formatted);
    }
    @Test
    void formatWithMissingPageTest() {
        Revision revision = new Revision(true);
        String formatted = RevisionFormatter.format(revision,1);
        assertEquals("No Wikipedia Page", formatted);
    }
}
