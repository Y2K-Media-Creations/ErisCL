package sh.miles.eriscl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.bukkit.plugin.Plugin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import lombok.Getter;

@SuppressWarnings("java:S2187")
public class BasicTest {

    @Getter
    Plugin plugin;
    @Getter
    ServerMock server;

    @BeforeEach
    public void setUp() {
        MockBukkit.mock();
        plugin = MockBukkit.createMockPlugin();
    }

    @AfterEach
    public void teardown() {
        MockBukkit.unmock();
    }

    @Test
    @SuppressWarnings("all")
    public void testTest() {
        assertEquals((byte) 1, (byte) 1);
    }

}
