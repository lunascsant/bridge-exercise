package com.ifood;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TelevisionTest {
    private Television television;

    @BeforeEach
    void setUp() {
        television = new Television();
    }

    @Test
    void shouldInitializeWithDefaultValues() {
        assertFalse(television.isEnabled());
        assertEquals(30, television.getVolume());
        assertEquals(1, television.getChannel());
    }

    @Test
    void shouldEnableDevice() {
        television.enable();
        assertTrue(television.isEnabled());
    }

    @Test
    void shouldDisableDevice() {
        television.enable();
        television.disable();
        assertFalse(television.isEnabled());
    }

    @Test
    void shouldSetValidVolume() {
        television.setVolume(50);
        assertEquals(50, television.getVolume());
    }

    @Test
    void shouldLimitVolumeToMaximum() {
        television.setVolume(150);
        assertEquals(100, television.getVolume());
    }

    @Test
    void shouldLimitVolumeToMinimum() {
        television.setVolume(-10);
        assertEquals(0, television.getVolume());
    }

    @Test
    void shouldSetChannel() {
        television.setChannel(5);
        assertEquals(5, television.getChannel());
    }

    @Test
    void shouldPrintStatus() {
        assertDoesNotThrow(() -> television.printStatus());
    }
}
