package edu.bsu.cs;

import edu.bsu.cs.model.Revision;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RevisionTest {
    @Test
    public void userAndTimestampConstructorTest() {
        Revision revision = new Revision("Sinclair Stark", "2024-02-02T14:30:00Z");
        assertEquals("Sinclair Stark", revision.getUser());
        assertEquals("2024-02-02T14:30:00Z", revision.getTimestamp());
    }

    @Test
    public void redirectConstructorTest() {
        Revision revision = new Revision("RedirectPage");
        assertEquals("RedirectPage", revision.getRedirectText());
    }

    @Test
    public void missingPageConstructorTest() {
        Revision revision = new Revision(true);
        assertTrue(revision.getIsMissing());
    }
}
